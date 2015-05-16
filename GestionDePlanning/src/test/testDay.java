package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import Model.CalendarObject.Day;

public class testDay extends TestCase{

	public void testgetDate() {
		Day d = new Day("Jeudi",4,1,1,2015,false);
		assertEquals("","04/01/2015",d.getDate());
	}

}
