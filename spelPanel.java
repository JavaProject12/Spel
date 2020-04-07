
import java.awt.Graphics;


import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class spelPanel extends JPanel {
	Roos roos;Ground ground;
	
	public spelPanel() {
		roos=new Roos();
		ground=new Ground();
	}
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		roos.draw(g);
		ground.draw(g);
	
	
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
	    
	}


