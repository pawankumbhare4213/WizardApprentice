package doorway;

import common.Direction;
import common.Name;
import location.Location;

/**
 * @author pawan
 *
 */
public class Path implements Name {

	protected final String name;
	protected final Location a;
	protected final Location b;
	protected final Direction direction;

	public Path(Location a, Location b, Direction direction, String name) {
		this.name = name;
		this.a = a;
		this.b = b;
		this.direction = direction;
	}

	public Location from() {
		return a;
	}

	public Location to() {
		return b;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public Path cloneOpposite() {
		return new Path(b, a, Direction.opposite(direction), name);
	}
}