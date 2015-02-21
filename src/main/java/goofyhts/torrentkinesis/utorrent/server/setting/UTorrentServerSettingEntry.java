package goofyhts.torrentkinesis.utorrent.server.setting;

import goofyhts.torrentkinesis.exception.InvalidTorrentServerSettingException;
import goofyhts.torrentkinesis.torrent.TorrentServerSettingEntry;

public class UTorrentServerSettingEntry implements TorrentServerSettingEntry {
	
	public enum SETTING_TYPE {		
		INTEGER,
		BOOLEAN,
		STRING,
		INVALID;
		
		public static SETTING_TYPE fromValue(int value) {
			switch(value) {
				case 0 : return INTEGER; 
				case 1 : return BOOLEAN;
				case 2 : return STRING;
				default: return INVALID;
			}
		}
	}

	private String settingName;
	private SETTING_TYPE settingType;
	private String settingValue;
	
	public UTorrentServerSettingEntry(String settingName, int settingType, String settingValue) {
		this.settingName = settingName;
		this.settingType = SETTING_TYPE.fromValue(settingType);
		
		validateOptionValue(settingValue);
		
		this.settingValue = settingValue;
	}
	
	private void validateOptionValue(String value) {
		if (this.settingName.equals("offers.404_icon"))
			return; //skip validation, UTorrent bug. Data type is 0 (Integer) but contains a String
		try {
			if (settingType == SETTING_TYPE.INTEGER) {
				Integer.parseInt(value);
			}			
			if (settingType == SETTING_TYPE.BOOLEAN) {
				if (!(value.equalsIgnoreCase("false") || value.equalsIgnoreCase("true"))) {
					throw new IllegalArgumentException(); //invoke catch below
				}
			}
		}
		catch(RuntimeException e) {
			throw new InvalidTorrentServerSettingException(String.format("Type not valid for %s. Requires a %s data type.", this.settingName, this.settingType));
		}
	}

	@Override
	public String getSettingName() {
		return this.settingName;
	}
	
	@Override
	public String getSettingValue() {
		return this.settingValue;
	}

	@Override
	public void setSettingValue(String value) {
		validateOptionValue(value);
		this.settingValue = value;
	}
	
	public SETTING_TYPE getSettingType() {
		return this.settingType;
	}
}
