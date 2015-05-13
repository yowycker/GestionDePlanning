package Obs;

import java.util.ArrayList;

import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;

public interface DaysObservable {
	  public void addObserver(DaysObserver obs);
	  public void removeObserver();
	  public void notifyObserver(Formation currentFormation,boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next);
	  public void notifyObserver(ArrayList<Formation> formations, Formation currentFormation);
}
