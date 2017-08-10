package item;

import exception.IllegalCommandException;

/**
 * @author pawan
 *
 */
public class Frog extends PickableItem {

	private static final String NAME = "Frog";

	public Frog() throws IllegalCommandException {
		super(NAME, NAME.toLowerCase());
	}
}
