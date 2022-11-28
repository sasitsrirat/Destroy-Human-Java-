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
    protected JPanel MainPanel,subPanel_1,subPanel_2,subPanel_3,subPanel_4;

    //constructor
    public Creditframe(ArrayList<Sound> mSound, ArrayList<Sound> eSound, String imagepath )//ArrayList<Sound> mSound, ArrayList<Sound> eSound, String imagepath 
    {
        musicSound = mSound;
        effectSound = eSound;
        path = imagepath;

        setTitle("Credit");
	    setBounds(50, 50, frameWidth, frameHeight);
	    setVisible(true);
        setResizable(false);
	    setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        contentPane = new JLabel();

        setContentPane(contentPane = new JLabel());
        ImageIcon imageIcon = new ImageIcon(path + "cityrobot.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
        contentPane.setIcon(imageIcon);
        
        JButton backButton = new JButton("Back");
        {
            backButton.setBounds(1000, 630, 100, 25);
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
        subPanel_1 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(path + "Music_max.png");
            picLabel.setIcon(imgThisImg);
            picLabel.setSize(300, 400);
           
            subPanel_1.setBackground(Color.BLUE);
            subPanel_1.setBounds(0, 0, frameWidth/4, 600);
            JLabel text_1 = new JLabel("Mr.Ravipol Chayeraksa");
            text_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
            text_1.setForeground(new Color(0,0,0)); 
            
            subPanel_1.add(picLabel);
            subPanel_1.add(text_1);
            contentPane.add(subPanel_1);
            validate();
            repaint();
        }
        subPanel_2 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(path + "Music_mute.png");
            picLabel.setIcon(imgThisImg);
            picLabel.setSize(300, 400);

            subPanel_2.setBackground(Color.red);
            subPanel_2.setBounds(333,0 , frameWidth/4, 600);
            //subPanel_1.setOpaque(false);
            //subPanel_2.setLayout(new GridLayout(0,0,2,2));
            JLabel text_2 = new JLabel("Mr.Watcharsak Prommanee");
            text_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
            text_2.setForeground(new Color(0,0,0)); 
            subPanel_2.add(picLabel);
            subPanel_2.add(text_2);
            contentPane.add(subPanel_2);

            validate();
            repaint();
        }
        subPanel_3 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(path + "Music_mute.png");
            picLabel.setIcon(imgThisImg);
            picLabel.setSize(300, 400);

            subPanel_3.setBackground(Color.green);
            subPanel_3.setBounds(666, 0, frameWidth/4, 600);
            //subPanel_1.setOpaque(false);
            //subPanel_3.setLayout(new GridLayout(0,4,2,2));
            JLabel text_3 = new JLabel("Mr.Sasit Srirat");
            text_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
            text_3.setForeground(new Color(0,0,0)); 
            subPanel_3.add(picLabel);
            subPanel_3.add(text_3);
            contentPane.add(subPanel_3);
            validate();
            repaint();
        }
        subPanel_4 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(path + "Kawin_mute.png");
            picLabel.setIcon(imgThisImg);
            picLabel.setSize(300, 400);

            subPanel_4.setBackground(Color.CYAN);
            subPanel_4.setBounds(1000, 0, 360, 600);
            //subPanel_1.setOpaque(false);
            //subPanel_4.setLayout(new GridLayout(0,4,2,2));
            JLabel text_4 = new JLabel("Mr.Kawin Kengkate");
            text_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
            text_4.setForeground(new Color(0,0,0)); 
            subPanel_4.add(picLabel);
            subPanel_4.add(text_4);
            contentPane.add(subPanel_4);

            validate();
            repaint();
        }

        MainPanel = new JPanel(); // black background
        {
            MainPanel.setBounds(0, 0, 1333, 768);
            MainPanel.setBackground(new Color(0, 10, 10, 150));
            contentPane.add(MainPanel);
        }

    }
}