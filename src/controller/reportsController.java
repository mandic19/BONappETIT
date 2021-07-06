package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dbConnection.DBConnection;
import model.loginModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.reportsView;

public class reportsController 
{
	private reportsView theView = null;
	
	public reportsController(reportsView theView)
	{
		this.theView = theView;
		this.theView.addActionListener(listener);
		this.theView.addClickListener(listenerClick);
	}
	
	 ActionListener listener = new ActionListener() 
	 {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox<String> combo = (JComboBox)e.getSource();
			
			switch(combo.getSelectedIndex())
			{
			case 0: 
				theView.deaktivirajDugme();
				theView.setpnlDatumiInvisible();
				break;
			case 1:
				theView.aktivirajDugme();
				theView.setpnlDatumiInvisible();
				break;
			case 2:
				theView.aktivirajDugme();
				theView.setpnlDatumiVisible();
				break;
			case 3: 
				theView.aktivirajDugme();
				theView.setpnlDatumiInvisible();
				break;
			}
		}
	};
	 ActionListener listenerClick = new ActionListener() 
	 {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getActionCommand().equals("generisi"))
			{
				DBConnection dbCon = DBConnection.getInstance();
				Connection connection = null;
				
				
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
					
				switch (theView.getSelectedIzvjestaj()) {
				
				case 1:
					try 
					{
					InputStream inputStream = new FileInputStream("reports/Cjenovnik.jrxml"); // punjenje dizajna izvjestaja u InputStream
					 
					Map<String, Object> parameters = new HashMap<String, Object>();
					parameters.put("JIB", loginModel.JIB); //ukoliko dizajn ima parametre, prosljedjuju se kroz hes mapu
					parameters.put("TipPosSis", loginModel.TipPosSisOznaka);
					parameters.put("OrgJed", loginModel.OznakaOrgJed);
				    parameters.put("DrzOzn", loginModel.OznakaDrz);
				    parameters.put("NazivRes", loginModel.NazivRestorana);
				    parameters.put("AdresaRes", loginModel.AdresaRestorana+", "+loginModel.Grad);
				    parameters.put("EmailRes", loginModel.EmailRestorana);
				    parameters.put("TelRes", loginModel.TelefonRestorana);
				  
				    
					JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
					JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection); // generisanje izvjestaja preko objekta @ResultSet@
					JasperViewer.viewReport(jasperPrint, false); // dijalog pogled na izvjestaj, omogucava eksport u pdf, html, xml preko korisnickih komandi
					
					JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/Cjenovnik.pdf"); //eksport izvjestaja u pdf u kodu
					
					JasperExportManager.exportReportToHtmlFile(jasperPrint, "reports/Cjenovnik.html"); //eksport izvjestaja u html u kodu 
					
					JasperExportManager.exportReportToXmlFile(jasperPrint, "reports/Cjenovnik.xml", false); // eksport izvjestaja u xml u kodu
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Greska: "+ex.getLocalizedMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
					}
					break;
				case 2:
						if(theView.validnostUnosa())
						{
						try
						{
							
							InputStream inputStream = new FileInputStream("reports/Prodaja.jrxml"); // punjenje dizajna izvjestaja u InputStream
							 
							Map<String, Object> parameters = new HashMap<String, Object>();
							parameters.put("NazivRes", loginModel.NazivRestorana);
						    parameters.put("AdresaRes", loginModel.AdresaRestorana+", "+loginModel.Grad);
						    parameters.put("EmailRes", loginModel.EmailRestorana);
						    parameters.put("TelRes", loginModel.TelefonRestorana);
						    parameters.put("JIB", loginModel.JIB); //ukoliko dizajn ima parametre, prosljedjuju se kroz hes mapu
							parameters.put("TipPosSis", loginModel.TipPosSisOznaka);
							parameters.put("OrgJed", loginModel.OznakaOrgJed);
						    parameters.put("DrzOzn", loginModel.OznakaDrz);
							parameters.put("Od", theView.getDatumPocetka());
						    parameters.put("Do", theView.getDatumZavrsetka());
						    
						    
							JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
							JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
							JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection); // generisanje izvjestaja preko objekta @ResultSet@

							JasperViewer.viewReport(jasperPrint, false); // dijalog pogled na izvjestaj, omogucava eksport u pdf, html, xml preko korisnickih komandi
							
							JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/Prodaja.pdf"); //eksport izvjestaja u pdf u kodu
							
							JasperExportManager.exportReportToHtmlFile(jasperPrint, "reports/Prodaja.html"); //eksport izvjestaja u html u kodu 
							
							JasperExportManager.exportReportToXmlFile(jasperPrint, "reports/Prodaja.xml", false); // eksport izvjestaja u xml u kodu
						}
						catch (Exception e2) 
						{
							JOptionPane.showMessageDialog(null, "Greska: "+e2.getLocalizedMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
						}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Popunite sva obavezna polja !!", "Greška !", JOptionPane.ERROR_MESSAGE);
						}
					break;
				case 3:
					
					try
					{
					
					InputStream inputStream = new FileInputStream("reports/PlateRadnika.jrxml");
					Map<String, Object> parameters = new HashMap<String, Object>();
					parameters.put("NazivRes", loginModel.NazivRestorana);
				    parameters.put("AdresaRes", loginModel.AdresaRestorana+", "+loginModel.Grad);
				    parameters.put("EmailRes", loginModel.EmailRestorana);
				    parameters.put("TelRes", loginModel.TelefonRestorana);
				    parameters.put("JIB", loginModel.JIB); //ukoliko dizajn ima parametre, prosljedjuju se kroz hes mapu
					parameters.put("TipPosSis", loginModel.TipPosSisOznaka);
					parameters.put("OrgJed", loginModel.OznakaOrgJed);
				    parameters.put("DrzOzn", loginModel.OznakaDrz);

				    
				    
					JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
					JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection); // generisanje izvjestaja preko objekta @ResultSet@
					
					JasperViewer.viewReport(jasperPrint, false); // dijalog pogled na izvjestaj, omogucava eksport u pdf, html, xml preko korisnickih komandi
					
					JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/PlateRadnika.pdf"); //eksport izvjestaja u pdf u kodu
					
					JasperExportManager.exportReportToHtmlFile(jasperPrint, "reports/PlateRadnika.html"); //eksport izvjestaja u html u kodu 
					
					JasperExportManager.exportReportToXmlFile(jasperPrint, "reports/PlateRadnika.xml", false); // eksport izvjestaja u xml u kodu
					}
					catch (Exception e2) 
					{
						JOptionPane.showMessageDialog(null, "Greska: "+e2.getLocalizedMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
					}
				
					break;
					
				}
			}
		}
	};

}
