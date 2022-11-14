package project3;

import java.util.ArrayList;

public class Robotwave{
    private ArrayList<Robot> ro = new ArrayList<Robot>();
    private Robot ro1;
    private Robot ro2;
    private Robot ro3;
    // Im back
    public Robotwave(int stage){
        switch (stage) {
            case 1:
                stage1();
                break;
            case 2:
                stage2();
                break;
            default:
                break;
        }
    }

    public ArrayList<Robot> getro() {
        return ro;
    }

    public void stage1() {
        ro1 = new Robot1("Musix-6000", 1, 1, 1, 1, 1, 1, 1);
        ro.add(ro1);
    }
    
    public void stage2(){
        ro1 = new Robot1("Musix-6000", 1, 1, 1, 1, 1, 1, 1);
        ro2 = new Robot1("BA-BE", 1, 1, 1, 1, 1, 1, 1);
        ro.add(ro1);
        ro.add(ro2);
    }
}
