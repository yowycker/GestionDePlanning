package Model;

import java.util.ArrayList;

import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Obs.DaysObservable;
import Obs.DaysObserver;

public abstract class DaysAbstractModel implements DaysObservable{
	protected Calendar calendar;
	protected ArrayList<Day> days;
	
	protected final int numWeekDays = 7;
	
	/*protected int annee;
	protected int mois;
	protected int semaine;*/
	protected int index = 0;
	
	private ArrayList<DaysObserver> listObserver = new ArrayList<DaysObserver>();

	public abstract void getWeek();
	public abstract void getNextWeek();
	public abstract void getAfterWeek();
	
	public abstract int getNumDays();
	public abstract void setCalendar(Calendar c);
	  
	public void addObserver(DaysObserver obs) {
	    this.listObserver.add(obs);
	}
	public void notifyObserver(ArrayList<Day> days, int numJours) {
	    for(DaysObserver obs : listObserver)
	      obs.update(days, numJours);
	}
	public void removeObserver() {
	    listObserver = new ArrayList<DaysObserver>();
	} 
}