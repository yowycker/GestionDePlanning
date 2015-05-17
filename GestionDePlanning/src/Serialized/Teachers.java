package Serialized;

import java.io.Serializable;
import java.util.ArrayList;

import Model.CalendarObject.Teacher;

public class Teachers implements Serializable{
	
	static private final long serialVersionUID = 8L;
	
	private ArrayList<Teacher> teachers;

	public ArrayList<Teacher> getTeachers(){
		return teachers;
	}
	
	public Teachers(ArrayList<Teacher> teachers){
		this.teachers = teachers;
	}
}
