package project3;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame
{
    private int frameWidth = 800, frameHeight = 500;
    private JLabel contentPane;
    
    public MainMenu()
    {
        String path = "src/pictures";

        setType(Type.POPUP);
        setBounds(50,50,frameWidth,frameHeight);
        setTitle("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
		
        //set background 
        contentPane = new JLabel();
        setContentPane(contentPane = new JLabel());
        contentPane.setBackground(new Color(107, 142, 35));
        contentPane.setForeground(new Color(107, 142, 35));
		contentPane.setBackground(new Color(255, 169, 57));
        contentPane.setOpaque(true); // significant
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        

        JButton btnNewButton = new JButton("Play");
		btnNewButton.setForeground(new Color(255, 255, 255));
        contentPane.add(btnNewButton);
        contentPane.validate();
    }
    public static void main(String[] args) {
 
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
 
    }
}

