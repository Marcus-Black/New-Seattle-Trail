package items.Equipment;

import java.util.Map;

import items.Consumables.*;

public class Shovel extends Craftable {
	public double price;
	public double weight;
	static WoodenPlank plank;
	static ScrapMetal scrap;
	public Map<Consumable, Integer> requirements = Map.of(plank,1,scrap,2);

	public Shovel() {
		// TODO Auto-generated constructor stub
	}
	
}
