package Model.CalendarObject;

import java.util.ArrayList;

public class Day {
// A supprimer
private Seance[] dayPlanning = new Seance[2];

	private ArrayList<DayFormationSeances> formationsSeances = new ArrayList<DayFormationSeances>();
	
	private String dayName;
	//private Date date;
	private int numDay, numWeek, numMonth, numYear;
	private boolean holiday;
	
	public Day(String dayName, int numDay, int numWeek, int numMonth, int numYear, boolean holiday){
		dayPlanning[0]=null;
		dayPlanning[1]=null;
		
		this.dayName = dayName;
		this.numDay = numDay;
		this.numWeek = numWeek;
		this.numMonth = numMonth;
		this.numYear = numYear;
		
		this.holiday = holiday;
	}
	public String getDate(){
		String j,m,a;
		j=Integer.toString(numDay);
		m=Integer.toString(numMonth);
		a=Integer.toString(numYear);
		if(j.length() == 1){
			j = "0" + j;
		}
		if(m.length() == 1){
			m = "0" + m;
		}
		return j + "/" + m + "/" + a;
	}
	

	public void setMorning(Formation currentFormation, String nameModule){
		this.getFormationSeances(currentFormation.getTitle()).setSeance(0, new Seance(currentFormation.getModule(nameModule)));
	}
	public void setAfternoon(Formation currentFormation, String nameModule){
		this.getFormationSeances(currentFormation.getTitle()).setSeance(1, new Seance(currentFormation.getModule(nameModule)));
	}

	public Seance getMorning(Formation currentFormation){
		return this.getFormationSeances(currentFormation.getTitle()).getSeance(0);
	}
	public Seance getAfternoon(Formation currentFormation){
		return this.getFormationSeances(currentFormation.getTitle()).getSeance(1);
	}
	private DayFormationSeances getFormationSeances(String formation){
		DayFormationSeances fSeances = null;
		for(DayFormationSeances s : formationsSeances){
			if(s.getFormation().equals(formation)){
				fSeances=s;
			}
		}
		return fSeances;
	}
	public void addFormationSeances(String formation){
		if(this.getFormationSeances(formation) == null)
			formationsSeances.add(new DayFormationSeances(formation));
	}
	public void removeFormationSeances(String formation){
		formationsSeances.remove(this.getFormationSeances(formation));
	}
	
	
	public boolean getHoliday(){
		return holiday;
	}
	public String getName(){
		return dayName;
	}
	public int getNumDay(){
		return numDay;
	}
	public int getNumWeek(){
		return numWeek;
	}
	public int getNumMonth(){
		return numMonth;
	}
	public int getYear(){
		return numYear;
	}
	
	
	
	public boolean equals(Day day){
		if(this.numDay == day.getNumDay() && this.numMonth == day.getNumMonth() && this.numYear == day.getYear())
			return true;
		else
			return false;
	}
}