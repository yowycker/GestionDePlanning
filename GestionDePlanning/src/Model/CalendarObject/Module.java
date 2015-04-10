package Model.CalendarObject;

import java.awt.Color;

public class Module {

	private int iSeance = 0;
	
	private final int maxSeances;
	private String Name;
	private Color color;
	private String teacher;
	
	public Module(String Name,Color color,String teacher,int maxSeances){
		this.Name=Name;
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
		return Name;
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
}