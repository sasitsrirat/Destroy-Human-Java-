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
        contentpane = new JLabel();
        MyImageIcon background = new MyImageIcon(imagepath + "8-Bit-Backgrounds2.jpg"); // project3\Project3_xxxxxxx\project3\src\pictures\8-Bit-Backgrounds.jpg
        contentpane.setIcon(background.resize(frameWidth, frameHeight));
        contentpane.setOpaque(true);
        contentpane.setLayout(null);
        this.addcomponent();

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
        robot1.setMoveConditions(250, 240);
        robot1.addMouse();

        robot2 = new Characterlabel(imagepath, "robot2.png", 200, 200, this,stat); // it a robot
        robot2.setMoveConditions(50, 240);
        robot2.addMouse();
        
        robot3 = new Characterlabel(imagepath, "robot2.png", 200, 200, this,stat); // it a robot
        robot3.setMoveConditions(450, 240);
        robot3.addMouse();

        enemy1 = new Characterlabel(imagepath, "Mutanthuman.png", 200, 200, this,stat); // it a robot
        enemy1.setMoveConditions(716, 240);
        enemy1.addMouse();
        
        enemy2 = new Characterlabel(imagepath, "repairman.png", 200, 200, this,stat); // it a robot
        enemy2.setMoveConditions(916, 240);
        enemy2.addMouse();
        
        enemy3 = new Characterlabel(imagepath, "sd1.png", 200, 200, this,stat); // it a robot
        enemy3.setMoveConditions(1116, 240);
        enemy3.addMouse();
        
        contentpane.add(stat);
        contentpane.add(robot1);
        contentpane.add(robot2);
        contentpane.add(robot3);
        contentpane.add(enemy1);
        contentpane.add(enemy2);
        contentpane.add(enemy3);

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
    public void setvisiblestatlabel(boolean n){
        this.setVisible(n);
        validate();
    }

    public void settext(int atk,int hp,int def,String name) {
        atktext.setText("ATK : "+ Integer.toString(atk));
        hptext.setText("HP  : "+ Integer.toString(hp) + "/ " + Integer.toString(hp));
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
        nametext.setText("name : kawin");
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
