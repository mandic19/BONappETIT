package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;


public class menuBar extends JMenuBar
{

	private JMenu file;
	private JMenu help;

	private JMenuItem exit;

	private JMenuItem about;

	public menuBar()
	{
		this.setBackground(new Color(230, 235, 240));
		this.setPreferredSize(new Dimension(getWidth(),30));
		Font font = new Font("Arial",Font.PLAIN, 14);
		Dimension dimenzija_JMenuItem = new Dimension(170,25);
		
		file = new JMenu("File");
		file.setFont(font);
		file.setHorizontalAlignment(SwingConstants.RIGHT);
		file.setVerticalAlignment(SwingConstants.CENTER);
		
	
		
		exit = new JMenuItem("Log out");
		exit.setHorizontalAlignment(SwingConstants.LEFT);
		exit.setFont(font);
		exit.setPreferredSize(dimenzija_JMenuItem);
		exit.setIcon(new ImageIcon(new ImageIcon("files/icons/exit.png").getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
		exit.setActionCommand("exit");
		file.addSeparator();
		file.add(exit);

		this.add(file);
		
		help = new JMenu("Help");
		help.setFont(font);
		help.setHorizontalAlignment(SwingConstants.RIGHT);
		help.setVerticalAlignment(SwingConstants.CENTER);

		about = new JMenuItem(" About");
		about.setFont(font);
		about.setPreferredSize(dimenzija_JMenuItem);
		about.setIcon(new ImageIcon(new ImageIcon("files/icons/about.png").getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_SMOOTH)));
		about.setHorizontalAlignment(SwingConstants.CENTER);

		about.setActionCommand("about");

		help.add(about);
		
		
		this.add(help);
	}
	
	public void addActionListener(ActionListener listener)
	{
		about.addActionListener(listener);
		exit.addActionListener(listener);
	}
}
