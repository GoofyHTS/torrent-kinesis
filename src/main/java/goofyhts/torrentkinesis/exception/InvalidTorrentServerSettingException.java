package goofyhts.torrentkinesis.exception;

public class InvalidTorrentServerSettingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidTorrentServerSettingException(String message) {
		super(message);
	}
}
