package view;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenadzerSalaKontrola extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String NazivSale, OrganizacionaJedinicaSale, TipPoslovnogSistema,KljucPoslovnogSistema,OznakaSale,BrojMjesta;


	
	public MenadzerSalaKontrola(String NazivSale, String BrojMjesta, String OpisSale, String OrganizacionaJedinicaSale, String TipPoslovnogSistema,
			String KljucPoslovnogSistema, String OznakaSale) {

		
		this.NazivSale=NazivSale;
		this.OrganizacionaJedinicaSale = OrganizacionaJedinicaSale;
		this.TipPoslovnogSistema= TipPoslovnogSistema;
		this.KljucPoslovnogSistema = KljucPoslovnogSistema;
		this.OznakaSale=OznakaSale;
		this.BrojMjesta=BrojMjesta;
		
		setBorder(new LineBorder(Color.BLACK, 2));
		
		this.setPreferredSize(new Dimension(700, 240));
		setLayout(new MigLayout());
		
		JLabel lblSlika = new JLabel(new ImageIcon("files\\icons\\logo.png"));
		add(lblSlika, "cell 0 0 8 9,growx,aligny top");
		
		JLabel lblNazivSale = new JLabel("Naziv sale : "+NazivSale);
		lblNazivSale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNazivSale, "cell 8 1 8 1");
		
		JLabel lblBrMjesta = new JLabel("Broj mjesta : "+BrojMjesta);
		lblBrMjesta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblBrMjesta, "cell 8 3,alignx left");
		
		JLabel lblOpisSale = new JLabel("Opis sale :");
		lblOpisSale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblOpisSale, "cell 8 5");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 8 6 8 4,grow");
		
		JTextArea txtOpisSale = new JTextArea();
		txtOpisSale.setEditable(false);
		txtOpisSale.setText(OpisSale);
		txtOpisSale.setPreferredSize(new Dimension(500, 250));
		scrollPane.setViewportView(txtOpisSale);
	
		}
	
		public void addmouseListener(MouseListener mouseListener) 
		{
			this.addMouseListener(mouseListener);
		}
		
		public String getBrojMjesta() 
		{
			return BrojMjesta;
		}
		
		public String getOznakaSale() {
			
			return OznakaSale;
		}
		
}
