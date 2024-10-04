package entities;

public class Companion extends Entity {
	
	public enum Creature{
		ROOSTER,RACCOON,HEDGEHOG,BULLFROG
	}
	//can find raccoon at night if traveling
	//can find frog in abandoned building 
	//can find hedgehog in tall grass
	//can find Rooster if woken from nightmare and choose to keep awake

	public Companion() {
		
	}

	public Companion(String name, int XPos, int YPos) {
		this.name = name;
		this.XPos = XPos;
		this.YPos = YPos;
		
	}
	

	@Override
	public String toString() {
		return null;
	}

}
