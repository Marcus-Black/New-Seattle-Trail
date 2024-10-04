package choices;

public class Event {
	public Type type;
	public Severity severity;
	
	public enum Severity{
		MINUTE,MODERATE,SEVERE
	}
	//not likely to harm crew,likely to harm crew,will kill a crew member
	
	public enum Type{
		ORCA_ATTACK,BLIZZARD,LOST_IN_PIKESPLACE,CONSTRUCTION,TRAFFIC,SQUIRREL_AMBUSH,
		HEAR_SOUNDS,SEE_SOMETHING_IN_THE_SHADOWS,SEE_SQUIRRELS,SEE_SEAGULLS,SEE_ABANDONED_BUILDING,
		REACH_RIVER,REACH_TALL_GRASS,DARKNESS_APPROACHES,SLEEP,SPLINTER_IN_FOOT
		
		
	}

	public Event(Type type) {
		this.type = type;
		Action();
		
	}
	public void Action() {
		if(this.type == Type.ORCA_ATTACK) {
			
		}
		if(this.type == Type.BLIZZARD) {
			
		}
		if(this.type == Type.LOST_IN_PIKESPLACE) {
			
		}
	}

}


/*
bug bites,Disturb Wasp nest,broken arm,broken leg,sprained ankle,Trench foot,Infection,Flu,
If reach river and have fishing pole give option to fish or to take bridge or to swim across
*/