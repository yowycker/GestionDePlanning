package Model.CalendarObject;

import java.util.ArrayList;

public class Calendar{

	private ArrayList<Day> listDays = new ArrayList<Day>();
// pas encore sur pour les modules
	private ArrayList<Module> listModules = new ArrayList<Module>();
	private boolean holiday; 
	private boolean saturday; 
	private boolean sunday;
	
	// premier jours dans la premiere semaine
	private int iDay;
	// premiere semaine dans l'année
	private int iWeek;
	
	public Calendar(int firstDay, int firstMonth, int firstYear,int lastDay,  int lastMonth, int lastYear){
		holiday = false; 
		saturday = false; 
		sunday = false;
		init(firstDay, firstMonth, firstYear);
		generateJours(firstDay, firstMonth, firstYear,lastDay,  lastMonth, lastYear);
	}

// Accesseurs :
	public ArrayList<Day> getDays(){
		return listDays;
	}
	public int getIDay(){
		return iDay;
	}
	public int getIWeek(){
		return iWeek;
	}
	public boolean getHoliday(){
		return holiday;
	}
	public boolean getSaturday(){
		return saturday;
	}
	public boolean getSunday(){
		return sunday;
	}
	public ArrayList<Module> getModules(){
		return listModules;
	}	

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
	
	// ---------------- Fonction de Calcule des Jours ------------------- //
	// ------------------------------------------------------------------ //
		
	private void init(int firstDay, int firstMonth, int firstYear){
		iDay = day(firstDay,firstMonth,firstYear);
		iWeek = week(firstDay,firstMonth,firstYear);
	}
	private void generateJours(int firstDay, int firstMonth, int firstYear,int lastDay,  int lastMonth, int lastYear){
		int sous = 0;
		int maxDaysMonth = numberJourMonth(firstMonth,firstYear);
		int fDay = iDay;
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
					maxDaysMonth = numberJourMonth(m,a);
					fDay = 1;
				}

				for(int j = fDay; j <= maxDaysMonth; j++){

					switch(fDay-sous){ 
			        case 1 : { listDays.add(new Day("Lundi",j,fWeek,m,a));break; } 
			        case 2 : { listDays.add(new Day("Mardi",j,fWeek,m,a));break; } 
			        case 3 : { listDays.add(new Day("Mercredi",fWeek,j,m,a));break; } 
			        case 4 : { listDays.add(new Day("Jeudi",j,fWeek,m,a));break; } 
			        case 5 : { listDays.add(new Day("Vendredi",fWeek,j,m,a));break; } 
			        case 6 : { listDays.add(new Day("Samedi",j,fWeek,m,a));break; }
		        	case 7 : { listDays.add(new Day("Dimanche",j,fWeek,m,a));break; } 
			    	}
			    	if((fDay-sous)==7){
			    		sous+=fDay-sous;
			    		fWeek++;
			    	}
			    	fDay++;
				}
				if (a == lastYear && m == lastMonth){
					m = 12;
				}
			}
			
			fWeek = 1;
	    }
	}

		
		private int week(int day, int month, int year){
			int retour = day(1,1,year);
		    for(int i=1;i<month;i++){ 
		    	retour += numberJourMonth(month,year);
		    }
		    for(int i=1;i<day;i++) 
		        retour+=1; 
		    if(retour%7==0) retour = retour/7; 
		    else retour = (retour+retour%7)/7; 
		    return (retour + 1); 
		}
		private int day(int day, int month, int year){
		    int retour = 0;
		    for(int i=1900;i<year;i++)
		        if(i%4 == 0)retour+=366;
		        else retour+=365;
		    for(int m=1;m<month;m++)
		    	retour += numberJourMonth(m,year);
		    for(int j=1;j<day;j++)
		        retour+=1;
		    if(retour%7==0) retour = 7;
		    else retour = retour%7;
		    return (retour); 
		}
		
//Exception sur le numero de mois et le jour
	private int numberJourMonth(int month,int year){
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
