package Model.CalendarObject;

import java.awt.Color;
import java.io.Serializable;

/**
 * Classe permettant de définir un module
 * @param maxSeances, @param name, @param abbreviation
 * @param color, @param teacher, @param iSeance
 */
public class Module implements Serializable{
	
	private int iSeance = 0;
	private int maxSeances; // peut-être modifié ?
	
	private String abbreviation;
	private String name;
	
	private Color color;
	
	/**
	 * Constructeur de la classe Module
	 * @param name
	 * @param abbreviation
	 * @param color
	 * @param teacher
	 * @param maxSeances
	 */
	public Module(String name, String abbreviation,Color color,int maxSeances){
		this.name=name;
		this.abbreviation = abbreviation;
		this.color=color;
		this.maxSeances=maxSeances;
	}

//Exceptions ici (si numCours depasse max ...)
	
	/**
	 * Méthode pour instancier les Séances de +1
	 */
	public void instantiateISeance(){
		iSeance++;
	}
	
	/**
	 * Méthode pour initialiser de -1
	 */
	public void dropInstantiateISeance(){
		iSeance--;
	}
	
	/**
	 * Ascesseur retournant la position de la séance
	 * @param iSeance
	 * @return
	 */
	public int getISeance(){
		return iSeance;
	}
	
	/**
	 * Ascesseur retournant le nom de la séance
	 * @param name
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Ascesseur retournant l'abbréviation de la séance
	 * @param abbreviation
	 * @return
	 */
	public String getAbbreviation(){
		return abbreviation;
	}
	
	/**
	 * Ascesseur retournant la couleur de la séance
	 * @param color
	 * @return
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * Ascesseur retournant le nb max séance prévu
	 * @param maxSeances
	 * @return
	 */
	public int getMaxSeances(){
		return maxSeances;
	}
	
	/**
	 * Mutateur modifiant le nom du module
	 * @param name
	 * @return
	 */
	public void setName(String name){
		this.name=name;
	}
	
	/**
	 * Mutateur modifiant l'abbréviation du module
	 * @param abbreviation
	 * @return
	 */
	public void setAbbreviation(String abbreviation){
		this.abbreviation = abbreviation;
	}
	
	/**
	 * Mutateur modifiant la couleur du module
	 * @param color
	 * @return
	 */
	public void setColor(Color color){
		this.color=color;
	}
	
	/**
	 * Mutateur modifiant le nb max séance prévu
	 * @param maxSeances
	 * @return
	 */
	public void setMaxSeances(int maxSeances){
		this.maxSeances=maxSeances;
	}
	
	/**
	 * Comparaison entre le module et la séance
	 * @param module
	 * @return
	 */
	public boolean equals(Module module){
		if(this.name.equals(module.getName()) || this.abbreviation.equals(module.getAbbreviation()) || this.color.equals(module.getColor()))
			return true;
		else
			return false;
	}
}