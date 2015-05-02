package Model.CalendarObject;

import java.awt.Color;

public class Module {
	private final int maxSeances; // peut-être modifié ?
	private String name;
	private String abbreviation;
	private Color color;
	
	private String teacher;
	
	private int iSeance = 0;
	
	public Module(String name, String abbreviation,Color color,String teacher,int maxSeances){
		this.name=name;
		this.abbreviation = abbreviation;
		this.color=color;
		this.teacher=teacher;
		
		this.maxSeances=maxSeances;
	}

//Exceptions ici (si numCours depasse max ...)
	public void instantiateISeance(){
		iSeance++;
	}
	public void dropInstantiateISeance(){
		iSeance--;
	}
	public int getISeance(){
		return iSeance;
	}
	
	public String getName(){
		return name;
	}
	public String getAbbreviation(){
		return abbreviation;
	}
	public Color getColor(){
		return color;
	}
	public String getTeacher(){
		return teacher;
	}
	public int getMaxSeances(){
		return maxSeances;
	}
	
	
	public boolean equals(Module module){
		if(this.name.equals(module.getName()) || this.abbreviation.equals(module.getAbbreviation()) || this.color.equals(module.getColor()))
			return true;
		else
			return false;
	}
}