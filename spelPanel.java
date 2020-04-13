
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class spelPanel extends JPanel implements KeyListener {
	Roos roos;Ground ground;Boog boog;
	
	public spelPanel() {
		roos=new Roos();
		ground=new Ground();
		boog=new Boog(60,340,90);
		addKeyListener(this);
	}
	@Override
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
				}
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		roos.draw(g);
		ground.draw(g);
		boog.draw(g);
	
	
	}
		
	
	public static void main(String[] args) {
		 	JFrame f = new JFrame();
	        f.setSize(750,500);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setTitle("Spel");
	        f.setLocation(100, 100); 			//standaard in de hoek van het scherm
	        JPanel hoofdpaneel = new spelPanel();
	        f.add(hoofdpaneel);
	        f.setVisible(true);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			boog=boog.left();
			repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			boog=boog.right();
			repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP) {
			boog=boog.up();
			repaint();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


