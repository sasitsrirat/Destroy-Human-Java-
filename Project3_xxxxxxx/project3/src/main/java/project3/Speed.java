package project3;

public class Speed extends Thread {
    protected int maxspeed = 2000000;
    protected int currentspd = 0;
    protected Stageframe frame;
    protected Character owner;

    public Speed(Stageframe sf, Character c) {
        this.frame = sf;
        this.owner = c;
    }

    public void run() {
        while (currentspd < maxspeed) {
            currentspd++;
            try {
            } catch (Exception e) {
                
            }
        }
        frame.setactiveLabel(owner);
        owner.setthreaddead(true);
    }
}