package location;

/**
 * @author pawan This class is a subclass of location to represent bedroom. It
 *         has name and description.
 */
public class Bedroom extends Location {

	private static final String NAME = "Bedroom";
	private static final String DESCRIPTION = "A person is snoring loudly on the bed";

	public Bedroom() {
		super(NAME, DESCRIPTION);
	}

	// To add prefix to name and change default description
	public Bedroom(String prefix) {
		super(prefix + " " + NAME, DESCRIPTION);
	}
}
