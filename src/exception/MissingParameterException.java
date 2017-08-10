package exception;

/**
 * @author pawan
 *
 */
public class MissingParameterException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Required parameter(s) is/are missing";
	}
}
