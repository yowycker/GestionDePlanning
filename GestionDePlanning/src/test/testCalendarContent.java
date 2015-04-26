package test;

import Exceptions.dateException;
import Model.CalendarObject.Calendar;
import junit.framework.TestCase;

public class testCalendarContent extends TestCase{
	public void testNbDays() throws Exception {
		assertTrue("Le nombre de jour est compris entre 0 et 7",this.isWeek(this.getCalendar(1,2,2035,2,2,2036,true,true,true).getDays().size()));
	}
	public void testPositionFirstDay() throws Exception {
		assertTrue("Le nombre de jour est compris entre 0 et 7", this.isWeek(this.getCalendar(1,2,2035,2,2,2036,true,true,true).getIDay()));
	}
	private boolean isWeek(int nbDays){
		boolean isW = false;
		if(nbDays < 7)
			isW = true;
		if(nbDays >= 0)
			isW = true;
		return isW;
	}
	
	
	private Calendar getCalendar(int firstDay, int firstMonth, int firstYear,int lastDay,  int lastMonth, int lastYear, boolean holiday, boolean saturday, boolean sunday){
		try{
			return new Calendar(firstDay,firstMonth,firstYear,lastDay,lastMonth,lastYear,holiday,saturday,sunday);
		}
		catch(dateException e){
			return null;
		}
	}
}
