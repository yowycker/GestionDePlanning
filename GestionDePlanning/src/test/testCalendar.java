package test;

import Exceptions.dateException;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Formation;
import junit.framework.TestCase;

public class testCalendar extends TestCase{
	public void testNbDays() throws Exception {
		assertTrue("Le nombre de jour dans l'année est compris entre 365 et 366",this.isYear(this.getCalendar(1,1,2035,1,1,2036,true,true,true).getDays().size()));
	}
	public void testPositionFirstDay() throws Exception {
		assertTrue("Le numéro de jour de la semaine est compris entre 0 et 7", this.isWeek(this.getCalendar(1,2,2035,2,2,2036,true,true,true).getIDay()));
	}
	
	public void testgetIDay(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("",4,c.getIDay());
	}
	
	public void testgetIWeek(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("",2,c.getIWeek());
	}
	
	public void testgetHoliday(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("",true,c.getHoliday());
	}
	
	public void testgetSaturday(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("",false,c.getSaturday());
	}
	
	public void testgetSunday(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("",true,c.getSunday());
	}
	
	public void testgetMonthString(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("","Janvier",c.getMonthString(1));
	}
	
	public void testsetCurrentFormation(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("", "L3",c.getFormations());
	}
	
	public void testgetCurrentFormation(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("",f,c.getFormation("L3"));
	}
	
	public void testaddFormation(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		assertTrue("", c.getFormations().size()==0);
		c.addFormation(f);
		assertTrue("", c.getFormations().size()==1);
	}
	
	public void testmodifyFormation(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		c.setCurrentFormation(f);
		assertEquals("",f,c.getFormation("L3"));
		c.modifyFormation("L3A",f);
		assertEquals("",f,c.getFormation("L3A"));
	}
	
	public void testremoveFormation(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		assertTrue("", c.getFormations().size()==0);
		c.addFormation(f);
		assertTrue("", c.getFormations().size()==1);
		c.removeFormation(f);
		assertTrue("", c.getFormations().size()==0);
	}
	
	public void testgetFormations(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		Formation f1 = new Formation("L3A", 2);
		assertTrue("", c.getFormations().size()==0);
		c.addFormation(f);
		assertTrue("", c.getFormations().size()==1);
		c.addFormation(f1);
		assertTrue("", c.getFormations().size()==2);
		c.removeFormation(f);
		c.removeFormation(f1);
		assertTrue("", c.getFormations().size()==0);
	}
	
	public void testgetFormation(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		assertEquals("",f,c.getFormation("L3"));
	}
	
	public void testsetMorningSeance(){
		Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Formation f = new Formation("L3", 3.5);
		c.addFormation(f);
		
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
