package doorway;

import common.Direction;
import location.Location;

/**
 * @author pawan
 *
 */
public class Ladder extends Path {

	private static final String NAME = "Ladder";

	public Ladder(Location a, Location b, Direction direction) {
		super(a, b, direction, NAME);
	}
}
