package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Filemanage {
    private PrintWriter output;
    private String path;
    private String filename;

    public Filemanage(String path,String filename){
        this.path = path;
        this.filename = filename;
    }

    public void filescan(ArrayList<PlayerInfo> playerArraylist){
        boolean fileopensuccess = false;

        while (!fileopensuccess) {
            try (Scanner filescan = new Scanner(new File(path + filename))) {
                fileopensuccess = true;
                while(filescan.hasNext()){
                    String line = filescan.nextLine();
                    String [] buf = line.split(",");
                    String name = buf[0].trim();
                    int stage = Integer.parseInt(buf[1].trim());
                    int score1 = Integer.parseInt(buf[2].trim());
                    int score2 = Integer.parseInt(buf[3].trim());
                    int score3 = Integer.parseInt(buf[4].trim());
                    int score4 = Integer.parseInt(buf[5].trim());
                    int score5 = Integer.parseInt(buf[6].trim());
                    boolean displayscore = false;
                    boolean Autosave = false;
                    boolean showstory = false;
                    if(buf[7].trim().equalsIgnoreCase("true")){
                        displayscore = true;    
                    }
                    if(buf[8].trim().equalsIgnoreCase("true")){
                        Autosave = true;    
                    }
                    if(buf[9].trim().equalsIgnoreCase("true")){
                        showstory = true;    
                    }

                    playerArraylist.add(new PlayerInfo(name,stage,score1,score2,score3,score4,score5,displayscore,Autosave,showstory));
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
                System.out.println("Input new filename");
                Scanner kb = new Scanner(System.in);
                filename = kb.nextLine();
                kb.close();
            }
        }
    }

    public void filewrite(ArrayList<PlayerInfo> playerArraylist){
        try{
            File file = new File(path+filename);
            FileWriter fw = new FileWriter(file,false);
            output = new PrintWriter(fw);
            
            for(PlayerInfo p: playerArraylist){
                boolean displayscore=false,Autosave=false,showstory = false;;
                if(p.getAutosave()){
                    Autosave = true;
                }
                if(p.getdisplay()){
                    displayscore = true;
                }
                if(p.getshowstory()){
                    showstory = true;
                }
                if(p.getAutosave()){
                output.printf("%s,%d,%d,%d,%d,%d,%d,%s,%s,%s \n",p.getname(),p.getstage(),p.getscore(1),p.getscore(2),p.getscore(3),p.getscore(4),p.getscore(5),displayscore,Autosave,showstory);
                }
            }
        output.close();
        }catch(Exception e){
                System.out.print("Error Occur");
                e.printStackTrace();
        }
    }
}
