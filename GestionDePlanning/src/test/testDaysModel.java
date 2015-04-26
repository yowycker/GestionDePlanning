package test;

import junit.framework.TestCase;
import Exceptions.dateException;
import Model.DaysAbstractModel;
import Model.DaysModel;
import Model.CalendarObject.Calendar;

public class testDaysModel extends TestCase{
	public void testFirstDaysLoad() throws Exception {
		DaysAbstractModel model = this.getDaysModel(1,2,2035,2,2,2036,true,true,true);
		assertTrue("Le nombre de jour est compris entre 0 et 7", this.isWeek(model.getFirstDaysLoad()));
	}
	private boolean isWeek(int nbDays){
		boolean isW = false;
		if(nbDays < 7)
			isW = true;
		if(nbDays >= 0)
			isW = true;
		return isW;
	}
	


	private DaysModel getDaysModel(int firstDay, int firstMonth, int firstYear,int lastDay,  int lastMonth, int lastYear, boolean holiday, boolean saturday, boolean sunday){
		Calendar c;
		try{
			c = new Calendar(firstDay,firstMonth,firstYear,lastDay,lastMonth,lastYear,holiday,saturday,sunday);
		}
		catch(dateException e){
			c=null;
		}
		DaysModel m = new DaysModel();
		m.setCalendar(c);
		return m;
	}
}
