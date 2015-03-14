package goofyhts.torrentkinesis.torrent.server.request;

import goofyhts.torrentkinesis.html.TorrentHttpClient;
import goofyhts.torrentkinesis.json.parser.TorrentJsonParser;

/**
 * Provides basic functionality for a torrent server request
 * @author GoofyHTS
 *
 */
public class AbstractTorrenServerRequest implements TorrentServerRequest {

	protected String baseUrl;
	protected TorrentHttpClient httpClient;
	protected TorrentJsonParser jsonParser;
	
	/**
	 * Constructor
	 * @param baseAddress Base URL address where are requests are formed
	 * @param httpClient Http client that provides GET and POST requests
	 * @param jsonParser Json parser
	 */
	public AbstractTorrenServerRequest(String baseAddress, TorrentHttpClient httpClient, TorrentJsonParser jsonParser) {
		this.baseUrl = baseAddress;
		this.httpClient = httpClient;
		this.jsonParser = jsonParser;
	}
	
	/**
	 * Gets the base URL address
	 * @return base URL address
	 */
	public String getBaseAddress() {
		return baseUrl;
	}

	/**
	 * Sets the base URL address
	 * @param baseAddress Base URL address
	 */
	public void setBaseAddress(String baseAddress) {
		this.baseUrl = baseAddress;
	}

	/**
	 * Gets the http client
	 * @return Http client
	 */
	public TorrentHttpClient getHttpClient() {
		return httpClient;
	}

	/**
	 * Sets the http client
	 * @param httpClient Http client
	 */
	public void setHttpClient(TorrentHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	@Override
	public String getRequest(String url) {
		url = baseUrl + url;
		httpClient.open();
		
		String alteredUrl = alterUrlBeforeRequest(httpClient, url);
		if (alteredUrl != null && alteredUrl.trim().length() > 0)
			url = alteredUrl;
		
		String response = httpClient.getURL(url);  
		
		httpClient.close();
		
		return response;
	}

	@Override
	public String postRequest(String url) {
		return null;
	}

	/**
	 * Alters a URL before sending a request
	 * @param httpClient Http client u
	 * @param url URL of the request
	 * @return The altered URL
	 */
	protected String alterUrlBeforeRequest(TorrentHttpClient httpClient, String url) {
		return null;
	}

	@Override
	public TorrentJsonParser getJsonParser() {
		return this.jsonParser;
	}
}
