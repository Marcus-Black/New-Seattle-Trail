package environment;

public class Weather {
	public Temperature temperature;
	public Conditions conditions;
	public Environment environment;
	public Type type;
	public double hungerRate;
	public double thirstRate;
	public double coldRate;
	public double percentChanceSlipInjury;
	public double percentChanceLost;
	public double energyRate;
	public double extraDamageRate;
	
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
			this.coldRate = 10.0;
			this.hungerRate = -5.0;
			this.thirstRate = -18.0;
			this.energyRate = -15.0;
			this.percentChanceSlipInjury = 5.0;
			this.percentChanceLost = 3.0;
		}
		if(type.equals(Type.LIGHT_FOG)) {
			this.environment = Environment.NOT_SLIPPERY;
			this.conditions = Conditions.HIGH_VISIBILITY;
			this.coldRate = -5.0;
			this.hungerRate = -5.0;
			this.thirstRate = -10.0;
			this.energyRate = -12.0;
			this.percentChanceSlipInjury = 15.0;
			this.percentChanceLost = 20.0;
		}
		if(type.equals(Type.CLOUDY)) {
			this.environment = Environment.NOT_SLIPPERY;
			this.conditions = Conditions.FULL_VISIBILITY;
			this.coldRate = -5.0;
			this.hungerRate = -5.0;
			this.thirstRate = -10.0;
			this.energyRate = -12.0;
			this.percentChanceSlipInjury = 6.0;
			this.percentChanceLost = 4.0;
		}
		if(type.equals(Type.HEAVY_FOG)) {
			this.environment = Environment.NOT_SLIPPERY;
			this.conditions = Conditions.LOW_VISIBILITY;
			this.coldRate = -9.0;
			this.hungerRate = -10.0;
			this.thirstRate = -10.0;
			this.energyRate = -13.0;
			this.percentChanceSlipInjury = 45.0;
			this.percentChanceLost = 70.0;
		}
		if(type.equals(Type.LIGHT_RAIN)) {
			this.environment = Environment.WET;
			this.conditions = Conditions.FULL_VISIBILITY;
			this.coldRate = -15.0;
			this.hungerRate = -5.0;
			this.thirstRate = -10.0;
			this.energyRate = -20.0;
			this.percentChanceSlipInjury = 20.0;
			this.percentChanceLost = 15.0;
		}
		if(type.equals(Type.HAIL)) {
			this.environment = Environment.WET;
			this.conditions = Conditions.FULL_VISIBILITY;
			this.coldRate = -25.0;
			this.hungerRate = -5.0;
			this.thirstRate = -10.0;
			this.energyRate = -25.0;
			this.percentChanceSlipInjury = 25.0;
			this.percentChanceLost = 28.0;
			this.extraDamageRate = 8.0;
		}
		if(type.equals(Type.HEAVY_RAIN)) {
			this.environment = Environment.SLIPPERY;
			this.conditions = Conditions.LOW_VISIBILITY;
			this.coldRate = -40.0;
			this.hungerRate = -5.0;
			this.thirstRate = -10.0;
			this.energyRate = -30.0;
			this.percentChanceSlipInjury = 22.0;
			this.percentChanceLost = 25.0;
		}
		if(type.equals(Type.STORM)) {
			this.environment = Environment.SLIPPERY;
			this.conditions = Conditions.NO_VISIBILITY;
			this.coldRate = -50.0;
			this.hungerRate = -5.0;
			this.thirstRate = -10.0;
			this.energyRate = -45.0;
			this.percentChanceSlipInjury = 85.0;
			this.percentChanceLost = 80.0;
			this.extraDamageRate = 4.0;
		}
		if(type.equals(Type.SNOW)) {
			this.environment = Environment.SLIPPERY;
			this.conditions = Conditions.LOW_VISIBILITY;
			this.coldRate = -70.0;
			this.hungerRate = -25.0;
			this.thirstRate = -10.0;
			this.energyRate = -35.0;
			this.percentChanceSlipInjury = 45.0;
			this.percentChanceLost = 55.0;
		}
	}
}

