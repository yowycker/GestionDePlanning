package View.Elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controler.DaysAbstractControler;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;

public class JButtonSeances extends JButton implements ActionListener{
	private DaysAbstractControler daysControler;
	private Day day;

    public JButtonSeances(String text, DaysAbstractControler daysControler,Formation currentFormation, String currentModule, Day day, int position){
    	this.setText(text);
    	this.daysControler = daysControler;
    	this.day = day;
    	System.out.println(currentModule);
    	if(day.getFormationSeances(currentFormation.getTitle()).getSeance(position) == null){
    		
    	}
    	else if(day.getFormationSeances(currentFormation.getTitle()).getSeance(position).getModule().getName() == currentModule)
    	{
    		this.setBackground(day.getFormationSeances(currentFormation.getTitle()).getSeance(position).getModule().getColor());
    	}
    	else{
    		this.setForeground(day.getFormationSeances(currentFormation.getTitle()).getSeance(position).getModule().getColor());
    		this.setEnabled(true);
    	}
    	this.addActionListener(this);
    }

	public void actionPerformed(ActionEvent even) {
		if(this.day.getHoliday())
			daysControler.modifyHoliday(false, day);
		else
			daysControler.modifyHoliday(true, day);
	}
	
}
