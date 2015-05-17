package View;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import test.AllTests;
import Controler.DaysAbstractControler;
import Controler.DaysControler;
import Model.DaysAbstractModel;
import Model.DaysModel;
import Serialized.SerializeObjects;
import View.DialogMenu.JDialogManage;
import View.DialogMenu.JDialogNewPlanning;
import View.DialogMenu.JPanelManageFormation;
import View.DialogMenu.JPanelManageHoliday;
import View.DialogMenu.JPanelManageModule;
import View.DialogMenu.JPanelManageSeance;
import View.DialogMenu.JPanelManageTeacher;
import View.DialogMenu.OpenFiles;

public class MainFrame extends JFrame implements ActionListener{

    private JButton newFile = new JButton("Nouveau");
    private JButton openFile = new JButton("Ouvrir");
    private JButton saveFile = new JButton("Sauvegarder");
    
    // listes menus
    private JButton manageFormation = new JButton("Formations");
    private JButton manageModule = new JButton("Modules");
    private JButton manageTeacher = new JButton("Formateurs");
    
    // affichage du calendrier
    private JButton manageHoliday = new JButton("Jours non-ouvré");
    private JButton manageSeances = new JButton("Séances");
    private JButton manageSeancesDragNDrop = new JButton("Drag'n Drop");
    
    private JDialogManage dm = new JDialogManage();

// Lier le Modele, le controlleur et la vue ensemble
 		    //Instanciation de notre modèle
    private DaysAbstractModel model = new DaysModel();
 		    //Création du contrôleur
    private DaysAbstractControler controler = new DaysControler(model);
 		    //Création de notre fenêtre avec le contrôleur en paramètre
    private PanelWeek planning = new PanelWeek(controler);
    private JPanelManageFormation manageFormationPanel = new JPanelManageFormation(controler);
    private JPanelManageModule manageModulePanel = new JPanelManageModule(controler);
    private JPanelManageHoliday manageHolidayPanel = new JPanelManageHoliday(controler);
    private JPanelManageSeance manageSeancePanel = new JPanelManageSeance(controler);
    private JPanelManageTeacher manageTeacherPanel = new JPanelManageTeacher(controler);
 		    
	  public MainFrame(){
		    this.setTitle("Planning");
		    this.setSize(1200, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);

// Recupperer données des Formateurs :
		    model.deserializeTeachers();
//Ajout de la fenêtre comme observer de notre modèle
 		    model.addObserver(planning);
 		    model.addObserver(manageFormationPanel);
 		    model.addObserver(manageModulePanel);
 		    model.addObserver(manageHolidayPanel);
 		    model.addObserver(manageSeancePanel);
 		    model.addObserver(manageTeacherPanel);

		    this.setLayout(new BorderLayout());
		    this.getContentPane().add(planning, BorderLayout.CENTER);
		    
// Exemple de toolBar
		    JToolBar toolbar = new JToolBar();
		    toolbar.setRollover(true);
		    toolbar.add(newFile);
		    toolbar.add(openFile);
		    toolbar.add(saveFile);
		    toolbar.addSeparator();
		    toolbar.add(manageHoliday);
		    toolbar.add(manageFormation);
		    toolbar.add(manageTeacher);
		    toolbar.addSeparator();
		    toolbar.add(manageModule);
		    toolbar.add(manageSeances);
		    toolbar.add(manageSeancesDragNDrop);
		    this.getContentPane().add(toolbar, BorderLayout.NORTH);

		    newFile.addActionListener(this); 
		    saveFile.addActionListener(this);
		    openFile.addActionListener(this);
		    
		    manageHoliday.addActionListener(this);
		    manageFormation.addActionListener(this);
		    manageModule.addActionListener(this);
		    manageSeances.addActionListener(this);
		    manageTeacher.addActionListener(this);
		    
		    this.setVisible(true);
	  }
	public static void main(String[] args){
		junit.textui.TestRunner.run(AllTests.suite());
		new MainFrame();
	}
	

	/**
	 * Nouveau Calendrier
	 */
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == newFile){
        	new JDialogNewPlanning(controler);
        }
        if(e.getSource() == saveFile){
        	controler.serializeCalendar();
        }
        if(e.getSource() == openFile){
        	try {
				new OpenFiles(controler);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        

        if(e.getSource() == manageHoliday){
        	manageHolidayPanel.initHolidays();
        	dm.initialise(manageHolidayPanel);;
        }
        if(e.getSource() == manageTeacher){
        	manageTeacherPanel.initListTeacher();
        	dm.initialise(manageTeacherPanel);;
        }
        if(e.getSource() == manageFormation){
        	manageFormationPanel.initListFormation();
        	dm.initialise(manageFormationPanel);;
        }
        
        if(e.getSource() == manageModule){
        	manageModulePanel.initModules();
        	dm.initialise(manageModulePanel);
        }
        if(e.getSource() == manageSeances){
        	manageSeancePanel.initSeances();
        	dm.initialise(manageSeancePanel);
        }
    }
}