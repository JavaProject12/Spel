// commentaar
import java.awt.Color;
import java.awt.Graphics; // hey

public class Ground {
	int h,b;
	
	public Ground() {
		this.h=100;
		this.b=750;
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0,400, b, h);
		
		
	}
	

}
