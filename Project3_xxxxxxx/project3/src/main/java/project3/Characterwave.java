package project3;

import java.util.ArrayList;

public class Characterwave{
    private ArrayList<Character> cha;
    private Human hu1;
    private Human hu2;
    private Human hu3;

    

    public ArrayList<Character> getcha() {
        return cha;
    }

    public void stage1_1() {
        hu1 = new Human("kawin", 10, 2, 1, 14, 5);
        hu2 = new Human("kawin", 10, 2, 1, 14, 5);
        cha.add(hu1);
        cha.add(hu2);
    }
    
    public void stage1_2(){
        hu1 = new Human("kawin", 10, 2, 1, 14, 5);
        hu2 = new Human("kawin", 10, 2, 1, 14, 5);
        hu3 = new Human("kawin", 10, 2, 1, 14, 5);
        cha.add(hu1);
        cha.add(hu2);
        cha.add(hu3);
    }
}
