package model;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLParserModel 
{
	private String tabela;
	private Vector<String> columnNames;
	private int numColumns=0;

	public void setTableData(String tableName)
	{
		 try {

 	    	
 	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 	    	Document doc = dBuilder.parse("xml/xml.xml");
 	    			

 	    	doc.getDocumentElement().normalize();

 	    	
 	    			
 	    	NodeList nList = doc.getElementsByTagName("column");
 	    	numColumns=0;
 	    	columnNames = new Vector<>();
 	    	for (int temp = 0; temp < nList.getLength(); temp++) {

 	    		org.w3c.dom.Node nNode = nList.item(temp);
 	    		org.w3c.dom.Node nParent = nNode.getParentNode();
 	    		
 	    		
 	    		if (nParent.getNodeType() == Node.ELEMENT_NODE) 
 	    		{
 	    			Element eElement = (Element) nParent;
 	    			tabela= eElement.getAttribute("name");
 	    			
 	    		}

 	    		if (nNode.getNodeType() == Node.ELEMENT_NODE && tabela.equals(tableName)) {
 	    			
 	    			Element eElement = (Element) nNode;

 	    			columnNames.add(eElement.getAttribute("name"));
 	    			numColumns++;
 	    		}
 	    	}
 	        } catch (Exception e) {
 	    	e.printStackTrace();
 	        }
	}
	
	public int getNumberOfColumns()
	{
		return numColumns;
	}
	public Vector<String> getColumnNames()
	{
		return columnNames;
	}
}
