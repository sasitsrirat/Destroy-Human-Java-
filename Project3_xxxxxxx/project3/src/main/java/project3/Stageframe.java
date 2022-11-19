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
    private String imagepath ; //project3\Project3_xxxxxxx\project3\src\pictures
    private String soundpath ;
    private Humanwave hw;   // hw = new humanwave(1,1); // hwArraylist = hw.gethu();
    private Robotwave rw;  // rw = new Robotwave(1); // robotArraylist = rw.gethu();
    private ArrayList<Robot> robotArraylist;
    private ArrayList<Human> humanArraylist;
    private Random rand = new Random();
    private Characterlabel robot1, robot2, robot3;
    private Characterlabel enemy1, enemy2, enemy3;
    private Characterlabel activeLabel;
    private StatLabel stat;
    private JLabel contentpane;
    private int stagenum ;
    private int wave ;

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
        battle();
        this.addcomponent();

        validate();
        repaint();

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
        stat = new StatLabel(imagepath, "StatusBG.png", 1352, 250, this);
        stat.setMoveConditions(0, 480);
        stat.addlabelcomponent();
        addallhuman();
        addallrobot();
        /*robot1 = new Characterlabel(imagepath, "robot4.png", 200, 200, this,stat); // it a robot
        robot1.setposition(1);
        robot1.addMouse();

        robot2 = new Characterlabel(imagepath, "robot2.png", 200, 200, this,stat); // it a robot
        robot2.setposition(2);
        robot2.addMouse();
        
        robot3 = new Characterlabel(imagepath, "robot2.png", 200, 200, this,stat); // it a robot
        robot3.setposition(3);
        robot3.addMouse();

        enemy1 = new Characterlabel(imagepath, "Mutanthuman.png", 200, 200, this,stat); // it a robot
        enemy1.setposition(4);
        enemy1.addMouse();
        
        enemy2 = new Characterlabel(imagepath, "repairman.png", 200, 200, this,stat); // it a robot
        enemy2.setposition(5);
        enemy2.addMouse();
        
        enemy3 = new Characterlabel(imagepath, "sd1.png", 200, 200, this,stat); // it a robot
        enemy3.setposition(6);
        enemy3.addMouse();
        
        
        contentpane.add(robot1);
        contentpane.add(robot2);
        contentpane.add(robot3);
        contentpane.add(enemy1);
        contentpane.add(enemy2);
        contentpane.add(enemy3);*/
        contentpane.add(stat);

        validate();
        repaint();
    }
    public void addallrobot() {
        if (robotArraylist.size() == 3) {
            robot1 = new Characterlabel(imagepath, robotArraylist.get(0).getimage(), 150, 150, this, stat); // it a robot
            robot1.setposition(robotArraylist.get(0).getposition());
            robot1.addMouse();
            robotArraylist.get(0).setLabel(robot1);

            robot2 = new Characterlabel(imagepath, robotArraylist.get(1).getimage(), 150, 150, this, stat); // it a robot
            robot2.setposition(robotArraylist.get(1).getposition());
            robot2.addMouse();
            robotArraylist.get(1).setLabel(robot2);

            robot3 = new Characterlabel(imagepath, robotArraylist.get(2).getimage(), 150, 150, this, stat); // it a robot
            robot3.setposition(robotArraylist.get(2).getposition());
            robot3.addMouse();
            robotArraylist.get(2).setLabel(robot3);

            contentpane.add(robot1);
            contentpane.add(robot2);
            contentpane.add(robot3);

        } else if (robotArraylist.size() == 2) {
            robot1 = new Characterlabel(imagepath, robotArraylist.get(0).getimage(), 150, 150, this, stat); // it a robot
            robot1.setposition(robotArraylist.get(0).getposition());
            robot1.addMouse();
            robotArraylist.get(0).setLabel(robot1);

            robot2 = new Characterlabel(imagepath, robotArraylist.get(1).getimage(), 150, 150, this, stat); // it a robot
            robot2.setposition(robotArraylist.get(1).getposition());
            robot2.addMouse();
            robotArraylist.get(1).setLabel(robot2);

            contentpane.add(robot1);
            contentpane.add(robot2);

        } else if(robotArraylist.size() == 1){
            robot1 = new Characterlabel(imagepath, robotArraylist.get(0).getimage(), 150, 150, this, stat); // it a robot
            robot1.setposition(robotArraylist.get(0).getposition());
            robot1.addMouse();
            robotArraylist.get(0).setLabel(robot1);

            contentpane.add(robot1);
        }

    }
    public void addallhuman() {
        if (humanArraylist.size() == 3) {
            enemy1 = new Characterlabel(imagepath, humanArraylist.get(0).getimage(), 150, 150, this, stat); // it a robot
            enemy1.setposition(humanArraylist.get(0).getposition());
            enemy1.addMouse();
            humanArraylist.get(0).setLabel(enemy1);

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
        }

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

    public static void main(String[] args) { // for test ting frame
        //new Stageframe();
    }

    //Old dude
    /*public void stage(int n, int w) {
        stagenum = n;
        wave = w;
        Robotwave ally = new Robotwave(n);
        robotArraylist = ally.getro();
        for (int index = 0; index < wave; index++) {
            Humanwave enemy = new Humanwave(stagenum, index + 1);
            humanArraylist = enemy.gethu();
            this.battle();
        }
    }*/

    public void battle() { // stage battle
        activeLabel = robotArraylist.get(0).getLabel();
        /*int i = 0;
        for (Robot r : robotArraylist) {
            r.introduce();
        }
        for (Human h : humanArraylist) {
            h.introduce();
        }
        while (i < 10) {
            for (Robot r : robotArraylist) {
                //action_robot(r);
                activeLabel = r.getLabel() ;
                checkdeath();
            }
            for (Human h : humanArraylist) {
                action_enemy(h);
                checkdeath();
            } 
            checkdeath();
            System.out.printf("End round %d\n********************\n\n", i + 1);
            // output from wave

            // run
            i++;
            if (robotArraylist.size() == 0 || humanArraylist.size() == 0) {
                i = 10;
            }
        }*/
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

    public void robot_attack(Robot ro) { // Arraylist robot,character
        JLabel warn = new JLabel("Choose the enemy");
        
        
        /*System.out.printf("Robot action\n");
        // show choice
        System.out.printf("Enter 1 to use skill\n\n");
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (Exception e) {
        }
        switch (choice) {
            case 1: // choose skill
                action_robot_skill(ro);
                break;
            case 2: // item use jcheckbox

                break;
            case 3: // choose rest

            default:
                break;
        }
        //System.out.print(robot.size());*/
    }

    public void action_robot_skill(Robot ro) {
        JLabel warn = new JLabel("Choose the enemy");
        System.out.printf("Enter 1 to use normal attack\n\n");
        Scanner scan = new Scanner(System.in);
        int choice_2 = scan.nextInt();
        switch (choice_2) {
            case 1: // choose normal attack
                int h = chooseenemy();
                ro.attack(humanArraylist.get(h));
                System.out.printf("%s attack %s\n", ro.getname(), humanArraylist.get(h).getname());
                break;
            case 2: // special skill

                break;
            case 3: // ultimate skill

                break;
            default:
                //action_robot(ro);
                break;
        }
    }

    public void action_enemy(Human h) { // Arraylist human,character
        int size = robotArraylist.size();
        if(size==0){
        System.out.printf("Human action\n");
        
        int a = rand.nextInt(size);
        h.attack(robotArraylist.get(a));
        }
    }

    public int chooseenemy() {
        int i = 1;
        for (Human h : humanArraylist) {
            System.out.printf("%d. ", i);
            h.introduce();
            i++;
        }
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt() - 1;
        return choice;
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
};

class Characterlabel extends JLabel {

    protected MyImageIcon staticon, staticon2;
    protected int curX, curY, width, height, position;
    protected Stageframe parentFrame;
    protected StatLabel status;

    public Characterlabel(String path, String filename, int width, int height, Stageframe pf,StatLabel sl) {
        
        this.width = width;
        this.height = height;
        status = sl;
        staticon = new MyImageIcon(path + filename).resize(width, height);
        staticon2 = new MyImageIcon(path + "robot3.png").resize(width, height);

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

    public void setposition(int po){
        position = po;
        switch (position) {
            case 1:
                setMoveConditions(50 , 240);
                break;
            case 2:
                setMoveConditions(250 , 240);
                break;
            case 3:
                setMoveConditions(450 , 240);
                break;
            case 4:
                setMoveConditions(parentFrame.getWidth() - 250 , 240);
                break;
            case 5:
                setMoveConditions(parentFrame.getWidth() - 450 , 240);
                break;
            case 6:
                setMoveConditions(parentFrame.getWidth() - 650 , 240);
                break;
            default:
                break;
        }
    }

    public void addFocus() {
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }

    public void addMouse() {
        this.addMouseListener(new MouseInputListener() {
            public void mousePressed(MouseEvent e) 
            {
 
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
                setIcon(staticon2);
                Character ex = new Character();
                for(int i = 0 ; i < parentFrame.gethumanArraylist().size(); i++){
                    if(position == parentFrame.gethumanArraylist().get(i).getposition()){
                        ex = parentFrame.gethumanArraylist().get(i);
                    }
                }
                for(int i = 0 ; i < parentFrame.getrobotArraylist().size(); i++){
                    if(position == parentFrame.getrobotArraylist().get(i).getposition()){
                        ex = parentFrame.getrobotArraylist().get(i);
                    }
                }
                status.settext(ex.getatk(), ex.gethp(), ex.getmax_hp(), ex.getdf(), ex.getname());
                parentFrame.repaint();
                
                validate();
            }

            public void mouseExited(MouseEvent e) {
                setIcon(staticon);
                //stat.setVisible(false);
                parentFrame.repaint();
                validate();
            }

            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                /*if (parentFrame.getstagenum() != 2) {
                    parentFrame.stage2();
                    parentFrame.setstagenum(2);
                } else {
                    parentFrame.stage1();
                    parentFrame.setstagenum(1);
                }
                status.settext(21,21,21,"kong3");*/
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });
    }
}

class StatLabel extends JLabel {
    protected MyImageIcon statusicon;
    protected int curX, curY, width, height;
    protected Stageframe parentFrame;
    protected Character activeCharacter;
    protected Border border;
    protected JLabel atktext = new JLabel();;
    protected JLabel hptext = new JLabel();
    protected JLabel deftext = new JLabel();
    protected JLabel spdtext = new JLabel();
    protected JLabel nametext = new JLabel();
    protected String imagepath;
    private   JLabel panelpane;


    public StatLabel(String path, String filename, int width, int height, Stageframe pf) {
        
        imagepath = path;
        this.width = width;
        this.height = height;
        border = BorderFactory.createLineBorder(Color.WHITE, 3);
        statusicon = new MyImageIcon(imagepath + filename).resize(width, height);
        setIcon(statusicon);
        setBorder(border);
        setOpaque(true);
        setLayout(null);
        parentFrame = pf;
        setBounds(getVisibleRect());
        setVisible(true);

    }

    public void getactiveCharacter(Character ac) {
        activeCharacter = ac;
        settext(activeCharacter.getatk(), activeCharacter.gethp(), activeCharacter.getmax_hp(), activeCharacter.getdf(), activeCharacter.getname());
    }

    public void setvisiblestatlabel(boolean n){
        this.setVisible(n);
        validate();
    }

    public void settext(int atk,int hp,int max_hp,int def,String name) {
        atktext.setText("ATK : "+ Integer.toString(atk));
        hptext.setText("HP  : "+ Integer.toString(hp) + "/ " + Integer.toString(max_hp));
        deftext.setText("DEF : "+ Integer.toString(def));
        nametext.setText("name : "+name);

        repaint();
        parentFrame.repaint();
    }

    public void setMoveConditions(int x, int y) {
        curX = x;
        curY = y;
        setBounds(curX, curY, width, height);

    }

    public void addlabelcomponent() {

        atktext.setBackground(null);       
        atktext.setForeground(Color.white);
        atktext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        atktext.setText("ATK : 20");
        atktext.setBounds(140,40, 200, 30);

        hptext.setBackground(null);       
        hptext.setForeground(Color.white);
        hptext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        hptext.setText("HP : 20/ 20");
        hptext.setBounds(140,70, 200, 30);

        deftext.setBackground(null);       
        deftext.setForeground(Color.white);
        deftext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        deftext.setText("DEF : 20");
        deftext.setBounds(140,100, 200, 30);

        nametext.setBackground(null);       
        nametext.setForeground(Color.white);
        nametext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        nametext.setText("name : Kawin");
        nametext.setBounds(140,130, 200, 30);

        JButton attackButton = new JButton(" Attack");
        {
            attackButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            attackButton.setIcon(new MyImageIcon(imagepath + "normalattack.png").resize(40, 40));
            attackButton.setBackground(new Color(222, 0, 62));
            attackButton.setForeground(Color.white);
            attackButton.setSize(100, 200);
            attackButton.setUI(new StyledButtonUI());
            attackButton.setForeground(new Color(255, 255, 255));
            attackButton.setBounds(500, 50, 150, 50);
            attackButton.setLayout(null);
            attackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    //clickSound.playOnce();
                    
                }
            });
        }
        
        JButton skillButton = new JButton(" Skill ");
        {
            skillButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            skillButton.setIcon(new MyImageIcon(imagepath + "skill_critical.png").resize(40, 40));
            skillButton.setBackground(new Color(222, 0, 62));
            skillButton.setForeground(Color.white);
            skillButton.setSize(100, 200);
            skillButton.setUI(new StyledButtonUI());
            skillButton.setForeground(new Color(255, 255, 255));
            skillButton.setBounds(500, 110, 150, 50);
            skillButton.setLayout(null);
            skillButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    //clickSound.playOnce();
                    
                }
            });
        }
        
        JButton restButton = new JButton(" rest  ");
        {
            restButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            restButton.setIcon(new MyImageIcon(imagepath + "rest.png").resize(40, 40));
            restButton.setBackground(new Color(222, 0, 62));
            restButton.setForeground(Color.white);
            restButton.setSize(100, 200);
            restButton.setUI(new StyledButtonUI());
            restButton.setForeground(new Color(255, 255, 255));
            restButton.setBounds(500, 170, 150, 50);
            restButton.setLayout(null);
            restButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    //clickSound.playOnce();
                    
                }
            });
        }

        this.add(atktext);
        this.add(hptext);
        this.add(deftext);
        this.add(nametext);
        this.add(attackButton);
        this.add(skillButton);
        this.add(restButton);
        
        validate();
        repaint();
    }
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
