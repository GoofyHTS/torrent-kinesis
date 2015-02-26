/*
The MIT License (MIT)
Copyright (c) 2015 GoofyHTS
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package goofyhts.torrentkinesis.utorrent.server.setting;

import goofyhts.torrentkinesis.exception.InvalidTorrentServerSettingException;
import goofyhts.torrentkinesis.torrent.server.setting.TorrentServerSettingEntry;

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
			return; //skip validation for this setting, UTorrent bug. Data type is 0 (Integer) but contains a String
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
