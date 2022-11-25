package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Storyframe extends JFrame {
    private int frameHeight = 768;
    private int frameWidth = 1366;
    private String path = "Project3_xxxxxxx/project3/src/pictures/";
    private Font storyFont = new Font("Times New Roman", Font.PLAIN, 52);
    private JLabel story1, story2, story3;
    private JLabel contentpane;
    private JPanel nextButtonPanel;
    private JButton nextButton;
    private JTextArea story1Text, story2Text, story3Text;
    protected Stageframe sframe;
    protected Storyframe strframe;
    private int scurX=50;
    private int scurY=700;
    private String imagepath = "Project3_xxxxxxx/project3/src/pictures/";
    private int stagenum = 1;
    protected ArrayList<Sound> musicSound = new ArrayList<Sound>(), effectSound = new ArrayList<Sound>();

    public Storyframe(int stagen)
    {
        //"src/pictures/"; // "project3/Project3_xxxxxxx/project3/src/pictures/"
        String soundpath = "Project3_xxxxxxx/project3/src/sounds/";
        // set background music
        musicSound.add(new Sound(soundpath + "BossTime.wav", "mainmenuBG"));
        musicSound.add(new Sound(soundpath + "namlie.wav", "gereBG"));
        for (Sound i : musicSound) {
            if ("mainmenuBG".equals(i.getName())) {
                i.playLoop();
            }
        }
        effectSound.add(new Sound(soundpath + "click.wav", "clickEF"));
        effectSound.add(new Sound(soundpath + "Laser.wav", "robotnormalattackEF"));
        effectSound.add(new Sound(soundpath + "lightening.wav", "robotskill1EF"));
        effectSound.add(new Sound(soundpath + "heal_robot.wav", "robotskill2EF"));
        effectSound.add(new Sound(soundpath + "bombef.wav", "robotskill3EF"));
        effectSound.add(new Sound(soundpath + "punch.wav", "humannormalattackEF"));


        contentpane = new JLabel();
        nextframeHandler nfHandler = new nextframeHandler();
        ImageIcon background = new ImageIcon(path + "space-background.jpg");

        contentpane.setIcon(background);
        contentpane.setOpaque(true);
        contentpane.setLayout(null);

        nextButtonPanel = new JPanel();
        nextButtonPanel.setBounds(1100, 600, 200, 100);
        nextButtonPanel.setOpaque(false);
        nextButton = new JButton("NEXT >>");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButtonPanel.add(nextButton);
        contentpane.add(nextButtonPanel);
        nextButton.addActionListener(nfHandler);
        nextButtonPanel.setVisible(false);

        switch (stagen){
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

    public class nextframeHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {

            sframe = new Stageframe(imagepath, musicSound, effectSound, 1);
            setTitle("Stage");
            setContentPane(sframe.getContentpane());
            dispose();
            validate();
            repaint();
        }
    }

    public void  story1()
    {
        /*int curX = 50, curY;*/
        story1 = new JLabel();
        story1.setBounds(scurX, scurY, 1100, 700);
        contentpane.add(story1);

        story1Text = new JTextArea("When the future world is destroyed by human.\nThe robot C3P0 must travel back in time to \nstop the humans before they destroy everything.\n" +
                "\nIn 2099 , After successfully turning back time,\nthe first robot began surveying the area and\nkilling humans in order to prevent the planet\nfrom collapsing.");
        story1Text.setBounds(100, 100, 1100, 700);
        story1Text.setOpaque(false);
        story1Text.setForeground(Color.orange);
        story1Text.setFont(storyFont);
        story1Text.setLineWrap(true);
        story1.add(story1Text);


        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    story1.setLocation(scurX, scurY);
                    scurY-=5;
                    if(scurY<25){nextButtonPanel.setVisible(true);}
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        });
        animation.start();




      /*nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                sframe = new Stageframe(imagepath, musicSound, effectSound, 1);
                // play for first time stage 1
                setTitle("Stage");
                animation.stop();
                setContentPane(sframe.getContentpane());
                validate();
            }
        });*/

        validate();
        repaint();
    }

    public void  story2()
    {
        story1 = new JLabel();
        story1.setBounds(100, 100, 1100, 700);
        contentpane.add(story1);

        nextButtonPanel = new JPanel();
        nextButtonPanel.setBounds(1100, 600, 200, 100);
        nextButtonPanel.setOpaque(false);

        nextButton = new JButton("NEXT >>");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButtonPanel.add(nextButton);
        contentpane.add(nextButtonPanel);
        nextButtonPanel.setVisible(false);
        story1Text = new JTextArea("When the second robot found that the first robot\nwas trying to complete the task on his own, the \nsecond robot followed him  and assisted him in \npreparing to invade the human armory. \n\n*The second "+
                "robot can repair other robot 🔧*");
        story1Text.setBounds(100, 100, frameWidth, frameHeight);
        story1Text.setOpaque(false);
        story1Text.setForeground(Color.orange);
        story1Text.setFont(storyFont);
        story1Text.setLineWrap(true);
        story1.add(story1Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    story1.setLocation(scurX, scurY);
                    scurY-=5;
                    if(scurY<50){nextButtonPanel.setVisible(true);}
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        });
        animation.start();

/*
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                sframe = new Stageframe(imagepath, musicSound, effectSound, 1);
                // play for first time stage 1
                setTitle("Stage");
                setContentPane(sframe.getContentpane());
                validate();
            }
        }); */

        validate();
        repaint();
    }

    public void  story3()
    {
        story1 = new JLabel();
        story1.setBounds(100, 100, 1100, 700);
        contentpane.add(story1);

        nextButtonPanel = new JPanel();
        nextButtonPanel.setBounds(1100, 600, 200, 100);
        nextButtonPanel.setOpaque(false);

        nextButton = new JButton("NEXT >>");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButtonPanel.add(nextButton);
        contentpane.add(nextButtonPanel);
        nextButtonPanel.setVisible(false);
        story1Text = new JTextArea("From many obstacles along the way through. we has \nheaded to the first destination, The Human Armory.\nbut you didn't know that inside the armory there \nare many soldiers waiting for you.");
        story1Text.setBounds(100, 100, frameWidth, frameHeight);
        story1Text.setOpaque(false);
        story1Text.setForeground(Color.orange);
        story1Text.setFont(storyFont);
        story1Text.setLineWrap(true);
        story1.add(story1Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    story1.setLocation(scurX, scurY);
                    scurY-=5;
                    if(scurY<50){nextButtonPanel.setVisible(true);}
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        });
        animation.start();

/*
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                sframe = new Stageframe(imagepath, musicSound, effectSound, 1);
                // play for first time stage 1
                setTitle("Stage");
                setContentPane(sframe.getContentpane());
                validate();
            }
        }); */

        validate();
        repaint();
    }

    public void  story4()
    {
        story1 = new JLabel();
        story1.setBounds(100, 100, 1100, 700);
        contentpane.add(story1);

        nextButtonPanel = new JPanel();
        nextButtonPanel.setBounds(1100, 600, 200, 100);
        nextButtonPanel.setOpaque(false);

        nextButton = new JButton("NEXT >>");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButtonPanel.add(nextButton);
        contentpane.add(nextButtonPanel);
        nextButtonPanel.setVisible(false);
        story1Text = new JTextArea("All battalion was killed. robot no.003 was join\nin the league. forward to final destination, \nRobot Factory. \n\n***Robot no.003 ability: can shooting the bomb like a bomber***");
        story1Text.setBounds(100, 100, frameWidth, frameHeight);
        story1Text.setOpaque(false);
        story1Text.setForeground(Color.orange);
        story1Text.setFont(storyFont);
        story1Text.setLineWrap(true);
        story1.add(story1Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    story1.setLocation(scurX, scurY);
                    scurY-=5;
                    if(scurY<50){nextButtonPanel.setVisible(true);}
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        });
        animation.start();

/*
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                sframe = new Stageframe(imagepath, musicSound, effectSound, 1);
                // play for first time stage 1
                setTitle("Stage");
                setContentPane(sframe.getContentpane());
                validate();
            }
        }); */

        validate();
        repaint();
    }

    public void  story5()
    {
        story1 = new JLabel();
        story1.setBounds(100, 100, 1100, 700);
        contentpane.add(story1);

        nextButtonPanel = new JPanel();
        nextButtonPanel.setBounds(1100, 600, 200, 100);
        nextButtonPanel.setOpaque(false);

        nextButton = new JButton("NEXT >>");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButtonPanel.add(nextButton);
        contentpane.add(nextButtonPanel);
        nextButtonPanel.setVisible(false);
        story1Text = new JTextArea("To surviving once the world has fallen. Humans \nhave done multiple experiments in order to create\nsuperhumans capable of surpassing all human \nlimitations and living in extreme environments.\nWhen all of robots going to control center of \nRobot Factory, superhuman appears");
        story1Text.setBounds(100, 100, frameWidth, frameHeight);
        story1Text.setOpaque(false);
        story1Text.setForeground(Color.orange);
        story1Text.setFont(storyFont);
        story1Text.setLineWrap(true);
        story1.add(story1Text);

        Thread animation = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    story1.setLocation(scurX, scurY);
                    scurY-=5;
                    if(scurY<50){nextButtonPanel.setVisible(true);}
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        });
        animation.start();

/*
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                sframe = new Stageframe(imagepath, musicSound, effectSound, 1);
                // play for first time stage 1
                setTitle("Stage");
                setContentPane(sframe.getContentpane());
                validate();
            }
        }); */

        validate();
        repaint();
    }


    public JLabel getContentpane() {
        return contentpane;
    }

    //public int getY() {return y;}

    public static void main(String[] args) { // for test ting frame
        new Storyframe(1);

    }
}

