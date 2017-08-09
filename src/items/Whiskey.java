package items;

import structure.Item;

public class Whiskey extends Item {
	
	private static final String NAME = "Whiskey"; 
	
	public Whiskey() {
		super(NAME, NAME.toLowerCase());
	}
}
