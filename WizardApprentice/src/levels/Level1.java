package levels;

import doorways.Door;
import doorways.Ladder;
import exceptions.IllegalMapException;
import exceptions.IllegalPathException;
import items.Bucket;
import items.Chain;
import items.Frog;
import items.Whiskey;
import locations.Attic;
import locations.Garden;
import locations.LivingRoom;
import map.Direction;
import map.GameMap;
import map.LevelMap;
import map.Location;
import structure.Item;

public class Level1 implements LevelMap {
	
	@Override
	public GameMap getMap() throws IllegalPathException, IllegalMapException {
		Location livingRoom = new LivingRoom();
		livingRoom.addItems(new Whiskey(), new Bucket());
		livingRoom.setHasWizard(true);
		
		Location attic = new Attic();
		Item bucket = new Bucket();
		attic.addItems(bucket);
		
		Location garden = new Garden();
		Item chain = new Chain();
		garden.addItems(chain, new Frog());
		
		Location roofGarden = new Garden("Roof", "There is a nice view in front of you");
		
		GameMap map = new GameMap(livingRoom);
		map.setStartLocation(livingRoom);
		map.addPath(new Door(livingRoom, garden, Direction.WEST));
		map.addPath(new Ladder(livingRoom, attic, Direction.UP));
		map.addPath(new Ladder(attic, roofGarden, Direction.UP));

		System.out.println(map.toFullString());
		
		return map;
	}
}
