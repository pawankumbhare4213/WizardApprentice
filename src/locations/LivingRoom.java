package locations;

import structure.Location;

public class LivingRoom extends Location {

	private static final String NAME = "Living Room"; 
	private static final String DESCRIPTION = "A wizard is snoring loudly on the couch";

	public LivingRoom() {
		super(NAME, DESCRIPTION);
	}
	
	public LivingRoom(String prefix) {
		super(prefix + " " + NAME, DESCRIPTION);
	}
}
