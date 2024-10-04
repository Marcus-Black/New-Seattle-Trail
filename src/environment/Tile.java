package environment;

import environment.Terrain.Path;
import environment.Weather.Conditions;
import environment.Weather.Environment;
import environment.Weather.Temperature;
import environment.Weather.Type;
import probability.Probability;
import choices.*;
import java.util.*;

import entities.Companion;
import entities.Crew;
import entities.Crew.*;
import items.Consumables.*;

public class Tile {
	public Weather weather;
	public Time time;
	public Terrain terrain;
	public int xPos;
	public int yPos;
	public boolean containsCrew;
//	public boolean containsBF;
//	public boolean containsNPC;
//	public boolean containsCompanion;
	public ArrayList<Event> events = new ArrayList<>();
	public Consumable consumable;
	public Companion companion;
	

	public Tile() {
		Weather weatherIN = new Weather();
		Terrain terrainIN = new Terrain();
		this.weather = weatherIN;
		this.terrain = terrainIN;
		this.containsCrew = false;
//		this.containsBF = false;
//		this.containsNPC = false;
//		this.containsCompanion = false;
	}
		
	public void setXPos(int x) {
		this.xPos = x;
	}
	public void setYPos(int y) {
		this.yPos = y;
	}
	
	public void createStandardEvents() {
		//create events based on conditions/time

		
		
	}
	public void environmentInteractionEvents() {
		if(this.terrain.plantOrAnimal == Terrain.PlantAndAnimalEncounters.SNAKE) {
			
		}		
	}
	
	public void eventTriggers() {
		
	}
	//if carrying raw meat,increase chance of biting flies/misquitos

}
