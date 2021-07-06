package controller;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dbConnection.DBConnection;
import model.MenadzerZakupSaleModel;
import model.cjenovnikModel;
import model.dnevniMeniModel;
import model.kadrovskaModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.MenadzerZakupSaleView;
import view.centralFormView;
import view.cjenovnikView;
import view.dnevniMeniView;
import view.dodajArtikalView;
import view.kadrovskaView;
import view.reportsView;

public class centralFormController {
	
	private centralFormView theView;
	private reportsView repView;
	private reportsController repCont;
	
	public centralFormController(centralFormView theView) 
	{
	this.theView=theView;
	this.theView.addToolsMouseListener(mouseActionListener);
	this.theView.addClosingListener(windowListener);
	}
	
	// Mouse Listener.....

			MouseListener mouseActionListener = new MouseListener() {

				public void mouseEntered(java.awt.event.MouseEvent evt) {
					 Font font = new Font("Times New Roman", Font.BOLD, 13);
					 JButton alatka = (JButton) evt.getSource();
					 theView.setToolsLabelChanges(alatka, font, Color.WHITE);
					 
				    }
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	
			    	 Font font = new Font("Times New Roman", Font.BOLD, 11);
			    	 JButton alatka = (JButton) evt.getSource();
					 theView.setToolsLabelChanges(alatka, font, Color.LIGHT_GRAY);
			    }
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					// Potrebno izvezati sa odgovarajucim formama u zavisnosti od kliknute alatke... if(evt.getSource ==...)
					JButton button = (JButton)e.getSource();
					// Test
					switch(button.getActionCommand())
					{
					case "kadar":
						
						
						kadrovskaView kadrovska = new kadrovskaView();
						kadrovskaModel theModel = new kadrovskaModel();
						kadrovskaController theController = new kadrovskaController(kadrovska, theModel);
						kadrovska.setVisible(true);
						theView.dispose();
						break;
					case "cjenovnik":
					
						cjenovnikView view = new cjenovnikView();
						cjenovnikModel model = new cjenovnikModel();
						cjenovnikController controller = new cjenovnikController(view,model);
						view.setVisible(true);
						theView.dispose();
						break;
				
					case "izvjestaji":
				
						repView = new reportsView();
					    repCont = new reportsController(repView);
						repView.setVisible(true);
						break;

					case "primjedbe":

						break;
					case "dnevni_meni":
						
						dnevniMeniView viewDnevni=new dnevniMeniView();
						dnevniMeniModel modelDnevni=new dnevniMeniModel();
						dnevniMeniController controller1=new dnevniMeniController(modelDnevni, viewDnevni);
						theView.dispose();
						break;
					case "dodaj_artikal":
						dodajArtikalView dodajArikal=new dodajArtikalView();
					dodajArtikalController	dodajArtikalController=new dodajArtikalController(dodajArikal);
						//theView.dispose();
						break;
					case "najam":
						MenadzerZakupSaleModel modelZakup = new MenadzerZakupSaleModel();
						 MenadzerZakupSaleView viewZakup = new MenadzerZakupSaleView();
						 MenadzerZakupSaleController controllerZakup = new MenadzerZakupSaleController(viewZakup, modelZakup);
						 viewZakup.setVisible(true);
						 theView.dispose();
						 
					}
					
					//
				}
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			};
			
			WindowListener windowListener = new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) 
				{
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent e)
				{
					// TODO Auto-generated method stub

			
				}
				
				@Override
				public void windowClosing(WindowEvent e)
				{

				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println(e.getNewState());
					if(repView!=null)
				    repView.dispose();
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			};
	
}
