package Obs;

import java.util.ArrayList;

import Model.CalendarObject.Day;

public interface DaysObservable {
	  public void addObserver(DaysObserver obs);
	  public void removeObserver();
	  public void notifyObserver(ArrayList<Day> days, int numJours);
}
