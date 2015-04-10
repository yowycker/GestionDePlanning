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
	public void getWeek(int index) {
		days = new ArrayList<Day>();

    	for(int i = 0; i < getNumDaysWeek(); i++){
    		if(index == 0 && i < calendar.getIDay())
    			days.add(null);
    		else if( (index + i) >= calendar.getDays().size())
    			days.add(null);
    		else
    			days.add(calendar.getDays().get(index + i));
    	}
    	
    	if(index == 0) after = false;
    	else after = true;
    	
    	if((index + getNumDaysWeek()) > calendar.getDays().size() ) next = false;
    	else next = true;
    	
    	notifyObserver(days,getNumDaysWeek(),after,next);
	}

	@Override
	public int getNumDaysWeek() {
		int numDays = numDaysWeek;
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