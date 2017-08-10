package main;

import exceptions.GameAlreadyStartedException;
import exceptions.IllegalMapException;
import exceptions.IllegalPathException;
import exceptions.MissingParametersException;
import levels.Level1;

public class Main {

	public static void main(String[] args) throws GameAlreadyStartedException {
		try {
			Game game = new Game(new Level1());
			game.start();
		} catch (IllegalPathException | IllegalMapException | MissingParametersException e) {
			e.printStackTrace();
		}
	}
}
