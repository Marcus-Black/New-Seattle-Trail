package st;

import java.util.Map;

import entities.Bigfoot;
import entities.Crew;
import entities.Bigfoot.Activity;
import items.Consumables.*;
import items.Equipment.BearLine;
import items.Equipment.Craftable;

public class GameRunner {
	public int days;
	public double timeIn24;
	static BearLine bearLine = new BearLine();
	Craftable.
	
	
	

	
	
	public static void startGameMoveCrew() {
		//check if has companion
		//check which professions your crew has
		//Character stat changes such as temp/energy/health/thirst/hunger
		//Check crewmember energy levels and if below 30 total have chance of covid
		//check how many tiles they have gone on wet/slippery in a row and decide if trenchfoot
		//create next events based on time/activity using Tile.createEvents for next tile in Trail including companion spawn
		//if paranoia, have weird phrases that can affect crew (Like hearing sounds/ seeing things that arent real)
		//check to make sure crew is alive, if not send score to database, if not give death screen
		//add hours to time based on speed/if overweight pack and if coffee
		if(Bigfoot.activity == Activity.ACTIVE) {
			Bigfoot.bigfootMove();
		}
		//check distance from crew
		//event triggers based on Tile.eventTriggers including next location event and bigfoot watching(sound from nearby)
		//move crew by using move function to x/y of next Trail
		//check next tile weather/time/landmark 
		//list any changes to weather conditions
		//Menu pops up with options to continue/speed up or to rest
			//if rest chance of bears eating food from packs if no bear line,2% chance of nightmare
			//also increase stats from sleeping, has chance to change weather by 15%,bigfoot moves again to players and can cause damage)
		
	}
	
	
}
