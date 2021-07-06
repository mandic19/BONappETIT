package model;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class loginModel 
{
	private DefaultTableModel modelOrgJed = null;
	private tableModel tableModel = new tableModel();
	
	public static int OznakaOrgJed;
	public static String JIB;
	public static String OznakaDrz ;
	public static String TipPosSisOznaka;
	public static String Grad;
	public static String NazivRestorana;
	public static String AdresaRestorana;
	public static String TelefonRestorana;
	public static String EmailRestorana;
	public static String KorisnickoIme;
	public static String TipNaloga;
	public static String NazivTipa;
	
	public void loadOrgJed(String sql)
	{
		tableModel.loadTableWithXML(sql, "Organizaciona jedinica");
		modelOrgJed = tableModel.getTableModel();
	}
	
	public String[] getOrgJedNativ()
	{
		String[] objects = new String[modelOrgJed.getRowCount()];
		for(int i=0; i<modelOrgJed.getRowCount(); i++)
		{
			objects[i]= modelOrgJed.getValueAt(i, 5).toString();
		}
		return objects;
	}
	public void setParametreOrgJed(int indexSelektovane)
	{
		OznakaOrgJed = Integer.parseInt(modelOrgJed.getValueAt(indexSelektovane, 0).toString());
		JIB = modelOrgJed.getValueAt(indexSelektovane,1).toString();
		TipPosSisOznaka = modelOrgJed.getValueAt(indexSelektovane, 2).toString();
		OznakaDrz = modelOrgJed.getValueAt(indexSelektovane, 3).toString();
		Grad = modelOrgJed.getValueAt(indexSelektovane, 3).toString();
		NazivRestorana = modelOrgJed.getValueAt(indexSelektovane, 5).toString();
		AdresaRestorana = modelOrgJed.getValueAt(indexSelektovane, 6).toString();
		TelefonRestorana = modelOrgJed.getValueAt(indexSelektovane, 7).toString();
		EmailRestorana = modelOrgJed.getValueAt(indexSelektovane, 8).toString();
	}
	
	public boolean getValidation(String korisnicko_ime, String password)
	{
		String sql = "{ call SelectKorisnickiNalog('"+OznakaOrgJed+"','"+JIB+"','"+TipPosSisOznaka+"','"+OznakaDrz+"','"+korisnicko_ime+"','"+password+"') }";

		tableModel tableModel = new tableModel();
		tableModel.loadTable(sql);
		DefaultTableModel model = tableModel.getTableModel();
		if(model.getRowCount()!=0)
		{
		TipNaloga=model.getValueAt(0, 1).toString();
		NazivTipa=model.getValueAt(0, 0).toString();
		KorisnickoIme=korisnicko_ime;
		return true;
		}
		return false;

	}
	
}
