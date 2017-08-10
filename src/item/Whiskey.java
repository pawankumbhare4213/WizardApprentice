package item;

import exception.IllegalCommandException;

/**
 * @author pawan
 *
 */
public class Whiskey extends PickableItem {

	private static final String NAME = "Whiskey";

	public Whiskey() throws IllegalCommandException {
		super(NAME, NAME.toLowerCase());
	}
}
