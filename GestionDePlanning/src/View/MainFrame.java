package View;


import java.awt.BorderLayout;
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

// Lier le Modele, le controlleur et la vue ensemble
		    //Instanciation de notre modèle
		    DaysAbstractModel model = new DaysModel();
		    //Création du contrôleur
		    DaysAbstractControler controler = new DaysControler(model);
		    //Création de notre fenêtre avec le contrôleur en paramètre
		    PanelWeek planning = new PanelWeek(controler);
		    //Ajout de la fenêtre comme observer de notre modèle
		    model.addObserver(planning);
		    
		    
		    planning.initPlanning();
		    Calendar c = new Calendar(6,5,2014,2,6,2015);
		    Module m1 = new Module("Anglais", Color.GREEN,"Champroux",12);
		    Module m2 = new Module("Reseau", Color.RED,"Pl",10);
		    c.getDays().get(4).setMorning(new Seance(m1));
		    c.getDays().get(2).setMorning(new Seance(m2));
		    c.getDays().get(2).setAfternoon(new Seance(m1));
		    c.getDays().get(8).setMorning(new Seance(m1));
		    c.getDays().get(9).setMorning(new Seance(m2));
		    c.getDays().get(13).setMorning(new Seance(m1));
		    c.getDays().get(13).setAfternoon(new Seance(m1));
		    c.getDays().get(15).setMorning(new Seance(m2));
		    c.getDays().get(25).setAfternoon(new Seance(m1));
		    c.getDays().get(25).setAfternoon(new Seance(m1));
		    controler.initData(c);
		    

		    this.setLayout(new BorderLayout());
		    this.getContentPane().add(planning, BorderLayout.CENTER);
		    
// Exemple de toolBar
		    /*
		    JToolBar toolbar = new JToolBar();
		    toolbar.setRollover(true);
		    JButton button = new JButton("button");
		    toolbar.add(button);
		    toolbar.addSeparator();
		    toolbar.add(new JButton("button 2"));
		    toolbar.addSeparator();
		    toolbar.add(new JComboBox(new String[]{"A","B","C"}));
		    this.getContentPane().add(toolbar, BorderLayout.NORTH);*/
		    
		    this.setVisible(true);
	  }
	public static void main(String[] args){
		new MainFrame();
	}
}