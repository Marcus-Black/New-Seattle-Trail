package environment;

public class Terrain {
	public Type type;
	public Path path;
	public boolean occupied;
	
	public enum Type{
		TALL_GRASS,WATER,SNOW,ABANDONED_BUILDING,LIGHT_MUDD,HEAVY_MUDD,FOREST,MARKET,TOWN,CLOSE_CAMPSITE,FAR_CAMPSITE,FIRSTPOI,SECONDPOI,THIRDPOI,FOURTHPOI,START,END,GRASS
	}
	public enum Path{
		TRAIL,NOT_TRAIL,POSSIBLE_TRAIL
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

}
