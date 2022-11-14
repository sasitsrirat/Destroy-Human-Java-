package project3;

import java.util.ArrayList;

public class Humanwave{
    private ArrayList<Human> hu = new ArrayList<Human>();
    private Human hu1 ;
    private Human hu2;
    private Human hu3;

    public Humanwave(int stage, int wave){
        switch (stage) {
            case 1:
            switch (wave) {
                case 1:
                    stage1_1();
                    break;
                case 2:
                    stage1_2();
                    break;
                default:
                    break;
            }
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    public ArrayList<Human> gethu() {
        return hu;
    }

    public void stage1_1() {
        hu1 = new Human("kawin", 10, 2, 1, 14, 5);
        hu2 = new Human("kawin", 10, 2, 1, 14, 5);
        hu3 = new Human("kawin", 10, 2, 1, 14, 5);
       
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }
    
    public void stage1_2(){
        hu1 = new Human("kawin", 10, 2, 1, 14, 5);
        hu2 = new Human("kawin", 10, 2, 1, 14, 5);
        hu3 = new Human("kawin", 10, 2, 1, 14, 5);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }
}
