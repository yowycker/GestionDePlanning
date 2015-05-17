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
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Model.CalendarObject.Teacher;
import Obs.DaysObserver;
import View.Elements.DayPanel;
import View.Elements.SLabel;

public class PanelWeek extends JPanel implements DaysObserver, ActionListener{
	private DaysAbstractControler daysControler;
	// change ici setSemaine et l'iteration de Index (celui n'a pas à être modifié)
    
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
	    // panneau recevant les horaires d'une journée
	    private JPanel timeTable = new JPanel();
	    // bar permettant de passer d'un jour à l'autre ET avec les information sur la semaine
	    private JPanel actionBar = new JPanel();
	    private JPanel actionChange = new JPanel();

// Layout
    private GridLayout headersLayout;
    private GridLayout seancesLayout;
    private BorderLayout timeTableLayout;
    private GridLayout actionChangeLayout;
    private BorderLayout tableLayout;
    private BorderLayout actionBarLayout;
    private BorderLayout planningLayout;
    private BorderLayout panelWeekLayout;
    
    private JPanel separationLayout;

    
    public PanelWeek(DaysAbstractControler daysControler){
    	this.daysControler = daysControler;
    }
    private void initPlanning(){    	
        // Entete
    	headersLayout = new GridLayout(1, 1);
    	headersLayout.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
    	headersLayout.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        headers.setLayout(headersLayout);
        
        // Seances : 2 par journee
        seancesLayout = new GridLayout(1, 1);
        seancesLayout.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
        seancesLayout.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        seances.setLayout(seancesLayout);
        
        // le planning qui va contenir les deux precedants
        tableLayout = new BorderLayout();
        table.setLayout(tableLayout);
        table.add(headers, BorderLayout.NORTH);
        table.add(seances, BorderLayout.CENTER);
        
        // les horaires sur le coté
        timeTableLayout = new BorderLayout();
        timeTableLayout.setVgap(10);
        timeTable.setLayout(timeTableLayout);
        timeTable.add(morning, BorderLayout.NORTH);
        timeTable.add(noon, BorderLayout.CENTER); 
        timeTable.add(evening, BorderLayout.SOUTH);  

        // la barre de "navigation"
        actionChangeLayout = new GridLayout(1, 3);
        actionChange.removeAll();
        actionChange.setLayout(actionChangeLayout);
        actionChange.setAlignmentY(CENTER_ALIGNMENT);
        actionChange.add(prec);
        separationLayout = new JPanel();
        actionChange.add(separationLayout);
        actionChange.add(suiv);
        
        // Barre d'outils
        actionBarLayout = new BorderLayout();
        actionBar.setLayout(actionBarLayout);
        actionBar.add(actionChange, BorderLayout.CENTER);
        
        //planning 
        planningLayout = new BorderLayout();
        planning.setLayout(planningLayout);
        planning.add(table, BorderLayout.CENTER); 
        planning.add(timeTable, BorderLayout.WEST);   
        planning.add(actionBar, BorderLayout.SOUTH);

// le tout
        panelWeekLayout = new BorderLayout();
        this.setLayout(panelWeekLayout);
        this.add(planning, BorderLayout.CENTER); 
        this.add(headerInfo, BorderLayout.NORTH);


// Modif elements :
        prec.addActionListener(this); 
        suiv.addActionListener(this);
        timeTable.setBackground(Color.LIGHT_GRAY);
        headerInfo.setBackground(Color.BLUE);
    }
    
// appelé dans le model par la méthode "notifyObserver"
    public void update(Formation currentFormation,boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next){
    	if(init) initPlanning();
    	
		prec.setEnabled(after);
		suiv.setEnabled(next);
		this.showWeek(currentFormation,days,numDays);
		this.updateUI();
	}
	public void update(ArrayList<Formation> formations,	Formation currentFormation) {
	}
    private void showWeek(Formation formation,ArrayList<Day> days, int numDays){
    	loadPlanningLayout(numDays);
        seancesLayout = new GridLayout(1, numDays);
    	seances.removeAll();
    	for(int i = 0; i < numDays; i++){
    		if(days.get(i) == null)
    			seances.add(new JPanel(),(i));
    		else{
    	    	seances.add(new DayPanel(days.get(i),5,5,formation),i);
System.out.println(days.get(i).getName() + " " + days.get(i).getDate());
    		    }
    	}
    }
/*    private void showMonth(Formation formation,ArrayList<Day> days, int numDays){
    	loadPlanningLayout(numDays);
        seancesLayout = new GridLayout(1, numDays);
    	seances.removeAll();
    	for(int i = 0; i < numDays; i++){
    		if(days.get(i) == null)
    			seances.add(new JPanel(),(i));
    		else{
    	    	seances.add(new DayPanel(days.get(i),5,5,formation),i);
    		    }
    	}
    }
*/
    
    private void loadPlanningLayout(int numDays){
    	headersLayout = new GridLayout(1, numDays);
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
        	daysControler.nextWeek();
        } 
        if(e.getSource() == prec){ 
        	daysControler.afterWeek();
        } 
    }
	@Override
	public void update(Formation currentFormation, Module currentModule, boolean isInit, boolean initSeances) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(ArrayList<Day> days, int firstDay, int lastDay,
			int posFirstDay, boolean after, boolean next, int month, int year, int numweeks){
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(ArrayList<Teacher> teachers, Teacher currentTeacher, boolean isInit, boolean inCalendar, boolean initSeances) {
		// TODO Auto-generated method stub
		
	}
}