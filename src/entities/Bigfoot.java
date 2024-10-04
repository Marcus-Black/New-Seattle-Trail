package entities;

public class Bigfoot extends Entity {
	public static Activity activity;
	
	public static enum Activity{
		FAR,CLOSE,VERY_CLOSE
	}

	public Bigfoot() {
		
	}

	public Bigfoot(int XPos, int YPos, double speed,Activity activity) {
		this.XPos = XPos;
		this.YPos = YPos;
		this.speed = speed;
		this.activity = activity;
		
	}
	public static void bigfootMove() {
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
