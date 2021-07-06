package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.loginModel;
import view.centralFormView;
import view.loginView;

public class loginController 
{
	public loginView theView = null;
	public loginModel theModel = null;
	
	public loginController(loginView theView, loginModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		this.theModel.loadOrgJed("SELECT * from ORGANIZACIONA_JEDINICA WHERE DR_OZNAKA='BIH' AND TPS_OZNAKA='RE' and ps_jib = '4201790070003'");
		this.theView.setcmbOrgJedNaziv(this.theModel.getOrgJedNativ());
		this.theView.addComboActionListener(comboChange);
		this.theView.addClickListener(clickLogin);
	}
	
	ActionListener comboChange = new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox<String> combo = (JComboBox<String>)e.getSource();
			if(combo.getSelectedIndex()>0)
			{
				theModel.setParametreOrgJed(combo.getSelectedIndex()-1);
			}
		}
	};
	ActionListener clickLogin = new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(theView.validnostUnosa())
			{
				if(theModel.getValidation(theView.getUsername(), theView.getPassword()))
				{
					
						centralFormView centralView = new centralFormView();
						centralFormController centralController = new centralFormController(centralView);
						centralView.setVisible(true);
						theView.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Pogresna lozinka ili username !!", "Greska !", JOptionPane.ERROR_MESSAGE);
				}
			}

		}
	};
}
