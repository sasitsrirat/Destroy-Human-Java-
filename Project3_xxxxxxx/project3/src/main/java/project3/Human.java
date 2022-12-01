package project3;

class Human extends Character{ // Skill use rate 0/10
    protected Characterlabel humanlabel;

    public Human(){}
    public Human(String n, int h, int a, int d, String imagefile, String attackimagefile , String deathimagefile,Stageframe sf){
        super(n, h, a, d, imagefile,attackimagefile,deathimagefile,sf);
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
        super(n,23,4,1, "Mutanthuman.png", "Mutanthuman.png", "tomb.png", sf);
        //a
    }
}

class Human_fat extends Human{
    
    public Human_fat(String n, Stageframe sf){
        super(n,27,5,2, "repairman.png", "repairman.png", "tomb.png",sf);
    }
}

class Human_soldier extends Human{

    public Human_soldier(String n, Stageframe sf){
        super(n,32,4,3, "sd1.png", "sd1.png","tomb.png", sf);
    }
}

class Human_super extends Human{

    public Human_super(String n, Stageframe sf){
        super(n,40,6,4, "superhuman.png", "superhuman.png","tomb.png", sf);
    }
}
