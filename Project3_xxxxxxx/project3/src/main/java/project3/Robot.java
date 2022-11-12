package project3;

import java.util.ArrayList;

class Robot extends Character{
    protected int ep = 0; //Energy Point
    protected int maxep = 10;
    protected int cd_s = 0; //Cooldown Special Skill
    protected int cd_u = 0; //Cooldown Ultimate Skill

    public Robot(){}
    public Robot(String n, int hp, int atk, int def, int spd, int p, int cs, int cu){
        super(n, hp, atk, def, spd);
        ep = p;
        cd_s = cs;
        cd_u = cu;
    }

    public void attack(Human human){
        int dmg = ramdomatk();
        human.takedamg(dmg);
    }

    @Override
    public void run(){

    }


    public void createRobot(ArrayList<Robot> ro){
        //Robot frontier = create1strobot();
        //Robot healer   = create2ndrobot();
        //Robot bomber   = create3rdrobot();

        //ro.add(frontier);
        //ro.add(healer);
        //ro.add(bomber);    
    }

    /*public Robot create1strobot(){
        
        Robot robot = new Robot("frontier",10,3,2,20,10,1,2); 
        
        return robot;
    }
    public Robot create2ndrobot(){
        
        Robot robot = new Robot("gix_the_fix",15,1,2,18,10,2,3); 
        
        return robot;
    }
    public Robot create3rdrobot(){
        
        Robot robot = new Robot("bombardier",10,3,2,20,10,2,3); 
        
        return robot;
    }*/
}

class Robot1 extends Robot{

    private String imagefile = "src/pictures/robot1.png";

    //Constructor กำหนดคุณลักษณะของ Robot1 
    public Robot1(String n, int hp, int atk, int def, int spd, int p, int cs, int cu){
        super(n, hp, atk,  def, spd,  p,  cs,  cu);
    } 

    
    

    
}
