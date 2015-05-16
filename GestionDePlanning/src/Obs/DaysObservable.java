package Obs;

import java.util.ArrayList;

import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;

public interface DaysObservable {
	  public void addObserver(DaysObserver obs);
	  public void removeObserver();
	  public void notifyObserver(Formation currentFormation,boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next);
	  public void notifyObserver(ArrayList<Formation> formations, Formation currentFormation);
	  public void notifyObserver(Formation currentFormation, Module currentModule, boolean isInit);
	  public void notifyObserver(ArrayList<Day> days, int firstDay, int lastDay, int posFirstDay, boolean after, boolean next, int month, int year, int numweeks);
}
