package test;

import Exceptions.dateException;
import Model.CalendarObject.Calendar;
import junit.framework.TestCase;

public class testCalendarContent extends TestCase{
	public void testNbDays() throws Exception {
		assertTrue("Le nombre de jour dans l'année est compris entre 365 et 366",this.isYear(this.getCalendar(1,1,2035,1,1,2036,true,true,true).getDays().size()));
	}
	public void testPositionFirstDay() throws Exception {
		assertTrue("Le numéro de jour de la semaine est compris entre 0 et 7", this.isWeek(this.getCalendar(1,2,2035,2,2,2036,true,true,true).getIDay()));
	}
	private boolean isWeek(int nbDays){
		boolean isW = true;
		if(nbDays > 7)
			isW = false;
		if(nbDays <= 0)
			isW = false;
		return isW;
	}
	private boolean isYear(int nbDays){
		boolean isW = true;
		if(nbDays > 366)
			isW = false;
		if(nbDays <= 365)
			isW = false;
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
