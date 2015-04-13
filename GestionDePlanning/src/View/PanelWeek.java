package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controler.DaysAbstractControler;
import Model.CalendarObject.Day;
import Model.CalendarObject.Seance;
import Obs.DaysObserver;
import View.Elements.SLabel;
import View.Elements.SeancePanel;

public class PanelWeek extends JPanel implements DaysObserver, ActionListener{
	private DaysAbstractControler daysControler;
	// change ici setSemaine et l'iteration de Index (celui n'a pas � �tre modifi�)
    
    private SLabel monday = new SLabel("Lundi");
    private SLabel tuesday = new SLabel("Mardi");
    private SLabel wednesday = new SLabel("Mercredi");
    private SLabel thursday = new SLabel("Jeudi");
    private SLabel friday = new SLabel("Vendredi");
    private SLabel saturday = new SLabel("Samedi");
    private SLabel sunday = new SLabel("Dimanche");

    private SLabel morning = new SLabel("9h00");
    private SLabel noon = new SLabel("12h00 - 14h00");
    private SLabel evening = new SLabel("18h00");
    
    private JButton prec = new JButton("<<"); 
    private JButton suiv = new JButton(">>");
    

// receptacles :
    // panneau contenant au moin le titre du planning
    private JPanel headerInfo = new JPanel();
    // panneau d'edition du planning : inserer seances ...
    private JPanel modulesTab = new JPanel();
    // panneau recevant : les entetes, les horaires, les Cours ET la barre
    private JPanel planning = new JPanel();
	    // panneau recevant : les entetes, les horaires, les Cours ET la barre
	    private JPanel table = new JPanel();
		    private JPanel headers = new JPanel();
		    private JPanel seances = new JPanel();
	    // panneau recevant les horaires d'une journ�e
	    private JPanel timeTable = new JPanel();
	    // bar permettant de passer d'un jour � l'autre ET avec les information sur la semaine
	    private JPanel actionBar = new JPanel();
	    private JPanel actionChange = new JPanel();

// Layout
    private GridLayout headersLayout;
    private GridLayout seancesLayout;
    private BorderLayout timeTableLayout;
    private GridLayout actionChangeLayout;

    
    public PanelWeek(DaysAbstractControler daysControler){
    	this.daysControler = daysControler;
    }
    public void initPlanning(){    	
        // Entete
    	headersLayout = new GridLayout(1, 1);
    	headersLayout.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
    	headersLayout.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        headers.setLayout(headersLayout);
        
        // Seances : 2 par journee
        seancesLayout = new GridLayout(2, 1);
        seancesLayout.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        seancesLayout.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        seances.setLayout(seancesLayout);
        
        // le planning qui va contenir les deux precedants
        table.setLayout(new BorderLayout());
        table.add(headers, BorderLayout.NORTH);
        table.add(seances, BorderLayout.CENTER);
        
        // les horaires sur le cot�
        timeTableLayout = new BorderLayout();
        timeTableLayout.setVgap(10);
        timeTable.setLayout(timeTableLayout);
        timeTable.add(morning, BorderLayout.NORTH);
        timeTable.add(noon, BorderLayout.CENTER); 
        timeTable.add(evening, BorderLayout.SOUTH);  

        // la barre de "navigation"
        actionChangeLayout = new GridLayout(1, 3);
        actionChange.setLayout(actionChangeLayout);
        actionChange.setAlignmentY(CENTER_ALIGNMENT);
        actionChange.add(prec);
        actionChange.add(new JPanel());
        actionChange.add(suiv);
        
        // Barre d'outils
        actionBar.setLayout(new BorderLayout());
        actionBar.add(actionChange, BorderLayout.CENTER);
        
        //planning 
        planning.setLayout(new BorderLayout());
        planning.add(table, BorderLayout.CENTER); 
        planning.add(timeTable, BorderLayout.WEST);   
        planning.add(actionBar, BorderLayout.SOUTH);

// le tout
        this.setLayout(new BorderLayout());
        this.add(planning, BorderLayout.CENTER); 
        this.add(headerInfo, BorderLayout.NORTH);


// Modif elements :
        prec.addActionListener(this); 
        suiv.addActionListener(this);
        timeTable.setBackground(Color.LIGHT_GRAY);
        headerInfo.setBackground(Color.BLUE);


///// Manipulation de l'onglet de gestion de modules
   //     this.add(modulesTab, BorderLayout.EAST);
   //     this.remove(modulesTab);
   //     modulesTab.setBackground(Color.LIGHT_GRAY);
    }
    
// appeler dans le model
    public void update(ArrayList<Day> days, int numDays, boolean after, boolean next){
		prec.setEnabled(after);
		suiv.setEnabled(next);
		this.showWeek(days,numDays);
		this.updateUI();
	}
    private void showWeek(ArrayList<Day> days, int numDays){
    	loadPlanningLayout(numDays);
    	seances.removeAll();    	
    	for(int i = 0; i < seancesLayout.getRows(); i++){
    		for(int j = 0; j < seancesLayout.getColumns(); j++)
    			if(days.get(j) == null || days.get(j).getHoliday())
    				seances.add(new JPanel(),(i*numDays + j));
    			else if(this.getSeance(days.get(j), i) == null)
        			seances.add(new SeancePanel(),(i*numDays + j));
    			else
    	    		seances.add(new SeancePanel(this.getSeance(days.get(j), i)),(i*numDays + j));
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
    private void loadPlanningLayout(int numDays){
    	headersLayout = new GridLayout(1, numDays);
        seancesLayout = new GridLayout(2, numDays);
        headers.removeAll();
        headers.add(monday);
        headers.add(tuesday);
        headers.add(wednesday);
        headers.add(thursday);
        headers.add(friday);
        if(numDays >= 6)
        	headers.add(saturday);
        if(numDays == 7)
        	headers.add(sunday);
    }
    
    
// Passer � la semaine suivante 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == suiv){
        	daysControler.nextWeek();
        } 
        if(e.getSource() == prec){ 
        	daysControler.afterWeek();
        } 
    }

    
}