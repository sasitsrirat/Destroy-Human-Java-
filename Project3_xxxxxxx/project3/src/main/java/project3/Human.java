package project3;

class Human extends Character{
    protected int skillrate = 0; // Skill use rate 0/10
    public Human(){}
    public Human(String n, int h, int a, int d, int s, int sr){
        super(n, h, a, d, s);
        skillrate = sr;
    }
    protected int checkskill(){
        if((int)(Math.random()*(10)+1) > skillrate){
            return 0;
        }
        else return 1;
    }
    
    public void attack(Robot robot){
        robot.takedamg(atk);
    }
    
}
