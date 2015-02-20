package goofyhts.torrentkinesis.utorrent.json.response;

public class UTorrentJsonResponse {

	private String build;
	private String[][] torrents;
	
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	public String[][] getTorrents() {
		return torrents;
	}
	public void setTorrents(String[][] torrents) {
		this.torrents = torrents;
	}
}
