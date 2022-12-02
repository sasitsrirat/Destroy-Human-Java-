package project3;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;

public class Stageframe extends JFrame {

    private int frameHeight = 768;
    private int frameWidth = 1366;
    private int stagenum, allwave;
    private int allturn;
    private int choose = 0;
    private String imagepath;
    private Stagewave sw;
    private ArrayList<Robot> robotArraylist;
    private ArrayList<Human> humanArraylist;
    private ArrayList<Characterlabel> robotLabelArraylist, humanLabelArraylist;
    private Random rand = new Random();
    private Characterlabel activeLabel, targetLabel;
    private StatLabel stat;
    private JLabel contentpane;
    private JLabel activepoint = new JLabel();
    private JLabel warn = new JLabel();
    private JLabel[] RO = { new JLabel(), new JLabel(), new JLabel() };
    private JLabel[] HU = { new JLabel(), new JLabel(), new JLabel() };
    private int currentstate = 0;
    protected ArrayList<Sound> musicSound = new ArrayList<Sound>(), effectSound = new ArrayList<Sound>();
    private ArrayList<Thread> threadArraylist;
    private MainMenu main;
    private PlayerInfo player;
    private ArrayList<PlayerInfo> playerArraylsit;
    private Stageframe stageframe;

    public Stageframe(String ipath, ArrayList<Sound> mSound, ArrayList<Sound> eSound, MainMenu m, int stage) {
        stageframe = this;
        stagenum = stage;
        imagepath = ipath;
        musicSound = mSound;
        effectSound = eSound;
        main = m;
        player = main.getCurrentplayer();
        playerArraylsit = main.getplayerarraylist();
        for (Sound i : musicSound) {
            if ("stageBG".equals(i.getName())) {
                i.playLoop();
            }
        }
        contentpane = new JLabel();
        sw = new Stagewave(stage, this);
        allwave = sw.getWave();
        MyImageIcon background = new MyImageIcon(imagepath + sw.getpath());
        contentpane.setIcon(background.resize(frameWidth, frameHeight));
        contentpane.setOpaque(false);
        contentpane.setLayout(null);
        this.addcomponent();
        if (stage != 5) {
            ImageIcon cloud = new ImageIcon(imagepath + "HSxPUMA_Clouds.gif");
            {
                cloud.setImage(cloud.getImage().getScaledInstance(frameWidth, 200, Image.SCALE_REPLICATE)); // size
                JLabel CloudPanel = new JLabel(cloud);
                CloudPanel.setBounds(0, 0, frameWidth, 200);
                CloudPanel.setVisible(true);
                contentpane.add(CloudPanel);
            }
        }
        validate();
        repaint();
        battle(stage, 1);
    }

    public int getchoose() {
        return choose;
    }

    public Characterlabel getTargetLabel() {
        return targetLabel;
    }

    public void settargetLabel(Characterlabel tl) {
        targetLabel = tl;
    }

    public void sethumanArraylist(int wave) {
        this.humanArraylist = sw.gethu(wave);
    }

    public void setrobotArraylist() {
        this.robotArraylist = sw.getro();
    }

    public ArrayList<Human> gethumanArraylist() {
        return humanArraylist;
    }

    public ArrayList<Robot> getrobotArraylist() {
        return robotArraylist;
    }

    public int getWidth() {
        return frameWidth;
    }

    public int getHeighth() {
        return frameHeight;
    }

    public JLabel getContentpane() {
        return contentpane;
    }

    public int getstagenum() {
        return this.stagenum;
    }

    public void setstagenum(int num) {
        this.stagenum = num;
    }

    public void setstagestate(int a) {
        this.currentstate = a;
    }

    public int getstagestate() {
        return this.currentstate;
    }

    public void settext() {
        int i = 0;
        for (i = 0; i < robotLabelArraylist.size(); i++) {
            RO[i].setText(robotLabelArraylist.get(i).getOwner().getname() + "  HP  : "
                    + Integer.toString(robotLabelArraylist.get(i).getOwner().gethp()) + "/ "
                    + Integer.toString(robotLabelArraylist.get(i).getOwner().getmax_hp()));
            RO[i].setVisible(true);
        }
        if (i < 3) {
            for (int j = i + 1; j < 3; j++) {
                RO[j].setVisible(false);
            }
        }
        for (i = 0; i < humanLabelArraylist.size(); i++) {
            HU[i].setText(humanLabelArraylist.get(i).getOwner().getname() + "  HP  : "
                    + Integer.toString(humanLabelArraylist.get(i).getOwner().gethp()) + "/ "
                    + Integer.toString(humanLabelArraylist.get(i).getOwner().getmax_hp()));
            HU[i].setVisible(true);
        }
        if (i < 3) {
            for (int j = i; j < 3; j++) {
                HU[j].setVisible(false);
            }
        }
        validate();
        contentpane.repaint();
    }

    public void showactive() {
        MyImageIcon pointer = new MyImageIcon(imagepath + "pointer.png").resize(50, 50);
        activepoint.setBounds(activeLabel.getcurX() + 65, activeLabel.getcurY() - 55, 50, 50);
        activepoint.setIcon(pointer);
        activepoint.setVisible(true);
        contentpane.add(activepoint);
        validate();
        contentpane.repaint();
    }

    public void hideactive() {
        activepoint.setVisible(false);
        validate();
        repaint();
    }

    public void addcomponent() {
        // this.setpause();
        for (Sound i : effectSound) {
            if ("clickEF".equals(i.getName())) {
                stat = new StatLabel(imagepath, "StatusBG.png", i, frameWidth, frameHeight - 480, this);
            }
        }
        stat.setMoveConditions(0, 480);
        stat.addlabelcomponent();

        setrobotArraylist();
        addallrobot();
        contentpane.add(stat);

        validate();
        repaint();
    }

    public void addallrobot() {
        robotLabelArraylist = new ArrayList<Characterlabel>();
        for (int i = 0; i < robotArraylist.size(); i++) {
            robotLabelArraylist.add(new Characterlabel(imagepath, 180, 180, this, stat, robotArraylist.get(i)));
            robotLabelArraylist.get(i).addMouse();
            contentpane.add(robotLabelArraylist.get(i));
            RO[i].setBackground(null);
            RO[i].setForeground(Color.white);
            RO[i].setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 13));
            RO[i].setHorizontalAlignment(JLabel.CENTER);
            RO[i].setBounds(robotLabelArraylist.get(i).getcurX(), robotLabelArraylist.get(i).getcurY() + 200, 200, 30);
            RO[i].setText(robotLabelArraylist.get(i).getOwner().getname() + "  HP  : "
                    + Integer.toString(robotLabelArraylist.get(i).getOwner().gethp()) + "/ "
                    + Integer.toString(robotLabelArraylist.get(i).getOwner().getmax_hp()));
            contentpane.add(RO[i]);
        }
    }

    public void addallhuman() {
        humanLabelArraylist = new ArrayList<Characterlabel>();
        for (int i = 0; i < humanArraylist.size(); i++) {
            humanLabelArraylist.add(new Characterlabel(imagepath, 180, 180, this, stat, humanArraylist.get(i)));
            humanLabelArraylist.get(i).addMouse();
            HU[i].setBackground(null);
            HU[i].setForeground(Color.white);
            HU[i].setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 13));
            HU[i].setBounds(humanLabelArraylist.get(i).getcurX(), humanLabelArraylist.get(i).getcurY() + 200, 180, 20);
            HU[i].setHorizontalAlignment(JLabel.CENTER);
            HU[i].setText(humanLabelArraylist.get(i).getOwner().getname() + "  HP  : "
                    + Integer.toString(humanLabelArraylist.get(i).getOwner().gethp()) + "/ "
                    + Integer.toString(humanLabelArraylist.get(i).getOwner().getmax_hp()));
            contentpane.add(humanLabelArraylist.get(i));
            contentpane.add(HU[i]);
        }
    }

    public void setallrobot() {

    }

    public void setallhuman() {

    }

    public void battle(int stage, int wave) { // stage battle
        sethumanArraylist(wave);
        addallhuman();
        settext();
        validate();
        contentpane.repaint();

        Thread bruh = new Thread() {
            public void setpause() {
                Thread b = this;
                MyImageIcon icon = new MyImageIcon(imagepath + "back.png").resize(50, 50);
                JButton pause = new JButton(icon);
                {
                    pause.setOpaque(false);
                    pause.setBounds(frameWidth - 90, 40, 50, 50);
                    pause.setVisible(true);
                    pause.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent event) {
                            for (Sound i : musicSound) {
                                if ("stageBG".equals(i.getName())) {
                                    i.stop();
                                }
                            }
                            int result = JOptionPane.showConfirmDialog(main, "Get back to Mainmenu?", " PAUSE",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (result == JOptionPane.YES_OPTION) {
                                for (Sound i : musicSound) {
                                    if ("mainmenuBG".equals(i.getName())) {
                                        i.playLoop();
                                    }
                                }
                                for (int j = 0; j < humanArraylist.size(); j++) {
                                        humanArraylist.get(j).getspeedthread().stop();
                                }
                                for (int j = 0; j < robotArraylist.size(); j++) {
                                        robotArraylist.get(j).getspeedthread().stop();
                                }
                                stageframe.dispose();
                                main.setContentPane(main.getPane());
                                b.stop();
                            } else {
                                for (Sound i : musicSound) {
                                    if ("stageBG".equals(i.getName())) {
                                        i.playLoop();
                                    }
                                }
                            }
                        }
                    });
                }
                contentpane.add(pause);
                contentpane.validate();
                contentpane.repaint();
                
            }

            public void run() {
                setpause();
                int turn;
                for (turn = 0; humanArraylist.size() > 0 && robotArraylist.size() > 0; turn++) {

                    JOptionPane.showMessageDialog(null, " WAVE" + wave + " TURN " + (turn + 1), " STAGE" + stage,
                            JOptionPane.PLAIN_MESSAGE);
                    threadArraylist = new ArrayList<Thread>();
                    for (Robot ro : robotArraylist) {

                        threadArraylist.add(ro.getspeedthread());
                    }
                    for (Human hu : humanArraylist) {
                        threadArraylist.add(hu.getspeedthread());
                    }
                    for (Thread th : threadArraylist) {
                        th.start();
                    }
                    for (Thread th : threadArraylist) {
                        try {
                            th.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    for (Robot ro : robotArraylist) {
                        ro.setnewspeedthread();
                    }
                    for (Human hu : humanArraylist) {
                        hu.setnewspeedthread();
                    }
                }
                allturn += turn;
                if (humanArraylist.isEmpty()) {
                    for (Characterlabel h : humanLabelArraylist) {
                        h.setVisible(false);
                    }
                    if (allwave > wave) {
                        battle(stage, wave + 1);
                    } else {
                        if (stage >= 5) { // Win all stage
                            if (allturn < 25)
                                player.setscore(100 + (100 - (allturn * 4)), stage);
                            else
                                player.setscore(100, stage);
                            main.getfilemanage().filewrite(playerArraylsit);
                            JOptionPane.showMessageDialog(null, "Victory\nScore : " + player.getscore(stage),
                                    " STAGE" + stage, JOptionPane.PLAIN_MESSAGE);
                            for (Sound i : musicSound) {
                                if ("stageBG".equals(i.getName())) {
                                    i.stop();
                                }
                            }
                            if (player.getshowstory()) {
                                main.startstory(6);
                            } else {
                                for (Sound i : musicSound) {
                                    if ("mainmenuBG".equals(i.getName())) {
                                        i.playLoop();
                                    }
                                }
                                main.openscore();
                                main.setContentPane(main.getPane());
                            }
                            main.validate();
                            main.repaint();
                        } else { // Win this stage
                            player.setstage(stage + 1);
                            if (stage == 1 && player.getscore(1) == 0) {
                                playerArraylsit.add(player);
                            }
                            if (allturn < 25)
                                player.setscore(100 + (100 - (allturn * 4)), stage);
                            else
                                player.setscore(100, stage);
                            main.getfilemanage().filewrite(playerArraylsit);
                            int result = JOptionPane.showConfirmDialog(main,
                                    "Victory\nScore : " + player.getscore(stage) + "\nGo to next stage ?",
                                    " STAGE" + stage,
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);
                            for (Sound i : musicSound) {
                                if ("stageBG".equals(i.getName())) {
                                    i.stop();
                                }
                            }
                            if (result == JOptionPane.YES_OPTION) {
                                if (player.getshowstory()) {
                                    main.startstory(stage + 1);
                                } else {
                                    main.startstage(stage + 1);
                                }
                                main.validate();
                                main.repaint();
                            } else {
                                for (Sound i : musicSound) {
                                    if ("mainmenuBG".equals(i.getName())) {
                                        i.playLoop();
                                    }
                                }
                                main.setContentPane(main.getPane());
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Defeat\nGet back to Mainmenu", " STAGE" + stage,
                            JOptionPane.PLAIN_MESSAGE);
                    for (Sound i : musicSound) {
                        if ("stageBG".equals(i.getName())) {
                            i.stop();
                        }
                    }
                    for (Sound i : musicSound) {
                        if ("mainmenuBG".equals(i.getName())) {
                            i.playLoop();
                        }
                    }
                    main.setContentPane(main.getPane());
                }
            }
        };
        bruh.start();
    }

    public synchronized void setactiveLabel(Character c) {
        if (robotArraylist.isEmpty() || humanArraylist.isEmpty()) {

        } else {
            activeLabel = c.getLabel();
            showactive();
            stat.setactiveCharacter(activeLabel.getOwner());
            stat.ShowAction(activeLabel.getOwner());
            try {
                Thread.currentThread();
                Thread.sleep(60000);
                action_rest();
                try {
                    Thread.currentThread();
                    Thread.sleep(2250);
                } catch (InterruptedException e) {

                }
            } catch (InterruptedException e) {
            }
            stat.setactiveCharacter(activeLabel.getOwner());
            checkdeath();
            settext();
            try {
                Thread.currentThread();
                Thread.sleep(2250);
            } catch (InterruptedException e) {

            }
            hideactive();
            stat.HideButton();
        }
    }

    public void checkdeath() {
        for (int j = 0; j < humanArraylist.size(); j++) { // check death here
            if (humanArraylist.get(j).checkdeath() == 1) {
                humanArraylist.get(j).getLabel().showdeath();
                humanArraylist.get(j).getspeedthread().stop(); // kill thread
                humanArraylist.remove(j);
                j = j - 1;
            }
        }
        for (int j = 0; j < robotArraylist.size(); j++) {
            if (robotArraylist.get(j).checkdeath() == 1) {
                robotArraylist.get(j).getLabel().showdeath();
                robotArraylist.get(j).getspeedthread().stop(); // kill thread
                robotArraylist.remove(j);
                j = j - 1;
            }
        }
    }

    public void robot_attack() { // Arraylist robot,character
        if (targetLabel == null) {
            warn.setText("Choose the Enemy");
            warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
            warn.setBackground(new Color(222, 0, 62));
            warn.setHorizontalAlignment(JLabel.CENTER);
            warn.setOpaque(true);
            warn.setForeground(Color.white);
            warn.setBounds(423, 50, 520, 70);
            contentpane.add(warn);
            choose = 1;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            this.currentstate = 4;
            stat.HideButton();
            activeLabel.getOwner().attack(targetLabel.getOwner());
            activeLabel.attack_animation();
            for (Sound i : effectSound) {
                if ("robotnormalattackEF".equals(i.getName())) {
                    targetLabel.takedmg_animation("hit.gif", i);
                }
            }
            Robot r = (Robot) activeLabel.getOwner();
            r.gainep(1);
            stat.settargetCharacter(targetLabel.getOwner());
            choose = 0;
            targetLabel = null;
            contentpane.remove(warn);
            this.currentstate = 0;
            contentpane.repaint();
            validate();

            activeLabel.getOwner().getspeedthread().interrupt();

        } else if (targetLabel.getOwner() instanceof Robot) {
            warn.setText("Don't Choose the Ally");
            contentpane.repaint();
            validate();
        }
    }

    public void randomRobot() {
        int a = rand.nextInt(robotArraylist.size());
        targetLabel = robotArraylist.get(a).getLabel();
    }

    public void human_attack() {
        activeLabel.attack_animation();
        if (activeLabel.getOwner() instanceof Human_soldier) {
            for (Robot ro : robotArraylist) {
                activeLabel.getOwner().attack(ro);
                for (Sound i : effectSound) {
                    if ("humangunEF".equals(i.getName())) {
                        ro.getLabel().takedmg_animation("gunfire.gif", i);
                    }
                }
            }
        } else {
            activeLabel.getOwner().attack(targetLabel.getOwner());
            for (Sound i : effectSound) {
                if ("humannormalattackEF".equals(i.getName())) {
                    targetLabel.takedmg_animation("hit.gif", i);
                }
            }
        }
        if (activeLabel.getOwner() instanceof Human_super) {
            activeLabel.getOwner().takeheal(3);
            for (Sound i : effectSound) {
                if ("humanhealEF".equals(i.getName())) {
                    activeLabel.takedmg_animation("humanheal.gif", i);
                }
            }
        }
        stat.settargetCharacter(targetLabel.getOwner());
        targetLabel = null;
        contentpane.repaint();
        validate();
        activeLabel.getOwner().getspeedthread().interrupt();
    }

    public void action_robot1_skill() {
        if (targetLabel == null) {
            warn.setText("Choose the Enemy");
            warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
            warn.setBackground(new Color(222, 0, 62));
            warn.setOpaque(true);
            warn.setHorizontalAlignment(JLabel.CENTER);
            warn.setForeground(Color.white);
            warn.setBounds(423, 50, 520, 70);
            contentpane.add(warn);
            choose = 2;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            stat.HideButton();
            activeLabel.getOwner().skill1(targetLabel.getOwner());
            activeLabel.attack_animation();
            for (Sound i : effectSound) {
                if ("robotskill1EF".equals(i.getName())) {
                    targetLabel.takedmg_animation("lightning.gif", i);
                }
            }
            stat.settargetCharacter(targetLabel.getOwner());

            choose = 0;
            targetLabel = null;
            contentpane.remove(warn);
            this.currentstate = 0;
            contentpane.repaint();
            validate();
            activeLabel.getOwner().getspeedthread().interrupt();
        } else if (targetLabel.getOwner() instanceof Robot) {
            warn.setText("Don't Choose the Ally");
            contentpane.repaint();
            validate();
        }
    }

    public void action_robot2_skill() {
        if (targetLabel == null) {
            warn.setText("Choose the Ally");
            warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
            warn.setBackground(new Color(222, 0, 62));
            warn.setOpaque(true);
            warn.setForeground(Color.white);
            warn.setHorizontalAlignment(JLabel.CENTER);
            warn.setBounds(423, 50, 520, 70);
            contentpane.add(warn);
            choose = 3;
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Human) {
            warn.setText("Don't Choose the Enemy");
            contentpane.repaint();
            validate();
        } else if (targetLabel.getOwner() instanceof Robot) {
            stat.HideButton();
            activeLabel.getOwner().skill2(targetLabel.getOwner());
            activeLabel.robotheal_animation();
            for (Sound i : effectSound) {
                if ("robotskill2EF".equals(i.getName())) {
                    targetLabel.takedmg_animation("healing.gif", i);
                }
            }
            stat.settargetCharacter(targetLabel.getOwner());
            choose = 0;
            targetLabel = null;
            contentpane.remove(warn);
            this.currentstate = 0;
            contentpane.repaint();
            validate();
            activeLabel.getOwner().getspeedthread().interrupt();
        }
    }

    public void action_robot3_skill() {
        stat.HideButton();
        activeLabel.getOwner().skill3(humanArraylist);
        activeLabel.attack_animation();
        for (Human hu : humanArraylist) {
            for (Sound i : effectSound) {
                if ("robotskill3EF".equals(i.getName())) {
                    hu.getLabel().takedmg_animation("bomb.gif", i);
                }
            }
            stat.settargetCharacter(hu);
        }
        this.currentstate = 0;
        contentpane.remove(warn);
        contentpane.repaint();
        validate();
        activeLabel.getOwner().getspeedthread().interrupt();
    }

    public void action_rest() {
        stat.HideButton();
        Robot r = (Robot) activeLabel.getOwner();
        r.gainep(2);
        for (Sound i : effectSound) {
            if ("restEF".equals(i.getName())) {
                activeLabel.rest_animation(i);
            }
        }
        this.currentstate = 0;
        contentpane.remove(warn);
        contentpane.repaint();
        validate();
        activeLabel.getOwner().getspeedthread().interrupt();
    }

    public void warnskill() {
        warn.setText("not enough EP ");
        warn.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 50));
        warn.setBackground(new Color(222, 0, 62));
        warn.setOpaque(true);
        warn.setHorizontalAlignment(JLabel.CENTER);
        warn.setForeground(Color.white);
        warn.setBounds(423, 50, 520, 70);
        contentpane.add(warn);
        contentpane.repaint();
        validate();
    }
}
