package entities;

public class Bigfoot extends Entity {
	public Activity activity;
	
	public static enum Activity{
		ACTIVE,INACTIVE
	}

	public Bigfoot() {
		
	}

	public Bigfoot(int XPos, int YPos, double speed,Activity activity) {
		this.XPos = XPos;
		this.YPos = YPos;
		this.speed = speed;
		this.activity = activity;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
