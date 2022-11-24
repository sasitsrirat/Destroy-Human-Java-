package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Scoreframe extends JFrame {
    private String pathInput = "Project3_xxxxxxx/project3/src/score.txt";
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

        ImageIcon imageIcon = new ImageIcon(imagepath + "engine.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT));
        contentPanel = new JLabel();
        setContentPane(contentPanel = new JLabel());
        contentPanel.setIcon(imageIcon);
        setContentPane(contentPanel);

        File file = new File(pathInput);
        FileReader fr = new FileReader(file);
        String Line;

        JPanel panel_2 = new JPanel();
        {
            panel_2.setBounds(230, 100, 900, 600); // Size of JPanel
            panel_2.setBackground(new Color(100, 100, 10, 150)); // RGBA 255,255,255,255 for check limit of size
            panel_2.setLayout(new GridLayout(10, 3, 20, 10));

            JLabel Bar = new JLabel("No.\t\t\t Name\t Level");
            Bar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            Bar.setForeground(new Color(255, 255, 255));

            panel_2.add(Bar);
            contentPanel.add(panel_2);

            try (BufferedReader br = new BufferedReader(fr)) 
            {
                
                while ((Line = br.readLine()) != null) {
                    
                    JLabel lblNewLabel_1 = new JLabel(Line);
                    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
                    lblNewLabel_1.setForeground(new Color(255, 255, 255));
                    //lblNewLabel_1.setLayout(new GridLayout(3, 3, 1, 1));
                    
                    panel_2.add(lblNewLabel_1);
                    revalidate();
                    System.out.println(Line);
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
/*
package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;
import java.lang.*;

class mainScore {

    public static void main (String[] args)
    {
        ArrayList<ScoreSystem> ScoreList = new ArrayList<>();
        Stream<ScoreSystem> mystream;
    
        final String File = "Project3_xxxxxxx/project3/src/score.txt";
        
        while(true)
        {
            try{
                Scanner scanner  = new Scanner(new File(File));
                while(scanner.hasNext())
                {
                    String line = scanner.nextLine();
                    String buf[] = line.split(" ");
                    ScoreSystem file = new ScoreSystem(buf[0].trim(),Integer.parseInt(buf[1].trim()));
                    ScoreList.add(file);
                }
            }catch(FileNotFoundException e)
            {
                e.printStackTrace();
                continue;
            }
        }
        System.out.printf(File, args));
        mystream = ScoreList.stream();
        mystream.filter(level -> level.getLevel() > 0).sorted(Comparator.comparing(ScoreSystem::getLevel).reversed()).forEach(name->System.out.printf("%s\tLevel: %d\n",name.getName(),name.getLevel()));
        
    }
}
class ScoreSystem implements Comparable<ScoreSystem>
{
    private String name;
    private int level;

    public ScoreSystem(String n,int l)
    {
        name = n;
        level = l;
    }
    public void setName(String n) {
        name = n;
    }
    public void setLevel(int l) {
        level = l;
    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }

    @Override
    public int compareTo(ScoreSystem other) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}

*/