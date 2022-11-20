package project3;

public class Speed extends Thread {
    protected int maxspeed = 200;
    protected int currentspd = 0;
    protected Stageframe frame;
    protected Character owner;

    public Speed(int speed,Stageframe sf, Character c) {
        this.currentspd = speed;
        this.frame = sf;
        this.owner = c;
    }

    public void run() {
        int temp = 0;
        //if(this.isAlive())
        while (currentspd < maxspeed) {
            temp += this.currentspd;
            try {
                Thread.sleep(200);
            } catch (Exception e) {

            }
        }
        frame.setactiveLabel(owner);

    }
}