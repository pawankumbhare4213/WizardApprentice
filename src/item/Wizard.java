package item;

import exception.IllegalCommandException;

public class Wizard extends UnpickableItem {

	public static final String NAME = "Wizard";
	private static final String DESCRIPTION = "A wizard is snoring loudly on the couch";

	public Wizard() throws IllegalCommandException {
		super(NAME, DESCRIPTION);
	}
}
