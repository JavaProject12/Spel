package maart30;

public class VeerDoel { //keeps the position of the target
	
	int xposdoel, yposdoel;
	int beginxposdoel, beginyposdoel;
	
	int leveldoel;
	int geraakt = 0;
	int snelheid = 1;
	
	public VeerDoel(int xposdoel, int yposdoel) {
		this.xposdoel = xposdoel;
		this.yposdoel = yposdoel;
		beginxposdoel = xposdoel;
		beginyposdoel = yposdoel;
		
	}
	public void updateDoel() {
		if(geraakt == 0) {
			xposdoel += snelheid;
			if(xposdoel >= beginxposdoel + 50 | xposdoel <= beginxposdoel - 50) {
				snelheid *= -1;
			}
			
		}
		
		
	}
	
	
	

}
