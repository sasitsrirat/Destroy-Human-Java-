package project3;

import java.util.ArrayList;

class Robot extends Character {

    protected int ep = 0; //Energy Point
    protected int maxep = 10;
    protected int cd_s = 0; //Cooldown Special Skill
    protected int cd_u = 0; //Cooldown Ultimate Skill
    protected Characterlabel robotlabel;

    public Robot() {
    }

    public Robot(String n, int hp, int atk, int def, int spd, int p, int cs, int cu, String imagefile) {
        super(n, hp, atk, def, spd, imagefile);
        ep = p;
        cd_s = cs;
        cd_u = cu;

    }

    public void initiallabel(Characterlabel label) {
        robotlabel = label;
    }

    public String getimage() {
        return imagefile;
    }

    @Override
    public void run() {

    }

    public void createRobot(ArrayList<Robot> ro) {
        //Robot frontier = create1strobot();
        //Robot healer   = create2ndrobot();
        //Robot bomber   = create3rdrobot();

        //ro.add(frontier);
        //ro.add(healer);
        //ro.add(bomber);    
    }
}

class Robot1 extends Robot {

    public Robot1() {
        super("Musix-6000", 20, 500, 1, 1, 3, 2, 5, "robot1-normal-01.png");
    }
}

class Robot2 extends Robot {

    public Robot2() {
        super("Ba-Be", 50, 1, 3, 1, 3, 2, 5, "robot2.png");
    }
}

class Robot3 extends Robot {

    public Robot3() {
        super("N2Y2", 30, 2, 2, 1, 3, 2, 5, "robot2.png");
    }
}
