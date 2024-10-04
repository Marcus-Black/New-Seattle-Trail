package items.Equipment;

import java.util.Map;

import items.Consumables.*;


public class MakeShiftPot extends Craftable {
	public double price;
	public double weight;
	static ScrapMetal scrap;
	public Map<Consumable, Integer> requirements = Map.of(scrap,4);

	public MakeShiftPot() {
		// TODO Auto-generated constructor stub
	}

}
