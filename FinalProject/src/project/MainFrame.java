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
//https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
public class MainFrame extends JFrame {
	
	
	
	
	
	
	String state = "MainMenu";
	int hiscore = 0;
	ArrowPanel ap;
	MainMenuPanel mmp = new MainMenuPanel(this);
	JButton b;
	Image background = Toolkit.getDefaultToolkit().getImage("src/images/pngguru.com.png");
	JLabel l;
	Image icon = Toolkit.getDefaultToolkit().getImage("src/images/69287-200.png");
	
	public MainFrame()  {
		
		this.setSize(800, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ARROW");
		this.setIconImage(icon);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
		
		
		add(mmp);
		mmp.setVisible(true);
		

		
		
	
		
		
		
		
		
	}
	
	public void SwitchPanel(String s) {
	
		if(s == "level") {
			mmp.setVisible(false);
			
			remove(mmp);
			
			ap = new ArrowPanel(1, this);
			
			add(ap);
			ap.setVisible(true);
			
		} 
		if(s == "menu") {
			ap.setVisible(false);
			remove(ap);
			add(mmp);
			mmp.setVisible(true);
		}
		
			
			
	}
	
	
	
	
	

    

}
