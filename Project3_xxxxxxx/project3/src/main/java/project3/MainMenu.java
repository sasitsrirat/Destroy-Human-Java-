package project3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    private int frameWidth = 1366, frameHeight = 768; // Don't Change it.
    private JLabel contentPane;

    Optionframe oframe;
    Tutorialframe tframe;
    Creditframe cframe;

    public MainMenu() {
        String path = "Project3_xxxxxxx/project3/src/pictures/";

        setType(Type.POPUP);
        setBounds(50, 50, frameWidth, frameHeight);
        setTitle("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // set background
        contentPane = new JLabel();
        setContentPane(contentPane = new JLabel());
        MyImageIcon background = new MyImageIcon(path + "8-Bit-Backgrounds.jpg");
        MyImageIcon logo = new MyImageIcon(path + "Testlogo.png");
        contentPane.setIcon(background.resize(frameWidth, frameHeight));
        // contentPane.setIcon( logo.resize(200, 100) );
        contentPane.setLayout(null);

        setContentPane(contentPane);

        JButton playButton = new JButton("Play");
        playButton.setForeground(new Color(255, 255, 255));
        playButton.setBounds(325, 100, 150, 50);
        JButton optionButton = new JButton("Option");
        optionButton.setForeground(new Color(255, 255, 255));
        optionButton.setBounds(325, 175, 150, 50);
        optionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (oframe == null)
                    oframe = new Optionframe();
                else
                    oframe.setVisible(true);
            }
        });
        JButton tutorialButton = new JButton("Tutorial");
        tutorialButton.setForeground(new Color(255, 255, 255));
        tutorialButton.setBounds(325, 250, 150, 50);
        tutorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (tframe == null)
                    tframe = new Tutorialframe();
                else
                    tframe.setVisible(true);
            }
        });
        JButton creditButton = new JButton("Credit");
        creditButton.setForeground(new Color(255, 255, 255));
        creditButton.setBounds(325, 325, 150, 50);
        creditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (cframe == null)
                    cframe = new Creditframe();
                else
                    cframe.setVisible(true);
            }
        });
        JButton quitButton = new JButton("Quit");
        quitButton.setForeground(new Color(255, 255, 255));
        quitButton.setBounds(325, 400, 150, 50);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JButton button = (JButton) event.getSource();
                // JOptionPane.showMessageDialog(null, "Do you want Exit");
                JDialog d = new JDialog();
                d.setTitle("test");
                d.setSize(300, 100);
                JPanel p = new JPanel();
                JLabel l1 = new JLabel("Are you sure to exit game");
                JButton b1 = new JButton("Yes");
                JButton b2 = new JButton("No");
                p.setLayout(new FlowLayout());
                p.add(l1);
                p.add(b1);
                p.add(b2);
                d.getContentPane().add(p);
                d.setVisible(true);

                /* if () else exit */
            }
        });

        contentPane.add(playButton);
        contentPane.add(optionButton);
        contentPane.add(tutorialButton);
        contentPane.add(creditButton);
        contentPane.add(quitButton);
        contentPane.setFocusable(true);
        contentPane.validate();

    }

    public static void main(String[] args) {
        try {
            MainMenu frame = new MainMenu();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MyImageIcon extends ImageIcon {
    public MyImageIcon(String fname) {
        super(fname);
    }

    public MyImageIcon(Image image) {
        super(image);
    }

    public MyImageIcon resize(int width, int height) {
        Image oldimg = this.getImage();
        Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new MyImageIcon(newimg);
    }
};
