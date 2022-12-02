package project3;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileNotFoundException;
 

public class Scoreframe extends JFrame {
    protected JPanel ScorePanel;
    protected JLabel contentPanel;
    protected int frameWidth = 1366;
    protected int frameHeight = 768;
    protected Filemanage scan;
    protected MainMenu main;
    protected ArrayList<PlayerInfo> playerArraylist;

    // constructor
    public Scoreframe(MainMenu mainMenu,String imagepath,String path) throws FileNotFoundException {
        this.main = mainMenu;
        scan = main.getfilemanage();
        playerArraylist = main.getplayerarraylist();
        setTitle("Score");
        setBounds(50, 50, frameWidth, frameHeight);
        setVisible(true);
        setResizable(false);
        ImageIcon img = new ImageIcon(imagepath + "trophy.png");
        setIconImage(img.getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ScorePanel = new JPanel();
        ScorePanel.setBounds(50, 100, 1366, 768);
        ScorePanel.setLayout(null); // set layout
        setContentPane(ScorePanel);

        ImageIcon imageIcon = new ImageIcon(imagepath + "engine.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        contentPanel = new JLabel();
        setContentPane(contentPanel = new JLabel());
        contentPanel.setIcon(imageIcon);
        setContentPane(contentPanel);

        // ScrollPane for Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(frameHeight / 2, 150, 400, 400);
        getContentPane().add(scrollPane);
        scrollPane.setSize(600, 400);

        // Table
        JTable table = new JTable();
        scrollPane.setViewportView(table);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        table.setRowHeight(50);
        table.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        table.setEnabled(false);
        
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addColumn("No");
            model.addColumn("Name");
            model.addColumn("Stage");
            model.addColumn("Score");

            // set data to jtable model
            int i = 0;
            Collections.sort(playerArraylist);
            for (PlayerInfo p : playerArraylist) {
                if (playerArraylist.get(i).getdisplay()) {
                    int score1 = p.getscore(1);
                    int score2 = p.getscore(2);
                    int score3 = p.getscore(3);
                    int score4 = p.getscore(4);
                    int score5 = p.getscore(5);
                    int sum = score1 + score2 + score3 + score4 + score5;
                    model.addRow(new Object[i]);
                    model.setValueAt(i + 1, i, 0); // Number
                    model.setValueAt(p.getname(), i, 1); // Name
                    model.setValueAt(p.getstage(), i, 2); // stage
                    model.setValueAt(sum, i, 3); // sum of score
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            panel_2.setLayout(new FlowLayout(3, 3, 3));
            contentPanel.add(panel_2);
        }

        JPanel panel = new JPanel();
        {
            panel.setBounds(230, 10, 900, 766); // Size of JPanel
            panel.setBackground(new Color(0, 0, 0, 150)); // RGBA 255,255,255,255 for check limit of size
            panel.revalidate();
            panel.repaint();
            contentPanel.add(panel);

            // header score
            JLabel detail = new JLabel("SCORE");
            detail.setForeground(new Color(255, 255, 255));
            detail.setFont(new Font("Copperplate Gothic BOLD", Font.CENTER_BASELINE, 40));

            panel.add(detail);
            revalidate();
            repaint();
        }
        contentPanel.setVisible(true);
    }
}