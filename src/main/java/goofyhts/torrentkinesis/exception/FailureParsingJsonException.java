package goofyhts.torrentkinesis.exception;

public class FailureParsingJsonException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FailureParsingJsonException(String attemptedJson) {
		super(attemptedJson);
	}
}
