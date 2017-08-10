package locations;

import map.Location;

public class Attic extends Location {

	private static final String NAME = "Attic";
	private static final String DESCRIPTION = "There is a giant welding torch in the corner";
	
	public Attic() {
		super(NAME, DESCRIPTION);
	}
	
	public Attic(String description) {
		super(NAME, description);
	}
	
	public Attic(String prefix, String description) {
		super(prefix + " " + NAME, description);
	}
}
