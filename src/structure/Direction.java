package structure;

import java.util.HashMap;
import java.util.Map;

public enum Direction implements Nameable, Commandable {

	EAST	("East"), 
	WEST	("West"), 
	NORTH	("North"), 
	SOUTH	("South"), 
	UP		("Up"), 
	DOWN	("Down");
	
	private String name;
	private String cmd;
	public static final Map<String, Direction> CMD_DIRECTION_MAP;
	
	static {
		CMD_DIRECTION_MAP = new HashMap<>();
		Direction[] enums = Direction.class.getEnumConstants();

		for (Direction dir : enums) 
			CMD_DIRECTION_MAP.put(dir.getCMD(), dir);
	}

    private Direction(String name) {
        this.name = name;
        this.cmd = name.toLowerCase();
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
