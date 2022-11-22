package project3;

import javax.sound.sampled.*;

public class Sound {

    Clip clip;
    float currentVolume = -18;
    FloatControl fc;
    boolean mute = false;

    public Sound(String filename) {
        try {
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
