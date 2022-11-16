package project3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class Optionframe extends JFrame {
    protected JSlider musicSlider;
    protected Sound musicSound;
    protected JPanel musicPanel;

    public Optionframe(Sound mSound, String imagepath) {
        setTitle("Option");
        setBounds(300, 200, 700, 400);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        musicPanel = new JPanel();
        musicPanel.setBounds(50, 100, 600, 100);
        musicPanel.setLayout(null);
        
        MyImageIcon kawin_max = new MyImageIcon(imagepath + "Kawin_max.png").resize(50, 50);
        MyImageIcon kawin_min = new MyImageIcon(imagepath + "Kawin_min.png").resize(50, 50);
        MyImageIcon kawin_mute = new MyImageIcon(imagepath + "Kawin_mute.png").resize(50, 50);
        JLabel audiolabel = new JLabel();
        audiolabel.setIcon(kawin_max);
        audiolabel.setHorizontalAlignment(JLabel.CENTER);
        audiolabel.setBounds(80, 12, 50, 50);
        musicPanel.add(audiolabel);

        musicSound = mSound;
        musicSlider = new JSlider(1,10);
        musicSlider.setBounds(150, 0, 400, 75);
        musicSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                
                switch (musicSlider.getValue()){
                    case 0 : musicSound.currentVolume = -80; break;
                    case 1 : musicSound.currentVolume = -29; break;
                    case 2 : musicSound.currentVolume = -25; break;
                    case 3 : musicSound.currentVolume = -21; break;
                    case 4 : musicSound.currentVolume = -17; break;
                    case 5 : musicSound.currentVolume = -13; break;
                    case 6 : musicSound.currentVolume = -9; break;
                    case 7 : musicSound.currentVolume = -5; break;
                    case 8 : musicSound.currentVolume = -1; break;
                    case 9 : musicSound.currentVolume = 2; break;
                    case 10 : musicSound.currentVolume = 6; break;
                }
                
                if (musicSlider.getValue() == 0) {
                    audiolabel.setIcon(kawin_mute);
                } else if(musicSlider.getValue() <= 5){
                    audiolabel.setIcon(kawin_min);
                } else if(musicSlider.getValue() > 5) {
                    audiolabel.setIcon(kawin_max);
                }
                musicSound.fc.setValue(musicSound.currentVolume);
            }
        });
        musicPanel.add(musicSlider);
        add(musicPanel);
        validate();
        repaint();
    }
}