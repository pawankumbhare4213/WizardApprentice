package items;

import structure.Item;

public class Bucket extends Item {

	private static final String NAME = "Bucket"; 
	private boolean isFilled;

	public Bucket() {
		super(NAME, NAME.toLowerCase());
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
}
