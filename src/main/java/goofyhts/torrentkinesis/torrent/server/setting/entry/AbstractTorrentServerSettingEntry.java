package goofyhts.torrentkinesis.torrent.server.setting.entry;

import goofyhts.torrentkinesis.torrent.server.request.TorrentServerRequest;

/**
 * Provides basic functionality for a torrent server setting entry
 * @author GoofyHTS
 *
 */
public abstract class AbstractTorrentServerSettingEntry implements TorrentServerSettingEntry {

	protected TorrentServerRequest torrentServerRequest;
	
	/**
	 * Constructor
	 * @param torrentServerRequest Torrent server request
	 */
	public AbstractTorrentServerSettingEntry(TorrentServerRequest torrentServerRequest) {
		this.torrentServerRequest = torrentServerRequest;
	}
}
