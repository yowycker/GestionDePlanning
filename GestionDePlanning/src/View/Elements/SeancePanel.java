package View.Elements;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.CalendarObject.Seance;


public class SeancePanel extends JPanel{

	Color color = Color.WHITE;;
	JLabel name = new JLabel();
	JLabel teacher = new JLabel();
	JLabel numSeance = new JLabel();

	public SeancePanel(){
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public SeancePanel(Seance seance){
		if(seance != null){
			color= seance.getModule().getColor();
			
			name.setText(seance.getModule().getName());
			numSeance.setText("Rang de la seance : " + Integer.toString(seance.getNumSeance() + 1) + " / " + Integer.toString(seance.getModule().getMaxSeances()));
			teacher.setText("Formateur : " + seance.getTeacher().getName());
			
	        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			this.add(name);
			this.add(teacher);
			this.add(numSeance);
		}
	}

	public void paintComponent(Graphics g){
	    g.setColor(color);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}