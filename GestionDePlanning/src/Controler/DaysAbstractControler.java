package Controler;

import java.util.ArrayList;

import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;

public abstract class DaysAbstractControler {
	  protected DaysAbstractModel daysModel;
	  protected int index = 0;
	  protected boolean isInit = false;
	  
	  protected final int nbYearsList = 7;
	  
// Affichage calendrier
	  public DaysAbstractControler(DaysAbstractModel daysModel){
	    this.daysModel = daysModel;
	  }
	  public abstract void nextWeek();
	  public abstract void afterWeek();
	  
	  public abstract void newCalendar(String Years, boolean holiday, boolean saturday, boolean sunday);

	  public abstract void initData(Calendar c);
	  
	  
// Affichage Menus
	  public abstract void newFormations(String title, double nbHoursSeances);
	  public abstract void initFormations();
	  
// recup de listes
	  public abstract ArrayList<String> getListYears();
}
