package Obs;

import java.util.ArrayList;

import Model.CalendarObject.Day;

public interface DaysObserver {
	  public void update(boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next);
}
