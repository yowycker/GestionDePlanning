package View.Elements;

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

import Controler.DaysAbstractControler;

public class JDialogNewPlanning extends JDialog implements ActionListener{
// Refaire le positionnement des elements
	private DaysAbstractControler daysControler;

	private JComboBox combo = new JComboBox();
	private JButton validate = new JButton("Valider");
	private JButton cancel = new JButton("Annuler");
	private JButton advance = new JButton("Avancé");
	private JCheckBox holidayCheck = new JCheckBox("Fériés");
	private JCheckBox saturdayCheck = new JCheckBox("Samedi");
	private JCheckBox sundayCheck = new JCheckBox("Dimanche");

	private SLabel year = new SLabel("Année");
	private SLabel holidays = new SLabel("Jours Non-ouvrés");
	
	
	private JPanel centerPanel = new JPanel();
		private JPanel yearsPanel = new JPanel();
			private JPanel yearLabelPanel = new JPanel();
			private JPanel yearsComboPanel = new JPanel();
		private JPanel advancePanel = new JPanel();
			private JPanel holidayLabelPanel = new JPanel();
			private JPanel advanceButtonPanel = new JPanel();
		private JPanel daysPanel = new JPanel();
			//private JPanel dayPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();

	private BorderLayout mainLayout;
		private Box centerLayout;
			private GridLayout yearsLayout;
			private GridLayout advanceLayout;
			private Box daysLayout;
		private Box bottomLayout;

		private GridLayout test;

	 public JDialogNewPlanning(DaysAbstractControler daysControler){
		 this.daysControler=daysControler;


		 
// Mettre dans panels les elements à center, aligner
		 yearsLayout = new GridLayout(1,2);
		 yearsPanel.setLayout(yearsLayout);
		 yearLabelPanel.add(year);
		 yearsPanel.add(yearLabelPanel, 0);
		 //centrer comboBox
		 combo.addItem("1899-1900");
		 combo.addItem("2014-2015");
		 combo.addItem("2015-2016");
		 combo.addItem("2016-2017");
		 combo.addItem("2017-2018");
		 combo.addItem("2018-2019");
		 combo.addItem("2019-2020");
		 yearsComboPanel.add(combo);
		 yearsPanel.add(yearsComboPanel, 1);
		 
		 advanceLayout = new GridLayout(1,2);
		 advancePanel.setLayout(advanceLayout);
		 holidayLabelPanel.add(holidays);
		 advancePanel.add(holidayLabelPanel, 0);
		 advanceButtonPanel.add(advance);
		 advancePanel.add(advanceButtonPanel, 1);
		 
		 
		 daysLayout = Box.createHorizontalBox();
		 // Remplacer panels par check box
		 daysPanel.add(holidayCheck,daysLayout);
		 daysPanel.add(saturdayCheck,daysLayout);
		 daysPanel.add(sundayCheck,daysLayout);
		 
		 test = new GridLayout(3,1);
		 centerLayout = Box.createHorizontalBox();
		 centerPanel.setLayout(test);
		 centerPanel.add(yearsPanel,0);
		 centerPanel.add(advancePanel,1);
		 centerPanel.add(daysPanel,2);

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
				daysControler.newCalendar((String)combo.getSelectedItem(),holidayCheck.isSelected(),saturdayCheck.isSelected(),sundayCheck.isSelected());
			}
			else if(evt.getSource() == cancel){
			}
			dispose();
	 }
}