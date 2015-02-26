package goofyhts.torrentkinesis.torrent.server.setting;

import goofyhts.torrentkinesis.torrent.server.request.TorrentServerRequest;

public abstract class AbstractTorrentServerSetting<SettingEntry extends TorrentServerSettingEntry> implements TorrentServerSetting<SettingEntry> {

	protected TorrentServerRequest torrentServerRequest;
	
	public AbstractTorrentServerSetting(TorrentServerRequest torrentServerRequest) {
		this.torrentServerRequest = torrentServerRequest;
	}
}
