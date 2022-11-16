package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Introframe extends JFrame {

    protected JPanel loadingScreen;
    protected MyImageIcon loadingPicture;
    static JProgressBar progressBar;
 
    public Introframe() {

        loadingScreen = new JPanel(); // JPanel loadingScreen = new JPanel();
        setContentPane(loadingScreen);
        setTitle("IntroFrame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600, 600, 1366, 768);
        getContentPane().setLayout(null);
 
        // ProgressBar
        progressBar = new JProgressBar();
        progressBar.setLayout(null);
        progressBar.setBackground(new Color(50,50,59));
        progressBar.setSize(new Dimension(500,50));
        progressBar.setLocation(400,768/2);
        progressBar.setStringPainted(true);

        loadingScreen.setBackground(Color.GRAY);
        loadingScreen.add(progressBar);
        loadingScreen.setVisible(true);
        startProgress();
        //MainMenu frame = new MainMenu();
        //frame.setVisible(true);

    }
  
    public static void startProgress() {

        Runnable runnable = new Runnable() {

            public void run() {

                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);

                    if(i==100)
                    {
                        Introframe introframe = new Introframe();
                        introframe.dispose();
                    }
                }
            }
        };
        new Thread(runnable).start();

    }
    
}
