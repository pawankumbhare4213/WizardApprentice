package map;

import doorways.Door;
import doorways.Ladder;
import items.Bucket;
import items.Chain;
import items.Frog;
import items.Whiskey;
import locations.Attic;
import locations.Garden;
import locations.LivingRoom;
import structure.Direction;
import structure.Location;

public class ZTestMap {

	public static void main(String args[]) throws Exception {
		getMap();		
	}
	
	public static GameMap getMap() throws Exception {
		Location livingRoom = new LivingRoom();
		livingRoom.addItems(new Whiskey(), new Bucket());
		livingRoom.setHasWizard(true);
		
		Location attic = new Attic();
		attic.addItems(new Bucket());
		
		Location garden = new Garden();
		garden.addItems(new Chain(), new Frog());
		
		Location roofGarden = new Garden("Roof", "There is a city view in front of you");
		
		GameMap map = new GameMap(livingRoom);
		map.addPath(new Door(livingRoom, garden, Direction.WEST));
		map.addPath(new Ladder(livingRoom, attic, Direction.UP));
		map.addPath(new Ladder(attic, roofGarden, Direction.UP));
		
		System.out.println(map.toFullString());
		
		return map;
	}
}
