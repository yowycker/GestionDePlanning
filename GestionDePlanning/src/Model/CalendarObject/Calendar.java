package Model.CalendarObject;

import java.util.ArrayList;

import Exceptions.FunctionException;
import Exceptions.dateException;
/**
 * Classe permettant de générer le Calendrier
 * @param currentFormation, @param iDay, @param iWeek
 * @param holiday, @param saturday, @param sunday
 * @param formations //Liste des formations
 * @param listDays //Liste des jours
 */
public class Calendar{
	
	private String currentFormation;

	private ArrayList<Formation> formations = new ArrayList<Formation>(); 
	private ArrayList<Day> listDays = new ArrayList<Day>();
	
////// pour plus tard		
	private boolean holiday;
	
	private boolean saturday; 
	private boolean sunday;
	
	// premier jours dans la premiere semaine
	private int iDay;
	// premiere semaine dans l'année
	private int iWeek;
	
	/**
	 * Constructeur de la classe Calendar
	 * @param firstDay
	 * @param firstMonth
	 * @param firstYear
	 * @param lastDay
	 * @param lastMonth
	 * @param lastYear
	 * @param holiday
	 * @param saturday
	 * @param sunday
	 * @throws dateException - retourne un message d'erreur si les date de fin et de début sont hors-scope
	 */
	public Calendar(int firstDay, int firstMonth, int firstYear,int lastDay,  int lastMonth, int lastYear, boolean holiday, boolean saturday, boolean sunday) throws dateException{
		// fonction static qui retourne un message d'erreur si les date de fin et de début sont hors scope
		if(FunctionException.erreurDate("début",firstDay,firstMonth,firstYear) != "")
			throw new dateException("Erreur",FunctionException.erreurDate("début",firstDay,firstMonth,firstYear));
		else if(FunctionException.erreurDate("fin",lastDay,lastMonth,lastYear) != "")
			throw new dateException("Erreur",FunctionException.erreurDate("fin",lastDay,lastMonth,lastYear));
		else{
			this.holiday = holiday; 
			this.saturday = saturday; 
			this.sunday = sunday;
			init(firstDay, firstMonth, firstYear);
			generateJours(firstDay, firstMonth, firstYear,lastDay,  lastMonth, lastYear);
		}
	}

	/**
	 * Ascesseur retournant la liste des jours
	 * @param listDays
	 * @return
	 */
	public ArrayList<Day> getDays(){
		return listDays;
	}
	
	/**
	 * Ascesseur retournant la position du jour
	 * @param iDay
	 * @return
	 */
	public int getIDay(){
		return iDay;
	}
	
	/**
	 * Ascesseur retournant la position de la semaine
	 * @param iWeek
	 * @return
	 */
	public int getIWeek(){
		return iWeek;
	}
	
	/**
	 * Ascesseur retournant la postion des vacances scolaires
	 * @param holiday
	 * @return
	 */
	public boolean getHoliday(){
		return holiday;
	}
	
	/**
	 * Ascesseur retournant la position du samedi
	 * @param saturday
	 * @return
	 */
	public boolean getSaturday(){
		return saturday;
	}
	
	/**
	 * Ascesseur retournant la position du dimanche
	 * @return sunday
	 */
	public boolean getSunday(){
		return sunday;
	}
	
	/**
	 * Retourne le nom du mois
	 * @param i
	 * @return month
	 */
	public static String getMonthString(int i){ 
		String month = new String(); 
		     
		switch(i){ 
			case 1 : { month ="Janvier";break; } 
		    case 2 : { month ="Février";break; } 
		    case 3 : { month ="Mars";break; } 
		    case 4 : { month ="Avril";break; } 
		    case 5 : { month ="Mai";break; } 
		    case 6 : { month ="Juin";break; } 
		    case 7 : { month ="Juillet";break; } 
		    case 8 : { month ="Aout";break; } 
		    case 9 : { month ="Septembre";break; } 
		    case 10: { month ="Octobre";break; } 
		    case 11: { month ="Novembre";break; } 
		    case 12: { month ="Décembre";break; } 
		}
	return month; 
	} 
	
	
	// -------------- Fonctions de Gestion des Formations --------------- //
	// ------------------------------------------------------------------ //

	/**
	 * Mutateur permettant de modifier la formation en cours
	 * @param formation
	 */
	public void setCurrentFormation(Formation formation){
		this.currentFormation = formation.getTitle();
	}
	
	/**
	 * Ascesseur retournant la formation en cours
	 * @return
	 */
	public Formation getCurrentFormation(){
		Formation cformation = null;
		for(Formation f : formations){
			if(f.getTitle().equals(currentFormation)){
				cformation=f;
			}
		}
		return cformation;
	}
	
	/**
	 * Méthode permettant d'ajouter une formation au calendrier
	 * @param formation
	 */
	public void addFormation(Formation formation){
		for(Day d : listDays){
			d.addFormationSeances(formation.getTitle());
		}
		formations.add(formation);
	}
	
	/**
	 * Méthode permettant d'ajouter une formation au calendrier
	 * @param formation
	 */
// Pas encore fonctionnelle
	public void modifyFormation(String formation, Formation newformation){
		for(Day d : listDays){
			d.getFormationSeances(formation).setFormation(newformation.getTitle());
			System.out.println(newformation.getTitle());
		}
		for(Formation f : formations){
			if(f.equals(new Formation(formation,0))){
				f.setTitle(newformation.getTitle());
				f.setNbHoursSeances(newformation.getHoursSeances());

				System.out.println(newformation.getTitle());
				System.out.println(newformation.getHoursSeances());
			}
		}
	}
	
	/**
	 * Méthode permettant de supprimer une formation du calendrier
	 * @param formation
	 */
	public void removeFormation(Formation formation){
		for(Day d : listDays){
			d.removeFormationSeances(formation.getTitle());
		}
		formations.remove(formation);
	}
	
	/**
	 * Retourne la liste des formations existantes
	 * @return
	 */
	public ArrayList<Formation> getFormations(){
		return formations;
	}
	
	/**
	 * Retourne la formation ayant le même titre mis en parametre
	 * @return
	 */
	public Formation getFormation(String title){
		Formation fe = null;
		for(Formation f : formations){
			if(f.getTitle().equals(title))
				fe = f;
		}
		return fe;
	}

	
	// --------------- Fonctions de Gestion des Seances ----------------- //
	// ------------------------------------------------------------------ //
	
	/**
	 * Méthode permettant de fixer un cours à la matinée du jour en cours
	 * @param day
	 * @param module
	 */
	public void setMorningSeance(Day day, Module module){
		for(Day d : listDays){
// modifier le rend des seances du meme module : matin et soir
			if(d.equals(day)){
				getCurrentFormation().addSeance(module.getName());
				d.setMorning(getCurrentFormation(), module.getName());
// modifier le rend de la seance
			}
		}
	}
	
	/**
	 * Méthode permettant de fixer un cours à l'après-midi du jour en cours
	 * @param day
	 * @param module
	 */
	public void setAfternoonSeance(Day day, Module module){
		for(Day d : listDays){
// modifier le rend des seances du meme module : matin et soir
			if(d.equals(day)){
				getCurrentFormation().addSeance(module.getName());
				d.setAfternoon(getCurrentFormation(), module.getName());
// modifier le rend de la seance
			}
		}
	}
	
	// ---------------- Fonctions de Calcule des Jours ------------------ //
	// ------------------------------------------------------------------ //
	
	/**
	 * Méthode d'initialisation du premier jour, mois et de l'année afin de generer les jour en apportant à chaqu'un le numero de jour sur le mois et le numero de semaine sur l'année
	 * @param firstDay
	 * @param firstMonth
	 * @param firstYear
	 */
	private void init(int firstDay, int firstMonth, int firstYear){
		iDay = day(firstDay,firstMonth,firstYear);
		iWeek = week(firstDay,firstMonth,firstYear);
	}
	
	/**
	 * Méthode de génération d'une année
	 * @param firstDay
	 * @param firstMonth
	 * @param firstYear
	 * @param lastDay
	 * @param lastMonth
	 * @param lastYear
	 */
	private void generateJours(int firstDay, int firstMonth, int firstYear,int lastDay,  int lastMonth, int lastYear){
		int maxDaysMonth = numberDayMonth(firstMonth,firstYear);
		int namedDay = iDay;
		int fDay = firstDay;
		int fWeek = iWeek;

		for(int a = firstYear; a <= lastYear; a++){
			for(int m = 1; m <= 12; m++){
				if(a == firstYear && m == 1){
					m = firstMonth;
				}
				else if (a == lastYear && m == lastMonth){
					maxDaysMonth = lastDay;
				}
				else{
					maxDaysMonth = numberDayMonth(m,a);
					fDay = 1;
				}

				for(int j = fDay; j <= maxDaysMonth; j++){

					switch(namedDay){ 
			        case 1 : { listDays.add(new Day("Lundi",j,fWeek,m,a,false));break; } 
			        case 2 : { listDays.add(new Day("Mardi",j,fWeek,m,a,false));break; } 
			        case 3 : { listDays.add(new Day("Mercredi",j,fWeek,m,a,false));break; } 
			        case 4 : { listDays.add(new Day("Jeudi",j,fWeek,m,a,false));break; } 
			        case 5 : { listDays.add(new Day("Vendredi",j,fWeek,m,a,false));break; } 
			        case 6 : { listDays.add(new Day("Samedi",j,fWeek,m,a,saturday));break; }
		        	case 7 : { listDays.add(new Day("Dimanche",j,fWeek,m,a,sunday));break; } 
			    	}
			    	if((namedDay)==7){
			    		namedDay = 0;
			    		fWeek++;
			    	}
			    	namedDay++;
				}
				if (a == lastYear && m == lastMonth){
					m = 12;
				}
			}
			
			fWeek = 1;
	    }
	}

		/**
		 * retourne le numéro de la semaine 
		 * @param day
		 * @param month
		 * @param year
		 * @return
		 */
		private int week(int day, int month, int year){
			int retour = day(1,1,year);
		    for(int i=1;i<month;i++){ 
		    	retour += numberDayMonth(month,year);
		    }
		    for(int i=1;i<day;i++) 
		        retour+=1; 
		    if(retour%7==0) retour = retour/7; 
		    else retour = (retour+retour%7)/7; 
		    return (retour + 1); 
		}
		
		/**
		 * retourne le numéro du jour dans la semaine
		 * @param day
		 * @param month
		 * @param year
		 * @return
		 */
		public int day(int day, int month, int year){
		    int retour = 0;
		    for(int i=1900;i<year;i++)
		        if(i%4 == 0)retour+=366;
		        else retour+=365;
		    for(int m=1;m<month;m++)
		    	retour += numberDayMonth(m,year);
		    for(int j=1;j<day;j++)
		        retour+=1;
		    if(retour%7==0) retour = 7;
		    else retour = retour%7;
		    return (retour); 
		}

	/**
	 * 	 retourne le nombre de jour dans le mois 
	 * @param month
	 * @param year
	 * @return
	 */
	public int numberDayMonth(int month,int year){
		    int retour = 0; 
		     
		    switch(month){ 
		        case 1 : { retour = 31;break; } 
		        case 2 : { 
		                    if(year%4 == 0) retour = 29; 
		                    else retour = 28; 
		                    break; } 
		        case 3 : { retour =31;break; } 
		        case 4 : { retour =30;break; } 
		        case 5 : { retour =31;break; } 
		        case 6 : { retour =30;break; } 
		        case 7 : { retour =31;break; } 
		        case 8 : { retour =31;break; } 
		        case 9 : { retour =30;break; } 
		        case 10: { retour =31;break; } 
		        case 11: { retour =30;break; } 
		        case 12: { retour =31;break; } 
		    } 
		    return retour; 
		}
}
