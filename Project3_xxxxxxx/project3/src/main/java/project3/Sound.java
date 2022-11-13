package project3;
import javax.sound.sampled.*;

public class Sound {
    
    Clip clip;
    float previousVolume = 0;
    float currentVolume = 0;
    FloatControl fc;
    boolean mute = false;

    public Sound(String filename) {
        try {
            java.io.File file = new java.io.File(filename);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception e) {
           // e.printStackTrace();
        }
    }
    public void playOnce()   { clip.setMicrosecondPosition(0); clip.start(); }
    public void playLoop()   { clip.loop(Clip.LOOP_CONTINUOUSLY); }
    public void stop()       { clip.stop(); }
    public void muteVolume(){
        if(mute == false){
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            fc.setValue(currentVolume);
            mute = true;
        }else if(mute == true){
            currentVolume = previousVolume;
            fc.setValue(currentVolume);
            mute = false;
        }
    }
}
