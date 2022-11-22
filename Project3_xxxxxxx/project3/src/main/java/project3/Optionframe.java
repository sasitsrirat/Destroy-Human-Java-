package project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Optionframe extends JFrame {

    protected JLabel musicText;
    protected JLabel effectText;
    protected JLabel contentpane;
    protected JSlider musicSlider;
    protected JSlider effectSlider;
    protected Sound musicSound;
    protected Sound effectSound;
    protected JCheckBox musiccheck;
    protected JCheckBox effectcheck;
    protected String path;
    protected int frameWidth = 700;
    protected int frameHeight = 400;

    public Optionframe(Sound mSound, Sound eSound, String imagepath) {
        
        musicSound = mSound;
        effectSound = eSound;
        path = imagepath;

        setTitle("Option");
        setBounds(300, 200, frameWidth, frameHeight);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setContentPane(contentpane = new JLabel());
        MyImageIcon imageIcon = new MyImageIcon(path + "jenny.jpg");
        contentpane.setIcon(imageIcon.resize(frameWidth, frameHeight));
        contentpane.setOpaque(true);
        contentpane.setLayout(null);

        AddComponents();
    }

    private void AddComponents() {

        musicText = new JLabel();
        musicText.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 30));
        musicText.setBackground(null);
        musicText.setForeground(Color.blue);
        musicText.setText("MUSIC VOLUME");
        musicText.setBounds(80, 40, 700, 30);
        effectText = new JLabel();
        effectText.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 30));
        effectText.setBackground(null);
        effectText.setForeground(Color.blue);
        effectText.setText("EFFECT VOLUME");
        effectText.setBounds(80, 205, 700, 30);

        JPanel musicPanel = new JPanel();
        musicPanel.setBounds(0, 90, 700, 100);
        musicPanel.setLayout(null);
        musicPanel.setOpaque(false);
        MyImageIcon music_max = new MyImageIcon(path + "Music_max.png").resize(75, 75);
        MyImageIcon music_min = new MyImageIcon(path + "Music_min.png").resize(75, 75);
        MyImageIcon music_mute = new MyImageIcon(path + "Music_mute.png").resize(75, 75);
        JLabel musiclabel = new JLabel();
        musiclabel.setIcon(music_max);
        musiclabel.setHorizontalAlignment(JLabel.CENTER);
        musiclabel.setBounds(70, 0, 75, 75);
        musicPanel.add(musiclabel);
        musicSlider = new JSlider(1, 10, 10);
        musicSlider.setBounds(150, 0, 400, 75);
        musicSlider.setOpaque(false);
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
                if (musiclabel.getIcon() == music_mute) {
                    //do notin
                } else if (musicSlider.getValue() <= 5) {
                    musiclabel.setIcon(music_min);
                } else if (musicSlider.getValue() > 5) {
                    musiclabel.setIcon(music_max);
                }
                musicSound.fc.setValue(musicSound.currentVolume);
            }
        });

        JPanel mpanel = new JPanel();
        mpanel.setBounds(535, 110, 100, 25);
        mpanel.setOpaque(false);
        musiccheck = new JCheckBox(" mute ");
        musiccheck.setOpaque(false);
        musiccheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox cb = (JCheckBox) event.getSource();
                if (cb.isSelected()) {
                    musicSound.muteVolume();
                    musiclabel.setIcon(music_mute);
                } else {
                    musicSound.muteVolume();
                    effectSound.fc.setValue(effectSound.currentVolume);
                    musicSound.playLoop();
                    if (musicSlider.getValue() <= 5) {
                        musiclabel.setIcon(music_min);
                    } else if (musicSlider.getValue() > 5) {
                        musiclabel.setIcon(music_max);
                    }
                }
            }
        });

        JPanel effectPanel = new JPanel();
        effectPanel.setBounds(0, 250, 700, 100);
        effectPanel.setLayout(null);
        effectPanel.setOpaque(false);
        MyImageIcon kawin_max = new MyImageIcon(path + "Kawin_max.png").resize(75, 75);
        MyImageIcon kawin_min = new MyImageIcon(path + "Kawin_min.png").resize(75, 75);
        MyImageIcon kawin_mute = new MyImageIcon(path + "Kawin_mute.png").resize(75, 75);
        JLabel effectlabel = new JLabel();
        effectlabel.setIcon(kawin_max);
        effectlabel.setHorizontalAlignment(JLabel.CENTER);
        effectlabel.setBounds(70, 0, 75, 75);
        effectPanel.add(effectlabel);
        effectSlider = new JSlider(1, 10, 10);
        effectSlider.setBounds(150, 0, 400, 75);
        effectSlider.setOpaque(false);
        effectSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (effectSlider.getValue()) {
                    case 1:
                        effectSound.currentVolume = -42;
                        break;
                    case 2:
                        effectSound.currentVolume = -33;
                        break;
                    case 3:
                        effectSound.currentVolume = -28;
                        break;
                    case 4:
                        effectSound.currentVolume = -23;
                        break;
                    case 5:
                        effectSound.currentVolume = -18;
                        break;
                    case 6:
                        effectSound.currentVolume = -13;
                        break;
                    case 7:
                        effectSound.currentVolume = -8;
                        break;
                    case 8:
                        effectSound.currentVolume = -3;
                        break;
                    case 9:
                        effectSound.currentVolume = 1;
                        break;
                    case 10:
                        effectSound.currentVolume = 6;
                        break;
                }
                if (effectlabel.getIcon() == kawin_mute) {
                    //do notin
                } else if (effectSlider.getValue() <= 5) {
                    effectlabel.setIcon(kawin_min);
                } else if (effectSlider.getValue() > 5) {
                    effectlabel.setIcon(kawin_max);
                }
                effectSound.fc.setValue(effectSound.currentVolume);
                effectSound.playOnce();
            }
        });

        JPanel epanel = new JPanel();
        epanel.setBounds(535, 270, 100, 25);
        epanel.setOpaque(false);
        effectcheck = new JCheckBox(" mute ");
        effectcheck.setOpaque(false);
        effectcheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox cb = (JCheckBox) event.getSource();
                if (cb.isSelected()) {
                    effectSound.muteVolume();
                    effectlabel.setIcon(kawin_mute);
                } else {
                    effectSound.muteVolume();
                    effectSound.fc.setValue(effectSound.currentVolume);
                    effectSound.playOnce();
                    if (effectSlider.getValue() <= 5) {
                        effectlabel.setIcon(kawin_min);
                    } else if (effectSlider.getValue() > 5) {
                        effectlabel.setIcon(kawin_max);
                    }
                }
            }
        });

        mpanel.add(musiccheck);
        
        epanel.add(effectcheck);
        
        musicPanel.add(musicSlider);
        
        effectPanel.add(effectSlider);
        
        contentpane.add(musicText);
        contentpane.add(effectText);
        contentpane.add(mpanel);
        contentpane.add(epanel);
        contentpane.add(musicPanel);
        contentpane.add(effectPanel);
        validate();
    }
    class MyImageIcon extends ImageIcon {
    public MyImageIcon(String fname) {
        super(fname);
    }

    public MyImageIcon(Image image) {
        super(image);
    }

    public MyImageIcon resize(int width, int height) {
        Image oldimg = this.getImage();
        Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new MyImageIcon(newimg);
    }
    }
}
