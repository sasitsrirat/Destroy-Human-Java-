package project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public class Action extends Stage {

    public Action(String n, ArrayList<Robot> ro, ArrayList<ArrayList<Human>> hw) {
        super(n, ro, hw);
    }

    public void action(Character cha) {
        //ตรวจสอบว่า object ถูกสร้างมาจาก class หรือไม่
        if (cha instanceof Robot) { 
            action_robot((Robot) cha);
        } else {
            action_enemy((Human) cha);
        }
    }

    public void action_robot(Robot ro) { // Arraylist robot,character
        //
    }

    public void action_enemy(Human hu) { // Arraylist robot,character
        //

    }
}