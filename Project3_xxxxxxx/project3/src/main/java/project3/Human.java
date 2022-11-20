package project3;

class Human extends Character{
    protected int skillrate = 0; // Skill use rate 0/10
    protected Characterlabel humanlabel;

    public Human(){}
    public Human(String n, int h, int a, int d, int s, int sr, String imagefile){
        super(n, h, a, d, s, imagefile);
        skillrate = sr;
    }
    protected int checkskill(){
        if((int)(Math.random()*(10)+1) > skillrate){
            return 0;
        }
        else return 1;
    }
    
    public void attack(Robot robot){
        int dmg = ramdomatk();
        robot.takedamg(dmg);
    }
    public void initiallabel(Characterlabel label){
        humanlabel = label;
    }
    
    @Override
    public void run(){

    }
}

class Human_weak extends Human{

    public Human_weak(String n){
        super(n,15,1,1,1,0, "Mutanthuman.png");
    }
}

class Human_fat extends Human{
    
    public Human_fat(String n){
        super(n,25,1,2,1,0, "repairman.png");
    }
}

class Human_soldier extends Human{

    public Human_soldier(String n){
        super(n,30,2,3,1,2, "sd1.png");
    }
}
