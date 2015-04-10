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
	JLabel maxSeances = new JLabel();

	public SeancePanel(){
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public SeancePanel(Seance seance){
		if(seance != null){
			color= seance.getModule().getColor();
			
			name.setText(seance.getModule().getName());
			teacher.setText(seance.getModule().getTeacher());
			numSeance.setText(Integer.toString(seance.getNumSeance()));
			maxSeances.setText(Integer.toString(seance.getModule().getMaxSeances()));
			
	        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			this.add(name);
			this.add(teacher);
			this.add(numSeance);
			this.add(maxSeances);
		}
	}

	public void paintComponent(Graphics g){
	    g.setColor(color);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}