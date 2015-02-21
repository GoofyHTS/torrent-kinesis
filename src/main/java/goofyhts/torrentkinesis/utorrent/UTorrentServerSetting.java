package goofyhts.torrentkinesis.utorrent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import goofyhts.torrentkinesis.torrent.TorrentServerSetting;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry;

public class UTorrentServerSetting implements TorrentServerSetting<UTorrentServerSettingEntry> {
	
	protected HashMap<String, UTorrentServerSettingEntry> settings = new HashMap<String, UTorrentServerSettingEntry>();
	
	@Override
	public void parseSettings(Object value) {
		Object[][] utorrentSettings = (Object[][])value;
		for(Object[] arr : utorrentSettings) {
			String optionName = (String)arr[0];
			int optionType = (int) Math.round((Double)arr[1]);
			String optionValue = (String)arr[2];
			UTorrentServerSettingEntry uTorrentServerSettingEntry = new UTorrentServerSettingEntry(optionName, optionType, optionValue);
			
			this.settings.put(optionName, uTorrentServerSettingEntry);
		}		
	}

	@Override
	public UTorrentServerSettingEntry getSetting(String value) {
		return this.settings.get(value);
	}
	
	@Override
	public List<UTorrentServerSettingEntry> getAllSettings() {
		return new ArrayList<UTorrentServerSettingEntry>(settings.values());
	}

}
