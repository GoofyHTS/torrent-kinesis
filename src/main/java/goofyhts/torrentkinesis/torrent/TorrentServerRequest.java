package goofyhts.torrentkinesis.torrent;

import goofyhts.torrentkinesis.json.parser.TorrentJsonParser;

public interface TorrentServerRequest {

	String getRequest(String url);
	String postRequest(String url);	
	TorrentJsonParser getJsonParser();
}
