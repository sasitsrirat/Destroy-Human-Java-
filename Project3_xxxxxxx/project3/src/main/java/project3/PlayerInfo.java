package project3;

public class PlayerInfo implements Comparable<PlayerInfo>{
    private String name;
    private int score;
    private int stage;
    private boolean scoreboarddisplay = true; //default true
    private boolean resumeplaying = true; // default true


    public PlayerInfo(String name,int score,int stage,boolean display,boolean resume){
        this.name = name;
        this.resumeplaying = resume;
        this.stage = stage;
        this.score = score;
        this.scoreboarddisplay = display;
    }
    public String getname(){
        return name;
    }
    public int getscore(){
        return score;
    }
    public boolean getdisplay(){
        return scoreboarddisplay;
    }
    public boolean getresume(){
        return resumeplaying;
    }
    public int getstage(){
        return stage;
    }
    public int compareTo(PlayerInfo other){
        return 1;
    }
}
