package environment;

public class Time {
	public static TimeOfDay time;
	
	public enum TimeOfDay{
		MORNING,DAY,EVENING,NIGHT
	}

	public Time() {
		
	}
	
	public static void setTime(TimeOfDay time) {
			time = time;
	}

}
