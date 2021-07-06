package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class loginView extends JFrame
{
	private JPanel pnlLoginInfo = new JPanel();
	private JComboBox<String> cmbOrgJedinice = new JComboBox<>();
	private JLabel lblOrgJedinice = new JLabel("Izaberite organizacionu jedinicu: *");
	private JLabel lblImage = new JLabel();
	private JLabel lblUsername = new JLabel("Username: *");
	private JTextField txtUsername = new JTextField();
	private JLabel lblPassword = new JLabel("Password: *");
	private JPasswordField txtPassword = new JPasswordField();
	private JButton btnLogin = new JButton("Log in");
	
	
	public loginView() 
	{
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));
		this.setTitle("BONappETIT - Log in");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new BorderLayout());
		
		txtUsername.setPreferredSize(new Dimension(200, 35));
		txtPassword.setPreferredSize(new Dimension(200, 35));
		cmbOrgJedinice.setPreferredSize(new Dimension(200, 25));
		btnLogin.setPreferredSize(new Dimension(150, 35));
		lblImage.setIcon(new ImageIcon(new ImageIcon("files/icons/lock.png").getImage().getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH)));
		
		pnlLoginInfo.setLayout(new MigLayout("center, center"));
		
		pnlLoginInfo.add(lblImage, "span 1 7, gapright 50");			// Span ovu celiju 1x7 (1 kolona 7 redova) i stavlja marginu od naredne kolone na 50px
		pnlLoginInfo.add(lblOrgJedinice, "wrap");
		pnlLoginInfo.add(cmbOrgJedinice, "wrap 20");
		pnlLoginInfo.add(lblUsername, "wrap 5");
		pnlLoginInfo.add(txtUsername, "wrap 5");
		pnlLoginInfo.add(lblPassword, "wrap 5");
		pnlLoginInfo.add(txtPassword, "wrap 20");
		pnlLoginInfo.add(btnLogin);
		
		this.add(pnlLoginInfo, BorderLayout.CENTER);

	}
	
	public void setcmbOrgJedNaziv(String[] objects)
	{
		cmbOrgJedinice.addItem("");
		for(int i = 0; i<objects.length; i++)
		{
			cmbOrgJedinice.addItem(objects[i]);
		}
	}
	public void addComboActionListener(ActionListener listener)
	{
		cmbOrgJedinice.addActionListener(listener);
	}
	
	public void addClickListener(ActionListener listener)
	{
		btnLogin.addActionListener(listener);
	}
	
	public boolean validnostUnosa()
	{
		if(!txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty() && cmbOrgJedinice.getSelectedIndex()!=0)
		{
			return true;
		}

		JOptionPane.showMessageDialog(null, "Popunite sva obavezna polja !!", "Greška !", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	public String getUsername()
	{
		return txtUsername.getText();
	}
	public String getPassword()
	{
		return String.valueOf(txtPassword.getPassword());
	}
	
}
