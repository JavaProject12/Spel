package project;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
//https://javatutorial.net/display-text-and-graphics-java-jframe
//http://www.java2s.com/Tutorials/Java/Swing_How_to/Layout/Set_the_location_of_a_button_anywhere_in_JFrame.htm
//https://stackoverflow.com/questions/5987600/simple-adding-a-jlabel-to-jpanel
//https://alvinalexander.com/java/jbutton-listener-pressed-actionlistener/
//Ultimate warrior
//https://www.javatpoint.com/Displaying-image-in-swing
//https://www.tutorialspoint.com/how-to-add-background-image-to-jframe-in-java
//https://stackoverflow.com/questions/12988896/jframe-fixed-width
//https://stackoverflow.com/questions/3195666/how-to-place-a-jbutton-at-a-desired-location-in-a-jframe-using-java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	
	
	
	
	
	String state;
	ArrowPanel ap;
	JPanel p;
	JButton b;
	Image background = Toolkit.getDefaultToolkit().getImage("src/images/Cylinders.jpg");
	JLabel l;
	public MainFrame()  {
		
		this.setSize(1300, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PROJECT");
		
		setResizable(false);
		
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.LIGHT_GRAY);
		
		b = new JButton("Start");
		l = new JLabel("Arrow");
		l.setFont(new Font("Verdana", Font.PLAIN, 18));
		l.setBounds(600, 200, 100, 20);
		p.add(l);
		b.setBounds(600,315,100, 20);
		
		b.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        SwitchPanel("level");
	       
	      }
	    });
		
		p.add(b);
		this.add(p);
		
		this.setVisible(true);
	
		
		
		
		
		
	}
	
	public void SwitchPanel(String s) {
		p.setVisible(false);
		
		this.remove(p);
		
		if(s == "level") {
			ap = new ArrowPanel(1);
			this.add(ap);
			ap.setLayout(null);
			ap.setVisible(true);
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	
	

    

}
