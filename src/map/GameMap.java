package map;

import structure.Location;
import structure.Path;

public final class GameMap {

	private Location start;

	public GameMap(Location defaultStart) throws Exception {
		this.start = defaultStart;
		if (!verify(start)) 
			throw new Exception("Illegal Map Exception");
	}

	private boolean verify(Location map) {
		//To be implemented
		return true;
	}

	public void setStartLocation(Location loc) {
		this.start = loc;
	}
	
	public Location getStartLocation() {
		return this.start;
	}
	
	public String toFullString() {
		return start.toFullString();
    }
	
	@Override
	public String toString() {
		return start.toString();
    }

	public void addPath(Path path) throws Exception {
		Location.addPath(path);
	}
}
