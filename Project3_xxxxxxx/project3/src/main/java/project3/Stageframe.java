package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;

public class Stageframe extends JFrame {

    private int frameHeight = 768;
    private int frameWidth = 1366;
    private int stagenum, wave;
    private boolean choose = false;
    private String imagepath, soundpath ; //project3\Project3_xxxxxxx\project3\src\pictures
    //private Character activeCharacter;
    private Humanwave hw;   // hw = new humanwave(1,1); // hwArraylist = hw.gethu();
    private Robotwave rw;  // rw = new Robotwave(1); // robotArraylist = rw.gethu();
    private ArrayList<Robot> robotArraylist;
    private ArrayList<Human> humanArraylist;
    private ArrayList<Characterlabel> robotLabelArraylist, humanLabelArraylist;
    private Random rand = new Random();
    private Characterlabel robot1, robot2, robot3;
    private Characterlabel enemy1, enemy2, enemy3;
    private Characterlabel activeLabel, targetLabel;
    private StatLabel stat;
    private JLabel contentpane;
    
    public Stageframe(String ipath, String spath,int stage) { // อาจจะรับ ArrayList เข้ามา
        hw = new Humanwave(stage,1);
        rw = new Robotwave(stage);
        sethumanArraylist();
        setrobotArraylist();
        stagenum = stage;
        imagepath = ipath;
        soundpath = spath;
        contentpane = new JLabel();
        MyImageIcon background = new MyImageIcon(imagepath + "8-Bit-Backgrounds2.jpg"); // project3\Project3_xxxxxxx\project3\src\pictures\8-Bit-Backgrounds.jpg
        contentpane.setIcon(background.resize(frameWidth, frameHeight));
        contentpane.setOpaque(true);
        contentpane.setLayout(null);
        
        this.addcomponent();
        battle();
        validate();
        repaint();

    }

    public boolean getchoose() {
        return choose;
    }

    public void settargetLabel(Characterlabel tl){
        targetLabel = tl;
    }

    public void sethumanArraylist(){
        this.humanArraylist = hw.gethu();
    }

    public void setrobotArraylist(){
        this.robotArraylist = rw.getro();
    }

    public ArrayList<Human> gethumanArraylist(){
        return humanArraylist;
    }

    public ArrayList<Robot> getrobotArraylist(){
        return robotArraylist;
    }

    public int getWidth(){
        return frameWidth;
    }

    public int getHeighth(){
        return frameHeight;
    }

    public JLabel getContentpane(){
        return contentpane;
    }

    public int getstagenum() {
        return this.stagenum;
    }

    public void setstagenum(int num) {
        this.stagenum = num;
    }

    public void addcomponent() {
        stat = new StatLabel(imagepath, "StatusBG.png", 1366, 286, this);
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
        for(int i = 0; i < robotArraylist.size(); i++){
            robotLabelArraylist.add(new Characterlabel(imagepath, 150, 150, this, stat,robotArraylist.get(i)));
            robotLabelArraylist.get(i).addMouse();
            contentpane.add(robotLabelArraylist.get(i));
        }
        
        /*if (robotArraylist.size() == 3) {
            robot1 = new Characterlabel(imagepath, 150, 150, this, stat,  robotArraylist.get(0)); // it a robot
            //robot1.setposition(robotArraylist.get(0).getposition());
            robot1.addMouse();
            //robotArraylist.get(0).setLabel(robot1);

            robot2 = new Characterlabel(imagepath, 150, 150, this, stat,  robotArraylist.get(1)); // it a robot
            //robot2.setposition(robotArraylist.get(1).getposition());
            robot2.addMouse();
            //robotArraylist.get(1).setLabel(robot2);

            robot3 = new Characterlabel(imagepath, 150, 150, this, stat,  robotArraylist.get(2)); // it a robot
            //robot3.setposition(robotArraylist.get(2).getposition());
            robot3.addMouse();
            //robotArraylist.get(2).setLabel(robot3);

            contentpane.add(robot1);
            contentpane.add(robot2);
            contentpane.add(robot3);

        } else if (robotArraylist.size() == 2) {
            robot1 = new Characterlabel(imagepath, 150, 150, this, stat,  robotArraylist.get(0)); // it a robot
            //robot1.setposition(robotArraylist.get(0).getposition());
            robot1.addMouse();
            //robotArraylist.get(0).setLabel(robot1);

            robot2 = new Characterlabel(imagepath, 150, 150, this, stat,  robotArraylist.get(1)); // it a robot
            //robot2.setposition(robotArraylist.get(1).getposition());
            robot2.addMouse();
            //robotArraylist.get(1).setLabel(robot2);

            contentpane.add(robot1);
            contentpane.add(robot2);

        } else if(robotArraylist.size() == 1){
            robot1 = new Characterlabel(imagepath, 150, 150, this, stat,  robotArraylist.get(0)); // it a robot
            //robot1.setposition(robotArraylist.get(0).getposition());
            robot1.addMouse();
            //robotArraylist.get(0).setLabel(robot1);

            contentpane.add(robot1);
        }*/

    }
    public void addallhuman() {
        humanLabelArraylist = new ArrayList<Characterlabel>();
        for(int i = 0; i < humanArraylist.size(); i++){
            humanLabelArraylist.add(new Characterlabel(imagepath, 150, 150, this, stat,humanArraylist.get(i)));
            humanLabelArraylist.get(i).addMouse();
            contentpane.add(humanLabelArraylist.get(i));
        }
        /*if (humanArraylist.size() == 3) {
            enemy1 = new Characterlabel(imagepath, 150, 150, this, stat,  humanArraylist.get(0)); // it a robot
            //enemy1.setposition(robotArraylist.get(0).getposition());
            enemy1.addMouse();
            //humanArraylist.get(0).setLabel(robot1);

            enemy2 = new Characterlabel(imagepath, humanArraylist.get(1).getimage(), 150, 150, this, stat); // it a robot
            enemy2.setposition(humanArraylist.get(1).getposition());
            enemy2.addMouse();
            humanArraylist.get(1).setLabel(enemy2);

            enemy3 = new Characterlabel(imagepath, humanArraylist.get(2).getimage(), 150, 150, this, stat); // it a robot
            enemy3.setposition(humanArraylist.get(2).getposition());
            enemy3.addMouse();
            humanArraylist.get(2).setLabel(enemy3);

            contentpane.add(enemy1);
            contentpane.add(enemy2);
            contentpane.add(enemy3);

        } else if (humanArraylist.size() == 2) {
            enemy1 = new Characterlabel(imagepath, humanArraylist.get(0).getimage(), 150, 150, this, stat); // it a robot
            enemy1.setposition(humanArraylist.get(0).getposition());
            enemy1.addMouse();
            humanArraylist.get(0).setLabel(enemy1);

            enemy2 = new Characterlabel(imagepath, humanArraylist.get(1).getimage(), 150, 150, this, stat); // it a robot
            enemy2.setposition(humanArraylist.get(1).getposition());
            enemy2.addMouse();
            humanArraylist.get(1).setLabel(enemy2);

            contentpane.add(enemy1);
            contentpane.add(enemy2);

        } else if(humanArraylist.size() == 1){
            enemy1 = new Characterlabel(imagepath, humanArraylist.get(0).getimage(), 150, 150, this, stat); // it a robot
            enemy1.setposition(humanArraylist.get(0).getposition());
            enemy1.addMouse();
            humanArraylist.get(0).setLabel(enemy1);

            contentpane.add(enemy1);
        }*/

    }
    public void setallrobot(){

    }
    public void setallhuman(){

    }

    public void stage2() {
        ImageIcon temp = new ImageIcon(imagepath + "city.gif");
        temp.setImage(temp.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT)); // size of
                                                                                                        // background
        // MyImageIcon temp = new MyImageIcon(path + "city.gif");
        contentpane.setIcon(temp);
        validate();
        repaint();
    }

    public void stage1() {
        ImageIcon temp = new ImageIcon(imagepath + "warzone-scene.png");
        temp.setImage(temp.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT)); // size of
                                                                                                        // background
        // MyImageIcon temp = new MyImageIcon(path + "city.gif");
        contentpane.setIcon(temp);
        validate();
        repaint();
    }

    public void battle() { // stage battle
        activeLabel = robotLabelArraylist.get(0);
        stat.setactiveCharacter(activeLabel.getOwner());
        stat.ShowAction(activeLabel.getOwner());
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
        if(targetLabel == null){
        JLabel warn = new JLabel("Choose the enemy");
        warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
        warn.setBackground(new Color(222, 0, 62));
        warn.setForeground(Color.white);
        warn.setBounds(433, 150, 500, 70);
        contentpane.add(warn);
        choose = true;
        }
        else{
            activeLabel.getOwner().attack(targetLabel.getOwner());
            choose = false;
            stat.settargetCharacter(targetLabel.getOwner());
            targetLabel = null;
        }
        contentpane.repaint();
        validate();
    }

    public void action_robot_skill() {
        //stat.setLtext(activeLabel, activeLabel, activeLabel, activeLabel, activeLabel);
    }

    public void action_enemy(Human h) { // Arraylist human,character
        int size = robotArraylist.size();
        if(size==0){
        System.out.printf("Human action\n");
        
        int a = rand.nextInt(size);
        h.attack(robotArraylist.get(a));
        }
    }

    /*public int chooseenemy() {
        int i = 1;
        for (Human h : humanArraylist) {
            System.out.printf("%d. ", i);
            h.introduce();
            i++;
        }
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt() - 1;
        return choice;
    }*/
}

// ======================================================================================================================
class templatelabel extends JLabel implements MouseInputListener, FocusListener {

    protected MyImageIcon staticon, staticon2;
    protected int curX, curY, width, height;
    protected Stageframe parentFrame;

    public templatelabel(String path, String filename, int width, int height, Stageframe pf) {

        this.width = width;
        this.height = height;
        staticon = new MyImageIcon(path + filename).resize(width, height);
        staticon2 = new MyImageIcon(path + "robot2.png").resize(width, height);
        setIcon(staticon);
        setHorizontalAlignment(JLabel.CENTER);
        parentFrame = pf;
        setBounds(getVisibleRect());
        setVisible(true);

    }

    public void setMoveConditions(int x, int y) {
        curX = x;
        curY = y;
        setBounds(curX, curY, width, height);

    }

    // mouselistener
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    // ----- (1) handler for MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    // ----- (2) handler for MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    // focuslistener

    public void focusGained(FocusEvent e) {
        this.setIcon(staticon2);
        parentFrame.repaint();
        validate();
    }

    public void focusLost(FocusEvent e) {
        this.setIcon(staticon);
        parentFrame.repaint();
        validate();
    }

    public void addFocus(templatelabel what) {
        what.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                what.setIcon(staticon2);
                parentFrame.repaint();
                validate();

            }

            @Override
            public void focusLost(FocusEvent e) {
                what.setIcon(staticon);
                parentFrame.repaint();
                validate();

            }
        });
    }

    public void addMouse() {
        this.addMouseListener(new MouseInputListener() {
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
                setIcon(staticon2);
                parentFrame.repaint();
                validate();
            }

            public void mouseExited(MouseEvent e) {
                setIcon(staticon);
                parentFrame.repaint();
                validate();
            }

            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            // ----- (2) handler for MouseMotionListener
            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });
    }
}
