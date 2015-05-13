package View.DialogMenu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
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
import Obs.DaysObserver;

public class JPanelManageFormation extends JPanelManage implements DaysObserver, ActionListener, ListSelectionListener{

private JList listFormation = new JList();

private JLabel titleLabel = new JLabel("Titre");
private JLabel nbHoursLabel = new JLabel("Nombre d'heure par séance");
private JTextField titleTextField = new JTextField(10);
private JTextField nbHoursTextField = new JTextField(10);

private JButton add = new JButton("Ajouter");
private JButton modify = new JButton("Modifier");
private JButton delete = new JButton("Supprimer");
//private JButton cancel = new JButton("Annuler");
	
	private JPanel centerPanel = new JPanel();
		private JPanel titlePanel = new JPanel();
			private JPanel titleLabelPanel = new JPanel();
			private JPanel titleTextFieldPanel = new JPanel();
		private JPanel nbHoursPanel = new JPanel();
			private JPanel nbHoursLabelPanel = new JPanel();
			private JPanel nbHoursTextFieldPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	

	private BorderLayout mainLayout;
		private GridLayout centerLayout;
			private GridLayout titleLayout;
			private GridLayout nbHoursLayout;
		private Box bottomLayout;
		
		private GridLayout westLayout;

	
	 public JPanelManageFormation(DaysAbstractControler daysControler){
		 super(daysControler,"Gestion des formations");
		 
		 westLayout = new GridLayout(1,2);
		 westPanel.setLayout(westLayout);
		 westPanel.add(listFormation);
		 westPanel.add(new JScrollPane(listFormation));

		    
		 centerLayout = new GridLayout(2,1);
		 centerPanel.setLayout(centerLayout);
		 centerPanel.add(titlePanel, 0);
		 centerPanel.add(nbHoursPanel, 1);

			titleLayout = new GridLayout(1,2);
			titlePanel.setLayout(titleLayout);
			titleLabelPanel.add(titleLabel);
			titlePanel.add(titleLabelPanel, 0);
			titleTextFieldPanel.add(titleTextField);
			titlePanel.add(titleTextFieldPanel, 1);

			nbHoursLayout = new GridLayout(1,2);
			nbHoursPanel.setLayout(nbHoursLayout);
			nbHoursLabelPanel.add(nbHoursLabel);
			nbHoursPanel.add(nbHoursLabelPanel, 0);
			nbHoursTextFieldPanel.add(nbHoursTextField);
			nbHoursPanel.add(nbHoursTextFieldPanel, 1);
		   
		bottomLayout = Box.createHorizontalBox();
		bottomPanel.add(add,bottomLayout);
		bottomPanel.add(modify,bottomLayout);
		bottomPanel.add(delete,bottomLayout);

		add.addActionListener(this);
		modify.addActionListener(this);
		delete.addActionListener(this);
		listFormation.addListSelectionListener(this);
		 
		 mainLayout = new BorderLayout();
	     this.setLayout(mainLayout);
	     this.add(centerPanel, BorderLayout.CENTER);
	     this.add(westPanel, BorderLayout.WEST);
	     this.add(bottomPanel, BorderLayout.SOUTH);
	 }
	 public void initListFormation(){
	     daysControler.initFormation();
	 }
	 

	public void actionPerformed(ActionEvent evt) {
		/*double nbHours = 0;
		if(nbHoursTextField.getText().length() != 0){
			for(int i = 0; i < nbHoursTextField.getText().length(); i++)
				nbHoursTextField.getText().charAt(i).matches("[0-9]")
				testString += "[0-9]";
		}
		for(char c : nbHoursTextField.getText().chars())
		Double.
		nbHoursTextField.getText());*/
		if(evt.getSource() == add){
			daysControler.addFormation(titleTextField.getText(), Double.parseDouble(nbHoursTextField.getText()));
		}
		else if(evt.getSource() == modify){
			daysControler.modifyFormation(listFormation.getSelectedValue().toString(),titleTextField.getText(), Double.parseDouble(nbHoursTextField.getText()));
		}
		else if(evt.getSource() == delete){
			daysControler.deleteFormation(titleTextField.getText(), Double.parseDouble(nbHoursTextField.getText()));
		}
		// dispose
	}
    public void valueChanged(ListSelectionEvent evt) {
    	if (!evt.getValueIsAdjusting()){
            JList source = (JList)evt.getSource();
            String selected = source.getSelectedValue().toString();
        	System.out.println(listFormation.getSelectedValuesList().get(listFormation.getSelectedIndex()));
        }
    	//daysControler.selectFormation(new Formation(listFormation.getSelectedValue().toString(),0));
    }


	public void update(ArrayList<Formation> formations,	Formation currentFormation) {
		ArrayList<String> selections = new ArrayList<String>();
		for(Formation f : formations){
			selections.add(f.getTitle());
			//System.out.println(f.getTitle());
		}
		listFormation.setListData(selections.toArray());
		listFormation.setSelectedValue(currentFormation.getTitle(), true);
		titleTextField.setText(currentFormation.getTitle());
		nbHoursTextField.setText(Double.toString(currentFormation.getHoursSeances()));
		//System.out.println(listFormation.getSelectedValue());
		System.out.println(listFormation.getSelectedValuesList().get(listFormation.getSelectedIndex()));
		//listFormation.setSelectedIndex(1);
		this.updateUI();
		
	}
	public void update(Formation currentFormation, boolean init, ArrayList<Day> days, int numDays, boolean after, boolean next) {
	}
}
