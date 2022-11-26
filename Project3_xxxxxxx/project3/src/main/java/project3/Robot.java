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

    public Robot(String n, int hp, int atk, int def, int spd, int p, int cs, int cu, String imagefile, String attackimagefile, String deathimagefile, Stageframe sf) {
        super(n, hp, atk, def, spd, imagefile, attackimagefile, deathimagefile, sf);
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
    public void skill1(Character enemy) {}
    @Override
    public void skill2(Character ally) {}
    @Override
    public void skill3(ArrayList<Human> enemies) {}
}

class Robot1 extends Robot {

    public Robot1(Stageframe sf) {
        super("Musix-6000", 20, 10, 1, 1, 3, 2, 5, "robot1-normal-01.png", "robot1-attack-01.png", "robot1-alive-01.png", sf);
    }

    @Override
    public void skill1(Character enemy) { //deal a huge damage by don't care the enemy def
        int dmg = ramdomatk() * 2;
        enemy.takedamg(dmg);
        ep = ep - 3;
    }
}

class Robot2 extends Robot {

    public Robot2(Stageframe sf) {
        super("Ba-Be", 30, 4, 3, 1, 3, 2, 5, "robot2-normal-01.png" , "robot2-attack-01.png", "robot2-alive-01.png", sf);
    }

    @Override
    public void skill2(Character ally) {  //restore ally's hp
        int a = ally.takeheal(ramdomatk() * 3);  // random atk คืออะไร
        ep = ep - 3;
    }
}

class Robot3 extends Robot {

    public Robot3(Stageframe sf) {
        super("N2Y2", 25, 5000, 2, 1, 3, 2, 5, "robot3-normal-01.png", "robot3-attack-01.png", "robot3-alive-01.png", sf) ;
    }
    @Override
    public void skill3(ArrayList<Human> enemies) { //attack all enemy
        for(Character e : enemies){
            int dmg = ramdomatk();
            dmg = dmg - e.getdf();
            if (dmg < 0) dmg = 0;
            e.takedamg(dmg);
        }
    }
}
