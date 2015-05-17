package Serialized;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Model.CalendarObject.Calendar;
import Model.CalendarObject.Teacher;

public class DeserializeObject {

	private static Calendar c = null;
	private static Teachers t = null;
	
	static public Calendar getCalendar(){
		return c;
	}
	static public ArrayList<Teacher> getTeachers(){
		return t.getTeachers();
	}
	
	static public void deserialiseCalendar(File file) {
		try {
			// ouverture d'un flux d'entr�e depuis le fichier "personne.serial"
			FileInputStream fis = new FileInputStream(file);
			// cr�ation d'un "flux objet" avec le flux fichier
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				// d�s�rialisation : lecture de l'objet depuis le flux d'entr�e
				c = (Calendar) ois.readObject();
			} finally {
				// on ferme les flux
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if(c != null) {
			System.out.println(c + " a ete deserialise");
		}
	}
	static public void deserialiseTeachers(File file){
		try {
			// ouverture d'un flux d'entr�e depuis le fichier "personne.serial"
			FileInputStream fis = new FileInputStream(file);
			// cr�ation d'un "flux objet" avec le flux fichier
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				// d�s�rialisation : lecture de l'objet depuis le flux d'entr�e
				t = (Teachers) ois.readObject();
			} finally {
				// on ferme les flux
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if(t != null) {
			System.out.println(t + " a ete deserialise");
		}
	}
}
