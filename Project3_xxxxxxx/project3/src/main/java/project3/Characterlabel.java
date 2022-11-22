package project3;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;
import java.util.*;
import java.awt.*;

public class Characterlabel extends JLabel {

    protected MyImageIcon staticon, staticon2, attackicon;
    protected int curX, curY, width, height, position;
    protected String path;
    protected Stageframe parentFrame;
    protected StatLabel status;
    protected Character owner;

    public Characterlabel(String pathfile, int width, int height, Stageframe pf, StatLabel sl, Character c) {

        owner = c;
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

        Thread th = new Thread() {
            public void run() {
                parentFrame.setstagestate(4);
                setIcon(attackicon);
                parentFrame.repaint();
                validate();
                try {
                    Thread.currentThread().sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
                setIcon(staticon);
                parentFrame.repaint();
                validate();
            }

            /*
             * parentFrame.setstagestate(4);
             * setIcon(attackicon);
             * parentFrame.repaint();
             * validate();
             */

        };
        th.start();
    }

    public void takedmg_animation(String effect) {
        JLabel effectLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(path + effect);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        effectLabel.setIcon(imageIcon);
        effectLabel.setBounds(50, 50, 100, 100);
        effectLabel.setVisible(true);
        effectLabel.setHorizontalAlignment(JLabel.CENTER);
        effectLabel.setLayout(null);
        Characterlabel temp = this;
        temp.add(effectLabel);
                this.validate();
                repaint();
                parentFrame.repaint();
        Thread bruh = new Thread() {
            public void run() {
                try {
                    Thread.currentThread().sleep(1500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                effectLabel.setVisible(false);
                temp.remove(effectLabel);
                temp.revalidate();
                temp.repaint();
                parentFrame.repaint();
            }
        };
        bruh.start();

    }

    public void setMoveConditions(int x, int y) {
        curX = x;
        curY = y;
        setBounds(curX, curY, width, height);
    }

    public void setposition() {
        // position = po;
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
                if (parentFrame.getstagestate() != 4) {
                    setIcon(staticon2);
                    status.setRtext(owner.getatk(), owner.gethp(), owner.getmax_hp(), owner.getdf(), owner.getname());
                    parentFrame.repaint();
                    validate();
                }
            }

            public void mouseExited(MouseEvent e) {
                if (parentFrame.getstagestate() != 4) {
                    // System.out.println(parentFrame.getState());
                    setIcon(staticon);
                    // stat.setVisible(false);
                    parentFrame.repaint();
                    validate();
                }
            }

            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                switch (parentFrame.getchoose()) {
                    case 1:
                        parentFrame.settargetLabel(temp);
                        parentFrame.robot_attack();
                        break;
                    case 2:
                        parentFrame.settargetLabel(temp);
                        parentFrame.action_robot1_skill();
                        break;
                    default:
                        break;
                }
                    /*
                     * if (parentFrame.getstagenum() != 2) {
                     * parentFrame.stage2();
                     * parentFrame.setstagenum(2);
                     * } else {
                     * parentFrame.stage1();
                     * parentFrame.setstagenum(1);
                     * }
                     */
                
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
