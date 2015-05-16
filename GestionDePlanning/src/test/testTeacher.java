package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import Model.CalendarObject.Teacher;

public class testTeacher extends TestCase{


	public void testgetEmail() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","champroux@u-pec.fr",t.getEmail());
	}
	
	public void testgetPhone() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","0620565485",t.getPhone());
	}
	
	public void testgetAbbreviation() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","CN",t.getAbbreviation());
	}
	
	public void testgetName() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","Champroux",t.getName());
	}
	
	public void testgetFirstname() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","Nathalie",t.getFirstname());
	}
	
	public void testsetEmail() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","champroux@u-pec.fr",t.getEmail());
		t.setEmail("champroux@gmail.com");
		assertEquals("","champroux@gmail.com",t.getEmail());
	}
	
	public void testsetPhone() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","0620565485",t.getPhone());
		t.setPhone("0620565486");
		assertEquals("","0620565486",t.getPhone());
	}
	
	public void testsetAbbreviation() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","CN",t.getAbbreviation());
		t.setAbbreviation("NC");
		assertEquals("","NC",t.getAbbreviation());
	}
	
	public void testsetName() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","Champroux",t.getName());
		t.setName("Champ");
		assertEquals("","Champ",t.getName());
	}
	
	public void testsetFirstname() {
		Teacher t = new Teacher("champroux@u-pec.fr","0620565485","CN","Champroux","Nathalie");
		assertEquals("","Nathalie",t.getFirstname());
		t.setFirstname("Nat");
		assertEquals("","Nat",t.getFirstname());
	}
}
