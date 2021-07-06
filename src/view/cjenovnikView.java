package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import controller.menuBarController;
import controller.toolbarController;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;


public class cjenovnikView extends JFrame
{
	private menuBar menuBar = new menuBar();
	private menuBarController menuBarCont = new menuBarController(menuBar, this);
	private toolbarView toolbar = new toolbarView();
	private toolbarController toolbarController = new toolbarController(toolbar, this);
	private JPanel barPanel = new JPanel();
	private JTable tableCjenovnik = new JTable();
	private JScrollPane scrollCjenovnik;
	private JTable tableAsortiman = new JTable();
	private JScrollPane scrollAsortiman;

	private JPanel pnlUnosArtikla = null;

	private JLabel lblNaziv = new JLabel("Naziv: *");
	private JTextField txtNaziv = new JTextField();
	private JLabel lblTipMenija = new JLabel("Tip menija: *");
	private JTextField txtTipMenija = new JTextField();
	
	
	private JLabel lblOznaka = new JLabel("Oznaka: *");
	private JTextField txtOznaka = new JTextField();
	private JLabel lblCijena = new JLabel("Cijena: *");
	private JTextField txtCijena = new JTextField();
	
	private JLabel lblDatumPocetka = new JLabel("Datum početka: *");
	private JDateChooser datumPocetka = new JDateChooser();
	private JLabel lblDatumZavrsetka = new JLabel("Datum završetka: ");
	private JDateChooser datumZavrsetka = new JDateChooser();
	
	private JButton btnSpremi = new JButton("Spremi");
	private int position=-1;
	
	public cjenovnikView()
	{
		// Podesavanja osnovnog JFramea
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));
		this.setTitle("BONappETIT - Cjenovnik");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1050, 600));
		this.setSize(1050, 600);
		this.setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		barPanel.setLayout(new BorderLayout());
		barPanel.add(menuBar, BorderLayout.PAGE_START);
		barPanel.add(toolbar, BorderLayout.CENTER);
		getContentPane().add(barPanel, BorderLayout.PAGE_START);
		
		
		//Cjenovnik
		
		tableCjenovnik.setDefaultEditor(Object.class, null);						// Ne dozvoljava editovanje celija tabele
		tableCjenovnik.setRowHeight(25);
		tableCjenovnik.getTableHeader().setReorderingAllowed(false);				// Ne dozvoljavamo prevlacenje kolona u JTable

		scrollCjenovnik = new JScrollPane(tableCjenovnik);
		JPanel pnlCjenovnik = new JPanel();
		pnlCjenovnik.setLayout(new BorderLayout());
		pnlCjenovnik.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "Aktuelni cjenovnik", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 15), Color.black));
		pnlCjenovnik.add(scrollCjenovnik, BorderLayout.CENTER);
		
		// Asortiman artikala
		
		tableAsortiman.setDefaultEditor(Object.class, null);						// Ne dozvoljava editovanje celija tabele
		tableAsortiman.setRowHeight(25);

		tableAsortiman.getTableHeader().setReorderingAllowed(false);				// Ne dozvoljavamo prevlacenje kolona u JTable
		scrollAsortiman = new JScrollPane(tableAsortiman);
		JPanel pnlAsortiman = new JPanel();
		pnlAsortiman.setLayout(new BorderLayout());
		pnlAsortiman.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "Asortiman artikala", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 15), Color.black));
		pnlAsortiman.add(scrollAsortiman, BorderLayout.CENTER);
		
		
		
		// Panel za kreiranje ponude cjenovnika
		
		pnlUnosArtikla = new JPanel(new MigLayout("center, center"));
		pnlUnosArtikla.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "Unos u Cjenovnik", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 15), Color.black));

		txtNaziv.setPreferredSize(new Dimension(150,25));
		txtNaziv.setEditable(false);
		txtCijena.setPreferredSize(new Dimension(150,25));
		txtOznaka.setPreferredSize(new Dimension(50,25));
		txtOznaka.setEditable(false);
		txtTipMenija.setPreferredSize(new Dimension(150,25));
		txtTipMenija.setEditable(false);
		btnSpremi.setPreferredSize(new Dimension(100, 25));
		
		Calendar calendar = Calendar.getInstance();

		Date danasnji = calendar.getTime();
		
		
		datumPocetka.setMinSelectableDate(danasnji);
		datumPocetka.setPreferredSize(new Dimension(130,25));
		datumPocetka.setDateFormatString("dd/MM/yyyy");
		
		datumZavrsetka.setEnabled(false);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		danasnji = calendar.getTime();


		datumZavrsetka.setPreferredSize(new Dimension(130,25));
		datumZavrsetka.setDateFormatString("dd/MM/yyyy");
		btnSpremi.setActionCommand("spremi");
		
		pnlUnosArtikla.add(lblNaziv);
		pnlUnosArtikla.add(txtNaziv, "span, grow, wrap 20");
		pnlUnosArtikla.add(lblTipMenija);
		pnlUnosArtikla.add(txtTipMenija);
		pnlUnosArtikla.add(lblOznaka,"gap unrelated");
		pnlUnosArtikla.add(txtOznaka, "wrap 20");
		pnlUnosArtikla.add(lblDatumPocetka);
		pnlUnosArtikla.add(datumPocetka, "wrap 10");
		pnlUnosArtikla.add(lblDatumZavrsetka);
		pnlUnosArtikla.add(datumZavrsetka, "wrap 10");
		pnlUnosArtikla.add(lblCijena);
		pnlUnosArtikla.add(txtCijena);
		pnlUnosArtikla.add(btnSpremi,"span, grow");
		
		JPanel groupPanel = new JPanel();
		getContentPane().add(groupPanel, BorderLayout.CENTER);

		GroupLayout gl_groupPanel = new GroupLayout(groupPanel);
		gl_groupPanel.setHorizontalGroup(
			gl_groupPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_groupPanel.createSequentialGroup()
					.addComponent(pnlAsortiman, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlUnosArtikla, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlCjenovnik, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_groupPanel.setVerticalGroup(
			gl_groupPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_groupPanel.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_groupPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlAsortiman, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addComponent(pnlCjenovnik, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(pnlUnosArtikla, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
					.addGap(55))
		);
		groupPanel.setLayout(gl_groupPanel);
	}

	public void setTableAsortiman(JTable tbl)
	{
		tableAsortiman=tbl;
		tableAsortiman.removeColumn(tableAsortiman.getColumnModel().getColumn(0));
		tableAsortiman.removeColumn(tableAsortiman.getColumnModel().getColumn(0));
		tableAsortiman.setDefaultEditor(Object.class, null);					     	// Ne dozvoljava editovanje celija tabele
		tableAsortiman.setRowHeight(23);
		tableAsortiman.getColumnModel().getColumn(0).setMaxWidth(50);
        tableAsortiman.getTableHeader().setReorderingAllowed(false);					// Ne dozvoljavamo prevlacenje kolona u JTable
		scrollAsortiman.setViewportView(tableAsortiman);
	}
	
	public void setTableCjenovnik(JTable tbl)
	{
		tableCjenovnik=tbl;
		tableCjenovnik.removeColumn(tableCjenovnik.getColumnModel().getColumn(0));
		tableCjenovnik.removeColumn(tableCjenovnik.getColumnModel().getColumn(0));
		tableCjenovnik.removeColumn(tableCjenovnik.getColumnModel().getColumn(0));
		tableCjenovnik.removeColumn(tableCjenovnik.getColumnModel().getColumn(0));
		tableCjenovnik.removeColumn(tableCjenovnik.getColumnModel().getColumn(0));
		tableCjenovnik.removeColumn(tableCjenovnik.getColumnModel().getColumn(0));
		tableCjenovnik.removeColumn(tableCjenovnik.getColumnModel().getColumn(1));
		tableCjenovnik.removeColumn(tableCjenovnik.getColumnModel().getColumn(3));
		
		TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		    public Component getTableCellRendererComponent(JTable table,
		            Object value, boolean isSelected, boolean hasFocus,
		            int row, int column) {
		        if( value instanceof Date) {
		            value = dateFormat.format(value);
		        }
		        return super.getTableCellRendererComponent(table, value, isSelected,
		                hasFocus, row, column);
		    }
		};
		
		
		tableCjenovnik.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Važi do");
        tableCjenovnik.getColumnModel().getColumn(1).setCellRenderer(tableCellRenderer);
		tableCjenovnik.setDefaultEditor(Object.class, null);					     	// Ne dozvoljava editovanje celija tabele
		tableCjenovnik.setRowHeight(23);
		tableCjenovnik.getColumnModel().getColumn(1).setMaxWidth(200);
		tableCjenovnik.getColumnModel().getColumn(2).setMaxWidth(50);
		tableCjenovnik.getTableHeader().setReorderingAllowed(false);					// Ne dozvoljavamo prevlacenje kolona u JTable
		scrollCjenovnik.setViewportView(tableCjenovnik);
	}
	
	public String getClickedNaziv()
	{
		return tableAsortiman.getValueAt(tableAsortiman.getSelectedRow(), 1).toString();
	}
	
	public String getClickedOznaka()
	{
		return tableAsortiman.getValueAt(tableAsortiman.getSelectedRow(), 0).toString();
	}
	
	public void setNaziv(String naziv)
	{
		txtNaziv.setText(naziv);
	}

	public void setOznaka(String oznaka)
	{
		txtOznaka.setText(oznaka);
	}

	public void setTipMenija(String naziv)
	{
		txtTipMenija.setText(naziv);
	}

	public void addSelectionListener(ListSelectionListener listener)
	{
		 tableAsortiman.getSelectionModel().addListSelectionListener(listener);
	}

	public void addActionListener(ActionListener listener)
	{
		 btnSpremi.addActionListener(listener);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		 datumPocetka.addPropertyChangeListener(listener);
	}
	
	public int getClickedIndex()
	{
		return tableAsortiman.getSelectedRow();
	}
	
	public Date getDatumPocetka()
	{
		return datumPocetka.getDate();
	}
	
	public void setDatumZavrsetka(Date datum)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(datum);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		datum = cal.getTime();
		
		datumZavrsetka.setEnabled(true);
		datumZavrsetka.setMinSelectableDate(datum);

	}

	public Date getDatumZavrsetka()
	{
		return datumZavrsetka.getDate();
	}

	public String getCijena()
	{
		return txtCijena.getText();
	}

	public boolean validnostUnosa()
	{
		if(!txtCijena.getText().isEmpty() && datumPocetka.getDate()!=null && !txtNaziv.getText().isEmpty() && !txtOznaka.getText().isEmpty() && !txtTipMenija.getText().isEmpty())
		{
			try
			{
				Double.parseDouble(txtCijena.getText());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Pogresan format unosa u polju Cijena !!", "Greska !", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
		JOptionPane.showMessageDialog(null, "Popunite sva polja !!", "Greska !", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	public void selectFirstRow()
	    {
	    	position=0;

	    	tableAsortiman.setRowSelectionInterval(position,position);
	    }
	 
    public void selectLastRow()
    {
    	position=tableAsortiman.getRowCount()-1;
    	tableAsortiman.setRowSelectionInterval(position,position);
    }
  
    public void selectNextRow()
    {
    	position=tableAsortiman.getSelectedRow();
    	if(position!=tableAsortiman.getRowCount()-1 && position!=-1)
    	{
    	position=position+1;
    	}
    	else
    	{
    		position=0;
    	}
    	tableAsortiman.setRowSelectionInterval(position,position);

    }

    public void selectPrevRow()
	    {
	    	position=tableAsortiman.getSelectedRow();
	    	if(position!=0 && position!=-1)
	    	{
	    	position=position-1;
	    	}
	    	else
	    	{
	    		position=tableAsortiman.getRowCount()-1;
	    	}
	    	tableAsortiman.setRowSelectionInterval(position,position);
	    }
}
