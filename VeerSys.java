package maart30;


public class VeerSys {

	int beginxpos, beginypos;
	int xposbal, yposbal;
	double snelh = 0.2;
	int tijd = 0;
	double hoek = Math.PI/2;
	int start = 0;

	double vx;
	double vy;

	double pos1x;
	double pos1y;
	double pos2x;
	double pos2y;
		
	double m;
	
	int geraakt = 0;

	
	double raakhoek;
	
	VeerDoel doel = new VeerDoel(375,375);
	
	public VeerSys(int beginxpos, int beginypos) {
		this.xposbal = beginxpos;
		this.yposbal = beginypos;
		this.beginxpos = beginxpos;
		this.beginypos = beginxpos;

		
	}
	
	
	public void posChange(int x, int y, double h) {
		xposbal += x;
		yposbal -= y;
		hoek += h;
	}

	
	public void startstop() {
		if(start == 0) {
			start = 1;
		} else {
			start = 0;
		}		

	}
	
	public void geraakt() {
		geraakt = 1;
	}
	

	public void beginpos() {
		start = 0;
		xposbal = beginxpos;
		yposbal = beginypos;
		tijd = 0;
	}
	

	
	public void update() {
		if(start == 1 & xposbal <= 750 & xposbal >= -30 & yposbal <= 750 & geraakt == 0 ) {
			vx = Math.cos(hoek)*snelh;
			vy = Math.sin(hoek)*snelh;
			
			tijd += 20;
			
			pos1x = xposbal;
			pos1y = yposbal;

			yposbal -= vy*20;
			yposbal += 0.00001*(tijd)*tijd;
			xposbal += vx*20;
			
			pos2x = xposbal;
			pos2y = yposbal;
			
			m = (pos2y - pos1y)/(pos2x - pos1x);
			raakhoek = Math.atan(m);
			System.out.println(m);
			
		} else {
			
			xposbal = xposbal;
			yposbal = yposbal;
			
		}
		
		
		 
		

			
	
		
	}

}
