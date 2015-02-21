package goofyhts.torrentkinesis.torrent;

import goofyhts.torrentkinesis.TorrentHttpClient;

public abstract class AbstractTorrentServer implements TorrentServer {

	protected String baseUrl;
	protected TorrentHttpClient httpClient;
	
	public AbstractTorrentServer(String baseAddress, TorrentHttpClient httpClient) {
		this.baseUrl = baseAddress;
		this.httpClient = httpClient;
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
	
}
