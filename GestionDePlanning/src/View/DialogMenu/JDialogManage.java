package View.DialogMenu;


import javax.swing.JDialog;



public class JDialogManage extends JDialog{
	 public JDialogManage(){
	     
			this.setModal(true);
			//this.setLocation(400, 200);
			this.setLocationRelativeTo(null);
		    this.setSize(600, 400);
	 }
	 public void initialise(JPanelManage panelManage){
		 this.setContentPane(panelManage);
		 this.setTitle(panelManage.getTitle());
		 this.setVisible(true);
	 }
	 
	 
}