package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
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
import View.Elements.JButtonFormation;
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
    private SLabel mondayd = new SLabel("");
    private SLabel tuesdayd = new SLabel("");
    private SLabel wednesdayd = new SLabel("");
    private SLabel thursdayd = new SLabel("");
    private SLabel fridayd = new SLabel("");
    private SLabel saturdayd = new SLabel("");
    private SLabel sundayd = new SLabel("");

    private SLabel formation = new SLabel("");

    private SLabel morning = new SLabel("9h00");
    private SLabel noon = new SLabel("12h00 - 14h00");
    private SLabel evening = new SLabel("18h00");
    
    private JButton prec = new JButton("<<"); 
    private JButton suiv = new JButton(">>");
    

// receptacles :
    // panneau contenant au moin le titre du planning
    private JPanel headerInfo = new JPanel();
    	private JPanel formationsPanel = new JPanel();
    	private JPanel infoPanel = new JPanel();
    // panneau d'edition du planning : inserer seances ...
    private JPanel modulesTab = new JPanel();
    // panneau recevant : les entetes, les horaires, les Cours ET la barre
    private JPanel planning = new JPanel();
	    // panneau recevant : les entetes, les horaires, les Cours ET la barre
	    private JPanel table = new JPanel();
		    private JPanel headers = new JPanel();
		    	private JPanel header1 = new JPanel();
		    	private JPanel header2 = new JPanel();
		    private JPanel seances = new JPanel();
	    // panneau recevant les horaires d'une journée
	    private JPanel timeTable = new JPanel();
	    // bar permettant de passer d'un jour à l'autre ET avec les information sur la semaine
	    private JPanel actionBar = new JPanel();
	    private JPanel actionChange = new JPanel();

// Layout
    private GridLayout headersLayout;
    	private GridLayout header1Layout;
    	private GridLayout header2Layout;
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
    	headersLayout = new GridLayout(2, 1);
        headers.setLayout(headersLayout);
        headers.add(header1, 0);
        headers.add(header2, 1);
        header1Layout = new GridLayout(1, 1);
    	header1Layout.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
    	header1Layout.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        header1.setLayout(header1Layout);
        header2Layout = new GridLayout(1, 1);
    	header2Layout.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
    	header2Layout.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical)
        header2.setLayout(header2Layout);
        
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
        
        headerInfo.setLayout(new BorderLayout());
        headerInfo.add(formationsPanel, BorderLayout.NORTH);
        headerInfo.add(infoPanel, BorderLayout.CENTER);
        infoPanel.setBackground(Color.DARK_GRAY);
        infoPanel.add(formation);
        formation.setForeground(Color.WHITE);

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
	public void update(ArrayList<Formation> formations,	Formation currentFormation, boolean isInit) {
		formationsPanel = new JPanel();
		formationsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		for(Formation f : formations){
			formationsPanel.add(new JButtonFormation(f.getTitle(), this.daysControler));
		}
		formation.setText(currentFormation.getTitle() +"    -     "+ currentFormation.getNbHours()+" H  -  "+ currentFormation.getNbDays() +" J  -  " +currentFormation.getHoursFormation() + "H Total");
		this.updateUI();
	}
    private void showWeek(Formation formation,ArrayList<Day> days, int numDays){
    	loadPlanningLayout(numDays);
        seancesLayout = new GridLayout(1, numDays);
    	seances.removeAll();
    	for(int i = 0; i < numDays; i++){
    		if(days.get(i) == null)
    			seances.add(new JPanel(),(i));
    		else{
        		loadDateDay(i, days.get(i).getDate());
    	    	seances.add(new DayPanel(days.get(i),5,5,formation),i);
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
    private void loadDateDay(int i, String date){
    	switch(i){
    	case 0 : mondayd.setText(date);break;
    	case 1 : tuesdayd.setText(date);break;
    	case 2 : wednesdayd.setText(date);break;
    	case 3 : thursdayd.setText(date);break;
    	case 4 : fridayd.setText(date);break;
    	case 5 : saturdayd.setText(date);break;
    	case 6 : sundayd.setText(date);break;
    	}
    }
    private void loadPlanningLayout(int numDays){
    	header1Layout = new GridLayout(1, numDays);
    	header2Layout = new GridLayout(1, numDays);
        header1.removeAll();
        header2.removeAll();
        
        header1.add(monday);
        header1.add(tuesday);
        header1.add(wednesday);
        header1.add(thursday);
        header1.add(friday);
        header2.add(mondayd);
        header2.add(tuesdayd);
        header2.add(wednesdayd);
        header2.add(thursdayd);
        header2.add(fridayd);
        if(numDays >= 6)
        	header1.add(saturday);
    		header2.add(saturdayd);
        if(numDays == 7)
        	header1.add(sunday);
    		header2.add(sundayd);
    	
    	
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