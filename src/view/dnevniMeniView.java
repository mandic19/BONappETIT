package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import controller.menuBarController;
import controller.toolbarController;

public class dnevniMeniView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel frmDnevniMeni;
	private JTextField textProcent=new JTextField();

	JButton btnOk = new JButton();
	JButton  btnDodaj = new JButton("ADD=>");
	JButton btnRemove = new JButton("Remove");
	JButton btnNewButton = new JButton("Azuriraj");
	JList listGlavniMeni = new JList();
	DefaultListModel dlm2=new DefaultListModel<>();
	DefaultListModel dlm=new DefaultListModel<>();
	JList listDnevniMeni = new JList();
	JDateChooser dateChooser = new JDateChooser();
	JDateChooser dateChooser_1 = new JDateChooser();
	
	
	
	
	
	
	public JDateChooser getDateChooser_1() {
		return dateChooser_1;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}



	public JTextField getTextProcent() {
		return textProcent;
	}

	public void setTextProcent(JTextField textProcent) {
		this.textProcent = textProcent;
	}
	
	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public JButton getBtnDodaj() {
		return btnDodaj;
	}

	public void setBtnDodaj(JButton btnDodaj) {
		this.btnDodaj = btnDodaj;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public void setBtnRemove(JButton btnRemove) {
		this.btnRemove = btnRemove;
	}


	
	
	
	public JList getListDnevniMeni() {
		return listDnevniMeni;
	}

	public void setListDnevniMeni(JList listDnevniMeni) {
		this.listDnevniMeni = listDnevniMeni;
	}

	public DefaultListModel getDlm2() {
		return dlm2;
	}

	public void setDlm2(DefaultListModel dlm2) {
		this.dlm2 = dlm2;
	}

	public DefaultListModel getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel dlm) {
		this.dlm = dlm;
	}

	public JList getListGlavniMeni() {
		return listGlavniMeni;
	}

	public void setListGlavniMeni(JList listGlavniMeni) {
		this.listGlavniMeni = listGlavniMeni;
	}

	public dnevniMeniView() {
		
		frmDnevniMeni = new JPanel();
		this.setTitle("BONappETIT - Dnevni meni");
	
		this.setBounds(100, 100, 1093, 763);
		//frmDnevniMeni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1050, 600));
		this.setSize(1050, 600);
		this.setLocationRelativeTo(null);
		

		JLabel lblNewLabel = new JLabel("Glavni meni: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblDnevniMeni = new JLabel("Dnevni meni: ");
		lblDnevniMeni.setFont(new Font("Arial", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
	
		btnDodaj.setBackground(new Color(255, 255, 224));
		btnDodaj.setActionCommand("add");
		
		JLabel lblProcenatZaKoji = new JLabel("Procenat za koji se umanjuje cijena:");
		lblProcenatZaKoji.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblPonudaVaziOd = new JLabel("Ponuda vazi od");
		lblPonudaVaziOd.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblDo = new JLabel("do");
		lblDo.setFont(new Font("Dialog", Font.BOLD, 16));

		
		
		
		Date date2=new Date();
		dateChooser.setDate(date2);   
		
		
		
		
		
		

JScrollPane scrollPane_1 = new JScrollPane();
		
		
		listDnevniMeni.setBackground(new Color(255, 255, 255));
	
		listDnevniMeni.setFont(new Font("Consolas", Font.BOLD, 15));
		scrollPane_1.setViewportView(listDnevniMeni);
		
	
		
		btnRemove.setBackground(new Color(255, 255, 255));
		btnRemove.setActionCommand("remove");
		
		
		Icon img=new ImageIcon(new ImageIcon("files/icons/ok.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		btnOk.setIcon(img);
		
				btnOk.setActionCommand("ok");
				
				
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
				btnNewButton.setActionCommand("azuriraj");
			
				
				
				GroupLayout groupLayout = new GroupLayout(frmDnevniMeni);
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
									.addGap(39)
									.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblDnevniMeni, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
											.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(33))))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDnevniMeni, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(71))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addGap(466)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))))
									.addGap(38))))
				);
				
				
				
				scrollPane.setViewportView(listGlavniMeni);
				
				textProcent = new JTextField();
				textProcent.setColumns(10);
				GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
				gl_layeredPane.setHorizontalGroup(
					gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGap(11)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGap(308)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(Alignment.TRAILING, gl_layeredPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPonudaVaziOd, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_layeredPane.createSequentialGroup()
									.addGap(33)
									.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_layeredPane.createSequentialGroup()
							.addContainerGap(377, Short.MAX_VALUE)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_layeredPane.createSequentialGroup()
							.addGap(11)
							.addComponent(lblProcenatZaKoji, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textProcent, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addContainerGap())
				);
				gl_layeredPane.setVerticalGroup(
					gl_layeredPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_layeredPane.createSequentialGroup()
							.addGap(11)
							.addComponent(scrollPane_1, 150, 150, Short.MAX_VALUE)
							.addGap(9)
							.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProcenatZaKoji, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(textProcent, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_layeredPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPonudaVaziOd, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(42))
				);
				layeredPane.setLayout(gl_layeredPane);
				
				
				JPanel pnlBar = new JPanel();
				pnlBar.setLayout(new BorderLayout());
				toolbarView toolbar = new toolbarView();
				toolbarController tlbControler = new toolbarController(toolbar, this);
				menuBar menubarView = new menuBar();
				menuBarController menubarCont = new menuBarController(menubarView, this);
				pnlBar.add(menubarView, BorderLayout.PAGE_START);
				pnlBar.add(toolbar, BorderLayout.CENTER);
				frmDnevniMeni.setLayout(groupLayout);
				getContentPane().setLayout(new BorderLayout());
				getContentPane().add(frmDnevniMeni, BorderLayout.CENTER);
				getContentPane().add(pnlBar, BorderLayout.PAGE_START);
				listGlavniMeni.setFont(new Font("Consolas", Font.PLAIN, 15));
				
				
				
				
			
		
	}
	
	public void addMouseListener(MouseListener mouseActionListener) {
		
		btnOk.addMouseListener(mouseActionListener);
		btnDodaj.addMouseListener(mouseActionListener);
		btnRemove.addMouseListener(mouseActionListener);
		btnNewButton.addMouseListener(mouseActionListener);
		
	}
	

}
