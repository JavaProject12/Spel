package project;

import java.awt.Graphics;

public class Level {
	static int inLevel;
	Arrow arrow;
	Target target;
	collision collision;
	
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
		}
		
	}
	
	public void drawLevel(Graphics g) {
		target.draw(g);
		arrow.draw(g);
		
	}
	
	

}
