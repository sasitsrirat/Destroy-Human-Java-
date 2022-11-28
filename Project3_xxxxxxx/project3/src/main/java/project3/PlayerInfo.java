package project3;

public class PlayerInfo implements Comparable<PlayerInfo>{
    private String name;
    private int score1=0,score2=0,score3=0,score4=0,score5=0;
    private int stage = 1;
    private boolean scoreboarddisplay = true; //default true
    private boolean Autosave = true; // default true
    private boolean watchstory = true; // default true


    public PlayerInfo(String name,int stage,int score1,int score2,int score3,int score4,int score5,boolean display,boolean save,boolean story){
        this.name = name;
        this.Autosave = save;
        this.stage = stage;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
        this.scoreboarddisplay = display;
        this.watchstory = story;

    }
    public String getname(){
        return name;
    }
    public int getscore(int s){
        
        switch(s){
            case 1: return score1;
            case 2: return score2;
            case 3: return score3; 
            case 4: return score4;
            case 5: return score5; 
        }
        return 0;
    }
    public boolean getdisplay(){
        return scoreboarddisplay;
    }
    public boolean getAutosave(){
        return Autosave;
    }
    public boolean getshowstory(){
        return watchstory;
    }

    public int getstage(){
        return stage;
    }
    public void setname(String n){
        name = n;
    }
    public void setscore(int score,int stage){
        switch(stage){
            case 1:  score1=score; break;
            case 2:  score2=score; break;
            case 3:  score3=score; break;
            case 4:  score4=score; break;
            case 5:  score5=score; break;
        }
    }
    public void setdisplay(boolean d){
        scoreboarddisplay = d;
    }
    public void setAutosave(boolean save){
        Autosave = save;
    }
    public void setshowstory(boolean s){
        watchstory = s;
    }
    public void setstage(int s){
        stage = s;
    }
    public int compareTo(PlayerInfo other){
        return 1;
    }
}
