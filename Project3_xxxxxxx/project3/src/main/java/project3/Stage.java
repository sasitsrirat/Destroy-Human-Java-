package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public class Stage extends JFrame {

    protected String name = "";
    protected ArrayList<Robot> robot;
    protected ArrayList<ArrayList<Human>> humanwave;
    protected ArrayList<Character> all;
    //
    protected Random rand = new Random();
    protected int wave = 0;

    protected Stageframe me; // frame

    public Stage(String n, ArrayList<Robot> ro, ArrayList<ArrayList<Human>> hw) {
        name = n;
        robot = ro;
        humanwave = hw;
        wave = humanwave.size() - 1;
        this.battle();
    }

    public void Hello() { // stage story

    }

    public void battle() { // stage battle
        int i = 0;
        // all = new ArrayList<Character>();
        for (Robot r : robot) {
            // all.add(r);
            r.introduce();
        }
        for (Human h : humanwave.get(wave)) {
            // all.add(h);
            h.introduce();
        }
        while (i < 10) {
            /*
             * for (Character c : all) {
             * this.action(c);
             * }
             */
            for (Robot r : robot) {
                action_robot(r);
                for (int j = 0; j < humanwave.get(wave).size(); j++) { // check death here
                    if (humanwave.get(wave).get(j).checkdeath() == 1) {
                        System.out.printf("%s is death\n", humanwave.get(wave).get(j).getname());
                        humanwave.get(wave).remove(j);
                        j = j - 1;
                    }
                }
            }
            for (Human h : humanwave.get(wave)) {
                action_enemy(h);
                for (int j = 0; j < robot.size(); j++) {
                    if (humanwave.get(wave).get(j).checkdeath() == 1) {
                        System.out.printf("%s is death\n", humanwave.get(wave).get(j).getname());
                        humanwave.get(wave).remove(j);
                        j = j - 1;
                    }
                }
            }
            /*
             * /for (Robot r : robot) {
             * if (r.checkdeath() == 1) {
             * System.out.printf("%s is death\n", r.getname());
             * robot.remove(r);
             * }
             * }
             */
            /*
             * for(int j = 0; j < robot.size(); j++){
             * if (humanwave.get(wave).get(j).checkdeath() == 1) {
             * System.out.printf("%s is death\n", humanwave.get(wave).get(j).getname());
             * humanwave.get(wave).remove(j);
             * j = j-1;
             * }
             * }
             * for(int j = 0; j < humanwave.get(wave).size(); j++){
             * if (humanwave.get(wave).get(j).checkdeath() == 1) {
             * System.out.printf("%s is death\n", humanwave.get(wave).get(j).getname());
             * humanwave.get(wave).remove(j);
             * j = j-1;
             * }
             * }
             */
            System.out.printf("End round %d\n********************\n", i+1);
            // output from wave

            // run
            i++;
            if (robot.size() == 0 || humanwave.get(wave).size() == 0) {
                i = 10;
            }
        }
        wave += 1;
    }

    /*
     * public void action(Character cha) {
     * if (cha instanceof Robot) {
     * System.out.printf("Robot action\n");
     * action_robot((Robot) cha);
     * 
     * } else {
     * System.out.printf("Human action\n");
     * action_enemy((Human) cha);
     * }
     * }
     */

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
    }

    public void action_robot_skill(Robot ro) {
        System.out.printf("Enter 1 to use normal attack\n\n");
        Scanner scan = new Scanner(System.in);
        int choice_2 = scan.nextInt();
        switch (choice_2) {
            case 1: // choose normal attack
                int hu = chooseenemy();
                ro.attack(humanwave.get(wave).get(hu));
                System.out.printf("%s attack %s\n", ro.getname(), humanwave.get(wave).get(hu).getname());
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

    public void action_enemy(Human hu) { // Arraylist human,character

        System.out.printf("Human action\n");
        int a = rand.nextInt(robot.size());
        hu.attack(robot.get(a));
    }

    public int chooseenemy() {
        int i = 1;
        for (Human h : humanwave.get(wave)) {
            System.out.printf("%d. ", i);
            h.introduce();
            i++;
        }
        /*
         * for(Character a : all){
         * if(a instanceof Human){
         * System.out.printf("%d. ", i);
         * a.introduce();
         * i++;
         * }
         * }
         */
        Scanner scan = new Scanner(System.in);
        // show enemy
        int choice = scan.nextInt() - 1;
        return choice;
    }

}