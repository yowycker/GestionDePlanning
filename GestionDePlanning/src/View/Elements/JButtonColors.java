package View.Elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JButtonColors extends JButton implements ActionListener{
    private Color couleurCourante;
    
    public JButtonColors(){
    	// Info bulle sur composants
    	this.setToolTipText( "cliquez ici pour le panneau des couleurs");
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