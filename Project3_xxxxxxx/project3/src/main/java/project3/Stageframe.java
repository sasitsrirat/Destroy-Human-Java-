package project3;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stageframe extends JFrame {

    private int frameHeight = 768;
    private int frameWidth = 1366;
    private String path = "project3/Project3_xxxxxxx/project3/src/pictures/";
    private JLabel robot1, robot2, robot3;
    private JLabel enemy1, enemy2, enemy3;
    private Statpanel stat;
    private JLabel contentpane;
    private int stagenum = 1;

    public Stageframe() { // อาจจะรับ ArrayList เข้ามา

        setBounds(50, 50, frameWidth, frameHeight);
        setTitle("Stage");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        setContentPane(contentpane = new JLabel());
        MyImageIcon background = new MyImageIcon(path + "8-Bit-Backgrounds.jpg"); // project3\Project3_xxxxxxx\project3\src\pictures\8-Bit-Backgrounds.jpg
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

    public int getstagenum() {
        return this.stagenum;
    }

    public void setstagenum(int num) {
        this.stagenum = num;
    }

    public void addcomponent() {
        stat = new Statpanel(path, null, 800, 100, this);
        stat.setMoveConditions(283, 615);
        stat.addpanelcomponent();

        Characterlabel ro1 = new Characterlabel(path, "robot4.png", 150, 150, this,stat); // it a robot
        ro1.setMoveConditions(600, 450);
        ro1.addMouse();

        Characterlabel ro2 = new Characterlabel(path, "robot2.png", 150, 150, this,stat); // it a robot
        ro2.setMoveConditions(300, 450);
        ro2.addMouse();

        contentpane.add(stat);
        contentpane.add(ro1);
        contentpane.add(ro2);

        validate();
        repaint();
    }

    public void stage2() {
        ImageIcon temp = new ImageIcon(path + "city.gif");
        temp.setImage(temp.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT)); // size of
                                                                                                        // background
        // MyImageIcon temp = new MyImageIcon(path + "city.gif");
        contentpane.setIcon(temp);
        validate();
        repaint();
    }

    public void stage1() {
        ImageIcon temp = new ImageIcon(path + "warzone-scene.png");
        temp.setImage(temp.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT)); // size of
                                                                                                        // background
        // MyImageIcon temp = new MyImageIcon(path + "city.gif");
        contentpane.setIcon(temp);
        validate();
        repaint();
    }

    public static void main(String[] args) { // for test ting frame
        new Stageframe();
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
    protected Statpanel status;

    public Characterlabel(String path, String filename, int width, int height, Stageframe pf,Statpanel sp) {

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

class Statpanel extends JPanel {
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


    public Statpanel(String path, String filename, int width, int height, Stageframe pf) {

        this.width = width;
        this.height = height;
        border = BorderFactory.createLineBorder(Color.WHITE, 3);
        // statusicon = new MyImageIcon(path + filename).resize(width, height);

        // setIcon(statusicon);
        
        setBackground(new Color(0, 0, 0, 75));
        setForeground(new Color(0, 0, 0));
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

    public void addpanelcomponent() {

        
        atktext.setBackground(null);       
        atktext.setForeground(Color.white);
        atktext.setText("ATK : 20");
        atktext.setBounds(70,10, 60, 20);

        hptext.setBackground(null);       
        hptext.setForeground(Color.white);
        hptext.setText("HP : 20");
        hptext.setBounds(70,30, 60, 20);

        deftext.setBackground(null);       
        deftext.setForeground(Color.white);
        deftext.setText("DEF : 20");
        deftext.setBounds(70,50, 60, 20);

        nametext.setBackground(null);       
        nametext.setForeground(Color.white);
        nametext.setText("name : kawin");
        nametext.setBounds(70,70, 100, 20);



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
