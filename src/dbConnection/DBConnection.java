package dbConnection;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.XMLParserModel;


 // Abstraktna klasa za kreiranje i implementiranje osnovnih podataka neophodnih za konekciju na bazu.

public class DBConnection
{
	protected static Connection connection = null;
	
	private String url = null;
	private String address = null;
	private String driver = null;
	private String user = null;
	private String password = null;
	private int port;
	private String type = null;;	
	private String dbName = null; 
	
	String tabela;	
	
	private static DBConnection instanca;
    
	// Metoda za kreiranje instance klase DBConnection
	
    public static DBConnection getInstance()
    {
    	if(instanca==null)
    	{
    		instanca = new DBConnection();
    	}
    	return instanca;
    }

	// Zatvaranje konekcije

	public void closeConnection()
	{
		if (connection == null)
		{
			return;
		}
		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			ErrorHandlerFunction(null, e.getMessage());
		}
	}
	
	// Metoda za dohvatanje parametara konekcije iz xml fajla
	
	public boolean getConnectionParameters(String putanja)
	{
		try
    	{	
    	    DocumentBuilderFactory databaseFactory = DocumentBuilderFactory.newInstance();
    	    DocumentBuilder documentBuilder = databaseFactory.newDocumentBuilder();
    	    Document document = documentBuilder.parse(putanja);
    	    
    	    NodeList param = document.getDocumentElement().getElementsByTagName("connection");
    	    
    	  
    	  
    	      
    	    
    	    for (int i = 0; i < param.getLength(); i++)
    	    {
	    		this.address = ((Element) param.item(i)).getAttribute("address");
	    		this.type = ((Element) param.item(i)).getAttribute("database_type");
	    		this.dbName = ((Element) param.item(i)).getAttribute("database");
	    		this.user = ((Element) param.item(i)).getAttribute("username");
	    		this.password = ((Element) param.item(i)).getAttribute("password");
	    		String portNum = ((Element) param.item(i)).getAttribute("port");
	    		
	    		try
	    		{
	    			port = Integer.parseInt(portNum);
	    		} 
	    		catch(Exception e) 
	    		{
	    			port = 1433;
	    		}
    	    }
    	    	
    	} 
    	catch (Exception e)
    	{
    		JOptionPane.showMessageDialog(null, "Greška: " + e.getMessage(), "Error !", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}

    	return true;
	}
	
	// Metoda uspostavlja konekciju sa bazom podataka
	
	public Connection getConnection()
	{
		url = "jdbc:sqlserver://" +  address + ":" + port + ";databaseName=" + dbName + ";user=" + user + ";password=" + password;
   	
		Connection connection = null;
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Greška: " + e.getMessage(), "Error !", JOptionPane.ERROR_MESSAGE);
		}
		
		return connection;
	}
	
	// Metoda vraca boolean vrijednost koja govori o tome da li je konekcija otvorena
	
	public Boolean isConnectionOpen()
	{
		if (connection != null)
		{
			return true;
		}

		return false;
	}
	
	// Metoda za pribavljanje postojece konekcije (ako postoji)
	
	public Connection getOpenedConnection()
	{
		if (connection != null)
		{
			return connection;
		}

		return null;
	}
	
	
	/**
	 * ErrorHandlerFunction, funkcija je koja odgovara na sve greske koje nastanu u sistemu konekcije na bazu.
	 * Ova funkcija ima dva parametra:
	 * 
	 * @param comp Komponenta koja je roditeljska komponenta za prikaz obavijesti o gresci
	 * @param errorMessage Poruka koju ce prikazati dijalog za obavijest
	 */
	protected void ErrorHandlerFunction(Component comp, String errorMessage)
	{
		JOptionPane.showMessageDialog(comp, errorMessage, "Error", 0);
		
		System.out.println();
	}
}