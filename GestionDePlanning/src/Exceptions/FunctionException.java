package Exceptions;

public class FunctionException{
	public static String erreurDate(String position, int day, int month, int year){
		String message = "";
		if(year < 1900)
			message = "L'année de " + position + " est inférieure à la date minimum acceptée";
		else if(year > 2099)
			message = "L'année de " + position + " est supérieure à la date maximum acceptée";
		else{
			if(month < 1)
				message = "Le mois de " + position + " est inférieur à la date minimum acceptée";
			else if(month > 12)
				message = "Le mois de " + position + " est supérieur à la date maximum acceptée";
			else{
				if(day < 1)
					message = "Le jour de " + position + " est inférieur à la date minimum acceptée";
				int nday = 0;
				switch(month){
			        case 1 : { nday = 31;break; } 
			        case 2 : { 
			                    if(year%4 == 0) nday = 29; 
			                    else nday = 28; 
			                    break; } 
			        case 3 : { nday =31;break; }
			        case 4 : { nday =30;break; }
			        case 5 : { nday =31;break; }
			        case 6 : { nday =30;break; }
			        case 7 : { nday =31;break; }
			        case 8 : { nday =31;break; }
			        case 9 : { nday =30;break; }
			        case 10: { nday =31;break; }
			        case 11: { nday =30;break; }
			        case 12: { nday =31;break; }
				}
				if(day > nday)
					message = "Le jour de " + position + " est supérieur à la date maximum acceptée";
			}
		}
		return message;
	}
	/*
	public static void maxDateExcetion(int day, int month, int year) throws dateException{
		
	}
	*/
}
