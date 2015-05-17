package View.DialogMenu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import View.Elements.SLabel;
import Controler.DaysAbstractControler;

public class JDialogNewPlanning extends JDialog implements ActionListener{
// Refaire le positionnement des elements
	private DaysAbstractControler daysControler;

	private JComboBox combo = new JComboBox();
	private JButton validate = new JButton("Valider");
	private JButton cancel = new JButton("Annuler");
	private JTextField formationTextField = new JTextField(10);
	private JTextField formationhTextField = new JTextField(5);
	private JCheckBox saturdayCheck = new JCheckBox("Samedi");
	private JCheckBox sundayCheck = new JCheckBox("Dimanche");

	private SLabel formation = new SLabel("Nom de la formation");
	private SLabel formationh = new SLabel("Heures par sceance");
	private SLabel year = new SLabel("Année");
	private SLabel holidays = new SLabel("Jours Non-ouvrés");
	
	
	private JPanel centerPanel = new JPanel();
		private JPanel yearsPanel = new JPanel();
			private JPanel yearLabelPanel = new JPanel();
			private JPanel yearsComboPanel = new JPanel();
		private JPanel formationPanel = new JPanel();
			private JPanel formationLabelPanel = new JPanel();
			private JPanel formationTextFieldPanel = new JPanel();
		private JPanel formationhPanel = new JPanel();
			private JPanel formationhLabelPanel = new JPanel();
			private JPanel formationhTextFieldPanel = new JPanel();
		private JPanel advancePanel = new JPanel();
			private JPanel holidayLabelPanel = new JPanel();
			private JPanel advanceButtonPanel = new JPanel();
		private JPanel daysPanel = new JPanel();
			//private JPanel dayPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();

	private BorderLayout mainLayout;
		private GridLayout centerLayout;
			private GridLayout yearsLayout;
			private GridLayout formationLayout;
			private GridLayout formationhLayout;
			private GridLayout advanceLayout;
			private Box daysLayout;
		private Box bottomLayout;

	 public JDialogNewPlanning(DaysAbstractControler daysControler){
		 this.daysControler=daysControler;


		 
// Mettre dans panels les elements à center, aligner
		 yearsLayout = new GridLayout(1,2);
		 yearsPanel.setLayout(yearsLayout);
		 yearLabelPanel.add(year);
		 yearsPanel.add(yearLabelPanel, 0);
		 //centrer comboBox
combo.addItem("1899-1900");
		 for(String s : daysControler.getListYears()){
			 combo.addItem(s);
		 }
		 yearsComboPanel.add(combo);
		 yearsPanel.add(yearsComboPanel, 1);
		 
		 advanceLayout = new GridLayout(1,2);
		 advancePanel.setLayout(advanceLayout);
		 holidayLabelPanel.add(holidays);
		 advancePanel.add(holidayLabelPanel, 0);
		 advancePanel.add(advanceButtonPanel, 1);
		 
		 formationLayout = new GridLayout(1,2);
		 formationPanel.setLayout(formationLayout);
		 formationPanel.add(formationLabelPanel, 0);
		 formationLabelPanel.add(formation);
		 formationPanel.add(formationTextFieldPanel, 1);
		 formationLabelPanel.add(formationTextField);
		 
		 formationhLayout = new GridLayout(1,2);
		 formationhPanel.setLayout(formationhLayout);
		 formationhPanel.add(formationhLabelPanel, 0);
		 formationhLabelPanel.add(formationh);
		 formationhPanel.add(formationhTextFieldPanel, 1);
		 formationhLabelPanel.add(formationhTextField);
		 
		 
		 daysLayout = Box.createHorizontalBox();
		 // Remplacer panels par check box
		 daysPanel.add(saturdayCheck,daysLayout);
		 daysPanel.add(sundayCheck,daysLayout);
		 
		 centerLayout = new GridLayout(5,1);
		 centerPanel.setLayout(centerLayout);
		 centerPanel.add(yearsPanel,0);
		 centerPanel.add(advancePanel,1);
		 centerPanel.add(daysPanel,2);
		 centerPanel.add(formationPanel,3);
		 centerPanel.add(formationhPanel,4);

		 bottomLayout = Box.createHorizontalBox();
		 //validate.setHorizontalAlignment(SwingConstants.EAST);
		 //cancel.setHorizontalAlignment(SwingConstants.EAST);
		 bottomPanel.add(validate,daysLayout);
		 bottomPanel.add(cancel,daysLayout);
		 
		 
		 mainLayout = new BorderLayout();
	     this.setLayout(mainLayout);
	     this.add(centerPanel, BorderLayout.CENTER);
	     this.add(bottomPanel, BorderLayout.SOUTH);
		 
	     
			
			validate.addActionListener(this);
			cancel.addActionListener(this);
	     
			
			this.setModal(true);
			this.setTitle("Nouveau Planning");
			this.pack();
			this.setLocation(400, 200);
			this.setLocationRelativeTo(null);
		    this.setSize(600, 400);
		    this.setVisible(true);
		 }
	 
	 public void actionPerformed(ActionEvent evt){
			if(evt.getSource() == validate){
				daysControler.newCalendar((String)combo.getSelectedItem(),formationTextField.getText(),formationhTextField.getText(),saturdayCheck.isSelected(),sundayCheck.isSelected());
			}
			else if(evt.getSource() == cancel){
			}
			dispose();
	 }
}