package project3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

class StatLabel extends JLabel {

    protected MyImageIcon statusicon;
    protected int curX, curY, width, height;
    protected String imagepath;
    protected Stageframe parentFrame;
    protected Character activeCharacter;
    protected Border border;
    protected Sound clickSound;

    protected JLabel Latktext = new JLabel();
    protected JLabel Lhptext = new JLabel();
    protected JLabel Ldeftext = new JLabel();
    protected JLabel Lspdtext = new JLabel();
    protected JLabel Lnametext = new JLabel();
    protected JLabel Leptext = new JLabel();
    protected JLabel Ratktext = new JLabel();
    protected JLabel Rhptext = new JLabel();
    protected JLabel Rdeftext = new JLabel();
    protected JLabel Rspdtext = new JLabel();
    protected JLabel Rnametext = new JLabel();
    protected JLabel Reptext = new JLabel();
    protected JLabel humanstat = new JLabel();
    protected JLabel humanaction = new JLabel();
    protected JLabel targetstat = new JLabel();
    protected JLabel attackinfo = new JLabel();
    protected JLabel skillinfo = new JLabel();
    protected JLabel restinfo = new JLabel();
    protected JButton attackButton, skillButton, restButton;
    protected JLabel panelpane;

    public StatLabel(String path, String image, Sound sound, int width, int height, Stageframe pf) {

        imagepath = path;
        this.width = width;
        this.height = height;
        statusicon = new MyImageIcon(imagepath + image).resize(width, height);
        clickSound = sound;
        setIcon(statusicon);
        setOpaque(true);
        setLayout(null);
        parentFrame = pf;
        setBounds(getVisibleRect());
        setVisible(true);

    }

    public synchronized void setactiveCharacter(Character ac) {
        activeCharacter = ac;
        if (activeCharacter instanceof Robot) {
            Robot a = (Robot) (activeCharacter);
            setRoLtext(activeCharacter.getatk(), activeCharacter.gethp(), activeCharacter.getmax_hp(),
                    activeCharacter.getdf(), activeCharacter.getname(), a.getep(), a.getmax_ep());
        } else {
            setHuLtext(activeCharacter.getatk(), activeCharacter.gethp(), activeCharacter.getmax_hp(),
                    activeCharacter.getdf(), activeCharacter.getname());
        }
    }

    public synchronized void settargetCharacter(Character tc) {
        if (tc instanceof Robot) {
            Robot a = (Robot) (tc);
            setRoRtext(tc.getatk(), tc.gethp(), tc.getmax_hp(),
                    tc.getdf(), tc.getname(), a.getep(), a.getmax_ep());
        } else {
            setHuRtext(tc.getatk(), tc.gethp(), tc.getmax_hp(),
                    tc.getdf(), tc.getname());
        }
    }

    public void setvisiblestatlabel(boolean n) {
        this.setVisible(n);
        validate();
    }

    public void setHuLtext(int atk, int hp, int max_hp, int def, String name) {
        Latktext.setText("ATK : " + Integer.toString(atk-1) + " - " + Integer.toString(atk+1));
        Lhptext.setText("HP  : " + Integer.toString(hp) + "/ " + Integer.toString(max_hp));
        Ldeftext.setText("DEF : " + Integer.toString(def));
        Lnametext.setText("NAME : " + name);
        Leptext.setVisible(false);
        repaint();
        parentFrame.repaint();
    }

    public void setRoLtext(int atk, int hp, int max_hp, int def, String name, int ep, int max_ep) {
        Latktext.setText("ATK : " + Integer.toString(atk-1) + " - " + Integer.toString(atk+1));
        Lhptext.setText("HP  : " + Integer.toString(hp) + "/ " + Integer.toString(max_hp));
        Ldeftext.setText("DEF : " + Integer.toString(def));
        Lnametext.setText("NAME : " + name);
        Leptext.setVisible(true);
        Leptext.setText("EP : " + Integer.toString(ep) + "/ " + Integer.toString(max_ep));
        repaint();
        parentFrame.repaint();
    }

    public void setHuRtext(int atk, int hp, int max_hp, int def, String name) {
        Ratktext.setText("ATK : " + Integer.toString(atk-1) + " - " + Integer.toString(atk+1));
        Rhptext.setText("HP  : " + Integer.toString(hp) + "/ " + Integer.toString(max_hp));
        Rdeftext.setText("DEF : " + Integer.toString(def));
        Rnametext.setText("NAME : " + name);
        Reptext.setVisible(false);
        repaint();
        parentFrame.repaint();
    }

    public void setRoRtext(int atk, int hp, int max_hp, int def, String name, int ep, int max_ep) {
        Ratktext.setText("ATK : " + Integer.toString(atk-1) + " - " + Integer.toString(atk+1));
        Rhptext.setText("HP  : " + Integer.toString(hp) + "/ " + Integer.toString(max_hp));
        Rdeftext.setText("DEF : " + Integer.toString(def));
        Rnametext.setText("NAME : " + name);
        Reptext.setVisible(true);
        Reptext.setText("EP : " + Integer.toString(ep) + "/ " + Integer.toString(max_ep));
        repaint();
        parentFrame.repaint();
    }

    public void setMoveConditions(int x, int y) {
        curX = x;
        curY = y;
        setBounds(curX, curY, width, height);
    }

    public void addlabelcomponent() {

        Latktext.setBackground(null);
        Latktext.setForeground(Color.white);
        Latktext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Latktext.setBounds(140, 40, 200, 30);

        Lhptext.setBackground(null);
        Lhptext.setForeground(Color.white);
        Lhptext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Lhptext.setBounds(140, 70, 200, 30);

        Ldeftext.setBackground(null);
        Ldeftext.setForeground(Color.white);
        Ldeftext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Ldeftext.setBounds(140, 100, 200, 30);

        Lnametext.setBackground(null);
        Lnametext.setForeground(Color.white);
        Lnametext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Lnametext.setBounds(140, 130, 200, 30);

        Leptext.setBackground(null);
        Leptext.setForeground(Color.white);
        Leptext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Leptext.setBounds(140, 160, 200, 30);

        Ratktext.setBackground(null);
        Ratktext.setForeground(Color.white);
        Ratktext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Ratktext.setBounds(parentFrame.getWidth() - 240, 40, 200, 30);

        Rhptext.setBackground(null);
        Rhptext.setForeground(Color.white);
        Rhptext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Rhptext.setBounds(parentFrame.getWidth() - 240, 70, 200, 30);

        Rdeftext.setBackground(null);
        Rdeftext.setForeground(Color.white);
        Rdeftext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Rdeftext.setBounds(parentFrame.getWidth() - 240, 100, 200, 30);

        Rnametext.setBackground(null);
        Rnametext.setForeground(Color.white);
        Rnametext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Rnametext.setBounds(parentFrame.getWidth() - 240, 130, 200, 30);

        Reptext.setBackground(null);
        Reptext.setForeground(Color.white);
        Reptext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Reptext.setBounds(parentFrame.getWidth() - 240, 160, 200, 30);

        attackinfo.setBackground(null);
        attackinfo.setForeground(Color.pink);
        attackinfo.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 14));
        attackinfo.setBounds(560, 50, 570, 50);
        attackinfo.setText("gain 1 EP --- Attack to an enemy with (atk) damage");
        attackinfo.setVisible(true);

        skillinfo.setBackground(null);
        skillinfo.setForeground(Color.pink);
        skillinfo.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 14));
        skillinfo.setBounds(560, 110, 570, 50);
        skillinfo.setVisible(true);

        restinfo.setBackground(null);
        restinfo.setForeground(Color.pink);
        restinfo.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 14));
        restinfo.setBounds(560, 170, 570, 50);
        restinfo.setText("gain 2 EP --- Skip this turn");
        restinfo.setVisible(true);

        attackButton = new JButton(" Attack");
        {
            attackButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            attackButton.setIcon(new MyImageIcon(imagepath + "normalattack.png").resize(40, 40));
            attackButton.setBackground(new Color(222, 0, 62));
            attackButton.setForeground(Color.white);
            attackButton.setSize(100, 200);
            attackButton.setUI(new StyledButtonUI());
            attackButton.setForeground(new Color(255, 255, 255));
            attackButton.setBounds(380, 50, 170, 50);
            attackButton.setLayout(null);
            attackButton.setVisible(true);
            attackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    clickSound.playOnce();
                    parentFrame.robot_attack();
                }
            });
        }

        skillButton = new JButton(" Skill ");
        {
            skillButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            skillButton.setBackground(new Color(222, 0, 62));
            skillButton.setForeground(Color.white);
            skillButton.setSize(100, 200);
            skillButton.setUI(new StyledButtonUI());
            skillButton.setForeground(new Color(255, 255, 255));
            skillButton.setBounds(380, 110, 170, 50);
            skillButton.setLayout(null);
            skillButton.setVisible(true);
            skillButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    clickSound.playOnce();
                    Robot r = (Robot) activeCharacter;
                    if (r.getep() < 3) {
                        parentFrame.warnskill();
                    } else {
                        if (activeCharacter instanceof Robot1) {
                            parentFrame.action_robot1_skill();
                        } else if (activeCharacter instanceof Robot2) {
                            parentFrame.action_robot2_skill();
                        } else if (activeCharacter instanceof Robot3) {
                            parentFrame.action_robot3_skill();
                        }
                    }
                }
            });
        }

        restButton = new JButton(" rest  ");
        {
            restButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            restButton.setIcon(new MyImageIcon(imagepath + "rest.png").resize(40, 40));
            restButton.setBackground(new Color(222, 0, 62));
            restButton.setForeground(Color.white);
            restButton.setSize(100, 200);
            restButton.setUI(new StyledButtonUI());
            restButton.setForeground(new Color(255, 255, 255));
            restButton.setBounds(380, 170, 170, 50);
            restButton.setLayout(null);
            restButton.setVisible(true);
            restButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    clickSound.playOnce();
                    parentFrame.action_rest();
                }
            });
        }

        this.add(Latktext);
        this.add(Lhptext);
        this.add(Ldeftext);
        this.add(Lnametext);
        this.add(Leptext);
        this.add(Ratktext);
        this.add(Rhptext);
        this.add(Rdeftext);
        this.add(Rnametext);
        this.add(Reptext);
        validate();
        repaint();
    }

    public synchronized void ShowAction(Character ch) {
        if (ch instanceof Robot1) {
            skillButton.setIcon(new MyImageIcon(imagepath + "skill_critical.png").resize(40, 40));
            skillinfo.setText("use  3 EP --- Attack an enemy with (atk * 2) damage and ignores enemy def");
            this.add(attackButton);
            this.add(attackinfo);
            this.add(skillButton);
            this.add(skillinfo);
            this.add(restButton);
            this.add(restinfo);
        } else if (ch instanceof Robot2) {
            skillButton.setIcon(new MyImageIcon(imagepath + "skill_heal.png").resize(40, 40));
            skillinfo.setText("use  3 EP --- Recovery an Ally with (atk * 3) HP");
            this.add(attackButton);
            this.add(attackinfo);
            this.add(skillButton);
            this.add(skillinfo);
            this.add(restButton);
            this.add(restinfo);
        } else if (ch instanceof Robot3) {
            skillButton.setIcon(new MyImageIcon(imagepath + "skill_bomb.png").resize(40, 40));
            skillinfo.setText("use  3 EP --- Attack all enemies with (atk) damage");
            this.add(attackButton);
            this.add(attackinfo);
            this.add(skillButton);
            this.add(skillinfo);
            this.add(restButton);
            this.add(restinfo);
        } else {
            parentFrame.randomRobot();
            this.humanaction(parentFrame.getTargetLabel());
            parentFrame.human_attack();
        }
        validate();
        repaint();
    }

    public void humanaction(Characterlabel target) {

        humanstat.setBackground(null);
        humanstat.setForeground(Color.white);
        humanstat.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 30));
        humanstat.setBounds(500, 60, 300, 40);
        humanstat.setText(activeCharacter.getname());
        humanstat.setVisible(true);

        humanaction.setBackground(null);
        humanaction.setForeground(Color.white);
        humanaction.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 30));
        humanaction.setBounds(500, 110, 300, 40);
        humanaction.setText(" is attack to ");
        humanaction.setVisible(true);

        targetstat.setBackground(null);
        targetstat.setForeground(Color.white);
        targetstat.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 30));
        targetstat.setBounds(500, 160, 300, 40);
        targetstat.setText(target.getOwner().getname());
        targetstat.setVisible(true);

        add(humanstat);
        add(humanaction);
        add(targetstat);
        repaint();
        parentFrame.repaint();
    }

    public void HideButton() {
        if (activeCharacter instanceof Robot) {
            remove(attackinfo);
            remove(attackButton);
            remove(skillinfo);
            remove(skillButton);
            remove(restinfo);
            remove(restButton);
        } else {
            remove(humanstat);
            remove(humanaction);
            remove(targetstat);
        }
        validate();
        repaint();
    }

}