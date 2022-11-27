package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Scoreframe extends JFrame {
    private String pathInput = "Project3_xxxxxxx/project3/src/main/java/project3/info.txt";
    protected JPanel ScorePanel;
    protected JLabel contentPanel;
    protected int frameWidth = 1366;
    protected int frameHeight = 768;

    // JPanel credit = new JPanel();
    // constructor
    public Scoreframe() throws FileNotFoundException 
    {
        String imagepath = "Project3_xxxxxxx/project3/src/pictures/";
        setTitle("Score");
        setBounds(50, 50, frameWidth, frameHeight);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ScorePanel = new JPanel();
        // JFrame frame = new JFrame();
        ScorePanel.setBounds(50, 100, 1366, 768);
        ScorePanel.setLayout(null); // set layout
        setContentPane(ScorePanel);

        ImageIcon imageIcon = new ImageIcon(imagepath + "engine.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        contentPanel = new JLabel();
        setContentPane(contentPanel = new JLabel());
        contentPanel.setIcon(imageIcon);
        setContentPane(contentPanel);

        JLabel Bar = new JLabel("No.                 Name                Level                   Point");
        Bar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Bar.setForeground(new Color(255, 255, 255));
        Bar.setBounds(450, 10, 600, 150);
        contentPanel.add(Bar);

        JButton backButton = new JButton("Back");
        {
            backButton.setBounds(1000, 630, 100, 50);
            contentPanel.add(backButton);
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
        JPanel panel_2 = new JPanel();
        {
            panel_2.setBounds(230, 100, 900, 600); // Size of JPanel
            panel_2.setBackground(new Color(100, 100, 10, 150)); // RGBA 255,255,255,255 for check limit of size
            panel_2.setLayout(new FlowLayout(3,3,3));
            contentPanel.add(panel_2);

            File file = new File(pathInput);
            try (Scanner filescan = new Scanner(file))
            {
                while (filescan.hasNext()) {
                    String Line = filescan.nextLine();
                    String[] buf = Line.split(",");
                    String name = buf[0].trim();
                    int stage = Integer.parseInt(buf[1].trim().toString());
                    int score = Integer.parseInt(buf[2].trim().toString());
                    Line = " " + name+ " "+ "   " + stage +"   " + score;
                    JLabel lblNewLabel_1 = new JLabel(Line);
                    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
                    lblNewLabel_1.setForeground(new Color(255, 255, 255));   
                    //lblNewLabel_1.setBounds(400, 300, 100, 100);
                    panel_2.add(lblNewLabel_1);
                    validate();
                    repaint();
                    System.out.printf("%s \t%d \t%d \n",name,stage,score);
                }
            } catch (IOException e) {
                System.out.print(e);
            }

        }

        JPanel panel = new JPanel();
        {
            panel.setBounds(230, 10, 900, 766); // Size of JPanel
            panel.setBackground(new Color(0, 0, 0, 150)); // RGBA 255,255,255,255 for check limit of size
            // panel.setLayout(new GridLayout(2, 2, 20, 10));
            panel.revalidate();
            panel.repaint();
            contentPanel.add(panel);

            // best score in games
            JLabel detail = new JLabel("SCORE");
            detail.setForeground(new Color(255, 255, 255));
            detail.setFont(new Font("Copperplate Gothic BOLD", Font.CENTER_BASELINE, 40));

            panel.add(detail);
            revalidate();
            repaint();
        }
 
        //contentPanel.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            Scoreframe a = new Scoreframe();
            a.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
