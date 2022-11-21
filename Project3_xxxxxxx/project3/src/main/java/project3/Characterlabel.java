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

public class Characterlabel extends JLabel {

    protected MyImageIcon staticon, staticon2;
    protected int curX, curY, width, height, position;
    protected Stageframe parentFrame;
    protected StatLabel status;
    protected Character owner;

    public Characterlabel(String path, int width, int height, Stageframe pf, StatLabel sl, Character c) {

        owner =  c;
        owner.setLabel(this);
        this.width = width;
        this.height = height;
        status = sl;
        staticon = new MyImageIcon(path + owner.getimage()).resize(width, height);
        staticon2 = new MyImageIcon(path + "robot3.png").resize(width, height);
        setIcon(staticon);
        setHorizontalAlignment(JLabel.CENTER);
        parentFrame = pf;
        position = owner.getposition();
        setposition();
        setVisible(true);
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
                /*Character ex = new Character();
                for(int i = 0 ; i < parentFrame.gethumanArraylist().size(); i++){
                    if(position == parentFrame.gethumanArraylist().get(i).getposition()){
                        ex = parentFrame.gethumanArraylist().get(i);
                    }
                }
                for(int i = 0 ; i < parentFrame.getrobotArraylist().size(); i++){
                    if(position == parentFrame.getrobotArraylist().get(i).getposition()){
                        ex = parentFrame.getrobotArraylist().get(i);
                    }
                }
                status.setRtext(ex.getatk(), ex.gethp(), ex.getmax_hp(), ex.getdf(), ex.getname());*/
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
