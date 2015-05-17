package View.Elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import Controler.DaysAbstractControler;
import Model.CalendarObject.Day;

public class JButtonDay extends JButton implements ActionListener{
	private DaysAbstractControler daysControler;
	private Day day;

    public JButtonDay(String text, DaysAbstractControler daysControler, Day day){
    	this.setText(text);
    	this.daysControler = daysControler;
    	this.day = day;
    	// Info bulle sur composants
    	this.addActionListener(this);
    }

	public void actionPerformed(ActionEvent even) {
		if(this.day.getHoliday())
			daysControler.modifyHoliday(false, day);
		else
			daysControler.modifyHoliday(true, day);
	}
	
}
