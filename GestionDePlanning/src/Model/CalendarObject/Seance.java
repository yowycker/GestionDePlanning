package Model.CalendarObject;

public class Seance {

	private Module module;
	private int numSeance;

	public Seance(Module module){
		this.module=module;
		this.module.instantiateISeance();
		this.numSeance = module.getISeance();
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
