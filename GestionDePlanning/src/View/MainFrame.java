package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import Controler.DaysAbstractControler;
import Controler.DaysControler;
import Model.DaysAbstractModel;
import Model.DaysModel;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Module;
import Model.CalendarObject.Seance;

public class MainFrame extends JFrame implements ActionListener{

    private JButton newFile = new JButton("Nouveau");
    private JButton openFile = new JButton("Ouvrir");
    private JButton saveFile = new JButton("Sauvegarder");
    private JButton gestion1 = new JButton("");
    private JButton gestion2 = new JButton("");
    private JButton gestion3 = new JButton("");
    private JButton plannification1 = new JButton("");
    private JButton plannification2 = new JButton("");
    
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
		    JToolBar toolbar = new JToolBar();
		    toolbar.setRollover(true);
		    toolbar.add(newFile);
		    toolbar.add(openFile);
		    toolbar.add(saveFile);
		    toolbar.addSeparator();
		    toolbar.add(gestion1);
		    toolbar.add(gestion2);
		    toolbar.add(gestion3);
		    toolbar.addSeparator();
		    toolbar.add(plannification1);
		    toolbar.add(plannification2);
		    this.getContentPane().add(toolbar, BorderLayout.NORTH);
		    
		    this.setVisible(true);
	  }
	public static void main(String[] args){
		new MainFrame();
	}
	
// nouveau calendrier
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == newFile){
        } 
        if(e.getSource() == openFile){ 
        } 
    }
}