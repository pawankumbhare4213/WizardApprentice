package items;

import structure.Item;

public class Chain extends Item {

	private static final String NAME = "Chain"; 
	private boolean isWelded;
	
	public Chain() {
		super(NAME, NAME.toLowerCase());
	}

	public boolean isWelded() {
		return isWelded;
	}

	public void setWelded(boolean isWelded) {
		this.isWelded = isWelded;
	}
}
