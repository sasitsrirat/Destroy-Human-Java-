/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author mkeng
 */
public class NewMain extends JFrame{

    private JPanel          contentpane;
    private JCheckBox []    check;
    private JTextArea       text;
    private Object [] items   = null;
    private String    message = "";
    
    public NewMain()
    {
	setTitle("This is a new Frame");
	setBounds(200, 200, 400, 400);
	setVisible(true);
	setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );

	contentpane = (JPanel)getContentPane();
	contentpane.setLayout( new BorderLayout() );
    }
    
    public void AddComponents()
    {
	JPanel cpanel = new JPanel();
        check = new JCheckBox [ 5 ];
	check[0] = new JCheckBox( " 1 " );
	cpanel.add( check[0] );

	contentpane.add(cpanel, BorderLayout.NORTH);

	validate();
    }
    
    public static void main(String[] args) {
        NewMain frame = new NewMain();

	frame.AddComponents();
    }
    
}
