package game;

import doorway.Path;
import exception.IllegalMapException;
import exception.IllegalPathException;
import location.Location;

/**
 * @author pawan
 *
 */
public class GameMap {

	private Location start;

	public GameMap(Location defaultStart) throws IllegalMapException {
		if (defaultStart == null)
			throw new IllegalMapException();
		this.start = defaultStart;
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

	public void addPath(Path path) throws IllegalPathException {
		Location.addPath(path);
	}

	@Override
	public String toString() {
		return start.toString();
	}
}
