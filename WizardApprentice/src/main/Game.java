package main;

import java.util.Scanner;

import exceptions.GameAlreadyStartedException;
import exceptions.IllegalCommandException;
import exceptions.IllegalMapException;
import exceptions.IllegalPathException;
import exceptions.MissingParametersException;
import map.GameMap;
import map.LevelMap;
import players.Player;
import structure.CMDHandler;

public class Game {

	private GameMap map;
	private Player player;
	private boolean isStarted;
	
	public Game(LevelMap level) throws IllegalPathException, IllegalMapException {
		isStarted = false;
		map = level.getMap();
		player = new Player("Pawan", map.getStartLocation());
	}
	
	public void start() throws MissingParametersException, GameAlreadyStartedException {
		if (isStarted) throw new GameAlreadyStartedException();
		isStarted = true;
		if (map == null || player == null) throw new MissingParametersException();
	    Scanner scanner = new Scanner(System.in);
	    while (scanner.hasNext()) {
	    	String line = scanner.nextLine();
	    	if (line.equalsIgnoreCase("quit")) {
	    		stop();
	    		break;
	    	}
	    	try {
	    		if (!CMDHandler.executeCMD(player, line)) {
	    			stop();
	    			break;
	    		}
	    	} catch (MissingParametersException | IllegalCommandException e) {
	    		System.err.println(e.getMessage());
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
