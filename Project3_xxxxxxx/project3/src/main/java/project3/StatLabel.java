package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;

class StatLabel extends JLabel {

    protected MyImageIcon statusicon;
    protected int curX, curY, width, height;
    protected String imagepath;
    protected Stageframe parentFrame;
    protected Character activeCharacter;
    protected Border border;
    protected JLabel Latktext = new JLabel();
    ;
    protected JLabel Lhptext = new JLabel();
    protected JLabel Ldeftext = new JLabel();
    protected JLabel Lspdtext = new JLabel();
    protected JLabel Lnametext = new JLabel();
    protected JLabel Ratktext = new JLabel();
    ;
    protected JLabel Rhptext = new JLabel();
    protected JLabel Rdeftext = new JLabel();
    protected JLabel Rspdtext = new JLabel();
    protected JLabel Rnametext = new JLabel();
    protected JButton attackButton, skillButton, restButton;
    private JLabel panelpane;

    public StatLabel(String path, String filename, int width, int height, Stageframe pf) {

        imagepath = path;
        this.width = width;
        this.height = height;
        statusicon = new MyImageIcon(imagepath + filename).resize(width, height);
        setIcon(statusicon);
        setOpaque(true);
        setLayout(null);
        parentFrame = pf;
        setBounds(getVisibleRect());
        setVisible(true);

    }

    public void setactiveCharacter(Character ac) {
        activeCharacter = ac;
        setLtext(activeCharacter.getatk(), activeCharacter.gethp(), activeCharacter.getmax_hp(),activeCharacter.getdf(), activeCharacter.getname());
    }

    public void settargetCharacter(Character tc) {
        setRtext(tc.getatk(), tc.gethp(), tc.getmax_hp(),tc.getdf(), tc.getname());
    }

    public void setvisiblestatlabel(boolean n) {
        this.setVisible(n);
        validate();
    }

    public void setLtext(int atk, int hp, int max_hp, int def, String name) {
        Latktext.setText("ATK : " + Integer.toString(atk));
        Lhptext.setText("HP  : " + Integer.toString(hp) + "/ " + Integer.toString(max_hp));
        Ldeftext.setText("DEF : " + Integer.toString(def));
        Lnametext.setText("name : " + name);

        repaint();
        parentFrame.repaint();
    }

    public void setRtext(int atk, int hp, int max_hp, int def, String name) {
        Ratktext.setText("ATK : " + Integer.toString(atk));
        Rhptext.setText("HP  : " + Integer.toString(hp) + "/ " + Integer.toString(max_hp));
        Rdeftext.setText("DEF : " + Integer.toString(def));
        Rnametext.setText("name : " + name);

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

        Ratktext.setBackground(null);
        Ratktext.setForeground(Color.white);
        Ratktext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Ratktext.setBounds(parentFrame.getWidth() - 340, 40, 200, 30);

        Rhptext.setBackground(null);
        Rhptext.setForeground(Color.white);
        Rhptext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Rhptext.setBounds(parentFrame.getWidth() - 340, 70, 200, 30);

        Rdeftext.setBackground(null);
        Rdeftext.setForeground(Color.white);
        Rdeftext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Rdeftext.setBounds(parentFrame.getWidth() - 340, 100, 200, 30);

        Rnametext.setBackground(null);
        Rnametext.setForeground(Color.white);
        Rnametext.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
        Rnametext.setBounds(parentFrame.getWidth() - 340, 130, 200, 30);

        attackButton = new JButton(" Attack");
        {
            attackButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            attackButton.setBackground(new Color(222, 0, 62));
            attackButton.setForeground(Color.white);
            attackButton.setSize(100, 200);
            attackButton.setUI(new StyledButtonUI());
            attackButton.setForeground(new Color(255, 255, 255));
            attackButton.setBounds(500, 50, 150, 50);
            attackButton.setLayout(null);
            attackButton.setVisible(false);
            attackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // clickSound.playOnce();
                    parentFrame.robot_attack();
                }
            });
        }

        skillButton = new JButton(" Skill ");
        {
            skillButton.setFont(new Font("Copperplate Gothic BOLD", Font.PLAIN, 20));
            skillButton.setIcon(new MyImageIcon(imagepath + "skill_critical.png").resize(40, 40));
            skillButton.setBackground(new Color(222, 0, 62));
            skillButton.setForeground(Color.white);
            skillButton.setSize(100, 200);
            skillButton.setUI(new StyledButtonUI());
            skillButton.setForeground(new Color(255, 255, 255));
            skillButton.setBounds(500, 110, 150, 50);
            skillButton.setLayout(null);
            skillButton.setVisible(false);
            skillButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // clickSound.playOnce();

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
            restButton.setBounds(500, 170, 150, 50);
            restButton.setLayout(null);
            restButton.setVisible(false);
            restButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // clickSound.playOnce();

                }
            });
        }

        this.add(attackButton);
        this.add(skillButton);
        this.add(restButton);
        this.add(Latktext);
        this.add(Lhptext);
        this.add(Ldeftext);
        this.add(Lnametext);
        this.add(Ratktext);
        this.add(Rhptext);
        this.add(Rdeftext);
        this.add(Rnametext);

        validate();
        repaint();
    }

    public void ShowAction(Character ch) {
        if (ch instanceof Robot1) {
            attackButton.setVisible(true);
            skillButton.setVisible(true);
            attackButton.setIcon(new MyImageIcon(imagepath + "normalattack.png").resize(40, 40));
            restButton.setVisible(true);
        }
        validate();
        repaint();
    }

    public void HideButton() {
        attackButton.setVisible(false);
        skillButton.setVisible(false);
        restButton.setVisible(false);
    }

}
