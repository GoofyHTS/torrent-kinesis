package goofyhts.torrentkinesis.torrent;

public abstract class AbstractTorrentServerSetting<SettingEntry extends TorrentServerSettingEntry> implements TorrentServerSetting<SettingEntry> {

	protected TorrentServerRequest torrentServerRequest;
	
	public AbstractTorrentServerSetting(TorrentServerRequest torrentServerRequest) {
		this.torrentServerRequest = torrentServerRequest;
	}
}
