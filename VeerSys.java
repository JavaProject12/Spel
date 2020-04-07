package maart30;
// voor start/stop/resetten mss best met cases

public class VeerSys {

	int beginxpos;
	int beginypos;
	int xposbal;
	int yposbal;
	double snelh = 0.2;
	int tijd = 0;
	double hoek = 1;
	int start = 0;
	int binnen = 1;
	
	
	public VeerSys(int beginxpos, int beginypos) {
		this.xposbal = beginxpos;
		this.yposbal = beginypos;
		this.beginxpos = beginxpos;
		this.beginypos = beginxpos;
	}
	
	public double getHoek() {
		return hoek;
	}
	
	public void posChange(int x, int y, double h) {
		xposbal += x;
		yposbal -= y;
		hoek += h;
	}

	
	public void startstop() {
		
		start = 1;

	}
	
	public void beginpos() {
		start = 0;
		xposbal = beginxpos;
		yposbal = beginypos;
		tijd = 0;
	}
	
	public void update() {
		if(start == 1 & xposbal <= 750 & xposbal >= 0 & yposbal <= 750 ) {
			double vx = Math.cos(hoek)*snelh;
			double vy = Math.sin(hoek)*snelh;
			tijd += 20;
			yposbal -= vy*20;
			yposbal += 0.00001*(tijd)*tijd;
			xposbal += vx*20;
		}
		
		 
		

			
	
		
	}

}
