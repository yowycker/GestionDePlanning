package Obs;

import java.util.ArrayList;

import Model.CalendarObject.Day;

public interface DaysObserver {
	  public void update(ArrayList<Day> days, int numDays, boolean after, boolean next);
}
