package project3;

import java.util.ArrayList;

public class Stagewave {

    private ArrayList<Human> hu = new ArrayList<Human>();
    private ArrayList<Robot> ro = new ArrayList<Robot>();
    private Human hu1 ;
    private Human hu2;
    private Human hu3;
    private Robot ro1;
    private Robot ro2;
    private Robot ro3;
    private Stageframe frame;
    private int [] stagewave = {1,2,2,3,3};
    private int stage;
    

    public Stagewave(int s, Stageframe sf){
        stage = s;
        frame = sf;
    }

    public int getWave() {
        return stagewave[stage-1];
    }

    // Human //////////////////////////
    public void humanstage1_1() {
        hu1 = new Human_weak("kawin",frame);
        hu2 = new Human_weak("kong",frame);
        hu3 = new Human_fat("Eakky",frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }
    
    public void humanstage1_2(){
        hu1 = new Human_weak("kawin",frame);
        hu2 = new Human_weak("kong",frame);
        hu3 = new Human_weak("Eakky",frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public ArrayList<Human> gethu(int wave) {
        switch (stage) {
            case 1:
            switch (wave) {
                case 1:
                    humanstage1_1();
                    break;
                case 2:
                    humanstage1_2();
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
        
        return hu;
    }

    // Robot  ////////////////////////////
    public void robotstage1() {
        ro1 = new Robot1(frame);
        ro2 = new Robot2(frame);
        ro3 = new Robot3(frame);
        ro.add(ro1);
        ro.add(ro2);
        ro.add(ro3);
        ro1.setposition(3);
        ro2.setposition(2);
        ro3.setposition(1);
    }
    
    public void robotstage2(){
        ro1 = new Robot1(frame);
        ro2 = new Robot2(frame);
        ro.add(ro1);
        ro.add(ro2);
        ro1.setposition(3);
        ro2.setposition(2);
    }

    public ArrayList<Robot> getro() {
        switch (stage) {
            case 1:
                robotstage1();
                break;
            case 2:
                robotstage2();
                break;
            default:
                break;
        }
        return ro;
    }
}
