package Model;

import java.util.ArrayList;

import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Model.CalendarObject.Teacher;
import Obs.DaysObservable;
import Obs.DaysObserver;
import Serialized.SerializeObjects;
import Serialized.Teachers;

public abstract class DaysAbstractModel implements DaysObservable{
	protected Calendar calendar;
	protected ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	
	protected boolean init;
	protected ArrayList<Day> days;
	protected boolean after;
	protected boolean next;
	
	protected final int numDaysWeek = 7;
	protected int firstDaysLoad = 0;

// Affichage de calendrier
	public ArrayList<Day> getDays(){
		return days;
	}
	public int getFirstDaysLoad(){
		return firstDaysLoad;
	}
	
	private ArrayList<DaysObserver> listObserver = new ArrayList<DaysObserver>();

	public abstract void getWeek(int index);

	public abstract int getNumDaysWeek();
	public abstract int getFinalNumDaysWeek();
	public abstract void setCalendar(Calendar c);
	public abstract void setInit(boolean init);
	
// Affichage des jours par mois
	public abstract void getMonth(int month, int year, int firstDay, int lastDay, int posFirstDay, int numweeks);
	public abstract int getNumDayMonth(int month, int year);
//	public abstract Day getLastDayWeek(Day day);
//	public abstract Day getFirstDayWeek(Day day);
	
// gestion des jours -> controler
	public abstract int getPosDayWeek(int day,int month, int year);
	public abstract int getIDay();
	public abstract int getIMonth();
	public abstract int getIYear();
	public abstract Day getDay(Day day);
	public abstract Day getLastDay();

// Gestion des Formateurs
	public abstract void addTeacher(String name, String firstname, String abbreviation, String email, String phone);
	public abstract void modifyTeacher(String oldEmail, String name, String firstname, String abbreviation, String email, String phone);
	public abstract void removeTeacher(String email);
	public abstract Teacher getTeacher(String email);
	public abstract void initTeacher(boolean inCalendar, boolean initSeances);
	public abstract void selectTeacher(String email,boolean inCalendar, boolean initSeances);
	
// Affichage de menu de formations
	public abstract void initFormations();
	public abstract void initFormations(String formation);
	public abstract void addFormation(String newtitle, Double newHourSeances);
	public abstract void modifyFormation(String title, String newtitle, Double newHourSeances);
	public abstract void deleteFormation(String title);
	public abstract ArrayList<Formation> getFormations();
	public abstract void setCurrentFormation(Formation formation);
	
// Affichage de menu des modules 
	public abstract void initModules(boolean initSeances);
	public abstract void initModules(String nameModule, boolean initSeances);
	public abstract void addModule(Module newModule);
	public abstract void modifyModule(String nameModule, Module newModule);
	public abstract void deleteModule(String nameModule);
	
// controle Seance
	public abstract void removeSeance(Module module, Day day, int positon);
	public abstract void addSeances(Module module, Teacher teacher, Day day, int positon);
	
// serialiser
	public abstract void serializeCalendar(String file);
	public abstract void serializeTeachers();
	public abstract void deserializeTeachers();
	
// Fonctions Observable
	public void addObserver(DaysObserver obs) {
	    this.listObserver.add(obs);
	}
	public void notifyObserver(Formation currentFormation,boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next){
	    for(DaysObserver obs : listObserver)
	      obs.update(currentFormation, init, days, numDays, after, next);
	}
	public void notifyObserver(ArrayList<Formation> formations, Formation currentFormation, boolean isInit){
		System.out.println(formations.size());
		System.out.println(currentFormation.getTitle());
	    for(DaysObserver obs : listObserver)
	      obs.update(formations, currentFormation, isInit);
	}
	public void notifyObserver(Formation currentFormation, Module currentModule, boolean isInit, boolean initSeances){
	    for(DaysObserver obs : listObserver)
	      obs.update(currentFormation,currentModule, isInit, initSeances);
	}
	public void notifyObserver(ArrayList<Day> days, int firstDay, int lastDay, int posFirstDay, boolean after, boolean next, int month, int year, int numweeks){
	    for(DaysObserver obs : listObserver)
	      obs.update(days,firstDay, lastDay,posFirstDay,after,next, month,  year, numweeks);
	}
	public void notifyObserver(ArrayList<Teacher> teachers, Teacher currentTeacher, boolean isInit, boolean inCalendar, boolean initSeances){
	    for(DaysObserver obs : listObserver)
	      obs.update(teachers,currentTeacher,isInit, inCalendar,initSeances);
	}
	public void removeObserver() {
	    listObserver = new ArrayList<DaysObserver>();
	}
}