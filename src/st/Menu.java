package st;
import java.io.*;
import java.util.*;

import entities.Crew;
import entities.CrewMember;
import st.GameRunner;
import items.Consumables.*;
import items.Equipment.Craftable;
import items.Equipment.EquipmentBase;


public class Menu {
	public boolean market;
	public boolean town;
	public boolean river;
	

	public Menu() {
		}


public static void printAndChooseMainMenuOptions() {
	int choice;
	System.out.println("-----Main Menu-----");
	System.out.println("1: Continue on the Seattle Trail\n2: Stop and Rest\n3: Check Supplies\n4: Character Stats\n5: Change Pace\n6: Crafting\n7: Interact with Environment");
	//while();
	try(Scanner scanner = new Scanner(System.in)){
		choice = scanner.nextInt();
		switch(choice) {
		case 1:
			GameRunner.startGameMoveCrew();
		case 2:
			//time increases by amount based on speed
			//character stat changes/sleep/nightmare chance/change in weather chance
			//return to main menu
		case 3:
						
		case 4:
			
		case 5:
			
		case 6:
			
		case 7:
		}
	}catch(Exception e) {
		System.out.println("Whoops, looks like you input an incorrect value, try again");
	}
}

public static String printSuppliesSetHashSet() {
	String result = "-----Consumables----\n\n";
	int x = 1;
	for(Consumable entry : Crew.consumableTypes) {
		result += x + ": " + entry.getClass().getName() + "\n";
		Crew.Supplieschoice.put(x, entry);
		x++;
	}
	int y = x+1;
	result += "\n\n-----Equipment-----\n\n";
	for(EquipmentBase entry : Crew.equipmentTypes) {
		result += y + ": " + entry.getClass().getName() + "\n";
		Crew.Supplieschoice.put(y, entry);
		y++;
	}
	return result;
}


public static String printCrewMembersSetHashSet() {
	String result = "";
	int x = 1;
	for(CrewMember member: Crew.Team) {
		result += x + ": " + member.name;
		Crew.Crewchoice.put(x, member);
		x++;
	}
	return result;
	
}

public static void suppliesToBeUsedAction() {
	Scanner input = new Scanner(System.in);
	Menu.printSuppliesSetHashSet();
	System.out.println("0: Return to main menu");
	System.out.println("Please select which item number you would like to do an action on");
	int chosen = input.nextInt();
	if(chosen == 0) {
		Menu.printAndChooseMainMenuOptions();
	}
	else if(Crew.Supplieschoice.containsKey(chosen)) {
		int choice2;
		if(Crew.Supplieschoice.get(chosen) instanceof EquipmentBase) {
			EquipmentBase equip = (EquipmentBase) Crew.Supplieschoice.get(chosen);
			System.out.println("Choose action with equipment");
			System.out.println("1:Drop equipment\n2:Equip item");
			switch(choice2 = input.nextInt()) {
			case 1:
				Crew.dropItem(Crew.Supplieschoice.get(chosen));
				break;
			case 2:
				if(equip.personalEquipment) {
					System.out.println("Who in your crew would you like to equip " + Crew.Supplieschoice.get(chosen).getClass().getName() + " onto?\n");
					Menu.printCrewMembersSetHashSet();
					int choice3 = input.nextInt();
					Crew.moveEquipment((EquipmentBase)Crew.Supplieschoice.get(chosen),Crew.Crewchoice.get(choice3));
				}
				else
					System.out.println("Sorry, can't equip " + Crew.Supplieschoice.get(chosen).getClass().getName() + ". Item is not equipable");
					break;
			}
			
		}
		else {
			Consumable cons = (Consumable) Crew.Supplieschoice.get(chosen);
			System.out.println("Choose action with consumables");
			System.out.println("1:Drop consumable\n2:Use consumable");
			switch(choice2 = input.nextInt()) {
			case 1:
				Crew.dropItem(Crew.Supplieschoice.get(chosen));
				break;
			case 2:
				if(cons.usable) {
					System.out.println("Who in your crew would you like to use " + Crew.Supplieschoice.get(chosen).getClass().getName() + " on?\n");
					Menu.printCrewMembersSetHashSet();
					int choice3 = input.nextInt();
					Crew.useConsumable((Consumable)Crew.Supplieschoice.get(chosen),Crew.Crewchoice.get(choice3));
				}
				else
					System.out.println("Sorry, can't use " + Crew.Supplieschoice.get(chosen).getClass().getName() + ". Item is not usable");
				break;
			}				
		}
			
		}
	else {
		System.out.println("Sorry, that is not a valid option");
	}
	Menu.printAndChooseMainMenuOptions();
	
	
}


public static String printCraftableSetHashMap() {
	String result = "-----Craftable Items-----\n\n";
	int x = 1;
	for(Craftable craft : Craftable.craftables) {
		result += x + ": " + craft.getClass().getName() + "   " + craft.requirements.entrySet();
		Crew.craftChoice.put(x, craft);
		x++;
	}
	result += "\n\n-----Craftable items that require more ingredients-----\n\n";
	for(int i = 0; i < Craftable.craftables.length;i++) {
	if(!Crew.craftChoice.containsValue(Craftable.craftables[i])) {
		result += Craftable.craftables[i] + "\n";
	}
	
}
	return result;
}

public static void 


















public void printAndChooseCharacterStats() {
	Scanner scanner = new Scanner(System.in);
	
}
public void findItemsToCraft() {
	
}
public void printAndChooseCrafting() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Choose items to craft:");
	
}
public void interactWithEnvironment() {
	//check where they are, if at water allow certain options
	//check if they have a shovel to dig
	//
}

}

/*Standard menu options
 Continue on the trail
 Stop and rest
 Check supplies
 See character stats
 Change pace
 Hunt for food(minigames?)
 crafting
 

river crossing(drink water/fish if pole)
market (buy/sell goods)
town (talk to locals, talk to NPC's)
abandoned building (check inside)




*/