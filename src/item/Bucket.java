package item;

import exception.IllegalCommandException;

/**
 * @author pawan
 *
 */
public class Bucket extends PickableItem {

	private static final String NAME = "Bucket";
	private boolean isFilled;

	public Bucket() throws IllegalCommandException {
		super(NAME, NAME.toLowerCase());
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
}
