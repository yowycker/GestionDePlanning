package test;

import Exceptions.FunctionException;
import junit.framework.TestCase;

public class testExceptionFunction extends TestCase{
	
	public void testDayDebut() throws Exception{
		assertEquals("Le jour de debut est inf�rieur � la date minimum accept�e",FunctionException.erreurDate("debut", 0, 2, 2015));
		assertEquals("Le jour de debut est sup�rieur � la date maximum accept�e",FunctionException.erreurDate("debut", 30, 2, 2015));
	}
	public void testDayFin() throws Exception{
		assertEquals("Le jour de fin est inf�rieur � la date minimum accept�e",FunctionException.erreurDate("fin", 0, 2, 2015));
		assertEquals("Le jour de fin est sup�rieur � la date maximum accept�e",FunctionException.erreurDate("fin", 30, 2, 2015));
	}
	public void testDayMonthDebut() throws Exception{
		assertEquals("Le mois de debut est inf�rieur � la date minimum accept�e",FunctionException.erreurDate("debut", 2, -1, 2015));
		assertEquals("Le mois de debut est inf�rieur � la date minimum accept�e",FunctionException.erreurDate("debut", 2, 0, 2015));
		assertEquals("Le mois de debut est sup�rieur � la date maximum accept�e",FunctionException.erreurDate("debut", 2, 15, 2015));
	}
	public void testDayMonthFin() throws Exception{
		assertEquals("Le mois de fin est inf�rieur � la date minimum accept�e",FunctionException.erreurDate("fin", 2, 0, 2015));
		assertEquals("Le mois de fin est sup�rieur � la date maximum accept�e",FunctionException.erreurDate("fin", 2, 15, 2015));
	}
	public void testDayYearDebut() throws Exception{
		assertEquals("L'ann�e de debut est inf�rieure � la date minimum accept�e",FunctionException.erreurDate("debut", 2, 2, 1899));
		assertEquals("L'ann�e de debut est sup�rieure � la date maximum accept�e",FunctionException.erreurDate("debut", 2, 2, 2100));
	}
	public void testDayYearFin() throws Exception{
		assertEquals("L'ann�e de fin est inf�rieure � la date minimum accept�e",FunctionException.erreurDate("fin", 2, 2, 1899));
		assertEquals("L'ann�e de fin est sup�rieure � la date maximum accept�e",FunctionException.erreurDate("fin", 2, 2, 2100));
	}
}
