package entities;
import java.util.*;

import items.Consumables.*;
import items.Equipment.*;
import probability.Probability;
import randomNames.NameReader;

import java.lang.*;

public class NPC extends Entity {
	public int age;
	public AgeRange ageRange;
	public Gender gender;
	public int hunger = 100;
	public int thirst = 100;
	public int HRate;
	public int TRate;
	public int Trust = 0;
	public int temp = 100;
	public HashMap<Consumable, Integer> consumablesNeeded = new HashMap<Consumable,Integer>();
	public HashMap<EquipmentBase, Integer> equipmentNeeded = new HashMap<EquipmentBase,Integer>();
	
	public enum Title{
		LAME,BORING,TERRIBLE,AMAZING,FANTASTIC,INCREDIBLE,INJURY_PRONE,GENIUS
	}	
	
	public enum AgeRange{
		YOUNG,OLD,MIDDLE_AGED
	}

	public enum Gender{
		MALE,FEMALE
	}
	

	public NPC() {
		this.HRate = Probability.RandomUpperLower(80, 130);
		this.TRate = Probability.RandomUpperLower(80, 130);
		if(Probability.SetPercentChance(50) == true) {
			this.gender = Gender.MALE;
			int nameChoice1 = Probability.RandomUpperLower(0, NameReader.numMNames + 1);
			this.name = NameReader.MaleNames[nameChoice1];
		}else {
			this.gender = Gender.FEMALE;
			int nameChoice2 = Probability.RandomUpperLower(0, NameReader.numFNames + 1);
			this.name = NameReader.FemaleNames[nameChoice2];
		}		
		this.age = Probability.RandomUpperLower(10,80);
		if(this.age < 30) {
			this.ageRange = AgeRange.YOUNG;
		}
		if(this.age >= 30 && this.age <= 60) {
			this.ageRange = AgeRange.MIDDLE_AGED;
		}
		if(this.age > 60) {
			this.ageRange = AgeRange.OLD;
		}
	}

	public NPC(double health, String name, Health_Status H_stat, Action_Status A_stat) {
		super(health, name, H_stat, A_stat);
		this.age = Probability.RandomUpperLower(10,80);
		if(this.age < 30) {
			this.ageRange = AgeRange.YOUNG;
		}
		if(this.age >= 30 && this.age <= 60) {
			this.ageRange = AgeRange.MIDDLE_AGED;
		}
		if(this.age > 60) {
			this.ageRange = AgeRange.OLD;
		}
	}
	public String NPCEncounter() {
		StringBuilder sb = new StringBuilder();
//		sb.append("Hello Travelers, my name is " + this.name + " I am just a " + this.ageRange + " " + this.gender + " searching for " + this.equipmentNeeded + ". If you happen to trade with me I am willing to trade you for other goods that you may need." + " If you would like I can also come with you on the trail?");
		return sb.toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
