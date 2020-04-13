import java.awt.Color;
import java.awt.Graphics;

public class Boog {
	int r;
	int dikte;
	int xm;
	int ym;
	int l_pijl;
	int hoek;
	private int xbegin;
	private int ybegin;
	
	public Boog(int xm,int ym,int hoek) {
		this.r=80;
		this.dikte=40;
		this.xm=xm;
		this.ym=ym;
		this.l_pijl=60;
		this.hoek =hoek;
		this.xbegin=60;
		this.ybegin=300;
				
		
				
	}
	public Boog left() {
		xm=(int)(xm-Math.cos((hoek-90)*3.1415/180)*5);
		ym=(int)(ym+Math.sin((hoek-90)*3.1415/180)*5);
		
	
		return  new Boog(xm,ym,hoek);
		
	}
	public Boog right() {
		xm=(int)(xm-Math.cos((hoek-90)*3.1415/180)*(-5));
		ym=(int)(ym+Math.sin((hoek-90)*3.1415/180)*(-5));
		
	
		return  new Boog(xm,ym,hoek);
	}
	public Boog up() {
		hoek=hoek+5;
		
	
		return  new Boog(xm,ym,hoek);
	}
	
		
	
	public void draw(Graphics g) {
		int x_topboog = (int)(xbegin+Math.cos(hoek*3.1415/180)*r/2);			//deze gaan veranderen met rotatie
					//deze gaan veranderen met rotatie
		
		int  y_topboog=(int) (ybegin+r/2-Math.sin(hoek*3.1415/180)*r/2);
		
		int x_benedenboog=(int)(xbegin-Math.cos(hoek*3.1415/180)*r/2);
		int  y_benedenboog=(int) (ybegin+r/2+Math.sin(hoek*3.1415/180)*r/2);
		
		int x_pijlpunt=(int)(xm+Math.cos(hoek*3.1415/180-3.1415/2)*l_pijl);
		int y_pijlpunt=(int)(ym-Math.sin(hoek*3.1415/180-3.1415/2)*l_pijl);
		
		int x_bovenstepijl=(int)(x_pijlpunt+Math.cos((hoek+45)*3.1415/180)*4);
		int y_bovenstepijl=(int)(y_pijlpunt-Math.sin((hoek+45)*3.1415/180)*4);
		
		int x_onderstepijl=(int)(x_pijlpunt-Math.cos((hoek-45)*3.1415/180)*4);
		int y_onderstepijl=(int)(y_pijlpunt+Math.sin((hoek-45)*3.1415/180)*4);
		
		int xm_nieuw=(int)(xm+Math.cos(hoek)*r/2);
		int ym_nieuw=(int)(ym+Math.cos(hoek)*r/2);
		
		
		
		
		g.setColor(Color.DARK_GRAY);
		g.drawArc(xbegin-r/2, ybegin, r, r, hoek,-180 );
		g.setColor(Color.black);
		g.drawLine(x_topboog, y_topboog, xm, ym);
		g.drawLine(xm, ym, x_benedenboog, y_benedenboog);
		
		g.drawLine(xm, ym, x_pijlpunt, y_pijlpunt);
		g.drawLine(x_pijlpunt, y_pijlpunt, x_bovenstepijl, y_bovenstepijl);
		g.drawLine(x_pijlpunt, y_pijlpunt, x_onderstepijl, y_onderstepijl);
		

		
	}
	

}
