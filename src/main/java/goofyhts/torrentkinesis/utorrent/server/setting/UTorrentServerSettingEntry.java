package goofyhts.torrentkinesis.utorrent.server.setting;

import goofyhts.torrentkinesis.exception.InvalidTorrentServerSettingException;

public class UTorrentServerSettingEntry {
	
	public enum OPTION_TYPE {		
		INTEGER,
		BOOLEAN,
		STRING,
		INVALID;
		
		public static OPTION_TYPE fromValue(int value) {
			switch(value) {
				case 0 : return INTEGER; 
				case 1 : return BOOLEAN;
				case 2 : return STRING;
				default: return INVALID;
			}
		}
	}

	private String optionName;
	private OPTION_TYPE optionType;
	private String optionValue;
	
	public UTorrentServerSettingEntry(String optionName, int optionType, String optionValue) {
		this.optionName = optionName;
		this.optionType = OPTION_TYPE.fromValue(optionType);
		
		validateOptionValue(optionValue);
		
		this.optionValue = optionValue;
	}
	
	private void validateOptionValue(String value) {
		try {
			if (optionType == OPTION_TYPE.INTEGER) {
				Integer.parseInt(value);
			}			
			if (optionType == OPTION_TYPE.BOOLEAN) {
				if (!(value.equalsIgnoreCase("false") || value.equalsIgnoreCase("true"))) {
					throw new IllegalArgumentException(); //invoke catch below
				}
			}
		}
		catch(RuntimeException e) {
			throw new InvalidTorrentServerSettingException(String.format("Type not valid for %s. Requires a %s data type.", this.optionName, this.optionType));
		}
	}
	
	public String getOptionName() {
		return optionName;
	}
	public OPTION_TYPE getOptionType() {
		return optionType;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		validateOptionValue(optionValue);
		this.optionValue = optionValue;
	}	
}
