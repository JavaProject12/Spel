package maart30;

public class LevelData {
	static int xposbal;
	static int yposbal;
	static int xposdoel;
	static int yposdoel;
	static int snelheid;
	static int doelafstandx, doelafstandy;
	public void Level(int level) {
		switch(level) {
		case 1:
			xposbal = 300;
			yposbal =  300;
			xposdoel = 500;
			yposdoel = 500;
			
			snelheid = 0;
			
			
	
			break;
		case 2:
			xposbal = 500;
			yposbal = 325;
			xposdoel = 700;
			yposdoel = 100;
			
			snelheid = 0;

			break;
		case 3:
			xposbal = 150;
			yposbal = 500;
			xposdoel = 350;
			yposdoel = 350;
			
			snelheid = 1;
			doelafstandx = 50;
		
		}
		
	}

}
