package project3;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

    Clip clip;
    float currentVolume = -18;
    FloatControl fc;
    boolean mute = false;
    String name;

    public Sound(String filename, String n) {
        try {
            name = n;
            java.io.File file = new java.io.File(filename);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);  
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            fc.setValue(currentVolume);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void playOnce() {
        if(mute != true){
        clip.setMicrosecondPosition(0);
        clip.start();
        }
    }

    public void playLoop() {
        if(mute != true){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        clip.stop();
    } 

    public void muteVolume() {
        if (mute == false) {
            clip.stop();
            mute = true;
        } else if (mute == true) {
            mute = false;
        }
    }
}
