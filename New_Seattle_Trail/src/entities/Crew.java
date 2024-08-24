package entities;
import java.util.*;

import entities.Entity.Action_Status;
import entities.Entity.Health_Status;
import items.Consumable;
import items.Equipment;


public class Crew extends Entity{
	public static int XPos;
	public static int YPos;
	public static double speed;
	public static int CrewAlive = 0;
	public static ArrayList<CrewMember> Team = new ArrayList<>();
	public static ArrayList<Consumable> consumables = new ArrayList<>();
	public static ArrayList<Equipment> equipment = new ArrayList<>();
	public int luck;
	public int Discovery;
	
	
	public enum Perk{
		QUICK_FEET,
	}

	public Crew(int XPos, int YPos,int speed) {
		this.XPos = XPos;
		this.YPos = YPos;
		this.speed = speed;
	}
	public static void AddCrewMember(CrewMember member) {
		Team.add(member);
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
