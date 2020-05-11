package spring;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JLabel;


public class Level {
	static int inLevel;
	Arrow arrow;
	Target target;
	collision collision;
	int score = 0;
	Image bg =  Toolkit.getDefaultToolkit().getImage("src/images/Cylinders.jpg");
	Image jungle = Toolkit.getDefaultToolkit().getImage("src/images/de jungle.jpg");
	Image green = Toolkit.getDefaultToolkit().getImage("src/images/green.jpg");
	Image beach = Toolkit.getDefaultToolkit().getImage("src/images/beach.jpg");
	Image underwater = Toolkit.getDefaultToolkit().getImage("src/images/underwater.jpg");
	Image woestijn = Toolkit.getDefaultToolkit().getImage("src/images/woestijn.jpg");
	Image city = Toolkit.getDefaultToolkit().getImage("src/images/city.jpg");
	
	
	
	public Level(int l) {
		this.inLevel = l;
		
		LevelSet();		
	}
	
	public void LevelSet() {
		
		
		switch(inLevel) {
		case 0:
			break;
		case 1:
			
			arrow = new Arrow(200,200);
			System.out.println("1111");
			target = new Target(300, 400,0,5,"circling",40);
			collision = new collision(arrow, target);
			
			break;
		case 2:
			arrow  = new Arrow(300,300);
			
			target = new Target(500, 400,0,10,"slidehorizontal",30);
			collision = new collision(arrow, target);
			break;
		case 3:
			arrow = new Arrow(500, 100);
			target = new Target(100, 100, 10,10, "circling", 50);
			collision = new collision(arrow, target);
			break;
		case 4:
			Random rng =new Random();
			
			arrow= new Arrow(100,300);
			target= new Target(500,300,5-rng.nextInt(10),5-rng.nextInt(10),"Random",50);
			collision = new collision(arrow, target);
			break;
		case 5:
			arrow= new Arrow(100,300);
			target = new Target(250, 250, 1,1, "change_direction", 700);
			collision = new collision(arrow, target);
			break;
			
		case 6:
			
			
			arrow= new Arrow(100,400);
			target = new Target(600, 250, 5,5, "dissapearing", 50);
			collision = new collision(arrow, target);
			break;
			
			
		}
		
	}
	
	public void drawLevel(Graphics g) {
		switch(inLevel) {
		
		case 1:
			g.drawImage(jungle, 0, 0,null);
			g.setFont(new Font("Verdana", Font.PLAIN, 20));
			g.drawString("Welcome to the jungle!",900, 30);
			
			
		case 2:
			g.drawImage(green, 0, 0, null);
			g.setFont(new Font("Verdana", Font.PLAIN, 20));
			g.drawString("Welcome to the lake!",900, 30);
			
		case 3:
			g.drawImage(city, 0, 0,null);
			g.setFont(new Font("Verdana", Font.PLAIN, 20));
			g.drawString("Welcome to my city!",900, 30);
		case 4:
			g.drawImage(beach, 0, 0,null);
			g.setFont(new Font("Verdana", Font.PLAIN, 20));
			g.drawString("Welcome to the beach!",900, 30);
		case 5:
			g.drawImage(underwater, 0, 0,null);
			g.setFont(new Font("Verdana", Font.PLAIN, 20));
			g.drawString("Welcome to the underwater world!",900, 30);
		case 6:
			g.drawImage(woestijn,0,0,null);
			g.setFont(new Font("Verdana", Font.PLAIN, 20));
			g.drawString("Welcome to the Sahara!",900, 30);
			
		
		
		}
		g.setFont(new Font("Broadway", Font.PLAIN, 24));
		g.drawString("Level " + Integer.toString(inLevel) , 30, 30);
		g.drawString("Score: " + Integer.toString(score), 650, 30);
	
	}
	
	

}