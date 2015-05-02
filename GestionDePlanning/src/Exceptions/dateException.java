package Exceptions;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class dateException extends Exception{
	private String title;
	public dateException(String title,String message){
	    super(message);
	    this.title = title;
System.out.println(message);
	}
	public void showDialogMessage(){
		JOptionPane.showMessageDialog(new JFrame(), this.getMessage(), title, JOptionPane.ERROR_MESSAGE);
//new WarningDateCalendar(this.title,this.getMessage());
	}
}