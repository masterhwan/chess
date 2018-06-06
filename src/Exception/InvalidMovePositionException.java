package Exception;

public class InvalidMovePositionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1213395152914421383L;

	public InvalidMovePositionException(String message) {
		super(message);
	}
}
