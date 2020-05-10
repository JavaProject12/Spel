package project;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Arrow {
// // https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/
	
	int startxpos, startypos; // starting position of the arrow
	int xposbal, yposbal; // position of the arrow (at rest or while moving)
	double snelh = 0.2; // initial speed of the arrow
	int tijd = 0; //time
	double angle = Math.PI/2; // initial angle of the arrow	
	Image arrowimage = Toolkit.getDefaultToolkit().getImage("src/images/arrow-150966_1280.png");

	boolean moving = false;
	boolean fired = false;
	double vx, vy, pos1x, pos2x, pos1y, pos2y, slope;
	int tightened = 0;
	int lives = 5;
	double m = angle;
	double ArrowTipX;
	double ArrowTipY; 
	boolean alive = true;
	double firedAngle;
	Graphics2D g2d;
	
	public void draw(Graphics g) {
		/*
		g.drawLine((int) (xposbal - 15*Math.cos(m)),(int) ( yposbal + 15*Math.sin(m)),
				(int) (xposbal + 15*Math.cos(m)),(int) (yposbal - 15*Math.sin(m)));
		*/
		for(int i = 1; i <= lives; i++) {
			g.fillOval(50*(i+1), 50, 15, 15);
		}
		g.drawArc(startxpos - 30, startypos - 30, 60, 60, (int) (angle/Math.PI * 180 - 90), 180);
		Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
        g2d.translate(xposbal, yposbal); // Translate the center of our coordinates.
        g2d.rotate(-m + Math.PI);  // Rotate the image by 1 radian.
        g2d.drawImage(arrowimage, -35, -20, 70, 40, null);
		
	
	}
	
	public void Tighten() {
		if(fired == false & tightened < 5 & lives > 0) {
			xposbal -= 5*Math.cos(angle);
			yposbal += 5*Math.sin(angle);
			tightened += 1;
			snelh += 0.2;
		}
		
	}
	public void toInitial() {
		xposbal = startxpos;
		yposbal = startypos;
		angle = firedAngle;
		m = angle;
		fired = false;
		moving = false;
		snelh = 0.2;
		tijd = 0;
		tightened = 0;
	}
	public Arrow(int beginxpos, int beginypos) {
		this.xposbal = beginxpos;
		this.yposbal = beginypos;
		this.startxpos = beginxpos;
		this.startypos = beginxpos;		
	}	
	public void startStopArrow() { //changes start to 1		
		if(moving == false) {
			moving = true;
		} else {
			moving = false;
		}
		
	}
	
	public void FireArrow() {
		if(lives >= 1 & fired == false) {
			lives -= 1;
			moving = true;
			fired = true;
			firedAngle = angle;
		}
		
	}
	public void update() { // updates the position of the arrow when fired (while taking gravity into account) 
		if(moving == true) {


			
			vx = Math.cos(angle)*snelh;
			vy = Math.sin(angle)*snelh;
			
			
			tijd += 20;
			
			pos1x = xposbal;  
			pos1y = yposbal; //x- and y-coordinate of the arrow before updating the position

			yposbal -= vy*20;
			yposbal += 0.00001*(tijd)*tijd;
			xposbal += vx*20;
			
			pos2x = xposbal;
			pos2y = yposbal;// after updating the position
			
			slope  = -( pos2y - pos1y)/ (pos2x - pos1x); // (delta y)/(delta x)
			m = Math.atan(slope);
			ArrowTipX= xposbal + 15*Math.cos(m);
			ArrowTipY= yposbal - 15*Math.sin(m);
			
		}		
	}
}
