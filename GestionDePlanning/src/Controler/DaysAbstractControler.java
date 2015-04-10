package Controler;

import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;

public abstract class DaysAbstractControler {
	  protected DaysAbstractModel daysModel;
	  protected int index = 0;
	  
	  public DaysAbstractControler(DaysAbstractModel daysModel){
	    this.daysModel = daysModel;
	  }
	  protected abstract void control();
	  public abstract void nextWeek();
	  public abstract void afterWeek();

		public void initData(Calendar c){
			daysModel.setCalendar(c);
			daysModel.getWeek(index);
		}
}
