package entities;
import globalID.Global_ID;
import st.*;

public abstract class Entity {
	
	public double health = 100;
	public String name;
	public int ID;
	public static int CID = 1;
	public int globalID;
	public int XPos;
	public int YPos;
	public double speed;
	public Health_Status H_stat;
	public Action_Status A_stat;
	
	
	public enum Health_Status {
		ALERT,DEAD,FATIGUED,ENERGETIC,DEHYDRATED,HUNGRY
	}
	public enum Action_Status {
		OCCUPIED,UNOCCUPIED	
	}
	
	public Entity() {
		this.ID = this.CID;
		CID++;
	}

	public Entity(double health,String name,int XPos, int YPos,double speed,Health_Status H_stat,Action_Status A_stat) {
		Global_ID gID = new Global_ID(this);
		this.health = health;
		this.name = name;
		this.XPos = XPos;
		this.YPos = YPos;
		this.ID = this.CID;
		this.CID++;
		this.globalID = gID.getGlobalID();
		this.speed = speed;
		this.H_stat = H_stat;
		this.A_stat = A_stat;
	}
	
	public Entity(double health,String name,Health_Status H_stat,Action_Status A_stat) {
		Global_ID gID = new Global_ID(this);
		this.health = health;
		this.name = name;
		this.ID = this.CID;
		this.CID++;
		this.globalID = gID.getGlobalID();
		this.H_stat = H_stat;
		this.A_stat = A_stat;
	}
	
	public void moveNumOfSpaces(int x,int y) {
		if(x < 0) {
			this.XPos -= x;
		}
		else if(y < 0) {
			this.YPos -= y;
		}
		else {
		this.XPos += x;
		this.YPos += y;
	}
	}
	public void setXandY(int XPos, int YPos) {
		this.XPos = XPos;
		this.YPos = YPos;
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
	public void setHealthStat(Health_Status H_stat) {
		this.H_stat = H_stat;
	}
	
	public void takeDamage(double damage) {
		this.health -= damage;
		if(this.health <= 0)
			setHealthStat(Health_Status.DEAD);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setActionStat(Action_Status status) {
		this.A_stat = status;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	@Override
	public abstract String toString();

}
