package probability;
import java.lang.*;
import java.util.Random;

import entities.Crew;

public class Probability {

public static boolean SetPercentChance(int prob) {
	if(prob == 1) {
		if(Math.random()*100 > 25) {
			return false;
		}
	}
	else if(prob == 2) {
		if(Math.random()*100 > 50) {
			return false;
			}
	}
	else if(prob == 3) {
		if(Math.random()*100 > 75) {
			return false;
				}	
	}
	
	return true;
}

public static int NumberOfCrewAffected() {
	Random random = new Random();
	return (random.nextInt(1, Crew.CrewAlive + 1));
}
public static int RandomUpperLower(int lowerLimit,int upperLimit) {
	Random random1 = new Random();
	int numberChosen = random1.nextInt(lowerLimit, upperLimit);
	return numberChosen;
}

public static boolean SpecificPercentChance(double percent) {
	boolean result = false;
	Random random = new Random();
	double temp = random.nextDouble(0.0,100.1);
	if(temp >= percent) {
		result = false;
	}
	else if(temp < percent) {
		result = true;
	}
	return result;
}




}