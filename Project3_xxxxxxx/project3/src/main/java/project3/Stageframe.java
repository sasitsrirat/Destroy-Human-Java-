package project3;

import java.awt.*;
import java.util.*;
import java.util.concurrent.CyclicBarrier;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;

public class Stageframe extends JFrame {

    private int frameHeight = 768;
    private int frameWidth = 1366;
    private int stagenum, allwave;
    private int choose = 0;
    private String imagepath; // project3\Project3_xxxxxxx\project3\src\pictures
    // private Character activeCharacter;
    private Stagewave sw;
    // private Humanwave hw; // hw = new humanwave(1,1); // hwArraylist =
    // hw.gethu();
    // private Robotwave rw; // rw = new Robotwave(1); // robotArraylist =
    // rw.gethu();
    private ArrayList<Robot> robotArraylist;
    private ArrayList<Human> humanArraylist;
    private ArrayList<Characterlabel> robotLabelArraylist, humanLabelArraylist;
    private Random rand = new Random();
    private Characterlabel activeLabel, targetLabel;
    private StatLabel stat;
    private JLabel contentpane;
    private JLabel activepoint = new JLabel();
    private JLabel warn = new JLabel();
    private JLabel[] RO = { new JLabel(), new JLabel(), new JLabel() };
    private JLabel[] HU = { new JLabel(), new JLabel(), new JLabel() };
    private int currentstate = 0;
    protected ArrayList<Sound> musicSound = new ArrayList<Sound>(), effectSound = new ArrayList<Sound>();
    private ArrayList<Thread> threadArraylist;
    private final int robotstate = 1;
    private final int humanstate = 2;
    private final int skillstate = 3;
    private final int actiostate = 4;
    private MainMenu main;

    public Stageframe(String ipath, ArrayList<Sound> mSound, ArrayList<Sound> eSound, MainMenu m, int stage) { // อาจจะรับ
                                                                                                               // ArrayList
        stagenum = stage;
        imagepath = ipath;
        musicSound = mSound;
        effectSound = eSound;
        main = m;
        for (Sound i : musicSound) {
            if ("gereBG".equals(i.getName())) {
                i.playLoop();
            }
        }
        contentpane = new JLabel();
        System.out.println("Hello");
        sw = new Stagewave(stage, this);
        allwave = sw.getWave();
        MyImageIcon background = new MyImageIcon(imagepath + "8-Bit-Backgrounds2.jpg"); // project3\Project3_xxxxxxx\project3\src\pictures\8-Bit-Backgrounds.jpg
        contentpane.setIcon(background.resize(frameWidth, frameHeight));
        contentpane.setOpaque(true);
        contentpane.setLayout(null);
        this.addcomponent();
        validate();
        repaint();
        battle(stage, 1);
    }

    public int getchoose() {
        return choose;
    }

    public Characterlabel getTargetLabel() {
        return targetLabel;
    }

    public void settargetLabel(Characterlabel tl) {
        targetLabel = tl;
    }

    public void sethumanArraylist(int wave) {
        this.humanArraylist = sw.gethu(wave);
    }

    public void setrobotArraylist() {
        this.robotArraylist = sw.getro();
    }

    public ArrayList<Human> gethumanArraylist() {
        return humanArraylist;
    }

    public ArrayList<Robot> getrobotArraylist() {
        return robotArraylist;
    }

    public int getWidth() {
        return frameWidth;
    }

    public int getHeighth() {
        return frameHeight;
    }

    public JLabel getContentpane() {
        return contentpane;
    }

    public int getstagenum() {
        return this.stagenum;
    }

    public void setstagenum(int num) {
        this.stagenum = num;
    }

    public void setstagestate(int a) {
        this.currentstate = a;
    }

    public int getstagestate() {
        return this.currentstate;
    }

    public void settext() {
        for (int i = 0; i < robotLabelArraylist.size(); i++) {
            RO[i].setText(robotLabelArraylist.get(i).getOwner().getname() + "  HP  : "
                    + Integer.toString(robotLabelArraylist.get(i).getOwner().gethp()) + "/ "
                    + Integer.toString(robotLabelArraylist.get(i).getOwner().getmax_hp()));

        }
        for (int i = 0; i < humanLabelArraylist.size(); i++) {
            HU[i].setText(humanLabelArraylist.get(i).getOwner().getname() + "  HP  : "
                    + Integer.toString(humanLabelArraylist.get(i).getOwner().gethp()) + "/ "
                    + Integer.toString(humanLabelArraylist.get(i).getOwner().getmax_hp()));
        }
        validate();
        repaint();
    }

    public void showactive() {
        MyImageIcon pointer = new MyImageIcon(imagepath + "pointer.png").resize(50, 50);
        activepoint.setBounds(activeLabel.getcurX() + 65, activeLabel.getcurY() - 55, 50, 50);
        activepoint.setIcon(pointer);
        activepoint.setVisible(true);
        contentpane.add(activepoint);
        validate();
        contentpane.repaint();
    }

    public void hideactive() {
        activepoint.setVisible(false);
        validate();
        repaint();
    }

    public void addcomponent() {
        for (Sound i : effectSound) {
            if ("clickEF".equals(i.getName())) {
                stat = new StatLabel(imagepath, "StatusBG.png", i, frameWidth, frameHeight - 480, this);
            }
        }
        stat.setMoveConditions(0, 480);
        stat.addlabelcomponent();

        setrobotArraylist();
        addallrobot();
        contentpane.add(stat);

        validate();
        repaint();
    }

    public void addallrobot() {
        robotLabelArraylist = new ArrayList<Characterlabel>();
        for (int i = 0; i < robotArraylist.size(); i++) {
            robotLabelArraylist.add(new Characterlabel(imagepath, 180, 180, this, stat, robotArraylist.get(i)));
            robotLabelArraylist.get(i).addMouse();
            contentpane.add(robotLabelArraylist.get(i));
            RO[i].setBackground(null);
            RO[i].setForeground(Color.white);
            RO[i].setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 13));
            RO[i].setBounds(robotLabelArraylist.get(i).getcurX(), robotLabelArraylist.get(i).getcurY() + 200, 200, 30);
            RO[i].setText(robotLabelArraylist.get(i).getOwner().getname() + "  HP  : "
                    + Integer.toString(robotLabelArraylist.get(i).getOwner().gethp()) + "/ "
                    + Integer.toString(robotLabelArraylist.get(i).getOwner().getmax_hp()));
            contentpane.add(RO[i]);
        }
    }

    public void addallhuman() {
        humanLabelArraylist = new ArrayList<Characterlabel>();
        for (int i = 0; i < humanArraylist.size(); i++) {
            humanLabelArraylist.add(new Characterlabel(imagepath, 180, 180, this, stat, humanArraylist.get(i)));
            humanLabelArraylist.get(i).addMouse();
            HU[i].setBackground(null);
            HU[i].setForeground(Color.white);
            HU[i].setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 13));
            HU[i].setBounds(humanLabelArraylist.get(i).getcurX(), humanLabelArraylist.get(i).getcurY() + 200, 180, 20);
            HU[i].setText(humanLabelArraylist.get(i).getOwner().getname() + "  HP  : "
                    + Integer.toString(humanLabelArraylist.get(i).getOwner().gethp()) + "/ "
                    + Integer.toString(humanLabelArraylist.get(i).getOwner().getmax_hp()));
            contentpane.add(humanLabelArraylist.get(i));
            contentpane.add(HU[i]);
        }
    }

    public void setallrobot() {

    }

    public void setallhuman() {

    }

    public void battle(int stage, int wave) { // stage battle
        sethumanArraylist(wave);
        addallhuman();
        validate();
        contentpane.repaint();

        Thread bruh = new Thread() {

            public void run() {

                for (int turn = 0; turn < 10 && humanArraylist.size() > 0 && robotArraylist.size() > 0; turn++) {

                    JOptionPane.showMessageDialog(null, " WAVE" + wave + " TURN " + (turn + 1), " STAGE" + stage,
                            JOptionPane.PLAIN_MESSAGE);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    threadArraylist = new ArrayList<Thread>();
                    for (Robot ro : robotArraylist) {

                        threadArraylist.add(ro.getspeedthread());
                        // ro.getspeedthread().start();

                    }
                    for (Human hu : humanArraylist) {
                        threadArraylist.add(hu.getspeedthread());
                        // hu.getspeedthread().start();
                    }
                    for (Thread th : threadArraylist) {
                        th.start();
                    }
                    for (Thread th : threadArraylist) {
                        try {
                            th.join();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                    for (Robot ro : robotArraylist) {
                        ro.setnewspeedthread();
                    }
                    for (Human hu : humanArraylist) {
                        hu.setnewspeedthread();
                    }
                }

                if (humanArraylist.isEmpty()) {
                    for (Characterlabel h : humanLabelArraylist) {
                        h.setVisible(false);
                    }
                    if (allwave > wave) {
                        battle(stage, wave + 1);
                    } else {
                        showvictory();
                        try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        if (stage >= 5) {
                            
                            System.out.println("F");
                            main.setContentPane(main.getPane());
                        } else {
                            System.out.println("YOU WIN STAGE" + stage);
                            Stageframe sf = new Stageframe(imagepath, musicSound, effectSound, main, stage + 1);
                            main.setContentPane(sf.getContentpane());
                            main.validate();
                            main.repaint();
                        }
                    }
                } else {
                    showdefeat();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("YOU LOOSE STAGE" + stage);
                    main.setContentPane(main.getPane());
                }

            }
        };
        bruh.start();
    }

    public synchronized void setactiveLabel(Character c) {
        if (robotArraylist.isEmpty() || humanArraylist.isEmpty()) {

        } else {
            activeLabel = c.getLabel();
            showactive();
            stat.setactiveCharacter(activeLabel.getOwner());
            // System.out.println(activeLabel.getOwner().getname());
            stat.ShowAction(activeLabel.getOwner());

            try {
                Thread.currentThread();
                Thread.sleep(99999999);
            } catch (InterruptedException e) {
            }
            settext();
            checkdeath();

            try {
                Thread.currentThread();
                Thread.sleep(2500);
            } catch (InterruptedException e) {

            }
            hideactive();
            stat.HideButton();
        }
    }

    public void checkdeath() {
        for (int j = 0; j < humanArraylist.size(); j++) { // check death here
            if (humanArraylist.get(j).checkdeath() == 1) {
                humanArraylist.get(j).getLabel().showdeath();
                humanArraylist.get(j).getspeedthread().stop(); // kill thread
                System.out.printf("%s is death\n", humanArraylist.get(j).getname());
                humanArraylist.remove(j);
                j = j - 1;
            }
        }
        for (int j = 0; j < robotArraylist.size(); j++) {
            if (robotArraylist.get(j).checkdeath() == 1) {
                robotArraylist.get(j).getLabel().showdeath();
                robotArraylist.get(j).getspeedthread().stop(); // kill thread
                System.out.printf("%s is death\n", robotArraylist.get(j).getname());
                robotArraylist.remove(j);
                j = j - 1;
            }
        }
    }

    public void robot_attack() { // Arraylist robot,character
        if (targetLabel == null) {
            warn.setText("   Choose the enemy");
            warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
            warn.setBackground(new Color(222, 0, 62));
            warn.setOpaque(true);
            warn.setForeground(Color.white);
            warn.setBounds(423, 50, 520, 70);
            contentpane.add(warn);
            choose = 1;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            this.currentstate = 4;
            stat.HideButton();
            activeLabel.getOwner().attack(targetLabel.getOwner());
            activeLabel.attack_animation();
            for (Sound i : effectSound) {
                if ("robotnormalattackEF".equals(i.getName())) {
                    targetLabel.takedmg_animation("hit.gif", i);
                }
            }
            Robot r = (Robot)activeLabel.getOwner();
            r.gainep(1);
            stat.settargetCharacter(targetLabel.getOwner());
            choose = 0;
            targetLabel = null;
            contentpane.remove(warn);
            this.currentstate = 0;
            contentpane.repaint();
            validate();

            activeLabel.getOwner().getspeedthread().interrupt();

        } else if (targetLabel.getOwner() instanceof Robot) {
            warn.setText(" Don't Choose the Ally");
            contentpane.repaint();
            validate();
        }
    }

    public void randomRobot() {
        int a = rand.nextInt(robotArraylist.size());
        targetLabel = robotArraylist.get(a).getLabel();
    }

    public void human_attack() {
        activeLabel.getOwner().attack(targetLabel.getOwner());
        activeLabel.attack_animation();
        for (Sound i : effectSound) {
            if ("humannormalattackEF".equals(i.getName())) {
                targetLabel.takedmg_animation("hit.gif", i);
            }
        }
        stat.settargetCharacter(targetLabel.getOwner());
        targetLabel = null;
        contentpane.repaint();
        validate();
        activeLabel.getOwner().getspeedthread().interrupt();
    }

    public void action_robot1_skill() {
        if (targetLabel == null) {
            warn.setText("   Choose the Enemy");
            warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
            warn.setBackground(new Color(222, 0, 62));
            warn.setOpaque(true);
            warn.setForeground(Color.white);
            warn.setBounds(423, 50, 520, 70);
            contentpane.add(warn);
            choose = 2;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            // this.currentstate = 4;
            stat.HideButton();
            activeLabel.getOwner().skill1(targetLabel.getOwner());
            activeLabel.attack_animation();
            for (Sound i : effectSound) {
                if ("robotskill1EF".equals(i.getName())) {
                    targetLabel.takedmg_animation("lightning.gif", i);
                }
            }
            stat.settargetCharacter(targetLabel.getOwner());

            choose = 0;
            targetLabel = null;
            contentpane.remove(warn);
            this.currentstate = 0;
            contentpane.repaint();
            validate();
            activeLabel.getOwner().getspeedthread().interrupt();
        } else if (targetLabel.getOwner() instanceof Robot) {
            warn.setText(" Don't Choose the Ally");
            contentpane.repaint();
            validate();
        }
    }

    public void action_robot2_skill() {
        if (targetLabel == null) {
            warn.setText("   Choose the Ally");
            warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
            warn.setBackground(new Color(222, 0, 62));
            warn.setOpaque(true);
            warn.setForeground(Color.white);
            warn.setBounds(423, 50, 520, 70);
            contentpane.add(warn);
            choose = 3;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            warn.setText(" Don't Choose the Enemy");
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Robot) {
            stat.HideButton();
            activeLabel.getOwner().skill2(targetLabel.getOwner());
            activeLabel.attack_animation();
            for (Sound i : effectSound) {
                if ("robotskill2EF".equals(i.getName())) {
                    targetLabel.takedmg_animation("healing.gif", i);
                }
            }
            stat.settargetCharacter(targetLabel.getOwner());
            choose = 0;
            targetLabel = null;
            contentpane.remove(warn);
            this.currentstate = 0;
            contentpane.repaint();
            validate();
            activeLabel.getOwner().getspeedthread().interrupt();
        }
    }

    public void action_robot3_skill() {
        stat.HideButton();
        activeLabel.getOwner().skill3(humanArraylist);
        activeLabel.attack_animation();
        for (Human hu : humanArraylist) {
            for (Sound i : effectSound) {
                if ("robotskill3EF".equals(i.getName())) {
                    hu.getLabel().takedmg_animation("bomb.gif", i);
                }
            }
            stat.settargetCharacter(hu);
        }
        this.currentstate = 0;
        contentpane.repaint();
        validate();
        activeLabel.getOwner().getspeedthread().interrupt();
    }

    public void action_rest() {
        stat.HideButton();
        Robot r = (Robot)activeLabel.getOwner();
        r.gainep(2);
        activeLabel.rest_animation();
        this.currentstate = 0;
        contentpane.repaint();
        validate();
        activeLabel.getOwner().getspeedthread().interrupt();
    }

    public void warnskill() {
            warn.setText("      not enough EP ");
            warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
            warn.setBackground(new Color(222, 0, 62));
            warn.setOpaque(true);
            warn.setForeground(Color.white);
            warn.setBounds(423, 50, 520, 70);
            contentpane.add(warn);
            contentpane.repaint();
            validate();
    }

    /*public void action_enemy(Human h) { // Arraylist human,character
        int size = robotArraylist.size();
        if (size == 0) {
            System.out.printf("Human action\n");

            int a = rand.nextInt(size);
            h.attack(robotArraylist.get(a));
        }
    }*/

    public void showvictory() {
        for (Sound i : effectSound) {
            if ("victoryEF".equals(i.getName())) {
                i.playOnce();
            }
        }
        JLabel effectLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(imagepath + "victory.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));

        effectLabel.setIcon(imageIcon);
        effectLabel.setBounds(383, 83, 600, 600);
        effectLabel.setVisible(true);
        effectLabel.setHorizontalAlignment(JLabel.CENTER);
        effectLabel.setLayout(null);
        contentpane.add(effectLabel);
        validate();
        contentpane.repaint();
        Thread bruh = new Thread() {
            public void run() {
                try {
                    Thread.currentThread();
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                effectLabel.setVisible(false);
                contentpane.remove(effectLabel);
                revalidate();
                contentpane.repaint();
            }
        };
        bruh.start();
    }

    public void showdefeat() {
        for (Sound i : effectSound) {
            if ("defeatEF".equals(i.getName())) {
                i.playOnce();
            }
        }
        JLabel effectLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(imagepath + "defeat.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));

        effectLabel.setIcon(imageIcon);
        effectLabel.setBounds(383, 83, 400, 400);
        effectLabel.setVisible(true);
        effectLabel.setHorizontalAlignment(JLabel.CENTER);
        effectLabel.setLayout(null);
        contentpane.add(effectLabel);
        validate();
        contentpane.repaint();
        Thread bruh = new Thread() {
            public void run() {
                try {
                    Thread.currentThread();
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                effectLabel.setVisible(false);
                contentpane.remove(effectLabel);
                revalidate();
                contentpane.repaint();
            }
        };
        bruh.start();
    }
}
