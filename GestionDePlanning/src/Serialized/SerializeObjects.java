package Serialized;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeObjects {
	public static void serialiseObject(String file, Object object){
		try {
				// ouverture d'un flux de sortie vers le fichier "personne.serial"
				FileOutputStream fos = new FileOutputStream(file + ".serial");
	
				// création d'un "flux objet" avec le flux fichier
				ObjectOutputStream oos= new ObjectOutputStream(fos);
				try {
					// sérialisation : écriture de l'objet dans le flux de sortie
					oos.writeObject(object); 
					// on vide le tampon
					oos.flush();
					System.out.println(object + " a ete serialise");
				} finally {
					//fermeture des flux
					try {
						oos.close();
					} finally {
						fos.close();
					}
				}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
