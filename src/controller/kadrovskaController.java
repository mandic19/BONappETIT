package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.kadrovskaModel;
import model.loginModel;
import view.kadrovskaView;

public class kadrovskaController 
{
	private kadrovskaView theView = null;
	private kadrovskaModel theModel = null;
	private String sql;
	
	public kadrovskaController(kadrovskaView theView, kadrovskaModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		this.theModel.loadTable("{ call " + "SelectRadnici" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') }", 0);
		this.theModel.loadSmjene("{ call " + "SelectSmjene" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') }");
		this.theModel.loadRadnaMjesta("{ call " + "SelectRadnaMjesta" + "() }");
		
		this.theView.setScrollPanel(this.theModel.getTable());
		this.theView.addSelectionListener(selectionListener);
		this.theView.setListSmjene(this.theModel.getObjectSmjene());
		this.theView.setListRadnaMjesta(this.theModel.getObjectRadnaMjesta());
		this.theView.addActionListener(clickListener, tableDoubleClick);
		this.theView.disableComponents();
		
	}
	
	// Listener koji slusa dogadjaje selektovanja redova tabele
	ListSelectionListener selectionListener = new ListSelectionListener() {
	    @Override
	    public void valueChanged(ListSelectionEvent event) 
	    {
	        if (theModel.getTable().getSelectedRow() > -1 && event.getValueIsAdjusting()!=true) 
	        {
	        	theView.setOznaka(theModel.getTable().getValueAt(theModel.getTable().getSelectedRow(), 0).toString());
	        	theView.setIme(theModel.getTable().getValueAt(theModel.getTable().getSelectedRow(), 1).toString());
	        	theView.setPrezime(theModel.getTable().getValueAt(theModel.getTable().getSelectedRow(), 2).toString());
	        	theView.setPlata(theModel.getTable().getValueAt(theModel.getTable().getSelectedRow(), 5).toString());
	        	theView.setTelefon(theModel.getDataModel().getValueAt(theModel.getTable().getSelectedRow(), 7).toString());
	        	theView.setAdresa(theModel.getDataModel().getValueAt(theModel.getTable().getSelectedRow(), 6).toString());
	        	theView.getToolbar().btnEdit.setEnabled(true);
	        	theView.getToolbar().btnDelete.setEnabled(true);
	        	
	        	switch(theModel.getDataModel().getValueAt(theModel.getTable().getSelectedRow(), 8).toString())
	        	{
	        	case "Stalni radni odnos":
	        		theView.setRadniOdnos(1);
	        		break;
	        	case "Privremeni radni odnos":
	        		theView.setRadniOdnos(2);
	        		break;
	        	}
	        	theView.setSmjena(theModel.getIndexSmjena(theModel.getTable().getValueAt(theModel.getTable().getSelectedRow(), 3).toString()));
	        	theView.setRadnoMjesto(theModel.getIndexRadMje(theModel.getTable().getValueAt(theModel.getTable().getSelectedRow(), 4).toString()));
	        }
	    }
	    
	};
	
	// Listener koji slusa dogadjaje klika na dugme Spremi (Dodaj, Izmjeni)
	ActionListener clickListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
			
			case "dodaj":
				
				if(theView.popunjenaObaveznaPolja())
				{
				String RM_Oznaka = theModel.dataRadnaMjesta.getValueAt(theView.getRadnoMjesto(), 0).toString();
			    String SM_Oznaka = theModel.dataSmjene.getValueAt(theView.getSmjena(), 0).toString();
					
				sql = "{ call " + "InsertRadnik" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"','"+theView.getOznaka()+"','"+RM_Oznaka+"','"+SM_Oznaka+"','"+theView.getIme()+"','"+theView.getPrezime()+"','"+theView.getPlata()+"','"+theView.getAdresa()+"','"+theView.getTelefon()+"','"+theView.getRadniOdnos()+"') }";
				theModel.updateRow(sql);
				
				theModel.loadTable("{ call " + "SelectRadnici" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') }", 0);
				theView.setScrollPanel(theModel.getTable());
				}

				break;
				
			case "izmijeni":
				
				if(theView.popunjenaObaveznaPolja())
				{
				String RM_Oznaka = theModel.dataRadnaMjesta.getValueAt(theView.getRadnoMjesto(), 0).toString();
				String SM_Oznaka = theModel.dataSmjene.getValueAt(theView.getSmjena(), 0).toString();
					
				String sql = "{ call " + "UpdateRadnik" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"','"+theView.getOznaka()+"','"+RM_Oznaka+"','"+SM_Oznaka+"','"+theView.getPlata()+"','"+theView.getAdresa()+"','"+theView.getTelefon()+"','"+theView.getRadniOdnos()+"') }";
				theModel.updateRow(sql);
				
				theModel.loadTable("{ call " + "SelectRadnici" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') }", 0);
				theView.setScrollPanel(theModel.getTable());
				}

				break;
			case "deleteRow":
				int n = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite izbrisati radnika?","Da li ste sigurni?",JOptionPane.YES_NO_CANCEL_OPTION);
				if (n == JOptionPane.YES_OPTION) 
				{
					sql = "{ call " + "DeleteRadnik" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"','"+theView.getOznaka()+"')}";
					theModel.updateRow(sql);
				
					theModel.loadTable("{ call " + "SelectRadnici" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"') }", 0);
					theView.setScrollPanel(theModel.getTable());
					theView.clearRightPanel();
				} 
				break;
			}
			
		}
	};
	
	// Listener koji slusa dogadjaje klika na redove tabele (dvostruki klik cime se ispisuje istorija radnih mjesta radnika)
	MouseListener tableDoubleClick = new MouseListener() 
	{

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			if(e.getClickCount()>1)
			{
				theModel.loadTable("{ call " + "SelectIstorijaRadnika" + "('"+loginModel.OznakaOrgJed+"','"+loginModel.JIB+"','"+loginModel.TipPosSisOznaka+"','"+loginModel.OznakaDrz+"','"+theView.getOznaka()+"') }",1);
				theView.disableComponents();
				theView.setIstorijaScroll(theModel.getTableIstorija());
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
}
