package Main;

import test.AllTests;
import Controler.DaysAbstractControler;
import Controler.DaysControler;
import Model.DaysAbstractModel;
import Model.DaysModel;
import View.MainFrame;
import View.PanelWeek;

public class PlanningLauncher {

	public static void main(String[] args){
		junit.textui.TestRunner.run(AllTests.suite());

	    new MainFrame();
	}
}
