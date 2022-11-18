package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public final class App {

    public static void main(String[] args) {
        //displayJFrame();
        try {
            //Introframe introframe = new Introframe();
            //introframe.setVisible(true);
            MainMenu frame = new MainMenu();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
