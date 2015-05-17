package test;

import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

import Model.CalendarObject.Module;

public class testModule extends TestCase{

	public void testgetName() {
		Module n = new Module("Anglais", "AN", Color.white, 10 ,null);
		assertTrue("Le module doit avoir un nom", n.getName() == "Anglais" );
	}
	
	public void testgetAbbreviation() {
		Module n = new Module("Anglais", "AN", Color.white, 10 , null);
		assertTrue("Le module doit avoir une abbreviation", n.getAbbreviation() == "AN" );
	}

}
