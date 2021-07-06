package model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class cjenovnikModel 
{
	private tableModel tableModel = new tableModel();
	private DefaultTableModel modelAsortiman = new DefaultTableModel();
	private JTable tableAsortiman = new JTable();
	private DefaultTableModel modelCjenovnik = new DefaultTableModel();
	private JTable tableCjenovnik = new JTable();
	
	public void loadAsortiman(String sql)
	{

		tableModel.loadTable(sql);
		modelAsortiman = tableModel.getTableModel();
		tableAsortiman.setModel(modelAsortiman);
	}
	
	public JTable getTableAsortiman()
	{
		return tableAsortiman;
	}
	
	public void loadCjenovnik(String sql)
	{
		tableModel.loadTableWithXML(sql, "Cijenovnik");
		modelCjenovnik = tableModel.getTableModel();
		tableCjenovnik.setModel(modelCjenovnik);
	}
	
	public JTable getTableCjenovnik()
	{
		return tableCjenovnik;
	}
	
	public String getOznakaAsortiman(int index)
	{
		return modelAsortiman.getValueAt(index, 0).toString();
		
	}
	
	public String getOznakaTipMenija(int index)
	{
		return modelAsortiman.getValueAt(index, 1).toString();
		
	}

	public void insertArtikalNaCijenovnik(String sql)
	{
		tableModel.updateRow(sql);
	}
	public void insertCijenovnik(String sql)
	{

		tableModel.updateRowNoMessage(sql);
	}

	public int getOznakaCijenovnika(String sql)
	{
		DefaultTableModel cijOznakaModel = new DefaultTableModel();
		tableModel.loadTable(sql);
		cijOznakaModel = tableModel.getTableModel();
		try
		{
		return Integer.parseInt(cijOznakaModel.getValueAt(0, 0).toString());
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
}
