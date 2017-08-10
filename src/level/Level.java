package level;

import common.GameMap;
import exception.IllegalCommandException;
import exception.IllegalMapException;
import exception.IllegalPathException;

/**
 * @author pawan
 *
 */
public interface Level {

	public GameMap getMap() throws IllegalPathException, IllegalMapException, IllegalCommandException;
}
