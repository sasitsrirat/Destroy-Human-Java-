package project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Optionframe extends JFrame {

    protected JPanel contentpane;
    protected JSlider musicSlider;
    protected Sound musicSound;
    protected Sound effectSound;
    protected JCheckBox musiccheck;
    protected String path;

    public Optionframe(Sound mSound, Sound eSound, String imagepath) {

        musicSound = mSound;
        effectSound = eSound;
        path = imagepath;

        setTitle("Option");
        setBounds(300, 200, 700, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(null);
        setContentPane(contentpane);

        AddComponents();
    }

    private void AddComponents() {
        JPanel musicPanel = new JPanel();
        musicPanel.setBounds(0, 100, 700, 100);
        musicPanel.setLayout(null);

        MyImageIcon kawin_max = new MyImageIcon(path + "Kawin_max.png").resize(50, 50);
        MyImageIcon kawin_min = new MyImageIcon(path + "Kawin_min.png").resize(50, 50);
        MyImageIcon kawin_mute = new MyImageIcon(path + "Kawin_mute.png").resize(50, 50);
        JLabel musiclabel = new JLabel();
        musiclabel.setIcon(kawin_max);
        musiclabel.setHorizontalAlignment(JLabel.CENTER);
        musiclabel.setBounds(80, 12, 50, 50);
        musicPanel.add(musiclabel);
        musicSlider = new JSlider(1, 10);
        musicSlider.setBounds(150, 0, 400, 75);
        musicSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                switch (musicSlider.getValue()) {
                    case 1:
                        musicSound.currentVolume = -42;
                        break;
                    case 2:
                        musicSound.currentVolume = -33;
                        break;
                    case 3:
                        musicSound.currentVolume = -28;
                        break;
                    case 4:
                        musicSound.currentVolume = -23;
                        break;
                    case 5:
                        musicSound.currentVolume = -18;
                        break;
                    case 6:
                        musicSound.currentVolume = -13;
                        break;
                    case 7:
                        musicSound.currentVolume = -8;
                        break;
                    case 8:
                        musicSound.currentVolume = -3;
                        break;
                    case 9:
                        musicSound.currentVolume = 1;
                        break;
                    case 10:
                        musicSound.currentVolume = 6;
                        break;
                }

                if (musiclabel.getIcon() == kawin_mute) {
                    //do notin
                } else if (musicSlider.getValue() <= 5) {
                    musiclabel.setIcon(kawin_min);
                } else if (musicSlider.getValue() > 5) {
                    musiclabel.setIcon(kawin_max);
                }
                musicSound.fc.setValue(musicSound.currentVolume);
            }
        });

        JPanel cpanel = new JPanel();

        cpanel.setBounds(535, 120, 100, 25);
        musiccheck = new JCheckBox(" mute ");
        musiccheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox cb = (JCheckBox) event.getSource();
                if (cb.isSelected()) {
                    musicSound.muteVolume();
                    musiclabel.setIcon(kawin_mute);
                } else {
                    musicSound.muteVolume();
                    musicSound.playLoop();
                    if (musicSlider.getValue() <= 5) {
                        musiclabel.setIcon(kawin_min);
                    } else if (musicSlider.getValue() > 5) {
                        musiclabel.setIcon(kawin_max);
                    }
                }
            }
        });
        cpanel.add(musiccheck);
        musicPanel.add(musicSlider);
        contentpane.add(cpanel);
        contentpane.add(musicPanel);
        validate();
    }
}
