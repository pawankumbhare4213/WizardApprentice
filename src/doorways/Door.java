package doorways;

import structure.Direction;
import structure.Location;
import structure.Path;

public class Door extends Path {

	private static final String NAME = "Door"; 
	
	public Door(Location a, Location b, Direction direction) {
		super(a, b, direction, NAME);
	}
}
