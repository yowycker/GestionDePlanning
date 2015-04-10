package Model.CalendarObject;

public class Seance {

	private Module module;
	private int numSeance;

	public Seance(Module module,int numSeance){
		this.module=module;
		this.numSeance = numSeance;
	}

	public Module getModule(){
		return module;
	}
	// Non valide pour l'instant
	public int getNumSeance(){
		return numSeance;
	}
	
	public void setNumSeance(int numSeance){
		this.numSeance=numSeance;
	}
}
