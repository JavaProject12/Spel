package maart30;

public class VeerSys {


	int xpos;
	int ypos;
	double snelh = 0.5;
	int tijd = 0;
	double hoek = 1;

	
	public VeerSys(int xpos, int ypos) {
		this.xpos = xpos;
		this.ypos = ypos;

	}
	
	
	
	public void posChange(int x, int y, double h) {
		xpos += x;
		ypos += y;
		hoek += h;
	}
	
	
	
	public void update() {

			double vx = Math.cos(hoek)*snelh;
			double vy = Math.sin(hoek)*snelh;
			tijd += 20;
			ypos -= vy*20;
			ypos += 0.00001*(tijd)*tijd;
			xpos += vx*20;
	
		
	}

}
