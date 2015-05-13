package View.DialogMenu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controler.DaysAbstractControler;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Obs.DaysObserver;

public class JPanelManageModule extends JPanelManage implements DaysObserver, ActionListener{
//// ajouter un bouton "Enregistrer" qui permet, soit de cr�er un nouveau module, soit de le modifier. Et un bouton "Supprimer" pour supprimer l'�l�ment selectionn�

private JList listModule = new JList();
private JComboBox formationComboBox = new JComboBox();
	

	private JPanel centerPanel = new JPanel();
		//private JPanel yearsPanel = new JPanel();
			//private JPanel yearLabelPanel = new JPanel();
			//private JPanel yearsComboPanel = new JPanel();
		//private JPanel advancePanel = new JPanel();
			//private JPanel holidayLabelPanel = new JPanel();
			//private JPanel advanceButtonPanel = new JPanel();
		//private JPanel daysPanel = new JPanel();
			//private JPanel dayPanel = new JPanel();
	private JPanel westPanel = new JPanel();
		private JPanel formationComboPanel = new JPanel();
		private JPanel moduleListePanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	
	private BorderLayout mainLayout;
	
		//private Box centerLayout;
			//private GridLayout yearsLayout;
			//private GridLayout advanceLayout;
			//private Box daysLayout;
		//private Box bottomLayout;
	
	private BorderLayout westLayout;
		//private GridLayout formationLayout;
		private GridLayout moduleLayout;

	
	 public JPanelManageModule(DaysAbstractControler daysControler){
		 super(daysControler,"Gestion des modules de cours");
		 
		 formationComboPanel.add(formationComboBox);
		 		 
		 moduleLayout = new GridLayout(1,2);
		 moduleListePanel.setLayout(moduleLayout);
		 moduleListePanel.add(listModule);
		 moduleListePanel.add(new JScrollPane(listModule));
		 	
		 westLayout = new BorderLayout();
		 westPanel.setLayout(westLayout);
		 //westPanel.add(formationComboPanel);
		 //westPanel.add(moduleListePanel);
		 westPanel.add(formationComboPanel, BorderLayout.NORTH);
		 westPanel.add(moduleListePanel, BorderLayout.CENTER);
		 
		 mainLayout = new BorderLayout();
	     this.setLayout(mainLayout);
	     this.add(centerPanel, BorderLayout.CENTER);
	     this.add(westPanel, BorderLayout.WEST);
	     this.add(bottomPanel, BorderLayout.SOUTH);
	 }
	 public void initListFormation(){
	     daysControler.initFormation();
	 }
	 

	public void actionPerformed(ActionEvent arg0) {
		
	}

	
	
	public void update(Formation currentFormation, boolean init,ArrayList<Day> days, int numDays, boolean after, boolean next) {
		
	}
	
	public void update(ArrayList<Formation> formations,	Formation currentFormation) {
		formationComboBox.removeAll();
		for(Formation f :formations){
			formationComboBox.addItem(f.getTitle());
			System.out.println(f.getTitle());
		}
		formationComboBox.setSelectedItem(currentFormation.getTitle());
		
		ArrayList<String> selections = new ArrayList<String>();
		for(Module m :currentFormation.getModules()){
			selections.add(m.getName());
		}
		listModule.setListData(selections.toArray());
		this.updateUI();
	}
}