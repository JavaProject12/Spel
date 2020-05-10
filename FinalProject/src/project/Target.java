package project;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Target {
	
	String TargetMode = new String();
	
	int TargetSpeed1;
	
	int TargetSpeed2;
	
	int TargetSize;
	
	int TargetX, TargetY;
	
	int initialTargetX, initialTargetY;
	
	double angle = 0;
	
	boolean TargetHit = false;
	Image targetimage = Toolkit.getDefaultToolkit().getImage("src/images/pngguru.com.png");
	
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
		//Graphics2D g2d = (Graphics2D)g;
		//g2d.translate(xposbal, yposbal); // Translate the center of our coordinates.
         
        g.drawImage(targetimage, TargetX - 15, TargetY - 15, 30, 30, null);
		
		
	}
	


}
