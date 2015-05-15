package Model;

import java.util.ArrayList;

import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;

public class DaysModel extends DaysAbstractModel{
	

	// -------------- Fonctions de l'affichage du calendrier --------------- //
	// --------------------------------------------------------------------- //
	
	public void getWeek(int index){
		days = new ArrayList<Day>();
System.out.println("IDay : " + calendar.getIDay());
System.out.println("getNumDaysWeek : " + getNumDaysWeek());
System.out.println("Date : " + calendar.getDays().get(0).getDate());
		int j = 0;
		if(index == 0)
			firstDaysLoad=0;
    	for(int i = 1; i <= numDaysWeek; i++){
    		if(index == 0 && i < (calendar.getIDay())){
    			days.add(null);
    			firstDaysLoad++;
    		}
    		else if( (index + j - firstDaysLoad) >= calendar.getDays().size()){
    			days.add(null);
    		}
    		
    		else
    		{
        		if(index == 0){
        			days.add(calendar.getDays().get(index + j));
        		}
        		else
        			days.add(calendar.getDays().get(index + j - firstDaysLoad));
        		j++;
    		}
    	}
    	
    	if(index == 0) after = false;
    	else after = true;
    	
    	if((index + getNumDaysWeek() - firstDaysLoad) > calendar.getDays().size() ) next = false;
    	else next = true;
    	
    	notifyObserver(calendar.getCurrentFormation() ,init, days, getNumDaysWeek(),after,next);
	}

	public int getNumDaysWeek(){
		int numDays = numDaysWeek;
		if(calendar.getSunday()){
			numDays--;
			if(calendar.getSaturday())
				numDays--;
		}
		return numDays;
	}
	public int getFinalNumDaysWeek(){
		return numDaysWeek;
	}


	
	public void setCalendar(Calendar c){
		this.calendar = c;
	}
	public void setInit(boolean init){
		this.init = init;
	}

	
	// ------------- Gestion de la formation courante  --------------- //
	// --------------------------------------------------------------- //

	public Formation getCurrentFormation(){
		return calendar.getCurrentFormation();
	}
	public void setCurrentFormation(Formation formation){
		this.calendar.setCurrentFormation(formation);
	}
	
	
	// -------------- Gestion d'affichage des menus  --------------- //
	// ------------------------------------------------------------- //
	
	public void initFormations(){
// Exception : cas ou aucune formation existe (entrer quand même dans la fenetre)
		notifyObserver(calendar.getFormations(), calendar.getCurrentFormation());
	}
	public void initFormations(String formation){
		notifyObserver(calendar.getFormations(), calendar.getFormation(formation));
	}
	
	public void addFormation(Formation formation){
		this.calendar.addFormation(formation);
	}
	public void modifyFormation(String formation, Formation newformation){
// Pas encore fonctionnelle
		this.calendar.modifyFormation(formation,newformation);
	}
	public void deleteFormation(Formation formation){
		this.calendar.removeFormation(formation);
	}
	public ArrayList<Formation> getFormations(){
		return calendar.getFormations();
	}
	
	
	public void initModules(){
		notifyObserver(calendar.getCurrentFormation(), calendar.getCurrentFormation().getModules().get(0),true);
	}
	public void initModules(String nameModule){
		notifyObserver(calendar.getCurrentFormation(), calendar.getCurrentFormation().getModule(nameModule),false);
	}
	public void addModule(Module newModule){
		this.calendar.getCurrentFormation().addModule(newModule);
	}
	public void modifyModule(String nameModule, Module newModule){
		this.calendar.getCurrentFormation().getModule(nameModule).setAbbreviation(newModule.getAbbreviation());
		this.calendar.getCurrentFormation().getModule(nameModule).setName(newModule.getName());
		this.calendar.getCurrentFormation().getModule(nameModule).setColor(newModule.getColor());
		this.calendar.getCurrentFormation().getModule(nameModule).setMaxSeances(newModule.getMaxSeances());
	}
	public void deleteModule(String nameModule){
		this.calendar.getCurrentFormation().removeModule(calendar.getCurrentFormation().getModule(nameModule));
	}
}