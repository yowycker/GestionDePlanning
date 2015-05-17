package Obs;

import java.util.ArrayList;

import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Model.CalendarObject.Teacher;

public interface DaysObserver {
	  public void update(Formation currentFormation,boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next);
	  public void update(ArrayList<Formation> formations, Formation currentFormation, boolean isInit);
	  public void update(Formation currentFormation, Module currentModule, boolean isInit, boolean initSeances);
	  public void update(ArrayList<Day> days, int firstDay, int lastDay, int posFirstDay, boolean after, boolean next, int month, int year, int numweeks);
	  public void update(ArrayList<Teacher> teachers, Teacher currentTeacher, boolean isInit, boolean inCalendar, boolean initSeances);
}
