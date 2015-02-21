package goofyhts.torrentkinesis.torrent;

import java.util.List;

public interface TorrentServerSetting<K> {

	void parseSettings(Object value);
	K getSetting(String value);
	List<K> getAllSettings();
}
