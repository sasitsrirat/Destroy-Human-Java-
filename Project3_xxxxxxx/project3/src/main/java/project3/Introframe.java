package project3;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument.Content;

class Introframe extends JFrame {
    private static int frameWidth = 1366, frameHeight = 768;
    public static JPanel loadingScreen;
    protected MyImageIcon loadingPicture;
    static JProgressBar progressBar;

    public Introframe() {

        loadingScreen = new JPanel(); // JPanel loadingScreen = new JPanel();
        setContentPane(loadingScreen);
        setTitle("IntroFrame");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(50, 50, frameWidth, frameHeight);
        getContentPane().setLayout(null);

        // ProgressBar
        progressBar = new JProgressBar();
        progressBar.setLayout(null);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(0, 100, 100, 1));
        UIManager.put("progressBar.background", Color.orange);
        UIManager.put("progressBar.foreground", Color.black);
        UIManager.put("progressBar.selectionBackground", Color.red);
        UIManager.put("progressBar.selectionForeground", Color.green);
        progressBar.setSize(new Dimension(500, 50));
        progressBar.setLocation(400, 730 / 2);

        loadingScreen.setBackground(Color.GRAY);
        loadingScreen.add(progressBar);
        loadingScreen.setVisible(true);
        startProgress();
    }

    public static void startProgress() {
        loadingScreen = new JPanel();
        Runnable runnable = new Runnable() {
            public void run() {
                int i = 0;
                for (i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);

                    if (i == 100) {
                        MainMenu frame = new MainMenu();
                        frame.setVisible(true);
                        loadingScreen.setVisible(false);
 
                    }
                }
            }
        };
        new Thread(runnable).start();

    }

}
