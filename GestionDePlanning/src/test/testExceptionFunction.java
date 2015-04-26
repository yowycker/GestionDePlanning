package test;

import Exceptions.FunctionException;
import junit.framework.TestCase;

public class testExceptionFunction extends TestCase{
	
	public void testDayDebut() throws Exception{
		assertEquals("Le jour de debut est inférieur à la date minimum acceptée",FunctionException.erreurDate("debut", 0, 2, 2015));
		assertEquals("Le jour de debut est supérieur à la date maximum acceptée",FunctionException.erreurDate("debut", 30, 2, 2015));
	}
	public void testDayFin() throws Exception{
		assertEquals("Le jour de fin est inférieur à la date minimum acceptée",FunctionException.erreurDate("fin", 0, 2, 2015));
		assertEquals("Le jour de fin est supérieur à la date maximum acceptée",FunctionException.erreurDate("fin", 30, 2, 2015));
	}
	public void testDayMonthDebut() throws Exception{
		assertEquals("Le mois de debut est inférieur à la date minimum acceptée",FunctionException.erreurDate("debut", 2, -1, 2015));
		assertEquals("Le mois de debut est inférieur à la date minimum acceptée",FunctionException.erreurDate("debut", 2, 0, 2015));
		assertEquals("Le mois de debut est supérieur à la date maximum acceptée",FunctionException.erreurDate("debut", 2, 15, 2015));
	}
	public void testDayMonthFin() throws Exception{
		assertEquals("Le mois de fin est inférieur à la date minimum acceptée",FunctionException.erreurDate("fin", 2, 0, 2015));
		assertEquals("Le mois de fin est supérieur à la date maximum acceptée",FunctionException.erreurDate("fin", 2, 15, 2015));
	}
	public void testDayYearDebut() throws Exception{
		assertEquals("L'année de debut est inférieure à la date minimum acceptée",FunctionException.erreurDate("debut", 2, 2, 1899));
		assertEquals("L'année de debut est supérieure à la date maximum acceptée",FunctionException.erreurDate("debut", 2, 2, 2100));
	}
	public void testDayYearFin() throws Exception{
		assertEquals("L'année de fin est inférieure à la date minimum acceptée",FunctionException.erreurDate("fin", 2, 2, 1899));
		assertEquals("L'année de fin est supérieure à la date maximum acceptée",FunctionException.erreurDate("fin", 2, 2, 2100));
	}
}
