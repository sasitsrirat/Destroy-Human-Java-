package project3;

import javax.swing.* ;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class Optionframe extends JFrame {
    protected JSlider masterSlider;
    protected Sound masterSound;
    protected JPanel masterPanel;
    
    public Optionframe(Sound mSound, String imagepath) {
        setTitle("Option");
	setBounds(300, 200, 700, 400);
	setVisible(true);
        setLayout(null);
	setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        
        masterPanel = new JPanel();
        masterPanel.setBounds(50,100,600,100);
        masterPanel.setLayout(null);
        
        MyImageIcon audio = new MyImageIcon(imagepath + "audio.png").resize(50, 50);
        MyImageIcon mute  = new MyImageIcon(imagepath + "mute.png").resize(50, 50);
        JLabel audiolabel = new JLabel();
        audiolabel.setIcon(audio);
        audiolabel.setHorizontalAlignment(JLabel.CENTER);
        audiolabel.setBounds(80,12,50,50);
        masterPanel.add(audiolabel);
        
        masterSound = mSound;
        masterSlider = new JSlider(-25,6);
        masterSlider.setBounds(150, 0, 400, 75);
        masterSlider.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
                masterSound.currentVolume = masterSlider.getValue();
                if(masterSlider.getValue() == -25){
                    masterSound.currentVolume = -80;
                    audiolabel.setIcon(mute);
                }
                else {audiolabel.setIcon(audio);}
                masterSound.fc.setValue(masterSound.currentVolume);
            }
        });
        masterPanel.add(masterSlider);
        add(masterPanel);
        validate();
        repaint();
    }
}