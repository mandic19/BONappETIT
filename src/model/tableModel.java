package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import dbConnection.DBConnection;

public class tableModel 
{

	private DefaultTableModel tableModel  = null;
	private CallableStatement procedura = null;
	private Connection connection = null;
	private XMLParserModel parser = new XMLParserModel();
	private DBConnection dbCon;
	
	public tableModel()
	{
		this.dbCon = dbCon.getInstance();
	}
	
	public void loadTable(String sql)
	{
		try {
			if(dbCon.isConnectionOpen())
			{
				connection=dbCon.getOpenedConnection();
			}
			else
			{
				if(dbCon.getConnectionParameters("xml\\xml.xml"))
				{
				connection=dbCon.getConnection();
				}
			}
			
			ResultSet rs = null;
			procedura = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
			rs = procedura.executeQuery();
			dbCon.closeConnection();
			ResultSetMetaData meta = rs.getMetaData();
		      
			int numberOfColumns = meta.getColumnCount();
			String[] naziviKolona = new String[numberOfColumns];
			for(int i=1; i<numberOfColumns+1; i++)
			{
				naziviKolona[i-1] = meta.getColumnName(i);
			}
			
			tableModel = new DefaultTableModel(naziviKolona, 0);
			
		      while (rs.next())
		        {
		            Object [] rowData = new Object[numberOfColumns];
		            for (int i = 0; i < numberOfColumns; i++)
		            {
		            		rowData[i] = rs.getObject(i+1);
		            }
		            tableModel.addRow(rowData);
		        }
			}

		catch (SQLException e1) 
		{
			JOptionPane.showMessageDialog(null, "Greška: " + e1.getMessage(), "Error !", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void loadTableWithXML(String sql, String imeTabele)
	{
		try {
			
			if(dbCon.isConnectionOpen())
			{
				connection=dbCon.getOpenedConnection();
			}
			else
			{
				if(dbCon.getConnectionParameters("xml\\xml.xml"))
				{
				connection=dbCon.getConnection();
				}
			}
			
			parser.setTableData(imeTabele);					// Ime kao u modelu tipa "Asortiman artikala" ne CODE
			Vector<String> naziviKolona;
			naziviKolona=parser.getColumnNames();
			
			ResultSet rs = null;
			procedura = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
			rs = procedura.executeQuery();
			dbCon.closeConnection();
			
		      
			int numberOfColumns = parser.getNumberOfColumns();
			
			tableModel = new DefaultTableModel(naziviKolona, 0);
			
		      while (rs.next())
		        {
		            Object [] rowData = new Object[numberOfColumns];
		            for (int i = 0; i < numberOfColumns; i++)
		            {
		            		rowData[i] = rs.getObject(i+1);
		            }
		            tableModel.addRow(rowData);
		        }
			}

		catch (SQLException e1) 
		{
			JOptionPane.showMessageDialog(null, "Greška: " + e1.getMessage(), "Error !", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateRow(String sql)
	{
		try {

			if(dbCon.isConnectionOpen())
			{
				connection=dbCon.getOpenedConnection();
			}
			else
			{
				if(dbCon.getConnectionParameters("xml\\xml.xml"))
				{
				connection=dbCon.getConnection();
				}
			}

			procedura = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
			procedura.execute();
			
		    JOptionPane.showMessageDialog(null, "Uspješno ste izvrsili izmjene ! ", "Izmjenjeno !", JOptionPane.INFORMATION_MESSAGE);
		    dbCon.closeConnection();

		}
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Greška: "+e.getMessage(), "Greška !", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateRowNoMessage(String sql)
	{
		try {

			if(dbCon.isConnectionOpen())
			{
				connection=dbCon.getOpenedConnection();
			}
			else
			{
				if(dbCon.getConnectionParameters("xml\\xml.xml"))
				{
				connection=dbCon.getConnection();
				}
			}

			procedura = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
			procedura.execute();
			
		    //JOptionPane.showMessageDialog(null, "Uspješno ste izvrsili izmjene ! ", "Izmjenjeno !", JOptionPane.INFORMATION_MESSAGE);
		    dbCon.closeConnection();

		}
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "Greška: "+e.getMessage(), "Greška !", JOptionPane.ERROR_MESSAGE);
		}
	}

	public DefaultTableModel getTableModel()
	{
		return tableModel;
	}

}
