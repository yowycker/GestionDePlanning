package View.DialogMenu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import Serialized.DeserializeObject;
import Controler.DaysAbstractControler;
 
 
public class OpenFiles extends JFileChooser{
	FiltreExtensible filtre;
	PrintWriter sortie;
	File fichier;
	
	public OpenFiles(DaysAbstractControler daysControler) throws IOException{
		super(new File("."));
		
		//this.daysControler = daysControler;
		
		filtre = new FiltreExtensible("Fichier Calendar");
		filtre.addExtension(".serial");
		filtre.setDescription("Fichiers Calendar");
		this.setFileFilter(filtre);
		this.setAcceptAllFileFilterUsed(false);
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		if (this.showOpenDialog(null)== 
		    JFileChooser.APPROVE_OPTION) {
		    fichier = this.getSelectedFile();

		    	System.out.println(fichier.getPath());
		    	DeserializeObject.deserialiseCalendar(fichier);
		    	daysControler.initData(DeserializeObject.getCalendar());
		    
		    sortie = new PrintWriter(new FileWriter(fichier.getPath(), true));
		    sortie.println("");
		    sortie.close();
		}
	}
}