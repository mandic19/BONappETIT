package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import controller.menuBarController;
import controller.toolbarController;
import net.miginfocom.swing.MigLayout;

public class reportsView extends JFrame
{

	private JLabel lblIzvjestaji = new JLabel("Izaberite izvještaj: ");
	private JComboBox<String> cmbIzvjestaji;
	private JPanel naslovnaLinija = new JPanel();
	private String[] izvjestaji = {"","Aktuelni cjenovnik", "Prihodi poslovanja", "Platna lista"};
	private JButton btnGenerisiIzvjestaj = new JButton("Generiši");
	private JLabel lblDatumPocetka = new JLabel("Od: *");
	private JDateChooser datumPocetka = new JDateChooser();
	private JLabel lblDatumZavrsetka = new JLabel("Do: *");
	private JDateChooser datumZavrsetka = new JDateChooser();
	private JPanel pnlDatumi = new JPanel();
	private menuBar meni = new menuBar();
	
	public reportsView() 
	{
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));
		this.setTitle("BONappETIT - Izvještaji");
		this.setMinimumSize(new Dimension(400, 150));
		this.setSize(400, 150);
		this.setLocationRelativeTo(null);
		naslovnaLinija.setLayout(new BorderLayout());
		cmbIzvjestaji = new JComboBox(izvjestaji);
		cmbIzvjestaji.setFont(new Font("Arial",Font.PLAIN,13));
		((JLabel)cmbIzvjestaji.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		lblIzvjestaji.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzvjestaji.setFont(new Font("Arial",Font.BOLD,17));
		naslovnaLinija.add(lblIzvjestaji, BorderLayout.PAGE_START);
		naslovnaLinija.add(cmbIzvjestaji, BorderLayout.CENTER);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(naslovnaLinija, BorderLayout.PAGE_START);
		
	    btnGenerisiIzvjestaj.setPreferredSize(new Dimension(80, 30));
	    btnGenerisiIzvjestaj.setEnabled(false);
	    btnGenerisiIzvjestaj.setActionCommand("generisi");
	    getContentPane().add(btnGenerisiIzvjestaj, BorderLayout.PAGE_END);
	   
	    Calendar calendar = Calendar.getInstance();

		Date danasnji = calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		danasnji = calendar.getTime();

		datumPocetka.setPreferredSize(new Dimension(130,25));
		datumPocetka.setDateFormatString("dd/MM/yyyy");
		datumPocetka.setMaxSelectableDate(danasnji);

		datumZavrsetka.setPreferredSize(new Dimension(130,25));
		datumZavrsetka.setMaxSelectableDate(danasnji);
		datumZavrsetka.setDateFormatString("dd/MM/yyyy");
		pnlDatumi.setLayout(new MigLayout("center center"));
		pnlDatumi.add(new JLabel(), "wrap 25");
		pnlDatumi.add(lblDatumPocetka, "wrap 5");
		pnlDatumi.add(datumPocetka, "wrap 20");
		pnlDatumi.add(lblDatumZavrsetka, "wrap 5");
		pnlDatumi.add(datumZavrsetka, "wrap 20");
		pnlDatumi.setVisible(false);
		getContentPane().add(pnlDatumi, BorderLayout.CENTER);
	}
	
	public void addActionListener(ActionListener listener)
	{
		cmbIzvjestaji.addActionListener(listener);
	}
	public void addClickListener(ActionListener listener)
	{
		btnGenerisiIzvjestaj.addActionListener(listener);
	}
	public void deaktivirajDugme()
	{
		btnGenerisiIzvjestaj.setEnabled(false);
	}
	public void aktivirajDugme()
	{
		btnGenerisiIzvjestaj.setEnabled(true);
	}
	public int getSelectedIzvjestaj()
	{
		return cmbIzvjestaji.getSelectedIndex();
	}
	public void setpnlDatumiVisible()
	{
		this.setSize(400, 300);
		pnlDatumi.setVisible(true);
	}
	public void setpnlDatumiInvisible()
	{
		pnlDatumi.setVisible(false);
		this.setSize(400, 150);
	}
	public Date getDatumPocetka()
	{
		return datumPocetka.getDate();
	}
	public Date getDatumZavrsetka()
	{
		return datumZavrsetka.getDate();
	}
	public boolean validnostUnosa()
	{
		if(datumPocetka.getDate()!=null && datumZavrsetka.getDate()!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
