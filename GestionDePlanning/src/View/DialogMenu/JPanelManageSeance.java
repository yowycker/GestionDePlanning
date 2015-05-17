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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
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
import View.Elements.JButtonSeances;
import View.Elements.SLabel;

public class JPanelManageSeance extends JPanelManage implements DaysObserver, ActionListener, ListSelectionListener{

	private Formation currentFormation;
	private Module currentModule;
	private Teacher currentTeacher;
	private boolean initModule;
	private boolean initTeacher;
	
	private DefaultListModel dlm = new DefaultListModel();
	private JList listModule = new JList(dlm);
	
	private static String titleLabel = new String("Gestion des seances");
	
	private SLabel monthYearLabel = new SLabel("");
	private SLabel monthYearLabel2 = new SLabel("");
	private JTextField messageTextField = new JTextField(40);

	private SLabel abbLabel = new SLabel("Abbreviation"); 
	private SLabel numLabel = new SLabel("Nombre de seances"); 
	private SLabel teacherLabel = new SLabel("Formateurs");
	
	private SLabel moduleName = new SLabel(""); 
	private SLabel moduleAbb = new SLabel("");  
	private SLabel moduleNumbers = new SLabel("");
	private JComboBox teacherCombo = new JComboBox(); 

	
	private SLabel monday = new SLabel("Lun"); 
	private SLabel tuesday = new SLabel("Mar"); 
	private SLabel wednesday = new SLabel("Mer"); 
	private SLabel thursday = new SLabel("Jeu"); 
	private SLabel friday = new SLabel("Ven"); 
	private SLabel saturday = new SLabel("Sam");
	private SLabel sunday = new SLabel("Dim");

	private SLabel monday2 = new SLabel("Lun"); 
	private SLabel tuesday2 = new SLabel("Mar"); 
	private SLabel wednesday2 = new SLabel("Mer"); 
	private SLabel thursday2 = new SLabel("Jeu"); 
	private SLabel friday2 = new SLabel("Ven"); 
	private SLabel saturday2 = new SLabel("Sam");
	private SLabel sunday2 = new SLabel("Dim");
			
	private JButton after = new JButton("<<");
	private JButton next = new JButton(">>");

	private JButton after2 = new JButton("<<");
	private JButton next2 = new JButton(">>");
	

		private JTabbedPane panelOnglet;
			private JPanel morningPanel = new JPanel();
			private JPanel afternoonPanel = new JPanel();
				private JPanel northPanel1 = new JPanel();
				private JPanel northPanel2 = new JPanel();
				private JPanel centerPanel1 = new JPanel();
				private JPanel centerPanel2 = new JPanel();
					private JPanel headerPanel1 = new JPanel();
				    	private JPanel monthYearPanel1 = new JPanel();
					private JPanel headerPanel2 = new JPanel();
					    private JPanel monthYearPanel2 = new JPanel();
					private JPanel daysPanel1 = new JPanel();
					private JPanel daysPanel2 = new JPanel();
		private JPanel messagePanel = new JPanel();
		private JPanel moduleSeancePanel = new JPanel();
			private JPanel moduleListePanel = new JPanel();
			private JPanel infoSeancePanel = new JPanel();
				private JPanel colorPanel = new JPanel();
				private JPanel namePanel = new JPanel();
				private JPanel abbPanel = new JPanel();
				private JPanel numPanel = new JPanel();
				private JPanel comboPanel = new JPanel();

				
				
		private BorderLayout mainLayout;
			private BorderLayout ongletLayout1;
			private BorderLayout ongletLayout2;
				private BorderLayout northLayout1;
				private BorderLayout northLayout2;
				private BorderLayout centerLayout1;
				private BorderLayout centerLayout2;
					private GridLayout headerLayout1 = new GridLayout(2,7);
					private GridLayout headerLayout2 = new GridLayout(2,7);
					private GridLayout daysLayout1;
					private GridLayout daysLayout2;
			private GridLayout messageLayout = new GridLayout(1,1);
			private BorderLayout moduleSeanceLayout;
				private BorderLayout moduleListeLayout;
				private GridLayout infoSeanceLayout = new GridLayout(5,1);
		
		 public JPanelManageSeance(DaysAbstractControler daysControler){
			 super(daysControler,titleLabel);
			 
			 panelOnglet = new JTabbedPane();
	         panelOnglet.addTab("Matin", null, morningPanel);
	         panelOnglet.addTab("Aprés-midi", null, afternoonPanel);
	         
	         ongletLayout1 = new BorderLayout();
	         morningPanel.setLayout(ongletLayout1);
	         morningPanel.add(northPanel1, BorderLayout.NORTH);
	         morningPanel.add(centerPanel1, BorderLayout.CENTER);
	         ongletLayout2 = new BorderLayout();
	         afternoonPanel.setLayout(ongletLayout2);
	         afternoonPanel.add(northPanel2, BorderLayout.NORTH);
	         afternoonPanel.add(centerPanel2, BorderLayout.CENTER);
	         
				 northLayout1 = new BorderLayout();
				 northPanel1.setLayout(northLayout1);
				 northPanel1.add(after, BorderLayout.WEST);
				 northPanel1.add(monthYearPanel1, BorderLayout.CENTER);
				 	monthYearPanel1.add(monthYearLabel);
				 northPanel1.add(next, BorderLayout.EAST);

				 northLayout2 = new BorderLayout();
				 northPanel2.setLayout(northLayout2);
				 northPanel2.add(after2, BorderLayout.WEST);
				 northPanel2.add(monthYearPanel2, BorderLayout.CENTER);
				 	monthYearPanel2.add(monthYearLabel2);
				 northPanel2.add(next2, BorderLayout.EAST);
					
				 centerLayout1 = new BorderLayout();
				 centerPanel1.setLayout(centerLayout1);
				 centerPanel1.add(headerPanel1, BorderLayout.NORTH);
				 centerPanel1.add(daysPanel1, BorderLayout.CENTER);
				 centerLayout2 = new BorderLayout();
				 centerPanel2.setLayout(centerLayout2);
				 centerPanel2.add(headerPanel2, BorderLayout.NORTH);
				 centerPanel2.add(daysPanel2, BorderLayout.CENTER);
				 
				 	headerPanel1.setLayout(headerLayout1);
				 	headerPanel1.add(new JPanel(), 0); 
				 	headerPanel1.add(new JPanel(), 1); 
				 	headerPanel1.add(new JPanel(), 2); 
				 	headerPanel1.add(new JPanel(), 3); 
				 	headerPanel1.add(new JPanel(), 4); 
				 	headerPanel1.add(new JPanel(), 5); 
				 	headerPanel1.add(new JPanel(), 6);
				 	headerPanel1.add(monday, 7); 
				 	headerPanel1.add(tuesday, 8); 
				 	headerPanel1.add(wednesday, 9); 
				 	headerPanel1.add(thursday, 10); 
				 	headerPanel1.add(friday, 11); 
				 	headerPanel1.add(saturday, 12); 
				 	headerPanel1.add(sunday, 13);
				 	
				 	headerPanel2.setLayout(headerLayout2);
				 	headerPanel2.add(new JPanel(), 0); 
				 	headerPanel2.add(new JPanel(), 1); 
				 	headerPanel2.add(new JPanel(), 2); 
				 	headerPanel2.add(new JPanel(), 3); 
				 	headerPanel2.add(new JPanel(), 4); 
				 	headerPanel2.add(new JPanel(), 5); 
				 	headerPanel2.add(new JPanel(), 6);
				 	headerPanel2.add(monday2, 7); 
				 	headerPanel2.add(tuesday2, 8); 
				 	headerPanel2.add(wednesday2, 9); 
				 	headerPanel2.add(thursday2, 10); 
				 	headerPanel2.add(friday2, 11); 
				 	headerPanel2.add(saturday2, 12); 
				 	headerPanel2.add(sunday2, 13);
	
					daysLayout1 = new GridLayout();
					daysPanel1.setLayout(daysLayout1);
					daysLayout2 = new GridLayout();
					daysPanel2.setLayout(daysLayout2);
			 
			 messagePanel.setLayout(messageLayout);
			 messageTextField.setEnabled(false);
			 messagePanel.add(messageTextField);
			 
			 moduleSeanceLayout = new BorderLayout();
			 moduleSeancePanel.setLayout(moduleSeanceLayout);
			 moduleSeancePanel.add(moduleListePanel, BorderLayout.NORTH);
			 moduleSeancePanel.add(infoSeancePanel, BorderLayout.CENTER);
			 
				 moduleListeLayout = new BorderLayout();
				 moduleListePanel.setLayout(moduleListeLayout);
				 moduleListePanel.add(listModule, BorderLayout.CENTER);
	
				 infoSeancePanel.setLayout(infoSeanceLayout);
				 infoSeancePanel.add(colorPanel , 0);
				 infoSeancePanel.add(namePanel, 1);
				 	namePanel.add(moduleName,0);
				 infoSeancePanel.add(abbPanel, 2);
				 	abbPanel.add(abbLabel);
				 	abbPanel.add(moduleAbb);
				 infoSeancePanel.add(numPanel, 3);
				 	numPanel.add(numLabel);
				 	numPanel.add(moduleNumbers);
				 infoSeancePanel.add(comboPanel, 4);
				 	comboPanel.add(teacherLabel);
				 	comboPanel.add(teacherCombo);
			 
			 mainLayout = new BorderLayout();
		     this.setLayout(mainLayout);
		     this.add(panelOnglet, BorderLayout.CENTER);
		     this.add(messagePanel, BorderLayout.SOUTH);
		     this.add(moduleSeancePanel, BorderLayout.WEST);
		     
		     
		     after.addActionListener(this);
			 next.addActionListener(this);

		     after2.addActionListener(this);
			 next2.addActionListener(this);
			 
			 teacherCombo.addActionListener(this);
			 
			 listModule.addListSelectionListener(this);
		 }
		 public void initSeances(){
		     daysControler.initTeacher(true,true);
		     daysControler.initModules(true);
		     daysControler.initDaysMonth();
		 }
		 

		public void actionPerformed(ActionEvent evt) {
			if(evt.getSource() == after || evt.getSource() == after2){
				daysControler.afterDaysMonth();
			}
			if(evt.getSource() == next || evt.getSource() == next2){
				daysControler.nextDaysMonth();
			}
			if(evt.getSource() == teacherCombo){
				if(teacherCombo.getSelectedItem() != null){
	    			if(!initTeacher){
	    				daysControler.selectTeacher((String) teacherCombo.getSelectedItem(), true, false);
	    				daysControler.initDaysMonth();
	    			}
				}
			}
		}
		public void valueChanged(ListSelectionEvent evt) {
	    	if (!evt.getValueIsAdjusting()){
	    		if(listModule.getSelectedValue() != null){
	    			if(!initModule){
	   		     		daysControler.selectModule((String) listModule.getSelectedValue(),false);
	   		     		daysControler.getDaysMonth();
	    			}
	    		}
	    	}
			
		}

		public void update(ArrayList<Day> days, int firstDay, int lastDay, int posFirstDayWeek, boolean after, boolean next, int month, int year, int numweeks){

			this.initModule = false;
			this.initTeacher = false;
			
			this.after.setEnabled(after);
			this.next.setEnabled(next);
			this.after2.setEnabled(after);
			this.next2.setEnabled(next);
			
			monthYearLabel.setText(Calendar.getMonthString(month) + " " + Integer.toString(year));
			monthYearLabel2.setText(Calendar.getMonthString(month) + " " + Integer.toString(year));

			daysPanel1.removeAll();
			daysLayout1 = new GridLayout(numweeks,7);
			daysPanel1.setLayout(daysLayout1);
			
			daysPanel2.removeAll();
			daysLayout2 = new GridLayout(numweeks,7);
			daysPanel2.setLayout(daysLayout2);
			
			for(int i = 0; i < (posFirstDayWeek-1); i++){
				daysPanel1.add(new JPanel(), i);
				daysPanel2.add(new JPanel(), i);
			}
			for(int j = 0; j < lastDay; j++){
				if((j + 1) >= firstDay && (j + 1) <= lastDay){
					System.out.println(currentTeacher);
					System.out.println(currentTeacher.getEmail());
					System.out.println((String) teacherCombo.getSelectedItem());
					JButtonSeances btn = new JButtonSeances("" + (j + 1), this.daysControler,currentFormation,currentModule.getName(),currentTeacher.getEmail(), days.get(j + 1 - firstDay), 0);
					JButtonSeances btn2 = new JButtonSeances("" + (j + 1), this.daysControler,currentFormation,currentModule.getName(),currentTeacher.getEmail() , days.get(j + 1 - firstDay), 1);
					
					btn.setToolTipText( "cliquez ici pour programmée la séance du matin");
					if(days.get(j + 1 - firstDay).getHoliday()){
						btn.setEnabled(days.get(j + 1 - firstDay).getHoliday());
						btn.setToolTipText( "Ce jour est marqué comme non-ouvré");
					}
					
					btn2.setToolTipText( "cliquez ici pour programmée la séance de l'aprés midi");
					if(days.get(j + 1 - firstDay).getHoliday()){
						btn2.setEnabled(days.get(j + 1 - firstDay).getHoliday());
						btn2.setToolTipText( "Ce jour est marqué comme non-ouvré");
					}
					
					daysPanel1.add(btn, j + posFirstDayWeek - 1);
					daysPanel2.add(btn2, j + posFirstDayWeek - 1);
				}
				else{
					JPanel p = new JPanel();
					p.setBackground(Color.WHITE);
					p.add(new SLabel("" + (j + 1)));
					p.setToolTipText( "Jour hors scope au calendrier de l'année scolaire");
					JPanel p2 = new JPanel();
					p2.setBackground(Color.WHITE);
					p2.add(new SLabel("" + (j + 1)));
					p2.setToolTipText( "Jour hors scope au calendrier de l'année scolaire");
					System.out.println(j + posFirstDayWeek - 1);
					daysPanel1.add(p, j + posFirstDayWeek - 1);
					daysPanel2.add(p2, j + posFirstDayWeek - 1);
				}
					
			}
			for(int i = (posFirstDayWeek + lastDay - 1); i < (numweeks * 7); i++){
				daysPanel1.add(new JPanel(), i);
				daysPanel2.add(new JPanel(), i);
			}
			
			
			this.updateUI();
		}
		public void update(ArrayList<Formation> formations,	Formation currentFormation) {
		}
		
		
		
		public void update(Formation currentFormation, boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next) {
		}
		public void update(Formation currentFormation, Module currentModule, boolean isInit, boolean initSeances) {
			this.currentFormation = currentFormation;
			this.currentModule = currentModule;
			this.initModule = initSeances;
			
			this.setTitle(titleLabel + " " + currentFormation.getTitle());
			
			dlm.removeAllElements();
			for(Module m :currentFormation.getModules()){
				dlm.addElement(m.getName());
			}
			if(isInit)
				listModule.setSelectedValue(currentModule.getName(), true);
			else{
				colorPanel.setBackground(currentModule.getColor());
				moduleName.setText(currentModule.getName());
				moduleAbb.setText(currentModule.getAbbreviation());  
				moduleNumbers.setText(currentModule.getISeance() + " / " + currentModule.getMaxSeances());
			}
			
			
			
			this.updateUI();
		}
		public void update(ArrayList<Teacher> teachers, Teacher currentTeacher, boolean isInit, boolean inCalendar, boolean initSeances) {
			if(inCalendar){
				this.currentTeacher = currentTeacher;
				this.initTeacher = initSeances;
				teacherCombo.removeAllItems();
				for(Teacher t : teachers){
					teacherCombo.addItem((t.getEmail()));
				}
				if(isInit)
					teacherCombo.setSelectedItem(currentTeacher.getEmail());				
				
				this.updateUI();
			}
		}
	}
