package entities;

public class Companion extends Entity {
	
	public enum Creature{
		ROOSTER,RACCOON,HEDGEHOG,BULLFROG
	}
	//Can find raccoon at night if traveling
	//can find frog in abandoned building 
	//can find hedgehog in tall grass
	//can find Rooster if woken from nightmare and choose to keep awake

	public Companion() {
		// TODO Auto-generated constructor stub
	}

	public Companion(double health, String name, int XPos, int YPos, int speed, Health_Status H_stat,
			Action_Status A_stat) {
		super(health, name, XPos, YPos, speed, H_stat, A_stat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
