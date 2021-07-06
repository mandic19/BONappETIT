package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.menuBarController;
import datetime.DateLabelFormatter;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;

public class NovaRezervacijaDialog extends JDialog {
	
	private Date pocetakDogadjaja;
	private Date zavrsetakDogadjaja;
	private JDatePickerImpl datePicker2;
	private JDatePickerImpl datePicker;
	private JComboBox cmbBoxTipDogadjaja;
	private JButton btnZavrsi;
	private JButton btnOdbaci;
	public String NazivSale;
	
	private String nazivSale;
	private JTextArea txtPostojeceRezervacije; 
	private JTextField txtBrojMjesta;
	private int UkupanBrojMjestaSale;
	private String[] TipZakupaOznaka;
	private menuBar meni = new menuBar();
	public menuBarController contrMeni = new menuBarController(meni, this);
	
	/**
	 * Create the dialog.
	 */
	public NovaRezervacijaDialog() {
		setBounds(100, 100, 525, 414);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));
		setLocationRelativeTo(null);
		this.NazivSale = this.getTitle();
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnZavrsi = new JButton("Završi");
				btnZavrsi.setActionCommand("Završi");
				buttonPane.add(btnZavrsi);
				getRootPane().setDefaultButton(btnZavrsi);
			}
			{
				btnOdbaci = new JButton("Odbaci");
				btnOdbaci.setActionCommand("Odbaci");
				buttonPane.add(btnOdbaci);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,
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
					RowSpec.decode("default:grow"),}));
			{
				JLabel lblNewLabel = new JLabel("Nova rezervacija :");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel.add(lblNewLabel, "2, 2");
			}
			{
				JLabel lblPoetakDogaaja = new JLabel("Po\u010Detak doga\u0111aja :");
				panel.add(lblPoetakDogaaja, "2, 4, right, center");
			}
			{
				UtilDateModel model = new UtilDateModel();
				Properties p = new Properties();
				p.put("text.today", "Today");
				p.put("text.month", "Month");
				p.put("text.year", "Year");
				JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
				DateLabelFormatter dataform =new DateLabelFormatter();
				datePicker = new JDatePickerImpl(datePanel, dataform);
				panel.add(datePicker, "4, 4, left, center");
			}
			{
				JLabel lblZavretakDogaaja = new JLabel("Zavr\u0161etak doga\u0111aja :");
				panel.add(lblZavretakDogaaja, "2, 6, right, center");
			}
			{
			
				UtilDateModel model2 = new UtilDateModel();
				Properties p2 = new Properties();
				p2.put("text.today", "Today");
				p2.put("text.month", "Month");
				p2.put("text.year", "Year");
				JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
				DateLabelFormatter dataform2 =new DateLabelFormatter();
				datePicker2 = new JDatePickerImpl(datePanel2, dataform2);
				panel.add(datePicker2, "4, 6, left, center");
				
			}
			{
				JLabel lblTipDogaaja = new JLabel("Tip doga\u0111aja :");
				panel.add(lblTipDogaaja, "2, 8, right, center");
			}
			{
				cmbBoxTipDogadjaja = new JComboBox();
			//	cmbBoxTipDogadjaja.setModel(new DefaultComboBoxModel(new String[] {"Svadba", "Rodjendan", "Sastanak", "Ostalo"}));
				panel.add(cmbBoxTipDogadjaja, "4, 8, left, center");
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Broj mjesta :");
				lblNewLabel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
				panel.add(lblNewLabel_1, "2, 10, right, default");
			}
			{
				txtBrojMjesta = new JTextField();
				panel.add(txtBrojMjesta, "4, 10, left, default");
				txtBrojMjesta.setColumns(10);
			}
			{
				JLabel lblPostojeeRezervacije = new JLabel("Postoje\u0107e rezervacije :");
				lblPostojeeRezervacije.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel.add(lblPostojeeRezervacije, "2, 12");
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				panel.add(scrollPane, "4, 14, fill, fill");
				{
					txtPostojeceRezervacije = new JTextArea();
					txtPostojeceRezervacije.setEditable(false);
					scrollPane.setViewportView(txtPostojeceRezervacije);
				}
			}
		}
	}
	
	public void addOdbaciActionListener(ActionListener odbaciActionListener) {
		
		btnOdbaci.addActionListener(odbaciActionListener);
	}
	public void setCmbBoxTipDogadjaja(DefaultTableModel tablemodel) {
		
		String[] cmbBoxModel = new String[tablemodel.getRowCount()];
		TipZakupaOznaka = new String[tablemodel.getRowCount()];
		for(int i=0;i<tablemodel.getRowCount();i++)
		{
			cmbBoxModel[i]=tablemodel.getValueAt(i, 1).toString();
			TipZakupaOznaka[i]=tablemodel.getValueAt(i, 0).toString();
		}
		cmbBoxTipDogadjaja.setModel(new DefaultComboBoxModel(cmbBoxModel));
	}
	
	public String getTipZakupa() {
		
		return TipZakupaOznaka[cmbBoxTipDogadjaja.getSelectedIndex()];
	}
	
	public String getUneseniBrojMjesta() {
		
		return txtBrojMjesta.getText();
	}

	public String getPocetakDogadjaja(){
		
		String datum;
		datum =String.valueOf(datePicker.getModel().getDay())+"/"+String.valueOf(datePicker.getModel().getMonth()+1)+"/"+String.valueOf(datePicker.getModel().getYear())+" 00:00:00";
		return datum;
	}
	
	public String getZavrsetakDogadjaja(){
		
		String datum;
		datum =String.valueOf(datePicker2.getModel().getDay())+"/"+String.valueOf(datePicker2.getModel().getMonth()+1)+"/"+String.valueOf(datePicker2.getModel().getYear())+" 00:00:00";
		return datum;
	}
	
	public String getTipDogadjaja()
	{
		return cmbBoxTipDogadjaja.getSelectedItem().toString();
	}
	
	public void setPostojeceRezervacije(String rezervacije) {
		
		txtPostojeceRezervacije.setText(rezervacije);
	}
	
	public void addActionListenerZavrsi(ActionListener zavrsiActionListener) {
		
		btnZavrsi.addActionListener(zavrsiActionListener);
	}
}
