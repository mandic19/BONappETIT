package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import dbConnection.DBConnection;


public class MenadzerZakupSaleModel {


	private DefaultTableModel dataModelSala = null;
	private DefaultTableModel dataModelZakupa = null;
	private DefaultTableModel dataModelTipZakupa = null;
	CallableStatement procedura = null;
	Connection connection = null;
	DBConnection dbCon;
	tableModel table = new tableModel();

	
	public void procitajTabeluSala() {
		
	try 
		{
			String sql = "SELECT * FROM sala where oj_oznaka='1' and tps_oznaka='RE' and ps_jib='4201790070003' and dr_oznaka ='BIH'";
			table.loadTableWithXML(sql, "Sala");
			dataModelSala = table.getTableModel();
		} 
		catch (Exception ex) 
		{
			JOptionPane.showMessageDialog(null, "GreÅ¡ka prilikom Ä�itanja podataka iz tabele Sala ! " + ex.getMessage(), "Error !", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void procitajTabeluZakup(String SalaOznaka, String OrganizacionaJedinica, String TipPoslovnogSistema, String KljucPoslovnogSistema) 
	{
		
		try
		{
		String sql = "SELECT * from zakup where sl_oznaka='"+SalaOznaka+"' and oj_oznaka='"+OrganizacionaJedinica+"' and tps_oznaka='"+TipPoslovnogSistema+"' and ps_jib='"+KljucPoslovnogSistema+"'";
		table.loadTableWithXML(sql, "Zakup");
		
		dataModelZakupa = table.getTableModel();
		} 
	
		catch (Exception ex) 
		{
		JOptionPane.showMessageDialog(null, "GreÅ¡ka prilikom Ä�itanja podataka iz tabele Zakup ! " + ex.getMessage(), "Error !", JOptionPane.ERROR_MESSAGE);
		}	
	
	}
	
	public void insertRow(String TipZakupa,String SalaOznaka,String BrojMjesta,String DatumPocetka,String DatumZavrsetka,float Cijena,String ImeZakupca,String PrezimeZakupca,String Adresa,String Telefon)
	{

		String sql = "{ call " + "unesi_novi_zakup" + "('"+TipZakupa+"','"+SalaOznaka+"','"+"RE"+"','"+"4201790070003"+"'";
		sql+=",'"+"1"+"','"+"BIH"+"','"+BrojMjesta+"','"+DatumPocetka+"','"+DatumZavrsetka+"','"+Cijena+"','"+ImeZakupca+"','"+PrezimeZakupca+"','"+Adresa+"','"+Telefon+"') }";
		table.updateRow(sql);
	
	}
	
	public void procitajTabeluTipZakupa() 
	{
		String sql = "SELECT * FROM tip_zakupa";
		table.loadTableWithXML(sql,"Tip zakupa");
		dataModelTipZakupa = table.getTableModel();
				
	}

	public DefaultTableModel getTipZakupaModel() {
		
		return dataModelTipZakupa;
	}
	
	public DefaultTableModel getDataModelSala() {
		
		return dataModelSala;
	}
	
	public DefaultTableModel getDataModelZakupa() {
			
		return dataModelZakupa;
	}
	
}
