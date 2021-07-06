package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.menuBarController;
import controller.toolbarController;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Date;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

public class MenadzerZakupSaleView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtTelefon;
	private JTextField txtAdresa;
	private JButton btnOdbaci;
	private JPanel controlPanel;
	public String pocetakDogadjaja;
	public String zavrsetakDogadjaja;
	private String tipDogadjaja;
	private JTextArea txtInformacijeZakup;
	private JButton btnZavrsi;
	private JLabel lblCijenaPoMjestu;
	private JTextField txtCijenaPoMjestu;
	private JLabel lblCijenaZakupa;
	private float CijenaZakupa;


	public MenadzerZakupSaleView() {
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1050, 600));
		this.setSize(1050, 600);
		this.setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BONappETIT - Zakup sale");
		contentPane = new JPanel(new BorderLayout());
		contentPane.setSize(new Dimension(800, 500));
		contentPane.setPreferredSize(new Dimension(800, 500));

		getContentPane().add(contentPane);
		
		/////////////////////////////LEFT PFNEL/////////////////////////////
		
		JPanel leftpanel = new JPanel();
		//leftpanel.setBackground(Color.LIGHT_GRAY);
		leftpanel.setSize(new Dimension(300, 500));
		leftpanel.setPreferredSize(new Dimension(300,500));

		contentPane.add(leftpanel,BorderLayout.LINE_START);
		leftpanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		
		JLabel lblInformacijeOZakupcu = new JLabel("Informacije o zakupcu :");
		leftpanel.add(lblInformacijeOZakupcu, "2, 2");
		
		JLabel lblIme = new JLabel("Ime* :");
		leftpanel.add(lblIme, "2, 6, right, default");
		
		txtIme = new JTextField();
		leftpanel.add(txtIme, "4, 6, fill, top");
		txtIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime * :");
		leftpanel.add(lblPrezime, "2, 8, right, default");
		
		txtPrezime = new JTextField();
		leftpanel.add(txtPrezime, "4, 8, fill, top");
		txtPrezime.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon* :");
		leftpanel.add(lblTelefon, "2, 10, right, default");
		
		txtTelefon = new JTextField();
		leftpanel.add(txtTelefon, "4, 10, fill, default");
		txtTelefon.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa :");
		leftpanel.add(lblAdresa, "2, 12, right, default");
		
		txtAdresa = new JTextField();
		leftpanel.add(txtAdresa, "4, 12, fill, default");
		txtAdresa.setColumns(10);
		
		JLabel lblInformacijeOZakupu = new JLabel("Informacije o zakupu :");
		leftpanel.add(lblInformacijeOZakupu, "2, 16");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		leftpanel.add(scrollPane_1, "2, 17, 3, 14, fill, fill");
		
		txtInformacijeZakup = new JTextArea();
		txtInformacijeZakup.setEditable(false);
		scrollPane_1.setViewportView(txtInformacijeZakup);
		
		lblCijenaPoMjestu = new JLabel("Cijena po mjestu :");
		leftpanel.add(lblCijenaPoMjestu, "2, 32, right, default");
		
		txtCijenaPoMjestu = new JTextField();
		leftpanel.add(txtCijenaPoMjestu, "4, 32, fill, default");
		txtCijenaPoMjestu.setColumns(10);
		txtCijenaPoMjestu.setText("0");
		
		lblCijenaZakupa = new JLabel("Cijena zakupa :");
		lblCijenaZakupa.setFont(new Font("Arial Black", Font.PLAIN, 14));
		leftpanel.add(lblCijenaZakupa, "2, 34, 3, 1");
		
		btnZavrsi = new JButton("Zavr\u0161i");
		btnZavrsi.setPreferredSize(new Dimension(61, 30));
		leftpanel.add(btnZavrsi, "2, 38, fill, bottom");
		
		btnOdbaci = new JButton("Odbaci");
		btnOdbaci.setPreferredSize(new Dimension(61, 30));
		leftpanel.add(btnOdbaci, "4, 38, fill, bottom");
		
		/////////////////////////////RIGHT PANEL/////////////////////////////
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(500, 1000));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		controlPanel = new JPanel(new FlowLayout());
		controlPanel.setPreferredSize(new Dimension(500,1000));
		
		JPanel pnlBar = new JPanel();
		pnlBar.setLayout(new BorderLayout());
		toolbarView toolbar = new toolbarView();
		toolbarController tlbControler = new toolbarController(toolbar, this);
		menuBar menubarView = new menuBar();
		menuBarController menubarCont = new menuBarController(menubarView, this);
		pnlBar.add(menubarView, BorderLayout.PAGE_START);
		pnlBar.add(toolbar, BorderLayout.CENTER);
		contentPane.add(pnlBar, BorderLayout.PAGE_START);
		
		
		scrollPane.setViewportView(controlPanel);
		
	}
	
	public void setCijenaZakupa(float CijenaZakupa) {
		
		this.CijenaZakupa=CijenaZakupa;
	}
	
	public String getImeZakupca() {
		
		return txtIme.getText();
	}
	
	public String getPrezimeZakupca() {
		
		return txtPrezime.getText();
	}
	
	public String getTelefonZakupca() {
		
		return txtTelefon.getText();
	}
	
	public String getAdresaZakupca() {
		
		return txtAdresa.getText();
	}
	
	public String getCijenaPoMjestu() {
		
		return txtCijenaPoMjestu.getText();
	}
	
	public void setlblCijenaZakupa(String ukupnaCijena)
	{
		lblCijenaZakupa.setText("Cijena zakupa : "+ukupnaCijena+"KM");
	}
	
	public void addCijenaPoMjestuActionListener(ActionListener cijenaPoMjestuActionListner) {
		
		txtCijenaPoMjestu.addActionListener(cijenaPoMjestuActionListner);
	}
	public void addOdbaciListener(ActionListener odbaciActionListener) {
		
		btnOdbaci.addActionListener(odbaciActionListener);
	}
	
	public void popuniRightPanel(MenadzerSalaKontrola Sala) {
		
		controlPanel.add(Sala);
	}
	
	public void setPocetakDogadjaja(String pocetakDogadjaja) {
		
		
		this.pocetakDogadjaja= pocetakDogadjaja;
	}
	
	public void setZavrsetakDogadjaja(String zavrsetakDogadjaja) {
		
		this.zavrsetakDogadjaja= zavrsetakDogadjaja;
	}
	
	public void setTipDogadjaja(String tipDogadjaja) {
		
		this.tipDogadjaja= tipDogadjaja;
	}
	
	public void setInformacijeZakup(String informacije) {
		
		this.txtInformacijeZakup.setText(informacije);
	}
	
	public void addZavrsiNarudzbuActionListener(ActionListener zavrsiNarudzbuActionListener) {
		
		btnZavrsi.addActionListener(zavrsiNarudzbuActionListener);
	}
	
	public String getTipDogadjaja()
	{
		return tipDogadjaja;
	}
	
	public float getCijenaZakupa() {
		
		return CijenaZakupa;
	}
	public void addClosingListener(WindowListener listener)
	{
		this.addWindowListener(listener);
	}
}
