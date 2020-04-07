package maart30;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;

public class VeerPanel extends JPanel implements KeyListener {
	
	
	
	public VeerPanel() {
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new UpdateTimerTask(),0, 20);
		this.addKeyListener(this);
		
		
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
			
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			pos.posChange(0, 0, -0.1);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_R) {
			pos.posChange(10,0 , 0);
			structChange(10,0);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			pos.posChange(-10,0 , 0);
			structChange(-10,0);
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_U) {
			pos.posChange(0,10 , 0);
			structChange(0,10);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			pos.posChange(0,-10 , 0);
			structChange(0, -10);
			
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER & opgespannen <= 5) {
			opgespannen += 1;
			pos.snelh += 0.1;
			pos.posChange((int) (-7*Math.cos(pos.hoek)),(int)(-7*Math.sin(pos.hoek)), 0);
			
			
		}
		
		
	}
	
	
	int opgespannen = 0;
	int yposstruct = 500;
	int xposstruct = 200;
	VeerSys pos = new VeerSys(xposstruct, yposstruct);
	
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
    	g.fillOval(pos.xposbal, pos.yposbal, 15, 15);
    	
    	if(pos.start == 0) {
    		
    		g.setColor(Color.red);
    		g.drawLine( pos.xposbal + 8 + (int) (20*Math.cos(pos.hoek)), pos.yposbal + 8 - (int) (20*Math.sin(pos.hoek)), pos.xposbal + 8 + (int) (50*Math.cos(pos.hoek)), pos.yposbal + 8 - (int) (50*Math.sin(pos.hoek)));
    		
    		g.setColor(Color.blue);
    		g.drawLine(xposstruct - 50, yposstruct + 15, pos.xposbal + 7, pos.yposbal + 15);
    		g.drawLine(xposstruct + 65, yposstruct + 15, pos.xposbal + 8, pos.yposbal + 15);
    	} else {
    		g.setColor(Color.blue);
    		g.drawLine(xposstruct - 50, yposstruct + 15, xposstruct + 65, yposstruct + 15);
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
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			pos.startstop();
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
