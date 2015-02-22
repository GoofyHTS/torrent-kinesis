package goofyhts.torrentkinesis.torrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractTorrentServerSettingCache<SettingEntry> implements TorrentServerSetting<SettingEntry> {

	protected HashMap<String, SettingEntry> settings = new HashMap<String, SettingEntry>();

	@Override
	public SettingEntry getSetting(String value) {
		return settings.get(value);
	}

	@Override
	public List<SettingEntry> getSettings() {
		return new ArrayList<SettingEntry>(settings.values());
	}
}
