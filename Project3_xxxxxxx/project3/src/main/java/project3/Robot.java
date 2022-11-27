package project3;

import java.util.ArrayList;

class Robot extends Character {

    protected int ep = 1; //Energy Point
    protected int max_ep = 5;
    protected int cd_s = 0; //Cooldown Special Skill
    protected int cd_u = 0; //Cooldown Ultimate Skill
    protected Characterlabel robotlabel;
    protected String idle;

    public Robot() {
    }

    public Robot(String n, int hp, int atk, int def, int spd, int p, int cs, int cu, String imagefile, String attackimagefile, String deathimagefile, String id, Stageframe sf) {
        super(n, hp, atk, def, spd, imagefile, attackimagefile, deathimagefile, sf);
        ep = p;
        cd_s = cs;
        cd_u = cu;
        idle = id;
    }

    public String getidleimage() {
        return idle;
    }

    public void initiallabel(Characterlabel label) {
        robotlabel = label;
    }
    
    public int getep() {
        return ep;
    }

    public void gainep(int e) {
        ep = ep + e;
        if(ep >= max_ep) ep = max_ep;
    }

    public int getmax_ep() {
        return max_ep;
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
        super("Musix-6000", 20, 5, 1, 1, 3, 2, 5, "robot1-normal-01.png", "robot1-attack-01.png", "robot1-alive-01.png", "robot1-shake-01.png", sf);
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
        super("Ba-Be", 30, 3, 3, 1, 3, 2, 5, "robot2-normal-01.png" , "robot2-attack-01.png", "robot2-alive-01.png", "robot2-shake-01.png", sf);
    }

    @Override
    public void skill2(Character ally) {  //restore ally's hp
        ally.takeheal(ramdomatk() * 2);  // random atk คืออะไร
        ep = ep - 3;
    }
}

class Robot3 extends Robot {

    public Robot3(Stageframe sf) {
        super("N2Y2", 25, 4000, 2, 1, 3, 2, 5, "robot3-normal-01.png", "robot3-attack-01.png", "robot3-alive-01.png", "robot3-shake-01.png", sf) ;
    }
    @Override
    public void skill3(ArrayList<Human> enemies) { //attack all enemy
        for(Character e : enemies){
            int dmg = ramdomatk();
            dmg = dmg - e.getdf();
            if (dmg < 0) dmg = 0;
            e.takedamg(dmg);
        }
        ep = ep - 3;
    }
}
