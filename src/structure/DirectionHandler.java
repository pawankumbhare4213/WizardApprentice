package structure;

public class DirectionHandler {

	public static Direction opposite(Direction direction) {

		switch (direction) {
			case EAST:
				return Direction.WEST;
			case WEST:
				return Direction.EAST;
			case NORTH:
				return Direction.SOUTH;
			case SOUTH:
				return Direction.NORTH;
			case UP:
				return Direction.DOWN;
			case DOWN:
				return Direction.UP;
		}
		return null;
	}
}