package View.Elements;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.CalendarObject.Day;
import Model.CalendarObject.Module;
import Model.CalendarObject.Seance;

public class DayPanel extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridLayout seancesLayout;
	
	public DayPanel(Day day, int hgap, int vgap){
		if(day != null){
			seancesLayout = new GridLayout(2,1);
			seancesLayout.setHgap(hgap); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
			seancesLayout.setVgap(vgap); //Cinq pixels d'espace entre les lignes (V comme Vertical)
			this.setLayout(seancesLayout);
			
			for(int i = 0; i < 2; i++){
	    		if(day.getHoliday())
	    			this.add(new JPanel(),i);
	    		else if(this.getSeance(day, i) == null)
	    			this.add(new SeancePanel(),i);
	    		else
	    			this.add(new SeancePanel(this.getSeance(day,i)),i);
	    	}
		}
	}
    private Seance getSeance(Day day, int position){
    	Seance seance = null;
    	if(position==0)
    		seance = day.getMorning();
    	else if(position==1)
    		seance = day.getAfternoon();
    	return seance;
    }

	public static void main(String[] args){
		JFrame f = new JFrame();
	    Module m1 = new Module("Anglais", Color.GREEN,"Champroux",12);
	    Module m2 = new Module("Reseau", Color.RED,"Pl",10);
		Day d = new Day("Mardi",2,52,11,2015,false);
		d.setAfternoon(new Seance(m1));
		d.setMorning(new Seance(m2));
		f.add(new DayPanel(d,5,5));
		f.setVisible(true);
	}
}