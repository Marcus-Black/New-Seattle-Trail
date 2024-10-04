package environment;

import java.util.ArrayList;
import java.util.HashMap;

import ailments.Ailment;
import entities.Crew;
import probability.Probability;
import items.Items;

public class Terrain {
	public Type type;
	public Path path;
	public CampRating campRating;
	public PlantAndAnimalEncounters plantOrAnimal;
	public Building building;
	public boolean occupied;
	public double damage;
	public ArrayList<Ailment> ailments = new ArrayList<Ailment>();
	public HashMap<Items,Integer> itemsPresent = new HashMap();
	
	public enum Type{
		TALL_GRASS,WATER,SNOW,LIGHT_MUDD,HEAVY_MUDD,FOREST,FIRSTPOI,SECONDPOI,THIRDPOI,FOURTHPOI,FIFTHPOI,START,END,GRASS
	}
	public enum Path{
		TRAIL,NOT_TRAIL,BRIDGE
	}
	public enum CampRating{
		GOOD_CAMPSITE,BAD_CAMPSITE,GREAT_CAMPSITE,NO_CAMPSITE
	}
	public enum PlantAndAnimalEncounters{
		BLACK_BERRY_BUSH,CITRONELA_PLANT,STINGING_NETTLES,DEER_CARCASS,MYSTERY_MEAT,POISON_OAK,SNAKE,WASP_NEST,SWORD_FERN
	}
	public enum Building{
		MARKET,TOWN,ABANDONED_BUILDING
	}
	

	public Terrain(Type type,Path path) {
		this.type = type;
		this.path = path;
	}
	public Terrain() {
		this.type = Type.GRASS;
		this.path = Path.NOT_TRAIL;
	}
	public void setType(Type type) {
		this.type = type;
		this.occupied = true;
		
	}
	public void setPath(Path path) {
		this.path = path;
	}
	public void setPlants(PlantAndAnimalEncounters plantOrAnimal) {
		this.plantOrAnimal = plantOrAnimal;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public void PAInteractions(PlantAndAnimalEncounters plantOrAnimal) {
		if(plantOrAnimal == PlantAndAnimalEncounters.BLACK_BERRY_BUSH) {
			
		}
		if(plantOrAnimal == PlantAndAnimalEncounters.CITRONELA_PLANT) {
			
		}
		if(plantOrAnimal == PlantAndAnimalEncounters.STINGING_NETTLES) {
			
	
		}
		if(plantOrAnimal == PlantAndAnimalEncounters.DEER_CARCASS) {
			//choice
	
		}
		if(plantOrAnimal == PlantAndAnimalEncounters.MYSTERY_MEAT) {
			//choice
	
		}
		if(plantOrAnimal == PlantAndAnimalEncounters.POISON_OAK) {
			
		}
		if(plantOrAnimal == PlantAndAnimalEncounters.SNAKE) {
			for(int i = 0;i < Crew.Team.size();i++) {
				if(Probability.perceptionBasedChance(Crew.Team.get(i).perceptiveness)) {
						Crew.Team.get(i).
					}
				}
		}
		if(plantOrAnimal == PlantAndAnimalEncounters.WASP_NEST) {
			
		}
		if(plantOrAnimal == PlantAndAnimalEncounters.SWORD_FERN) {
			
		}
		
	}

}
