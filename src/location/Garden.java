package location;

/**
 * @author pawan This class is a subclass of location to represent garden. It
 *         has name and description.
 */
public class Garden extends Location {

	private static final String NAME = "Garden";
	private static final String DESCRIPTION = "There is a well in front of you";

	public Garden() {
		super(NAME, DESCRIPTION);
	}

	// To change default description of the Garden
	public Garden(String description) {
		super(NAME, description);
	}

	// To add prefix to name and change default description of the Garden
	public Garden(String prefix, String description) {
		super(prefix + " " + NAME, description);
	}
}
