package project3;

import java.util.ArrayList;

public class Stagewave {

    private ArrayList<Human> hu = new ArrayList<Human>();
    private ArrayList<Robot> ro = new ArrayList<Robot>();
    private Human hu1;
    private Human hu2;
    private Human hu3;
    private Robot ro1;
    private Robot ro2;
    private Robot ro3;
    private Stageframe frame;
    private int[] stagewave = { 1, 2, 2, 3, 3 };
    private int stage;

    public Stagewave(int s, Stageframe sf) {
        stage = s;
        frame = sf;
    }

    public int getWave() {
        return stagewave[stage - 1];
    }

    // Human //////////////////////////
    public void humanstage1_1() {
        hu1 = new Human_weak("kawin", frame);
        hu2 = new Human_weak("kong", frame);
        hu3 = new Human_fat("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage2_1() {
        hu1 = new Human_fat("kawin", frame);
        hu2 = new Human_fat("kong", frame);
        hu3 = new Human_weak("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage2_2() {
        hu1 = new Human_fat("kawin", frame);
        hu2 = new Human_fat("kong", frame);
        hu3 = new Human_fat("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage3_1() {
        hu1 = new Human_fat("kawin", frame);
        hu2 = new Human_fat("kong", frame);
        hu3 = new Human_soldier("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage3_2() {
        hu1 = new Human_fat("kawin", frame);
        hu2 = new Human_fat("kong", frame);
        hu3 = new Human_soldier("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage4_1() {
        hu1 = new Human_fat("kawin", frame);
        hu2 = new Human_fat("kong", frame);
        hu3 = new Human_soldier("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage4_2() {
        hu1 = new Human_fat("kawin", frame);
        hu2 = new Human_soldier("kong", frame);
        hu3 = new Human_soldier("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage4_3() {
        hu1 = new Human_fat("kawin", frame);
        hu2 = new Human_soldier("kong", frame);
        hu3 = new Human_soldier("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage5_1() {
        hu1 = new Human_soldier("kawin", frame);
        hu2 = new Human_soldier("kong", frame);
        hu3 = new Human_super("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage5_2() {
        hu1 = new Human_soldier("kawin", frame);
        hu2 = new Human_super("kong", frame);
        hu3 = new Human_super("Eakky", frame);
        hu1.setposition(4);
        hu2.setposition(5);
        hu3.setposition(6);
        hu.add(hu1);
        hu.add(hu2);
        hu.add(hu3);
    }

    public void humanstage5_3() {
        hu1 = new Human_super("kawin", frame);
        hu2 = new Human_super("kong", frame);
        hu3 = new Human_super("Eakky", frame);
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
                    default:
                        break;
                }
                break;
            case 2:
                switch (wave) {
                    case 1:
                        humanstage2_1();
                        break;
                    case 2:
                        humanstage2_2();
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (wave) {
                    case 1:
                        humanstage3_1();
                        break;
                    case 2:
                        humanstage3_2();
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                switch (wave) {
                    case 1:
                        humanstage4_1();
                        break;
                    case 2:
                        humanstage4_2();
                        break;
                    case 3:
                        humanstage4_3();
                    default:
                        break;
                }
                break;
            case 5:
                switch (wave) {
                    case 1:
                        humanstage5_1();
                        break;
                    case 2:
                        humanstage5_2();
                        break;
                    case 3:
                        humanstage5_3();
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        return hu;
    }

    // Robot ////////////////////////////
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

    public void robotstage2() {
        ro1 = new Robot1(frame);
        // ro2 = new Robot2(frame);
        ro3 = new Robot3(frame);
        ro.add(ro1);
        // ro.add(ro2);
        ro.add(ro3);
        ro1.setposition(3);
        // ro2.setposition(2);
        ro3.setposition(1);

    }

    public void robotstage3() {
       // ro1 = new Robot1(frame);
        //ro2 = new Robot2(frame);
        ro3 = new Robot3(frame);
        //ro.add(ro1);
        //ro.add(ro2);
        ro.add(ro3);
        //ro1.setposition(3);
       // ro2.setposition(2);
        ro3.setposition(1);
    }

    public void robotstage4() {
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

    public void robotstage5() {
        ro1 = new Robot1(frame);
        //ro2 = new Robot2(frame);
        ro3 = new Robot3(frame);
        ro.add(ro1);
       // ro.add(ro2);
        ro.add(ro3);
        ro1.setposition(3);
       // ro2.setposition(2);
        ro3.setposition(1);
    }

    public ArrayList<Robot> getro() {
        switch (stage) {
            case 1:
                robotstage1();
                break;
            case 2:
                robotstage2();
                break;
            case 3:
                robotstage3();
                break;
            case 4:
                robotstage4();
                break;
            case 5:
                robotstage5();
                break;
            default:
                break;
        }
        return ro;
    }
}
