package View.DialogMenu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controler.DaysAbstractControler;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Obs.DaysObserver;

public class JPanelManageFormation extends JPanelManage implements DaysObserver, ActionListener{

private JList listFormation = new JList();
	
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
	private JPanel bottomPanel = new JPanel();
	

	private BorderLayout mainLayout;
		private Box centerLayout;
			//private GridLayout yearsLayout;
			//private GridLayout advanceLayout;
			//private Box daysLayout;
		//private Box bottomLayout;
		
		private GridLayout westLayout;

	
	 public JPanelManageFormation(DaysAbstractControler daysControler){
		 super(daysControler,"Gestion des formations");
		 
		 westLayout = new GridLayout(1,2);
		    westPanel.setLayout(westLayout);
		    westPanel.add(listFormation);
		    westPanel.add(new JScrollPane(listFormation));
		    
		 //centerLayout = new GridLayout(1,2);
		 
		 mainLayout = new BorderLayout();
	     this.setLayout(mainLayout);
	     this.add(centerPanel, BorderLayout.CENTER);
	     this.add(westPanel, BorderLayout.WEST);
	     this.add(bottomPanel, BorderLayout.SOUTH);
	 }
	 public void initListFormation(){
	     daysControler.initFormations();
	 }
	 

	public void actionPerformed(ActionEvent arg0) {
		
	}

	public void update(ArrayList<Formation> formations, Formation currentFormation,boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next){
		ArrayList<String> selections = new ArrayList<String>();
		for(Formation f :formations){
			selections.add(f.getTitle());
			System.out.println(f.getTitle());
		}
		listFormation.setListData(selections.toArray());
		System.out.println(listFormation.getSelectedValue());
		//listFormation.setSelectedIndex(1);
		this.updateUI();
	}
}
