/*6413110 Mr.Watcharsak Prommanee
6413112 Mr.Sasit Srirat
6413210 Mr.Kawin Kengkate
6413223 Mr.Ravipol Chayeraksa*/
package project3;

public class PlayerInfo implements Comparable<PlayerInfo> {
    private String name;
    private int[] score = { 0, 0, 0, 0, 0 };
    private int totalscore;
    private int stage = 1;
    private boolean scoreboarddisplay = true; // default true
    private boolean Autosave = true; // default true
    private boolean watchstory = true; // default true

    public PlayerInfo(String name, int stage, int score1, int score2, int score3, int score4, int score5,
            boolean display, boolean save, boolean story) {
        this.name = name;
        this.Autosave = save;
        this.stage = stage;
        score[0] = score1;
        score[1] = score2;
        score[2] = score3;
        score[3] = score4;
        score[4] = score5;
        this.scoreboarddisplay = display;
        this.watchstory = story;

    }

    public String getname() {
        return name;
    }

    public int getscore(int s) {
        return this.score[s - 1];
    }

    public boolean getdisplay() {
        return scoreboarddisplay;
    }

    public boolean getAutosave() {
        return Autosave;
    }

    public boolean getshowstory() {
        return watchstory;
    }

    public int getstage() {
        return stage;
    }

    public void setname(String n) {
        name = n;
    }

    public void setscore(int score, int stage) {
        if (this.score[stage - 1] < score)
            this.score[stage - 1] = score;
    }

    public void setdisplay(boolean d) {
        scoreboarddisplay = d;
    }

    public void setAutosave(boolean save) {
        Autosave = save;
    }

    public void setshowstory(boolean s) {
        watchstory = s;
    }

    public void setstage(int s) {
        if (this.stage < s)
            this.stage = s;
    }

    public int compareTo(PlayerInfo other) {
        if (this.totalscore > other.totalscore) {
            return -1;
        } else
            return 1;
    }

    public void settotalscore() {
        for (int i = 0; i < score.length; i++) {
            this.totalscore += score[i];
        }
    }
}
