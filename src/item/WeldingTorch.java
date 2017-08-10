package item;

import exception.IllegalCommandException;

public class WeldingTorch extends UnpickableItem {

	public static final String NAME = "Welding Machine";
	private static final String DESCRIPTION = "There is a giant welding torch in the corner";

	public WeldingTorch() throws IllegalCommandException {
		super(NAME, DESCRIPTION);
	}
}
