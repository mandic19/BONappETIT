package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.omg.CORBA.COMM_FAILURE;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public class dodajArtikalView extends JFrame{
	
	
	
	
	private JFrame frmDodajArtikal;
	private JTextField TxtNaziv;
	private JTextField TxtOznaka;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_5;
	JPanel panel_1 = new JPanel();
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JButton button = new JButton("SAVE");
	JCheckBox checkBox = new JCheckBox("Novi tip menija");
	
	JList list = new JList();
	DefaultListModel model=new DefaultListModel<>();
	DefaultComboBoxModel modelChb=new DefaultComboBoxModel<>();
	
	
	
	public JTextField getTextField_8() {
		return textField_8;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}


	public DefaultComboBoxModel getModelChb() {
		return modelChb;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public JButton getButton() {
		return button;
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}


	public JList getList() {
		return list;
	}

	public DefaultListModel getModel() {
		return model;
	}

	public dodajArtikalView() {
		
		frmDodajArtikal = new JFrame();
		frmDodajArtikal.setTitle("BONappETIT - Dodaj artikal");
		frmDodajArtikal.setBounds(100, 100, 962, 668);
	//	frmDodajArtikal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodajArtikal.setVisible(true);
		
		frmDodajArtikal.setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));
		
		frmDodajArtikal.setMinimumSize(new Dimension(1050, 600));
		frmDodajArtikal.setSize(1050, 600);
		frmDodajArtikal.setLocationRelativeTo(null);
		
		comboBox.setToolTipText("\r\n");
		comboBox.setActionCommand("combo");
	
		
		
		JLabel label = new JLabel("Tip menija:");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Artikli", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		
		button.setBackground(Color.WHITE);
		button.setActionCommand("save");
		
		JLabel lblDodajNoviArtikal = new JLabel("Dodaj novi artikal");
		lblDodajNoviArtikal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Dodaj arikal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		GroupLayout groupLayout = new GroupLayout(frmDodajArtikal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(83)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(72))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDodajNoviArtikal, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
									.addGap(28))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(167))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDodajNoviArtikal))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(45)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
					.addGap(41))
		);

		panel_1.setVisible(false);
		JLabel label_1 = new JLabel("Naziv");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel label_3 = new JLabel("Izaberite tip menja");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		list.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		

		checkBox.setActionCommand("chb");
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBackground(Color.LIGHT_GRAY);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBackground(Color.LIGHT_GRAY);
		
	
		
		JLabel label_6 = new JLabel(":");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel label_7 = new JLabel(":");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_8 = new JLabel("Naziv");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(24, 13, 52, 20);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBackground(Color.LIGHT_GRAY);
		label_9.setBounds(66, 13, 10, 20);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel(":");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(77, 13, 17, 20);
		panel_1.add(label_10);
		
		TxtNaziv = new JTextField();
		TxtNaziv.setEnabled(false);
		TxtNaziv.setColumns(10);
		TxtNaziv.setBounds(92, 13, 116, 22);
		panel_1.add(TxtNaziv);
		
		JLabel label_11 = new JLabel("Oznaka");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(24, 64, 61, 20);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_12.setBackground(Color.LIGHT_GRAY);
		label_12.setBounds(179, 64, 10, 20);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("(jedan karakter)");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_13.setBounds(86, 65, 93, 20);
		panel_1.add(label_13);
		
		TxtOznaka = new JTextField();
		TxtOznaka.setEnabled(false);
		TxtOznaka.setColumns(10);
		TxtOznaka.setBounds(201, 64, 52, 22);
		panel_1.add(TxtOznaka);
		
		JLabel label_14 = new JLabel(":");
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_14.setBackground(Color.LIGHT_GRAY);
		label_14.setBounds(189, 67, 10, 20);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("Proizvodjac:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel label_16 = new JLabel("Godina proizvodnje:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblGodina = new JLabel("Godina:");
		lblGodina.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(145)
					.addComponent(checkBox, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
					.addGap(117))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addGap(140))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addGap(73))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(12)
											.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
									.addGap(5)
									.addComponent(comboBox_1, 0, 130, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(42)
											.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addGap(1)
									.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
									.addGap(101)))
							.addGap(79)))
					.addGap(29))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(57)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(2)))
					.addGap(20)
					.addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE))
						.addComponent(textField_8, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		panel.setLayout(gl_panel);
		
		
		scrollPane.setViewportView(list);
		
	
		frmDodajArtikal.getContentPane().setLayout(groupLayout);
		
		
	}
	
public JTextField getTxtNaziv() {
		return TxtNaziv;
	}

	public void setTxtNaziv(JTextField txtNaziv) {
		TxtNaziv = txtNaziv;
	}

	public JTextField getTxtOznaka() {
		return TxtOznaka;
	}

	public void setTxtOznaka(JTextField txtOznaka) {
		TxtOznaka = txtOznaka;
	}

public void addMouseAndItemListener(MouseListener mouseActionListener,ActionListener l) {
		
		button.addMouseListener(mouseActionListener);
		
		checkBox.addActionListener(l);
		comboBox.addActionListener(l);
		
		
	}

}
