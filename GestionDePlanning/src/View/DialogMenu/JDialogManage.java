package View.DialogMenu;

import javax.swing.JDialog;


public class JDialogManage extends JDialog{
	 public JDialogManage(JPanelManageFormation panelManage){
		 this.setContentPane(panelManage);
	     
			this.setModal(true);
			this.setTitle("Gestion des Formations");
			this.setLocation(400, 200);
			this.setLocationRelativeTo(null);
		    this.setSize(600, 400);
		    this.setVisible(true);
	 }
}
