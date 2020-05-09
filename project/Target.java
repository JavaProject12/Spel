package project;
import java.awt.Graphics;

public class Target {
	
	String TargetMode = new String();
	
	int TargetSpeed1;
	
	int TargetSpeed2;
	
	int TargetSize;
	
	int TargetX, TargetY;
	
	int initialTargetX, initialTargetY;
	
	double angle = 0;
	
	boolean TargetHit = false;
	
	Target(int x, int y,int speed1, int speed2, String mode, int size) {
		
		this.TargetMode = mode;
		this.TargetSize = size;
		this.TargetSpeed1 = speed1;
		this.TargetSpeed2 = speed2;
		this.TargetX = x;
		this.initialTargetX = x;
		this.TargetY = y;
		this.initialTargetY = y;
		
	}
	 public void update() {
		 
		 if(TargetHit == false) {
			 if(TargetMode == "slidehorizontal") {
				 
				 TargetX += TargetSpeed1;
				 TargetY += TargetSpeed2;
				 if(TargetX > initialTargetX + TargetSize
						 |TargetX < initialTargetX - TargetSize ) {
					 TargetSpeed1 *= -1;
				 }
				 if(TargetY > initialTargetX + TargetSize
						 |TargetY < initialTargetY - TargetSize) {
					 TargetSpeed2 *= -1;
				 }
			 }
			 if(TargetMode == "circling") {
				
				 TargetX = (int) (initialTargetX + TargetSize*Math.cos(angle));
				 TargetY = (int) (initialTargetY + TargetSize*Math.sin(angle));
				 angle += 0.01*TargetSpeed1;
			 }
			 
		 }
		
		 
		 
		
	}
	public void draw(Graphics g) {
		g.fillOval(TargetX - 15, TargetY - 15, 30, 30);
		if(TargetHit == true) {
			g.drawString("Target Hit", 500, 500);
		}
	}
	


}
