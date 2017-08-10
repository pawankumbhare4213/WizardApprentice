package map;

import exceptions.IllegalMapException;
import exceptions.IllegalPathException;

public interface LevelMap {

	public GameMap getMap() throws IllegalPathException, IllegalMapException;
}
