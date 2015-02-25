package goofyhts.torrentkinesis.torrent;

import goofyhts.torrentkinesis.TorrentHttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractTorrentServerSettingCache<SettingEntry extends TorrentServerSettingEntry> extends AbstractTorrentServerSetting<SettingEntry> {

	protected HashMap<String, SettingEntry> settings = new HashMap<String, SettingEntry>();

	public AbstractTorrentServerSettingCache(TorrentServerRequest torrentServerRequest) {
		super(torrentServerRequest);	
	}

	public abstract void refreshSettings();
	
	@Override
	public SettingEntry getSetting(String value) {
		return settings.get(value);
	}

	@Override
	public List<SettingEntry> getSettings() {
		return new ArrayList<SettingEntry>(settings.values());
	}
}
