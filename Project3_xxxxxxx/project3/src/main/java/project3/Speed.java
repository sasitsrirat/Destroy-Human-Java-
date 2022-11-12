package project3;

public class Speed extends Thread {
    protected int maxspeed = 200;
    protected int currentspd = 0;

    public Speed(int speed) {
        this.currentspd = speed;
    }

    public void run() {
        int temp = 0;
        while (currentspd < maxspeed) {
            temp += this.currentspd;
            try {
                Thread.sleep(200);
            } catch (Exception e) {

            }

        }
    }

}
