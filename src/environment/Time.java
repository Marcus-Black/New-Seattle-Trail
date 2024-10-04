package environment;

public class Time {
	public static TimeOfDay time;
	public static double timein24hours;
	
	public enum TimeOfDay{
		MORNING,DAY,EVENING,NIGHT
	}

	public Time() {
		
	}
	
	public static void setTime(TimeOfDay time) {
			time = time;
	}

}
