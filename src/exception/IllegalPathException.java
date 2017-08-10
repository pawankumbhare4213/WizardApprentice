package exception;

/**
 * @author pawan
 *
 */
public class IllegalPathException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Illegal Command";
	}
}
