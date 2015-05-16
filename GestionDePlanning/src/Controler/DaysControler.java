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
	 * M�thode d'affichage de la semaine suivante
	 */
	public void nextWeek(){
		daysModel.setInit(false);
		index += daysModel.getFinalNumDaysWeek();
System.out.println("Index : " + index);
		daysModel.getWeek(index);
	}
	
	/**
	 * M�thode d'affichage de la semaine pr�c�dente
	 */
	public void afterWeek(){
		daysModel.setInit(false);
		index -= daysModel.getFinalNumDaysWeek();
System.out.println("Index : " + index);
		daysModel.getWeek(index);
	}
	
	/**
	 * Initialisation des donn�es
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
	 * M�thode d'affichage du nouveau calendrier
	 */
	public void newCalendar(String years, boolean holiday, boolean saturday, boolean sunday){
		int firstYear = Integer.parseInt(years.substring(0, 4));
		int lastYear = Integer.parseInt(years.substring(5, 9));

		try{
			Calendar c = new Calendar(28,12,firstYear,18,2,lastYear,holiday,saturday,sunday);
			Formation f = new Formation("L3 2/3 A", 3.5);
			
			c.addFormation(f);
			c.setCurrentFormation(f);
			
		    Module m1 = new Module("Anglais", "AN", Color.GREEN,12);
		    Module m2 = new Module("Reseau", "RE", Color.RED,10);
		    
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
	

	// -------------- Gestion de l'affichage par mois  --------------- //
	// --------------------------------------------------------------- //
	
	
	public void initDaysMonth(){
		indexMonthMenu = 0;
		getDaysMonth();
	}
	public void afterDaysMonth(){
		indexMonthMenu --;
		getDaysMonth();
	}
	public void nextDaysMonth(){
		indexMonthMenu ++;
		getDaysMonth();
	}
	
	private void getDaysMonth(){
		int numMonth = (daysModel.getIMonth() + indexMonthMenu) % 12;
		if(numMonth == 0)
			numMonth = 12;
		int year = daysModel.getIYear() + (daysModel.getIMonth() + indexMonthMenu - numMonth)/12;
		
		int firstDayMonth;
		if(indexMonthMenu == 0)
			firstDayMonth = daysModel.getIDay();
		else
			firstDayMonth = 1;
		
		int lastDayMonth;
		if(daysModel.getLastDay().getNumMonth() == numMonth && daysModel.getLastDay().getYear() == year)
			lastDayMonth = daysModel.getLastDay().getNumDay();
		else
			lastDayMonth = daysModel.getNumDayMonth(numMonth,year);
		
		int posFirstDayMonth = daysModel.getPosDayWeek(1,numMonth,year);
		int numweeks = 1;
		int j = 7;
		for(int i =  (8 - posFirstDayMonth); i <= lastDayMonth; i++){
			if(j == 7){
				j = 0;
				numweeks++;
			}
			j++;
		}
		daysModel.getMonth(numMonth, year, firstDayMonth, lastDayMonth, posFirstDayMonth, numweeks);
	}
// ------- Gestion de l'affichage par mois ------- //
	
	public void modifyHoliday(boolean holiday, Day day){
		daysModel.getDay(day).setHoliday(holiday);
		getDaysMonth();
	}
	

	
// Fonctions de controle des valeurs envoy�es :
	// - Seances Existantes ? (test si passe en holiday)
	// - Si Samedi/dimanche, modifier holiday Calendar : (tests spe � l'action : 2 cas)
	
	
	
	// -------------- Gestion du menu Formations  --------------- //
	// ---------------------------------------------------------- //
	
	
	public void initFormation(){
		daysModel.initFormations();
	}
	public void addFormation(String title, double nbHoursSeances){
		if(formationExist(new Formation(title, nbHoursSeances))){
// Exception : Exist
		}
		else{
// Controle si title et nbHoursSeances sont dans la norme ...
			daysModel.addFormation(new Formation(title, nbHoursSeances));
		}
		daysModel.initFormations(title);
	} 
	public void modifyFormation(String title, String newtitle, double newNbHoursSeances){
// Pas encore fonctionnelle
		boolean formationExist = false;
		for(Formation f : daysModel.getFormations()){
			if(f.equals(new Formation(title, 0)))
			{
				formationExist = true;
				daysModel.modifyFormation(title, new Formation(newtitle, newNbHoursSeances));
			}
			else
			{
// Exception : N'existe pas
			}
		}
		daysModel.initFormations(title);
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

	// -------------- Gestion du menu Modules  --------------- //
	// ------------------------------------------------------- //
	

	public void initModules(){
// supprimer erreur dans le cas ou aucun modules existe (entrer quand m�me dans la fenetre)
		daysModel.initModules();
	}
	public void selectModule(String nameModule){
// supprimer erreur dans le cas ou aucun modules existe (entrer quand m�me dans la fenetre)
		daysModel.initModules(nameModule);
	}
	
	public void addModule(String newName, String newAbbreviation, String newMaxSeances, Color newColor){
// Tests
		daysModel.addModule(new Module(newName,newAbbreviation,newColor,Integer.parseInt(newMaxSeances)));
		daysModel.initModules(newName);
	}
	public void modifyModule(String nameModule, String newName, String newAbbreviation, String newMaxSeances, Color newColor){
// Tests
		daysModel.modifyModule(nameModule, new Module(newName,newAbbreviation,newColor,Integer.parseInt(newMaxSeances)));
		daysModel.initModules(newName);
	}
	public void removeModule(String nameModule){
// Tests
		daysModel.deleteModule(nameModule);
		daysModel.initModules();
	}

	
// Fonction de controle des valeurs envoy�es :
	// - nbMax est un entier (pour tous)
	// - Nom et Abb et couleur : si exist (spe � l'action)
	// - nb Seances existantes : si exist / si < nbMax (spe � l'action)

	
	
	
	// -------------- Fonctions de remplissage de liste --------------- //
	// ---------------------------------------------------------------- //

	
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
