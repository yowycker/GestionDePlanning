package View.DialogMenu;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controler.DaysAbstractControler;
import Model.CalendarObject.Day;
import Model.CalendarObject.Formation;
import Model.CalendarObject.Module;
import Obs.DaysObserver;
import View.Elements.JButtonColors;

public class JPanelManageModule extends JPanelManage implements DaysObserver, ActionListener, ListSelectionListener{

private DefaultListModel dlm = new DefaultListModel();
private JList listModule = new JList(dlm);

private JLabel nameLabel = new JLabel("Titre ");
private JLabel abbreviationLabel = new JLabel("Abbreviation ");
private JLabel maxSeancesLabel = new JLabel("Nombre de seances ");
private JLabel colorLabel = new JLabel("Choisisez une couleur d'affichage ");
private JTextField nameTextField = new JTextField(10);
private JTextField abbreviationTextField = new JTextField(10);
private JTextField maxSeancesTextField = new JTextField(5);
private JButtonColors colorButton = new JButtonColors();

private JButton add = new JButton("Ajouter");
private JButton modify = new JButton("Modifier");
private JButton delete = new JButton("Supprimer");
	

	private JPanel centerPanel = new JPanel();
		private JPanel nameAbbPanel = new JPanel();
			private JPanel nameLabelPanel = new JPanel();
			private JPanel abbreviationLabelPanel = new JPanel();
		private JPanel maxSeancesPanel = new JPanel();
		private JPanel colorPanel = new JPanel();
	private JPanel westPanel = new JPanel();
		private JPanel moduleListePanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	
	private BorderLayout mainLayout;
	
		private GridLayout centerLayout;
			private GridLayout nameAbbLayout;
		private Box bottomLayout;
	
	private BorderLayout westLayout;
		//private GridLayout formationLayout;
		private GridLayout moduleLayout;

	
	 public JPanelManageModule(DaysAbstractControler daysControler){
		 super(daysControler,"Gestion des modules de cours");
		 		 
		 moduleLayout = new GridLayout(1,2);
		 moduleListePanel.setLayout(moduleLayout);
		 moduleListePanel.add(listModule);
		 moduleListePanel.add(new JScrollPane(listModule));
		 	
		 westLayout = new BorderLayout();
		 westPanel.setLayout(westLayout);
		 westPanel.add(moduleListePanel, BorderLayout.CENTER);

		 centerLayout = new GridLayout(3,1);
		 centerPanel.setLayout(centerLayout);
		 centerPanel.add(nameAbbPanel, 0);
		 centerPanel.add(maxSeancesPanel, 1);
		 centerPanel.add(colorPanel, 2);

		 	nameAbbLayout = new GridLayout(1,2);
		 	nameAbbPanel.setLayout(nameAbbLayout);
		 	nameAbbPanel.add(nameLabelPanel,0);
		 		nameLabelPanel.add(nameLabel);
		 		nameLabelPanel.add(nameTextField);
		 	nameAbbPanel.add(abbreviationLabelPanel,1);
		 		abbreviationLabelPanel.add(abbreviationLabel);
		 		abbreviationLabelPanel.add(abbreviationTextField);

			maxSeancesPanel.add(maxSeancesLabel);
			maxSeancesPanel.add(maxSeancesTextField);
			
			colorPanel.add(colorLabel);
			colorPanel.add(colorButton);
		 

		bottomLayout = Box.createHorizontalBox();
		bottomPanel.add(add,bottomLayout);
		bottomPanel.add(modify,bottomLayout);
		bottomPanel.add(delete,bottomLayout);

			add.addActionListener(this);
			modify.addActionListener(this);
			delete.addActionListener(this);
		listModule.addListSelectionListener(this);
		 
		 mainLayout = new BorderLayout();
	     this.setLayout(mainLayout);
	     this.add(centerPanel, BorderLayout.CENTER);
	     this.add(westPanel, BorderLayout.WEST);
	     this.add(bottomPanel, BorderLayout.SOUTH);
	 }
	 public void initModules(){
	     daysControler.initModules();
	 }
	 

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == add){
			daysControler.addModule(nameTextField.getText(), abbreviationTextField.getText(), maxSeancesTextField.getText(), colorButton.getBackground());
		}
		else if(evt.getSource() == modify){
			daysControler.modifyModule((String) listModule.getSelectedValue() ,nameTextField.getText(), abbreviationTextField.getText(), maxSeancesTextField.getText(), colorButton.getBackground());
		}
		else if(evt.getSource() == delete){
			daysControler.removeModule((String) listModule.getSelectedValue());
		}
	}
    public void valueChanged(ListSelectionEvent evt) {
    	if (!evt.getValueIsAdjusting()){
    		/*for(int i = 0; i < this.formations.size(); i++){
    			if(this.formations.get(i).getTitle() == listFormation.getSelectedValue()){
    				titleTextField.setText(this.formations.get(i).getTitle());
    				nbHoursTextField.setText(Double.toString(this.formations.get(i).getHoursSeances()));
    			}
    		}*/
    		
    		if(listModule.getSelectedValue() != null){
    			daysControler.selectModule((String) listModule.getSelectedValue());
    		}
        }
    }

	
	
	public void update(Formation currentFormation, boolean init,ArrayList<Day> days, int numDays, boolean after, boolean next) {
	}
	
	public void update(ArrayList<Formation> formations,	Formation currentFormation){
	}
	public void update(Formation currentFormation, Module currentModule, boolean isInit){
		
		dlm.removeAllElements();
		for(Module m :currentFormation.getModules()){
			dlm.addElement(m.getName());
		}
		if(isInit)
			listModule.setSelectedValue(currentModule.getName(), true);
		else{
			nameTextField.setText(currentModule.getName());
			abbreviationTextField.setText(currentModule.getAbbreviation());
			maxSeancesTextField.setText(Integer.toString(currentModule.getMaxSeances()));
			colorButton.setBackground(currentModule.getColor());
		}
		
		
		this.updateUI();
	}
	@Override
	public void update(ArrayList<Day> days, int firstDay, int lastDay,
			int numWeeks, boolean after, boolean next, int month, int year, int numweeks){
		// TODO Auto-generated method stub
		
	}
}