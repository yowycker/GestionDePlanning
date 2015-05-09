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
	
	/**
	 * Constructeur de la classe Day
	 * @param dayName
	 * @param numDay
	 * @param numWeek
	 * @param numMonth
	 * @param numYear
	 * @param holiday
	 */
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
	
	/**
	 * Ascesseur retournant les index de la date en cours
	 * @return
	 */
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
	
	/**
	 * Mutateur permettant de modifier les variables locales pour la matin�e (Formation en cours & Nom du module)
	 * @param currentFormation
	 * @param nameModule
	 */
	public void setMorning(Formation currentFormation, String nameModule){
		this.getFormationSeances(currentFormation.getTitle()).setSeance(0, new Seance(currentFormation.getModule(nameModule)));
	}
	
	/**
	 * Mutateur permettant de modifier les variables locales pour l'apr�s-midi (Formation en cours & Nom du module)
	 * @param currentFormation
	 * @param nameModule
	 */
	public void setAfternoon(Formation currentFormation, String nameModule){
		this.getFormationSeances(currentFormation.getTitle()).setSeance(1, new Seance(currentFormation.getModule(nameModule)));
	}

	/**
	 * Ascesseur retournant la formation actuelle (matin�e)
	 * @param currentFormation
	 * @return
	 */
	public Seance getMorning(Formation currentFormation){
		return this.getFormationSeances(currentFormation.getTitle()).getSeance(0);
	}
	
	/**
	 * Ascesseur retournant la formation actuelle (apr�s-midi)
	 * @param currentFormation
	 * @return
	 */
	public Seance getAfternoon(Formation currentFormation){
		return this.getFormationSeances(currentFormation.getTitle()).getSeance(1);
	}
	
	/**
	 * 
	 * @param formation
	 * @return
	 */
	private DayFormationSeances getFormationSeances(String formation){
		DayFormationSeances fSeances = null;
		for(DayFormationSeances s : formationsSeances){
			if(s.getFormation().equals(formation)){
				fSeances=s;
			}
		}
		return fSeances;
	}
	
	/**
	 * M�thode d'ajout d'une S�ance � une formation
	 * @param formation
	 */
	public void addFormationSeances(String formation){
		if(this.getFormationSeances(formation) == null)
			formationsSeances.add(new DayFormationSeances(formation));
	}
	
	/**
	 * M�thode de suppression d'une S�ance d'une formation
	 * @param formation
	 */
	public void removeFormationSeances(String formation){
		formationsSeances.remove(this.getFormationSeances(formation));
	}
	
	/**
	 * Ascesseur retournant les vacances
	 * @return
	 */
	public boolean getHoliday(){
		return holiday;
	}
	
	/**
	 * Ascesseur retournant le nom du Jour
	 * @return
	 */
	public String getName(){
		return dayName;
	}
	
	/**
	 * Ascesseur retournant l'index du Jour
	 * @return
	 */
	public int getNumDay(){
		return numDay;
	}
	
	/**
	 * Ascesseur retournant l'index de la semaine
	 * @return
	 */
	public int getNumWeek(){
		return numWeek;
	}
	
	/**
	 * Ascesseur retournant l'index du mois
	 * @return
	 */
	public int getNumMonth(){
		return numMonth;
	}
	
	/**
	 * Ascesseur retournant l'index de l'ann�e
	 * @return
	 */
	public int getYear(){
		return numYear;
	}
	
	
	/**
	 * Red�finissons de la fonction equals()
	 * @param day
	 * @return
	 */
	public boolean equals(Day day){
		if(this.numDay == day.getNumDay() && this.numMonth == day.getNumMonth() && this.numYear == day.getYear())
			return true;
		else
			return false;
	}
}