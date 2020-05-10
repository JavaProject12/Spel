package project;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Arrow {
	//https://stackoverflow.com/questions/33433485/jpanel-window-not-scaling-when-resize-the-main-frame
// // https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/
	//https://www.google.com/url?sa=i&url=https%3A%2F%2Fgfycat.com%2Fstickers%2Fsearch%2Fbeating&psig=AOvVaw2AC3vRc6v1FAd8Ei79qUCe&ust=1589195799266000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMj0ieyVqekCFQAAAAAdAAAAABAd
	int startxpos, startypos; // starting position of the arrow
	int xposbal, yposbal; // position of the arrow (at rest or while moving)
	double snelh = 0.2; // initial speed of the arrow
	int tijd = 0; //time
	double angle = Math.PI/2; // initial angle of the arrow	
	Image arrowimage = Toolkit.getDefaultToolkit().getImage("src/images/arrow.png");
	Image heart = Toolkit.getDefaultToolkit().createImage("src/images/alexia-janssens-beatingheart2-big.gif");
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
		Graphics2D g2d=(Graphics2D)g;
		
		for(int i = 1; i <= lives; i++) {
			g2d.drawImage(heart, 40*(i+1) - 50, 50, 30, 30, null);
		}
		
		g.drawArc(startxpos - 30, startypos - 30, 60, 60, (int) (angle/Math.PI * 180 - 90), 180);
		if(fired == true) {
			g.drawLine((int) (startxpos + 30*Math.sin(-angle)),(int)  (startypos - 30*Math.cos(-angle)),(int) (startxpos - 30*Math.sin(-angle)),(int)  (startypos + 30*Math.cos(-angle)));
		} else {
			g.drawLine((int) (startxpos + 30*Math.sin(-angle)),(int)  (startypos - 30*Math.cos(-angle)),(int)(xposbal - 20*Math.cos(-angle)) ,(int)(xposbal - 20*Math.sin(-angle)));
			g.drawLine((int)(xposbal - 20*Math.cos(-angle)) ,(int)(xposbal - 20*Math.sin(-angle)), (int) (startxpos - 30*Math.sin(-angle)),(int)  (startypos + 30*Math.cos(-angle)));
		}
	
        g2d.translate(xposbal, yposbal); // Translate the center of our coordinates.
        g2d.rotate(-m + Math.PI); 
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
