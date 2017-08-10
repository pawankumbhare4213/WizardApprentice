package locations;

import map.Location;

public class Garden extends Location {

	private static final String NAME = "Garden";
	private static final String DESCRIPTION = "There is a well in front of you";
	
	public Garden() {
		super(NAME, DESCRIPTION);
	}
	
	public Garden(String description) {
		super(NAME, description);
	}
	
	public Garden(String prefix, String description) {
		super(prefix + " " + NAME, description);
	}
}
