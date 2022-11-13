package project3;

import javax.swing.JFrame;
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
    private JLabel Stat;
    private JLabel contentpane;

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
        /*Characterlabel ro1 = new Characterlabel(path, "robot4.png", 150, 150, this); // it a robot
        ro1.setMoveConditions(600, 450);
        ro1.addMouse();

        Characterlabel ro2 = new Characterlabel(path, "robot2.png", 150, 150, this); // it a robot
        ro2.setMoveConditions(300, 450);
        ro2.addMouse();

        contentpane.add(ro1);
        contentpane.add(ro2);*/

        // stat label

        // validate();
        repaint();

    }

    public void addcomponent() {
        Characterlabel ro1 = new Characterlabel(path, "robot4.png", 150, 150, this); // it a robot
        ro1.setMoveConditions(600, 450);
        ro1.addMouse();

        Characterlabel ro2 = new Characterlabel(path, "robot2.png", 150, 150, this); // it a robot
        ro2.setMoveConditions(300, 450);
        ro2.addMouse();

        contentpane.add(ro1);
        contentpane.add(ro2);
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

    public Characterlabel(String path, String filename, int width, int height, Stageframe pf) {

        this.width = width;
        this.height = height;
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

            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });
    }
}

class Statlabel extends JLabel {

    protected MyImageIcon staticon, staticon2;
    protected int curX, curY, width, height;
    protected Stageframe parentFrame;

    public Statlabel(String path, String filename, int width, int height, Stageframe pf) {

        this.width = width;
        this.height = height;
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
