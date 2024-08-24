package st;
import java.io.*;
import java.util.*;

import entities.Crew;
import environment.*;
import environment.Tile;
import environment.Weather.Temperature;
import environment.Terrain.Path;
import environment.Terrain.Type;
import probability.Probability;

public class MapCreator {
	public Tile[][] matrix = new Tile[50][50];
	public int currentX;
	public int currentY;
	public int trailLength = 70;
	public int xPH1;
	public int yPH1;
	public int xPH2;
	public int yPH2;
	public int placeHolders = 0;
	public double percentChanceRight;
	public double percentChanceLeft;
	public double percentChanceDown;
	public double percentChanceUp;
	public ArrayList<Tile> Trail = new ArrayList<Tile>();
	public int weatherSectioner;
	public boolean wide;
	public ArrayList<Tile> availableSpots = new ArrayList<Tile>();
	Tile[][] WeatherZone1;
	Tile[][] WeatherZone2;
	Tile[][] WeatherZone3;
	Tile tempBottom;
	Tile tempFarLeft;
	Tile tempFarRight;
	Tile tempTop;

	public MapCreator() {
		setArray();
		setXYPos();
		setStart();
		setDirectionalRouteChance();
		buildPath();
		findWeatherZones();
//		buildWeatherZones();
		printArray();
		
	}
	
	public void setArray() {
		for(int i = 0; i < matrix.length;i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				Tile initial = new Tile();
				matrix[i][j] = initial;
			}
		}
	}
	
	public Tile[][] setXYPos(){
		for(int i = 0; i < matrix.length;i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				matrix[i][j].yPos = i;
				matrix[i][j].xPos = j;
			}
		}
		return matrix;
	}
	
	public Tile[][] setStart(){
		label1:
	while(placeHolders == 0) {
		for(int i = (matrix.length/4);i < matrix.length-(matrix.length/4);i++) {
			for(int j = (matrix.length/4);j < matrix[i].length-(matrix.length/4);j++) {
				if(Probability.SpecificPercentChance(0.1) == true) {
					matrix[i][j].terrain.type = Type.START;
					matrix[i][j].terrain.path = Path.TRAIL;
					Trail.add(matrix[i][j]);
					Crew.XPos = j;
					Crew.YPos = i;
					matrix[i][j].containsCrew = true;
					xPH1 = j;
					yPH1 = i;
					break label1;					
				}
			}	
		}
	}
		return matrix;
	}	
	
	public void setDirectionalRouteChance(){
		double rightSidePercent = (matrix.length - xPH1)-1;
		percentChanceRight = 100.0*(rightSidePercent/matrix.length);
		percentChanceLeft = (100.0 - percentChanceRight);
		double downPercent = (matrix.length - yPH1)-1;
		percentChanceDown = 100.0*(downPercent/matrix.length);
		percentChanceUp = (100.0 - percentChanceDown);		
		
	}
	
	public Tile[][] buildPath(){
		currentX = xPH1;
		currentY = yPH1;
		int TrailAvailable = trailLength;
		while(TrailAvailable != 0) {
			if(Probability.SpecificPercentChance(percentChanceRight) && currentX+1 < matrix.length-1 && matrix[currentY][currentX+1].terrain.path != Path.TRAIL) {
				matrix[currentY][currentX+1].terrain.path = Path.TRAIL;
				Trail.add(matrix[currentY][currentX+1]);
				currentX++;
				TrailAvailable--;
				continue;
				
				
			}else if(Probability.SpecificPercentChance(percentChanceLeft) && currentX-1 > 0 && matrix[currentY][currentX-1].terrain.path != Path.TRAIL) {
				matrix[currentY][currentX-1].terrain.path = Path.TRAIL;
				Trail.add(matrix[currentY][currentX-1]);
				currentX--;
				TrailAvailable--;
				continue;
				
				
			}else if(Probability.SpecificPercentChance(percentChanceUp) && currentY-1 > 0 && matrix[currentY-1][currentX].terrain.path != Path.TRAIL) {
				matrix[currentY-1][currentX].terrain.path = Path.TRAIL;
				Trail.add(matrix[currentY-1][currentX]);
				currentY--;
				TrailAvailable--;
				continue;
								
			}
			else if(Probability.SpecificPercentChance(percentChanceDown) && currentY+1 < matrix[0].length-1 && matrix[currentY+1][currentX].terrain.path != Path.TRAIL) {
				matrix[currentY+1][currentX].terrain.path = Path.TRAIL;
				Trail.add(matrix[currentY+1][currentX]);
				currentY++;
				TrailAvailable--;
				continue;
			}
		}
		return matrix;
	}
	
	
	public Tile[][] findWeatherZones(){
		this.tempFarRight = Trail.get(0);
		for(int i = 1;i < Trail.size();i++) {
			if(Trail.get(i).xPos > tempFarRight.xPos) {
				tempFarRight = Trail.get(i);
			}
		}
		this.tempFarLeft = Trail.get(0);
		for(int i = 1;i < Trail.size();i++) {
			if(Trail.get(i).xPos < tempFarLeft.xPos) {
				tempFarLeft = Trail.get(i);
				
			}
		}
		this.tempTop = Trail.get(0);
		for(int i = 1;i < Trail.size();i++) {
			if(Trail.get(i).yPos < tempTop.yPos) {
				tempTop = Trail.get(i);
			}
		}
		this.tempBottom = Trail.get(0);
		for(int i = 1;i < Trail.size();i++) {
			if(Trail.get(i).yPos > tempBottom.yPos) {
				tempBottom = Trail.get(i);
			}
		}
		System.out.println(tempTop.yPos + " Top y position");
		System.out.println(tempBottom.yPos + " Bottom y position");
		System.out.println(tempFarLeft.xPos + " Left x position");
		System.out.println(tempFarRight.xPos + " Right x position");
		int width = (tempFarRight.xPos - tempFarLeft.xPos);
		int depth = (tempBottom.yPos - tempTop.yPos);
		if(width > depth) {
			wide = true;
			weatherSectioner = (width/3);
		for(int j = tempTop.yPos;j <= tempBottom.yPos;j++) {
			for(int i = tempFarLeft.xPos;i <= tempFarLeft.xPos + weatherSectioner;i++) {
				matrix[j][i].weather.temperature = Temperature.EXTREME_COLD;
				checkIfOnly1Block(matrix[j][i]);
			}
		}
		for(int j = tempTop.yPos;j <= tempBottom.yPos;j++) {
			for(int i = tempFarLeft.xPos + weatherSectioner;i <= tempFarLeft.xPos + (weatherSectioner*2);i++) {
				matrix[j][i].weather.temperature = Temperature.COLD;
				checkIfOnly1Block(matrix[j][i]);
			}
		}
		for(int j = tempTop.yPos;j <= tempBottom.yPos;j++) {
			for(int i = tempFarLeft.xPos + (weatherSectioner*2);i <= tempFarRight.xPos;i++) {
				matrix[j][i].weather.temperature = Temperature.WARM;
				checkIfOnly1Block(matrix[j][i]);
			}
		}
	}		
		
		if(depth >= width) {
			weatherSectioner = (depth/3);
			wide = false;
			for(int j = tempTop.yPos;j <= tempTop.yPos + weatherSectioner;j++) {
				for(int i = tempFarLeft.xPos;i <= tempFarRight.xPos;i++) {
					matrix[j][i].weather.temperature = Temperature.EXTREME_COLD;
					checkIfOnly1Block(matrix[j][i]);
				}
			}
			for(int j = tempTop.yPos + weatherSectioner;j <= tempTop.yPos + (weatherSectioner*2);j++) {
				for(int i = tempFarLeft.xPos;i <= tempFarRight.xPos;i++) {
					matrix[j][i].weather.temperature = Temperature.COLD;
					checkIfOnly1Block(matrix[j][i]);
			}	
			}
			for(int j = tempTop.yPos + (weatherSectioner * 2);j <= tempBottom.yPos;j++) {
				for(int i = tempFarLeft.xPos;i <= tempFarRight.xPos;i++) {
					matrix[j][i].weather.temperature = Temperature.WARM;
					checkIfOnly1Block(matrix[j][i]);
			}
		}
	}			
			return matrix;
			
		}
	
	
	public void checkIfOnly1Block(Tile tile) {
		int count = 0;
		if(matrix[tile.yPos][tile.xPos].terrain.path != Path.TRAIL && matrix[tile.yPos+1][tile.xPos].terrain.path == Path.TRAIL && tile.terrain.occupied == false) {
			count++;
		}
		else if(matrix[tile.yPos][tile.xPos].terrain.path != Path.TRAIL && matrix[tile.yPos-1][tile.xPos].terrain.path == Path.TRAIL && tile.terrain.occupied == false) {
			count++;
		}
		else if(matrix[tile.yPos][tile.xPos].terrain.path != Path.TRAIL && matrix[tile.yPos][tile.xPos+1].terrain.path == Path.TRAIL && tile.terrain.occupied == false) {
			count++;
		}
		else if(matrix[tile.yPos][tile.xPos].terrain.path != Path.TRAIL && matrix[tile.yPos][tile.xPos-1].terrain.path == Path.TRAIL && tile.terrain.occupied == false) {
			count++;
		}
		if(count == 1) {
			availableSpots.add(tile);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public Tile[][] buildEnvironment(){
//		for(int i = )
//	}
	
//	public void buildWeatherZones(){
//		if(wide = true) {
//			int m = -1;
//			int n = 0;
//			for(int j = tempTop.yPos;j <= tempBottom.yPos;j++) {
//				++m;
//				n = 0;
//				for(int i = tempFarLeft.xPos;i <= tempFarLeft.xPos + weatherSectioner;i++) {
//					WeatherZone1 = new Tile[4+(tempBottom.yPos - tempTop.yPos)][4+weatherSectioner];
//					WeatherZone1[m][n] = matrix[j][i];
//					n++;
//			}
//		}
//			 m = -1;
//			for(int j = tempTop.yPos;j <= tempBottom.yPos;j++) {
//				++m;
//				n = 0;
//				for(int i = tempFarLeft.xPos + weatherSectioner;i <= tempFarLeft.xPos + (weatherSectioner*2);i++) {
//					WeatherZone2 = new Tile[4+(tempBottom.yPos - tempTop.yPos)][4+weatherSectioner];
//					WeatherZone2[m][n] = matrix[j][i];
//					n++;
//			}
//		}
//			m = -1;
//			for(int j = tempTop.yPos;j <= tempBottom.yPos;j++) {
//				++m;
//				n = 0;
//				for(int i = tempFarLeft.xPos + (weatherSectioner*2);i <= tempFarRight.xPos;i++) {
//					WeatherZone3 = new Tile[4+(tempBottom.yPos - tempTop.yPos)][4+weatherSectioner];
//					WeatherZone3[m][n] = matrix[j][i];
//					n++;
//			}
//		}
//	}
//}
	
	
//	public Tile[][] setEnvironmentStructures(){
//		if(wide = true) {
//			for(int i = tempTop.yPos; i <= tempBottom.)
//			
//		}
//		
//	}
	
//		public Tile[][] setTileWeather(){
//			for(int i = 0; i < matrix.length;i++) {
//				for(int j = 0; j < matrix[0].length;j++) {
//					if(matrix[i][j].weather.temperature == Temperature.WARM) {
//					int choice = Probability.RandomUpperLower(1, 100);
//						if(choice )
//					}
//				}
//			}
//		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	public void printArray() {
		int count = 0;
		int countEx = 0;
		for(int i = 0; i < matrix.length;i++) {
			System.out.println();
			for(int j = 0; j < matrix[i].length;j++) {
				if(matrix[i][j].weather.temperature == Temperature.EXTREME_COLD && matrix[i][j].terrain.path != Path.TRAIL && matrix[i][j].terrain.type != Terrain.Type.START) {
						System.out.print("e");
					}
				if(matrix[i][j].weather.temperature == Temperature.COLD && matrix[i][j].terrain.path != Path.TRAIL && matrix[i][j].terrain.type != Terrain.Type.START) {
						System.out.print("c");
					}
				if(matrix[i][j].terrain.path == Path.TRAIL) {
						System.out.print("x");
					}
				else if(matrix[i][j].terrain.path == Path.NOT_TRAIL && matrix[i][j].weather.temperature != Weather.Temperature.COLD && matrix[i][j].weather.temperature != Weather.Temperature.EXTREME_COLD){
					System.out.print("o");
				}
				}
		}
		System.out.println();
		System.out.println(percentChanceRight + " Right");
		System.out.println(percentChanceLeft + " Left");
		System.out.println(percentChanceDown + " Down");
		System.out.println(percentChanceUp + " Up");
		System.out.println(xPH1 + " XPOS");
		System.out.println(yPH1 + " YPOS");
		System.out.println(Crew.XPos);
		System.out.println(Crew.YPos);
		System.out.println(availableSpots.size());
		
		
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
