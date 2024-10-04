package items.Equipment;

import java.util.Map;

import items.Consumables.Consumable;
import items.Consumables.Stick;
import items.Consumables.Tape;

public class HikingPole extends Craftable {
	public double price;
	public double weight;
	public double slipResistence;
	public boolean personalEquipment = true;
	static Tape tape;
	static Stick stick;
	public Map<Consumable, Integer> requirements = Map.of(tape,1,stick,4);

	public HikingPole() {
		// TODO Auto-generated constructor stub
	}
	
}
