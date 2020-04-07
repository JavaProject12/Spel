import java.awt.Color;
import java.awt.Graphics;

public class Roos {
	int xbegin,ybegin,b_stok,h_stok,h,b;


	public Roos() {
		this.xbegin=650;
		this.ybegin=400;
		this.h=15;//hoogte lengte en breedte van de delen van de roos
		this.b=20;
		
		this.h_stok=10;
		this.b_stok=5;
			
		}
	//Hier teken ik de roos met de verschillende kleuren
	public void draw(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(xbegin, ybegin-h_stok, b_stok, h_stok);
		g.setColor(Color.BLACK);
		g.fillArc(xbegin-7, ybegin-h_stok-b, b, b, 180,180);
		g.fillRect(xbegin-7, ybegin-h_stok-h-b/2, b, h);
		g.setColor(Color.BLUE);
		g.fillRect(xbegin-7,ybegin- h_stok-2*h-b/2, b, h);
		g.setColor(Color.RED);
		g.fillRect(xbegin-7,ybegin- h_stok-3*h-b/2,b,h);
		g.setColor(Color.ORANGE);
		g.fillRect(xbegin-7,ybegin- h_stok-3*h-h/2-b/2, b, h/2);
		g.setColor(Color.RED);
		g.fillRect(xbegin-7,ybegin- h_stok-4*h-h/2-b/2, b, h);
		g.setColor(Color.BLUE);
		g.fillRect(xbegin-7,ybegin- h_stok-5*h-h/2-b/2, b, h);
		g.setColor(Color.BLACK);
		g.fillRect(xbegin-7,ybegin- h_stok-6*h-h/2-b/2, b, h);
		g.fillArc(xbegin-7,ybegin- h_stok-6*h-h/2-b,b,b,180,-180);
		
	}
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

}


