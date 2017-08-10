package item;

import exception.IllegalCommandException;

/**
 * @author pawan
 *
 */
public class Chain extends PickableItem {

	private static final String NAME = "Chain";
	private boolean isWelded;

	public Chain() throws IllegalCommandException {
		super(NAME, NAME.toLowerCase());
	}

	public boolean isWelded() {
		return isWelded;
	}

	public void setWelded(boolean isWelded) {
		this.isWelded = isWelded;
	}
}
