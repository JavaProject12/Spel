package project;
//https://alvinalexander.com/java/jbutton-listener-pressed-actionlistener/
//https://stackoverflow.com/questions/3195666/how-to-place-a-jbutton-at-a-desired-location-in-a-jframe-using-java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	
	JPanel p = new JPanel();
	
	String state;
	ArrowPanel ap;
	JButton b;
	
	public MainFrame() {
		
		this.setSize(1300, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PROJECT");
		this.setLocation(20,20);
		p.setSize(1300, 650);
		p.setLocation(20,20);
		
		b = new JButton("Start");
		b.setBounds(650, 325, 100, 20);
		
		b.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	        SwitchPanel("level");
	       
	      }
	    });
		
		p.add(b);
		this.add(p);
		this.setVisible(true);
		p.setVisible(true);
		b.setVisible(true);
		
		
		
		
		
	}
	
	public void SwitchPanel(String s) {
		p.setVisible(false);
		this.remove(p);
		if(s == "level") {
			ap = new ArrowPanel(1);
			this.add(ap);
			ap.setLayout(null);
			ap.setVisible(true);
		}
		
	}
	

    

}
