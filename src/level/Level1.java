package level;

import common.Direction;
import common.GameMap;
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
