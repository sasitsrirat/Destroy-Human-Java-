package project3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.*;

//Class for design Button like CSS
class StyledButtonUI extends BasicButtonUI 
{
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
    private int frameWidth = 1366, frameHeight = 768; // Don't Change it.
    private JLabel contentPane;
    protected Optionframe oframe;
    protected Tutorialframe tframe;
    protected Creditframe cframe;
    protected Sound mainmenuSound;


    public MainMenu() 
    {
        String imagepath = "src/pictures/";
        String soundpath = "src/sounds/";

        setType(Type.POPUP);
        setTitle("Menu");
        setBounds(50, 50, frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // set background
        contentPane = new JLabel();
        setContentPane(contentPane = new JLabel());
        MyImageIcon background = new MyImageIcon(imagepath + "8-Bit-Backgrounds.jpg");
        //MyImageIcon logo = new MyImageIcon(path + "Testlogo.png");
        contentPane.setIcon(background.resize(frameWidth, frameHeight));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        //set background music
        mainmenuSound = new Sound(soundpath + "namlie.wav");
        mainmenuSound.playLoop();

        JButton playButton = new JButton("Play");
        {
            playButton.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
            playButton.setBackground(new Color(0x2dce98));
            playButton.setForeground(Color.white);
            // customize the button with your own look
            playButton.setUI(new StyledButtonUI());
            playButton.setForeground(new Color(255, 255, 255));
            playButton.setBounds(608, 100, 150, 50);
        }
        JButton optionButton = new JButton("Option");
        {
            optionButton.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
            optionButton.setBackground(new Color(0x2dce98));
            optionButton.setForeground(Color.white);
            // customize the button with your own look
            optionButton.setUI(new StyledButtonUI());
            optionButton.setForeground(new Color(255, 255, 255));

            optionButton.setForeground(new Color(255, 255, 255));
            optionButton.setBounds(608, 175, 150, 50);
            optionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (oframe == null)
                        oframe = new Optionframe(mainmenuSound);
                    else
                        oframe.setVisible(true);
                }
            });
        }
        JButton tutorialButton = new JButton("Tutorial");
        {
            tutorialButton.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
            tutorialButton.setBackground(new Color(0x2dce98));
            tutorialButton.setForeground(Color.white);
            // customize the button with your own look
            tutorialButton.setUI(new StyledButtonUI());
            tutorialButton.setForeground(new Color(255, 255, 255));

            tutorialButton.setForeground(new Color(255, 255, 255));
            tutorialButton.setBounds(608, 250, 150, 50);
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
        JButton creditButton = new JButton("Credit");
        {
            creditButton.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
            creditButton.setBackground(new Color(0x2dce98));
            creditButton.setForeground(Color.white);
            // customize the button with your own look
            creditButton.setUI(new StyledButtonUI());
            creditButton.setForeground(new Color(255, 255, 255));

            creditButton.setForeground(new Color(255, 255, 255));
            creditButton.setBounds(608, 325, 150, 50);
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
        JButton quitButton = new JButton("Quit");
        {
            quitButton.setFont(new Font("Cascadia Code", Font.PLAIN, 14));
            quitButton.setBackground(new Color(0x2dce98));
            quitButton.setForeground(Color.white);
            // customize the button with your own look
            quitButton.setUI(new StyledButtonUI());
            quitButton.setForeground(new Color(255, 255, 255));

            quitButton.setForeground(new Color(255, 255, 255));
            quitButton.setBounds(608, 400, 150, 50);
            quitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JButton button = (JButton) event.getSource();
                    JDialog d = new JDialog();
                    d.setTitle("test");
                    d.setBounds(583,459,300,100);
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
