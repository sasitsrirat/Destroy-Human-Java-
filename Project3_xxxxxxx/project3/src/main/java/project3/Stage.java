package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public class Stage extends JFrame{
    
    protected String name = "";
    protected ArrayList<Robot> robot;
    protected ArrayList<ArrayList<Human>> humanwave;
    protected int maxspeed = 3000 ; // 
    protected Random rand = new Random();
    protected int wave = 0;
    

    protected Stageframe me; // frame

    public Stage(String n, ArrayList<Robot> ro, ArrayList<ArrayList<Human>> hw){
        name = n;
        robot = ro;
        humanwave = hw;
    }

    public void Hello (){ // stage story
        
    }

    public void battle (){ // stage battle
        ArrayList<Character> all = new ArrayList<Character>();
        for (Robot r: robot){
            all.add(r);
        }
        ArrayList<Human> human = humanwave.get(wave);
        for (Human h: human){
            all.add(h);
        }
        for (Character c: all){
            this.action(c);
        }
        
        //output from wave

        //run
        wave += 1;
    }

    public void action (Character cha){
        if(cha instanceof Robot){
            action_robot((Robot)cha);
        }
        else{
            action_enemy((Human)cha);
        }
    }

    public void action_robot(Robot ro){ // Arraylist robot,character
        //show choice
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        try{
            choice = scan.nextInt();
        }catch(Exception e){            
        }
        switch (choice){
            case 1: //choose normal attack 
                int hu = chooseenemy() ;
                ro.attack(humanwave.get(wave).get(hu));
                break ;
            case 2: break ;
            default:break ;
        }
    }
    
    public void action_enemy(Human hu){ // Arraylist human,character 
        
        int a = rand.nextInt(robot.size());
        hu.attack(robot.get(a));
        /*int dmg = hu.ramdomatk();
        robot.get(a).takedamg(dmg);*/
        
    }

    public int chooseenemy(){
        Scanner scan = new Scanner(System.in);
        //show enemy
        int choice = 0;
        return choice;
    }
    
}