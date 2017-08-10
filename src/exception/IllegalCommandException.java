package exception;

/**
 * @author pawan
 *
 */
public class IllegalCommandException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Illegal Command";
	}
}
