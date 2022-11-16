package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Scoreframe extends JFrame 
{
    protected JPanel creditPanel;
    protected JLabel contentPane;
    //JPanel credit = new JPanel();
    //constructor
    public Scoreframe() {
        String imagepath = "Project3_xxxxxxx/project3/src/pictures/";
        setTitle("Score");
	    setBounds(300, 200, 1366, 768);
	    setVisible(true);
	    setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        creditPanel = new JPanel();
        //JFrame frame = new JFrame();
        creditPanel.setBounds(50,100,1366,768);
        creditPanel.setLayout(null); //set layout
        
        ImageIcon imageIcon = new ImageIcon(imagepath + "alphacorders.jpg");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        contentPane = new JLabel();
        setContentPane(contentPane = new JLabel());
        contentPane.setIcon(imageIcon);
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        {
            panel.setBounds(0, 200, 400, 766); // Size of JPanel
            panel.setBackground(new Color(0, 0, 0, 0)); // RGBA 255,255,255,255 for check limit of size
            panel.setLayout(new GridLayout(10, 1, 20, 10));
            contentPane.add(panel);
            panel.revalidate();
            panel.repaint();
            
            //best score in games 
            JLabel detail = new JLabel("SCORE");
            
            
            
        }
        
        
         
    }
    
    
      
}