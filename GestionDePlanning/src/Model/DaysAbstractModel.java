package Model;

import java.util.ArrayList;

import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Obs.DaysObservable;
import Obs.DaysObserver;

public abstract class DaysAbstractModel implements DaysObservable{
	protected Calendar calendar;
	protected ArrayList<Day> days;
	protected boolean after;
	protected boolean next;
	
	protected final int numDaysWeek = 7;
	
	/*protected int annee;
	protected int mois;
	protected int semaine;*/
	
	private ArrayList<DaysObserver> listObserver = new ArrayList<DaysObserver>();

	public abstract void getWeek(int index);

	public abstract int getNumDaysWeek();
	public abstract void setCalendar(Calendar c);
	  
	public void addObserver(DaysObserver obs) {
	    this.listObserver.add(obs);
	}
	public void notifyObserver(ArrayList<Day> days, int numDays, boolean after, boolean next) {
	    for(DaysObserver obs : listObserver)
	      obs.update(days, numDays,after,next);
	}
	public void removeObserver() {
	    listObserver = new ArrayList<DaysObserver>();
	} 
}