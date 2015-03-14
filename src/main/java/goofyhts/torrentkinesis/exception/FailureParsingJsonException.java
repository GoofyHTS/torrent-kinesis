package goofyhts.torrentkinesis.exception;

/**
 * Custom exception indicating a invalid Json was returned
 * @author GoofyHTS
 *
 */
public class FailureParsingJsonException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FailureParsingJsonException(String attemptedJson) {
		super(attemptedJson);
	}
}
