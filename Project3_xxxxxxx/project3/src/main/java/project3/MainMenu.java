/*6413110 Mr.Watcharsak Prommanee
6413112 Mr.Sasit Srirat
6413210 Mr.Kawin Kengkate
6413223 Mr.Ravipol Chayeraksa*/
package project3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

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
    private final int frameWidth = 1366, frameHeight = 768;
    protected Stageframe sframe;
    private JLabel contentPane;
    protected Optionframe oframe;
    protected Tutorialframe tframe;
    protected Creditframe cframe;
    protected ArrayList<Sound> musicSound = new ArrayList<Sound>(), effectSound = new ArrayList<Sound>();
    protected Scoreframe scoreframe;
    protected Storyframe strframe;
    public String imagepath, soundpath, path;
    protected ArrayList<PlayerInfo> playerArraylist = new ArrayList<PlayerInfo>();
    protected PlayerInfo currentplayer;
    protected Filemanage scan;
    protected String fileinfo = "info.txt";
    private Timer timer1,timer2;
    protected MainMenu main = this;

    public MainMenu() {
        imagepath = "src/pictures/";//"src/pictures/"
        soundpath = "src/sounds/"; // "src/sounds/"
        path = "src/main/java/project3/";// "src/main/java/project3/";
                                                                            
        //------------------------------------->  set sounds to the ArrayList
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
        effectSound.add(new Sound(soundpath + "leech.wav", "humanhealEF"));
        effectSound.add(new Sound(soundpath + "victoryEF.wav", "victoryEF"));
        effectSound.add(new Sound(soundpath + "defeatEF.wav", "defeatEF"));
        effectSound.add(new Sound(soundpath + "restEF.wav", "restEF"));
        
        //-------------------------------------> config JFrame  
        setType(Type.POPUP);
        setTitle("Menu");
        setResizable(false);
        setBounds(50, 50, frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ImageIcon img = new ImageIcon(imagepath + "robot.png");
        setIconImage(img.getImage());
        addWindowListener(this);
        
        //---------------------------------------> File management
        scan = new Filemanage(path, fileinfo);
        scan.filescan(playerArraylist);
        
        addcomponent();
    }
    
    public void addcomponent(){
        //-------------------------------------> set background gif
        ImageIcon imageIcon = new ImageIcon(imagepath + "roboyscofi1.gif");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
        contentPane = new JLabel();
        contentPane.setIcon(imageIcon);
        contentPane.setLayout(null);
        setContentPane(contentPane);
 
        timer1 = new Timer(4000, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                ImageIcon imageIcon = new ImageIcon(imagepath + "roboyscofi2.gif");
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
                contentPane.setIcon(imageIcon);
                
            }
        });
        
        timer2 = new Timer(6000, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                ImageIcon imageIcon = new ImageIcon(imagepath + "roboyscofi1.gif");
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_DEFAULT));
                contentPane.setIcon(imageIcon);
                
            }
        });
        
        timer1.start();
        timer2.start();
 
        //-------------------------------------> set logo gif and text footer
        JLabel logo = new JLabel();
        JLabel est = new JLabel("Power by Java ver.18 @ 2022");
        est.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 15));
        est.setForeground(Color.white);
        logo.setIcon(new ImageIcon(new ImageIcon(imagepath + "RDT-Logo.gif").getImage().getScaledInstance(160, 160,
                Image.SCALE_DEFAULT)));
        logo.setBounds(122, 15, 200, 200); // setBounds(122, 15, 200, 200);
        est.setBounds(82, 600, 300, 200);
        contentPane.add(est);
        contentPane.add(logo);

        //-------------------------------------> set Button
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
                    d.setResizable(false);
                    d.setSize(500, 300);
                    d.setBounds(250, 250, 500, 200);
                    d.addKeyListener(new KeyListener() {
                        public void keyTyped(KeyEvent e) {
                            System.out.printf("t >>  %c  (%s) \n", e.getKeyChar(), KeyEvent.getKeyText(e.getKeyCode()));
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
            optionButton.setUI(new StyledButtonUI());
            optionButton.setForeground(new Color(255, 255, 255));
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
                        tframe = new Tutorialframe(imagepath);
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
                }
            });
        }
        JButton creditButton = new JButton("CREDIT");
        {
            creditButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            creditButton.setBackground(new Color(222, 0, 62));
            creditButton.setForeground(Color.white);
            creditButton.setUI(new StyledButtonUI());
            creditButton.setForeground(new Color(255, 255, 255));
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
                        d.setResizable(false);
                        JButton b1 = new JButton("Yes");
                        JButton b2 = new JButton("No");
                        JLabel l1 = new JLabel("Are you sure to exit game ???? ");
                        d.setTitle("Exit");
                        d.setBounds(583, 459, 240, 100);
                        d.setLayout(new FlowLayout());
                        d.add(l1);
                        d.add(b1);
                        d.add(b2);
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

        //-------------------------------------> add all to contentPane
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
            J.setBackground(new Color(0, 0, 0, 155)); // RGBA 255,255,255,255
            contentPane.add(J);
            repaint();
            validate();
        }
        contentPane.setFocusable(true);
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

    public void openscore() {
        try {
                scoreframe = new Scoreframe(main,imagepath,path+fileinfo);
            } catch (FileNotFoundException e) {
            }
    }

    public void startstory(int a) {
        for (Sound i : musicSound) {
            if ("mainmenuBG".equals(i.getName()))
                i.stop();
        }
        setTitle("Story " + a);
        strframe = new Storyframe(a, imagepath, musicSound, effectSound, main, frameWidth, frameHeight);
        setContentPane(strframe.getContentpane());
    }

    public void startstage(int a) {
        for (Sound i : musicSound) {
            if ("mainmenuBG".equals(i.getName()))
                i.stop();
        }
        sframe = new Stageframe(imagepath, musicSound, effectSound, main, a);
        setTitle("Stage " + a);
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
        scan.filewrite(playerArraylist);
    }

    @Override
    public void windowClosed(WindowEvent e) // window close
    {
    }

    public static void main(String[] args) {
        try {
             MainMenu frame = new MainMenu();
             frame.setVisible(true);
        } catch (Exception e) {}
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
                    main.setCurrentplayer(checkplayer(playerarraylist, nametext)); 
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
            summitButton.setForeground(new Color(255, 255, 255));
            summitButton.setBounds(350, 25, 100, 50);
            summitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    String nametext = tf.getText();
                    // set current player
                    main.setCurrentplayer(checkplayer(playerarraylist, nametext));
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
        setSize(300, 300);
        setLayout(null);
        this.addcomponent();
        validate();
        repaint();
    }

    public void addcomponent() {
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
        final JComboBox SB = new JComboBox(new Vector<String>(st));
        SB.setBounds(25, 120, 75, 20);
        SB.setVisible(true);
        SB.setSelectedIndex(0);
        this.add(SB);
        stage = 1; //config stage
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

        JButton summitButton = new JButton("submit");
        {
            summitButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 16));
            summitButton.setBackground(new Color(222, 0, 62));
            summitButton.setForeground(Color.white);
            summitButton.setForeground(new Color(255, 255, 255));
            summitButton.setBounds(350, 25, 100, 50);
            summitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    temp.dispose();
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
                        player.setAutosave(false);
                    } else {
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
                        player.setdisplay(false);
                    } else {
                        player.setdisplay(true);
                    }
                }
            });
        }
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
