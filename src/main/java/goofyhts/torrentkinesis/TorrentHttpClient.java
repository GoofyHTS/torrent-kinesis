package goofyhts.torrentkinesis;

public interface TorrentHttpClient {

	public void open();
	public String getURL(String url);
	public String postURL(String url);
	public void close();
}
