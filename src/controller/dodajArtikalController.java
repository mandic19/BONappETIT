package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.JulianFields;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import dbConnection.DBConnection;
import model.loginModel;
import view.dodajArtikalView;

public class dodajArtikalController {

	dodajArtikalView view;
	private DBConnection dbCon;
	private Connection connection = null;
	DefaultComboBoxModel model2=new DefaultComboBoxModel<>();
	String sql;
	CallableStatement procStmt = null;
	boolean selektovan=false;
	
	public dodajArtikalController(dodajArtikalView view) {
		super();
		this.view = view;
		dbCon=DBConnection.getInstance();
		ucitajListu();
		view.addMouseAndItemListener(mouseActionListener,l);
		
	}
	
	ActionListener l=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {


			if(e.getActionCommand()=="chb")
			{ JCheckBox chb=(JCheckBox)e.getSource();
			if(chb.isSelected())
			{
				selektovan=true;
				view.getPanel_1().setBackground(Color.decode("#99b4d1"));

				view.getPanel_1().setVisible(true);
				view.getTxtNaziv().setEnabled(true);
				view.getTxtOznaka().setEnabled(true);
				view.getTxtNaziv().setText("");
				view.getTxtOznaka().setText("");
			}
			else
			{
				selektovan=false;
				view.getPanel_1().setVisible(false);
				view.getTxtNaziv().setEnabled(false);
				view.getTxtOznaka().setEnabled(false);
			}
			}
			
			if(e.getActionCommand()=="combo")
			{ JComboBox combo=(JComboBox)e.getSource();
				try
				{ String sql="select AA_NAZIV from ASORTIMAN_ARTIKALA where oj_oznaka='"+loginModel.OznakaOrgJed+"' and ps_jib='"+loginModel.JIB+"' and tps_oznaka='"+loginModel.TipPosSisOznaka+"' and dr_oznaka='"+loginModel.OznakaDrz+"'";
					if(combo.getSelectedIndex()!=0)
					{
						System.out.println(combo.getSelectedItem().toString());
						 sql = " select AA_NAZIV from ASORTIMAN_ARTIKALA JOIN TIP_MENIJA ON ASORTIMAN_ARTIKALA.TM_OZNAKA=TIP_MENIJA.TM_OZNAKA Where TIP_MENIJA.TM_NAZIV='"+combo.getSelectedItem().toString()+"' and oj_oznaka='"+loginModel.OznakaOrgJed+"' and ps_jib='"+loginModel.JIB+"' and tps_oznaka='"+loginModel.TipPosSisOznaka+"' and dr_oznaka='"+loginModel.OznakaDrz+"'" + 
								"";
					}
				
				ResultSet rs = null;
				procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
				rs = procStmt.executeQuery();
				view.getModel().clear();
				while(rs.next())
				{
					view.getModel().addElement(rs.getString("AA_NAZIV"));
					
					view.getList().setModel(view.getModel());
				}
				}
				catch (Exception e1) {
				System.out.println(e1.getMessage());	
				}
			}
			
		}
	};
	

	
	MouseListener mouseActionListener=new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton dugme = (JButton) e.getSource();
			
		
			
			if(dugme.getActionCommand()=="save")
			{
				try
				{
					if(view.getTextField_5().getText().length()>0)
					{
						if(selektovan)
						{
							if(view.getTxtNaziv().getText().length()>0 &&  view.getTxtOznaka().getText().length()>0 )
							{
								sql="insert into tip_menija(TM_OZNAKA,TM_NAZIV) values ('"+view.getTxtOznaka().getText().toString()+"','"+view.getTxtNaziv().getText().toString()+"')";
										procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
										procStmt.execute();
								
								if(view.getTextField_8().getText().length()>0 && view.getTextField_9().getText().length()>0 )
								{
									sql="\r\n" + 
											"  INSERT into asortiman_artikala(tps_oznaka,ps_jib,oj_oznaka,dr_oznaka,aa_naziv,tm_oznaka,AA_PROIZVODJAC,AA_GODINA_PROIZVODNJE) values('"+loginModel.TipPosSisOznaka+"','"+loginModel.JIB+"','"+loginModel.OznakaOrgJed+"','"+loginModel.OznakaDrz+"','"+view.getTextField_5().getText().toString()+"','"+view.getTxtOznaka().getText()+"','"+view.getTextField_8().getText().toString()+"',"+view.getTextField_9().getText()+");\r\n" + 
											"";
									
								}
								else
								{
									sql="\r\n" + 
											"  INSERT into asortiman_artikala(tps_oznaka,ps_jib,oj_oznaka,dr_oznaka,aa_naziv,tm_oznaka) values('"+loginModel.TipPosSisOznaka+"','"+loginModel.JIB+"','"+loginModel.OznakaOrgJed+"','"+loginModel.OznakaDrz+"','"+view.getTextField_5().getText().toString()+"','"+view.getTxtOznaka().getText()+"');\r\n" + 
											"";
								}
								
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Greška: Niste popunili obavezna polja oznacena sa '*' !" , "Error !", JOptionPane.ERROR_MESSAGE);
								
							}
						}
						else
						{
							String oznaka=vratiOznaku();
							
							if(view.getTextField_8().getText().length()>0 && view.getTextField_9().getText().length()>0)
							{
								sql="\r\n" + 
										"  INSERT into asortiman_artikala(tps_oznaka,ps_jib,oj_oznaka,dr_oznaka,aa_naziv,tm_oznaka,AA_PROIZVODJAC,AA_GODINA_PROIZVODNJE) values('"+loginModel.TipPosSisOznaka+"','"+loginModel.JIB+"','"+loginModel.OznakaOrgJed+"','"+loginModel.OznakaDrz+"','"+view.getTextField_5().getText().toString()+"','"+oznaka+"','"+view.getTextField_8().getText().toString()+"',"+view.getTextField_9().getText()+");\r\n" + 
										"";
							}
							else
							{
								
								sql="\r\n" + 
										"  INSERT into asortiman_artikala(tps_oznaka,ps_jib,oj_oznaka,dr_oznaka,aa_naziv,tm_oznaka) values('"+loginModel.TipPosSisOznaka+"','"+loginModel.JIB+"','"+loginModel.OznakaOrgJed+"','"+loginModel.OznakaDrz+"','"+view.getTextField_5().getText().toString()+"','"+oznaka+"');";
							}
							
						}
						
			
				procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
				procStmt.execute();
				
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Greška: Niste popunili obavezna polja oznacena sa *!" , "Error !", JOptionPane.ERROR_MESSAGE);
						
					}
					view.getTextField_8().setText(null);
					view.getTextField_9().setText(null);
					view.getTxtNaziv().setText(null);
					view.getTxtOznaka().setText(null);
					view.getTextField_5().setText(null);
					
				}
				catch (Exception e1) {
				e1.printStackTrace();
				}
				
				
			}
			
			
		}
	};
	
	public void ucitajListu()
	{
		try
		{
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
		
		 sql = "select AA_NAZIV from ASORTIMAN_ARTIKALA where oj_oznaka='"+loginModel.OznakaOrgJed+"' and ps_jib='"+loginModel.JIB+"' and tps_oznaka='"+loginModel.TipPosSisOznaka+"' and dr_oznaka='"+loginModel.OznakaDrz+"'";
		ResultSet rs = null;
		procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
		rs = procStmt.executeQuery();
		
		while(rs.next())
		{
			view.getModel().addElement(rs.getString("AA_NAZIV"));
			
			view.getList().setModel(view.getModel());
		}
	
		 sql = "select TM_NAZIV from TIP_MENIJA";
		 rs = null;
		procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
		rs = procStmt.executeQuery();
		view.getModelChb().addElement("       ");
		while(rs.next())
		{
			view.getModelChb().addElement(rs.getString("TM_NAZIV"));
			model2.addElement(rs.getString("TM_NAZIV"));
			view.getComboBox().setModel(view.getModelChb());
			view.getComboBox_1().setModel(model2);
		}
		view.getComboBox_1().setSelectedIndex(1);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Greška: " + e.getMessage(), "Error !", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
	public String vratiOznaku()
	{
		String oznaka = null;
		sql="select  tm_oznaka from TIP_MENIJA where TM_NAZIV='"+view.getComboBox_1().getSelectedItem().toString()+"'";
		
			
			try {
				ResultSet rs = null;
				procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
				rs = procStmt.executeQuery();
				if(rs.next())
				{
					oznaka=rs.getString("tm_oznaka");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return oznaka;
		
	}
	
}
