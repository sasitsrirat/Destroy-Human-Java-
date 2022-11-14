package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public class Stage extends JFrame {

    protected int num = 0;
    protected ArrayList<Robot> robot;
    protected ArrayList<Human> human;
    protected Random rand = new Random();
    protected int wave = 0;
    protected Stageframe me; // frame

    public Stage(int n, int w) {
        num = n;
        wave = w;
        Robotwave ally = new Robotwave(n);
        robot = ally.getro();
        for (int index = 0; index < wave; index++) {
            Humanwave enemy = new Humanwave(num, index + 1);
            human = enemy.gethu();
            this.battle();
        }
    }
    
    public void Hello() { // stage story

    }

    public void battle() { // stage battle
        int i = 0;
        for (Robot r : robot) {
            r.introduce();
        }
        for (Human h : human) {
            h.introduce();
        }
        while (i < 10) {
            for (Robot r : robot) {
                action_robot(r);
                checkdeath();
            }
            for (Human h : human) {
                action_enemy(h);
                checkdeath();
            } 
            checkdeath();
            System.out.printf("End round %d\n********************\n\n", i + 1);
            // output from wave

            // run
            i++;
            if (robot.size() == 0 || human.size() == 0) {
                i = 10;
            }
        }
    }

    public void checkdeath() {
        for (int j = 0; j < human.size(); j++) { // check death here
            if (human.get(j).checkdeath() == 1) {
                System.out.printf("%s is death\n", human.get(j).getname());
                human.remove(j);
                j = j - 1;
            }
        }
        for (int j = 0; j < robot.size(); j++) {
            if (robot.get(j).checkdeath() == 1) {
                System.out.printf("%s is death\n", robot.get(j).getname());
                robot.remove(j);
                j = j - 1;
            }
        }
    }

    public void action_robot(Robot ro) { // Arraylist robot,character
        System.out.printf("Robot action\n");
        // show choice
        System.out.printf("Enter 1 to use skill\n\n");
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (Exception e) {
        }
        switch (choice) {
            case 1: // choose skill
                action_robot_skill(ro);
                break;
            case 2: // item use jcheckbox

                break;
            case 3: // choose rest

            default:
                break;
        }
        //System.out.print(robot.size());
    }

    public void action_robot_skill(Robot ro) {
        System.out.printf("Enter 1 to use normal attack\n\n");
        Scanner scan = new Scanner(System.in);
        int choice_2 = scan.nextInt();
        switch (choice_2) {
            case 1: // choose normal attack
                int h = chooseenemy();
                ro.attack(human.get(h));
                System.out.printf("%s attack %s\n", ro.getname(), human.get(h).getname());
                break;
            case 2: // special skill

                break;
            case 3: // ultimate skill

                break;
            default:
                action_robot(ro);
                break;
        }
    }

    public void action_enemy(Human h) { // Arraylist human,character
        int size = robot.size();
        if(size==0){
        System.out.printf("Human action\n");
        
        int a = rand.nextInt(size);
        h.attack(robot.get(a));
        }
    }

    public int chooseenemy() {
        int i = 1;
        for (Human h : human) {
            System.out.printf("%d. ", i);
            h.introduce();
            i++;
        }
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt() - 1;
        return choice;
    }
}