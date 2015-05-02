package Model.CalendarObject;

import java.util.ArrayList;

public class DayFormationSeances {
	private String formation;
	
	private Seance[] seances= new Seance[2];
	
	public DayFormationSeances(String formation){
		this.formation = formation;
		this.seances[0] = null;
		this.seances[1] = null;
	}

	public String getFormation(){
		return formation;
	}
	public Seance getSeance(int index){
		return seances[index];
	}
	public void setSeance(int index, Seance seance){
		seances[index] = seance;
	}
}
