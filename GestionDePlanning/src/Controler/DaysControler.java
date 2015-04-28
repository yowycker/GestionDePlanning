package Controler;

import java.awt.Color;

import Exceptions.dateException;
import Model.DaysAbstractModel;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Module;
import Model.CalendarObject.Seance;
import View.DialogMenu.JDialogNewPlanning;

public class DaysControler extends DaysAbstractControler {	
	public DaysControler(DaysAbstractModel daysModel){
		super(daysModel);
	}
	  
	protected void control(){

	}
	
	
	public void nextWeek(){
		daysModel.setInit(false);
		index += daysModel.getNumDaysWeek();
System.out.println("Index : " + index);
		daysModel.getWeek(index);
	}
	public void afterWeek(){
		daysModel.setInit(false);
		index -= daysModel.getNumDaysWeek();
System.out.println("Index : " + index);
		daysModel.getWeek(index);
	}
	public void initData(Calendar c){
		index = 0;
		if(isInit == false){
			isInit = true;
			daysModel.setInit(true);
		}
		else
			daysModel.setInit(false);
		daysModel.setCalendar(c);
		daysModel.getWeek(index);
	}
	public void newCalendar(String years, boolean holiday, boolean saturday, boolean sunday){
		int firstYear = Integer.parseInt(years.substring(0, 4));
		int lastYear = Integer.parseInt(years.substring(5, 9));

		try{
			Calendar c = new Calendar(28,12,firstYear,18,2,lastYear,holiday,saturday,sunday);
		    Module m1 = new Module("Anglais", Color.GREEN,"Champroux",12);
		    Module m2 = new Module("Reseau", Color.RED,"Pl",10);
		    c.getDays().get(2).setMorning(new Seance(m2));
		    c.getDays().get(3).setAfternoon(new Seance(m1));
		    c.getDays().get(4).setMorning(new Seance(m1));
		    c.getDays().get(8).setMorning(new Seance(m1));
		    c.getDays().get(9).setMorning(new Seance(m2));
		    c.getDays().get(13).setMorning(new Seance(m1));
		    c.getDays().get(13).setAfternoon(new Seance(m1));
		    c.getDays().get(15).setMorning(new Seance(m2));
		    c.getDays().get(24).setAfternoon(new Seance(m1));
		    c.getDays().get(25).setAfternoon(new Seance(m1));
		    for(Day d : c.getDays()){
		    	System.out.println(d.getDate());
		    	if(d.getMorning() != null)
		    		System.out.println("    Module Matin : " + d.getMorning().getModule().getName());
		    	else
		    		System.out.println("    Module Matin : NULL");
		    	if(d.getAfternoon() != null)
		    		System.out.println("    Module Aprem : " + d.getAfternoon().getModule().getName());
		    	else
		    		System.out.println("    Module Aprem : NULL");
		    }
		    initData(c);
		}
		catch(dateException e){
			e.showDialogMessage();
			//new JDialogNewPlanning(this);
		}
	}

}
