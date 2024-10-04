package items.Equipment;

import java.util.Map;

import items.Consumables.*;

public class Tent extends Craftable {
	public double price;
	public double weight;
	static Rope rope;
	static Stick stick;
	static Cloth cloth;
	static Tape tape;
	public Map<Consumable, Integer> requirements = Map.of(rope,1,stick,4,tape,1,cloth,8);

	public Tent() {
		
	}
}
