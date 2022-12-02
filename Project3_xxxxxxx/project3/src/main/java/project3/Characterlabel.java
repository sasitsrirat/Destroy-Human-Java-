package project3;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;
import java.awt.*;

public class Characterlabel extends JLabel {

    protected MyImageIcon staticon, attackicon, deathicon, idleicon, healicon;
    protected int curX, curY, width, height, position;
    protected String path;
    protected Stageframe parentFrame;
    protected StatLabel stat;
    protected Character owner;
    protected boolean death;

    public Characterlabel(String pathfile, int width, int height, Stageframe pf, StatLabel sl, Character c) {

        owner = c;
        owner.setLabel(this);
        this.width = width;
        this.height = height;
        path = pathfile;
        stat = sl;
        staticon = new MyImageIcon(path + owner.getimage()).resize(width, height);
        attackicon = new MyImageIcon(path + owner.getattackimage()).resize(width, height);
        if (owner instanceof Robot){
            Robot ro = (Robot)owner;
            idleicon = new MyImageIcon(path + ro.getidleimage()).resize(width, height);
        }
        if (owner instanceof Robot2){
            Robot2 r = (Robot2)owner;
            healicon = new MyImageIcon(path + r.gethealimage()).resize(width, height);
        }
        deathicon = new MyImageIcon(path + owner.getdeathimage()).resize(width, height);
        setIcon(staticon);
        setHorizontalAlignment(JLabel.CENTER);
        parentFrame = pf;
        position = owner.getposition();
        death = false;
        setposition();
        setVisible(true);
    }

    public void robotheal_animation() {
        Thread th = new Thread() {
            public void run() {
                parentFrame.setstagestate(4);
                setIcon(healicon);
                if (owner instanceof Robot) {
                    setBounds(curX + 50, curY, width, height);
                } else {
                    setBounds(curX - 50, curY, width, height);
                }
                parentFrame.repaint();
                validate();
                try {
                    Thread.currentThread();
                    Thread.sleep(650);
                } catch (Exception e) {
                    System.out.println(e);
                }
                setIcon(staticon);
                setBounds(curX, curY, width, height);
                parentFrame.repaint();
                validate();
            }
        };
        th.start();
    }

    public void attack_animation() {

        Thread th = new Thread() {
            public void run() {
                parentFrame.setstagestate(4);
                setIcon(attackicon);
                if (owner instanceof Robot) {
                    setBounds(curX + 50, curY, width, height);
                } else {
                    setBounds(curX - 50, curY, width, height);
                }
                parentFrame.repaint();
                validate();
                try {
                    Thread.currentThread();
                    Thread.sleep(650);
                } catch (Exception e) {
                    System.out.println(e);
                }
                setIcon(staticon);
                setBounds(curX, curY, width, height);
                parentFrame.repaint();
                validate();
            }
        };
        th.start();
    }

    public void rest_animation(Sound sound) {
        sound.playOnce();
        Thread th = new Thread() {
            public void run() {
                parentFrame.setstagestate(4);
                setIcon(idleicon);
                parentFrame.repaint();
                validate();
                try {
                    Thread.currentThread();
                    Thread.sleep(750);
                } catch (Exception e) {
                    System.out.println(e);
                }
                setIcon(staticon);
                parentFrame.repaint();
                validate();
                try {
                    Thread.currentThread();
                    Thread.sleep(750);
                } catch (Exception e) {
                    System.out.println(e);
                }
                setIcon(idleicon);
                parentFrame.repaint();
                validate();
                try {
                    Thread.currentThread();
                    Thread.sleep(750);
                } catch (Exception e) {
                    System.out.println(e);
                }
                setIcon(staticon);
                parentFrame.repaint();
                validate();
            }
        };
        th.start();
    }

    public void takedmg_animation(String effect, Sound sound) {
        if (death) {

        } else {
            sound.playOnce();
            JLabel effectLabel = new JLabel();
            ImageIcon imageIcon = new ImageIcon(path + effect);
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(width - 30, height - 30, Image.SCALE_DEFAULT));

            effectLabel.setIcon(imageIcon);
            effectLabel.setBounds(15, 15, width - 30, height - 30);
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
                        Thread.currentThread();
                        Thread.sleep(1750);
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
    }

    public void showdeath() {
        death = true;
        setIcon(deathicon);
        if (owner instanceof Human){
            curY = curY + 25;
            setBounds(curX, curY, width, height);
        }
    }

    public void setMoveConditions(int x, int y) {
        curX = x;
        curY = y;
        setBounds(curX, curY, width, height);
    }

    public int getcurX() {
        return curX;
    }

    public int getcurY() {
        return curY;
    }

    public void setposition() {
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
                setMoveConditions(parentFrame.getWidth() - 650, 240);
                break;
            case 5:
                setMoveConditions(parentFrame.getWidth() - 450, 240);
                break;
            case 6:
                setMoveConditions(parentFrame.getWidth() - 250, 240);
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
                temp.setBounds(curX, curY - 20, width, height);
                if (owner instanceof Robot) {
                    Robot a = (Robot) (owner);
                    stat.setRoRtext(owner.getatk(), owner.gethp(), owner.getmax_hp(),
                            owner.getdf(), owner.getname(), a.getep(), a.getmax_ep());
                } else {
                    stat.setHuRtext(owner.getatk(), owner.gethp(), owner.getmax_hp(),
                            owner.getdf(), owner.getname());
                }
                parentFrame.repaint();
                validate();
            }

            public void mouseExited(MouseEvent e) {
                temp.setBounds(curX, curY, width, height);
                parentFrame.repaint();
                validate();
            }

            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (death) {

                } else {
                    switch (parentFrame.getchoose()) {
                        case 1:
                            parentFrame.settargetLabel(temp);
                            parentFrame.robot_attack();
                            break;
                        case 2:
                            parentFrame.settargetLabel(temp);
                            parentFrame.action_robot1_skill();
                            break;
                        case 3:
                            parentFrame.settargetLabel(temp);
                            parentFrame.action_robot2_skill();
                        default:

                            break;
                    }
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
