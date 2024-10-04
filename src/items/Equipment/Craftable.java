package items.Equipment;
import java.util.*;

import entities.Crew;
import items.Consumables.*;

public class Craftable extends EquipmentBase{
 static BearLine bearLine = new BearLine();
 static FishingPole fishingPole = new FishingPole();
 static HikingPole hikingPole = new HikingPole();
 static MakeShiftCoat makeShiftCoat = new MakeShiftCoat();
 static MakeShiftPot makeShiftPot = new MakeShiftPot();
 static Shovel shovel = new Shovel();
 static Sign sign = new Sign();
 static Tent tent = new Tent();
 public static Craftable[] craftables = new Craftable[] {bearLine,fishingPole,hikingPole,makeShiftCoat,makeShiftPot,shovel,sign,tent};
	public Map<Consumable, Integer> requirements;

	public Craftable() {
		
	}
	
			
}
