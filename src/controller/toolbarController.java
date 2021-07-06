package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MenadzerZakupSaleView;
import view.centralFormView;
import view.cjenovnikView;
import view.dnevniMeniView;
import view.dodajArtikalView;
import view.kadrovskaView;
import view.reportsView;
import view.toolbarView;

public class toolbarController 
{
	private toolbarView theView;
	private kadrovskaView kadrView;
	private cjenovnikView cijView;
	private dodajArtikalView dodView;
	private dnevniMeniView dneMeni;
	private MenadzerZakupSaleView zakup;

	private String sql;
	
	public toolbarController(toolbarView theView, kadrovskaView kadrView)
	{
		this.theView=theView;
		this.kadrView=kadrView;
		this.theView.addActionListener(listener);
	}
	public toolbarController(toolbarView theView, cjenovnikView cijView)
	{
		this.theView=theView;
		this.cijView=cijView;
		this.theView.addActionListener(listenerCijenovnik);
		this.theView.btnAdd.setEnabled(false);
	}
	public toolbarController(toolbarView theView, dodajArtikalView dodView)
	{
		this.theView=theView;
		this.dodView=dodView;
		this.theView.addActionListener(listenerdodajArt);
		this.theView.btnAdd.setEnabled(false);
	}
	public toolbarController(toolbarView theView, dnevniMeniView dneMeni)
	{
		this.theView=theView;
		this.dneMeni=dneMeni;
		this.theView.addActionListener(listenerdneMeni);
		this.theView.btnAdd.setEnabled(false);
	}
	public toolbarController(toolbarView theView, MenadzerZakupSaleView zakup)
	{
		this.theView=theView;
		this.zakup=zakup;
		this.theView.addActionListener(listenerzakup);
		this.theView.btnAdd.setEnabled(false);
	}
	
	ActionListener listener = new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
			case "newRow":
				kadrView.setAddMode();
				theView.btnEdit.setEnabled(false);
				break;
			case "editRow":
				kadrView.setEditMode();
				break;
			case "deleteRow": 
				break;
			case "first": 
				kadrView.selectFirstRow();
				break;
			case "next": 
				kadrView.selectNextRow();
				break;
			case "previous": 
				kadrView.selectPrevRow();
				break;
			case "last": 
				kadrView.selectLastRow();
				break;
			case "back": 
				kadrView.setTableRadnik();
				break;
			case "goBack": 
				kadrView.dispose();
				centralFormView central = new centralFormView();
				centralFormController centralControler = new centralFormController(central);
				central.setVisible(true);
				break;
			}
		}
	};
	
	ActionListener listenerCijenovnik = new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
			case "newRow":
				break;
			case "editRow":
				break;
			case "deleteRow": 
				break;
			case "first": 
				cijView.selectFirstRow();
				break;
			case "next": 
				cijView.selectNextRow();
				break;
			case "previous": 
				cijView.selectPrevRow();
				break;
			case "last": 
				cijView.selectLastRow();
				break;
			case "goBack": 
			    cijView.dispose();
				centralFormView central = new centralFormView();
				centralFormController centralControler = new centralFormController(central);
				central.setVisible(true);
				break;
			}
		}
	};
	
	ActionListener listenerdodajArt = new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
			case "newRow":
				break;
			case "editRow":
				break;
			case "deleteRow": 
				break;
			case "first": 
		
				break;
			case "next": 
			
				break;
			case "previous": 	
				break;
			case "last": 

				break;
			case "goBack": 
				dodView.dispose();
				centralFormView central = new centralFormView();
				centralFormController centralControler = new centralFormController(central);
				central.setVisible(true);
				break;
			}
		}
	};
	
	ActionListener listenerdneMeni = new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
			case "newRow":
				break;
			case "editRow":
				break;
			case "deleteRow": 
				break;
			case "first": 
		
				break;
			case "next": 
			
				break;
			case "previous": 	
				break;
			case "last": 

				break;
			case "goBack": 
				dneMeni.dispose();
				centralFormView central = new centralFormView();
				centralFormController centralControler = new centralFormController(central);
				central.setVisible(true);
				break;
			}
		}
	};
	
	ActionListener listenerzakup = new ActionListener() 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
			case "newRow":
				break;
			case "editRow":
				break;
			case "deleteRow": 
				break;
			case "first": 
		
				break;
			case "next": 
			
				break;
			case "previous": 	
				break;
			case "last": 

				break;
			case "goBack": 
				zakup.dispose();
				centralFormView central = new centralFormView();
				centralFormController centralControler = new centralFormController(central);
				central.setVisible(true);
				break;
			}
		}
	};
	
}
