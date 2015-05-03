package View.DialogMenu;


import javax.swing.JPanel;

import Controler.DaysAbstractControler;

public class JPanelManage extends JPanel{

	protected DaysAbstractControler daysControler;
	
	protected String title;
	public String getTitle(){
		return title;
	}
	

	 public JPanelManage(DaysAbstractControler daysControler, String title){
		 this.daysControler=daysControler;
		 this.title = title;
	 }
}
