package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Creditframe extends JFrame 
{
    protected ArrayList<Sound> musicSound;
    protected ArrayList<Sound> effectSound;
    protected String path;
    protected JPanel creditPanel;
    protected JLabel contentPane;
    protected int frameWidth = 1366;
    protected int frameHeight = 768;
    protected JPanel MainPanel;

    //constructor
    public Creditframe(ArrayList<Sound> mSound, ArrayList<Sound> eSound, String imagepath) {
        musicSound = mSound;
        effectSound = eSound;
        path = imagepath;

        setTitle("Credit");
	    setBounds(50, 50, frameWidth, frameHeight);
	    setVisible(true);
        setResizable(false);
	    setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );

        setContentPane(contentPane = new JLabel());
        ImageIcon imageIcon = new ImageIcon(path + "cityrobot.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
        
        creditPanel = new JPanel();
        //JFrame frame = new JFrame();
        
        JPanel panel = new JPanel();
        {
            JLabel text_1 = new JLabel("Credit");
            text_1.setText("sasit srirat");
            JLabel text_2 = new JLabel("MR.XXAABB XXAABB 1234556");
            text_2.setFont(new Font("Charter", Font.BOLD, 30));
            text_2.setBounds(80, 40, 700, 30);
            text_2.setForeground(Color.white);
            contentPane.add(text_1);
            contentPane.add(text_2);
            validate();

        }
        JPanel MainPanel = new JPanel(); // black background
        {
            MainPanel.setBounds(0, 0, 800, 768);
            MainPanel.setBackground(new Color(0, 0, 0, 150));
        }
        JButton backButton = new JButton("Back");
        {
            backButton.setBounds(1000, 630, 100, 50);
            contentPane.add(backButton);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String button = event.getActionCommand();
                    if (button.equals("Back")) {
                        dispose();
                        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    }
                }
            });
        }
        contentPane.setIcon(imageIcon);
        repaint(); 
    }
    
    
      
}