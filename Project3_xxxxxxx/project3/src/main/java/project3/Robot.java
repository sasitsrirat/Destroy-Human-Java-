package project3;

class Robot extends Character{
    protected int ep = 0; //Energy Point
    protected int[] cd = new int[3]; //Cooldown Skill

    public Robot(){}
    public Robot(String n, int h, int a, int d, int s, int p, int[] c){
        super(n, h, a, d, s);
        ep = p;
        System.arraycopy(c, 0, cd, 0, 3);
    }

    public void attack(Human human){
        human.takedamg(atk);
    }
}
