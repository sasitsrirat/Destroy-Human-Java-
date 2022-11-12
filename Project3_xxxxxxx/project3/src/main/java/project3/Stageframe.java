package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stageframe extends JFrame {

    private int frameHeight = 600;
    private int frameWidth = 900;
    private String path = "project3/Project3_xxxxxxx/project3/src/pictures/";
    private JLabel robot1,robot2,robot3;
    private JLabel enemy1,enemy2,enemy3;
    private JLabel Stat;
    private JLabel contentpane;


    public Stageframe(){
        
         
        setBounds(50,50,frameWidth,frameHeight);
        setTitle("Stage");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        setContentPane(contentpane = new JLabel());
	    MyImageIcon background = new MyImageIcon(path + "8-Bit-Backgrounds.jpg"); //project3\Project3_xxxxxxx\project3\src\pictures\8-Bit-Backgrounds.jpg
	    contentpane.setIcon( background.resize(frameWidth, frameHeight) );
        contentpane.setOpaque(true);
	    contentpane.setLayout( null );

        Statlabel statlabel = new Statlabel(path,"robot4.png", 100, 100, this); //it a robot 
        statlabel.setMoveConditions(600,370);

        Statlabel statlabel2 = new Statlabel(path,"robot2.png", 100, 100, this); //it a robot 
        statlabel2.setMoveConditions(300,370);

        contentpane.add(statlabel);
        contentpane.add(statlabel2);

        //stat label

        validate();
        repaint();

    }

    public void addcomponent(){
        
    }

    public static void main(String[] args){ // for test ting frame
         new Stageframe();
    }
}

class MyImageIcon extends ImageIcon
{
    public MyImageIcon(String fname)  { super(fname); }
    public MyImageIcon(Image image)   { super(image); }

    public MyImageIcon resize(int width, int height)
    {
	Image oldimg = this.getImage();
	Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new MyImageIcon(newimg);
    }
};

class Statlabel extends JLabel{

    protected MyImageIcon        staticon;
    protected int                curX, curY, width, height;
    protected Stageframe         parentFrame;

    public Statlabel(String path,String filename,int width,int height,Stageframe pf){

        this.width = width; 
        this.height = height;
        staticon = new MyImageIcon(path+filename).resize(width, height);
	    setIcon(staticon);
	    setHorizontalAlignment(JLabel.CENTER);        
        parentFrame = pf;
        setBounds(getVisibleRect());
        setVisible(true);

    } 
    public void setMoveConditions(int x, int y)
    {
        curX = x; curY = y;
	    setBounds(curX, curY, width, height);
        
    }
}
