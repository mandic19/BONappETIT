package view;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import controller.menuBarController;
import controller.toolbarController;
import net.miginfocom.swing.MigLayout;

public class kadrovskaView extends JFrame{
	
	private JScrollPane scrollPanel;
	private JScrollPane scrollIstorija;
	private JTable table;
	private JTable tableIstorijaRadnika;
	private JTextField txtIme = null;
	private JTextField txtPrezime = null;
	private JTextField txtOznaka = null;
	private JTextField txtPlata = null;
	private JTextField txtAdresa = null;
	private JTextField txtTel = null;
	private JComboBox cmbSmjena = null;
	private JComboBox cmbRadnoMjesto = null;
	private JComboBox cmbTipRadOdnosa = null;
	private JButton btnSpremi = null;
	private JPanel rightPanel = null;
	private toolbarView toolbar = null;
	private int position=-1;
	
	
	private Dimension dimenzijaLabel = new Dimension(150, 20);
	private Dimension dimenzijaComboBox = new Dimension(200, 20);
	private Dimension dimenzijaTextField = new Dimension(200, 25);		
	private Font fontLabela = new Font("Arial", Font.PLAIN, 14);
	private CallableStatement procStmt = null;
	
	public kadrovskaView() {
		
		setTitle("BONappETIT - Kadrovska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1050, 600));
		setSize(1050, 600);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("files/icons/restoran.png"));
		
		// Postavljamo BorderLayout JFramea sa marginom 20 horiz. i 10 vert.
		
		setLayout(new BorderLayout(2,5));
		
		// Komponente desnog JPanela labele, textboxovi, cmboxovi
		
		JLabel title = new JLabel("Podaci o zaposlenom: ");
		title.setFont(new Font("Arial", Font.PLAIN, 22));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblIme = new JLabel("Ime: *");
		lblIme.setPreferredSize(dimenzijaLabel);
		lblIme.setFont(fontLabela);
		JLabel lblPrezime = new JLabel("Prezime: *");
		lblPrezime.setPreferredSize(dimenzijaLabel);
		lblPrezime.setFont(fontLabela);
		JLabel lblOznaka = new JLabel("Oznaka: *");
		lblOznaka.setPreferredSize(dimenzijaLabel);
		lblOznaka.setFont(fontLabela);
		JLabel lblRadnoMjesto = new JLabel("Radno mjesto: *");
		lblRadnoMjesto.setPreferredSize(dimenzijaLabel);
		lblRadnoMjesto.setFont(fontLabela);
		JLabel lblSmjena = new JLabel("Smjena: *");
		lblSmjena.setPreferredSize(dimenzijaLabel);
		lblSmjena.setFont(fontLabela);
		JLabel lblTipRadOdnosa = new JLabel("Tip radnog odnosa: *");
		lblTipRadOdnosa.setPreferredSize(dimenzijaLabel);
		lblTipRadOdnosa.setFont(fontLabela);
		JLabel lblPlata = new JLabel("Plata: *");
		lblPlata.setPreferredSize(dimenzijaLabel);
		lblPlata.setFont(fontLabela);
		JLabel lblAdresa = new JLabel("Adresa stanovanja: ");
		lblAdresa.setPreferredSize(dimenzijaLabel);
		lblAdresa.setFont(fontLabela);
		JLabel lblTel = new JLabel("Telefon: ");
		lblTel.setPreferredSize(dimenzijaLabel);
		lblTel.setFont(fontLabela);
	    txtIme = new JTextField();
		txtIme.setPreferredSize(dimenzijaTextField);
		txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dimenzijaTextField);
		txtOznaka = new JTextField();
		txtOznaka.setPreferredSize(dimenzijaTextField);
		cmbRadnoMjesto = new JComboBox();
		cmbRadnoMjesto.setPreferredSize(dimenzijaComboBox);
		cmbSmjena = new JComboBox();
		cmbSmjena.setPreferredSize(dimenzijaComboBox);
		Object[] items = new Object[] {"","Stalni radni odnos", "Privremeni radni odnos"};
		cmbTipRadOdnosa = new JComboBox(items);
		cmbTipRadOdnosa.setPreferredSize(dimenzijaComboBox);
		txtPlata = new JTextField();
		txtPlata.setPreferredSize(dimenzijaTextField);
		txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dimenzijaTextField);
		txtTel = new JTextField();
		txtTel.setPreferredSize(dimenzijaTextField);
		
		rightPanel = new JPanel();
		
		rightPanel.setLayout(new MigLayout("align center top"));
		
		rightPanel.add(title,"span, grow, wrap 60");
		rightPanel.add(lblIme);
		rightPanel.add(txtIme, "wrap");
		rightPanel.add(lblPrezime);
		rightPanel.add(txtPrezime,"wrap");	
		rightPanel.add(lblOznaka);
		rightPanel.add(txtOznaka, "wrap 40");
		rightPanel.add(lblRadnoMjesto);
		rightPanel.add(cmbRadnoMjesto,  "span, grow, wrap 20");
		rightPanel.add(lblSmjena);
		rightPanel.add(cmbSmjena, "wrap");		
		rightPanel.add(lblTipRadOdnosa);
		rightPanel.add(cmbTipRadOdnosa, "wrap 10");
		rightPanel.add(lblPlata);
		rightPanel.add(txtPlata, "wrap 40");
		rightPanel.add(lblAdresa);
		rightPanel.add(txtAdresa,"span, grow, wrap 20");	
		rightPanel.add(lblTel);
		rightPanel.add(txtTel);	
		
		btnSpremi = new JButton("Spremi");
		btnSpremi.setFont(fontLabela);
		btnSpremi.setActionCommand("spremi");
		rightPanel.add(btnSpremi,"span, grow, gap unrelated, wrap");

		scrollPanel = new JScrollPane(table);
		menuBar menu = new menuBar();
	    menuBarController mbc = new menuBarController(menu, this);
	    toolbar = new toolbarView();
		toolbarController tbc = new toolbarController(toolbar, this);
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout());
		menuPanel.add(menu, BorderLayout.PAGE_START);
		menuPanel.add(toolbar, BorderLayout.CENTER);
		
	    add(menuPanel, BorderLayout.PAGE_START);
	    add(scrollPanel, BorderLayout.CENTER);
		add(rightPanel, BorderLayout.EAST);

	}
	
	
	public void setScrollPanel(JTable tbl)
	{
		table=tbl;
		table.setDefaultEditor(Object.class, null);						// Ne dozvoljava editovanje celija tabele
	    table.setRowHeight(25);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);			
        table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        table.getTableHeader().setReorderingAllowed(false);					// Ne dozvoljavamo prevlacenje kolona u JTable
        table.removeColumn( table.getColumnModel().getColumn(6));			// Sakriva kolonu ali i dalje mozes pristupiti podacima
        table.removeColumn( table.getColumnModel().getColumn(7));
        table.removeColumn( table.getColumnModel().getColumn(6));
		scrollPanel.getViewport().add(table);
	}
	public void setIstorijaScroll(JTable tbl)
	{
		tableIstorijaRadnika=tbl;
		tableIstorijaRadnika.setDefaultEditor(Object.class, null);						// Ne dozvoljava editovanje celija tabele
		tableIstorijaRadnika.setRowHeight(25);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);	
        tableIstorijaRadnika.getColumnModel().getColumn(0).setMaxWidth(30);
        tableIstorijaRadnika.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        tableIstorijaRadnika.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        tableIstorijaRadnika.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tableIstorijaRadnika.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tableIstorijaRadnika.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tableIstorijaRadnika.getTableHeader().setReorderingAllowed(false);				// Ne dozvoljavamo prevlacenje kolona u JTable
        scrollIstorija=new JScrollPane(tableIstorijaRadnika);
        this.remove(scrollPanel);
        this.add(scrollIstorija, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
        
        toolbar.disableComponents();
	}
	
	public void setTableRadnik()
	{
		 this.remove(scrollIstorija);
	     this.add(scrollPanel, BorderLayout.CENTER);
	     this.revalidate();
	     this.repaint();
	     
	     toolbar.enableComponents();
	}
	
	public void setIme(String string)
	{
		txtIme.setText(string);
	}
	
	public void setPrezime(String string)
	{
		txtPrezime.setText(string);
	}

	public void setOznaka(String string)
	{
		txtOznaka.setText(string);
	}

	public void setPlata(String string)
	{
		txtPlata.setText(string);
	}
	
	public void setAdresa(String string)
	{
		txtAdresa.setText(string);
	}
	
	public void setTelefon(String string)
	{
		txtTel.setText(string);
	}
	
	public void setListSmjene(Object[]  smjene)
	{
		for(int i=0; i<smjene.length; i++)
		{
		cmbSmjena.addItem(smjene[i]);
		}
	}
	
	public void setListRadnaMjesta(Object[]  radnaMjesta)
	{
		for(int i=0; i<radnaMjesta.length; i++)
		{
		cmbRadnoMjesto.addItem(radnaMjesta[i]);
		}
	}

	public void setSmjena(int index)
	{
		cmbSmjena.setSelectedIndex(index);
	}
	
	public int getSmjena()
	{
		return cmbSmjena.getSelectedIndex()-1;
	}

	public void setRadnoMjesto(int index)
	{
		cmbRadnoMjesto.setSelectedIndex(index);
	}

	public int getRadnoMjesto()
	{
		return cmbRadnoMjesto.getSelectedIndex()-1;
	}
	
	public void setRadniOdnos(int index)

	{
		cmbTipRadOdnosa.setSelectedIndex(index);
	}

	public String getRadniOdnos()
	{
		return cmbTipRadOdnosa.getSelectedItem().toString();
	}
	
	public void addSelectionListener(ListSelectionListener selectListener) 
	{
		table.getSelectionModel().addListSelectionListener(selectListener);
	}

	public void addActionListener(ActionListener clickListener, MouseListener clickTable) 
	{
		btnSpremi.addActionListener(clickListener);
		table.addMouseListener(clickTable);
		toolbar.btnDelete.addActionListener(clickListener);
	}

	public String getOznaka()
	{
	return txtOznaka.getText();
	}
	
	public String getIme()
	{
	return txtIme.getText();
	}
	
	public String getPrezime()
	{
	return txtPrezime.getText();
	}
	
	public String getPlata()
	{
		return txtPlata.getText();
	}
	
	public String getAdresa()
	{
	return txtAdresa.getText();
	}
	
	public String getTelefon()
	{
	return txtTel.getText();
	}

	public void disableComponents()
	 {
		  txtIme.setEditable(false);
		  txtPrezime.setEditable(false);
		  txtPlata.setEditable(false);
		  txtAdresa.setEditable(false);
		  txtTel.setEditable(false);
		  txtOznaka.setEditable(false);
		  cmbRadnoMjesto.setEnabled(false);
		  cmbSmjena.setEnabled(false);
		  cmbTipRadOdnosa.setEnabled(false);
		  btnSpremi.setEnabled(false);
	 }
	
	public void enableComponents()
	 {
		  txtIme.setEditable(true);
		  txtPrezime.setEditable(true);
		  txtPlata.setEditable(true);
		  txtAdresa.setEditable(true);
		  txtTel.setEditable(true);
		  txtOznaka.setEditable(true);
		  cmbRadnoMjesto.setEnabled(true);
		  cmbSmjena.setEnabled(true);
		  cmbTipRadOdnosa.setEnabled(true);
		  btnSpremi.setEnabled(true);
	 }
	
    public void setEditMode()
	 {
	  
      txtIme.setEditable(false);
	  txtPrezime.setEditable(false);
	  txtOznaka.setEditable(false);
	  btnSpremi.setActionCommand("izmijeni");
	  toolbar.btnDelete.setEnabled(true);
		  if(btnSpremi.getText().equals("Dodaj"))
		  {
			  txtPlata.setEditable(true);
			  txtAdresa.setEditable(true);
			  txtTel.setEditable(true);
			  cmbRadnoMjesto.setEnabled(true);
			  cmbSmjena.setEnabled(true);
			  cmbTipRadOdnosa.setEnabled(true);
			  btnSpremi.setEnabled(true);
		  }
		  else
		  {
			  txtPlata.setEditable(!txtPlata.isEditable());
			  txtAdresa.setEditable(!txtAdresa.isEditable());
			  txtTel.setEditable(!txtTel.isEditable());
			  cmbRadnoMjesto.setEnabled(!cmbRadnoMjesto.isEnabled());
			  cmbSmjena.setEnabled(!cmbSmjena.isEnabled());
			  cmbTipRadOdnosa.setEnabled(!cmbTipRadOdnosa.isEnabled());
			  btnSpremi.setEnabled(!btnSpremi.isEnabled());
		  }
	  btnSpremi.setText("Izmijeni");
		 
	 }

    public void setAddMode()
	 {
		 
		  clearRightPanel();
		  cmbRadnoMjesto.setSelectedIndex(0);
		  cmbSmjena.setSelectedIndex(0);
		  cmbTipRadOdnosa.setSelectedIndex(0);
		  btnSpremi.setActionCommand("dodaj");
		  toolbar.btnDelete.setEnabled(false);
		  
		  if(!txtOznaka.isEditable())
		  {
		  enableComponents();
		  }
		  else
		  {
			  disableComponents();
		  }
		  btnSpremi.setText("Dodaj");
	 }

    public toolbarView getToolbar()
	 {
		 return toolbar;
	 }

    public void selectFirstRow()
    {
    	position=0;

    	table.setRowSelectionInterval(position,position);
    }
 
    public void selectLastRow()
    {
    	position=table.getRowCount()-1;
    	table.setRowSelectionInterval(position,position);
    }
  
    public void selectNextRow()
    {
    	position=table.getSelectedRow();
    	if(position!=table.getRowCount()-1 && position!=-1)
    	{
    	position=position+1;
    	}
    	else
    	{
    		position=0;
    	}
    	table.setRowSelectionInterval(position,position);

    }

    public void selectPrevRow()
    {
    	position=table.getSelectedRow();
    	if(position!=0 && position!=-1)
    	{
    	position=position-1;
    	}
    	else
    	{
    		position=table.getRowCount()-1;
    	}
    	table.setRowSelectionInterval(position,position);
    }
    
    public boolean popunjenaObaveznaPolja()
    {
    	if(!txtIme.getText().isEmpty() && !txtPrezime.getText().isEmpty() && !txtPlata.getText().isEmpty() && !txtOznaka.getText().isEmpty() && cmbRadnoMjesto.getSelectedIndex()>0 && cmbTipRadOdnosa.getSelectedIndex()>0 && cmbSmjena.getSelectedIndex()>0)
    	{
    		try
    		{
    			Double plata = Double.parseDouble(txtPlata.getText());
    		}
    		catch(Exception exc)
    		{
    			JOptionPane.showMessageDialog(null, "Pogresan unos u polje Plata !!","Greska !",JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
    		return true;
    	}
    	JOptionPane.showMessageDialog(null, "Popunite sva obavezna polja !!","Greska !",JOptionPane.ERROR_MESSAGE);
    	return false;
    	
    }
    
    public void clearRightPanel()
    {
    	  txtIme.setText(null);
		  txtPrezime.setText(null);
		  txtOznaka.setText(null);
		  txtPlata.setText(null);
		  txtAdresa.setText(null);
		  txtTel.setText(null);
		  cmbRadnoMjesto.setSelectedIndex(0);
		  cmbSmjena.setSelectedIndex(0);
		  cmbTipRadOdnosa.setSelectedIndex(0);
    }
    
   
}
