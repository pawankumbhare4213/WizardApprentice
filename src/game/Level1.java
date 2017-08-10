package game;

import common.Direction;
import doorway.Door;
import doorway.Ladder;
import exception.IllegalCommandException;
import exception.IllegalMapException;
import exception.IllegalPathException;
import item.Bucket;
import item.Chain;
import item.Frog;
import item.Item;
import item.WeldingTorch;
import item.Well;
import item.Whiskey;
import item.Wizard;
import location.Attic;
import location.Bedroom;
import location.Garden;
import location.LivingRoom;
import location.Location;

/**
 * @author pawan
 *
 */
public class Level1 implements Level {

	@Override
	public GameMap getMap() throws IllegalPathException, IllegalMapException, IllegalCommandException {
		
		Location livingRoom = new LivingRoom();
		livingRoom.addItems(new Whiskey(), new Bucket(), new Wizard());

		Location attic = new Attic();
		Item bucket = new Bucket();
		attic.addItems(bucket, new WeldingTorch());

		Location garden = new Garden();
		Item chain = new Chain();
		garden.addItems(chain, new Frog(), new Well());

		Location bedroom1 = new Bedroom();
		bedroom1.addItems(new Whiskey());
		Location bedroom2 = new Bedroom();
		bedroom2.addItems(new Whiskey(), new Bucket(), new Chain());

		Location roofGarden = new Garden("Roof", "There is a nice view in front of you");

		GameMap map = new GameMap(livingRoom);
		map.setStartLocation(livingRoom);
		map.addPath(new Door(livingRoom, garden, Direction.WEST));
		map.addPath(new Ladder(livingRoom, attic, Direction.UP));
		map.addPath(new Ladder(attic, roofGarden, Direction.UP));
		map.addPath(new Door(livingRoom, bedroom1, Direction.EAST));
		map.addPath(new Door(livingRoom, bedroom2, Direction.SOUTH));

		System.out.println(map.toFullString());

		return map;
	}
}
