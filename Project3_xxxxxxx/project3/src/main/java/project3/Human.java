package project3;

class Human extends Character{
    protected int skillrate = 0; // Skill use rate 0/10
    protected Characterlabel humanlabel;

    public Human(){}
    public Human(String n, int h, int a, int d, int s, int sr, String imagefile, String attackimagefile , String deathimagefile,Stageframe sf){
        super(n, h, a, d, s, imagefile,attackimagefile,deathimagefile,sf);
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

    public Human_weak(String n, Stageframe sf){
        super(n,15,3,1,1,0, "Mutanthuman.png", "Mutanthuman.png", "robot4.png", sf);
        //a
    }
}

class Human_fat extends Human{
    
    public Human_fat(String n, Stageframe sf){
        super(n,25,3,2,1,0, "repairman.png", "repairman.png", "robot4.png",sf);
    }
}

class Human_soldier extends Human{

    public Human_soldier(String n, Stageframe sf){
        super(n,30,2,3,1,2, "sd1.png", "sd1.png","robot4.png", sf);
    }
}
