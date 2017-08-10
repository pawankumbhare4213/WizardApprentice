package location;

/**
 * @author pawan This class is a subclass of location to represent attic. It has
 *         name and description.
 */
public class Attic extends Location {

	private static final String NAME = "Attic";
	private static final String DESCRIPTION = "There is a giant welding torch in the corner";

	public Attic() {
		super(NAME, DESCRIPTION);
	}

	// To change default description
	public Attic(String description) {
		super(NAME, description);
	}

	// To add prefix to name and change default description
	public Attic(String prefix, String description) {
		super(prefix + " " + NAME, description);
	}
}
