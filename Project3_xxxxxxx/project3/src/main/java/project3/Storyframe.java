package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Storyframe extends JFrame {
    private int frameHeight = 768;
    private int frameWidth = 1366;
    private Font storyFont = new Font("Times New Roman", Font.PLAIN, 52);
    private JLabel story1, story2, story3, story4, story5;
    private JLabel contentpane;
    private JPanel nextButtonPanel;
    private JButton nextButton;
    private JTextArea story1Text, story2Text, story3Text, story4Text, story5Text;
    protected Stageframe sframe;
    protected Storyframe strframe;
    protected MainMenu mainMenu;
    private int scurX = 50;
    private int scurY = 700;
    private String imagepath;
    protected ArrayList<Sound> musicSound, effectSound;

    public Storyframe(int stagenum, String ipath, ArrayList<Sound> mSound, ArrayList<Sound> eSound,
            MainMenu m) {
        mainMenu = m;
        imagepath = ipath;
        musicSound = mSound;
        effectSound = eSound;
        contentpane = new JLabel();
        // MyImageIcon background = new MyImageIcon(imagepath + "space-background.png");
        contentpane.setBackground(Color.black);
        // contentpane.setIcon(background.resize(frameWidth, frameHeight));
        contentpane.setOpaque(true);
        contentpane.setLayout(null);
        setContentPane(contentpane);
        for (Sound i : musicSound) {
            if ("storyBG".equals(i.getName())) {
                i.playLoop();
            }
        }
        setNextButtonPanel();

        switch (stagenum) {
            case 1:
                story1();
                break;
            case 2:
                story2();
                break;
            case 3:
                story3();
                break;
            case 4:
                story4();
                break;
            case 5:
                story5();
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
        nextButton.setBackground(Color.yellow);
        nextButton.setForeground(Color.black);
        nextButton.setUI(new StyledButtonUI());
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
                if ("storyBG".equals(i.getName())) {
                    i.stop();
                }
            }
            sframe = new Stageframe(imagepath, musicSound, effectSound, mainMenu, 1);
            setTitle("Stage");
            mainMenu.setContentPane(sframe.getContentpane());
            validate();
            mainMenu.validate();
            repaint();
            mainMenu.repaint();
        }
    }

    public void story1() {
        story1 = new JLabel();
        story1.setBounds(100, 100, 1100, 700);
        contentpane.add(story1);

        story1Text = new JTextArea(
                "When the future world is destroyed by human.\nThe robot C3P0 must travel back in time to \nstop the humans before they destroy everything.\n"
                        +
                        "\nIn 2099 , After successfully turning back time,\nthe first robot began surveying the area and\nkilling humans in order to prevent the planet\nfrom collapsing.");
        story1Text.setBounds(100, 100, frameWidth, frameHeight);
        story1Text.setOpaque(false);
        story1Text.setForeground(Color.orange);
        story1Text.setFont(storyFont);
        story1Text.setLineWrap(true);
        story1.add(story1Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story1.setLocation(scurX, scurY);
                    scurY -= 5;
                    if (scurY < 25) {
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
                "When the second robot found that the first robot\nwas trying to complete the task on his own, the \nsecond robot followed him  and assisted him in \npreparing to invade the human armory. \n\n*The second "
                        +
                        "robot can repair other robot 🔧*");
        story2Text.setBounds(100, 100, frameWidth, frameHeight);
        story2Text.setOpaque(false);
        story2Text.setForeground(Color.orange);
        story2Text.setFont(storyFont);
        story2Text.setLineWrap(true);
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
                "From many obstacles along the way through. we has \nheaded to the first destination, The Human Armory.\nbut you didn't know that inside the armory there \nare many soldiers waiting for you.");
        story3Text.setBounds(100, 100, frameWidth, frameHeight);
        story3Text.setOpaque(false);
        story3Text.setForeground(Color.orange);
        story3Text.setFont(storyFont);
        story3Text.setLineWrap(true);
        story3.add(story3Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story1.setLocation(scurX, scurY);
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
                "All battalion was killed. robot no.003 was join\nin the league. forward to final destination, \nRobot Factory. \n\n***Robot no.003 ability: can shooting the bomb like a bomber***");
        story4Text.setBounds(100, 100, frameWidth, frameHeight);
        story4Text.setOpaque(false);
        story4Text.setForeground(Color.orange);
        story4Text.setFont(storyFont);
        story4Text.setLineWrap(true);
        story4.add(story4Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story1.setLocation(scurX, scurY);
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
        story5.add(story5Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    story1.setLocation(scurX, scurY);
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

    public static void main(String[] args) { // for test ting frame
        // new Storyframe(1);
    }
}
