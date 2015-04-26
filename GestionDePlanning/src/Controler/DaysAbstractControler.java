package Controler;

import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;

public abstract class DaysAbstractControler {
	  protected DaysAbstractModel daysModel;
	  protected int index = 0;
	  protected boolean isInit = false;
	  
	  public DaysAbstractControler(DaysAbstractModel daysModel){
	    this.daysModel = daysModel;
	  }
	  protected abstract void control();
	  public abstract void nextWeek();
	  public abstract void afterWeek();
	  
	  public abstract void newCalendar(String Years, boolean holiday, boolean saturday, boolean sunday);

	  public abstract void initData(Calendar c);
}
