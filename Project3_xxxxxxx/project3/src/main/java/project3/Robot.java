package project3;

class Robot extends Character{
    protected int sp = 0; //Stamina Point
    protected int[] cd = new int[3]; //Cooldown Skill

    public Robot(){}
    public Robot(String n, int h, int a, int d, int s, int p, int[] c){
        super(n, h, a, d, s);
        sp = p;
        System.arraycopy(c, 0, cd, 0, 3);
    }
}
