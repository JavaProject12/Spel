package project;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel { 
	
	Image archer = Toolkit.getDefaultToolkit().getImage("src/images/40e2d3d4ebef924992b7d8fdfa5bfc1f.png");
	Image underline = Toolkit.getDefaultToolkit().getImage("src/images/154.png");
	JButton b = new JButton("START");
	JLabel l = new JLabel("Arrow");
	String state = "MainMenu";
	MainFrame frame;

	public MainMenuPanel(MainFrame f) {
		frame = f;
		
		setLayout(null);	
		
		
		b.setBounds(175,250, 150, 50);
		b.setFont(new Font("Broadway", Font.PLAIN, 24));
		add(b);
		
		b.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	       frame.SwitchPanel("level");
	       
	      }
	    });
		
		l.setFont(new Font("CASTELLAR", Font.PLAIN, 50));
		l.setBounds(135, 75, 300, 100);
		add(l);
		
		
		
		
	}
	public void paintComponent(Graphics g) {
		
		g.drawImage(underline,90, 10, 300, 300, this);
		g.drawImage(archer,500, 230, 250, 400, this);
		
		
	}
	

}
