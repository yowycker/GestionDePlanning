package View.Elements;

import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class SLabel extends JLabel{ 
    
    public SLabel(String Text){ 
        super(Text); 
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }
} 