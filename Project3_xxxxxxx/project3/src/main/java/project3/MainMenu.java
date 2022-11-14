package project3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.*;

//Class for design Button like CSS
class StyledButtonUI extends BasicButtonUI {
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground(Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
        g.setColor(c.getBackground());
        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
    }
}

public class MainMenu extends JFrame {
    private static int frameWidth = 1366, frameHeight = 768; // Don't Change it.
    protected Stageframe sframe;
    private JLabel contentPane;
    protected Optionframe oframe;
    protected Tutorialframe tframe;
    protected Creditframe cframe;
    protected Sound mainmenuSound;

    public MainMenu() {
        String imagepath = "project3/Project3_xxxxxxx/project3/src/pictures/";
        String soundpath = "project3/Project3_xxxxxxx/project3/src/sounds/";

        // set background music
        mainmenuSound = new Sound(soundpath + "BossTime.wav");
       // mainmenuSound.playLoop(); // Off-On Music

        setType(Type.POPUP);
        setTitle("Menu");
        setBounds(50, 50, frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // set background gif
        ImageIcon imageIcon = new ImageIcon(imagepath + "roboyscofi.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT)); // size of background
        contentPane = new JLabel();
        setContentPane(contentPane = new JLabel());
        contentPane.setIcon(imageIcon);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton playButton = new JButton("PLAY");
        {
            playButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            playButton.setBackground(new Color(222, 0, 62));
            playButton.setForeground(Color.white);
            // customize the button with your own look
            playButton.setUI(new StyledButtonUI());
            playButton.setForeground(new Color(255, 255, 255));
            // playButton.setBounds(100, 100, 200, 50);
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (sframe == null)
                        sframe = new Stageframe();
                    else
                        sframe.setVisible(true);
                }
            });
        }
        JButton optionButton = new JButton("OPTION");
        {
            optionButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            optionButton.setBackground(new Color(222, 0, 62));
            optionButton.setForeground(Color.white);
            // customize the button with your own look
            optionButton.setUI(new StyledButtonUI());
            optionButton.setForeground(new Color(255, 255, 255));
            // optionButton.setBounds(608, 175, 150, 50);
            optionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (oframe == null)
                        oframe = new Optionframe(mainmenuSound, imagepath);
                    else
                        oframe.setVisible(true);
                }
            });
        }
        JButton tutorialButton = new JButton("TUTORIAL");
        {
            tutorialButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            tutorialButton.setBackground(new Color(222, 0, 62));
            tutorialButton.setForeground(Color.white);
            // customize the button with your own look
            tutorialButton.setUI(new StyledButtonUI());
            tutorialButton.setForeground(new Color(255, 255, 255));
            // tutorialButton.setBounds(608, 250, 150, 50);
            tutorialButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (tframe == null)
                        tframe = new Tutorialframe();
                    else
                        tframe.setVisible(true);
                }
            });
        }
        JButton creditButton = new JButton("CREDIT");
        {
            creditButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            creditButton.setBackground(new Color(222, 0, 62));
            creditButton.setForeground(Color.white);
            // customize the button with your own look
            creditButton.setUI(new StyledButtonUI());
            creditButton.setForeground(new Color(255, 255, 255));
            // creditButton.setBounds(608, 325, 150, 50);
            creditButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (cframe == null)
                        cframe = new Creditframe();
                    else
                        cframe.setVisible(true);
                }
            });
        }
        JButton quitButton = new JButton("QUIT");
        {
            quitButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            quitButton.setBackground(new Color(222, 0, 62));
            quitButton.setForeground(Color.white);
            quitButton.setSize(100, 200);
            // customize the button with your own look
            quitButton.setUI(new StyledButtonUI());
            quitButton.setForeground(new Color(255, 255, 255));
            // quitButton.setBounds(608, 400, 150, 50);
            quitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JButton button = (JButton) event.getSource();
                    JDialog d = new JDialog();
                    d.setTitle("test");
                    d.setBounds(583, 459, 300, 200);
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
        }
        JPanel J2 = new JPanel();
        {
            J2.setBounds(0, 200, 400, 766); // Size of JPanel
            J2.setBackground(new Color(0, 0, 0, 0)); // RGBA 255,255,255,255 for check limit of size
            J2.setLayout(new GridLayout(10, 1, 20, 10));
            contentPane.add(J2);
            J2.add(playButton);
            J2.add(optionButton);
            J2.add(tutorialButton);
            J2.add(creditButton);
            J2.add(quitButton);
            J2.revalidate();
            J2.repaint();
        }

        JPanel J = new JPanel();
        {
            J.setSize(400, 766); // Size of JPanel
            J.setBackground(new Color(0, 0, 0, 200)); // RGBA 255,255,255,255
            contentPane.add(J);
            // Logo in main menu
            JLabel logo = new JLabel();
            logo.setIcon(new ImageIcon(new ImageIcon(imagepath + "Testlogo.png").getImage().getScaledInstance(250, 150,
                    Image.SCALE_SMOOTH)));
            J.add(logo);
        }

        /*
         * contentPane.add(playButton);
         * contentPane.add(optionButton);
         * contentPane.add(tutorialButton);
         * contentPane.add(creditButton);
         * contentPane.add(quitButton);/*
         */
        // contentPane.setFocusable(true);
        // contentPane.validate();

    }
    //intro and loading screen  
    static void displayJFrame() {
        // set the jframe title in the constructor
        JFrame jframe = new JFrame("LOADING");
        JLabel Logo = new JLabel();
        
       // Logo.setImage(Logo.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT)); // size of background

        // all the other jframe setup stuff
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setPreferredSize(new Dimension(1400, 300));
        jframe.setBackground(Color.black);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        
    }

    public static void main(String[] args) {
        //displayJFrame();
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
