package doorways;

import structure.Direction;
import structure.Location;
import structure.Path;

public class Ladder extends Path {

	private static final String NAME = "Ladder"; 
	
	public Ladder(Location a, Location b, Direction direction) {
		super(a, b, direction, NAME);
	}
}
