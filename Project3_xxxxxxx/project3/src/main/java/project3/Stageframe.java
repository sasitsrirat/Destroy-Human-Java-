package project3;

import java.awt.*;

import java.util.*;
import javax.swing.*;

import javax.swing.JFrame;

import javax.swing.event.MouseInputListener;
import java.awt.event.*;

public class Stageframe extends JFrame {

    private int frameHeight = 768;
    private int frameWidth = 1366;
    private int stagenum, wave;
    private int choose = 0;
    private String imagepath; // project3\Project3_xxxxxxx\project3\src\pictures
    // private Character activeCharacter;
    private Humanwave hw; // hw = new humanwave(1,1); // hwArraylist = hw.gethu();
    private Robotwave rw; // rw = new Robotwave(1); // robotArraylist = rw.gethu();
    private ArrayList<Robot> robotArraylist;
    private ArrayList<Human> humanArraylist;
    private ArrayList<Characterlabel> robotLabelArraylist, humanLabelArraylist;
    private Random rand = new Random();
    private Characterlabel activeLabel, targetLabel;
    private StatLabel stat;
    private JLabel contentpane;
    private JLabel warn = new JLabel();
    private int currentstate = 0;
    protected ArrayList<Sound> musicSound = new ArrayList<Sound>(), effectSound = new ArrayList<Sound>();
    private ArrayList<Thread> threadArraylist;
    private final int robotstate = 1;
    private final int humanstate = 2;
    private final int skillstate = 3;
    private final int actiostate = 4;

    public Stageframe(String ipath, ArrayList<Sound> mSound, ArrayList<Sound> eSound, int stage) { // อาจจะรับ ArrayList
                                                                                                   // เข้ามา
        hw = new Humanwave(stage, 1, this);
        rw = new Robotwave(stage, this);
        sethumanArraylist();
        setrobotArraylist();
        stagenum = stage;
        imagepath = ipath;
        musicSound = mSound;
        effectSound = eSound;
        for (Sound i : musicSound) {
            if (i.getName() == "gereBG") {
                i.playLoop();
            }
        }
        contentpane = new JLabel();
        MyImageIcon background = new MyImageIcon(imagepath + "8-Bit-Backgrounds2.jpg"); // project3\Project3_xxxxxxx\project3\src\pictures\8-Bit-Backgrounds.jpg
        contentpane.setIcon(background.resize(frameWidth, frameHeight));
        contentpane.setOpaque(true);
        contentpane.setLayout(null);

        this.addcomponent();
        // battle();
        validate();
        repaint();

    }

    public void setcharacterstage(int stage) {
        hw = new Humanwave(stage, 1, this);
        rw = new Robotwave(stage, this);
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

    public void sethumanArraylist() {
        this.humanArraylist = hw.gethu();
    }

    public void setrobotArraylist() {
        this.robotArraylist = rw.getro();
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

    public void addcomponent() {
        for (Sound i : effectSound) {
            if (i.getName() == "clickEF") {
                stat = new StatLabel(imagepath, "StatusBG.png", i, frameWidth, frameHeight - 480, this);
            }
        }
        stat.setMoveConditions(0, 480);
        stat.addlabelcomponent();
        addallhuman();
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
        }
    }

    public void addallhuman() {
        humanLabelArraylist = new ArrayList<Characterlabel>();
        for (int i = 0; i < humanArraylist.size(); i++) {
            humanLabelArraylist.add(new Characterlabel(imagepath, 180, 180, this, stat, humanArraylist.get(i)));
            humanLabelArraylist.get(i).addMouse();
            contentpane.add(humanLabelArraylist.get(i));
        }
    }

    public void setallrobot() {

    }

    public void setallhuman() {

    }

    public void stage2() {
        ImageIcon temp = new ImageIcon(imagepath + "city.gif");
        temp.setImage(temp.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
        contentpane.setIcon(temp);
        validate();
        repaint();
    }

    public void stage1() {
        ImageIcon temp = new ImageIcon(imagepath + "warzone-scene.png");
        temp.setImage(temp.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
        contentpane.setIcon(temp);
        validate();
        repaint();
    }

    public void battle() { // stage battle
        for (int i = 0; i < 10; i++) {
            threadArraylist = new ArrayList<Thread>();
        for (Robot ro : robotArraylist) {
            threadArraylist.add(ro.getspeedthread());
        }
        for (Human hu : humanArraylist) {
            threadArraylist.add(hu.getspeedthread());
        }
        for (Thread th : threadArraylist) {
            th.start();
        }
        }
    }

    public synchronized void setactiveLabel(Character c) {
        activeLabel = c.getLabel();
        stat.setactiveCharacter(activeLabel.getOwner());
        stat.ShowAction(activeLabel.getOwner());
        try {
            Thread.currentThread();
            Thread.sleep(99999999);
        } catch (InterruptedException e) {
        }
        try {
            Thread.currentThread();
            Thread.sleep(2500);
        } catch (InterruptedException e) {

        }
        stat.HideButton();
    }

    public void checkdeath() {
        for (int j = 0; j < humanArraylist.size(); j++) { // check death here
            if (humanArraylist.get(j).checkdeath() == 1) {
                System.out.printf("%s is death\n", humanArraylist.get(j).getname());
                humanArraylist.remove(j);
                j = j - 1;
            }
        }
        for (int j = 0; j < robotArraylist.size(); j++) {
            if (robotArraylist.get(j).checkdeath() == 1) {
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
            warn.setBounds(423, 150, 520, 70);
            contentpane.add(warn);
            choose = 1;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            this.currentstate = 4;
            activeLabel.getOwner().attack(targetLabel.getOwner());
            activeLabel.attack_animation();
            for (Sound i : effectSound) {
                if ("robotnormalattackEF".equals(i.getName())) {
                    targetLabel.takedmg_animation("hit.gif", i);
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
            warn.setBounds(423, 150, 520, 70);
            contentpane.add(warn);
            choose = 2;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            // this.currentstate = 4;
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
            warn.setBounds(423, 150, 520, 70);
            contentpane.add(warn);
            choose = 3;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            warn.setText(" Don't Choose the Enemy");
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Robot) {
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

    public void action_enemy(Human h) { // Arraylist human,character
        int size = robotArraylist.size();
        if (size == 0) {
            System.out.printf("Human action\n");

            int a = rand.nextInt(size);
            h.attack(robotArraylist.get(a));
        }
    }
}
