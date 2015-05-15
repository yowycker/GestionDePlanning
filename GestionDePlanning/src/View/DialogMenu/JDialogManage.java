package View.DialogMenu;

import java.awt.event.WindowAdapter;

import javax.swing.JDialog;

import com.sun.glass.events.WindowEvent;


public class JDialogManage extends JDialog{
	 public JDialogManage(){
	     
			this.setModal(true);
			//this.setLocation(400, 200);
			this.setLocationRelativeTo(null);
		    this.setSize(600, 400);
		    /*this.addWindowListener(new WindowAdapter() 
		    {
		      public void windowClosed(WindowEvent e)
		      {
		        System.out.println("jdialog window closed event received");
		      }
		     
		      public void windowClosing(WindowEvent e)
		      {
		        System.out.println("jdialog window closing event received");
		      }
		    });*/
		    this.addWindowListener(new WindowAdapter() {
				   public void windowClosing (WindowEvent e) {
					   System.out.println("salut bif");
					   dispose();
					   System.exit(0);
					   //Main.windowClosed();
				   }
				});
	 }
	 public void initialise(JPanelManage panelManage){
		 this.setContentPane(panelManage);
		 this.setTitle(panelManage.getTitle());
		 this.setVisible(true);
	 }
	 
	 
}