/*6413110 Mr.Watcharsak Prommanee
6413112 Mr.Sasit Srirat
6413210 Mr.Kawin Kengkate
6413223 Mr.Ravipol Chayeraksa*/
package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Storyframe extends JFrame {
    private int frameHeight;
    private int frameWidth;
    private int stage;
    private Font storyFont = new Font("Times New Roman", Font.PLAIN, 52);
    private JLabel story1, story2, story3, story4, story5, endstory;
    private JLabel contentpane;
    private JPanel nextButtonPanel;
    private JButton nextButton;
    private JTextArea story1Text, story2Text, story3Text, story4Text, story5Text, endstoryText;
    protected Stageframe sframe;
    protected Storyframe strframe;
    protected MainMenu mainMenu;
    private int scurX = 133;
    private int scurY = 700;
    private String imagepath;
    protected ArrayList<Sound> musicSound, effectSound;

    public Storyframe(int n, String ipath, ArrayList<Sound> mSound, ArrayList<Sound> eSound, MainMenu m, int fw,
            int fh) {
        mainMenu = m;
        imagepath = ipath;
        musicSound = mSound;
        effectSound = eSound;
        frameWidth = fw;
        frameHeight = fh;
        stage = n;
        contentpane = new JLabel();
        MyImageIcon background = new MyImageIcon(imagepath + "space-background.jpg").resize(frameWidth, frameHeight);
        contentpane.setBackground(Color.black);
        contentpane.setIcon(background);
        contentpane.setOpaque(true);
        contentpane.setLayout(null);
        setNextButtonPanel();

        switch (stage) {
            case 1:
                for (Sound i : musicSound) {
                    if ("story1BG".equals(i.getName())) {
                        i.playLoop();
                    }
                }
                story1();
                break;
            case 2:
                for (Sound i : musicSound) {
                    if ("story2BG".equals(i.getName())) {
                        i.playLoop();
                    }
                }
                story2();
                break;
            case 3:
                for (Sound i : musicSound) {
                    if ("story3BG".equals(i.getName())) {
                        i.playLoop();
                    }
                }
                story3();
                break;
            case 4:
                for (Sound i : musicSound) {
                    if ("story4BG".equals(i.getName())) {
                        i.playLoop();
                    }
                }
                story4();
                break;
            case 5:
                for (Sound i : musicSound) {
                    if ("story5BG".equals(i.getName())) {
                        i.playLoop();
                    }
                }
                story5();
                break;
            case 6:
                for (Sound i : musicSound) {
                    if ("endBG".equals(i.getName())) {
                        i.playLoop();
                    }
                }
                endstory();
                break;
            default:
        }
        validate();
        repaint();
    }

    public int setNextButtonPanel() {
        nextframeHandler nfHandler = new nextframeHandler();
        nextButtonPanel = new JPanel();
        nextButtonPanel.setBounds(1100, 600, 150, 100);
        nextButtonPanel.setOpaque(false);
        nextButton = new JButton("NEXT >>");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButtonPanel.add(nextButton);
        contentpane.add(nextButtonPanel);
        nextButton.addActionListener(nfHandler);
        nextButtonPanel.setVisible(false);
        if (nextButtonPanel.isVisible()) {
            return 1;
        }
        return 0;
    }

    public class nextframeHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            for (Sound i : musicSound) {
                i.stop();
            }
            if (stage > 5) {
                for (Sound i : musicSound) {
                    if ("mainmenuBG".equals(i.getName())) {
                        i.playLoop();
                    }
                }
                mainMenu.openscore();
                mainMenu.setContentPane(mainMenu.getPane());
            } else {
                mainMenu.startstage(stage);
            }
            validate();
            mainMenu.validate();
            repaint();
            mainMenu.repaint();
        }
    }

    public void story1() {
        story1 = new JLabel();
        story1.setBounds(scurX, scurY, 1100, 700);
        contentpane.add(story1);
        story1Text = new JTextArea(
                "When the future world is destroyed by human.\nThe robot MUSIX-6000 and friends\nmust travel back in time to \nstop the humans before they destroy everything.\n"
                        +
                        "\nIn 2099 , After successfully turning back time,\nthe first robot began surveying the area and\nkilling humans in order to prevent the planet\nfrom collapsing.");
        story1Text.setBounds(100, 100, frameWidth, frameHeight);
        story1Text.setOpaque(false);
        story1Text.setForeground(Color.orange);
        story1Text.setFont(storyFont);
        story1Text.setLineWrap(true);
        story1Text.setEditable(false);
        story1.add(story1Text);
        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story1.setLocation(scurX, scurY);
                    scurY -= 5;
                    if (scurY < 20) {
                        nextButtonPanel.setVisible(true);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        });
        animation.start();
        
        validate();
        repaint();
    }

    public void story2() {
        story2 = new JLabel();
        story2.setBounds(100, 100, 1100, 700);
        contentpane.add(story2);

        story2Text = new JTextArea(
                "When the second robot N2Y2 found that the \nfirst robot was trying to complete\nthe task on his own, the \nsecond robot followed him  and assisted him in \npreparing to invade the human armory. \n\n*The second "
                        +
                        "robot can repair other robot");
        story2Text.setBounds(100, 100, frameWidth, frameHeight);
        story2Text.setOpaque(false);
        story2Text.setForeground(Color.orange);
        story2Text.setFont(storyFont);
        story2Text.setLineWrap(true);
        story2Text.setEditable(false);
        story2.add(story2Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story2.setLocation(scurX, scurY);
                    scurY -= 5;
                    if (scurY < 50) {
                        nextButtonPanel.setVisible(true);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        });
        animation.start();

        validate();
        repaint();
    }

    public void story3() {
        story3 = new JLabel();
        story3.setBounds(100, 100, 1100, 700);
        contentpane.add(story3);

        story3Text = new JTextArea(
                "From many obstacles along the way through.\nwe has headed to the first destination,\nThe Human Armory.but you didn't \nknow that inside the armory there \nare many soldiers waiting for you.");
        story3Text.setBounds(100, 100, frameWidth, frameHeight);
        story3Text.setOpaque(false);
        story3Text.setForeground(Color.orange);
        story3Text.setFont(storyFont);
        story3Text.setLineWrap(true);
        story3Text.setEditable(false);
        story3.add(story3Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story3.setLocation(scurX, scurY);
                    scurY -= 5;
                    if (scurY < 50) {
                        nextButtonPanel.setVisible(true);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        });
        animation.start();

        validate();
        repaint();
    }

    public void story4() {
        story4 = new JLabel();
        story4.setBounds(100, 100, 1100, 700);
        contentpane.add(story4);

        story4Text = new JTextArea(
                "All battalion was killed. robot no.3 Ba-Be was join\nin the league. forward to final destination, \nRobot Factory. \n\n***Ba-Be ability: can shooting the bomb like a bomber***");
        story4Text.setBounds(100, 100, frameWidth, frameHeight);
        story4Text.setOpaque(false);
        story4Text.setForeground(Color.orange);
        story4Text.setFont(storyFont);
        story4Text.setLineWrap(true);
        story4Text.setEditable(false);
        story4.add(story4Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story4.setLocation(scurX, scurY);
                    scurY -= 5;
                    if (scurY < 50) {
                        nextButtonPanel.setVisible(true);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        });
        animation.start();

        validate();
        repaint();
    }

    public void story5() {
        story5 = new JLabel();
        story5.setBounds(100, 100, 1100, 700);
        contentpane.add(story5);

        story5Text = new JTextArea(
                "To surviving once the world has fallen. Humans \nhave done multiple experiments in order to create\nsuperhumans capable of surpassing all human \nlimitations and living in extreme environments.\nWhen all of robots going to control center of \nRobot Factory, superhuman appears");
        story5Text.setBounds(100, 100, frameWidth, frameHeight);
        story5Text.setOpaque(false);
        story5Text.setForeground(Color.orange);
        story5Text.setFont(storyFont);
        story5Text.setLineWrap(true);
        story5Text.setEditable(false);
        story5.add(story5Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story5.setLocation(scurX, scurY);
                    scurY -= 5;
                    if (scurY < 50) {
                        nextButtonPanel.setVisible(true);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        });
        animation.start();

        validate();
        repaint();
    }

    public void endstory() {
        endstory = new JLabel();
        endstory.setBounds(100, 100, 1100, 700);
        contentpane.add(endstory);

        endstoryText = new JTextArea("Finally, robot can take the Robot Factory back. \nFactory produced a large number of robots to do\nevery human occupation. After the robots wiped off\nall of humanity on Earth, the robot civilization \nbegan to spread throughout the universe.");
        endstoryText.setBounds(100, 100, frameWidth, frameHeight);
        endstoryText.setOpaque(false);
        endstoryText.setForeground(Color.orange);
        endstoryText.setFont(storyFont);
        endstoryText.setLineWrap(true);
        endstory.add(endstoryText);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    endstory.setLocation(scurX, scurY);
                    scurY -= 5;
                    if (scurY < 50) {
                        nextButtonPanel.setVisible(true);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        });
        animation.start();

        validate();
        repaint();
    }

    public JLabel getContentpane() {
        return contentpane;
    }
}
