package Model.CalendarObject;

import java.util.ArrayList;

public class Formation{
	private String title;
	private double nbHoursSeances;
	private ArrayList<Module> modules = new ArrayList<Module>();
	
	private int nbDays = 0;
	private double nbHours = 0;
	
	public Formation(String title, double nbHoursSeances){
// tester si nb H bien < à 5 ou 6 ...
		this.title = title;
		this.nbHoursSeances = nbHoursSeances;
	}
	
	public double getHoursModule(){
		return (nbDays*24 + nbHours);
	}
	public String getTitle(){
		return title;
	}
	
	
	public void addModule(Module module){
// tester si le module existe deja dans la formation (nom, couleur ... etc)
		/*
		for(Module m : modules){
			if(m.equals(module))
				//Exception
		}*/
		this.modules.add(module);
	}
// Exception : Si seance existe, ne pas supprimer module ? ou alors supprimer tous les modules ?
	public void removeModule(Module module){
		modules.remove(module);
	}
	public Module getModule(String nameModule){
		Module module = null;
		for(Module m : modules){
			if(m.getName() == nameModule)
				module = m;
		}
		return module;
	}
	
	public void addSeance(String nameModule){
// Tester si le module existe
// Tester si le nombre de modules max n'est pas déja à son max : ici ou dans module ?
		getModule(nameModule).instantiateISeance();
		this.instantiateNbHours();
	}
	public void removeSeance(String nameModule){
// Tester si le module existe
// Tester si le nombre de modules max n'est pas déja à son max : ici ou dans module ?
		getModule(nameModule).dropInstantiateISeance();
		this.dropInstantiateNbHours();
	}
	private void instantiateNbHours(){
		nbHours+=nbHoursSeances;
		if(nbHours >= 24){
			nbHours -= 24;
			nbDays++;
		}
	}
// exception si le nombre d'heure et de jours < 0
	private void dropInstantiateNbHours(){
		nbHours-=nbHoursSeances;
		if(nbHours < 0){
			nbHours += ( 24 + nbHours);
			nbDays--;
		}
	}
}
