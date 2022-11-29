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
        ImageIcon imageIcon = new ImageIcon(path + "inside.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
        contentPane.setIcon(imageIcon);
        
        JButton backButton = new JButton("Back");
        {
            backButton.setBounds(frameWidth/2, 670, 100, 60);
            backButton.setUI(new StyledButtonUI());
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
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "user1.png").getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
            picLabel.setSize(300, 400);
            picLabel.setIcon(imgThisImg);

            subPanel_1.setOpaque(false);
            //subPanel_1.setBackground(new Color(71, 157, 83,40));
            subPanel_1.setBounds(0, 90, frameWidth/4, 500);

            JLabel text_1 = new JLabel("<html><font size = '6' color=white> Ravipol Chayeraksa</font></html>");
            JLabel text_1ID = new JLabel ("<html><font size='16' color=white> 6413XXX</font></html>");

            subPanel_1.add(picLabel);
            subPanel_1.add(text_1);
            subPanel_1.add(text_1ID);
            contentPane.add(subPanel_1);

            validate();
            repaint();
        }
        subPanel_2 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "user2.png").getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
            picLabel.setSize(300, 400);
            picLabel.setIcon(imgThisImg);

            subPanel_2.setOpaque(false);
            //subPanel_2.setBackground(new Color(165, 157, 83,40));
            subPanel_2.setBounds(333,90, frameWidth/4, 500);
 
            JLabel text_2 = new JLabel("<html><font size = '6' color=white> Watcharsak Prommanee</font></html>");//Watcharsak Prommanee
            JLabel text_2ID = new JLabel ("<html><font size='16' color=white> 6413XXX</font> ");
 
            subPanel_2.add(picLabel);
            subPanel_2.add(text_2);
            subPanel_2.add(text_2ID);
            contentPane.add(subPanel_2);

            validate();
            repaint();
        }
        subPanel_3 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "user3.png").getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
            picLabel.setSize(300, 400);
            picLabel.setIcon(imgThisImg);

            subPanel_3.setOpaque(false);
            //subPanel_3.setBackground(new Color(165, 157, 208,40));
            subPanel_3.setBounds(666, 90, frameWidth/4, 500);
 
            JLabel text_3 = new JLabel("<html><font size = '6' color=white>    Sasit Sriratxx        </font></html>");//Sasit Srirat
            JLabel text_3ID = new JLabel ("<html><font size='16' color=white>   6413XXX </font> ");
 
            subPanel_3.add(picLabel);
            subPanel_3.add(text_3);
            subPanel_3.add(text_3ID);
            contentPane.add(subPanel_3);

            validate();
            repaint();
        }
        subPanel_4 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "user4.png").getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
            picLabel.setSize(300, 400);
            picLabel.setIcon(imgThisImg);

            subPanel_4.setOpaque(false);
            //subPanel_4.setBackground(new Color(218, 157, 138,40));
            subPanel_4.setBounds(1000, 90, 360, 500);
   
            JLabel text_4 = new JLabel("<html><font size = '6' color=white> Kawin Kengkate      </font></html>");//Kawin Kengkate
            JLabel text_4ID = new JLabel ("<html><font size='16' color=white> 6413XXX</font> ");
 
            subPanel_4.add(picLabel);
            subPanel_4.add(text_4);
            subPanel_4.add(text_4ID);
            contentPane.add(subPanel_4);

            validate();
            repaint();
        }

        MainPanel = new JPanel(); // black background with transparent
        {
            MainPanel.setBounds(0, 0, 1366,700);
            MainPanel.setBackground(new Color(0, 10, 10, 150));
            contentPane.add(MainPanel);
            validate();
 
        }

    }
}