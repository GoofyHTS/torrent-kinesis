package goofyhts.torrentkinesis.torrent;

public interface TorrentServerSetting<K,V> {

	void parseSettings(Object value);
	V getSetting(K value);
	void setSetting(V value);
}
