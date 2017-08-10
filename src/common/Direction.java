package common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pawan
 *
 */
public enum Direction implements Name, Command {

	EAST("East"), WEST("West"), NORTH("North"), SOUTH("South"), UP("Up"), DOWN("Down");

	private String name;
	private String command;
	private static final Map<String, Direction> STR_DIR_MAP;

	static {
		STR_DIR_MAP = new HashMap<>();
		Direction[] directions = Direction.class.getEnumConstants();
		for (Direction dir : directions)
			STR_DIR_MAP.put(dir.getCommand(), dir);
	}

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

	private Direction(String name) {
		this.name = name;
		this.command = name.toLowerCase();
	}

	public static Direction getDirection(String dir) {
		return STR_DIR_MAP.get(dir.toLowerCase());
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getCommand() {
		return this.command;
	}
}
