package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public class Action extends Stage{

    public Action(String n, ArrayList<Robot> ro, ArrayList<ArrayList<Human>> hw){
        super(n,ro,hw);
    }

    public void action (Character cha){
        if(cha instanceof Robot){
            action_robot((Robot)cha);
        }
        else{
            action_enemy((Human)cha);
        }
    }

    public void action_robot(Robot ro){ // Array;ist robot,character
        //
    }
    
    public void action_enemy(Human hu){ // Array;ist robot,character
        //
        
    }
}