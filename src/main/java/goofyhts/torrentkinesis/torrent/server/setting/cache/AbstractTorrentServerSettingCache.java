package goofyhts.torrentkinesis.torrent.server.setting.cache;

import goofyhts.torrentkinesis.torrent.server.request.TorrentServerRequest;
import goofyhts.torrentkinesis.torrent.server.setting.AbstractTorrentServerSetting;
import goofyhts.torrentkinesis.torrent.server.setting.TorrentServerSettingEntry;
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
