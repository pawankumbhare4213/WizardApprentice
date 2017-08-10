package item;

import exception.IllegalCommandException;

public class Well extends UnpickableItem {

	public static final String NAME = "Well";
	private static final String DESCRIPTION = "There is well in front of you";

	public Well() throws IllegalCommandException {
		super(NAME, DESCRIPTION);
	}
}
