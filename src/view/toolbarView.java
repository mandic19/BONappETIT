
package view;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;



public class toolbarView extends JToolBar
{
 
  public JButton btnGoBack, btnFirst, btnLast, btnNext, btnPrev;
  public JButton btnAdd,btnEdit, btnDelete, btnBack;
  
   
   public toolbarView()
   {

		setRollover(true);
		setBorderPainted(true);
		//setFloatable(true);
		setOrientation(JToolBar.HORIZONTAL);
		
		Dimension btnDimension = new Dimension(30,30);
		addSeparator(new Dimension(3, 0));
		btnGoBack = new JButton();
		btnGoBack.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/goback.png")));
		btnGoBack.setPreferredSize(btnDimension);
		btnGoBack.setMinimumSize(btnDimension);
		btnGoBack.setMaximumSize(btnDimension);
		btnGoBack.setToolTipText("Go back");
		btnGoBack.setActionCommand("goBack");
		add(btnGoBack);
		
		addSeparator(btnDimension);
		
		btnFirst = new JButton();
		btnFirst.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/first.png")));
		btnFirst.setPreferredSize(btnDimension);
		btnFirst.setMinimumSize(btnDimension);
		btnFirst.setMaximumSize(btnDimension);
		btnFirst.setToolTipText("First row");
		btnFirst.setActionCommand("first");
		add(btnFirst);
		
		btnPrev = new JButton();
		btnPrev.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/prev.png")));
		btnPrev.setPreferredSize(btnDimension);
		btnPrev.setMinimumSize(btnDimension);
		btnPrev.setMaximumSize(btnDimension);
		btnPrev.setToolTipText("Previous row");
		btnPrev.setActionCommand("previous");
		add(btnPrev);
		
		btnNext = new JButton();
		btnNext.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/next.png")));
		btnNext.setPreferredSize(btnDimension);
		btnNext.setMinimumSize(btnDimension);
		btnNext.setMaximumSize(btnDimension);
		btnNext.setToolTipText("Next row");
		btnNext.setActionCommand("next");

		add(btnNext);
		
		btnLast = new JButton();
		btnLast.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/last.png")));
		btnLast.setPreferredSize(btnDimension);
		btnLast.setMinimumSize(btnDimension);
		btnLast.setMaximumSize(btnDimension);
		btnLast.setToolTipText("Last row");
		btnLast.setActionCommand("last");

		add(btnLast);
		
		addSeparator(btnDimension);
		
		btnAdd = new JButton();
		btnAdd.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/add.png")));
		btnAdd.setPreferredSize(btnDimension);
		btnAdd.setMinimumSize(btnDimension);
		btnAdd.setMaximumSize(btnDimension);
		btnAdd.setToolTipText("Add row");
		btnAdd.setActionCommand("newRow");
		add(btnAdd);
		
		btnEdit = new JButton();
		btnEdit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/edit.png")));
		btnEdit.setPreferredSize(btnDimension);
		btnEdit.setMinimumSize(btnDimension);
		btnEdit.setMaximumSize(btnDimension);
		btnEdit.setToolTipText("Edit row");
		btnEdit.setActionCommand("editRow");
		btnEdit.setEnabled(false);
		add(btnEdit);
		
		btnDelete = new JButton();
		btnDelete.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/delete.png")));
		btnDelete.setPreferredSize(btnDimension);
		btnDelete.setMinimumSize(btnDimension);
		btnDelete.setMaximumSize(btnDimension);
		btnDelete.setToolTipText("Delete row");
		btnDelete.setActionCommand("deleteRow");
		btnDelete.setEnabled(false);
		add(btnDelete);
		
		
		btnBack = new JButton();
		btnBack.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("files/icons/back.png")));
		btnBack.setPreferredSize(btnDimension);
		btnBack.setMinimumSize(btnDimension);
		btnBack.setMaximumSize(btnDimension);
		btnBack.setToolTipText("Go back");
		btnBack.setActionCommand("back");
		btnBack.setEnabled(false);
		add(btnBack);
		
		setFloatable(false);
	
   }
 
   public void addActionListener(ActionListener listener)
   {
	   btnFirst.addActionListener(listener);
	   btnPrev.addActionListener(listener);
	   btnNext.addActionListener(listener);
	   btnLast.addActionListener(listener);
	   btnAdd.addActionListener(listener);
	   btnEdit.addActionListener(listener);
	   btnDelete.addActionListener(listener);
	   btnBack.addActionListener(listener);
	   btnGoBack.addActionListener(listener);
   }
   public void disableComponents()
   {
	   this.btnAdd.setEnabled(false);
	   //this.btnDelete.setEnabled(false);
	   //this.btnEdit.setEnabled(false);
	   this.btnBack.setEnabled(true);
       this.btnFirst.setEnabled(false);
       this.btnNext.setEnabled(false);
       this.btnPrev.setEnabled(false);
       this.btnLast.setEnabled(false);
   }
  
   public void enableComponents()
   {
	   this.btnAdd.setEnabled(true);
	  // this.btnDelete.setEnabled(true);
	 //  this.btnEdit.setEnabled(true);
	   this.btnBack.setEnabled(false);
	   this.btnFirst.setEnabled(true);
	   this.btnNext.setEnabled(true);
	   this.btnPrev.setEnabled(true);
	   this.btnLast.setEnabled(true);
   }
}