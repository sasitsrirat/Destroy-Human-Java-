package project3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
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

public class MainMenu extends JFrame implements WindowListener {
    private final int frameWidth = 1366, frameHeight = 768; // Don't Change it.
    protected Stageframe sframe;
    private JLabel contentPane; // JLabel contentPane = new JLabel;
    protected Optionframe oframe;
    protected Tutorialframe tframe;
    protected Creditframe cframe;
    protected ArrayList<Sound> musicSound = new ArrayList<Sound>(), effectSound = new ArrayList<Sound>();
    protected Scoreframe scoreframe;
    protected Storyframe strframe;
    protected boolean cutscene = true, save = true, showscore = true;
    public String imagepath, soundpath, path;
    protected ArrayList<PlayerInfo> playerArraylist = new ArrayList<PlayerInfo>();
    protected PlayerInfo currentplayer;
    protected Filemanage scan;
    protected String fileinfo = "info.txt";

    protected MainMenu main = this;

    public MainMenu() {
        imagepath = "Project3_xxxxxxx/project3/src/pictures/";//"project3/Project3_xxxxxxx/project3/src/pictures/"
        soundpath = "Project3_xxxxxxx/project3/src/sounds/"; // src/sounds/
        path = "Project3_xxxxxxx/project3/src/main/java/project3/";// "src/main/java/project3/";
                                                                            

        // set background music
        musicSound.add(new Sound(soundpath + "BossTime.wav", "mainmenuBG"));
        musicSound.add(new Sound(soundpath + "stageBG.wav", "stageBG"));
        musicSound.add(new Sound(soundpath + "namlie.wav", "gereBG"));
        musicSound.add(new Sound(soundpath + "Star_Wars.wav", "story1BG"));
        musicSound.add(new Sound(soundpath + "story-2.wav", "story2BG"));
        musicSound.add(new Sound(soundpath + "story-3.wav", "story3BG"));
        musicSound.add(new Sound(soundpath + "story-4.wav", "story4BG"));
        musicSound.add(new Sound(soundpath + "story-5.wav", "story5BG"));
        musicSound.add(new Sound(soundpath + "end_theme.wav", "endBG"));
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
        effectSound.add(new Sound(soundpath + "gunEF.wav", "humangunEF"));
        effectSound.add(new Sound(soundpath + "victoryEF.wav", "victoryEF"));
        effectSound.add(new Sound(soundpath + "defeatEF.wav", "defeatEF"));
        effectSound.add(new Sound(soundpath + "restEF.wav", "restEF"));

        setType(Type.POPUP);
        setTitle("Menu");
        setResizable(false);
        setBounds(50, 50, frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        addWindowListener(this);
        // set background gif
        ImageIcon imageIcon = new ImageIcon(imagepath + "roboyscofi.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
        contentPane = new JLabel();
        contentPane.setIcon(imageIcon);
        contentPane.setLayout(null);
        setContentPane(contentPane);
        MainMenu main = this;
        scan = new Filemanage(path, fileinfo);
        scan.filescan(playerArraylist);

        JButton playButton = new JButton("PLAY");
        {
            playButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            playButton.setBackground(new Color(222, 0, 62));
            playButton.setForeground(Color.white);
            playButton.setUI(new StyledButtonUI());
            playButton.setForeground(new Color(255, 255, 255));
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                    JDialog d = new JDialog(main, "User");
                    d.setSize(500, 300);
                    d.setBounds(250, 250, 500, 200);
                    d.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent e) {
                            System.out.printf("t >>  %c  (%s) \n", e.getKeyChar(), e.getKeyText(e.getKeyCode()));
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                            if (e.getKeyCode() == 10) {
                                d.dispose();
                            }
                        }

                        public void keyReleased(KeyEvent e) {
                        }

                    });

                    Mytextpanel tl = new Mytextpanel(d, main, playerArraylist);
                    d.add(tl);
                    d.setVisible(true);
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
            scoreButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
                    openscore();
                    /*
                     * if (scoreframe == null)
                     * try {
                     * scoreframe = new Scoreframe();
                     * } catch (FileNotFoundException e) {
                     * }
                     * else
                     * scoreframe.setVisible(true);
                     */
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
                    if (cframe == null)
                        cframe = new Creditframe(effectSound, effectSound, imagepath);
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
            quitButton.setUI(new StyledButtonUI());
            quitButton.setForeground(new Color(255, 255, 255));
            quitButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent event) {
                    JDialog d = new JDialog();
                    {
                        JButton b1 = new JButton("Yes");
                        JButton b2 = new JButton("No");
                        JLabel l1 = new JLabel("Are you sure to exit game ???? ");
                        // JLabel l2 = new JLabel("Because this game is a fun game. It is also a game
                        // that allows\nyou to develop skills such as logic, \nproblem solving and have
                        // fun.\n If you quit this game, you'll probably regret it all day.");
                        d.setTitle("Exit");
                        d.setBounds(583, 459, 240, 100);
                        d.setLayout(new FlowLayout());
                        d.add(l1);
                        // d.add(l2);
                        d.add(b1);
                        d.add(b2);

                        // d.add(b2);

                        // save to file when quit
                        for (PlayerInfo p : playerArraylist) {
                            p.settotalscore();
                        }
                        Collections.sort(playerArraylist);
                        scan.filewrite(playerArraylist);

                        b1.addActionListener(e -> System.exit(0));
                        b2.addActionListener(e -> d.dispose());
                        d.getContentPane();
                        d.setVisible(true);
                    }
                    for (Sound i : effectSound) {
                        if ("clickEF".equals(i.getName())) {
                            i.playOnce();
                        }
                    }
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

    public void setCurrentplayer(PlayerInfo p) {
        currentplayer = p;
    }

    public PlayerInfo getCurrentplayer() {
        return currentplayer;
    }

    public ArrayList<PlayerInfo> getplayerarraylist() {
        return playerArraylist;
    }

    public Filemanage getfilemanage() {
        return scan;
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

    public void openscore() {
        if (scoreframe == null)
            try {
                scoreframe = new Scoreframe(main);
            } catch (FileNotFoundException e) {
            }
        else
            scoreframe.setVisible(true);
    }

    public void startstory(int a) {
        for (Sound i : musicSound) {
            if ("mainmenuBG".equals(i.getName()))
                i.stop();
        }
        strframe = new Storyframe(a, imagepath, musicSound, effectSound, main, frameWidth, frameHeight);
        setContentPane(strframe.getContentpane());
    }

    public void startstage(int a) {
        for (Sound i : musicSound) {
            if ("mainmenuBG".equals(i.getName()))
                i.stop();
        }
        sframe = new Stageframe(imagepath, musicSound, effectSound, main, a);
        setTitle("Stage");
        setContentPane(sframe.getContentpane());
        validate();
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) // or used window close // closing
    {
        for (PlayerInfo p : playerArraylist) {
            p.settotalscore();
        }
        Collections.sort(playerArraylist);
        /*
         * for(PlayerInfo p : playerArraylist){
         * System.out.println(p);
         * }
         */
        scan.filewrite(playerArraylist);
    }

    @Override
    public void windowClosed(WindowEvent e) // window close
    {
    }

    public static void main(String[] args) {
        try {
            Introframe introframe = new Introframe();
            introframe.setVisible(true);
            // MainMenu frame = new MainMenu();
            // frame.setVisible(true);
            // Stageframe stageframe = new Stageframe("src/pictures", "src/sounds",1);
        } catch (Exception e) {
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

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

class Mytextpanel extends JPanel {

    String name;
    JTextField tf;
    JLabel contentpane;
    JDialog temp;
    MainMenu main;
    PlayerInfo player;
    ArrayList<PlayerInfo> playerarraylist;

    public Mytextpanel(JDialog t, MainMenu nu, ArrayList<PlayerInfo> playerarraylist) {
        temp = t;
        main = nu;
        this.playerarraylist = playerarraylist;
        setVisible(true);
        setBackground(new Color(64, 64, 196));
        setSize(300, 300);
        setLayout(null);

        this.addcomponent();

        validate();
        repaint();
    }

    public void addcomponent() {
        tf = new JTextField(20);
        tf.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 20));
        tf.setText("In put username");
        tf.setBounds(25, 25, 300, 50);
        tf.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String nametext = tf.getText();
                    // set current player
                    main.setCurrentplayer(checkplayer(playerarraylist, nametext)); // = checkplayer(playerarraylist,
                                                                                   // nametext);
                    temp.dispose();

                    JDialog d2;
                    d2 = new JDialog(main, "Choose stage");

                    d2.setSize(500, 300);
                    d2.setBounds(250, 250, 500, 200);
                    Mytextpanel2 t2 = new Mytextpanel2(d2, main.getCurrentplayer(), main);
                    d2.add(t2);
                    d2.setVisible(true);
                }

            }

            public void keyReleased(KeyEvent e) {
            }

        }); // summit button
        JButton summitButton = new JButton("submit");
        {
            summitButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 16));
            summitButton.setBackground(new Color(222, 0, 62));
            summitButton.setForeground(Color.white);
            // customize the button with your own look

            summitButton.setForeground(new Color(255, 255, 255));
            summitButton.setBounds(350, 25, 100, 50);
            summitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String nametext = tf.getText();
                    // set current player
                    main.setCurrentplayer(checkplayer(playerarraylist, nametext)); // = checkplayer(playerarraylist,
                                                                                   // nametext);
                    temp.dispose();

                    JDialog d2;
                    d2 = new JDialog(main, "Choose stage");

                    d2.setSize(500, 300);
                    d2.setBounds(250, 250, 500, 200);
                    Mytextpanel2 t2 = new Mytextpanel2(d2, main.getCurrentplayer(), main);
                    d2.add(t2);
                    d2.setVisible(true);
                    d2.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent e) {
                        }

                        public void keyPressed(KeyEvent e) {

                            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                                temp.dispose();
                            }

                        }

                        public void keyReleased(KeyEvent e) {
                        }

                    });

                    // submit name and process to check that player have ever play
                }
            });
        }
        this.add(tf);
        this.add(summitButton);
    }

    public PlayerInfo checkplayer(ArrayList<PlayerInfo> playerarr, String name) {
        for (PlayerInfo p : playerarr) {
            if (name.equalsIgnoreCase(p.getname())) {
                return p;
            }
        }
        PlayerInfo temp = new PlayerInfo(name, 1, 0, 0, 0, 0, 0, true, true, true);
        return temp;

    }
}

class Mytextpanel2 extends JPanel {
    protected JCheckBox musiccheck, effectcheck, cutScenecheck, savecheck, scorecheck;
    protected JPanel epanel, mpanel, cpanel, spanel, scpanel;
    protected JPanel AutosavePanel;
    protected JPanel ScorePanel;
    protected JLabel AutotsaveText;
    protected JLabel cutscenesText;
    protected JLabel ScoreText;
    protected JPanel cutScenesPanel;
    protected JDialog temp;
    protected PlayerInfo player;
    protected MainMenu main;
    protected int stage = 0;

    public Mytextpanel2(JDialog t, PlayerInfo p, MainMenu m) {
        temp = t;
        player = p;
        main = m;

        setVisible(true);
        setBackground(new Color(64, 64, 196));
        // setBounds(50,50,200,500);
        setSize(300, 300);
        // setHorizontalAlignment(CENTER);
        // setVerticalAlignment(CENTER);
        setLayout(null);

        this.addcomponent();

        validate();
        repaint();
    }

    public void addcomponent() {

        ButtonGroup bg = new ButtonGroup();
        // button
        System.out.println(player.getstage());
        ArrayList<String> st = new ArrayList<String>();
        
        switch (player.getstage()) 
        {
            case 1:
                st.add("Stage1");
                break;
            case 2:
                st.add("Stage1");
                st.add("Stage2");
                break;
            case 3:
                st.add("Stage1");
                st.add("Stage2");
                st.add("Stage3");
                break;
            case 4:
                st.add("Stage1");
                st.add("Stage2");
                st.add("Stage3");
                st.add("Stage4");
                break;
            case 5:
                st.add("Stage1");
                st.add("Stage2");
                st.add("Stage3");
                st.add("Stage4");
                st.add("Stage5");
                break;
            default:
                break;
        }
        JComboBox SB = new JComboBox(new Vector<String>(st));
        SB.setBounds(25, 120, 75, 20);
        SB.setVisible(true);
        this.add(SB);

        ActionListener cbActionListener = new ActionListener() { //add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int s = SB.getSelectedIndex(); //get the selected item

                switch (s) {//check for a match
                    case 0:
                        stage = 1;
                        break;
                    case 1:
                        stage = 2;
                        break;
                    case 2:
                        stage = 3;
                        break;
                    case 3:
                        stage = 4;
                        break;
                    case 4:
                        stage = 5;
                        break;
                    default:
                        break;
                }
            }
        };
        SB.addActionListener(cbActionListener);
 
        System.out.println(stage + " --- " +SB.getSelectedIndex());
        JButton summitButton = new JButton("submit");
        {
            summitButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 16));
            summitButton.setBackground(new Color(222, 0, 62));
            summitButton.setForeground(Color.white);
            // customize the button with your own look

            summitButton.setForeground(new Color(255, 255, 255));
            summitButton.setBounds(350, 25, 100, 50);
            summitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    temp.dispose();
                    System.out.println(stage);
                    if (player.getshowstory()) {
                        main.startstory(stage);
                    } else {
                        main.startstage(stage);
                    }

                }
            });
        }
        cutScenesPanel = new JPanel();
        {
            cutscenesText = new JLabel();
            {
                cutscenesText.setFont(new Font("Charter", Font.BOLD, 16));
                cutscenesText.setForeground(Color.white);
                cutscenesText.setText("NOT SHOW STORY");
                cutscenesText.setBounds(25, 75, 150, 30);
            }
            cutScenesPanel.setBounds(25, 75, 150, 100);
            cutScenesPanel.setOpaque(false);
        }
        cpanel = new JPanel();
        {
            cpanel.setBounds(200, 75, 100, 25);
            cpanel.setOpaque(false);
            cutScenecheck = new JCheckBox(" no story ");
            cutScenecheck.setForeground(Color.white);
            cutScenecheck.setOpaque(false);
            if (player.getshowstory()) {
                cutScenecheck.setSelected(false);
            } else {
                cutScenecheck.setSelected(true);
            }
            cutScenecheck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JCheckBox cb = (JCheckBox) event.getSource();
                    if (cb.isSelected()) {
                        player.setshowstory(false);
                    } else {
                        player.setshowstory(true);
                    }
                }
            });
        }

        AutosavePanel = new JPanel();
        {
            AutotsaveText = new JLabel();
            {
                AutotsaveText.setFont(new Font("Charter", Font.BOLD, 16));
                AutotsaveText.setForeground(Color.white);
                AutotsaveText.setText("NO AUTO-SAVE");
                AutotsaveText.setBounds(25, 50, 150, 30);
            }
            AutosavePanel.setBounds(50, 100, 100, 100);
            AutosavePanel.setOpaque(false);
        }
        spanel = new JPanel();
        {
            spanel.setBounds(200, 50, 100, 25);
            spanel.setOpaque(false);
            savecheck = new JCheckBox(" no save ");
            savecheck.setForeground(Color.white);
            savecheck.setOpaque(false);
            if (player.getAutosave()) {
                savecheck.setSelected(false);
            } else {
                savecheck.setSelected(true);
            }
            savecheck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JCheckBox cb = (JCheckBox) event.getSource();
                    if (cb.isSelected()) {
                        // main.setsave(false);
                        player.setAutosave(false);
                    } else {
                        // main.setsave(true);
                        player.setAutosave(true);
                    }
                }
            });
        }

        ScorePanel = new JPanel();
        {
            ScoreText = new JLabel();
            {
                ScoreText.setFont(new Font("Charter", Font.BOLD, 16));
                ScoreText.setForeground(Color.white);
                ScoreText.setText("NOT SHOW SCORE");
                ScoreText.setBounds(25, 25, 150, 30);
            }
            ScorePanel.setBounds(150, 50, 100, 100);
            ScorePanel.setOpaque(false);
        }
        scpanel = new JPanel();
        {
            scpanel.setBounds(200, 25, 100, 25);
            scpanel.setOpaque(false);
            scorecheck = new JCheckBox(" no score ");
            scorecheck.setForeground(Color.white);
            scorecheck.setOpaque(false);
            if (player.getdisplay()) {
                scorecheck.setSelected(false);
            } else {
                scorecheck.setSelected(true);
            }

            scorecheck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    JCheckBox cb = (JCheckBox) event.getSource();
                    if (cb.isSelected()) {
                        // main.setscore(false);
                        player.setshowstory(false);
                    } else {
                        // main.setscore(true);
                        player.setshowstory(true);

                    }
                }
            });
        }

        /*
         * bg.add(r1);
         * bg.add(r2);
         * bg.add(r3);
         * bg.add(r4);
         * bg.add(r5);
         * 
         * // this.add(tf);
         * // add
         * this.add(r1);
         * this.add(r2);
         * this.add(r3);
         * this.add(r4);
         * this.add(r5);
         */
        this.add(summitButton);
        cpanel.add(cutScenecheck);
        spanel.add(savecheck);
        scpanel.add(scorecheck);
        this.add(AutotsaveText);
        this.add(cutscenesText);
        this.add(cutScenesPanel);
        this.add(ScorePanel);
        this.add(ScoreText);
        this.add(AutosavePanel);
        this.add(cutScenesPanel);
        this.add(cpanel);
        this.add(spanel);
        this.add(scpanel);

        validate();
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            temp.dispose();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
