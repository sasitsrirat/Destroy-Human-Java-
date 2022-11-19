package project3;

class Human extends Character{
    protected int skillrate = 0; // Skill use rate 0/10
    protected Characterlabel humanlabel;
    protected String imagefile;

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
        int dmg = ramdomatk();
        robot.takedamg(dmg);
    }
    public void initiallabel(Characterlabel label){
        humanlabel = label;
    }
    
    public String getimage(){
        return imagefile;
    }

    
        
    @Override
    public void run(){

    }
}

class Human1 extends Human{
    private String imagefile = "robot1-attack-01.png";

    public Human1(String name,int hp,int atk,int def,int spd,int sr){
        super(name,hp,atk,def,spd,sr);
    }
    @Override
    public String getimage(){
        return this.imagefile;
    }
}

class Human2 extends Human{
    private String imagefile = "robot3-attack-01.png";

    public Human2(String name,int hp,int atk,int def,int spd,int sr){
        super(name,hp,atk,def,spd,sr);
    }
    @Override
    public String getimage(){
        return this.imagefile;
    }
}

class Human3 extends Human{
    private String imagefile = "robot3-attack-01.png";

    public Human3(String name,int hp,int atk,int def,int spd,int sr){
        super(name,hp,atk,def,spd,sr);
    }
    @Override
    public String getimage(){
        return this.imagefile;
    }
}
