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
	// change ici setSemaine et l'iteration de Index (celui n'a pas à être modifié)
	private int nbJour = 7;
    
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
    // panneau recevant le tableau de la semaine
    private JPanel planning = new JPanel();
    private JPanel headers = new JPanel();
    private JPanel seances = new JPanel();
    // panneau recevant les horaires d'une journée
    private JPanel timeTable = new JPanel();
    // bar de menu
    private JPanel toolbar = new JPanel();
    // bar permettant de passer d'un jour à l'autre ET avec les information sur la semaine
    private JPanel actionBar = new JPanel();
    private JPanel actionChange = new JPanel();
    // panneau d'edition du planning
    private JPanel modulesTab = new JPanel();

// Layout
    private GridLayout headersLayout;
    private GridLayout seancesLayout;
    private BorderLayout timeTableLayout;
    private GridLayout actionChangeLayout;

    
    public PanelWeek(DaysAbstractControler daysControler){
    	this.daysControler = daysControler;
    	initPosition();
    	initElements();
    }
    private void initPosition(){    	
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
        planning.setLayout(new BorderLayout());
        planning.add(headers, BorderLayout.NORTH);
        planning.add(seances, BorderLayout.CENTER);
        
        // les horaires sur le coté
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

        // le tout
        this.setLayout(new BorderLayout());
        this.add(planning, BorderLayout.CENTER); 
        this.add(timeTable, BorderLayout.WEST);   
        this.add(actionBar, BorderLayout.SOUTH);  

        
///// Manipulation de l'onglet de gestion de modules
        this.add(modulesTab, BorderLayout.EAST);
        this.remove(modulesTab);
    }
    private void initElements(){
        prec.addActionListener(this); 
        suiv.addActionListener(this);

        timeTable.setBackground(Color.LIGHT_GRAY);
        modulesTab.setBackground(Color.LIGHT_GRAY);
    }
    
// appeler dans le model
    public void update(ArrayList<Day> days, int numDays){
		this.showWeek(days,numDays);
	}
    private void showWeek(ArrayList<Day> days, int numDays){
    	loadPlanningLayout(numDays);
    	seances.removeAll();    	
    	for(int i = 0; i < seancesLayout.getRows(); i++){
    		for(int j = 0; j < seancesLayout.getColumns(); j++)
    			if(days.get(j) == null || days.get(j).getFerie())
    				seances.add(new JPanel(),(i*numDays + j));
    			else if(this.getSeance(days.get(j), i) == null)
        			seances.add(new SeancePanel(),(i*numDays + j));
    			else
    	    		seances.add(new SeancePanel(this.getSeance(days.get(j), i)),(i*numDays + j));
    	}
///// changer le contenu d'un panel dans un gridLayout (seulement add sur index suffit, il faudra toutefois recuperer le bon index pour drag'n drop
/*        seances.remove(2);
        seances.add(new JPanel(),2);
        seances.remove(0);
        seances.add(new JPanel(),0);*/
    }
    private Seance getSeance(Day day, int position){
    	Seance seance = null;
    	if(position==0)
    		seance = day.getMatin();
    	else if(position==1)
    		seance = day.getApresMidi();
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
    
    
// Passer à la semaine suivante 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == suiv){
        	//PanelSemaine.setIndex(nbJour);
        	//setSemaine();
        } 
        if(e.getSource() == prec){ 
        	//PanelSemaine.setIndex(-nbJour);
        	//setSemaine();
        } 
    }

    
}