package View;


import java.awt.Color;

import javax.swing.JFrame;

import Controler.DaysAbstractControler;
import Controler.DaysControler;
import Model.DaysAbstractModel;
import Model.DaysModel;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Module;
import Model.CalendarObject.Seance;

public class MainFrame extends JFrame{
	  public MainFrame(){
		    this.setTitle("Planning");
		    this.setSize(1200, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);


		    //Instanciation de notre mod�le
		    DaysAbstractModel model = new DaysModel();
		    //Cr�ation du contr�leur
		    DaysAbstractControler controler = new DaysControler(model);
		    //Cr�ation de notre fen�tre avec le contr�leur en param�tre
		    PanelWeek planning = new PanelWeek(controler);
		    //Ajout de la fen�tre comme observer de notre mod�le
		    model.addObserver(planning);
		    
		    
		    Calendar c = new Calendar(6,5,2014,2,6,2015);
		    c.getDays().get(4).setMatin(new Seance(new Module("Anglais", Color.BLUE,"Champroux",12),1));
		    c.getDays().get(2).setMatin(new Seance(new Module("Reseau", Color.RED,"Pl",10),1));
		    c.getDays().get(2).setApresMidi(new Seance(new Module("Anglais", Color.BLUE,"Champroux",12),2));
		    controler.initData(c);
		    
		    this.getContentPane().add(planning);
		    this.setVisible(true);
	  }
	public static void main(String[] args){
		new MainFrame();
	}
}