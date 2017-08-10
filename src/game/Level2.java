package game;

import java.io.File;

import exception.IllegalCommandException;
import exception.IllegalMapException;
import exception.IllegalPathException;

/**
 * @author pawan
 *
 */
public class Level2 implements Level {

	@Override
	public GameMap getMap() throws IllegalPathException, IllegalMapException, IllegalCommandException {
		
		File file = new File("level2.txt");
		GameMap map = LevelBuilder.getMap(file);
		System.out.println(map.toFullString());

		return map;
	}
}
