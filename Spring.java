package spring;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Spring extends JPanel {
	public Image backgroundImage;

	  
	
	  
	  public static void main(String[] a) {
		    JFrame f = new JFrame();
		    f.setSize(400, 400);
		    f.add(new Spring());
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    f.setTitle("The arc");
		    f.setVisible(true);
		    f.createImage(300, 400);
		    
		    
		   
		   
		    
		    
		  }

		  public void paint(Graphics g) {
			  super.paint(g);
		    g.setColor (Color.blue);  
		    g.drawArc (200, 200, 100, 100, -90, 90);
		    g.drawArc(200, 200, 100, 100, 0, 90);
		    g.draw3DRect(0, 0, 2000, 1400, true);
		    g.setColor(Color.cyan);
		    g.fill3DRect(0, 0, 2000, 1400, true);
		    g.draw3DRect(0, 700, 1500, 200, true);
		    g.setColor(Color.green);
		    g.fillRect(0, 700, 1500, 200);
		    g.setColor(Color.black);
		    g.fill3DRect(100, 500, 100, 200, true);
		    g.drawArc(100, 350, 100, 200, 0, 120);
		    
		    //g.fillArc(100, 350, 100, 200, 0, 120);
		    g.drawLine(150,400,100,500);
		    g.drawLine(122,366,200,450);
		    
		    
		   
		    
			
			
			
			
		  }
		  
		

	}


