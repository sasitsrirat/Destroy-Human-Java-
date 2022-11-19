package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Scoreframe extends JFrame 
{
    private String pathInput = "score.txt";
    protected JPanel ScorePanel;
    protected JLabel contentPanel;
    //JPanel credit = new JPanel();
    //constructor
    public Scoreframe() throws FileNotFoundException 
    {
        String imagepath = "Project3_xxxxxxx/project3/src/pictures/";
        setTitle("Score");
	    setBounds(300, 200, 1366, 768);
	    setVisible(true);
	    setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        ScorePanel = new JPanel();
        //JFrame frame = new JFrame();
        ScorePanel.setBounds(50,100,1366,768);
        ScorePanel.setLayout(null); //set layout
        setContentPane(ScorePanel);
        
        ImageIcon imageIcon = new ImageIcon(imagepath + "warzone-scene.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        contentPanel = new JLabel();
        setContentPane(contentPanel = new JLabel());
        contentPanel.setIcon(imageIcon);
        setContentPane(contentPanel);
        
        JPanel panel = new JPanel();
        {
            panel.setBounds(0, 200, 400, 766); // Size of JPanel
            panel.setBackground(new Color(0, 0, 0, 188)); // RGBA 255,255,255,255 for check limit of size
            panel.setLayout(new GridLayout(10, 1, 20, 10));
            panel.revalidate();
            panel.repaint();
            contentPanel.add(panel);
            
            //best score in games 
            JLabel detail = new JLabel("SCORE");
            contentPanel.add(detail);
        }
        File file = new File(pathInput);
        FileReader fr = new FileReader(file);
        String Line;
        try  (BufferedReader br = new BufferedReader(fr))
        {
            while((Line = br.readLine())!= null)
            {
                JLabel lblNewLabel_1 = new JLabel(Line);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1.setBounds(181, 224, 134, 43);
				contentPanel.add(lblNewLabel_1);
			    System.out.println(Line);
			}
        }catch(IOException e)
        {
            System.out.print(e);
        }
        contentPanel.setVisible(true);

        

        
    }
}