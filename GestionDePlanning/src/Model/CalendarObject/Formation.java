package Model.CalendarObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *Classe permettant de d�finir une Formation
 * @param title, @param nbDays
 * @param nbHours, @param nbHoursSeances
 * @param modules //Liste des modules de la formation
 */
public class Formation implements Serializable{
	
	private String title;
	
	private ArrayList<Module> modules = new ArrayList<Module>();
	
	private int nbDays = 0;
	private double nbHours = 0;
	private double nbHoursSeances;
	
	/**
	 * Constructeur de la classe Formation
	 * @param title
	 * @param nbHoursSeances
	 */
	public Formation(String title, double nbHoursSeances){
// tester si nb H bien < � 5 ou 6 ...
		this.title = title;
		this.nbHoursSeances = nbHoursSeances;
	}
	
	/**
	 * Ascesseur retournant le nombre d'heures de toutes les seances
	 * @return (nbDays*24 + nbHours)
	 */
	public double getHoursFormation(){
		return (nbDays*24 + nbHours); 
	}
	/**
	 * Ascesseur retournant le nombre d'heures de toutes les seances
	 * @return (nbDays*24 + nbHours)
	 */
	public double getHoursSeances(){
		return nbHoursSeances; 
	}
	/**
	 * Ascesseur retournant le nombre de jours des seances
	 * @return nbDays
	 */
	public int getNbDays(){
		return nbDays; 
	}
	/**
	 * Ascesseur retournant le nombre d'heures des seances
	 * @return nbHours
	 */
	public double getNbHours(){
		return nbHours; 
	}
	
	/**
	 * Ascesseur retournant le titre de la formation
	 * @param title
	 * @return
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Mutateur qui permet de modifier le titre de la formation
	 * @param title
	 * @return
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Mutateur qui permet de modifier le nb d'heure type pour une seance dans la formation et recalcule les jours et heures compt�es des seances programm�es
	 * @param nbHoursSeances
	 * @return
	 */
	public void setNbHoursSeances(double nbHoursSeances){
		nbDays = (int) ((((nbDays*24 + nbHours)/this.nbHoursSeances)*nbHoursSeances) / 24);
		nbHours = (((nbDays*24 + nbHours)/this.nbHoursSeances)*nbHoursSeances) % 24;
		this.nbHoursSeances = nbHoursSeances;
	}
	
	
	/**
	 * M�thode d'ajout d'un module
	 * @param module
	 */
	public void addModule(Module module){
		this.modules.add(module);
	}
	
	/**
	 * M�thode pour soustraire un module
	 * @param module
	 */
	public void removeModule(Module module){
		modules.remove(module);
	}
	
	/**
	 * Ascesseur retournant le nom du module en cours
	 * @param nameModule, @param module
	 * @return
	 */
	public Module getModule(String nameModule){
		Module module = null;
		for(Module m : modules){
			if(m.getName().equals(nameModule))
				module = m;
		}
		return module;
	}
	
	/**
	 * Ascesseur retournant la liste des modules
	 * @param modules
	 * @return
	 */
	public ArrayList<Module> getModules(){
		return modules;
	}
	
	/**
	 * M�thode d'ajout d'une s�ance
	 * @param nameModule
	 */
	public void addSeance(String nameModule){
		this.getModule(nameModule).instantiateISeance();
		this.instantiateNbHours();
	}
	
	/**
	 * M�thode de suppression d'une s�ance
	 * @param nameModule
	 */
	public void removeSeance(String nameModule){
		this.getModule(nameModule).dropInstantiateISeance();
		this.dropInstantiateNbHours();
	}
	
	/**
	 * M�thode permettant d'instantier le nombre d'heures
	 * si le nombre d�heure d�passe 24 alors on ajoute une journ�e
	 */
	private void instantiateNbHours(){
		nbHours+=nbHoursSeances;
		if(nbHours >= 24){
			nbHours -= 24;
			nbDays++;	
		}
	}
	
	/**
	 * M�thode permettant d'instantier le nombre d'heures
	 * suppression d'une journ�e
	 */
	private void dropInstantiateNbHours(){
		nbHours-=nbHoursSeances;
		if(nbHours < 0){
			nbHours += ( 24 + nbHours);
			nbDays--;
		}
	}
}
