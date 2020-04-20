package maart30;


public class VeerSys {

	int beginxpos, beginypos; // starting position of the arrow
	int xposbal, yposbal; // position of the arrow (at rest or while moving)
	double snelh = 0.2; // initial speed of the arrow
	int tijd = 0; //time
	double hoek = Math.PI/2; // initial angle of the arrow
	int start = 0; // start = 0 if the arrow is at rest and = 1 if fired

	double vx; //speed along the x-axis
	double vy; // speed along the y-axis

	double pos1x, pos1y, pos2x, pos2y; // see update() method
		
	double m; // slope of the arrow while in movement
	
	int geraakt = 0; // geraakt = 1 if the arrow has touched the target

	
	double raakhoek; //angle of slope m
	

	
	public VeerSys(int beginxpos, int beginypos) {
		this.xposbal = beginxpos;
		this.yposbal = beginypos;
		this.beginxpos = beginxpos;
		this.beginypos = beginxpos;

		
	}
	
	
	public void posChange(int x, int y, double h) { //method that allows you to change the position or angle of the ball
		xposbal += x;
		yposbal -= y;
		hoek += h;
	}

	
	public void startstop() { //changes start to 1
		start = 1;
		}		

	
	
	public void geraakt() { //changes value of geraakt to 1
		geraakt = 1;
	}

	
	public void update() { // updates the position of the arrow when fired (while taking gravity into account) 
		if(start == 1 & xposbal <= 750 & xposbal >= -30 & yposbal <= 750 & geraakt == 0 ) {
			vx = Math.cos(hoek)*snelh;
			vy = Math.sin(hoek)*snelh;
			
			tijd += 20;
			
			pos1x = xposbal; 
			pos1y = yposbal; //x- and y-coordinate of the arrow before updating the position

			yposbal -= vy*20;
			yposbal += 0.00001*(tijd)*tijd;
			xposbal += vx*20;
			
			pos2x = xposbal;
			pos2y = yposbal;// after updating the position
			
			m = (pos2y - pos1y)/(pos2x - pos1x); // (delta y)/(delta x)
			raakhoek = Math.atan(m);
			
		}
		
		
		 
		

			
	
		
	}

}
