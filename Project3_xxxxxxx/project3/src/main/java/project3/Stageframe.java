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
    private ArrayList<Robot> robot;
    private ArrayList<Human> human;
    private Random rand = new Random();
    private Characterlabel robot1, robot2, robot3;
    private Characterlabel enemy1, enemy2, enemy3;
    private StatLabel stat;
    private JLabel contentpane;
    private int stagenum = 1;
    private int wave = 1;

    public Stageframe(String ipath, String spath) { // อาจจะรับ ArrayList เข้ามา
        
        imagepath = ipath;
        soundpath = spath;
       /* setBounds(50, 50, frameWidth, frameHeight);
        setTitle("Stage");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        setContentPane(contentpane = new JLabel()); */
        contentpane = new JLabel();
        MyImageIcon background = new MyImageIcon(imagepath + "8-Bit-Backgrounds2.jpg"); // project3\Project3_xxxxxxx\project3\src\pictures\8-Bit-Backgrounds.jpg
        contentpane.setIcon(background.resize(frameWidth, frameHeight));
        contentpane.setOpaque(true);
        contentpane.setLayout(null);
        this.addcomponent();
        /*
         * Characterlabel ro1 = new Characterlabel(path, "robot4.png", 150, 150, this);
         * // it a robot
         * ro1.setMoveConditions(600, 450);
         * ro1.addMouse();
         * 
         * Characterlabel ro2 = new Characterlabel(path, "robot2.png", 150, 150, this);
         * // it a robot
         * ro2.setMoveConditions(300, 450);
         * ro2.addMouse();
         * 
         * contentpane.add(ro1);
         * contentpane.add(ro2);
         */

        // stat label

        validate();
        repaint();

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

        robot1 = new Characterlabel(imagepath, "robot4.png", 200, 200, this,stat); // it a robot
        robot1.setMoveConditions(350, 240);
        robot1.addMouse();

        robot2 = new Characterlabel(imagepath, "robot2.png", 200, 200, this,stat); // it a robot
        robot2.setMoveConditions(100, 240);
        robot2.addMouse();

        contentpane.add(stat);
        contentpane.add(robot1);
        contentpane.add(robot2);

        validate();
        repaint();
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

    public void runstage(int n, int w) {
        stagenum = n;
        wave = w;
        Robotwave ally = new Robotwave(n);
        robot = ally.getro();
        for (int index = 0; index < wave; index++) {
            Humanwave enemy = new Humanwave(stagenum, index + 1);
            human = enemy.gethu();
            this.battle();
        }
    }

    public void battle() { // stage battle
        int i = 0;
        for (Robot r : robot) {
            r.introduce();
        }
        for (Human h : human) {
            h.introduce();
        }
        while (i < 10) {
            for (Robot r : robot) {
                action_robot(r);
                checkdeath();
            }
            for (Human h : human) {
                action_enemy(h);
                checkdeath();
            } 
            checkdeath();
            System.out.printf("End round %d\n********************\n\n", i + 1);
            // output from wave

            // run
            i++;
            if (robot.size() == 0 || human.size() == 0) {
                i = 10;
            }
        }
    }

    public void checkdeath() {
        for (int j = 0; j < human.size(); j++) { // check death here
            if (human.get(j).checkdeath() == 1) {
                System.out.printf("%s is death\n", human.get(j).getname());
                human.remove(j);
                j = j - 1;
            }
        }
        for (int j = 0; j < robot.size(); j++) {
            if (robot.get(j).checkdeath() == 1) {
                System.out.printf("%s is death\n", robot.get(j).getname());
                robot.remove(j);
                j = j - 1;
            }
        }
    }

    public void action_robot(Robot ro) { // Arraylist robot,character
        System.out.printf("Robot action\n");
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
        //System.out.print(robot.size());
    }

    public void action_robot_skill(Robot ro) {
        System.out.printf("Enter 1 to use normal attack\n\n");
        Scanner scan = new Scanner(System.in);
        int choice_2 = scan.nextInt();
        switch (choice_2) {
            case 1: // choose normal attack
                int h = chooseenemy();
                ro.attack(human.get(h));
                System.out.printf("%s attack %s\n", ro.getname(), human.get(h).getname());
                break;
            case 2: // special skill

                break;
            case 3: // ultimate skill

                break;
            default:
                action_robot(ro);
                break;
        }
    }

    public void action_enemy(Human h) { // Arraylist human,character
        int size = robot.size();
        if(size==0){
        System.out.printf("Human action\n");
        
        int a = rand.nextInt(size);
        h.attack(robot.get(a));
        }
    }

    public int chooseenemy() {
        int i = 1;
        for (Human h : human) {
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
    protected int curX, curY, width, height;
    protected Stageframe parentFrame;
    protected Character character;
    protected StatLabel status;

    public Characterlabel(String path, String filename, int width, int height, Stageframe pf,StatLabel sp) {

        this.width = width;
        this.height = height;
        status = sp;
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
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
                setIcon(staticon2);
                //stat.setVisible(true);
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
                if (parentFrame.getstagenum() != 2) {
                    parentFrame.stage2();
                    parentFrame.setstagenum(2);
                } else {
                    parentFrame.stage1();
                    parentFrame.setstagenum(1);
                }
                status.settext(21,21,21,"kong3");
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
    protected Border border;
    protected JLabel atktext = new JLabel();;
    protected JLabel hptext = new JLabel();
    protected JLabel deftext = new JLabel();
    protected JLabel spdtext = new JLabel();
    protected JLabel nametext = new JLabel();
    private   JLabel panelpane;


    public StatLabel(String path, String filename, int width, int height, Stageframe pf) {

        this.width = width;
        this.height = height;
        border = BorderFactory.createLineBorder(Color.WHITE, 3);
        statusicon = new MyImageIcon(path + filename).resize(width, height);
        setIcon(statusicon);
        setBorder(border);
        setOpaque(true);
        setLayout(null);
        parentFrame = pf;
        setBounds(getVisibleRect());
        setVisible(true);

    }
    public void setvisiblestatpanel(boolean n){
        this.setVisible(n);
        validate();
    }

    public void settext(int atk,int hp,int def,String name) {
        atktext.setText("ATK : "+ Integer.toString(atk));
        hptext.setText("HP  : "+ Integer.toString(hp));
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
        hptext.setText("HP : 20");
        hptext.setBounds(140,70, 200, 30);

        deftext.setBackground(null);       
        deftext.setForeground(Color.white);
        deftext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        deftext.setText("DEF : 20");
        deftext.setBounds(140,100, 200, 30);

        nametext.setBackground(null);       
        nametext.setForeground(Color.white);
        nametext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        nametext.setText("name : kawin");
        nametext.setBounds(140,130, 200, 30);



        this.add(atktext);
        this.add(hptext);
        this.add(deftext);
        this.add(nametext);

        
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
