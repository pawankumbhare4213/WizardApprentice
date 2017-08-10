package map;

import structure.Nameable;

public class Path implements Nameable {

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