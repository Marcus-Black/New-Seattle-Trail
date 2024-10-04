package entities;

import java.util.Random;
import java.util.*;
import ailments.Ailment;
import items.Equipment.*;

public class CrewMember extends Entity {
	public int age;
	public int hunger = 100;
	public int thirst = 100;
	public int energy = 100;
	public int HRate;
	public int TRate;
	public int ERate;
	public double perceptiveness;
	public Gender gender;
	public Profession profession;
	public AgeRange agerange;
	public int temp = 100;
	public HashSet<EquipmentBase> personalEquipment = new HashSet<EquipmentBase>();
	public ArrayList<Ailment> ailments = new ArrayList<Ailment>();

	
	public enum AgeRange{
		YOUNG,OLD,MIDDLE_AGED
	}
	public enum Gender{
		MALE,FEMALE
	}
	public enum Profession{
		BARISTA,UNEMPLOYED,CRYPTO,CHEF,SOFTWARE_ENGINEER,STUDENT,MECHANIC,RETIRED,BUS_DRIVER,JUDGE,FARMER,POLICE,TEACHER
	}
	//Barista(give coffee and speed up movement)
	//Unemployed(
	//Crypto_Bro(High persuasion)
	//Chef(food satiates hunger for longer)
	//Software_Engineer(
	//Biology_Student(Can help determine how to help bug-bites/infections and what ingredients to use)
	//Mechanic(Can fix if tools/equipment gets broken)
	//Retired(Start with more money)
	//Bus_driver(Navigate the trail better, crew less likely to go off trail)
	//Judge(Can receive more info on choices before making)
	//Farmer(Harvest plants nearby)
	//Police(Can shoot precisely and hunt better)
	//Teacher(

	public CrewMember(String name,Gender gender,Profession profession) {
		this.name = name;
		this.gender = gender;
		this.profession = profession;
		setCharacterStats();
		Crew.AddCrewMember(this);
		
	}
	public void setCharacterStats() {
		if(this.profession == Profession.UNEMPLOYED) {
			Random ra = new Random();
			this.age = ra.nextInt(10, 30);
			this.agerange = AgeRange.YOUNG;
		}
	}
	
	public boolean setEquipment(EquipmentBase equipment) {
		boolean success;
		if(personalEquipment.add(equipment)) {
			success = true;
		}else {
			success = false;
		}
		return success;
		
	}
	
	public void removeEquipment(EquipmentBase equipment) {
		personalEquipment.remove(equipment);
		if(Crew.Equipment.containsKey(equipment)) {
		Crew.Equipment.put(equipment, Crew.Equipment.get(equipment)+1);
		}else {
			Crew.Equipment.put(equipment, 1);
		}
		
	}
	
	public void removeAilment(Ailment ailment) {
		for(int i = 0; i < ailments.size();i++) {
		if(ailments.get(i).equals(ailment)) {
			ailments.remove(i);
			System.out.println(ailment + " has been remedied from " + this.name);
		}
		}
	}
	
	public void addAilment(Ailment ailment) {
		String result;
		boolean has = false;
		for(int i = 0; i < ailments.size();i++) {
			if(ailments.get(i).equals(ailment)) {
				has = true;
				result = this.name + " already has " + ailment.getClass().getName();
				break;
				
			}
				
			}
		if(!has) {
			ailments.add(ailment);
			this.health -= ailment.healthLostAtOnce;
			result = this.name + " now has " + ailment.getClass().getName() + ". " + this.name + " lost " + ailment.healthLostAtOnce + " health";
	}
}
	
		
	
	@Override
	public String toString() {
		String equipments = "";
		String ails = "";
		String result = String.format(this.name + "%10s",this.profession+
				"%10d",this.age + "%10s \n",this.gender, this.hunger + "\n" + this.thirst + "\n" + this.energy +"    "+ this.temp + "     " + this.perceptiveness);
		for(EquipmentBase equipment : personalEquipment) {
				equipments += equipment.getClass().getName() + "    ";
		}
		for(Ailment ailment : ailments) {
				ails += ails + ailment.getClass().getName() + "    "; 
		}
		result += equipments + "\n" + ails;
		
		return result;
	}

}
