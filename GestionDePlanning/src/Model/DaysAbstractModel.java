package Model;

import java.util.ArrayList;

import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Obs.DaysObservable;
import Obs.DaysObserver;

public abstract class DaysAbstractModel implements DaysObservable{
	protected Calendar calendar;
	
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
	  
// Affichage de menus
	public abstract void getFormations();
	public abstract void setFormations(Formation formation);
	
// Fonctions Observable
	public void addObserver(DaysObserver obs) {
	    this.listObserver.add(obs);
	}
	public void notifyObserver(ArrayList<Formation> formations, Formation currentFormation,boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next){
	    for(DaysObserver obs : listObserver)
	      obs.update(formations, currentFormation, init, days, numDays, after, next);
	}
	public void removeObserver() {
	    listObserver = new ArrayList<DaysObserver>();
	} 
}