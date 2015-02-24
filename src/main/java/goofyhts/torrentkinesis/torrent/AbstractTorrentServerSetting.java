package goofyhts.torrentkinesis.torrent;

import goofyhts.torrentkinesis.TorrentHttpClient;

public abstract class AbstractTorrentServerSetting<SettingEntry extends TorrentServerSettingEntry> implements TorrentServerSetting<SettingEntry> {

	protected TorrentHttpClient httpClient;
	
	public AbstractTorrentServerSetting(TorrentHttpClient httpClient) {
		this.httpClient = httpClient;
	}
}
