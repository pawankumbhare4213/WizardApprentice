package doorways;

import map.Direction;
import map.Location;
import map.Path;

public class Door extends Path {

	private static final String NAME = "Door"; 
	
	public Door(Location a, Location b, Direction direction) {
		super(a, b, direction, NAME);
	}
}
