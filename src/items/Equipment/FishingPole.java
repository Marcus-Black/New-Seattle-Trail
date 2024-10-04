package items.Equipment;

import java.util.Map;

import items.Consumables.Consumable;
import items.Consumables.FoodRation;
import items.Consumables.Stick;

public class FishingPole extends Craftable {
	public double price;
	public double weight;
	static FoodRation food;
	static Stick stick;
	public Map<Consumable, Integer> requirements = Map.of(food,1,stick,4);

	public FishingPole() {
		// TODO Auto-generated constructor stub
	}
	
}
