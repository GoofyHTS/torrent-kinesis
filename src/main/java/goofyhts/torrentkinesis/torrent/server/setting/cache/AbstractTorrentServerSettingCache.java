package goofyhts.torrentkinesis.torrent.server.setting.cache;

import goofyhts.torrentkinesis.torrent.server.request.TorrentServerRequest;
import goofyhts.torrentkinesis.torrent.server.setting.AbstractTorrentServerSetting;
import goofyhts.torrentkinesis.torrent.server.setting.entry.TorrentServerSettingEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Provides basic cacheable functionality for caching torrent server setting requests to minimize requests to the server
 * @author GoofyHTS
 *
 * @param <SettingEntry>
 */
public abstract class AbstractTorrentServerSettingCache<SettingEntry extends TorrentServerSettingEntry> extends AbstractTorrentServerSetting<SettingEntry> {

	protected HashMap<String, SettingEntry> settings = new HashMap<String, SettingEntry>();

	/**
	 * Constructor
	 * @param torrentServerRequest Torrent server request
	 */
	public AbstractTorrentServerSettingCache(TorrentServerRequest torrentServerRequest) {
		super(torrentServerRequest);	
	}

	/**
	 * Force reloading of the server settings in the cache
	 */
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
