package spring;
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
	JLabel text;
	JLabel lev;
	JLabel inst;
	public MainFrame()  {
		
		this.setSize(1300, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PROJECT");
		
		setResizable(false);
		
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.LIGHT_GRAY);
		text= new JLabel("Welcome dear player!To play Arrow, click on the start button.");
		lev= new JLabel("You start with the first level, you have got five chances for each level. \n" + 
				"All levels have different environments. Want to discover them? Start playing now!\n");
		inst = new JLabel("Press the right and left arrows of your keyboard to rotate the arrow\n" + 
				"Press the space bar to clamp the arrow\n" + 
				"Release the space bar to make the arrow hit its target.\n" + 
				"\n" + 
				"Have a good game!\n" + 
				" ");
		

		b = new JButton("Start");
		l = new JLabel("Arrow");
		l.setFont(new Font("Verdana", Font.PLAIN, 18));
		l.setBounds(600, 200, 100, 20);
		text.setFont(new Font("Arial",Font.PLAIN, 15));
		lev.setFont(new Font("Arial",Font.PLAIN, 13));
		inst.setFont(new Font("Arial",Font.PLAIN, 13));
		lev.setForeground(Color.CYAN);
		inst.setForeground(Color.CYAN);
		p.add(l);
		p.add(text);
		p.add(inst);
		p.add(lev);
		b.setBounds(600,315,100, 20);
		text.setBounds(450,450,550,50);
		lev.setBounds(100,500,1500,10);
		inst.setBounds(100,500,1500,60);
		
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