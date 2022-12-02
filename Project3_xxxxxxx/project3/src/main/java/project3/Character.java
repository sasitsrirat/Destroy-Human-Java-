package project3;

import java.util.ArrayList;

public class Character{

    String name = "";
    protected int max_hp = 0; // Max Health Point
    protected int hp = 0; // Health Point
    protected int atk = 0; // Attack Point
    protected int def = 0; // Defense Point
    protected int position; // will be set in another
    protected int maxspeed = 3000;
    protected String imagefile, attackimagefile, deathimagefile;
    protected Characterlabel CLabel;
    private Speed speedthread;
    private Stageframe frame;
    private boolean threaddead;

    public Character() {
    }

    public Character(String n, int h, int a, int d, String i, String ai, String di, Stageframe sf) {
        name = n;
        hp = h;
        max_hp = h;
        atk = a;
        def = d;
        imagefile = i;
        attackimagefile = ai;
        deathimagefile = di;
        frame = sf;
        speedthread = new Speed(frame, this);
        threaddead = false;
    }
    public void setthreaddead(boolean n){
        threaddead = n;
    }
    public boolean getthreaddead(){
        return threaddead;
    }
    public void setnewspeedthread(){
        speedthread = new Speed(frame,this);
    }
    public Speed getspeedthread(){
        return speedthread;
    }
    public void setspeedthread() {
        if (!speedthread.isAlive()) {
            speedthread = new Speed(frame, this);
        }
    }

    public void checkthread() {
        
    }

    public void setLabel(Characterlabel CL) {
        CLabel = CL;
    }

    public Characterlabel getLabel() {
        return CLabel;
    }

    protected int ramdomatk() {
        int max = atk + 1;
        int min = atk - 1;
        if (min < 0) {
            min = 0;
        }
        int newatk = (int) (Math.random() * (max - min + 1) + min);
        return newatk;
    }

    protected void takedamg(int dam) {
        hp = hp - dam;

        if (hp <= 0) {
            hp = 0;
        }
    }

    protected int takeheal(int heal) {
        if (heal + hp > max_hp) {
            heal = max_hp - hp;
            hp = max_hp;
        } else {
            hp = hp + heal;
        }
        return heal;
    }

    protected int checkdeath() {
        if (hp <= 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void attack(Character enemy) {
        int dmg = ramdomatk();
        dmg = dmg - enemy.getdf();
        if (dmg < 0) dmg = 0;
        enemy.takedamg(dmg);
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

    public void setposition(int po) {
        position = po;
    }

    public int getposition() {
        return position;
    }

    public String getimage() {
        return imagefile;
    }
    
    public String getattackimage() {
        return attackimagefile;
    }

    public String getdeathimage(){
        return deathimagefile;
    }

    public void skill1(Character enemy) {}
    public void skill2(Character ally) {}
    public void skill3(ArrayList<Human> enemies) {}
}
