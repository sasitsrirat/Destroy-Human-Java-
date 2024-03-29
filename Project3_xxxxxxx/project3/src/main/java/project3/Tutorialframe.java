/*6413110 Mr.Watcharsak Prommanee
6413112 Mr.Sasit Srirat
6413210 Mr.Kawin Kengkate
6413223 Mr.Ravipol Chayeraksa*/
package project3;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

public class Tutorialframe extends JFrame {
    JLabel contentpane;
    String imagepath;

    public Tutorialframe(String path) {
        imagepath = path;
        setTitle("Tutorial");
	    setBounds(200, 0, 1188, 840);
	    setVisible(true);
	    setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        ImageIcon img = new ImageIcon(imagepath + "book.png");
        setIconImage(img.getImage());
        contentpane = new JLabel();
        setContentPane(contentpane);
        ImageIcon bg = new ImageIcon(imagepath + "tutorial.png");
        bg.setImage(bg.getImage().getScaledInstance(1188, 840, Image.SCALE_REPLICATE));
        contentpane.setIcon(bg);

        validate();
        repaint();
    }
    
}