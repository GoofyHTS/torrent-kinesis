package goofyhts.torrentkinesis.torrent;

import java.util.List;

public interface TorrentServer<Setting> {

	TorrentServerSetting<Setting> getSettings();
	void setSetting(TorrentServerSettingEntry torrentServerSettingEntry);
	void setSettings(List<TorrentServerSettingEntry> settings);
}
