package project3;

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
    protected JPanel MainPanel,subPanel_1,subPanel_2,subPanel_3,subPanel_4,subPanel_5;

    //constructor
    public Creditframe(ArrayList<Sound> mSound, ArrayList<Sound> eSound, String imagepath )
    {
        musicSound = mSound;
        effectSound = eSound;
        path = imagepath;

        setTitle("Credit");
	    setBounds(50, 50, frameWidth, frameHeight);
	    setVisible(true);
        setResizable(false);
	    setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        ImageIcon img = new ImageIcon(imagepath + "people.png");
        setIconImage(img.getImage());
        contentPane = new JLabel();
        setContentPane(contentPane = new JLabel());
        ImageIcon imageIcon = new ImageIcon(path + "inside.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
        contentPane.setIcon(imageIcon);
 
        JButton backButton = new JButton("Back");
        {
            backButton.setBounds(340, 700, 750, 35);
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
       //header
       JLabel Credit = new JLabel("<html><font size = '20' color = white> DEVELOPER TEAM </font></html>");
       Credit.setFont(new Font("Tahoma", Font.PLAIN,20));
       Credit.setBounds(520, 20, 750, 100);
       contentPane.add(Credit);
       
        subPanel_1 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "music8bit.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
            picLabel.setSize(300, 400);
            picLabel.setIcon(imgThisImg);

            subPanel_1.setOpaque(false);
            subPanel_1.setBounds(0, 120, frameWidth/4, 500);

            JLabel text_1 = new JLabel("<html><font size = '6' color=white font = Skia> Ravipol Chayeraksa</font></html>");
            JLabel text_1ID = new JLabel ("<html><font size='16' color=white> 6413223</font></html>");
            text_1.setFont(new Font("Verdana", Font.PLAIN, 18));

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
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "new8bit.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
            picLabel.setSize(300, 400);
            picLabel.setIcon(imgThisImg);

            subPanel_2.setOpaque(false);
            subPanel_2.setBounds(333,120, frameWidth/4, 500);
             
            JLabel text_2 = new JLabel("<html><font size = '6' color=white> Watcharsak Prommanee</font></html>");
            JLabel text_2ID = new JLabel ("<html><font size='16' color=white> 6413110</font> ");
            text_2.setFont(new Font("Verdana", Font.PLAIN, 18));

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
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "babe8bit.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
            picLabel.setSize(300, 400);
            picLabel.setIcon(imgThisImg);
            
            subPanel_3.setOpaque(false);
            subPanel_3.setBounds(666, 120, frameWidth/4, 500);
 
            JLabel text_3 = new JLabel("<html><font size = '6' color=white>    Sasit Srirat              </font></html>");
            JLabel text_3ID = new JLabel ("<html><font size='16' color=white>   6413112 </font> ");
            text_3.setFont(new Font("Verdana", Font.PLAIN, 18));
            text_3ID.setBounds(656, 410, 360, 50);
            text_3ID.setHorizontalAlignment(JLabel.CENTER);
            subPanel_3.add(picLabel);
            subPanel_3.add(text_3);
            contentPane.add(text_3ID);
            contentPane.add(subPanel_3);

            validate();
            repaint();
        }
        subPanel_4 = new JPanel();
        {
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "kawin8bit.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
            picLabel.setSize(300, 400);
            picLabel.setIcon(imgThisImg);

            subPanel_4.setOpaque(false);
            subPanel_4.setBounds(1000, 120, 360, 500);
   
            JLabel text_4 = new JLabel("<html><font size = '6' color=white> Kawin Kengkate </font></html>");
            JLabel text_4ID = new JLabel ("<html><font size='16' color=white> 6413210</font> ");
            text_4ID.setBounds(1000, 410, 360, 50);
            text_4ID.setHorizontalAlignment(JLabel.CENTER);
            text_4.setFont(new Font("Verdana", Font.PLAIN, 18));

            subPanel_4.add(picLabel);
            subPanel_4.add(text_4);
            contentPane.add(text_4ID);
            contentPane.add(subPanel_4);

            validate();
            repaint();
        }
        subPanel_5 = new JPanel();
        {
            subPanel_5.setLayout(new GridLayout(1,3,0,2));
            JLabel picLabel = new JLabel();
            ImageIcon imgThisImg = new ImageIcon(new ImageIcon(path + "Mahidol_U8bit.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            picLabel.setSize(290, 300);
            picLabel.setIcon(imgThisImg);

            subPanel_5.setOpaque(false);
            subPanel_5.setBounds(520, 470, 290, 300);
   
            JLabel text_5 = new JLabel ("<html><font size='5' color=white>COMPUTER ENGINEERING (2564-THAI) </font> ");
            
 
            subPanel_5.add(picLabel);
            subPanel_5.add(text_5);
            contentPane.add(subPanel_5);

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