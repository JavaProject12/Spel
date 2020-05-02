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
		lev.Level(level);
		xposstruct = lev.xposbal;
		yposstruct = lev.yposbal;
		xposdoel = lev.xposdoel;
		yposdoel = lev.yposdoel;
		snelheid = lev.snelheid;
		beginxposdoel = xposdoel;
		beginyposdoel = yposdoel;
		
		
		
	}
	
	@Override 
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
		}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(menu) {
		case 0:
			if(e.getKeyCode() == KeyEvent.VK_LEFT & opgespannen == 0 & levens > 0) {	
				
				pos.posChange(0, 0, 0.1);
				booghoek += 0.1;	
			}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT & opgespannen == 0 & levens > 0) {
				
				pos.posChange(0, 0, -0.1);
				booghoek -= 0.1;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_SPACE & opgespannen <= 5 & levens > 0) { //keep the spacebar pressed to pull the arrow
				opgespannen += 1;
				pos.snelh += 0.1;
				pos.posChange((int) (-7*Math.cos(pos.hoek)),(int)(-7*Math.sin(pos.hoek)), 0);					
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER & geraakt == 0 & gameover == 0) {// pressing enter resets the bow and arrow
				reset();
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER & geraakt == 1) {
				
				score += 5*levens;
				if(highscore < score) {
					highscore = score;
				}
				level += 1;
				levelSet();
				reset();
				levens = 5;
				System.out.println("l");
				
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER & gameover == 1) {
				score = 0;
				level = 1;
				levelSet();
				reset();
				levens = 5;
				gameover = 0;
				System.out.println("l");
				
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER & geraakt == 0 & levens == 0) {// pressing enter resets the bow and arrow
				gameover = 1;
			}
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				if(escape == 1) {
					escape = 0;
				} else {
					escape = 1;
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER & escape == 1) {
				
				menu = 1;
				escape = 0;
			}
			break;
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				levelselected += 1;
				System.out.println(levelselected);
			}
			
			
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				levelselected -= 1;
				System.out.println(levelselected);
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				level = levelselected;
				levelSet();
				reset();
				menu = 0;
			}
			break;
		}
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE & levens > 0) {
			 //fires the arrow when the spacebar is released
			if(pos.start == 0) {
				levens -= 1;
			}
			pos.startstop();

		}	
	}
	
	
	int opgespannen = 0; // keeps track of how far the arrow has been pulled
	double booghoek = 0; // sets initial angle of bow to 0
	static int yposstruct = 300; 
	static int xposstruct = 300; // coordinates of the bow
	static int xposdoel = 500;
	static int yposdoel = 500;
	int beginxposdoel = xposdoel;
	int beginyposdoel = yposdoel;
	static int snelheid = 0;
	VeerSys pos = new VeerSys(xposstruct, yposstruct); // puts arrow in the same position as the bow
	VeerDoel doel = new VeerDoel(375, 375); // places angle at the given position
	static int level = 1;
	static int geraakt = 0;
	LevelData lev = new LevelData();
	int levens = 5;
	int gameover = 0;
	int menu = 1;
	int levelselected = 1;
	int escape = 0;
	int score = 0;
	int highscore = 0;
	

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
	
	
	public void updateDoel() {
		
		if(geraakt == 0) {
			xposdoel += snelheid;
			if(xposdoel >= beginxposdoel + 50 | xposdoel <= beginxposdoel - 50) {
				snelheid *= -1;
			}
			
		}
		
	}
		
		
	
	
	public void paintComponent(Graphics g) {	

		
		
        super.paintComponent(g);
        
        switch(menu) {
        
        case 0:
        	g.setColor(Color.red);
        	 
            for(int i = 0; i < levens; i++) {
            	g.fillOval(50+ 25*i, 55,20 , 20);
            }

        	 g.setColor(Color.black);
        	 g.drawString("SCORE : " + Integer.toString(score), 620, 50);
        	 g.drawString("HIGH SCORE: " + Integer.toString(highscore), 620, 65);
        	 if(levens == 0 & (pos.xposbal > 750  | pos.xposbal < 0| pos.yposbal > 750)) {
        		 
        		 gameover = 1;
        	 }
        	 if(gameover == 1) {
        		 g.drawString("GAME OVER", 350, 350);
        	 }
        	g.drawArc(xposstruct - 30, yposstruct - 30, 60, 60, (int) (booghoek/Math.PI * 180), 180); //draws bow
        	
        	g.fillOval(xposdoel - 15, yposdoel -15, 30, 30); //draws target
        	g.setColor(Color.blue);
        	g.fillOval(xposdoel - 12, yposdoel -12, 25, 25);
        	g.setColor(Color.red);
        	g.fillOval(xposdoel - 10, yposdoel -10, 20, 20);
        	g.setColor(Color.yellow);
        	g.fillOval(xposdoel - 2, yposdoel -2, 5, 5);
        	g.setColor(Color.black);
        	if(pos.xposbal + 15* Math.cos(pos.raakhoek) >= xposdoel - 15 
        			& pos.xposbal + 15* Math.cos(pos.raakhoek) <= xposdoel + 15
        			& pos.yposbal - 15* Math.sin(pos.raakhoek) <= yposdoel + 15 
        			& pos.yposbal - 15* Math.sin(pos.raakhoek) >= yposdoel - 15) {
        		//displays the string 'win!' when the arrow touches the target
        		geraakt = 1;
        		
        		doel.geraakt = 1;
        		pos.geraakt();
    			g.drawString("Target hit! Press enter to continue",100, 100);
    			
    			
    		}
        	
        	g.drawString("Level " + Integer.toString(level), 50, 50);
        	
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
        	if(escape == 1) {
        		g.drawString("Exit Level?", 300, 290);
        		g.drawString( "escape: back to level", 300, 315);
        		g.drawString("enter : to menu", 300, 330);
        	}
        	break;
        case 1:
        	
        	for(int i = 1; i < 4;i ++) {
        		if(levelselected == i) {
        			g.setColor(Color.red);
        		} else {
        			g.setColor(Color.black);
        			
        		}
        		g.drawString("Level" + Integer.toString(i), 80 + (i - 1)* 275, 300);
        	}
        	
        	
        }
        
       
        
       
        
    }
	class UpdateTimerTask extends TimerTask {
		
		@Override
		public void run() {
			if(levelselected > 3) {
				levelselected -= 3;
			}
			if(levelselected < 1) {
				levelselected += 3;
			}
			pos.update();
			updateDoel();
			repaint(); 
			
			
			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
