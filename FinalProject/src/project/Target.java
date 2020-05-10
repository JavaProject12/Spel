package project;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class Target {
	
	String TargetMode = new String();
	
	int TargetSpeed1;
	
	int TargetSpeed2;
	
	int TargetSize;
	
	int TargetX, TargetY;
	
	int initialTargetX, initialTargetY;
	
	double angle = 0;
	
	int t=0;
	
	int tijdelijkx,tijdelijky;
	
	
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
			 if(TargetMode=="Random") {
				 
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
			 if(TargetMode=="change_direction") {
				 Random rng= new Random();
				 TargetX += TargetSpeed1;
				 TargetY += TargetSpeed2;
				 t++;
				 if(t%40==0) {
					 TargetSpeed1=4- rng.nextInt(8);
					 TargetSpeed2=4-rng.nextInt(8);
					 
				 }
				 if(TargetX > TargetSize) {
					 TargetSpeed1 =-rng.nextInt(10);
				 }
				 if(TargetY > 700) {
					 TargetSpeed2 = -rng.nextInt(10);
				 }
				 if(TargetX <0) {
					 TargetSpeed1 =rng.nextInt(10);
				
				 }
				 if(TargetY <0) {
					 TargetSpeed2 = rng.nextInt(10);
				 }
				 
			 }
			 if(TargetMode=="dissapearing") {
				 Random rng=new Random();
				 
				
				 t++;
				
				 if(t%150>10&& t%150<50) {
					 TargetX=-30;
					 TargetY=-50;
				 }
				 else {
					 TargetX =tijdelijkx+initialTargetX;
					 TargetY =tijdelijky+initialTargetY;
					 
					 
					 
				 }
				 
				
				
				 
				 
		 		
				 
			 }
			 
	 }
	}

		
		 
		 
		
	
	public void draw(Graphics g) {
		
         
        g.drawImage(targetimage, TargetX - 25, TargetY - 25, 50, 50, null);
		
		
	}
	


}