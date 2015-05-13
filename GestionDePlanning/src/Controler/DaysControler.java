package Controler;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Exceptions.dateException;
import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;

public class DaysControler extends DaysAbstractControler {
	/**
	 * Constructeur de la classe DaysControler
	 * @param daysModel
	 */
	public DaysControler(DaysAbstractModel daysModel){
		super(daysModel);
	}


	// -------------- Fonctions de l'affichage du calendrier --------------- //
	// --------------------------------------------------------------------- //
	
	/**
	 * Méthode d'affichage de la semaine suivante
	 */
	public void nextWeek(){
		daysModel.setInit(false);
		index += daysModel.getFinalNumDaysWeek();
System.out.println("Index : " + index);
		daysModel.getWeek(index);
	}
	
	/**
	 * Méthode d'affichage de la semaine précédente
	 */
	public void afterWeek(){
		daysModel.setInit(false);
		index -= daysModel.getFinalNumDaysWeek();
System.out.println("Index : " + index);
		daysModel.getWeek(index);
	}
	
	/**
	 * Initialisation des données
	 */
	public void initData(Calendar c){
		index = 0;
		if(isInit == false){
			isInit = true;
			daysModel.setInit(true);
		}
		else
			daysModel.setInit(false);
		daysModel.setCalendar(c);
		daysModel.getWeek(index);
	}
	
	/**
	 * Méthode d'affichage du nouveau calendrier
	 */
	public void newCalendar(String years, boolean holiday, boolean saturday, boolean sunday){
		int firstYear = Integer.parseInt(years.substring(0, 4));
		int lastYear = Integer.parseInt(years.substring(5, 9));

		try{
			Calendar c = new Calendar(28,12,firstYear,18,2,lastYear,holiday,saturday,sunday);
			Formation f = new Formation("L3 2/3 A", 3.5);
			
			c.addFormation(f);
			c.setCurrentFormation(f);
			
		    Module m1 = new Module("Anglais", "AN", Color.GREEN,"Champroux",12);
		    Module m2 = new Module("Reseau", "RE", Color.RED,"Pl",10);
		    
		    f.addModule(m1);
		    f.addModule(m2);
		    
		    c.setMorningSeance(c.getDays().get(2), m2);
		    c.setAfternoonSeance(c.getDays().get(3), m1);
		    c.setMorningSeance(c.getDays().get(4), m1);
		    c.setMorningSeance(c.getDays().get(8), m1);
		    c.setMorningSeance(c.getDays().get(9), m2);
		    
		    c.setMorningSeance(c.getDays().get(13), m1);
		    c.setAfternoonSeance(c.getDays().get(13), m1);
		    c.setMorningSeance(c.getDays().get(15), m2);
		    c.setAfternoonSeance(c.getDays().get(24), m1);
		    c.setAfternoonSeance(c.getDays().get(25), m1);

System.out.println("                                 NB H Formation : " + f.getHoursFormation());
		    
		    for(Day d : c.getDays()){
		    	System.out.println(d.getDate());
		    	if(d.getMorning(c.getCurrentFormation()) != null)
		    		System.out.println("    Module Matin : " + d.getMorning(c.getCurrentFormation()).getModule().getName());
		    	else
		    		System.out.println("    Module Matin : NULL");
		    	if(d.getAfternoon(c.getCurrentFormation()) != null)
		    		System.out.println("    Module Aprem : " + d.getAfternoon(c.getCurrentFormation()).getModule().getName());
		    	else
		    		System.out.println("    Module Aprem : NULL");
		    }
		    initData(c);
		}
		catch(dateException e){
			e.showDialogMessage();
			//new JDialogNewPlanning(this);
		}
	}

	// -------------- Gestion d'affichage des menus  --------------- //
	// ------------------------------------------------------------- //
	
	
	public void initFormation(){
		daysModel.initFormations();
	}
	public void selectFormation(Formation formation){
		daysModel.initFormations(formation);
	}
	public void addFormation(String title, double nbHoursSeances){
		if(formationExist(new Formation(title, nbHoursSeances))){
// Exception : Exist
		}
		else{
// Controle si title et nbHoursSeances sont dans la norme ...
			daysModel.addFormation(new Formation(title, nbHoursSeances));
		}
		this.initFormation();
	} 
	public void modifyFormation(String title, String newtitle, double newNbHoursSeances) {
		Formation fe = null;
		boolean formationExist = false;
		for(Formation f : daysModel.getFormations()){
			if((new Formation(title, 0)).equals(f))
			{
				formationExist = true;
				fe = f;
			}
		}
		
		if(formationExist){
			daysModel.modifyFormation(fe, new Formation(newtitle, newNbHoursSeances));
		}
		else{
// Exception : N'existe pas
		}
		this.initFormation();
	}
	public void deleteFormation(String title, double nbHoursSeances){
		if(formationExist(new Formation(title, nbHoursSeances))){
// Controle quel formation on supprime (si il existe plus de formation, faire... sinon faire ...
			daysModel.deleteFormation(new Formation(title, nbHoursSeances));
		}
		else{
// Exception : N'existe pas
		}
		this.initFormation();
	}
	private boolean formationExist(Formation fe){
		boolean formationExist = false;
		for(Formation f : daysModel.getFormations()){
			if(fe.equals(f))
			{
				formationExist = true;
			}
		}
		return formationExist;
	}

	
	// -------------- Fonctions de remplissage de la fenetre --------------- //
	// --------------------------------------------------------------------- //

	
	public ArrayList<String> getListYears(){
		 Date current = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy");
		 int currentYear = Integer.parseInt(dateFormat.format(current));
		 int nextYear = currentYear + 1;
		 
		ArrayList<String> listYears = new ArrayList<String>();
		for(int i = 0; i < nbYearsList; i++){
			listYears.add((currentYear + i) + "-" + (nextYear + i));
		}
		return listYears;
	}

}
