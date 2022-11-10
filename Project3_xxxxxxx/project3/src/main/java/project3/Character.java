package project3;

public class Character extends Thread{
    String name = "";
    protected int max_hp = 0; // Max Health Point
    protected int hp = 0; // Health Point
    protected int atk = 0; // Attack Point
    protected int def = 0; // Defense Point
    protected int spd = 0; // Speed Point
    protected int position; // will be set in another 

    public Character() {
    }

    public Character(String n, int h, int a, int d, int s) {
        name = n;
        hp = h;
        max_hp = h;
        atk = a;
        def = d;
        spd = s;
    }

    protected int ramdomatk(){
        int max = atk + 3;
        int min = atk - 3;
        if(min < 0) min = 0;
        int newatk = (int)(Math.random()*(max-min+1)+min); 
        return newatk;
    }

    protected int takedamg(int dam) {
        dam = dam - def;
        hp = hp - dam;
        if (hp < 0) {
            hp = 0;
        }
        return dam; // Return for report on screen
    }

    protected int takeheal(int heal) { // รับฟื้นฟูhp
        if (heal + hp > max_hp) {
            heal = max_hp - hp;
            hp = max_hp;
        } else
            hp = hp + heal;
        return heal; // Return for report on screen
    }

    protected int checkdeath() {
        if (hp <= 0) {
            return 1;
        } else
            return 0;
    }

    public String getname() {
        return name;
    }

    public int gethp() {
        return hp;
    }

    public int getdf() {
        return def;
    }

    public int getatk() {
        return atk;
    }

    public int getspd() {
        return spd;
    }

    public void setposition(){
        
    }

}