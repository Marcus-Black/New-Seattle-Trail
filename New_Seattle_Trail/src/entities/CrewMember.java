package entities;

import java.util.Random;

public class CrewMember extends Entity {
	public int age;
	public int hunger = 100;
	public int thirst = 100;
	public int HRate;
	public int TRate;
	public Gender gender;
	public Profession profession;
	public AgeRange agerange;
	public int temp = 100;
	
	public enum AgeRange{
		YOUNG,OLD,MIDDLE_AGED
	}
	public enum Gender{
		MALE,FEMALE
	}
	public enum Profession{
		BARISTA,UNEMPLOYED,CRYPTO_BRO,CHEF,SOFTWARE_ENGINEER,STUDENT,MECHANIC,RETIRED,BUS_DRIVER,JUDGE,FARMER,POLICE,TEACHER
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

	public CrewMember(String name,Gender gender,Profession profession,
			Health_Status H_stat,Action_Status A_stat) {
		this.name = name;
		this.H_stat = H_stat;
		this.A_stat = A_stat;
		this.gender = gender;
		this.profession = profession;
		setCharacterStats();
		Crew.AddCrewMember(this);
		
	}
	public void setCharacterStats() {
		if(this.profession == Profession.UNEMPLOYED) {
			Random ra = new Random();
			ra.nextInt(10, 30);
			this.agerange = AgeRange.YOUNG;
		}
	}

	@Override
	public String toString() {
		return null;
	}

}
