package Controler;

import Model.DaysAbstractModel;

public class DaysControler extends DaysAbstractControler {	
	public DaysControler(DaysAbstractModel daysModel) {
		super(daysModel);
	}
	  
	protected void control(){

	}
	
	
	public void nextWeek() {
		index += daysModel.getNumDaysWeek();
		daysModel.getWeek(index);
	}
	public void afterWeek() {
		index -= daysModel.getNumDaysWeek();
		daysModel.getWeek(index);
	}

}
