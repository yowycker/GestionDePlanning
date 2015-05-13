package Obs;

import java.util.ArrayList;

import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;

public interface DaysObserver {
	  public void update(Formation currentFormation,boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next);
	  public void update(ArrayList<Formation> formations, Formation currentFormation);
}
