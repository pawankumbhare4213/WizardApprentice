package players;

import actions.Pick;
import actions.Walk;
import doorways.Door;
import doorways.Ladder;
import items.Bucket;
import items.Chain;
import items.Frog;
import items.Whiskey;
import locations.Attic;
import locations.Garden;
import locations.LivingRoom;
import map.GameMap;
import structure.Action;
import structure.Direction;
import structure.Item;
import structure.Location;

public class ZTestPlayer {

	public static void main(String[] args) throws Exception {

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
		
		Player pawan = new Player("Pawan", map.getStartLocation());
		pawan.perform(Action.CMD_ACTION_MAP.get("look"));
		pawan.perform(((Walk) Action.CMD_ACTION_MAP.get("walk")).setDirection("up"));
		pawan.perform(((Pick) Action.CMD_ACTION_MAP.get("pick")).setItem(bucket));
		pawan.perform(((Walk) Action.CMD_ACTION_MAP.get("walk")).setDirection("up"));
		/*pawan.perform(new Walk(Direction.UP));
		pawan.perform(new Walk(Direction.EAST));
		pawan.perform(new Walk(Direction.UP));
		pawan.perform(new Look());*/
	}
}
