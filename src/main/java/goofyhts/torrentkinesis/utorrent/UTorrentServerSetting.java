package goofyhts.torrentkinesis.utorrent;

import java.util.HashMap;

import goofyhts.torrentkinesis.torrent.TorrentServerSetting;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry;

public class UTorrentServerSetting implements TorrentServerSetting<String, UTorrentServerSettingEntry> {
	
	protected HashMap<String, UTorrentServerSettingEntry> settings = new HashMap<String, UTorrentServerSettingEntry>();
	
	@Override
	public void parseSettings(Object value) {
		String[][] utorrentSettings = (String[][])value;
		for(String[] arr : utorrentSettings) {
			String optionName = arr[0];
			int optionType = Integer.parseInt(arr[1]);
			String optionValue = arr[2];
			UTorrentServerSettingEntry uTorrentServerSettingEntry = new UTorrentServerSettingEntry(optionName, optionType, optionValue);
			
			settings.put(optionName, uTorrentServerSettingEntry);
		}		
	}

	@Override
	public UTorrentServerSettingEntry getSetting(String value) {
		return settings.get(value);
	}

	@Override
	public void setSetting(UTorrentServerSettingEntry value) {
		
	}
}
