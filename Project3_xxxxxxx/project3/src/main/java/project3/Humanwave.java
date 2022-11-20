package project3;

import java.util.ArrayList;

public class Humanwave{
    private ArrayList<Human> hu = new ArrayList<Human>();
    private Human hu1 ;
    private Human hu2;
    private Human hu3;
    private Stageframe frame;

    public Humanwave(int stage, int wave, Stageframe sf){
        frame = sf;
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
        hu1 = new Human_weak("kawin",frame);
        hu2 = new Human_weak("kong",frame);
        hu3 = new Human_fat("Rangsipan",frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }
    
    public void stage1_2(){
        hu1 = new Human_weak("kawin",frame);
        hu2 = new Human_weak("kong",frame);
        hu3 = new Human_weak("Rangsipan",frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }
}
