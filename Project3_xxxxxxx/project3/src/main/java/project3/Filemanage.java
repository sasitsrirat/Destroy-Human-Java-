package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Filemanage {
    private PrintWriter output;

    public void filescan(ArrayList<PlayerInfo> playerArraylist,String path,String filename) {
        boolean fileopensuccess = false;

        while (!fileopensuccess) {
            try (Scanner filescan = new Scanner(new File(path + filename))) {
                fileopensuccess = true;
                while(filescan.hasNext()){
                    String line = filescan.nextLine();
                    String [] buf = line.split(",");
                    String name = buf[0].trim();
                    int stage = Integer.parseInt(buf[1].trim());
                    int score = Integer.parseInt(buf[2].trim());
                    boolean displayscore = false;
                    boolean resume = false;
                    if(buf[3].trim().equalsIgnoreCase("true")){
                        displayscore = true;    
                    }
                    if(buf[4].trim().equalsIgnoreCase("true")){
                        resume = true;    
                    }

                    playerArraylist.add(new PlayerInfo(name,stage,score,displayscore,resume));
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

    public void filewrite(ArrayList<PlayerInfo> playerArraylist,String path,String filename){
        try{
            File file = new File(path+filename);
            FileWriter fw = new FileWriter(file,false);
            output = new PrintWriter(fw);
            
            for(PlayerInfo p: playerArraylist){
                boolean display=false,resume=false;
                if(p.getresume()){
                    resume = true;
                }
                if(p.getdisplay()){
                    display = true;
                }
                output.printf("%s,%d,%d,%s,%s\n",p.getname(),p.getstage(),p.getscore(),display,resume);
            }
        output.close();
        }catch(Exception e){
                System.out.print("Error Occur");
                e.printStackTrace();
        }
    }
}
