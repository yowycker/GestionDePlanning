package Controler;

import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;

public abstract class DaysAbstractControler {
	  protected DaysAbstractModel daysModel;
	  
	  public DaysAbstractControler(DaysAbstractModel daysModel){
	    this.daysModel = daysModel;
	  }
	  abstract void control();

		public void initData(Calendar c){
			daysModel.setCalendar(c);
			daysModel.getWeek();
		}
}
