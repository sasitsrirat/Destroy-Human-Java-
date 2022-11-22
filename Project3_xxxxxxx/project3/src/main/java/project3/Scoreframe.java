package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Scoreframe extends JFrame {
    private String pathInput = "Project3_xxxxxxx/project3/src/main/java/project3/score.txt";
    protected JPanel ScorePanel;
    protected JLabel contentPanel;

    // JPanel credit = new JPanel();
    // constructor
    public Scoreframe() throws FileNotFoundException {
        String imagepath = "Project3_xxxxxxx/project3/src/pictures/";
        setTitle("Score");
        setBounds(300, 200, 1366, 768);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ScorePanel = new JPanel();
        // JFrame frame = new JFrame();
        ScorePanel.setBounds(50, 100, 1366, 768);
        ScorePanel.setLayout(null); // set layout
        setContentPane(ScorePanel);

        ImageIcon imageIcon = new ImageIcon(imagepath + "inkpendude-portal-storm.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        contentPanel = new JLabel();
        setContentPane(contentPanel = new JLabel());
        contentPanel.setIcon(imageIcon);
        setContentPane(contentPanel);

        File file = new File(pathInput);
        FileReader fr = new FileReader(file);
        String Line;

        JPanel panel = new JPanel();
        {
            panel.setBounds(230, 0, 900, 766); // Size of JPanel
            panel.setBackground(new Color(0, 0, 0, 150)); // RGBA 255,255,255,255 for check limit of size
            // panel.setLayout(new GridLayout(10, 1, 20, 10));
            panel.revalidate();
            panel.repaint();
            contentPanel.add(panel);

            // best score in games
            JLabel detail = new JLabel("SCORE");
            detail.setForeground(new Color(255, 255, 255));
            detail.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 40));
            panel.add(detail);
        }

        JPanel panel_2 = new JPanel();
        {
            panel_2.setBounds(230, 100, 900, 600); // Size of JPanel
            panel_2.setBackground(new Color(100, 100, 0, 150)); // RGBA 255,255,255,255 for check limit of size
            panel_2.setLayout(new GridLayout(10, 1, 20, 10));
            panel_2.revalidate();
            panel_2.repaint();
            contentPanel.add(panel_2);
            try (BufferedReader br = new BufferedReader(fr)) {
                while ((Line = br.readLine()) != null) {
                    JLabel lblNewLabel_1 = new JLabel(Line);
                    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
                    lblNewLabel_1.setForeground(new Color(255, 255, 255));
                    // lblNewLabel_1.setLayout(new GridLayout(10, 1, 20, 10));
                    panel_2.add(lblNewLabel_1);
                    lblNewLabel_1.repaint();
                    lblNewLabel_1.validate();
                    System.out.println(Line);
                }
            } catch (IOException e) {
                System.out.print(e);
            }
        }
        
        contentPanel.setVisible(true);

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