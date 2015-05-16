package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import Exceptions.dateException;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Model.CalendarObject.Seance;

public class testFormation extends TestCase{

	public void testgetHoursFormation() {
		//Calendar c = getCalendar(1,1,2015,30,9,2015,true,false,true);
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Formation f = new Formation("L3", 3.5);
		//c.addFormation(f);
		//c.setCurrentFormation(f);
		f.addModule(n);
		for(int i =0;i<9;i++){
			f.addSeance(n.getName());
		}	
		assertEquals("",31.5,f.getHoursFormation());
		assertEquals("",1,f.getNbDays());
		assertEquals("",7.5,f.getNbHours());
	}
	
	public void testgetHoursSeances(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Formation f = new Formation("L3", 3.5);
		assertTrue("La formation doit avoir un nombre d'heures de toutes les seances", f.getHoursSeances() == 3.5 );
	}
	
	public void testgetNbDays(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Formation f = new Formation("L3", 3.5);
		if(f.getNbDays() >= 365 && f.getNbDays() <= 366){
		assertTrue("La formation doit avoir un nombre de jours des seances", f.getNbDays() >= 365 && f.getNbDays() <= 366);
		}
		else
		assertFalse("La formation doit avoir un nombre de jours des seances", f.getNbDays() == 364 );
	}
	
	public void testgetNbHours(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Formation f = new Formation("L3", 3.5);
		
	}
	
	public void testgetTitle(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Formation f = new Formation("L3", 3.5);
		assertFalse("La formation doit avoir un titre", f.getTitle() == "" );
	}
	
	public void testsetTitle(){
		Formation f = new Formation("L3", 3.5);
		f.setTitle("L3A");
		assertEquals("", f.getTitle(),"L3A");
	}
	
	public void testsetNbHoursSeances(){
		
	}
	
	public void testaddModule(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Formation f = new Formation("L3", 3.5);
		assertTrue("", f.getModules().size()==0);
		f.addModule(n);
		assertTrue("", f.getModules().size()==1);
	}
	
	public void testremoveModule(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Formation f = new Formation("L3", 3.5);
		f.addModule(n);
		assertTrue("", f.getModules().size()==1);
		f.removeModule(n);
		assertTrue("", f.getModules().size()==0);
	}
	
	public void testgetModule(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Formation f = new Formation("L3", 3.5);
		assertFalse("La formation doit avoir un titre", f.getTitle() == "" );
	}
	
	public void testaddSeance(){
		Module n = new Module("Anglais", "AN", Color.white, 10 );
		Module p = new Module("Maths", "MA", Color.red, 10 );
		Formation f = new Formation("L3", 3.5);
		assertTrue("", f.getModules().size()==0);
		f.addModule(n);
		assertTrue("", f.getModules().size()==1);
		f.addSeance("Anglais");
		assertTrue("", f.getModules().size()==1);
		instantiateNbHours();
		f.addSeance("Maths");
		assertTrue("", f.getModules().size()!=1);
	}
	
	public void testremoveSeance(){
		
	}
	
	private void instantiateISeance(){
		int iSeance = 0;
		iSeance++;
	}
	
	private void instantiateNbHours(){
		int nbDays = 0;
		double nbHours = 0;
		double nbHoursSeances = 0;
		nbHours+=nbHoursSeances;
		if(nbHours >= 24){
			nbHours -= 24;
			nbDays++;	
		}
	}
	
	private void dropInstantiateNbHours(){
		int nbDays = 0;
		double nbHours = 0;
		double nbHoursSeances = 0;
		nbHours-=nbHoursSeances;
		if(nbHours < 0){
			nbHours += ( 24 + nbHours);
			nbDays--;
		}
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
