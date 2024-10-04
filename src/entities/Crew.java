package entities;
import java.util.*;

import items.Consumables.*;
import items.Equipment.*;
import st.Menu;
import items.Items;
import environment.Tile;


public class Crew extends Entity{
	public static double speed = 4;
	public static int XPos;
	public static int YPos;
	public static int CrewAlive = 0;
	public static ArrayList<CrewMember> Team = new ArrayList<>();
	public static HashMap<Consumable, Integer> consumables = new HashMap<Consumable,Integer>();
	public static Set<Consumable>consumableTypes = new HashSet<>();
	public static HashMap<EquipmentBase, Integer> Equipment = new HashMap<EquipmentBase, Integer>();
	public static Set<EquipmentBase>equipmentTypes = new HashSet<>();
	public static HashMap<Integer,Items> Supplieschoice = new HashMap<>();
	public static HashMap<Integer,CrewMember> Crewchoice = new HashMap<>();
	public static HashMap<Integer,Craftable>craftChoice = new HashMap<>();
	public static double luck;
	public static double Discovery;
	public static double money = 1000.00;
	public static double carryingWeight;
	public static double totalAvailableWeight = 250;
	public static boolean overweightLoad = false;
	public static Perk perk;
	public static Companion companion = null;
	public static double itemDropScale;
	
		
	public enum Perk{
		QUICK_FEET,PACK_MULE,COMMON_CENTS,DISCOVERY_CORPS
	}

	public Crew(int XPos, int YPos,int speed) {
		this.XPos = XPos;
		this.YPos = YPos;
		this.speed = speed;
	}
	
	public static void AddCrewMember(CrewMember member) {
		Team.add(member);
		CrewAlive++;
		
	}
		
	public void moveCrew(Tile tile) {
		this.XPos = tile.xPos;
		this.YPos = tile.yPos;
		
	}
	
	public void setPerk(Perk perk) {
		if(perk == Perk.QUICK_FEET) {
			this.speed = 6;
			this.totalAvailableWeight = 200;
		}
		else if(perk == Perk.PACK_MULE) {
			this.totalAvailableWeight = 300;
			this.speed = 3.5;
		}
		else if(perk == Perk.COMMON_CENTS) {
			this.money = 1800.00;
			this.luck = 30.00;
			this.Discovery = 30.00;
			
		}
		else if(perk == Perk.DISCOVERY_CORPS) {
			this.Discovery = 75.0;
			this.luck = 75.0;
			this.money = 350.00;
		}
		this.perk = perk;
		
	}
	
	public String addItem(Items item, int amount) {
		String result = "";
		int totalamount = amount;
		session:
		while(amount > 0) {
		if(totalAvailableWeight >= (item.weight + carryingWeight)) {
		if(item instanceof EquipmentBase) {
		Equipment.put((EquipmentBase)item, Equipment.getOrDefault((EquipmentBase)item, 0)+1);
		equipmentTypes.add((EquipmentBase)item);
		carryingWeight += (item.weight);
		amount--;
		}
		else {
			consumables.put((Consumable)item, consumables.getOrDefault((Consumable)item, 0)+1);
			consumableTypes.add((Consumable)item);
			carryingWeight += (item.weight);
			amount--;
			}
		}
		else {
			result = "Unable to add all " + item.getClass().getName() +"'s to inventory";
			result += "\n" + (totalamount - amount) + " " + item.getClass().getName() +"'s added to inventory";
			break session;
		}
		}
		if(amount == 0) {
			result = "Added all " + item.getClass().getName() +"'s to inventory successfully"; 
		}
		return result;
	}	
	
	public static String moveEquipment(EquipmentBase equipment,CrewMember member) {
		String result;
	if(Equipment.containsKey(equipment)) {
		for(int i = 0; i < Team.size();i++) {
		if(Team.get(i).equals(member)) {
			if(Team.get(i).setEquipment(equipment)) {
				Equipment.replace(equipment, Equipment.get(equipment)-1);
				carryingWeight -= equipment.weight;
			}
		}
	}
		result = equipment + " was successfully placed on " + member.name;
		} else {
			result = "Sorry, unable to set equipment ";
			
		}
		return result;		
	}		
	
	public static String useConsumable(Consumable consumable, CrewMember member ) {
		String result = "Sorry, was unable to use consumable on " + member.name;
		if(consumable.energyGain == false) {
		for(int i = 0; i < member.ailments.size();i++) {
			for(int j = 0; j < member.ailments.get(i).remedies.size();j++) {
				if(member.ailments.get(i).remedies.get(j).equals(consumable)){
					member.removeAilment(member.ailments.get(i));
					result = " ";
				}
		}
		}
		}else if(consumable.energyGain == true) {
			if(member.energy <= 90) {
			member.energy += 10;
		} else {
			member.energy = 100;
		}
			result = member.name + " has gained energy";
		}
				
		return result;
			
		
	}	
		
	public static String dropItem(Items item) {
		Scanner input = new Scanner(System.in);
		int amountTotal;
		String result = "Sorry, unable to drop items";
		HashMap chosen;
		System.out.println("How many " + item.getClass().getName() + "'s would you like to drop?");
		int amountToDrop = input.nextInt();
		if(item instanceof Consumable) {
			chosen = consumables;
		} else {
			chosen = Equipment;
		}
		if(chosen.containsKey(item)) {
			if(amountToDrop > (int) chosen.get(item)) {
				result = ("That appears to be more than you currently have, dropping all of your" + item.getClass().getName() + "s");
				chosen.remove(item);
			}
			else if(amountToDrop == (int) chosen.get(item)) {
				result = ("Dropping all of your" + item.getClass().getName() + "s");
				chosen.remove(item);
			}
			else if(amountToDrop < (int) chosen.get(item)) {
				result = ("Dropping " + amountToDrop + " " + item.getClass().getName() + "s");
				if(chosen == consumables) {
				consumables.put((Consumable)item,((int) consumables.get(item) - amountToDrop));
				itemDropScale -= (item.weight * amountToDrop);
			}else if (chosen == Equipment) {
				Equipment.put((EquipmentBase)item,((int) Equipment.get(item) - amountToDrop));
				itemDropScale -= (item.weight * amountToDrop);
			}
		}	
	}
		return result;
		
		}		
	
	public static String Craft() {
		Scanner input = new Scanner(System.in);
		String result;
		int amountCrafted = 0;
		System.out.println(Menu.printCraftableSetHashMap());
		System.out.println("\n\nPlease choose which item you would like to craft");
		int item = input.nextInt();
		Craftable craftable = Crew.craftChoice.get(item);
		System.out.println("Please choose how many you would like to craft");
		int integer = input.nextInt();
		outerloop:
		while(integer != 0) {
		int IngredientsNeed = craftable.requirements.size();
		for(Map.Entry<Consumable, Integer> entry : craftable.requirements.entrySet()) {
			if(Crew.consumables.containsKey(entry.getKey()) && Crew.consumables.get(entry.getKey())  >= entry.getValue()) {
				IngredientsNeed--;
			}else {
				break outerloop;
			}
		}
		if(IngredientsNeed == 0) {
			Crew.Equipment.put(craftable, Crew.Equipment.get(craftable)+1);
			amountCrafted++;
			}
		}
		result = amountCrafted + " " + craftable.getClass().getName() + "'s were created";
		return result;
	}
	
	
	public static void displayCrewStats() {
		String[] crewStats = new String[Team.size()];
		for(int i = 0; i < Team.size();i++) {
			crewStats[i] = Team.get(i).toString();
			
		}
		for(String stat: crewStats) {
			System.out.println(stat+"\n\n");
		}
	}	
	
	public void newCompanion(Companion companion) {
		this.companion = companion;
		
		
	}
	public void loseCompanion() {
		this.companion = null;
	}
	@Override
	public String toString() {
		return null;
	}

}
