package items;

import structure.Item;

public class Bucket extends Item {

	private static final String NAME = "Bucket"; 
	
	public Bucket() {
		super(NAME, NAME.toLowerCase());
	}
}
