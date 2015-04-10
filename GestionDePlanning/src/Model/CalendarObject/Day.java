package Model.CalendarObject;

public class Day {
	private Seance[] dayPlanning = new Seance[2];
	private String dayName;
	//private Date date;
	private int numDay, numWeek, numMonth, numYear;
	private boolean holiday;
	
	public Day(String dayName, int numDay, int numWeek, int numMonth, int numYear){
		this.dayName = dayName;
		this.numDay = numDay;
		this.numWeek = numWeek;
		this.numMonth = numMonth;
		this.numYear = numYear;
		
		this.holiday = false;
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
	
	
	public void setMatin(Seance seance){
		dayPlanning[0]=seance;
	}
	public void setApresMidi(Seance seance){
		dayPlanning[1]=seance;
	}

	public Seance getMatin(){
		return dayPlanning[0];
	}
	public Seance getApresMidi(){
		return dayPlanning[1];
	}
	public boolean getFerie(){
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
}