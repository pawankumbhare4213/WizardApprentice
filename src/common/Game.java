package common;

import java.util.Scanner;

import exception.GameAlreadyStartedException;
import exception.IllegalCommandException;
import exception.IllegalMapException;
import exception.IllegalPathException;
import exception.MissingParameterException;
import level.Level;

/**
 * @author pawan
 *
 */
public class Game {

	private GameMap map;
	private Player player;
	private boolean isStarted;

	public Game(Level level) throws IllegalPathException, IllegalMapException, IllegalCommandException {
		isStarted = false;
		map = level.getMap();
		player = new Player("Pawan", map.getStartLocation());
	}

	public void start() throws MissingParameterException, GameAlreadyStartedException {
		if (isStarted)
			throw new GameAlreadyStartedException();
		isStarted = true;
		if (map == null || player == null)
			throw new MissingParameterException();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			if (line.equalsIgnoreCase("quit")) {
				stop();
				break;
			}
			try {
				if (!CommandHandler.executeCommand(player, line)) {
					stop();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				scanner.close();
				break;
			}
		}
		System.out.println("QUITTING GAME!");
		scanner.close();
	}

	private void stop() {
		isStarted = false;
		map = null;
		player = null;
	}
}
