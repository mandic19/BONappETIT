package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.MenadzerZakupSaleModel;
import view.MenadzerSalaKontrola;
import view.MenadzerZakupSaleView;
import view.NovaRezervacijaDialog;

public class MenadzerZakupSaleController {
	
	private MenadzerZakupSaleView view;
	private MenadzerZakupSaleModel model;
	private DefaultTableModel tableModel;
	private DefaultTableModel tipZakupaTableModel;
	private String rezervacije;
	private String NovaRezervacija="";
	private NovaRezervacijaDialog rezervacija;
	private MenadzerSalaKontrola kontrola;
	
	public MenadzerZakupSaleController(MenadzerZakupSaleView view, MenadzerZakupSaleModel model) {
		
		this.view = view;
		this.model=model;
		this.view.addOdbaciListener(odbaciActionListener);
		this.view.addZavrsiNarudzbuActionListener(zavrsiNarudzbuActionListener);
		this.view.addCijenaPoMjestuActionListener(txtCijenaPoMjestuActionListener);
		this.view.addClosingListener(windowClosing);
		ucitajRaspoloziveSale();
	}
	
	ActionListener odbaciDijalogActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			rezervacija.dispose();
		}
	};
	
	ActionListener odbaciActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {

			view.setVisible(false);
			view.dispose();
		}
	};
	
	MouseListener mouseClickedListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent me) {
			
			kontrola = (MenadzerSalaKontrola) me.getSource();
			rezervacije="";
			rezervacija = new NovaRezervacijaDialog();
			rezervacija.addActionListenerZavrsi(zavrsiActionListener);
			rezervacija.addOdbaciActionListener(odbaciDijalogActionListener);
			rezervacija.setTitle(kontrola.NazivSale);
			model.procitajTabeluZakup(kontrola.OznakaSale, kontrola.OrganizacionaJedinicaSale, kontrola.TipPoslovnogSistema, kontrola.KljucPoslovnogSistema);
			tableModel=model.getDataModelZakupa();
			model.procitajTabeluTipZakupa();
			tipZakupaTableModel=model.getTipZakupaModel();
			rezervacija.setCmbBoxTipDogadjaja(tipZakupaTableModel);
			ucitajRezervacijeSale();
			rezervacija.setPostojeceRezervacije(rezervacije);
			rezervacija.setVisible(true);
			
		}
	};
	
	ActionListener zavrsiActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			if((Integer.parseInt(rezervacija.getUneseniBrojMjesta())>0) && (Integer.parseInt(rezervacija.getUneseniBrojMjesta()) <= Integer.parseInt(kontrola.BrojMjesta))){
				

				NovaRezervacija +="REZERVISANO :\nNaziv sale: "+rezervacija.getTitle().toString()+"\nTip dogaÄ‘aja: "+rezervacija.getTipDogadjaja().toString()+"\nPoÄ�etak dogaÄ‘aja: "+rezervacija.getPocetakDogadjaja().toString()+"\nZavrÅ¡etak dogaÄ‘aja: "+rezervacija.getZavrsetakDogadjaja().toString()+"\n";
				view.setPocetakDogadjaja(rezervacija.getPocetakDogadjaja());
				view.setZavrsetakDogadjaja(rezervacija.getZavrsetakDogadjaja());
				view.setTipDogadjaja(rezervacija.getTipZakupa());
				rezervacija.dispose();
				view.setInformacijeZakup(NovaRezervacija);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"PogreÅ¡an unos broja mjesta !","Eror",JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	ActionListener txtCijenaPoMjestuActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			BigDecimal cijena;
			float cijenazakupa = (Integer.parseInt(rezervacija.getUneseniBrojMjesta()))*(float)(Double.parseDouble(view.getCijenaPoMjestu()));
			cijena =round( (Integer.parseInt(rezervacija.getUneseniBrojMjesta()))*(float)(Double.parseDouble(view.getCijenaPoMjestu())),2);
			view.setCijenaZakupa(cijenazakupa);
			view.setlblCijenaZakupa(String.valueOf(cijena));
			
		}
	};
	
	@SuppressWarnings("deprecation")
	public static BigDecimal round(float d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(Float.toString(d));
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
	    return bd;
	}
	
	ActionListener zavrsiNarudzbuActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			
			/*EXEC unesi_novi_zakup(tz_oznaka,sl_oznaka,tps_oznaka,ps_jib,oj_oznaka,dr_oznaka,broj_mjesta,datum pocetka, datum zavrsetka,cijena,ime zakupca, prezime,adresa, telefon)*/
			
			model.insertRow(rezervacija.getTipZakupa(),kontrola.getOznakaSale(),kontrola.BrojMjesta, view.pocetakDogadjaja, view.zavrsetakDogadjaja, view.getCijenaZakupa(), view.getImeZakupca(), view.getPrezimeZakupca(), view.getAdresaZakupca(), view.getTelefonZakupca());
			
		}
	};
	public void ucitajRaspoloziveSale() {
		
		model.procitajTabeluSala();
		tableModel = model.getDataModelSala();
		
		for(int i=0;i<tableModel.getRowCount();i++) {
			
			MenadzerSalaKontrola Sala = new MenadzerSalaKontrola(tableModel.getValueAt(i,5).toString(),tableModel.getValueAt(i,6).toString(), tableModel.getValueAt(i,7).toString(),
			tableModel.getValueAt(i,3).toString(),tableModel.getValueAt(i,1).toString(),tableModel.getValueAt(i,2).toString(),tableModel.getValueAt(i,0).toString());
			Sala.addmouseListener(mouseClickedListener);
			view.popuniRightPanel(Sala);
		}
	}
	
	public void ucitajRezervacijeSale() {
		
		if(tableModel.getRowCount()!=0) {
			
			for(int i =0;i<tableModel.getRowCount();i++) {
				
				rezervacije += "REZERVACIJA BR."+(i+1)+":\n PoÄ�etak dogaÄ‘aja :"+tableModel.getValueAt(i,9)+"\n ZavrÅ¡etak dogaÄ‘aja :"+tableModel.getValueAt(i,10)+"\n";
			}
		}
		else
		{
			rezervacije += "Nema rezervacija za ovu salu !";
		}
		
	}
	WindowListener windowClosing = new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			if(rezervacija!=null)
			rezervacija.dispose();
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
}
