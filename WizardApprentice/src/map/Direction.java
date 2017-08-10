package map;

import java.util.HashMap;
import java.util.Map;

import structure.Commandable;
import structure.Nameable;

public enum Direction implements Nameable, Commandable {

	EAST	("East"), 
	WEST	("West"), 
	NORTH	("North"), 
	SOUTH	("South"), 
	UP		("Up"), 
	DOWN	("Down");
	
	private String name;
	private String cmd;
	private static final Map<String, Direction> STR_DIR_MAP;
	
	static {
		STR_DIR_MAP = new HashMap<>();
		Direction[] directions = Direction.class.getEnumConstants();
		for (Direction dir : directions)
			STR_DIR_MAP.put(dir.getCMD(), dir);
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
        this.cmd = name.toLowerCase();
    }
    
    public static Direction getDirection(String dir) {
    	return STR_DIR_MAP.get(dir.toLowerCase());
    }
    
    @Override
    public String getCMD() {
        return this.cmd;
    }

	@Override
	public String getName() {
		return this.name;
	}
}
