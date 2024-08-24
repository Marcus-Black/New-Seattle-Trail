package environment;

import environment.Terrain.Path;
import environment.Weather.Conditions;
import environment.Weather.Environment;
import environment.Weather.Temperature;
import environment.Weather.Type;

public class Tile {
	public Weather weather;
	public Time time;
	public Terrain terrain;
	public int xPos;
	public int yPos;
	public boolean containsCrew;
	public boolean containsBF;
	public boolean containsNPC;
	public boolean containsCompanion;
	

	public Tile() {
		Weather weatherIN = new Weather();
		Terrain terrainIN = new Terrain();
		this.weather = weatherIN;
		this.terrain = terrainIN;
		this.containsCrew = false;
		this.containsBF = false;
		this.containsNPC = false;
		this.containsCompanion = false;
	}
		
	public void setXPos(int x) {
		this.xPos = x;
	}
	public void setYPos(int y) {
		this.yPos = y;
	}

}
