package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;

public class Characterlabel extends JLabel {

    protected MyImageIcon staticon, staticon2, attackicon;
    protected int curX, curY, width, height, position;
    protected String path;
    protected Stageframe parentFrame;
    protected StatLabel status;
    protected Character owner;

    public Characterlabel(String pathfile, int width, int height, Stageframe pf, StatLabel sl, Character c) {

        owner =  c;
        owner.setLabel(this);
        this.width = width;
        this.height = height;
        path = pathfile;
        status = sl;
        staticon = new MyImageIcon(path + owner.getimage()).resize(width, height);
        staticon2 = new MyImageIcon(path + "robot3.png").resize(width, height);
        attackicon = new MyImageIcon(path + owner.getattackimage()).resize(width, height);
        setIcon(staticon);
        setHorizontalAlignment(JLabel.CENTER);
        parentFrame = pf;
        position = owner.getposition();
        
        setposition();
        
        setVisible(true);
    }

    public void attack_animation() {
        setIcon(attackicon);
        parentFrame.repaint();
                validate();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        setIcon(staticon);
        parentFrame.repaint();
                validate();
    }
    
    public void takedmg_animation(String effect){
        JLabel effectLabel = new JLabel();
        effectLabel.setIcon(new MyImageIcon(path + effect).resize(width, height));
        effectLabel.setBounds(50, 50, 50, 50);
        this.add(effectLabel);
        validate();
        repaint();
        parentFrame.repaint();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        this.remove(effectLabel);
        validate();
        repaint();
        parentFrame.repaint();
    }

    public void setMoveConditions(int x, int y) {
        curX = x;
        curY = y;
        setBounds(curX, curY, width, height);
    }

    public void setposition() {
        //position = po;
        switch (position) {
            case 1:
                setMoveConditions(50, 240);
                break;
            case 2:
                setMoveConditions(250, 240);
                break;
            case 3:
                setMoveConditions(450, 240);
                break;
            case 4:
                setMoveConditions(parentFrame.getWidth() - 250, 240);
                break;
            case 5:
                setMoveConditions(parentFrame.getWidth() - 450, 240);
                break;
            case 6:
                setMoveConditions(parentFrame.getWidth() - 650, 240);
                break;
            default:
                break;
        }
    }

    public void addFocus() {
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }

    public void addMouse() {
        Characterlabel temp = this;
        this.addMouseListener(new MouseInputListener() {
            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
                setIcon(staticon2);
                status.setRtext(owner.getatk(), owner.gethp(), owner.getmax_hp(), owner.getdf(), owner.getname());
                parentFrame.repaint();
                validate();
            }

            public void mouseExited(MouseEvent e) {
                setIcon(staticon);
                //stat.setVisible(false);
                parentFrame.repaint();
                validate();
            }

            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (parentFrame.getchoose() == true) {
                    parentFrame.settargetLabel(temp);
                    parentFrame.robot_attack();
                    /*if (parentFrame.getstagenum() != 2) {
                        parentFrame.stage2();
                        parentFrame.setstagenum(2);
                    } else {
                        parentFrame.stage1();
                        parentFrame.setstagenum(1);
                    }*/
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });
    }

    protected Character getOwner() {
        return owner;
    }

}
