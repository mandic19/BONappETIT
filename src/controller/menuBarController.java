package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.loginModel;
import view.MenadzerZakupSaleView;
import view.NovaRezervacijaDialog;
import view.centralFormView;
import view.cjenovnikView;
import view.dnevniMeniView;
import view.dodajArtikalView;
import view.kadrovskaView;
import view.loginView;
import view.menuBar;
import view.reportsView;
import view.toolbarView;

public class menuBarController 
{
	private centralFormView theCentralView;
	private menuBar menuBar = new menuBar();
	private kadrovskaView kadrovskaView;
	private cjenovnikView cjenovnikView;
	private dodajArtikalView dodajView;
	private dnevniMeniView dnevniView;
	private MenadzerZakupSaleView zakupView;
	private NovaRezervacijaDialog novaView;


	public menuBarController(menuBar menuBar, centralFormView theCentralView) 
	{
	this.menuBar=menuBar;
	this.theCentralView=theCentralView;
	this.menuBar.addActionListener(actionPerformed);
	}
	public menuBarController(menuBar menuBar, kadrovskaView kadrovskaView) 
	{
	this.menuBar=menuBar;
	this.kadrovskaView=kadrovskaView;
	this.menuBar.addActionListener(actionPerformed);
	}
	public menuBarController(menuBar menuBar, cjenovnikView cjenovnikView) 
	{
		this.menuBar=menuBar;
		this.cjenovnikView=cjenovnikView;
		this.menuBar.addActionListener(actionPerformed);
	}
	public menuBarController(menuBar menuBar, dnevniMeniView dnevniView) 
	{
		this.menuBar=menuBar;
		this.dnevniView=dnevniView;
		this.menuBar.addActionListener(actionPerformed);
	}
	public menuBarController(menuBar menuBar, dodajArtikalView dodajView) 
	{
		this.menuBar=menuBar;
		this.dodajView=dodajView;
		this.menuBar.addActionListener(actionPerformed);
	}
	public menuBarController(menuBar menuBar, MenadzerZakupSaleView  zakupView) 
	{
		this.menuBar=menuBar;
		this.zakupView=zakupView;
		this.menuBar.addActionListener(actionPerformed);
	}

	public menuBarController(menuBar menuBar, NovaRezervacijaDialog  novaView) 
	{
		this.menuBar=menuBar;
		this.novaView=novaView;
		this.menuBar.addActionListener(actionPerformed);
	}
	
	
	ActionListener actionPerformed = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch (e.getActionCommand())
			{
			case "about":
				
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				Font font_naslova = new Font("Times New Roman", Font.BOLD, 20);
				Font font = new Font("Consolas", Font.BOLD, 12);
				
				JLabel title = new JLabel("ABOUT US");
				title.setForeground(Color.GRAY);
				title.setFont(font_naslova);
				title.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				JLabel apptitle = new JLabel("\"BONappETIT\"");	
				apptitle.setAlignmentX(Component.CENTER_ALIGNMENT);
				apptitle.setFont(font_naslova);
				apptitle.setForeground(Color.BLACK);
						
				JLabel dev_first = new JLabel("Marko Mandić");
				dev_first.setForeground(Color.gray);
				dev_first.setFont(font);
				dev_first.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				JLabel dev_second = new JLabel("Nenad Grujičić");
				dev_second.setForeground(Color.gray);
				dev_second.setFont(font);
				dev_second.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				JLabel dev_third = new JLabel("Predrag Damjanović");
				dev_third.setFont(font);
				dev_third.setForeground(Color.gray);
				dev_third.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				JLabel project_menager = new JLabel("Stefan Grujičić");
				project_menager.setFont(font);
				project_menager.setForeground(Color.DARK_GRAY);
				project_menager.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				JLabel dev_fourth = new JLabel("Milan Mitrović");
				dev_fourth.setFont(font);
				dev_fourth.setForeground(Color.gray);
				dev_fourth.setAlignmentX(Component.CENTER_ALIGNMENT);
				

				JLabel footer = new JLabel("PROJEKTOVANJE INFORMACIONIH SISTEMA");
				footer.setFont(new Font("Times New Roman", Font.BOLD, 16));
				footer.setForeground(Color.black);
				footer.setAlignmentX(Component.CENTER_ALIGNMENT);
				
				JPanel empty1 = new JPanel();
				empty1.setPreferredSize(new Dimension(10, 10));
				JPanel empty2 = new JPanel();
				empty2.setPreferredSize(new Dimension(10, 10));
				JPanel empty3 = new JPanel();
				empty3.setPreferredSize(new Dimension(10, 10));
				JPanel empty4 = new JPanel();
				empty4.setPreferredSize(new Dimension(10, 10));
				
				panel.add(title);
				panel.add(empty1);
				panel.add(apptitle);
				panel.add(empty2);
				panel.add(project_menager);
				panel.add(dev_first);
				panel.add(dev_second);
				panel.add(dev_third);
				panel.add(dev_fourth);
				panel.add(empty3);
				panel.add(footer);
				
				JOptionPane.showMessageDialog(null, panel, "About application", JOptionPane.OK_OPTION, new ImageIcon("files/icons/logo.png"));
				break;
			
			case "exit":
				
				if(kadrovskaView!=null)
				{
				kadrovskaView.dispose();
				}
				if(dnevniView!=null)
				{
					dnevniView.dispose();
				}
				if(cjenovnikView!=null)
				{
					cjenovnikView.dispose();
				}
				if(dodajView!=null)
				{
					dodajView.dispose();
				}
				if(theCentralView!=null)
				{
					theCentralView.dispose();
				}
				if(zakupView!=null)
				{
					zakupView.dispose();
				}
				if(novaView!=null)
				{
					novaView.dispose();
				}
			
				loginView loginView = new loginView();
				loginModel loginModel = new loginModel();
				loginController loginController = new loginController(loginView, loginModel);
				loginView.setVisible(true);
				break;
				
				
			}
			
		}

	};
	
}
