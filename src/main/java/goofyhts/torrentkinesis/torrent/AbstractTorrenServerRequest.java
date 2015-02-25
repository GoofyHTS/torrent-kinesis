package goofyhts.torrentkinesis.torrent;

import goofyhts.torrentkinesis.TorrentHttpClient;
import goofyhts.torrentkinesis.json.parser.TorrentJsonParser;

public class AbstractTorrenServerRequest implements TorrentServerRequest {

	protected String baseUrl;
	protected TorrentHttpClient httpClient;
	protected TorrentJsonParser jsonParser;
	
	public AbstractTorrenServerRequest(String baseAddress, TorrentHttpClient httpClient, TorrentJsonParser jsonParser) {
		this.baseUrl = baseAddress;
		this.httpClient = httpClient;
		this.jsonParser = jsonParser;
	}
	
	public String getBaseAddress() {
		return baseUrl;
	}

	public void setBaseAddress(String baseAddress) {
		this.baseUrl = baseAddress;
	}

	public TorrentHttpClient getHttpClient() {
		return httpClient;
	}

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

	protected String alterUrlBeforeRequest(TorrentHttpClient httpClient, String url) {
		return null;
	}

	@Override
	public TorrentJsonParser getJsonParser() {
		return this.jsonParser;
	}
}
