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
import Model.CalendarObject.Seance;
import Model.CalendarObject.Teacher;

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
		daysModel.initFormations(c.getCurrentFormation().getTitle());//c.getCurrentFormation().getTitle()
		daysModel.getWeek(index);
	}
	
	/**
	 * M�thode d'affichage du nouveau calendrier
	 */
	public void newCalendar(String years, String titreFormation, String formationHSeances, boolean saturday, boolean sunday){
		int firstYear = Integer.parseInt(years.substring(0, 4));
		int lastYear = Integer.parseInt(years.substring(5, 9));

		try{
			Calendar c = new Calendar(1,9,firstYear,31,8,lastYear,false,saturday,sunday);
			
			Formation f = new Formation(titreFormation,Double.parseDouble(formationHSeances));
			
			c.addFormation(f);
			c.setCurrentFormation(c.getFormations().get(0));
			   
			      Module m1 = new Module("Anglais", "AN", Color.GREEN,12, f);
			      Module m2 = new Module("Reseau", "RE", Color.RED,10, f);
			      
			      Teacher t1 = new Teacher("champ@u-pec.fr","0652315824", "CH", "Champroux", "");
			      Teacher t2 = new Teacher("cham@u-pec.fr","0652315524", "CHo", "Champroux", "uy");
			      
			      c.getCurrentFormation().addModule(m1);
			      c.getCurrentFormation().addModule(m2);

			      c.getDays().get(2).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m2.getName()),t1));
			   c.inNumSeances(new Seance(m2,t1), m2);
			      c.getDays().get(3).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(1, new Seance(c.getCurrentFormation().getModule(m1.getName()),t1));
			   c.inNumSeances(new Seance(m1,t1), m1);
			      c.getDays().get(4).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m1.getName()),t2));
			   c.inNumSeances(new Seance(m1,t2), m1);
			      c.getDays().get(8).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m1.getName()),t2));
			   c.inNumSeances(new Seance(m1,t2), m1);
			      c.getDays().get(9).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m2.getName()),t1));
			   c.inNumSeances(new Seance(m2,t1), m2);
			      c.getDays().get(13).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m1.getName()),t1));
			   c.inNumSeances(new Seance(m1,t1), m1);
			      c.getDays().get(13).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m1.getName()),t2));
			   c.inNumSeances(new Seance(m1,t2), m1);
			      c.getDays().get(15).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m2.getName()),t1));
			   c.inNumSeances(new Seance(m2,t1), m2);
			      c.getDays().get(24).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m1.getName()),t2));
			   c.inNumSeances(new Seance(m1,t2), m1);
			      c.getDays().get(25).getFormationSeances(c.getCurrentFormation().getTitle()).setSeance(0, new Seance(c.getCurrentFormation().getModule(m1.getName()),t1));
			   c.inNumSeances(new Seance(m1,t1), m1);
			   c.resetSeance(c.getCurrentFormation().getModule(m1.getName()));
			   c.resetSeance(c.getCurrentFormation().getModule(m2.getName()));

			System.out.println("                                 NB H Formation : " + f.getHoursFormation());
			   
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
	
	public void getDaysMonth(){
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
		daysModel.getWeek(index);
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
		daysModel.getWeek(index);
		daysModel.initFormations();
	}
	public void selectFormation(String title){
		daysModel.setCurrentFormation(title);
		daysModel.getWeek(index);
		daysModel.initFormations(title);
	}
	public void addFormation(String title, String newNbHoursSeances){
		daysModel.addFormation(title, Double.parseDouble(newNbHoursSeances));
		selectFormation(title);
		daysModel.initFormations(title);
	} 
	public void modifyFormation(String title, String newtitle, String newNbHoursSeances){
		boolean formationExist = false;
		for(Formation f : daysModel.getFormations()){
			if(f.getTitle().equals(title))
			{
				daysModel.modifyFormation(title, newtitle, Double.parseDouble(newNbHoursSeances));
			}
		}
		selectFormation(newtitle);
		daysModel.initFormations(newtitle);
	}
	public void deleteFormation(String title){
		daysModel.deleteFormation(title);
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
	

	// -------------- Gestion du menu Formateurs  --------------- //
	// ---------------------------------------------------------- //
	
	public void addTeacher(String name, String firstname, String abbreviation, String email, String phone) {
		daysModel.addTeacher(name, firstname, abbreviation, email, phone);
		daysModel.serializeTeachers();
		daysModel.selectTeacher(email, false, false);
	}
	public void modifyTeacher(String oldEmail, String name, String firstname, String abbreviation, String email, String phone) {
		daysModel.modifyTeacher(oldEmail,name, firstname, abbreviation, email, phone);
		daysModel.serializeTeachers();
		daysModel.selectTeacher(email, false, false);
	}
	public void removeTeacher(String email){
		daysModel.removeTeacher(email);
		daysModel.serializeTeachers();
		daysModel.initTeacher(false, false);
	}
	public void initTeacher(boolean inCalendar, boolean initSeances){
		daysModel.initTeacher(inCalendar, initSeances);
	}
	public void selectTeacher(String email,boolean inCalendar, boolean initSeances){
		daysModel.selectTeacher(email, inCalendar,initSeances);
	}

	
	
	// Fonction de controle des valeurs envoy�es :
		// - que des valeurs uniques - > verifier que le formateur exit (suivant l'action)
		// - gere action si pas de formateur existant (modifier/supprimer)
		// - suppression interdite si deja assign� utilis� dans une seance
	
	
	
	// -------------- Gestion du menu Modules  --------------- //
	// ------------------------------------------------------- //
	

	public void initModules(boolean initSeances){
// supprimer erreur dans le cas ou aucun modules existe (entrer quand m�me dans la fenetre)
		daysModel.initModules(initSeances);
	}
	public void selectModule(String nameModule, boolean initSeances){
// supprimer erreur dans le cas ou aucun modules existe (entrer quand m�me dans la fenetre)
		daysModel.initModules(nameModule,initSeances);
	}
	
	public void addModule(String newName, String newAbbreviation, String newMaxSeances, Color newColor){
// Tests
		daysModel.addModule(new Module(newName,newAbbreviation,newColor,Integer.parseInt(newMaxSeances), daysModel.getCurrentFormation()));
		daysModel.initModules(newName,false);
	}
	public void modifyModule(String nameModule, String newName, String newAbbreviation, String newMaxSeances, Color newColor){
// Tests
		daysModel.modifyModule(nameModule, new Module(newName,newAbbreviation,newColor,Integer.parseInt(newMaxSeances), daysModel.getCurrentFormation()));
		daysModel.initModules(newName,false);
	}
	public void removeModule(String nameModule){
// Tests
		daysModel.deleteModule(nameModule);
		daysModel.initModules(false);
	}

	
// Fonction de controle des valeurs envoy�es :
	// - nbMax est un entier (pour tous)
	// - nbMax <= 4
	// - Nom et Abb et couleur : si exist (spe � l'action)
	// - nb Seances existantes : si exist / si < nbMax (spe � l'action)

	

	// -------------- Fonctions de Gestion des S�ances --------------- //
	// --------------------------------------------------------------- //
	
	public void removeSeance(Module module, Day day, int position){
		daysModel.removeSeance(module, day, position);
		this.getDaysMonth();
	}
	public void addSeances(Module module, String emailTeacher, Day day, int position){
		daysModel.addSeances(module, daysModel.getTeacher(emailTeacher), day, position);
		this.getDaysMonth();
	}
	
	
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
	
	
	// -------------- Fonctions de serialisation --------------- //
	// --------------------------------------------------------- //
	
	public void serializeCalendar(){
		daysModel.serializeCalendar(daysModel.getIYear() + " " + (daysModel.getIYear() + 1) + "Calendar.serial");
	}
}
