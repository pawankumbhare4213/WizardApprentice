package game;

import exception.IllegalCommandException;
import exception.IllegalMapException;
import exception.IllegalPathException;

/**
 * @author pawan
 *
 */
interface Level {

	public GameMap getMap() throws IllegalPathException, IllegalMapException, IllegalCommandException;
}
