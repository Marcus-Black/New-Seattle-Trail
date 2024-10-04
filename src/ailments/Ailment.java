package ailments;

import java.util.ArrayList;
import java.util.Map;

import entities.Crew;
import items.Consumables.*;

public class Ailment {
	
		public double healthLostAtOnce;
		public double healthLostPerTile;
		public boolean spreadable = false;
		public double spreadablePercent;
		public Consumable currentRemedy;
		public ArrayList<Consumable> remedies = new ArrayList<Consumable>();
		public double hoursAffected;
		public AilmentType ailment;
		public double speedSetback;
		static FirstAidKit FAK = new FirstAidKit();
		static AntiVenom AV = new AntiVenom();
		static Splint S = new Splint();
		static SwordFern SF = new SwordFern();
		
		public enum AilmentType{
			SNAKE_BITE,COVID,BROKEN_LEG,SPRAINED_ANKLE,PARANOIA,FOOD_POISONING,INFECTION,TRENCH_FOOT,HYPOTHERMIA,DYSENTARY,EXHAUSTION,STINGING_NETTLES,BUG_BITES
		}
		public Ailment(AilmentType ailment){
			this.ailment = ailment;
			setAttributes();
		}
		
		public void setAttributes() {
						
			if(this.ailment == AilmentType.SNAKE_BITE) {
				this.healthLostAtOnce = 20;
				this.healthLostPerTile = 5;
				this.spreadable = false;
				this.remedies.add(FAK);
				this.remedies.add(AV);
				this.hoursAffected = 500;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.COVID) {
				this.healthLostAtOnce = 0;
				this.healthLostPerTile = 5;
				this.spreadable = true;
				this.spreadablePercent = 25;
				this.hoursAffected = 50;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.BROKEN_LEG) {
				this.healthLostAtOnce = 10;
				this.healthLostPerTile = 10;
				this.spreadable = false;
				this.remedies.add(S);
				this.hoursAffected = 500;
				this.speedSetback = 4;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.SPRAINED_ANKLE) {
				this.healthLostAtOnce = 5;
				this.healthLostPerTile = 5;
				this.spreadable = false;
				this.remedies.add(FAK);
				this.remedies.add(S);
				this.hoursAffected = 75;
				this.speedSetback = 2;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.PARANOIA) {
				this.healthLostAtOnce = 0;
				this.healthLostPerTile = 0;
				this.spreadable = true;
				this.spreadablePercent = 75;
				this.hoursAffected = 500;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.FOOD_POISONING) {
				this.healthLostAtOnce = 0;
				this.healthLostPerTile = 6;
				this.spreadable = false;
				this.hoursAffected = 50;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.INFECTION) {
				this.healthLostAtOnce = 5;
				this.healthLostPerTile = 20;
				this.spreadable = false;
				this.remedies.add(FAK);
				this.hoursAffected = 500;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.TRENCH_FOOT) {
				this.healthLostAtOnce = 0;
				this.healthLostPerTile = 7;
				this.spreadable = false;
				this.hoursAffected = 500;
				this.speedSetback = 1;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.HYPOTHERMIA) {
				this.healthLostAtOnce = 15;
				this.healthLostPerTile = 30;
				this.spreadable = false;
				this.hoursAffected = 500;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.DYSENTARY) {
				this.healthLostAtOnce = 0;
				this.healthLostPerTile = 8;
				this.spreadable = false;
				this.remedies.add(FAK);
				this.hoursAffected = 75;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.EXHAUSTION) {
				this.healthLostAtOnce = 0;
				this.healthLostPerTile = 5;
				this.spreadable = false;
				this.hoursAffected = 500;
				this.speedSetback = 2;
				checkIfRemedyIsAvailable();
				//sleep helps
			}
			if(this.ailment == AilmentType.STINGING_NETTLES) {
				this.healthLostAtOnce = 5;
				this.healthLostPerTile = 2;
				this.spreadable = false;
				this.remedies.add(SF);
				this.hoursAffected = 50;
				checkIfRemedyIsAvailable();
			}
			if(this.ailment == AilmentType.BUG_BITES) {
				this.healthLostAtOnce = 2;
				this.healthLostPerTile = 0;
				this.spreadable = false;
				this.hoursAffected = 0;
				checkIfRemedyIsAvailable();
				//if using citronela then no bug bites
			}
		}
		public boolean checkIfRemedyIsAvailable() {
			boolean result = false;
			for(Map.Entry<Consumable, Integer> entry : Crew.consumables.entrySet()) {
				for(int i = 0; i < remedies.size();i++) {
					if(remedies.get(i).equals(entry.getKey())){
						result = true;
						currentRemedy = remedies.get(i);
					}
				}
			}
			
			return result;
		}
		
	

}


//snake bite^^D(if perceptiveness is less than 100-perceptiveness = chance, 5% chance of spawn),covid(increased chance if team is low energy/unhealthy)
//broken leg(caused from slippery ground and fast speed)3% base > if slippery
//sprained ankle(caused from slippery ground and fast speed)
//paranoia (caused from lack of sleep, to fix need to get energy to 100 and sleep),food poisoning (caused from not cooking raw meat)
//infection^^,trench foot(caused from stepping on wet/slippery ground for too long)
//hypothermia(caused from cold temp/ bad gear/no fire)
//dysentary (caused from drinking unfiltered/untreated water)
//exhaustion (caused from lack of rest/fast speeds)
//stinging nettles/rash^^D
//bug bites^^D