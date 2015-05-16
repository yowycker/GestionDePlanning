package View.Elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class JButtonColors extends JButton implements ActionListener{
    
    public JButtonColors(){
    	// Info bulle sur composants
    	this.setToolTipText( "cliquez ici pour selectionner une couleur");
    	this.addActionListener(this);
    }

	public void actionPerformed(ActionEvent even) {
		 Color colorChoose = JColorChooser.showDialog(this,          // conteneur

		            "Choisir une couleur",      // titre de JColorChooser

		            this.getBackground());       

		        if (colorChoose != null)
		        	this.setBackground(colorChoose);
	}

}