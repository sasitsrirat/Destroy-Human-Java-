package project3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.*;

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
    private final int frameWidth = 1366, frameHeight = 768; // Don't Change it.
    protected Stageframe sframe;
    private JLabel contentPane; // JLabel contentPane = new JLabel;
    protected Optionframe oframe;
    protected Tutorialframe tframe;
    protected Creditframe cframe;
    protected ArrayList<Sound> musicSound = new ArrayList<Sound>(), effectSound = new ArrayList<Sound>();
    protected Scoreframe scoreframe;
    protected Storyframe strframe;
    public String imagepath,soundpath;
    protected ArrayList<PlayerInfo> playerArraylist;

    public MainMenu() {
        imagepath = "project3/Project3_xxxxxxx/project3/src/pictures/";//"src/pictures/"; // "project3/Project3_xxxxxxx/project3/src/pictures/"
        soundpath = "project3/Project3_xxxxxxx/project3/src/sounds/";

        // set background music
        musicSound.add(new Sound(soundpath + "BossTime.wav", "mainmenuBG"));
        musicSound.add(new Sound(soundpath + "namlie.wav", "gereBG"));
        musicSound.add(new Sound(soundpath + "Star_Wars.wav", "storyBG"));
        for (Sound i : musicSound) {
            if ("mainmenuBG".equals(i.getName())) {
                i.playLoop();
            }
        }
        effectSound.add(new Sound(soundpath + "click.wav", "clickEF"));
        effectSound.add(new Sound(soundpath + "Laser.wav", "robotnormalattackEF"));
        effectSound.add(new Sound(soundpath + "lightening.wav", "robotskill1EF"));
        effectSound.add(new Sound(soundpath + "heal_robot.wav", "robotskill2EF"));
        effectSound.add(new Sound(soundpath + "bombef.wav", "robotskill3EF"));
        effectSound.add(new Sound(soundpath + "punch.wav", "humannormalattackEF"));
        effectSound.add(new Sound(soundpath + "victoryEF.wav", "victoryEF"));
        effectSound.add(new Sound(soundpath + "defeatEF.wav", "defeatEF"));
        // effectSound.add(new Sound(soundpath + "humangunfire.wav", "humanskill1EF"));

        setType(Type.POPUP);
        setTitle("Menu");
        setResizable(false);
        setBounds(50, 50, frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // set background gif
        ImageIcon imageIcon = new ImageIcon(imagepath + "roboyscofi.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT)); // size
        // of
        // background
        contentPane = new JLabel();
        contentPane.setIcon(imageIcon);
        contentPane.setLayout(null);
        setContentPane(contentPane);
        MainMenu main = this;

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
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                    for (Sound i : musicSound) {
                        if ("mainmenuBG".equals(i.getName())) {
                            i.stop();
                        }
                    }
                    /*sframe = new Stageframe(imagepath, musicSound, effectSound, main, 1); // play for first time stage 1
                    setTitle("Stage");

                    setContentPane(sframe.getContentpane());*/
                    /*strframe = new Storyframe(1);
                    setContentPane(sframe.getContentpane());*/
                    Storyframe strframe = new Storyframe(1, imagepath, musicSound, effectSound, main);

                    setTitle("STORY");
                    setContentPane(strframe.getContentPane());
                    validate();
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
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                    if (oframe == null)
                        oframe = new Optionframe(musicSound, effectSound, imagepath, main);
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
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                    if (tframe == null)
                        tframe = new Tutorialframe();
                    else
                        tframe.setVisible(true);
                }
            });
        }
        JButton scoreButton = new JButton("SCORE");
        {
            scoreButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            scoreButton.setBackground(new Color(222, 0, 62));
            scoreButton.setForeground(Color.white);
            // customize the button with your own look
            scoreButton.setUI(new StyledButtonUI());
            scoreButton.setForeground(new Color(255, 255, 255));
            // tutorialButton.setBounds(608, 250, 150, 50);
            scoreButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                    if (scoreframe == null)
                        try {
                            scoreframe = new Scoreframe();
                        } catch (FileNotFoundException e) {
                        }
                    else
                        scoreframe.setVisible(true);
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
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                    if (cframe == null){
                        //cframe = new Creditframe();
                    }
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
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
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
                    System.exit(0);
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
            J2.add(scoreButton);
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
        contentPane.setFocusable(true);
        validate();

    }

    public JLabel getPane() {
        return contentPane;
    }

    public void setcutscene(boolean a) {
        cutscene = a;
    }

    public void setsave(boolean a) {
        save = a;
    }

    public void setscore(boolean a) {
        showscore = a;
    }

    public static void main(String[] args) {
        // displayJFrame();
        try {
            Introframe introframe = new Introframe();
            introframe.setVisible(true);
            // MainMenu frame = new MainMenu();
            // frame.setVisible(true);
            // Stageframe stageframe = new Stageframe("src/pictures", "src/sounds",1);
        } catch (Exception e) {
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

class Mytextlabel extends JLabel {
    String name;
    MainMenu main;

    public Mytextlabel(MainMenu main,ArrayList<PlayerInfo> player ){
        this.main = main;

        setVisible(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        this.addcomponent();
        
    }
    public void addcomponent(){
        JTextField tf = new JTextField();
        tf.setFont(new Font("Comic Sans MS", Font.BOLD+Font.ITALIC, 20));

        JDialog d = new JDialog(main, "User"); // this refer to frame

        //Radiobutton
        // maybe arraylist
        JRadioButton r1=new JRadioButton("Stage 1");    
        JRadioButton r2=new JRadioButton("Stage 2");
        JRadioButton r3=new JRadioButton("Stage 3");    
        JRadioButton r4=new JRadioButton("Stage 4"); 
        JRadioButton r5=new JRadioButton("Stage 4");   

        ButtonGroup bg=new ButtonGroup();

        bg.add(r1); bg.add(r2); bg.add(r3); bg.add(r4); bg.add(r5);
        
       //d.add(tl);
        //d.add(bg);
        d.setSize(500, 300);
        d.setBounds(250,250,500,200);
        d.setVisible(true);
        d.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                System.out.printf("t >>  %c  (%s) \n", e.getKeyChar(), e.getKeyText(e.getKeyCode()));
                //String current = tf.getText();
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    //tf.setText("");
                    //tf.setText("");
                }

            }

            public void keyReleased(KeyEvent e) {
            }

        });
        JButton summitButton = new JButton("submit");
        {
            summitButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            summitButton.setBackground(new Color(222, 0, 62));
            summitButton.setForeground(Color.white);
            // customize the button with your own look
            summitButton.setUI(new StyledButtonUI());
            summitButton.setForeground(new Color(255, 255, 255));
            // playButton.setBounds(100, 100, 200, 50);
            summitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    /*for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                    for (Sound i : musicSound) {
                        if ("mainmenuBG".equals(i.getName())) {
                            i.stop();
                        }
                    }
                    */

                    // submit name and process to check that player have ever play

                    
                }
            });
        }
        
    }
}

