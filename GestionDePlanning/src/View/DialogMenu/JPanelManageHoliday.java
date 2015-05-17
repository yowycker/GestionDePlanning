package View.DialogMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controler.DaysAbstractControler;
import Model.CalendarObject.Calendar;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Model.CalendarObject.Teacher;
import Obs.DaysObserver;
import View.Elements.JButtonDay;
import View.Elements.SLabel;

public class JPanelManageHoliday extends JPanelManage implements DaysObserver, ActionListener{
private SLabel monthYearLabel = new SLabel("");
private JTextField messageTextField = new JTextField(40);


private SLabel monday = new SLabel("Lun"); 
private SLabel tuesday = new SLabel("Mar"); 
private SLabel wednesday = new SLabel("Mer"); 
private SLabel thursday = new SLabel("Jeu"); 
private SLabel friday = new SLabel("Ven"); 
private SLabel saturday = new SLabel("Sam");
private SLabel sunday = new SLabel("Dim");
		
private JButton after = new JButton("<<");
private JButton next = new JButton(">>");

	private JPanel northPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	    private JPanel headerPanel = new JPanel();
	    	private JPanel monthYearPanel = new JPanel();
	    private JPanel daysPanel = new JPanel();
	    private JPanel messagePanel = new JPanel();

	private BorderLayout mainLayout;
		private BorderLayout northLayout;
		private BorderLayout centerLayout;
			private GridLayout headerLayout = new GridLayout(2,7);
			private GridLayout daysLayout;
		private GridLayout messageLayout = new GridLayout(1,1);
	
	 public JPanelManageHoliday(DaysAbstractControler daysControler){
		 super(daysControler,"Gestion des jours non-ouvrés");
		 
		 northLayout = new BorderLayout();
		 northPanel.setLayout(northLayout);
		 northPanel.add(after, BorderLayout.WEST);
		 northPanel.add(monthYearPanel, BorderLayout.CENTER);
		 	monthYearPanel.add(monthYearLabel);
		 northPanel.add(next, BorderLayout.EAST);
			
		 centerLayout = new BorderLayout();
		 centerPanel.setLayout(centerLayout);
		 centerPanel.add(headerPanel, BorderLayout.NORTH);
		 centerPanel.add(daysPanel, BorderLayout.CENTER);
		 
		 	headerPanel.setLayout(headerLayout);
		 	headerPanel.add(new JPanel(), 0); 
		 	headerPanel.add(new JPanel(), 1); 
		 	headerPanel.add(new JPanel(), 2); 
		 	headerPanel.add(new JPanel(), 3); 
		 	headerPanel.add(new JPanel(), 4); 
		 	headerPanel.add(new JPanel(), 5); 
		 	headerPanel.add(new JPanel(), 6);
		 	headerPanel.add(monday, 7); 
		 	headerPanel.add(tuesday, 8); 
		 	headerPanel.add(wednesday, 9); 
		 	headerPanel.add(thursday, 10); 
		 	headerPanel.add(friday, 11); 
		 	headerPanel.add(saturday, 12); 
		 	headerPanel.add(sunday, 13);

			daysLayout = new GridLayout();
			daysPanel.setLayout(daysLayout);
		 
		 messagePanel.setLayout(messageLayout);
		 messageTextField.setEnabled(false);
		 messagePanel.add(messageTextField);
		 
		 mainLayout = new BorderLayout();
	     this.setLayout(mainLayout);
	     this.add(northPanel, BorderLayout.NORTH);
	     this.add(centerPanel, BorderLayout.CENTER);
	     this.add(messagePanel, BorderLayout.SOUTH);
	     
	     
	     after.addActionListener(this);
		 next.addActionListener(this);
	 }
	 public void initHolidays(){
		 daysControler.initTeacher(true, true);
	     daysControler.initModules(true);
	     daysControler.initDaysMonth();
	 }
	 

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == after){
			daysControler.afterDaysMonth();
		}
		if(evt.getSource() == next){
			daysControler.nextDaysMonth();
		}
	}

	public void update(ArrayList<Day> days, int firstDay, int lastDay, int posFirstDayWeek, boolean after, boolean next, int month, int year, int numweeks){
		this.after.setEnabled(after);
		this.next.setEnabled(next);
		
		monthYearLabel.setText(Calendar.getMonthString(month) + " " + Integer.toString(year));

		daysPanel.removeAll();
		daysLayout = new GridLayout(numweeks,7);
		daysPanel.setLayout(daysLayout);
		
		for(int i = 0; i < (posFirstDayWeek-1); i++){
			daysPanel.add(new JPanel(), i);
		}
		for(int j = 0; j < lastDay; j++){
			if((j + 1) >= firstDay && (j + 1) <= lastDay){
				JButtonDay btn = new JButtonDay("" + (j + 1), this.daysControler, days.get(j + 1 - firstDay));
				btn.setToolTipText( "cliquez ici pour changer le jour en non-ouvré");
				if(days.get(j + 1 - firstDay).getHoliday()){
					btn.setToolTipText( "cliquez ici pour changer le jour en ouvré");
					btn.setBackground(Color.BLACK);
					btn.setForeground(Color.WHITE);
				}
				daysPanel.add(btn, j + posFirstDayWeek - 1);
			}
			else{
				JPanel p = new JPanel();
				p.setBackground(Color.WHITE);
				p.add(new SLabel("" + (j + 1)));
				p.setToolTipText( "Jour hors scope au calendrier de l'année scolaire");
				daysPanel.add(p, j + posFirstDayWeek - 1);
			}
				
		}
		for(int i = (posFirstDayWeek + lastDay - 1); i < (numweeks * 7); i++){
			daysPanel.add(new JPanel(), i);
		}
		
		
		this.updateUI();
	}
	public void update(ArrayList<Formation> formations,	Formation currentFormation) {
	}
	public void update(Formation currentFormation, boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next) {
	}
	public void update(Formation currentFormation, Module currentModule, boolean isInit, boolean initSeances) {
	}
	@Override
	public void update(ArrayList<Teacher> teachers, Teacher currentTeacher, boolean isInit, boolean inCalendar, boolean initSeances) {
		// TODO Auto-generated method stub
		
	}
}
