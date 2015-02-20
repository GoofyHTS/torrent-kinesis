package goofyhts.torrent.api;

import goofyhts.torrent.api.domain.Torrent;

import java.util.List;

public abstract class TorrentServer {

	protected String baseUrl;
	protected TorrentHttpClient httpClient;
	
	public TorrentServer(String baseAddress, TorrentHttpClient httpClient) {
		this.baseUrl = baseAddress;
		this.httpClient = httpClient;
	}
	
	public abstract List<Torrent> getTorrentList();

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
