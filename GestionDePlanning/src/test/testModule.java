package test;

import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

import Model.CalendarObject.Module;

public class testModule extends TestCase{

	public void testinstantiateISeance(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertTrue("", n.getISeance() == 0);
		n.instantiateISeance();
		assertTrue("", n.getISeance() == 1);
		n.dropInstantiateISeance();
		assertTrue("", n.getISeance() == 0);
	}
	
	public void testgetName() {
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertTrue("Le module doit avoir un nom", n.getName() == "Anglais" );
	}
	
	public void testgetAbbreviation() {
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertTrue("Le module doit avoir une abbreviation", n.getAbbreviation() == "AN" );
	}

	public void testgetColor() {
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertTrue("Le module doit avoir une couleur", n.getColor() == Color.white );
	}
	
	/*public void testgetTeacher() {
		Module n = new Module("Anglais", "AN", Color.white, "Champroux", 10 );
		assertTrue("Le module doit avoir un enseignant", n.getTeacher() == "Champroux" );
	}*/
	
	public void testgetMaxSeances() {
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertTrue("Le module doit avoir un nombre de seance max", n.getMaxSeances() == 10 );
	}
	
	public void testEqualsName(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertFalse("Le module doit avoir un nom", n.getName() == "" );
	}
	
	public void testEqualsAbbreviation(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertFalse("Le module doit avoir une abbreviation", n.getAbbreviation() == "" );
	}
	
	public void testEqualsColor(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		assertFalse("Le module doit avoir une couleur", n.getColor() == Color.red );
	}
	
}
