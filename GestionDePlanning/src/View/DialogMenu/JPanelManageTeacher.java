package View.DialogMenu;

import java.awt.BorderLayout;
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
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Model.CalendarObject.Teacher;
import Obs.DaysObserver;

public class JPanelManageTeacher  extends JPanelManage implements DaysObserver, ActionListener, ListSelectionListener{

private Teacher currentTeacher;

private DefaultListModel dlm = new DefaultListModel();
private JList listTeacher = new JList(dlm);

private JLabel nameLabel = new JLabel("Nom ");
private JLabel firstnameLabel = new JLabel("Prenom ");
private JLabel abbLabel = new JLabel("Abbreviation ");
private JLabel emailLabel = new JLabel("Email ");
private JLabel phoneLabel = new JLabel("Téléphone ");
private JTextField nameTextField = new JTextField(10);
private JTextField firstnameTextField = new JTextField(10);
private JTextField abbTextField = new JTextField(10);
private JTextField emailTextField = new JTextField(10);
private JTextField phoneTextField = new JTextField(10);

private JButton add = new JButton("Ajouter");
private JButton modify = new JButton("Modifier");
private JButton delete = new JButton("Supprimer");
	
	private JPanel centerPanel = new JPanel();
		private JPanel namePanel = new JPanel();
			private JPanel nameLabelPanel = new JPanel();
			private JPanel nameTextFieldPanel = new JPanel();
		private JPanel firstnamePanel = new JPanel();
			private JPanel firstnameLabelPanel = new JPanel();
			private JPanel firstnameTextFieldPanel = new JPanel();
		private JPanel abbPanel = new JPanel();
			private JPanel abbLabelPanel = new JPanel();
			private JPanel abbTextFieldPanel = new JPanel();
		private JPanel emailPanel = new JPanel();
			private JPanel emailLabelPanel = new JPanel();
			private JPanel emailTextFieldPanel = new JPanel();
		private JPanel phonePanel = new JPanel();
			private JPanel phoneLabelPanel = new JPanel();
			private JPanel phoneTextFieldPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	

	private BorderLayout mainLayout;
		private GridLayout centerLayout;
			private GridLayout nameLayout;
			private GridLayout firstnameLayout;
			private GridLayout abbLayout;
			private GridLayout emailLayout;
			private GridLayout phoneLayout;
		private Box bottomLayout;
		
		private GridLayout westLayout;

	
	 public JPanelManageTeacher(DaysAbstractControler daysControler){
		 super(daysControler,"Gestion des formateurs");
		 
		 westLayout = new GridLayout(1,2);
		 westPanel.setLayout(westLayout);
		 westPanel.add(listTeacher);
		 westPanel.add(new JScrollPane(listTeacher));

		    
		 centerLayout = new GridLayout(5,1);
		 centerPanel.setLayout(centerLayout);
		 centerPanel.add(namePanel, 0);
		 centerPanel.add(firstnamePanel, 1);
		 centerPanel.add(abbPanel, 2);
		 centerPanel.add(emailPanel, 3);
		 centerPanel.add(phonePanel, 4);

		 	nameLayout = new GridLayout(1,2);
			namePanel.setLayout(nameLayout);
			nameLabelPanel.add(nameLabel);
			namePanel.add(nameLabelPanel, 0);
			nameTextFieldPanel.add(nameTextField);
			namePanel.add(nameTextFieldPanel, 1);

			firstnameLayout = new GridLayout(1,2);
			firstnamePanel.setLayout(firstnameLayout);
			firstnameLabelPanel.add(firstnameLabel);
			firstnamePanel.add(firstnameLabelPanel, 0);
			firstnameTextFieldPanel.add(firstnameTextField);
			firstnamePanel.add(firstnameTextFieldPanel, 1);

			abbLayout = new GridLayout(1,2);
			abbPanel.setLayout(abbLayout);
			abbLabelPanel.add(abbLabel);
			abbPanel.add(abbLabelPanel, 0);
			abbTextFieldPanel.add(abbTextField);
			abbPanel.add(abbTextFieldPanel, 1);

			emailLayout = new GridLayout(1,2);
			emailPanel.setLayout(emailLayout);
			emailLabelPanel.add(emailLabel);
			emailPanel.add(emailLabelPanel, 0);
			emailTextFieldPanel.add(emailTextField);
			emailPanel.add(emailTextFieldPanel, 1);

			phoneLayout = new GridLayout(1,2);
			phonePanel.setLayout(phoneLayout);
			phoneLabelPanel.add(phoneLabel);
			phonePanel.add(phoneLabelPanel, 0);
			phoneTextFieldPanel.add(phoneTextField);
			phonePanel.add(phoneTextFieldPanel, 1);
		   
		bottomLayout = Box.createHorizontalBox();
		bottomPanel.add(add,bottomLayout);
		bottomPanel.add(modify,bottomLayout);
		bottomPanel.add(delete,bottomLayout);

		add.addActionListener(this);
		modify.addActionListener(this);
		delete.addActionListener(this);
		listTeacher.addListSelectionListener(this);
		 
		 mainLayout = new BorderLayout();
	     this.setLayout(mainLayout);
	     this.add(centerPanel, BorderLayout.CENTER);
	     this.add(westPanel, BorderLayout.WEST);
	     this.add(bottomPanel, BorderLayout.SOUTH);
	 }
	 public void initListTeacher(){
	     daysControler.initTeacher(false,true);
	 }
	 

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == add){
			daysControler.addTeacher(nameTextField.getText(), firstnameTextField.getText(), abbTextField.getText(), emailTextField.getText(), phoneTextField.getText());
		}
		else if(evt.getSource() == modify){
			daysControler.modifyTeacher(currentTeacher.getEmail(), nameTextField.getText(), firstnameTextField.getText(), abbTextField.getText(), emailTextField.getText(), phoneTextField.getText());
		}
		else if(evt.getSource() == delete){
			daysControler.removeTeacher(currentTeacher.getEmail());
		}
	}
    public void valueChanged(ListSelectionEvent evt) {
    	if (!evt.getValueIsAdjusting()){
    		if(listTeacher.getSelectedValue() != null)
    			daysControler.selectTeacher((String) listTeacher.getSelectedValue(), false, true);
        }
    }

	public void update(ArrayList<Formation> formations,	Formation currentFormation) {		
	}
	public void update(Formation currentFormation, boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next) {
	}
	public void update(Formation currentFormation, Module currentModule, boolean isInit, boolean initSeances) {
	}
	public void update(ArrayList<Day> days, int firstDay, int lastDay,int posFirstDay, boolean after, boolean next, int month, int year, int numweeks){
	}
	public void update(ArrayList<Teacher> teachers, Teacher currentTeacher, boolean isInit, boolean inCalendar, boolean initSeances) {
		this.currentTeacher = currentTeacher;
		dlm.removeAllElements();
		for(Teacher t : teachers){
			dlm.addElement((t.getEmail()));
		}
		if(isInit)
			listTeacher.setSelectedValue(currentTeacher.getEmail(), true);
		else{
			nameTextField.setText(currentTeacher.getName());
			firstnameTextField.setText(currentTeacher.getFirstname());
			abbTextField.setText(currentTeacher.getAbbreviation());
			emailTextField.setText(currentTeacher.getEmail());
			phoneTextField.setText(currentTeacher.getPhone());
		}
		this.updateUI();
	}
}