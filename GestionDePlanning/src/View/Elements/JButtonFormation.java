package View.Elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controler.DaysAbstractControler;
import Model.CalendarObject.Day;

public class JButtonFormation extends JButton implements ActionListener{
	private DaysAbstractControler daysControler;

    public JButtonFormation(String text, DaysAbstractControler daysControler){
    	this.setText(text);
    	this.daysControler = daysControler;
    	this.setBackground(Color.WHITE);
    	this.setForeground(Color.DARK_GRAY);
    	this.addActionListener(this);
    }

	public void actionPerformed(ActionEvent even) {
		daysControler.selectFormation(this.getText());
	}
}
