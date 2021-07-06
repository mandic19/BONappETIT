package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;

import javax.swing.JOptionPane;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

import dbConnection.DBConnection;
import model.dnevniMeniModel;
import model.loginModel;
import view.dnevniMeniView;

public class dnevniMeniController {

	private dnevniMeniModel model;
	private dnevniMeniView view;
	public Double dnevniMeni= (double) 0;
	double[] cijena=new double[500] ;
	double[] cijena2=new double[50] ;
	String[] tipMenija=new String[500];
	String[] tipMenija2=new String[50];
	String cijOznaka;
	int j=0;
	Connection connection = null;

	CallableStatement procStmt = null;
	
    
	public dnevniMeniController(dnevniMeniModel model, dnevniMeniView view) {
		super();
		this.model = model;
		this.view = view;
		ucitajPodatkeUListu();
		this.view.addMouseListener(mouseActionListener);
		
	}


	MouseListener mouseActionListener = new MouseListener() {
		
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
			
			JButton dugme=(JButton) e.getSource();
			if(dugme.isEnabled())
			{
			switch (dugme.getActionCommand()) {
			case "ok":
				
				if(view.getTextProcent().getText().toString().length()>0)
				{  
				
					view.getDlm().addElement("----------------------------------------------------------");
					view.getDlm().addElement("                                    -"+ view.getTextProcent().getText()+"%");
					view.getDlm().addElement("----------------------------------------------------------");
					
					for (int i = 0; i < cijena2.length; i++) {
						
						if(cijena2[i]!=0)
						{
						model.izracunajCijenuMenija(Double.parseDouble(view.getTextProcent().getText().toString()), cijena2[i]);
						int duzina=view.getListDnevniMeni().getModel().getElementAt(i).toString().length();
						view.getDlm().addElement(view.getListDnevniMeni().getModel().getElementAt(i).toString().substring(0, duzina-16)+"      "+ model.getCijenaDnevnogMenija()+" KM");
						}
						}
					
				
				view.getBtnRemove().setEnabled(false);
				view.getBtnDodaj().setEnabled(false);
				view.getBtnOk().setEnabled(false);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Greška: Niste unijeli procenat umanjenja dnevnog menija!" , "Error !", JOptionPane.ERROR_MESSAGE);
				}
				
				
				break;
			case "remove":
				
				dnevniMeni-=cijena2[(view.getListDnevniMeni().getSelectedIndex())];
				
				for(int i=view.getListDnevniMeni().getSelectedIndex();i<cijena2.length-1;i++)
				{
					
					cijena2[i]=cijena2[i+1];
					tipMenija2[i]=tipMenija2[i+1];
					
				}
				view.getDlm().removeElementAt(view.getListDnevniMeni().getSelectedIndex());
				
				view.getListDnevniMeni().setModel(view.getDlm());
				break;
			case "add":
				String rec=view.getListGlavniMeni().getSelectedValue().toString();
			
				if(rec.length()>10 && !rec.equals("-----------------------------------------------"))
				{
					
					
					view.getDlm().addElement(view.getListGlavniMeni().getSelectedValue());
				
			        
					dnevniMeni+=cijena[(view.getListGlavniMeni().getSelectedIndex())];
					cijena2[j]=cijena[(view.getListGlavniMeni().getSelectedIndex())];
					tipMenija2[j]=tipMenija[(view.getListGlavniMeni().getSelectedIndex())];		
					
					j++;
					
				}
				
				view.getListDnevniMeni().setModel(view.getDlm());
				break;
			case "azuriraj":
				String sql="";
				String tipMenija;

				for (int i = 0; i < cijena2.length; i++) {
					
					if(cijena2[i]!=0)
					{
						Date polje=view.getDateChooser().getDate();
						Date polje2=view.getDateChooser_1().getDate();
						
						SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				
					
						model.izracunajCijenuMenija(Double.parseDouble(view.getTextProcent().getText().toString()), cijena2[i]);

						tipMenija=vratiTipMenija("{ call vratiTipMenija('"+tipMenija2[i]+"','"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') }");
						
						
						cijOznaka=vratiCijOznaku("{ call vratiCijOznaku('"+tipMenija2[i]+"','"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') }");
						
						
							if(polje2==null)
							{
								sql="{ call " + "UnesiArtikalUDnevniMeni" + "('"+loginModel.TipPosSisOznaka+"','"+loginModel.JIB+"','"+loginModel.OznakaOrgJed+"','"+loginModel.OznakaDrz+"','"+tipMenija+"',"+Integer.parseInt(cijOznaka)+",'"+sdf.format(polje).toString()+"',null,"+model.getCijenaDnevnogMenija()+")}";
								
							}
							else
							{
								sql="{ call " + "UnesiArtikalUDnevniMeni" + "('"+loginModel.TipPosSisOznaka+"','"+loginModel.JIB+"','"+loginModel.OznakaOrgJed+"','"+loginModel.OznakaDrz+"','"+tipMenija+"',"+Integer.parseInt(cijOznaka)+",'"+sdf.format(polje).toString()+"','"+sdf.format(polje2).toString()+"',"+model.getCijenaDnevnogMenija()+")}";
								
							}
								try {
								procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
								procStmt.execute();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				}
				
				 
			
			
				
				view.getDlm().clear();
				view.getListDnevniMeni().setModel(view.getDlm());
				
				j=0;
				view.getBtnRemove().setEnabled(true);
				view.getBtnDodaj().setEnabled(true);
				view.getBtnOk().setEnabled(true);
				view.getTextProcent().setText("");
				view.getDateChooser_1().setDate(null);
				for (int k = 0; k < cijena2.length; k++) {
					cijena2[k]=0;
					tipMenija2[k]="";
				}
				dnevniMeni=(double) 0;
				
				break;
	

			default:
				break;
			}
			}
			
			
		}
	};
	
	public void ucitajPodatkeUListu()
	{
	
		try {
		
			DBConnection dbCon=DBConnection.getInstance();
			if(dbCon.getConnectionParameters("xml\\xml.xml"))
			{
			connection=dbCon.getConnection();
			}
		
			String sql = "{ call ucitajPodatkeUListu('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') }";
			ResultSet rs = null;
			procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
			rs = procStmt.executeQuery();
			
			int i=0;
			String naziv="Nesto";
			while(rs.next())
			{
				String novi=rs.getString("TM_NAZIV").toString();
				if(!novi.equals(naziv))
				{
					naziv=rs.getString("TM_NAZIV");
					
					
					
					view.getDlm2().addElement("-----------------------------------------------");
					view.getDlm2().addElement(naziv);
					view.getDlm2().addElement("-----------------------------------------------");
					
				
					i+=3;
					
					
				}
				
			
				
				view.getDlm2().addElement(String.format("%-" + 30 + "s", rs.getString("CIJ_NAZIV"))+rs.getString("CIJ_CIJENA")+"  KM");
				cijena[i]=rs.getDouble("CIJ_CIJENA");
				tipMenija[i]=rs.getString("CIJ_NAZIV");
				
				i++;
			view.getListGlavniMeni().setModel(view.getDlm2());
				
				
					
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String vratiTipMenija(String sql)
	{
		String tip = null;
		ResultSet rs = null;
		try {
			procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
			rs = procStmt.executeQuery();
			if(rs.next())
			tip=rs.getString("TM_OZNAKA");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tip;
		
		
	}
	public String vratiCijOznaku(String sql)
	{
		String tip = null;
		ResultSet rs = null;
		try {
			procStmt = connection.prepareCall(sql, SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,SQLServerResultSet.CONCUR_READ_ONLY);
			rs = procStmt.executeQuery();
			if(rs.next())
			tip=rs.getString("CIJ_OZNAKA");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tip;
		
		
	}
}
