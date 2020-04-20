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
//https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
public class VeerPanel extends JPanel implements KeyListener {
	

	
	public VeerPanel() {
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new UpdateTimerTask(),0, 20);
		this.addKeyListener(this);		
	}	
	
	public void reset() {
		pos.tijd = 0;
		pos.xposbal = xposstruct;
		pos.yposbal = yposstruct;
		pos.hoek = Math.PI/2;
		pos.start = 0;
		opgespannen = 0;
		pos.snelh = 0.2;
		booghoek = 0;
		pos.geraakt = 0;
	}
	
	@Override 
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
		}
	
	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_LEFT) {	
				
			pos.posChange(0, 0, 0.1);
			booghoek += 0.1;	
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			pos.posChange(0, 0, -0.1);
			booghoek -= 0.1;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE & opgespannen <= 5) {
			opgespannen += 1;
			pos.snelh += 0.1;
			pos.posChange((int) (-7*Math.cos(pos.hoek)),(int)(-7*Math.sin(pos.hoek)), 0);					
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			reset();
		}
	}	
	int opgespannen = 0;
	double booghoek = 0; 
	int yposstruct = 500;
	int xposstruct = 200;
	VeerSys pos = new VeerSys(xposstruct, yposstruct);
	VeerDoel doel = new VeerDoel(375, 375);
	
	public void structChange(int x, int y) {
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
        
        g.setColor(Color.black);
        
        

    	
    	g.drawArc(xposstruct - 30, yposstruct - 30, 60, 60, (int) (booghoek/Math.PI * 180), 180);
    	
    	g.drawOval(doel.xposdoel - 15, doel.yposdoel -15, 30, 30);
    
    	if(pos.xposbal >= doel.xposdoel - 15 & pos.xposbal <= doel.xposdoel + 15 & pos.yposbal <= doel.yposdoel + 15 & pos.yposbal >= doel.yposdoel - 15) {
    		
    		pos.geraakt();
			g.drawString("win!",100, 100);
		}
    	
    	if(pos.start == 0) {
    		
    		
    		g.setColor(Color.red);
    		g.drawLine(pos.xposbal,
    				   pos.yposbal, 
    				   pos.xposbal+ (int) (30*Math.cos(pos.hoek)), 
    				   pos.yposbal- (int) (30*Math.sin(pos.hoek)));
    		g.setColor(Color.blue);
    		g.drawLine((int) (xposstruct - 30*Math.cos(booghoek)),(int) (yposstruct + 30*Math.sin(booghoek)), pos.xposbal, pos.yposbal);
    		g.drawLine((int) (xposstruct + 30*Math.cos(booghoek)),(int) (yposstruct - 30*Math.sin(booghoek)), pos.xposbal, pos.yposbal);

    	} else {
    		
    		g.setColor(Color.blue);
    		g.drawLine((int) (xposstruct - 30*Math.cos(booghoek)),
    				   (int) (yposstruct + 30*Math.sin(booghoek)),
    				   (int) (xposstruct + 30*Math.cos(booghoek)),
    				   (int) (yposstruct - 30*Math.sin(booghoek)));
    		
    		g.setColor(Color.red);
    		g.drawLine((int) (pos.xposbal - 15* Math.cos(pos.raakhoek)),
    				   (int) (pos.yposbal - 15* Math.sin(pos.raakhoek)), 
    				   (int) (pos.xposbal + 15* Math.cos(pos.raakhoek)), 
    				   (int) (pos.yposbal + 15* Math.sin(pos.raakhoek)));
    	}  
    }
	class UpdateTimerTask extends TimerTask {
		
		@Override
		public void run() {
			pos.update();
			repaint();			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			pos.startstop();

		}	
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
