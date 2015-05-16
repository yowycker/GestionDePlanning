package test;

import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;
import Model.CalendarObject.Module;
import Model.CalendarObject.Seance;

import org.junit.Test;

public class testSeances extends TestCase{

	public void testgetModule() {
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertTrue("Le module doit avoir un nom", n.getName() == "Anglais" );
		assertTrue("Le module doit avoir une abbreviation", n.getAbbreviation() == "AN" );
		assertTrue("Le module doit avoir une couleur", n.getColor() == Color.white );
		//assertTrue("Le module doit avoir un enseignant", n.getTeacher() == "Champroux" );
		assertTrue("Le module doit avoir un nombre de seance max", n.getMaxSeances() == 10 );
	}
	
	public void testgetNumSeance(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertTrue("", n.getISeance() == 0);
		n.instantiateISeance();
		assertTrue("", n.getISeance() == 1);
	}
	
	public void testsetNumSeance(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertTrue("", n.getISeance() == 0);
		n.instantiateISeance();
		assertTrue("", n.getISeance() == 1);
	}
}
