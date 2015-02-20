package goofyhts.torrentkinesis.utorrent.constant;

public class UTorrentServerConst { 
	
	private UTorrentServerConst() {		
	}

	public static final String REQUEST_TOKEN_URL = "/token.html";
	public static final String REQUEST_TOKEN_ELEMENT_ID = "token";
	public static final String GET_TORRENT_LIST_URL = "/?list=1&token=%s";
}
