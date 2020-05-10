package project;

public class collision {
	Arrow arrow;
	Target target;
	
	public collision(Arrow x, Target y) {
		arrow = x;
		target = y;
	}
	public boolean Check() {
		
		if(arrow.ArrowTipX <= target.TargetX + 15 
				& arrow.ArrowTipY <= target.TargetY + 15 
				& arrow.ArrowTipX >= target.TargetX - 15
				& arrow.ArrowTipY >= target.TargetY - 15) {
			arrow.moving = false;
			target.TargetHit = true;
			return true;
		}
		else {
			return false;
		}
		
		
	}

}
