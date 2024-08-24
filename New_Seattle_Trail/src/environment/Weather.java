package environment;

public class Weather {
	public Temperature temperature;
	public Conditions conditions;
	public Environment environment;
	public Type type;
	public double hungerRate;
	public double thirstRate;
	public double coldRate;
	public double percentChanceInjury;
	public double percentChanceLost;
	
	public enum Temperature{
		WARM,COLD,EXTREME_COLD
	}
	
	public enum Conditions{
		LOW_VISIBILITY,HIGH_VISIBILITY,NO_VISIBILITY,FULL_VISIBILITY
	}
	
	public enum Environment{
		SLIPPERY,WET,NOT_SLIPPERY
	}
	
	public enum Type{
		LIGHT_RAIN,HEAVY_RAIN,HAIL,SNOW,SUNNY,CLOUDY,STORM,LIGHT_FOG,HEAVY_FOG
	}

	public Weather(Temperature temp, Conditions conditions,Environment environment,Type type) {
		this.temperature = temp;
		this.conditions = conditions;
		this.environment = environment;
		this.type = type;
	}
	public Weather() {
		this.temperature = Temperature.WARM;
		this.conditions = Conditions.FULL_VISIBILITY;
		this.environment = Environment.NOT_SLIPPERY;
		this.type = Type.SUNNY;
	}
	
	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
	
	public void setConditions(Conditions conditions) {
		this.conditions = conditions;
	}
	
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	public void setType(Type type) {
		if(type.equals(Type.SUNNY)) {
			this.environment = Environment.NOT_SLIPPERY;
			this.conditions = Conditions.FULL_VISIBILITY;
		}
		if(type.equals(Type.LIGHT_FOG)) {
			this.environment = Environment.NOT_SLIPPERY;
			this.conditions = Conditions.HIGH_VISIBILITY;
		}
		if(type.equals(Type.CLOUDY)) {
			this.environment = Environment.NOT_SLIPPERY;
			this.conditions = Conditions.FULL_VISIBILITY;
		}
		if(type.equals(Type.HEAVY_FOG)) {
			this.environment = Environment.NOT_SLIPPERY;
			this.conditions = Conditions.LOW_VISIBILITY;
		}
		if(type.equals(Type.LIGHT_RAIN)) {
			this.environment = Environment.WET;
			this.conditions = Conditions.FULL_VISIBILITY;
		}
		if(type.equals(Type.HAIL)) {
			this.environment = Environment.WET;
			this.conditions = Conditions.FULL_VISIBILITY;
		}
		if(type.equals(Type.HEAVY_RAIN)) {
			this.environment = Environment.SLIPPERY;
			this.conditions = Conditions.LOW_VISIBILITY;
		}
		if(type.equals(Type.STORM)) {
			this.environment = Environment.SLIPPERY;
			this.conditions = Conditions.NO_VISIBILITY;
		}
		if(type.equals(Type.SNOW)) {
			this.environment = Environment.SLIPPERY;
			this.conditions = Conditions.LOW_VISIBILITY;
		}
	}
}

