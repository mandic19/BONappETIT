package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.toedter.calendar.JDateChooser;
import model.cjenovnikModel;
import model.loginModel;
import view.cjenovnikView;
import view.kadrovskaView;


public class cjenovnikController 
{
	
	private cjenovnikView theView;
	private cjenovnikModel theModel;
	
	public cjenovnikController(cjenovnikView theView, cjenovnikModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		this.theModel.loadAsortiman("{ call SelectAsortimanArtikala('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') };");
		this.theView.setTableAsortiman(this.theModel.getTableAsortiman());
		this.theModel.loadCjenovnik("{ call SelectCijenovnik('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') };");
		this.theView.setTableCjenovnik(this.theModel.getTableCjenovnik());
		this.theView.addSelectionListener(selectionListener);
		this.theView.addActionListener(buttonClick);
		this.theView.addPropertyChangeListener(dateChange);
	}
	
	ListSelectionListener selectionListener = new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
		
			if(theModel.getTableAsortiman().getSelectedRow() > -1 && e.getValueIsAdjusting()!=true)
			{
			theView.setNaziv(theView.getClickedNaziv());
			theView.setOznaka(theView.getClickedOznaka());
			theView.setTipMenija(theModel.getOznakaAsortiman(theView.getClickedIndex()));
			}
		}
	};
	
	ActionListener buttonClick = new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch(e.getActionCommand())
			{
			case "spremi":
				
				if(theView.validnostUnosa())
				{
				int oznakaCijenovnika=theModel.getOznakaCijenovnika("{ call SelectMaxCijOznaka('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"','"+theModel.getOznakaTipMenija(theView.getClickedIndex())+"')}")+1;
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String datumPocetka = dateFormat.format(theView.getDatumPocetka());
				String datumZavrsetka = "0";
				if(theView.getDatumZavrsetka()!=null)
				{
				 datumZavrsetka = dateFormat.format(theView.getDatumZavrsetka());
				}
				String sql = "{ call insertCijenovnik('"+oznakaCijenovnika
				+"','"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"','"+theView.getClickedNaziv()+"','"+datumPocetka
				+"','"+datumZavrsetka+"','"+theView.getCijena()+"','"+theModel.getOznakaTipMenija(theView.getClickedIndex())+"')}";
				
				theModel.insertCijenovnik(sql);
				sql = "{ call insertNudiArtikal('"+theView.getClickedOznaka()+"','"+oznakaCijenovnika+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.JIB+"','"+loginModel.OznakaOrgJed+"','"+loginModel.OznakaDrz+"','"+theModel.getOznakaTipMenija(theView.getClickedIndex())+"')}";
				
				theModel.insertArtikalNaCijenovnik(sql);
				theModel.loadCjenovnik("{ call SelectCijenovnik('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') };");
				theView.setTableCjenovnik(theModel.getTableCjenovnik());
				}
			
				break;
			}
			
		}
	};
	
	PropertyChangeListener dateChange = new PropertyChangeListener() 
	{
		@Override
		public void propertyChange(PropertyChangeEvent arg0) 
		{
			
			JDateChooser choser = (JDateChooser)arg0.getSource();
			if(choser.getDate()!=null)
			{
			theView.setDatumZavrsetka(theView.getDatumPocetka());
			}
			
		}
	};
			
	
}
