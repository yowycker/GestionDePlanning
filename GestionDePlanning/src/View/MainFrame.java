package View;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import test.AllTests;
import Controler.DaysAbstractControler;
import Controler.DaysControler;
import Model.DaysAbstractModel;
import Model.DaysModel;
import View.Elements.JDialogNewPlanning;

public class MainFrame extends JFrame implements ActionListener{

    private JButton newFile = new JButton("Nouveau");
    private JButton openFile = new JButton("Ouvrir");
    private JButton saveFile = new JButton("Sauvegarder");
    private JButton gestion1 = new JButton("");
    private JButton gestion2 = new JButton("");
    private JButton gestion3 = new JButton("");
    private JButton plannification1 = new JButton("");
    private JButton plannification2 = new JButton("");

// Lier le Modele, le controlleur et la vue ensemble
 		    //Instanciation de notre modèle
 		    DaysAbstractModel model = new DaysModel();
 		    //Création du contrôleur
 		    DaysAbstractControler controler = new DaysControler(model);
 		    //Création de notre fenêtre avec le contrôleur en paramètre
 		    PanelWeek planning = new PanelWeek(controler); 		    
 		    
	  public MainFrame(){
		    this.setTitle("Planning");
		    this.setSize(1200, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);

	//Ajout de la fenêtre comme observer de notre modèle
 		    model.addObserver(planning);

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

		    newFile.addActionListener(this); 
		    openFile.addActionListener(this);
		    
		    this.setVisible(true);
	  }
	public static void main(String[] args){
		junit.textui.TestRunner.run(AllTests.suite());
		new MainFrame();
	}
	
// nouveau calendrier
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == newFile){
        	new JDialogNewPlanning(controler);
        }
        if(e.getSource() == openFile){
        }
    }
}