package exceptions;

public class IllegalMapException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Illegal Map, Map cannot be null";
	}
}
