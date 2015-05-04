package Model.CalendarObject;

import java.awt.Color;

/**
 * Classe permettant de d�finir un module
 * @param maxSeances, @param name, @param abbreviation
 * @param color, @param teacher, @param iSeance
 */
public class Module {
	
	private int iSeance = 0;
	private final int maxSeances; // peut-�tre modifi� ?
	
	private String abbreviation;
	private String name;
	private String teacher;
	
	private Color color;
	
	/**
	 * Constructeur de la classe Module
	 * @param name
	 * @param abbreviation
	 * @param color
	 * @param teacher
	 * @param maxSeances
	 */
	public Module(String name, String abbreviation,Color color,String teacher,int maxSeances){
		this.name=name;
		this.abbreviation = abbreviation;
		this.color=color;
		this.teacher=teacher;
		this.maxSeances=maxSeances;
	}

//Exceptions ici (si numCours depasse max ...)
	
	/**
	 * M�thode pour instancier les S�ances de +1
	 */
	public void instantiateISeance(){
		iSeance++;
	}
	
	/**
	 * M�thode pour initialiser de -1
	 */
	public void dropInstantiateISeance(){
		iSeance--;
	}
	
	/**
	 * Ascesseur retournant la position de la s�ance
	 * @param iSeance
	 * @return
	 */
	public int getISeance(){
		return iSeance;
	}
	
	/**
	 * Ascesseur retournant le nom de la s�ance
	 * @param name
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Ascesseur retournant l'abbr�viation de la s�ance
	 * @param abbreviation
	 * @return
	 */
	public String getAbbreviation(){
		return abbreviation;
	}
	
	/**
	 * Ascesseur retournant la couleur de la s�ance
	 * @param color
	 * @return
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * Ascesseur retournant l'enseignant de la s�ance
	 * @param teacher
	 * @return
	 */
	public String getTeacher(){
		return teacher;
	}
	
	/**
	 * Ascesseur retournant le nb max s�ance pr�vu
	 * @param maxSeances
	 * @return
	 */
	public int getMaxSeances(){
		return maxSeances;
	}
	
	/**
	 * Comparaison entre le module et la s�ance
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