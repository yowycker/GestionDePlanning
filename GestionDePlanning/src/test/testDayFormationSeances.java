package test;

import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

import Model.CalendarObject.DayFormationSeances;
import Model.CalendarObject.Module;
import Model.CalendarObject.Seance;
import Model.CalendarObject.Teacher;

public class testDayFormationSeances extends TestCase{

	public void testgetFormation() {
		DayFormationSeances d =new DayFormationSeances("L3");
		assertEquals("","L3",d.getFormation());
	}

	public void testsetFormation() {
		DayFormationSeances d =new DayFormationSeances("L3");
		assertEquals("","L3",d.getFormation());
		d.setFormation("L3A");
		assertEquals("","L3A",d.getFormation());
	}
	
	public void testgetSeance(){
		Seance[] seances= new Seance[2]; 
		DayFormationSeances d =new DayFormationSeances("L3");
		assertEquals("",null,d.getSeance(1));
	}
	
	public void testsetSeance(){
		Seance[] seances= new Seance[2]; 
		DayFormationSeances d =new DayFormationSeances("L3");
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		Seance s = new Seance(n,t);
		assertEquals("",null,d.getSeance(1));
		d.setSeance(1,s);
		assertEquals("",s,d.getSeance(1));
	}
}
