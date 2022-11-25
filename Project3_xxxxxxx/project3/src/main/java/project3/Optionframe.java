package project3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Optionframe extends JFrame implements ActionListener {

    protected JPanel epanel;
    protected JPanel effectPanel;
    protected JPanel mpanel;
    protected JPanel musicPanel;
    protected JPanel cutScenesPanel;
    protected JPanel AutosavePanel;
    protected JLabel AutotsaveText;
    protected JLabel cutscenesText;
    protected JLabel musicText;
    protected JLabel effectText;
    protected JLabel contentpane;
    protected JLabel musiclabel;
    protected JSlider musicSlider;
    protected JSlider effectSlider;
    protected ArrayList<Sound> musicSound;
    protected ArrayList<Sound> effectSound;
    protected JCheckBox musiccheck;
    protected JCheckBox effectcheck;
    protected JToggleButton toggleButton, toggleButton_2;
    protected String path;
    protected int frameWidth = 1366;
    protected int frameHeight = 768;

    public Optionframe(ArrayList<Sound> mSound, ArrayList<Sound> eSound, String imagepath) {
        musicSound = mSound;
        effectSound = eSound;
        path = imagepath;

        setTitle("Option");
        setBounds(50, 50, frameWidth, frameHeight);
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

    public static void main(String[] args) {
        MainMenu m = new MainMenu();
        final Optionframe obj = new Optionframe(m.musicSound, m.effectSound, m.imagepath);
        obj.repaint();
        obj.setVisible(true);

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

            musicPanel.setBounds(0, 90, 800, 100);
            musicPanel.setLayout(null);
            musicPanel.setOpaque(false);
            // musicPanel.setBackground(new Color(0,0,0,150));
            musiclabel = new JLabel();
            musiclabel.setIcon(music_min);
            musiclabel.setHorizontalAlignment(JLabel.CENTER);
            musiclabel.setBounds(70, 0, 75, 75);
            musicPanel.add(musiclabel);

            musicSlider = new JSlider(1, 10, 5);
            musicSlider.setBounds(150, 0, 400, 75);
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
            mpanel.setBounds(535, 110, 100, 25);
            mpanel.setOpaque(false);
            musiccheck = new JCheckBox(" mute ");
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
                effectText.setBounds(80, 205, 700, 30);
            }
            effectPanel.setBounds(0, 250, 800, 100);
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
            effectSlider.setBounds(150, 0, 400, 75);
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
                epanel.setBounds(535, 270, 100, 25);
                epanel.setOpaque(false);
                effectcheck = new JCheckBox(" mute ");
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
                cutscenesText.setText("CUTSCENES");
                cutscenesText.setBounds(80, 360, 700, 30);
            }
            cutScenesPanel.setBounds(0, 355, 700, 100);
            cutScenesPanel.setOpaque(false); // ทำให้ไม่เห็นพื้นหลังสีขาว
            // effectPanel.setBackground(new Color(0,0,0,150));

            toggleButton = new JToggleButton("ON/OFF");
            {
                toggleButton.setForeground(Color.black);
                // UIManager.put("toggleButton.selected", Color.ORANGE);
                ItemListener itemListener = new ItemListener() {
                    public void itemStateChanged(ItemEvent itemEvent) {
                        int cutsceneson_off = itemEvent.getStateChange();
                        if (cutsceneson_off == ItemEvent.SELECTED) {
                            System.out.println("Selected Cutscenes"); // show your message here
                        } else {
                            System.out.println("Deselected Cutscenes"); // remove your message
                        }
                    }
                };
                toggleButton.addItemListener(itemListener);
            }
        }

        AutosavePanel = new JPanel();
        {
            AutotsaveText = new JLabel();
            {
                AutotsaveText.setFont(new Font("Charter", Font.BOLD, 30));
                AutotsaveText.setForeground(Color.white);
                AutotsaveText.setText("AUTO-SAVE");
                AutotsaveText.setBounds(80, 430, 700, 30);
            }
            AutosavePanel.setBounds(0, 425, 700, 100);
            AutosavePanel.setOpaque(false); // ทำให้ไม่เห็นพื้นหลังสีขาว
            toggleButton_2 = new JToggleButton("ON/OFF");
            {
                toggleButton_2.setForeground(Color.black);
                // UIManager.put("toggleButton.selected", Color.ORANGE);
                ItemListener itemListener = new ItemListener() {
                    public void itemStateChanged(ItemEvent itemEvent) {
                        int autosaveonn_off = itemEvent.getStateChange();
                        if (autosaveonn_off == ItemEvent.SELECTED) {
                            System.out.println("Selected Autosave"); // show your message here
                        } else {
                            System.out.println("Deselected Autosave"); // remove your message
                        }
                    }
                };
                toggleButton_2.addItemListener(itemListener);
            }
        }
        JPanel MainPanel = new JPanel(); // black background
        {
            MainPanel.setBounds(0, 0, 800, 768);
            MainPanel.setBackground(new Color(0, 0, 0, 150));
        }

        mpanel.add(musiccheck);
        epanel.add(effectcheck);
        musicPanel.add(musicSlider);
        effectPanel.add(effectSlider);

        contentpane.add(cutscenesText);
        cutScenesPanel.add(toggleButton);

        AutosavePanel.add(toggleButton_2);

        contentpane.add(musicText);
        contentpane.add(effectText);
        contentpane.add(AutotsaveText);
        contentpane.add(AutosavePanel);
        contentpane.add(cutScenesPanel);
        contentpane.add(mpanel);
        contentpane.add(epanel);
        contentpane.add(musicPanel);
        contentpane.add(effectPanel);
        contentpane.add(MainPanel);
        cutScenesPanel.add(toggleButton);

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