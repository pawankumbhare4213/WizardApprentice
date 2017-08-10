package doorway;

import common.Direction;
import location.Location;

/**
 * @author pawan
 *
 */
public class Door extends Path {

	private static final String NAME = "Door";

	public Door(Location a, Location b, Direction direction) {
		super(a, b, direction, NAME);
	}
}
