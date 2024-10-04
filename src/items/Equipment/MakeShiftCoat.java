package items.Equipment;

import java.util.Map;

import items.Consumables.*;

public class MakeShiftCoat extends Craftable {
	public double price;
	public double weight;
	public double coldResistence;
	public boolean personalEquipment = true;
	static Cloth cloth;
	static Rope rope;
	public Map<Consumable, Integer> requirements = Map.of(cloth,5,rope,2);

	public MakeShiftCoat() {
		// TODO Auto-generated constructor stub
	}
	
}
