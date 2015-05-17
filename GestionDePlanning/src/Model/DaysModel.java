package Model;

import java.io.File;
import java.util.ArrayList;

import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Model.CalendarObject.Seance;
import Model.CalendarObject.Teacher;
import Serialized.DeserializeObject;
import Serialized.SerializeObjects;
import Serialized.Teachers;

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
	
	

	public void getMonth(int month, int year, int firstDay, int lastDay, int posFirstDay, int numweeks){
		ArrayList<Day> days = new ArrayList<Day>();
		boolean after = true;
		boolean next = true;
		for(Day d : calendar.getDays()){
//if(this.getFirstDayWeek(d).getNumMonth() == month && this.getFirstDayWeek(d).getYear() == year || this.getLastDayWeek(d).getNumMonth() == month && this.getLastDayWeek(d).getYear() == year){

				if(d.getNumMonth() == month && d.getYear() == year){
					days.add(d);
					if(calendar.getDays().get(0) == d){
						after = false;
					}
					else if(calendar.getDays().get(calendar.getDays().size() -1) == d){
						next = false;
					}
				}
//				else days.add(null);
//}
    	}
		notifyObserver(days,firstDay,lastDay,posFirstDay,after, next, month, year, numweeks);
	}
	public int getNumDayMonth(int month, int year){
		return calendar.numberDayMonth(month, year);
	}
/*	public Day getLastDayWeek(Day day){
		int position = calendar.getDays().indexOf(day);
		if(calendar.getDays().get(position).getName() != "Dimanche")
			while(calendar.getDays().get(position).getName() != "Dimanche" && position < (calendar.getDays().size() -1)){
					position++;
			}
		return calendar.getDays().get(position);
	}
	public Day getFirstDayWeek(Day day){
		int position = calendar.getDays().indexOf(day);
		if((this.getIYear() != day.getYear() || calendar.getIWeek() != day.getNumMonth()) && calendar.getDays().get(position).getName() != "Lundi")
			while(calendar.getDays().get(position).getName() != "Lundi" && position > 0){
					position--;
			}
		return calendar.getDays().get(position);
	}
*/
	
	public void setCalendar(Calendar c){
		this.calendar = c;
	}
	public void setInit(boolean init){
		this.init = init;
	}


	// -------------- Fonctions de Gestion des Jours --------------- //
	// ------------------------------------------------------------- //
	
	public int getPosDayWeek(int day, int month, int year){
		return calendar.day(1, month, year);
	}
	public int getIDay(){
		return calendar.getDays().get(0).getNumDay();
	}
	public int getIMonth(){
		return calendar.getDays().get(0).getNumMonth();
	}
	public int getIYear(){
		return calendar.getDays().get(0).getYear();
	}
	public Day getDay(Day day){
		int posDay = -1;
		for(Day d : calendar.getDays()){
			if(d.equals(day)){
				posDay = calendar.getDays().indexOf(d);
			}
		}
		return calendar.getDays().get(posDay);
	}
	public Day getLastDay(){
		return calendar.getDays().get(calendar.getDays().size() - 1);
	}	
	
	
	// ------------- Gestion de la formation courante  --------------- //
	// --------------------------------------------------------------- //

	public void addTeacher(String name, String firstname, String abbreviation, String email, String phone) {
		teachers.add(new Teacher(email,phone, abbreviation,name,firstname));
	}
	public void modifyTeacher(String oldEmail, String name, String firstname, String abbreviation, String email, String phone) {
		this.getTeacher(email).setAbbreviation(abbreviation);
		this.getTeacher(email).setEmail(email);
		this.getTeacher(email).setFirstname(firstname);
		this.getTeacher(email).setName(name);
		this.getTeacher(email).setPhone(phone);
	}
	public void removeTeacher(String email){
		teachers.remove(this.getTeacher(email));
	}
	public Teacher getTeacher(String email) {
		Teacher te = null;
		if(teachers.size() != 0)
			for(Teacher t : teachers){
				System.out.println("test Boucle : "+t.getName());
				if(t.getEmail() == email)
					{te = t;System.out.println("Equals !!");}
			}
		return te;
	}
	public void initTeacher() {
		if(teachers.size() != 0)
			notifyObserver(this.teachers, teachers.get(0));
	}
	public void selectTeacher(String email) {
		System.out.println( "test 1 : " + email);
		System.out.println( "test 2 : " + this.teachers.size());
		System.out.println( "test 3 : " + getTeacher(email).getEmail());
			notifyObserver(this.teachers, (Teacher)this.getTeacher(email));
	}
	
	// ------------- Gestion de la formation courante  --------------- //
	// --------------------------------------------------------------- //

	public Formation getCurrentFormation(){
		return calendar.getCurrentFormation();
	}
	public void setCurrentFormation(Formation formation){
		this.calendar.setCurrentFormation(formation);
	}
	
	
	// -------------- Fonctions de Gestion des Fonctions  --------------- //
	// ------------------------------------------------------------------ //
	
	public void initFormations(){
// Exception : cas ou aucune formation existe (entrer quand m�me dans la fenetre)
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

	
	// -------------- Fonctions de Gestion des Modules --------------- //
	// --------------------------------------------------------------- //
	
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

	
	// -------------- Fonctions de Gestion des S�ances --------------- //
	// --------------------------------------------------------------- //
	
	public void removeSeance(Module module, Day day, int positon){
		this.getDay(day).getFormationSeances(this.calendar.getCurrentFormation().toString()).setSeance(positon, null);
		this.calendar.inNumSeances(null, module);
		this.calendar.resetSeance(module);
	}
	public void addSeances(Module module, Teacher teacher, Day day, int positon){
		this.getDay(day).getFormationSeances(this.calendar.getCurrentFormation().toString()).setSeance(positon, new Seance(module,teacher));
		this.calendar.inNumSeances(new Seance(module,teacher), module);
		this.calendar.resetSeance(module);
	}
	
	
	
	// -------------- Fonctions de serialisation --------------- //
	// --------------------------------------------------------- //
	
	public void serializeCalendar(String file){
		SerializeObjects.serialiseObject(file, this.calendar);
	}
	public void serializeTeachers(){
		SerializeObjects.serialiseObject("Teachers.load", new Teachers(this.teachers));
	}
	public void deserializeTeachers(){
		File f = new File("Teachers.load");
		if(f.exists()){
			DeserializeObject.deserialiseTeachers(f);
			this.teachers = DeserializeObject.getTeachers();
		}
	}
	
}