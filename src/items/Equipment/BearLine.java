package items.Equipment;

import java.util.Map;

import items.Consumables.*;

public class BearLine extends Craftable {
	public double price;
	public double weight;
	static Rope rope;
	static Stick stick;
	public Map<Consumable, Integer> requirements = Map.of(rope, 4,stick,2);

	public BearLine() {
		// TODO Auto-generated constructor stub
	}
	
	public String aboutInfo() {
		String result = "This item allows your crew to hangup their backpacks when sleeping to keep animals from stealing food";
		return result;
	}
	
}
