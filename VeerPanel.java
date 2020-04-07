

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
		t.scheduleAtFixedRate(new UpdateTimerTask(), 5000, 20);
		this.addKeyListener(this);
		
		
	}
	
	@Override 
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
		}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			pos.posChange(0, 0, 0.5);
			repaint();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pos.posChange(10,0 , 0);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			pos.posChange(-10,0 , 0);
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			pos.posChange(0,-10 , 0);
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			pos.posChange(0,10 , 0);
			repaint();
		}
		
	}
	
	int beginposx = 200;
	int beginposy = 500;
	
	
	
	VeerSys pos = new VeerSys(beginposx, beginposy);

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
        
    	g.fillOval(pos.xpos, pos.ypos, 15, 15);
     
    }
	
	
	
	class UpdateTimerTask extends TimerTask {
		
		
		@Override
		public void run() {
			pos.update();
			System.out.println(pos);
			repaint();
			
		}
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
