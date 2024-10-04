package choices;

public abstract class ChoicesInfo {
	public Choices choice;
	
	public enum Choices{
		USE_REMEDY,CROSS_RIVER,FEED_SQUIRRELS
	}

	public ChoicesInfo(Event event) {
		printOptionInfo(event);
		
	}
	
	public abstract void printOptionInfo(Event event);
	//this.choice = choice;
	


	////Stumble upon fork in the road(left or right),
	//Look for shelter nearby(Take shelter if it is close enough),
	//cross river(or look for nearby bridge),speed up,slow down,
	//look for shelter(if raining/hailing),
	//Check what sound is(Takes time and momentum from crew but can help you not get ambushed by bigfoot or squierrels), 
	//Drink water from river
}
