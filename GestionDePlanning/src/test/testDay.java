package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Teacher;

public class testDay extends TestCase{

	public void testgetDate() {
		Day d = new Day("Jeudi",4,1,1,2015,false);
		assertEquals("","04/01/2015",d.getDate());
	}

	
	public void testsetMorning(){
		Day d = new Day("Jeudi",4,1,1,2015,false);
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		Formation f = new Formation("L3", 3.5);
		d.setMorning(f,"Anglais",t);
		assertEquals("","04/01/2015",d.getMorning(f));
	}
}
