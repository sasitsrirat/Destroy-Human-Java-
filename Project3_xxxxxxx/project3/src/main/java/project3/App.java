package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.printf("Hello World!\nI am Kawin Sudloh\n");

        ArrayList<Robot> robot = new ArrayList<Robot>(); 
        robot.add(new Robot("KawinSudloh", 500, 50, 50, 50, 50, 50, 50));
        ArrayList<ArrayList <Human>> humanwave = new ArrayList<ArrayList <Human>>(); 
        ArrayList<Human> human = new ArrayList<Human>(); 
        human.add(new Human("Kong_1", 10, 1, 1, 1, 1));
        human.add(new Human("Kong_2", 20, 1, 1,10, 1));
        humanwave.add(human);
        new Stage("1", robot, humanwave);

        // Don't delete
        /*ArrayList<ArrayList <Integer>> a = new ArrayList<ArrayList<Integer>>(5);
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        b.add(1);
        b.add(2);
        c.add(3);
        c.add(4);

        a.add(b);
        a.add(c);

        
            
            System.out.printf("%d %d\n",b.get(0) , b.get(1));
            
            a.get(0).remove(0);

        System.out.printf("%d \n",b.get(0));*/
        /*i = a.get(1);   
            for(int j : c){
                i.add(j);
            }*/
        //Don't delete
}
}
