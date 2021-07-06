package model;

import java.sql.CallableStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class kadrovskaModel 
{
	private JTable tableRadnik = new JTable();
	private JTable tableIstorija = new JTable();
	private CallableStatement procedura = null;
	private DefaultTableModel dataModel = null;
	private DefaultTableModel dataIstorija = null;
	public DefaultTableModel dataSmjene = null;
	public DefaultTableModel dataRadnaMjesta = null;
	private  Object [] smjene;
	private  Object [] radnaMjesta;
	private tableModel tableModel = new tableModel();
	
	public void loadTable(String sql, int model)
	{
		if(model==0)
		{
		tableModel.loadTable(sql);
		dataModel = tableModel.getTableModel();
		tableRadnik.setModel(dataModel);
		}
		else
		{
		tableModel.loadTable(sql);
		dataIstorija = tableModel.getTableModel();
		tableIstorija.setModel(dataIstorija);
		}
	}
	
	public JTable getTable()
	{
		return tableRadnik;
	}
	
	public JTable getTableIstorija()
	{
		return tableIstorija;
	}
	
	public DefaultTableModel getDataModel()
	{
		return dataModel;
	}

	public void loadSmjene(String sql)
	{
		tableModel.loadTableWithXML(sql, "Smjena");
		
		dataSmjene = tableModel.getTableModel();
		int row_numbers = dataSmjene.getRowCount();
		smjene = new Object[row_numbers+1];
		smjene[0]="";
		for(int i=1; i<row_numbers+1; i++)
		{
			smjene[i]=dataSmjene.getValueAt(i-1, 5);
		}
	}
	
	public void loadRadnaMjesta(String sql)
	{
		 tableModel.loadTableWithXML(sql, "Radno mjesto");
		 
	     dataRadnaMjesta = tableModel.getTableModel();
	     int row_numbers = dataRadnaMjesta.getRowCount();
	     radnaMjesta = new Object[row_numbers+1];
	     radnaMjesta[0]="";
		
		 for(int i=1; i<row_numbers+1; i++)
		 {
			radnaMjesta[i]=dataRadnaMjesta.getValueAt(i-1, 1);
		 }
	}
	
	public  Object [] getObjectSmjene()
	{
		return smjene;
	}
	
	public Object[] getObjectRadnaMjesta()
	{
		return radnaMjesta;
	}
	
	public DefaultTableModel getModelSmjene()
	{
		return dataSmjene;
	}
	
	public DefaultTableModel getModelRadMje()
	{
		return dataRadnaMjesta;
	}

	public int getIndexSmjena(String string)
	{
		for(int i=0; i< smjene.length; i++)
		{
			if(string.equals(smjene[i].toString()))
			{
				return i;
			}
		}
		return 0;
	}
	
	public int getIndexRadMje(String string)
	{
		for(int i=0; i< radnaMjesta.length; i++)
		{
			if(string.equals(radnaMjesta[i].toString()))
			{
				return i;
			}
		}
		return 0;
	}

	public void updateRow(String sql)
	{
		tableModel.updateRow(sql);
	}
}
