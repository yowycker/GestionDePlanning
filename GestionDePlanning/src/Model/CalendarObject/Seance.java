package Model.CalendarObject;

/**
 *	Classe permettant de d�finir une Seance
 * @param module, @param numSeance
 */
public class Seance {
	
	private Module module;
	private int numSeance;
	
	/**
	 * Constructeur de la classe Seance
	 * @param module
	 * Chaque module est instanci� dans la Seance
	 */
	public Seance(Module module){
		this.module=module;
		this.module.instantiateISeance();
		this.numSeance = module.getISeance();
	}
	
	/**
	 * Ascesseur retournant le module
	 * @return
	 * @param module
	 */
	public Module getModule(){
		return module;
	}
	
	/**
	 * Ascesseur retournant le num�ro de la s�ance
	 * @return
	 * @param numSeance
	 */
	// Non valide pour l'instant
	public int getNumSeance(){
		return numSeance;
	}
	
	/**
	 * M�thode de MAJ de la variable locale numSeance
	 * @param numSeance
	 */
	public void setNumSeance(int numSeance){
		this.numSeance=numSeance;
	}
}
