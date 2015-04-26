package Obs;

import java.util.ArrayList;

import Model.CalendarObject.Day;

public interface DaysObservable {
	  public void addObserver(DaysObserver obs);
	  public void removeObserver();
	  public void notifyObserver(boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next);
}
