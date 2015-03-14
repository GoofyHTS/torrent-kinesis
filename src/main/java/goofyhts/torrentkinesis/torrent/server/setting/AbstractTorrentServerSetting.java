package goofyhts.torrentkinesis.torrent.server.setting;

import goofyhts.torrentkinesis.torrent.server.request.TorrentServerRequest;
import goofyhts.torrentkinesis.torrent.server.setting.entry.TorrentServerSettingEntry;

/**
 * Provides basic functionality for a torrent server settings
 * @author GoofyHTS
 *
 * @param <SettingEntry>
 */
public abstract class AbstractTorrentServerSetting<SettingEntry extends TorrentServerSettingEntry> implements TorrentServerSetting<SettingEntry> {

	protected TorrentServerRequest torrentServerRequest;
	
	/**
	 * Constructor
	 * @param torrentServerRequest Torrent server request
	 */
	public AbstractTorrentServerSetting(TorrentServerRequest torrentServerRequest) {
		this.torrentServerRequest = torrentServerRequest;
	}
}
