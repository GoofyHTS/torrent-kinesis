package goofyhts.torrentkinesis.torrent;

import java.util.List;

public interface TorrentServer {

	List<TorrentServerSetting> getSettings();
	void setSettings(List<TorrentServerSetting> settings);
}
