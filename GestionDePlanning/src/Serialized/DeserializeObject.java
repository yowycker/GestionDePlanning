package Serialized;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Model.CalendarObject.Calendar;

public class DeserializeObject {

	private static Calendar c = null;
	
	static public Calendar getCalendar(){
		return c;
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
				System.out.println(c.getCurrentFormation().getTitle());
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
}
