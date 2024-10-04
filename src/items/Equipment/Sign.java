package items.Equipment;

import java.util.Map;

import items.Consumables.*;

public class Sign extends Craftable {
	public double price;
	public double weight;
	static Marker marker;
	static WoodenPlank plank;
	public Map<Consumable, Integer> requirements = Map.of(marker,1,plank,4);

	public Sign() {
		// TODO Auto-generated constructor stub
	}
	
}
