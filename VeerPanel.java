package maart30;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;

public class VeerPanel extends JPanel implements KeyListener {
	
	
	
	public VeerPanel() {
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new UpdateTimerTask(),0, 20);
		this.addKeyListener(this);		
	}	
	
	public void reset() { //resets bow and arrow to initial state 
		pos.tijd = 0;
		pos.xposbal = xposstruct;
		pos.yposbal = yposstruct;
		pos.hoek = Math.PI/2;
		pos.start = 0;
		opgespannen = 0;
		pos.snelh = 0.2;
		booghoek = 0;
		pos.geraakt = 0;
		geraakt = 0;
		
	}
	
	public void levelSet() {
		if( level == 1) {
			xposstruct = 300;
			yposstruct = 300;
		}
		if (level == 2) {
			xposstruct = 100;
			yposstruct = 600;
		}
		
	}
	
	@Override 
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
		}
	
	@Override
	public void keyPressed(KeyEvent e) { // pressing LEFT and RIGHT changes the initial angle of bow and arrow

		if(e.getKeyCode() == KeyEvent.VK_LEFT & opgespannen == 0) {	
				
			pos.posChange(0, 0, 0.1);
			booghoek += 0.1;	
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT & opgespannen == 0) {
			
			pos.posChange(0, 0, -0.1);
			booghoek -= 0.1;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE & opgespannen <= 5) { //keep the spacebar pressed to pull the arrow
			opgespannen += 1;
			pos.snelh += 0.1;
			pos.posChange((int) (-7*Math.cos(pos.hoek)),(int)(-7*Math.sin(pos.hoek)), 0);					
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER & geraakt == 0) {// pressing enter resets the bow and arrow
			reset();
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER & geraakt == 1) {
			level += 1;
			levelSet();
			reset();
			System.out.println("l");
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			pos.startstop(); //fires the arrow when the spacebar is released

		}	
	}
	
	
	int opgespannen = 0; // keeps track of how far the arrow has been pulled
	double booghoek = 0; // sets initial angle of bow to 0
	static int yposstruct = 300; 
	static int xposstruct = 300; // coordinates of the bow
	
	VeerSys pos = new VeerSys(xposstruct, yposstruct); // puts arrow in the same position as the bow
	VeerDoel doel = new VeerDoel(375, 375); // places angle at the given position
	static int level = 1;
	static int geraakt = 0;

	public void structChange(int x, int y) { //(unused) allows you to change the position of the bow
		xposstruct += x;
		yposstruct -= y;
	}
	
	public static void main(String[] args) {
		
			JFrame f = new JFrame();
	        f.setSize(750,750);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setTitle("Project");
	        f.setLocation(100, 100); //standaard in de hoek van het scherm
	        JPanel hoofdpaneel = new VeerPanel();
	        f.add(hoofdpaneel);
	        f.setVisible(true);
	  	     
	}
	
		
		
		
	
	
	public void paintComponent(Graphics g) {	

		
		
        super.paintComponent(g);
        
        g.setColor(Color.green);
        
        g.fillRect(0, yposstruct + 30 , 750, 750); // draws ground (always right under bow)
        
        g.setColor(Color.black);
        
 
        

    	
    	g.drawArc(xposstruct - 30, yposstruct - 30, 60, 60, (int) (booghoek/Math.PI * 180), 180); //draws bow
    	
    	g.drawOval(doel.xposdoel - 15, doel.yposdoel -15, 30, 30); //draws target
    
    	if(pos.xposbal + 15* Math.cos(pos.raakhoek) >= doel.xposdoel - 15 
    			& pos.xposbal + 15* Math.cos(pos.raakhoek) <= doel.xposdoel + 15
    			& pos.yposbal - 15* Math.sin(pos.raakhoek) <= doel.yposdoel + 15 
    			& pos.yposbal - 15* Math.sin(pos.raakhoek) >= doel.yposdoel - 15) {
    		//displays the string 'win!' when the arrow touches the target
    		geraakt = 1;
    		doel.geraakt = 1;
    		pos.geraakt();
			g.drawString("win! press enter to continue",100, 100);
		}
    	
    	if(level == 1) {
    		g.drawString("Level 1", 200, 200);
    	} else {
    		g.drawString("Level 2", 200, 200);
    	}
    	
    	if(pos.start == 0) {
    		
    		
    		g.setColor(Color.red);
    		g.drawLine(pos.xposbal,
    				   pos.yposbal, 
    				   pos.xposbal+ (int) (30*Math.cos(pos.hoek)), 
    				   pos.yposbal- (int) (30*Math.sin(pos.hoek))); //draws arrow while not fired (attached to string)
    		g.setColor(Color.blue);
    		g.drawLine((int) (xposstruct - 30*Math.cos(booghoek)),(int) (yposstruct + 30*Math.sin(booghoek)), pos.xposbal, pos.yposbal); // draws the string of the bow (attached to arrow when not fired)
    		g.drawLine((int) (xposstruct + 30*Math.cos(booghoek)),(int) (yposstruct - 30*Math.sin(booghoek)), pos.xposbal, pos.yposbal);// ^

    	} else {
    		
    		g.setColor(Color.blue);
    		g.drawLine((int) (xposstruct - 30*Math.cos(booghoek)),
    				   (int) (yposstruct + 30*Math.sin(booghoek)),
    				   (int) (xposstruct + 30*Math.cos(booghoek)),
    				   (int) (yposstruct - 30*Math.sin(booghoek))); //draws the string of the bow when the arrow has been fired (arrow not attached to string)
    		
    		g.setColor(Color.red);
    		g.drawLine((int) (pos.xposbal - 15* Math.cos(pos.raakhoek)),
    				   (int) (pos.yposbal - 15* Math.sin(pos.raakhoek)), 
    				   (int) (pos.xposbal + 15* Math.cos(pos.raakhoek)), 
    				   (int) (pos.yposbal + 15* Math.sin(pos.raakhoek))); //draws the arrow when it has been fired
    	}  
    }
	class UpdateTimerTask extends TimerTask {
		
		@Override
		public void run() {
			pos.update();
			doel.updateDoel();
			repaint(); 			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
