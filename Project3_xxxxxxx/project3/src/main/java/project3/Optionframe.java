package project3;

import javax.swing.* ;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class Optionframe extends JFrame {
    JSlider masterSlider;
    Sound masterSound;
    
    public Optionframe(Sound mSound) {
        setTitle("Option");
	    setBounds(300, 200, 700, 400);
	    setVisible(true);
	    setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
            
        masterSound = mSound;
        masterSlider = new JSlider();
        masterSlider.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
                masterSound.currentVolume = masterSlider.getValue();
                System.out.println("Volume : " + masterSound.currentVolume);
                masterSound.fc.setValue(masterSound.currentVolume);
            }
        });
        add(masterSlider);
    }
}