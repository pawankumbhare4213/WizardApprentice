import common.Game;
import exception.GameAlreadyStartedException;
import exception.IllegalCommandException;
import exception.IllegalMapException;
import exception.IllegalPathException;
import exception.MissingParameterException;
import level.Level2;

/**
 * @author pawan This class is used to run the game.
 */
public class Main {

	/**
	 * main method which starts the game
	 */
	public static void main(String[] args) throws IllegalCommandException, GameAlreadyStartedException {
		try {
			Game game = new Game(new Level2());
			game.start();
		} catch (MissingParameterException | IllegalPathException | IllegalMapException e) {
			e.printStackTrace();
		}
	}
}
