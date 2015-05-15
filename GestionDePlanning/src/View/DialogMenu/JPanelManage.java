package View.DialogMenu;


import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import Controler.DaysAbstractControler;
import Obs.DaysObserver;

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
