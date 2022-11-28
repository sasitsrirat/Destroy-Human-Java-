package project3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Optionframe extends JFrame implements ActionListener {

    protected MainMenu main;
    protected JPanel epanel, mpanel, cpanel, spanel, scpanel;
    protected JPanel effectPanel;
    protected JPanel musicPanel;
    protected JPanel cutScenesPanel;
    protected JPanel AutosavePanel;
    protected JPanel ScorePanel;
    protected JLabel AutotsaveText;
    protected JLabel cutscenesText;
    protected JLabel musicText;
    protected JLabel effectText;
    protected JLabel ScoreText;
    protected JLabel contentpane;
    protected JLabel musiclabel;
    protected JSlider musicSlider;
    protected JSlider effectSlider;
    protected ArrayList<Sound> musicSound;
    protected ArrayList<Sound> effectSound;
    protected JCheckBox musiccheck, effectcheck, cutScenecheck, savecheck, scorecheck;
    protected JToggleButton toggleButton, toggleButton_2;
    protected String path;
    protected int frameWidth = 1024;
    protected int frameHeight = 600;

    public Optionframe(ArrayList<Sound> mSound, ArrayList<Sound> eSound, String imagepath, MainMenu m) {
        musicSound = mSound;
        effectSound = eSound;
        path = imagepath;
        main = m;

        setTitle("Option");
        setBounds(221, 134, frameWidth, frameHeight);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setContentPane(contentpane = new JLabel());
        MyImageIcon imageIcon = new MyImageIcon(path + "wp4363081.jpg");
        contentpane.setIcon(imageIcon.resize(frameWidth, frameHeight));
        contentpane.setOpaque(true);
        contentpane.setLayout(null);

        AddComponents();
    }

    private void AddComponents() {
        JButton backButton = new JButton("Back");
        {
            backButton.setBounds(75, 500, 100, 50);
            contentpane.add(backButton);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String button = event.getActionCommand();
                    if (button.equals("Back")) {
                        dispose();
                    }
                }
            });
        }

        MyImageIcon music_max = new MyImageIcon(path + "Music_max.png").resize(75, 75);
        MyImageIcon music_min = new MyImageIcon(path + "Music_min.png").resize(75, 75);
        MyImageIcon music_mute = new MyImageIcon(path + "Music_mute.png").resize(75, 75);

        musicPanel = new JPanel();
        {
            musicText = new JLabel();
            {
                musicText.setFont(new Font("Charter", Font.BOLD, 30));
                musicText.setForeground(Color.white);
                musicText.setText("MUSIC VOLUME");
                musicText.setBounds(80, 40, 700, 30);
            }

            musicPanel.setBounds(0, 90, 900, 100);
            musicPanel.setLayout(null);
            musicPanel.setOpaque(false);
            // musicPanel.setBackground(new Color(0,0,0,150));
            musiclabel = new JLabel();
            musiclabel.setIcon(music_min);
            musiclabel.setHorizontalAlignment(JLabel.CENTER);
            musiclabel.setBounds(70, 0, 75, 75);
            musicPanel.add(musiclabel);

            musicSlider = new JSlider(1, 10, 5);
            musicSlider.setBounds(150, 0, 700, 75);
            musicSlider.setOpaque(false);
            musicSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    switch (musicSlider.getValue()) {
                        case 1:
                            setAllcurrentVolume(musicSound, -42);
                            break;
                        case 2:
                            setAllcurrentVolume(musicSound, -33);
                            break;
                        case 3:
                            setAllcurrentVolume(musicSound, -28);
                            break;
                        case 4:
                            setAllcurrentVolume(musicSound, -23);
                            break;
                        case 5:
                            setAllcurrentVolume(musicSound, -18);
                            break;
                        case 6:
                            setAllcurrentVolume(musicSound, -13);
                            break;
                        case 7:
                            setAllcurrentVolume(musicSound, -8);
                            break;
                        case 8:
                            setAllcurrentVolume(musicSound, -3);
                            break;
                        case 9:
                            setAllcurrentVolume(musicSound, 1);
                            break;
                        case 10:
                            setAllcurrentVolume(musicSound, 6);
                            break;
                    }
                    if (musiclabel.getIcon() == music_mute) {
                        // do notin
                    } else if (musicSlider.getValue() <= 5) {
                        musiclabel.setIcon(music_min);
                    } else if (musicSlider.getValue() > 5) {
                        musiclabel.setIcon(music_max);
                    }
                    setAllValue(musicSound);
                }
            });
        }

        mpanel = new JPanel();
        {
            mpanel.setBounds(850, 110, 100, 25);
            mpanel.setOpaque(false);
            musiccheck = new JCheckBox(" mute ");
            musiccheck.setForeground(Color.white);
            musiccheck.setOpaque(false);
            musiccheck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JCheckBox cb = (JCheckBox) event.getSource();
                    if (cb.isSelected()) {
                        setAllmute(musicSound);
                        musiclabel.setIcon(music_mute);
                    } else {
                        setAllmute(musicSound);
                        setAllValue(musicSound);
                        for (Sound i : musicSound) {
                            if ("mainmenuBG".equals(i.getName())) {
                                i.playLoop();
                            }
                        }
                        if (musicSlider.getValue() <= 5) {
                            musiclabel.setIcon(music_min);
                        } else if (musicSlider.getValue() > 5) {
                            musiclabel.setIcon(music_max);
                        }
                    }
                }
            });
        }

        effectPanel = new JPanel();
        {
            effectText = new JLabel();
            {
                effectText.setFont(new Font("Charter", Font.BOLD, 30));
                effectText.setForeground(Color.white);
                effectText.setText("EFFECT VOLUME");
                effectText.setBounds(80, 185, 700, 30);
            }
            effectPanel.setBounds(0, 230, 900, 100);
            effectPanel.setLayout(null);
            effectPanel.setOpaque(false); // ทำให้ไม่เห็นพื้นหลังสีขาว
            // effectPanel.setBackground(new Color(0,0,0,150));
            MyImageIcon kawin_max = new MyImageIcon(path + "Kawin_max.png").resize(75, 75);
            MyImageIcon kawin_min = new MyImageIcon(path + "Kawin_min.png").resize(75, 75);
            MyImageIcon kawin_mute = new MyImageIcon(path + "Kawin_mute.png").resize(75, 75);
            JLabel effectlabel = new JLabel();
            effectlabel.setIcon(kawin_min);
            effectlabel.setHorizontalAlignment(JLabel.CENTER);
            effectlabel.setBounds(70, 0, 75, 75);
            effectPanel.add(effectlabel);
            effectSlider = new JSlider(1, 10, 5);
            effectSlider.setBounds(150, 0, 700, 75);
            effectSlider.setOpaque(false);
            effectSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    switch (effectSlider.getValue()) {
                        case 1:
                            setAllcurrentVolume(effectSound, -42);
                            break;
                        case 2:
                            setAllcurrentVolume(effectSound, -33);
                            break;
                        case 3:
                            setAllcurrentVolume(effectSound, -28);
                            break;
                        case 4:
                            setAllcurrentVolume(effectSound, -23);
                            break;
                        case 5:
                            setAllcurrentVolume(effectSound, -18);
                            break;
                        case 6:
                            setAllcurrentVolume(effectSound, -13);
                            break;
                        case 7:
                            setAllcurrentVolume(effectSound, -8);
                            break;
                        case 8:
                            setAllcurrentVolume(effectSound, -3);
                            break;
                        case 9:
                            setAllcurrentVolume(effectSound, 1);
                            break;
                        case 10:
                            setAllcurrentVolume(effectSound, 6);
                            break;
                    }
                    if (effectlabel.getIcon() == kawin_mute) {
                        // do notin
                    } else if (effectSlider.getValue() <= 5) {
                        effectlabel.setIcon(kawin_min);
                    } else if (effectSlider.getValue() > 5) {
                        effectlabel.setIcon(kawin_max);
                    }
                    setAllValue(effectSound);
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                }
            });

            epanel = new JPanel();
            {
                epanel.setBounds(850, 250, 100, 25);
                epanel.setOpaque(false);
                effectcheck = new JCheckBox(" mute ");
                effectcheck.setForeground(Color.white);
                effectcheck.setOpaque(false);
                effectcheck.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        JCheckBox cb = (JCheckBox) event.getSource();
                        if (cb.isSelected()) {
                            setAllmute(effectSound);
                            effectlabel.setIcon(kawin_mute);
                        } else {
                            setAllmute(effectSound);
                            setAllValue(effectSound);
                            for (Sound i : effectSound) {
                                if (i.getName() == "clickEF") {
                                    i.playOnce();
                                }
                            }
                            if (effectSlider.getValue() <= 5) {
                                effectlabel.setIcon(kawin_min);
                            } else if (effectSlider.getValue() > 5) {
                                effectlabel.setIcon(kawin_max);
                            }
                        }
                    }
                });
            }
        }

        cutScenesPanel = new JPanel();
        {
            cutscenesText = new JLabel();
            {
                cutscenesText.setFont(new Font("Charter", Font.BOLD, 30));
                cutscenesText.setForeground(Color.white);
                cutscenesText.setText("NOT SHOW STORY");
                cutscenesText.setBounds(80, 340, 700, 30);
            }
            cutScenesPanel.setBounds(0, 335, 900, 100);
            cutScenesPanel.setOpaque(false);
        }
        
        cpanel = new JPanel();
            {
                cpanel.setBounds(850, 335, 100, 25);
                cpanel.setOpaque(false);
                cutScenecheck = new JCheckBox(" no story ");
                cutScenecheck.setForeground(Color.white);
                cutScenecheck.setOpaque(false);
                cutScenecheck.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        JCheckBox cb = (JCheckBox) event.getSource();
                        if (cb.isSelected()) {
                            main.setcutscene(false);
                        } else {
                            main.setcutscene(true);
                        }
                    }
                });
            }

        AutosavePanel = new JPanel();
        {
            AutotsaveText = new JLabel();
            {
                AutotsaveText.setFont(new Font("Charter", Font.BOLD, 30));
                AutotsaveText.setForeground(Color.white);
                AutotsaveText.setText("NO AUTO-SAVE");
                AutotsaveText.setBounds(80, 390, 700, 30);
            }
            AutosavePanel.setBounds(0, 385, 700, 100);
            AutosavePanel.setOpaque(false);
        }
        spanel = new JPanel();
            {
                spanel.setBounds(850, 385, 100, 25);
                spanel.setOpaque(false);
                savecheck = new JCheckBox(" no save ");
                savecheck.setForeground(Color.white);
                savecheck.setOpaque(false);
                savecheck.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        JCheckBox cb = (JCheckBox) event.getSource();
                        if (cb.isSelected()) {
                            main.setsave(false);
                        } else {
                            main.setsave(true);
                        }
                    }
                });
            }

        ScorePanel = new JPanel();
        {
            ScoreText = new JLabel();
            {
                ScoreText.setFont(new Font("Charter", Font.BOLD, 30));
                ScoreText.setForeground(Color.white);
                ScoreText.setText("NOT SHOW SCORE");
                ScoreText.setBounds(80, 440, 700, 30);
            }
            ScorePanel.setBounds(0, 435, 700, 100);
            ScorePanel.setOpaque(false);
        }
        scpanel = new JPanel();
            {
                scpanel.setBounds(850, 435, 100, 25);
                scpanel.setOpaque(false);
                scorecheck = new JCheckBox(" no score ");
                scorecheck.setForeground(Color.white);
                scorecheck.setOpaque(false);
                scorecheck.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        JCheckBox cb = (JCheckBox) event.getSource();
                        if (cb.isSelected()) {
                            main.setscore(false);
                        } else {
                            main.setscore(true);
                        }
                    }
                });
            }
            
        mpanel.add(musiccheck);
        epanel.add(effectcheck);
        cpanel.add(cutScenecheck);
        spanel.add(savecheck);
        scpanel.add(scorecheck);
        musicPanel.add(musicSlider);
        effectPanel.add(effectSlider);
        contentpane.add(musicText);
        contentpane.add(effectText);
        contentpane.add(AutotsaveText);
        contentpane.add(cutscenesText);
        contentpane.add(ScorePanel);
        contentpane.add(ScoreText);
        contentpane.add(AutosavePanel);
        contentpane.add(cutScenesPanel);
        contentpane.add(mpanel);
        contentpane.add(epanel);
        contentpane.add(cpanel);
        contentpane.add(spanel);
        contentpane.add(scpanel);
        contentpane.add(musicPanel);
        contentpane.add(effectPanel);

        validate();
    }

    public void setAllcurrentVolume(ArrayList<Sound> SA, int v) {
        for (Sound s : SA) {
            s.currentVolume = v;
        }
    }

    public void setAllValue(ArrayList<Sound> SA) {
        for (Sound s : SA) {
            s.fc.setValue(s.currentVolume);
        }
    }

    public void setAllmute(ArrayList<Sound> SA) {
        for (Sound s : SA) {
            s.muteVolume();
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}