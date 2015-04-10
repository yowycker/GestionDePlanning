package Model;

import java.util.ArrayList;

import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;

public class DaysModel extends DaysAbstractModel{

	/*
	 on va devoir recuperer pour les test/ controles du controler :
	 -	Le jours de la semaine de commencement
	 
	 Ajouter JourFin ???? Erreur si plus de valeurs dans la liste ... Avec longueur de la liste = index + 7
	 */	
	
	
	@Override
	public void getWeek() {
		days = new ArrayList<Day>();

    	for(int i = 0; i < getNumDays(); i++){
    		if(index == 0 && i < calendar.getIDay())
    			days.add(null);
    		else if( (index + i) > calendar.getDays().size())
    			days.add(null);
    		else
    			days.add(calendar.getDays().get(index + i));
    	}
    	notifyObserver(days,getNumDays());
	}

	@Override
	public void getNextWeek() {
		index += numWeekDays;
		getWeek();
	}

	@Override
	public void getAfterWeek() {
		index -= numWeekDays;
		getWeek();
	}

	@Override
	public int getNumDays() {
		int numDays = numWeekDays;
		if(calendar.getSunday()){
			numDays--;
			if(calendar.getSaturday())
				numDays--;
		}
		return numDays;
	}

	@Override
	public void setCalendar(Calendar c) {
		calendar = c;
	}
}