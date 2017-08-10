package exception;

/**
 * @author pawan
 *
 */
public class GameAlreadyStartedException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Game is alredy started";
	}
}
