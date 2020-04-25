package level;

public class Level {
	public static void main(String[] args) {
		String whichlevel = null;
		int xbegin = 0;
		int xposbal = 0;
		
		
		int levels = 4;
		switch (levels){
		case 1: whichlevel= "level 1";
		break;
		case 2: whichlevel= "level 2";
		break;
		case 3: whichlevel= "level 3";
		break;
		case 4: whichlevel= "level 4";
		break;
		case 5: whichlevel= "level 5";
		break;
		}
		if (xposbal == xbegin) {
			levels++;
		}
		System.out.println(whichlevel);
		
		
	}
}
