package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.menuBarController;
import model.loginModel;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;



public class centralFormView extends JFrame {

	private JPanel contentPanel;
	private JButton btnCijenovnik = new JButton();
	private JLabel lblCjenovnik = new JLabel("CJENOVNIK\r\n");
	private JButton btnNarudzba = new JButton();
	private JLabel lblNarudzba = new JLabel("NARUD\u017DBA");
	private JButton btnNajam = new JButton();
	private JLabel lblNajam = new JLabel("NAJAM");
	private JButton btnDnevniMeni = new JButton();
	private JLabel lblDnevniMeni = new JLabel("DNEVNI MENI");
	private JButton btnPrimjedbe = new JButton();
	private JLabel lblPrimjedbe = new JLabel("PRIMJEDBE");
	private JButton btnNarudzbeNajma = new JButton();
	private JLabel lblNarudzbeNajma = new JLabel("DOGA\u0110AJI");
	private JButton btnIzvjestaji = new JButton();
	private JLabel lblIzvjestaji = new JLabel("IZVJE\u0160TAJI");
	private JButton btnDodajArtikal = new JButton();
	private JLabel lblDodajArtikal = new JLabel("DODAJ ARTIKAL");
	private JButton btnKadar = new JButton();
	private JLabel lblKadar = new JLabel("KADAR");
	private JLabel lblNaziv;
	private JLabel lblAdresa;
	private JLabel lblTelefon;
	private JLabel lblKorisnickoIme;
	private JLabel lblTipNaloga;

	public centralFormView(){
		
		Color boja_pozadine = new Color(30,30,30);
		Color boja_kontrola = new Color(240, 255, 240);
		Dimension dimenzije_alatki = new Dimension(100, 100);
		Dimension dimenzije_labela = new Dimension(103,30);
		
		// Osnovna podesavanja JFrame-a
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));
		this.setTitle("BONappETIT");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1050, 600));
		this.setSize(1050, 600);
		this.setLocationRelativeTo(null);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(boja_pozadine);
		contentPanel.setBorder(new EmptyBorder(0,0,10,0));
		setContentPane(contentPanel);
		
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{900, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 140, 150, 28, 150};
		gbl_contentPanel.columnWeights = new double[]{ Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0};
		contentPanel.setLayout(gbl_contentPanel);
		
		
		// Labela naslova central View forme
	
		JLabel lblNaslov = new JLabel("BONappETIT");
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaslov.setForeground(boja_kontrola);
		lblNaslov.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		
		GridBagConstraints gbc_lblNaslov = new GridBagConstraints();
		gbc_lblNaslov.anchor = GridBagConstraints.NORTH;
		gbc_lblNaslov.insets = new Insets(45, 0, 5, 0);
		gbc_lblNaslov.gridx = 0;
		gbc_lblNaslov.gridy = 1;
		contentPanel.add(lblNaslov, gbc_lblNaslov);
		
		//Meni bar
		
		menuBar menuBar=new menuBar();
		menuBarController mnc=new menuBarController(menuBar, this);
		GridBagConstraints gbc_toolbar = new GridBagConstraints();
	    gbc_toolbar.insets = new Insets(0, 0, 5, 0);
	    gbc_toolbar.gridx = 0;
	    gbc_toolbar.gridy = 0;
	    gbc_toolbar.anchor = GridBagConstraints.NORTH;
	    gbc_toolbar.fill = GridBagConstraints.HORIZONTAL;
	    contentPanel.add(menuBar, gbc_toolbar);
		
		// Panel korisničkih ALATKI
		
		JPanel pnlAlatke = new JPanel();
		pnlAlatke.setBackground(boja_pozadine);
		Border border = new TitledBorder(new LineBorder(boja_kontrola, 2, true), "ALATKE", TitledBorder.LEADING, TitledBorder.TOP, new Font("Times New Roman", Font.BOLD, 13), boja_kontrola);
		Border margin = new EmptyBorder(5,50,5,50);
		pnlAlatke.setBorder(new CompoundBorder(border, margin));
		pnlAlatke.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

		
		// Layout constraint za panel ALATKI
		
		GridBagConstraints gbc_pnlAlatke = new GridBagConstraints();
		gbc_pnlAlatke.anchor = GridBagConstraints.NORTH;
		gbc_pnlAlatke.insets = new Insets(0, 0, 5, 0);
		gbc_pnlAlatke.gridx = 0;
		gbc_pnlAlatke.gridy = 2;
		contentPanel.add(pnlAlatke, gbc_pnlAlatke);
		
		
		//Panel naziva korisničkih alatki
		
		JPanel pnlLabele = new JPanel();
		pnlLabele.setBackground(new Color(30, 30, 30));
		
		
		// Layout constraint za panel naziva alatki

		GridBagConstraints gbc_pnlLabele = new GridBagConstraints();
		gbc_pnlLabele.anchor = GridBagConstraints.NORTH;
		gbc_pnlLabele.insets = new Insets(0, 0, 5, 0);
		gbc_pnlLabele.gridx = 0;
		gbc_pnlLabele.gridy = 3;
		contentPanel.add(pnlLabele, gbc_pnlLabele);
		pnlLabele.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));
		
		
		// Dugme (alatka) CJENOVNIK i njegova labela naziva
		
		btnCijenovnik.setIcon(new ImageIcon(new ImageIcon("files/icons/cjenovnik.png").getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH)));
		btnCijenovnik.setActionCommand("cjenovnik");
		btnCijenovnik.setPreferredSize(dimenzije_alatki);
		btnCijenovnik.setBackground(boja_kontrola);
		pnlAlatke.add(btnCijenovnik);
		
		lblCjenovnik.setVerticalAlignment(SwingConstants.TOP);
		lblCjenovnik.setHorizontalAlignment(SwingConstants.CENTER);
		lblCjenovnik.setForeground(Color.LIGHT_GRAY);
		lblCjenovnik.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblCjenovnik.setPreferredSize(dimenzije_labela);
		pnlLabele.add(lblCjenovnik);
		
		
		// Dugme (alatka) NARUDŽBE i njegova labela naziva
		
		btnNarudzba.setIcon(new ImageIcon(new ImageIcon("files/icons/narudzba.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		btnNarudzba.setActionCommand("narudzba");
		btnNarudzba.setBackground(boja_kontrola);
		btnNarudzba.setPreferredSize(dimenzije_alatki);
		pnlAlatke.add(btnNarudzba);
		pnlAlatke.add(btnNarudzba);
		
		lblNarudzba.setVerticalAlignment(SwingConstants.TOP);
		lblNarudzba.setHorizontalAlignment(SwingConstants.CENTER);
		lblNarudzba.setForeground(Color.LIGHT_GRAY);
		lblNarudzba.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNarudzba.setPreferredSize(dimenzije_labela);
		pnlLabele.add(lblNarudzba);

		
		// Dugme (alatka) IZVJEŠTAJI i njegova labela naziva
		

		btnIzvjestaji.setIcon(new ImageIcon(new ImageIcon("files/icons/izvjestaj.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		btnIzvjestaji.setActionCommand("izvjestaji");
		btnIzvjestaji.setBackground(boja_kontrola);
		btnIzvjestaji.setPreferredSize(dimenzije_alatki);
		pnlAlatke.add(btnIzvjestaji);
		
		lblIzvjestaji.setVerticalAlignment(SwingConstants.TOP);
		lblIzvjestaji.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblIzvjestaji.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzvjestaji.setForeground(Color.LIGHT_GRAY);
		lblIzvjestaji.setPreferredSize(dimenzije_labela);
		pnlLabele.add(lblIzvjestaji);
		
		
		// Dugme (alatka) NAJAM i njegova labela naziva
		
		btnNajam.setIcon(new ImageIcon(new ImageIcon("files/icons/najam.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		btnNajam.setActionCommand("najam");
		btnNajam.setBackground(boja_kontrola);
		btnNajam.setPreferredSize(dimenzije_alatki);
		pnlAlatke.add(btnNajam);

		lblNajam.setVerticalAlignment(SwingConstants.TOP);
		lblNajam.setHorizontalAlignment(SwingConstants.CENTER);
		lblNajam.setForeground(Color.LIGHT_GRAY);
		lblNajam.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNajam.setPreferredSize(dimenzije_labela);
		pnlLabele.add(lblNajam);
		
		
		// Dugme (alatka) PRIMJEDBE i njegova labela naziva
	

		btnPrimjedbe.setIcon(new ImageIcon(new ImageIcon("files/icons/zalbe.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		btnPrimjedbe.setActionCommand("primjedbe");
		btnPrimjedbe.setBackground(boja_kontrola);
		btnPrimjedbe.setPreferredSize(dimenzije_alatki);
		pnlAlatke.add(btnPrimjedbe);
		
		lblPrimjedbe.setVerticalAlignment(SwingConstants.TOP);
		lblPrimjedbe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimjedbe.setForeground(Color.LIGHT_GRAY);
		lblPrimjedbe.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPrimjedbe.setPreferredSize(dimenzije_labela);
		pnlLabele.add(lblPrimjedbe);
	
		
		// Dugme (alatka) DNEVNI MENI i njegova labela naziva
		
		btnDnevniMeni.setIcon(new ImageIcon(new ImageIcon("files/icons/dnevniMeni.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		btnDnevniMeni.setActionCommand("dnevni_meni");
		btnDnevniMeni.setPreferredSize(dimenzije_alatki);
		btnDnevniMeni.setBackground(boja_kontrola);
		pnlAlatke.add(btnDnevniMeni);

		lblDnevniMeni.setVerticalAlignment(SwingConstants.TOP);
		lblDnevniMeni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDnevniMeni.setForeground(Color.LIGHT_GRAY);
		lblDnevniMeni.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDnevniMeni.setPreferredSize(dimenzije_labela);
		pnlLabele.add(lblDnevniMeni);

		
		// Dugme (alatka) DAGAĐAJI i njegova labela naziva
		
		btnNarudzbeNajma.setIcon(new ImageIcon(new ImageIcon("files/icons/narudzbeNajma.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		btnNarudzbeNajma.setActionCommand("narudzbe_najma");
		btnNarudzbeNajma.setPreferredSize(dimenzije_alatki);
		btnNarudzbeNajma.setBackground(boja_kontrola);
		//pnlAlatke.add(btnNarudzbeNajma);
		
		lblNarudzbeNajma.setVerticalAlignment(SwingConstants.TOP);
		lblNarudzbeNajma.setPreferredSize(dimenzije_labela);
		lblNarudzbeNajma.setHorizontalAlignment(SwingConstants.CENTER);
		lblNarudzbeNajma.setForeground(Color.LIGHT_GRAY);
		lblNarudzbeNajma.setFont(new Font("Times New Roman", Font.BOLD, 11));
		//pnlLabele.add(lblNarudzbeNajma);
		
		
		// Dugme (alatka) DODAJ ARTIKAL i njegova labela naziva
		
		btnDodajArtikal.setIcon(new ImageIcon(new ImageIcon("files/icons/dodajArtikal.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		btnDodajArtikal.setActionCommand("dodaj_artikal");
		btnDodajArtikal.setPreferredSize(dimenzije_alatki);
		btnDodajArtikal.setBackground(boja_kontrola);
		pnlAlatke.add(btnDodajArtikal);
		
		lblDodajArtikal.setVerticalAlignment(SwingConstants.TOP);
		lblDodajArtikal.setPreferredSize(dimenzije_labela);
		lblDodajArtikal.setHorizontalAlignment(SwingConstants.CENTER);
		lblDodajArtikal.setForeground(Color.LIGHT_GRAY);
		lblDodajArtikal.setFont(new Font("Times New Roman", Font.BOLD, 11));
		pnlLabele.add(lblDodajArtikal);
				
		
		// Dugme (alatka) ZAPOSLENI i njegova labela naziva
		
		btnKadar.setIcon(new ImageIcon(new ImageIcon("files/icons/kadar.png").getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH)));
		btnKadar.setActionCommand("kadar");
		btnKadar.setPreferredSize(dimenzije_alatki);
		btnKadar.setBackground(boja_kontrola);
		pnlAlatke.add(btnKadar);
		
		lblKadar.setVerticalAlignment(SwingConstants.TOP);
		lblKadar.setPreferredSize(dimenzije_labela);
		lblKadar.setHorizontalAlignment(SwingConstants.CENTER);
		lblKadar.setForeground(Color.LIGHT_GRAY);
		lblKadar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		pnlLabele.add(lblKadar);
		
		
		// Panel informacija o organizacionoj jedinici i ulogovanom korisniku		
		
		JPanel pnlInfo = new JPanel();
		pnlInfo.setBorder(new TitledBorder(new LineBorder(new Color(80,80,80), 1, true), null, TitledBorder.LEADING, TitledBorder.TOP, new Font("Times New Roman", Font.BOLD, 11), new Color(255, 255, 255)));
		pnlInfo.setBackground(boja_pozadine);
		pnlInfo.setPreferredSize(new Dimension(600, 150)); 
		
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 4;
		contentPanel.add(pnlInfo, gbc_lblInfo);
		
		// Labela koja sadrzi logo organizacione jedinice/poslovnog sistema
		
		JLabel lblLogo = new JLabel(new ImageIcon(new ImageIcon("files/icons/logo.png").getImage().getScaledInstance(180, 130, java.awt.Image.SCALE_SMOOTH)));
		lblLogo.setPreferredSize(new Dimension(180, 130));
		
		// Labele koja sadrzi podatke o organizacionoj jedinici i ulogovanom korisniku		
		
		lblNaziv = new JLabel("PICERIJA ZLATNO ZRNO BR.1");
		lblNaziv.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaziv.setForeground(Color.LIGHT_GRAY);
		lblNaziv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNaziv.setPreferredSize(new Dimension(250, 150));
		
		lblAdresa = new JLabel("Adresa:  Nikole Tesle 37B, Banjaluka");
		lblAdresa.setPreferredSize(new Dimension(250, 150));
		lblAdresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresa.setForeground(Color.LIGHT_GRAY);
		lblAdresa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblTelefon = new JLabel("Telefon: +38765123123");
		lblTelefon.setPreferredSize(new Dimension(250, 150));
		lblTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefon.setForeground(Color.LIGHT_GRAY);
		lblTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblKorisnickoIme = new JLabel("Ulogovani ste kao:  mandic19");
		lblKorisnickoIme.setPreferredSize(new Dimension(250, 150));
		lblKorisnickoIme.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorisnickoIme.setForeground(Color.LIGHT_GRAY);
		lblKorisnickoIme.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblTipNaloga = new JLabel("Tip naloga: Konobar");
		lblTipNaloga.setPreferredSize(new Dimension(250, 150));
		lblTipNaloga.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipNaloga.setForeground(Color.LIGHT_GRAY);
		lblTipNaloga.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		inicjalizacijaKorisnika();

		
		GroupLayout gl_pnlInfo = new GroupLayout(pnlInfo);
		gl_pnlInfo.setHorizontalGroup(
			gl_pnlInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfo.createSequentialGroup()
					.addGap(39)
					.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_pnlInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTipNaloga, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNaziv, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdresa, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefon, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKorisnickoIme, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnlInfo.setVerticalGroup(
			gl_pnlInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlInfo.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_pnlInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlInfo.createSequentialGroup()
							.addComponent(lblNaziv, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAdresa, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addComponent(lblTelefon, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addGap(15)
							.addComponent(lblKorisnickoIme, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTipNaloga, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlInfo.createSequentialGroup()
							.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
							.addGap(10))))
		);
		pnlInfo.setLayout(gl_pnlInfo);
		}
	
	// Dodavanje MouseListenera na alatke unutar panela alatki
	
	public void addToolsMouseListener(MouseListener mouseActionListener) {
		
		btnIzvjestaji.addMouseListener(mouseActionListener);
		btnDodajArtikal.addMouseListener(mouseActionListener);
		btnNarudzbeNajma.addMouseListener(mouseActionListener);
		btnNajam.addMouseListener(mouseActionListener);
		btnDnevniMeni.addMouseListener(mouseActionListener);
		btnNarudzba.addMouseListener(mouseActionListener);
		btnPrimjedbe.addMouseListener(mouseActionListener);
		btnCijenovnik.addMouseListener(mouseActionListener);
		btnKadar.addMouseListener(mouseActionListener);
	}
	
	public void setToolsLabelChanges(JButton alatka, Font font, Color boja)
	{
		switch(alatka.getActionCommand())
		{
		case "cjenovnik":
			
			 lblCjenovnik.setFont(font);
			 lblCjenovnik.setForeground(boja);
			 break;
		case "izvjestaji":

			 lblIzvjestaji.setFont(font);
			 lblIzvjestaji.setForeground(boja);
			 break;
			 
		case "najam":
			
			 lblNajam.setFont(font);
			 lblNajam.setForeground(boja);
			 break;
			 
		case "narudzba":

			 lblNarudzba.setFont(font);
			 lblNarudzba.setForeground(boja);
			 break;
			 
		case "dnevni_meni":
			
			 lblDnevniMeni.setFont(font);
			 lblDnevniMeni.setForeground(boja);
			 break;
			 
		case "primjedbe":

			 lblPrimjedbe.setFont(font);
			 lblPrimjedbe.setForeground(boja);
			 break;
			 
		case "dodaj_artikal":
			
			lblDodajArtikal.setFont(font);
			 lblDodajArtikal.setForeground(boja);
			 break;
			 
		case "narudzbe_najma":

			 lblNarudzbeNajma.setFont(font);
			 lblNarudzbeNajma.setForeground(boja);
			 break;
		
		case "kadar":
			
			 lblKadar.setFont(font);
			 lblKadar.setForeground(boja);
			 break;
		}
		 
	}
	
	
	// Metode za setovanje sadrzaja labela INFO panela (naziv restorana, adresa, telefon, korisnicko ime, tip naloga)
	
	public void setNazivOrganizacioneJedinice(String naziv)
	{
		lblNaziv.setText(naziv);
	}

	public void setAdresuOrganizacioneJedinice(String adresa)
	{
		lblAdresa.setText("Adresa: "+adresa);
	}
	
	public void setTelefonOrganizacioneJedinice(String telefon)
	{
		lblTelefon.setText("Telefon: "+telefon);
	}
	
	public void setKorisnickoIme(String korisnik)
	{
		lblKorisnickoIme.setText("Korisnicko ime: "+korisnik);
	}
	
	public void setTipNaloga(String tip)
	{
		lblTipNaloga.setText("Tip naloga: "+tip);
	}

	private void inicjalizacijaKorisnika()
	{
		switch(loginModel.TipNaloga)
		{
		case "C":
			lblCjenovnik.setVisible(false);
			btnCijenovnik.setVisible(false);
			lblIzvjestaji.setVisible(false);
			btnIzvjestaji.setVisible(false);
			lblNajam.setVisible(false);
			btnNajam.setVisible(false);
			lblNarudzba.setVisible(false);
			btnNarudzba.setVisible(false);
			lblKadar.setVisible(false);
			btnKadar.setVisible(false);
			lblPrimjedbe.setVisible(false);
			btnPrimjedbe.setVisible(false);
			btnDodajArtikal.setVisible(true);
			lblDodajArtikal.setVisible(true);
			btnDnevniMeni.setVisible(true);
			lblDnevniMeni.setVisible(true);
			break;
		case "W":
			lblCjenovnik.setVisible(false);
			btnCijenovnik.setVisible(false);
			lblIzvjestaji.setVisible(false);
			btnIzvjestaji.setVisible(false);
			lblNajam.setVisible(false);
			btnNajam.setVisible(false);
			lblNarudzba.setVisible(true);
			btnNarudzba.setVisible(true);
			lblKadar.setVisible(false);
			btnKadar.setVisible(false);
			lblPrimjedbe.setVisible(true);
			btnPrimjedbe.setVisible(true);
			btnDodajArtikal.setVisible(false);
			lblDodajArtikal.setVisible(false);
			btnDnevniMeni.setVisible(false);
			lblDnevniMeni.setVisible(false);
			break;
		case "M":
			lblCjenovnik.setVisible(true);
			btnCijenovnik.setVisible(true);
			lblIzvjestaji.setVisible(true);
			btnIzvjestaji.setVisible(true);
			lblNajam.setVisible(true);
			btnNajam.setVisible(true);
			lblNarudzba.setVisible(false);
			btnNarudzba.setVisible(false);
			lblKadar.setVisible(true);
			btnKadar.setVisible(true);
			lblPrimjedbe.setVisible(false);
			btnPrimjedbe.setVisible(false);
			btnDodajArtikal.setVisible(false);
			lblDodajArtikal.setVisible(false);
			btnDnevniMeni.setVisible(false);
			lblDnevniMeni.setVisible(false);
			break;
		}
		
		setNazivOrganizacioneJedinice(loginModel.NazivRestorana);
		setAdresuOrganizacioneJedinice(loginModel.AdresaRestorana+", "+loginModel.Grad);
		setTelefonOrganizacioneJedinice(loginModel.TelefonRestorana);
		setKorisnickoIme(loginModel.KorisnickoIme);
		setTipNaloga(loginModel.NazivTipa);
	}
	
	public void addClosingListener(WindowListener listener)
	{
		this.addWindowListener(listener);
	}
	
}
