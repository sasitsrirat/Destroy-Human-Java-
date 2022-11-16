package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Creditframe extends JFrame 
{
    protected JPanel creditPanel;
    protected JLabel contentPane;
    //JPanel credit = new JPanel();
    //constructor
    public Creditframe() {
        String imagepath = "Project3_xxxxxxx/project3/src/pictures/";
        setTitle("Credit");
	    setBounds(300, 200, 1366, 768);
	    setVisible(true);
	    setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        creditPanel = new JPanel();
        //JFrame frame = new JFrame();
        creditPanel.setBounds(50,100,1366,768);
        creditPanel.setLayout(null); //set layout
        
        ImageIcon imageIcon = new ImageIcon(imagepath + "ground.jpg");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        contentPane = new JLabel();
        setContentPane(contentPane = new JLabel());
        contentPane.setIcon(imageIcon);
        setContentPane(contentPane);
         
    }
    
    
      
}