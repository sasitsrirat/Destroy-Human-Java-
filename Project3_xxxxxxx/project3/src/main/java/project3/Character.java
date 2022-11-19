package project3;

public class Character extends Thread implements Comparable<Character>{
    String name = "";
    protected int max_hp = 0; // Max Health Point
    protected int hp = 0; // Health Point
    protected int atk = 0; // Attack Point
    protected int def = 0; // Defense Point
    protected int spd = 0; // Speed Point
    protected int position; // will be set in another
    protected int maxspeed = 3000;
    protected Characterlabel CLabel;

    // protected Speed speedthread;

    public Character() {
    }

    public Character(String n, int h, int a, int d, int s) {
        name = n;
        hp = h;
        max_hp = h;
        atk = a;
        def = d;
        spd = s;
        // speedthread = new Speed(spd);
    }

    public void setLabel(Characterlabel CL){
        CLabel = CL;
    }

    public Characterlabel getLabel(){
        return CLabel;
    }

    // Ramdom attack
    protected int ramdomatk() {
        int max = atk + 3;
        int min = atk - 3;
        if (min < 0) {
            min = 0;
        }
        int newatk = (int) (Math.random() * (max - min + 1) + min);
        return newatk;
    }

    // Take damage
    protected int takedamg(int dam) {
        if (dam >= def) {
            dam = dam - def;
        } else {
            dam = 0;
        }

        hp = hp - dam;

        if (hp <= 0) {
            hp = 0;
        }
        return dam; // Return for report on screen
    }

    // Take heal
    protected int takeheal(int heal) { // รับฟื้นฟูhp
        if (heal + hp > max_hp) {
            heal = max_hp - hp;
            hp = max_hp;
        } else
            hp = hp + heal;
        return heal; // Return for report on screen
    }

    // Check Death
    protected int checkdeath() {
        if (hp <= 0) {
            return 1;
        } else
            return 0;
    }

    // characterize the character
    public void introduce() {
        System.out.printf("%s %d/%d \n", name, hp, max_hp);
    }

    public String getname() {
        return name;
    }

    public int gethp() {
        return hp;
    }

    public int getmax_hp() {
        return max_hp;
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

    public void setposition(int po) {
        position = po;
    }

    public int getposition() {
        return position;
    }

    public void run() {

    }
    @Override
    public int compareTo(Character other) {
        if (this.spd > other.spd) {
            return -1;
        } else
            return 1;
    }

    

}