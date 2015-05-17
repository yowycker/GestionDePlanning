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
	private Formation currentFormation;
	private String currentModule;
	private String emailTeacher;
	private int position;
	private Day day;

    public JButtonSeances(String text, DaysAbstractControler daysControler,Formation currentFormation, String currentModule, String emailTeacher, Day day, int position){
    	this.setText(text);
    	this.daysControler = daysControler;
    	this.currentFormation = currentFormation;
    	this.currentModule = currentModule;
    	this.emailTeacher = emailTeacher;
    	this.position = position;
    	this.day = day;
    	if(day.getFormationSeances(currentFormation.getTitle()).getSeance(position) == null){
    		
    	}
    	else if(day.getFormationSeances(currentFormation.getTitle()).getSeance(position).getModule().getName() == currentModule)
    	{
    		this.setBackground(day.getFormationSeances(currentFormation.getTitle()).getSeance(position).getModule().getColor());
    	}
    	else{
    		this.setEnabled(false);
    		this.setBackground(day.getFormationSeances(currentFormation.getTitle()).getSeance(position).getModule().getColor());
    	}
    	this.addActionListener(this);
    }

	public void actionPerformed(ActionEvent even) {
		if(day.getFormationSeances(currentFormation.getTitle()).getSeance(position) == null)
			daysControler.addSeances(currentFormation.getModule(currentModule), emailTeacher, day, position);
		else
			daysControler.removeSeance(currentFormation.getModule(currentModule), day, position);
	}
	
}
