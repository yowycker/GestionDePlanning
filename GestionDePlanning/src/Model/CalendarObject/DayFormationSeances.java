package Model.CalendarObject;

/**
 * Classe défissant les séances du jour
 * @param formation, @param seances
 */
public class DayFormationSeances {
	
	private String formation;
	//Nb séance --> 2 par jour
	private Seance[] seances= new Seance[2]; 
	
	/**
	 * Constructeur de la classe DayFormationSeances
	 * @param formation
	 * par défaut seances passer null (rien n'est planifié) 
	 */
	public DayFormationSeances(String formation){
		this.formation = formation;
		this.seances[0] = null;
		this.seances[1] = null;
	}
	
	/**
	 * Ascesseur retournant la formation
	 * @param formation
	 * @return
	 */
	public String getFormation(){
		return formation;
	}
	
	/**
	 * Mutateur retournant la formation
	 * @param formation
	 * @return
	 */
	public void setFormation(String formation){
		this.formation=formation;
	}
	
	/**
	 * Ascesseur retournant la position de la séance (1-->Matin ou 2-->Après-midi)
	 * @param index
	 * @return
	 */
	public Seance getSeance(int index){
		return seances[index];
	}
	
	/**
	 * Méthode de MAJ de la variable locale seance
	 * @param index
	 * @param seance
	 */
	public void setSeance(int index, Seance seance){
		seances[index] = seance;
	}
}
