package project;

// https://examples.javacodegeeks.com/desktop-java/awt/drawing-an-image-example/
//http://beginwithjava.blogspot.com/2009/02/rotating-image-with-java.html

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import java.awt.event.KeyEvent;

public class ArrowPanel extends JPanel implements KeyListener {

	Level level;
	
	
	public ArrowPanel(int l) {
		
    
		
		this.addKeyListener(this);	
		level = new Level(l);
		Timer t = new Timer();
		t.scheduleAtFixedRate(new UpdateTimerTask(),0, 20);
	}	

	@Override 
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
		}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(level.target.TargetHit == false & level.arrow.lives > 0 & level.arrow.fired == false) {
				level.arrow.angle += 0.075;
			level.arrow.m += 0.075;
			}
	
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(level.target.TargetHit == false & level.arrow.lives > 0 & level.arrow.fired == false) {
				level.arrow.angle -= 0.075;
			    level.arrow.m -= 0.075;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			if(level.target.TargetHit == true) {
				level.inLevel += 1;
				level.LevelSet();
			}
			if(level.target.TargetHit == false) {
				level.arrow.toInitial();
			}
		
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			level.arrow.Tighten();		
		}
		
	}	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			level.arrow.FireArrow();
		
		}
		
	}
	
	public void paintComponent(Graphics g) {	
	
        super.paintComponent(g);
       
        level.drawLevel(g);
       
	}
	
        
	class UpdateTimerTask extends TimerTask {
		
		@Override
		public void run() {
			
			level.arrow.update();
			level.target.update();
			level.collision.Check();
			repaint(); 		
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
