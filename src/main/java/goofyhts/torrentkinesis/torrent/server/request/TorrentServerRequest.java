package goofyhts.torrentkinesis.torrent.server.request;

import goofyhts.torrentkinesis.json.parser.TorrentJsonParser;

/**
 * Defines a torrent server request
 * @author GoofyHTS
 *
 */
public interface TorrentServerRequest {

	/**
	 * Sends a GET request to the torrent server
	 * @param url URL for the GET request
	 * @return GET request response
	 */
	String getRequest(String url);
	
	/**
	 * Sends a POST request to the torrent server
	 * @param url URL for the POST request
	 * @return POST request response
	 */
	String postRequest(String url);	
	
	/**
	 * Gets a Json parser
	 * @return Json parser
	 */
	TorrentJsonParser getJsonParser();
}
