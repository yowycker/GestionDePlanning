package View.Elements;

import java.awt.GridLayout;

import javax.swing.JPanel;

import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Seance;

public class DayPanel extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridLayout seancesLayout;
	
	public DayPanel(Day day, int hgap, int vgap, Formation formation){
		if(day != null){
			seancesLayout = new GridLayout(2,1);
			seancesLayout.setHgap(hgap); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
			seancesLayout.setVgap(vgap); //Cinq pixels d'espace entre les lignes (V comme Vertical)
			this.setLayout(seancesLayout);
			
			for(int i = 0; i < 2; i++){
	    		if(day.getHoliday())
	    			this.add(new JPanel(),i);
	    		else if(day.getFormationSeances(formation.getTitle()).getSeance(i) == null)
	    			this.add(new SeancePanel(),i);
	    		else
	    			this.add(new SeancePanel(this.getSeance(day,i,formation)),i);
	    	}
		}
	}
    private Seance getSeance(Day day, int position, Formation formation){
    	Seance seance = null;
    	if(position==0)
    		seance = day.getMorning(formation);
    	else if(position==1)
    		seance = day.getAfternoon(formation);
    	return seance;
    }
}