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

import java.util.Arrays;
import java.util.List;

import goofyhts.torrentkinesis.torrent.server.request.TorrentServerRequest;
import goofyhts.torrentkinesis.torrent.server.setting.cache.AbstractTorrentServerSettingCache;
import goofyhts.torrentkinesis.utorrent.constant.UTorrentServerConst;
import goofyhts.torrentkinesis.utorrent.json.response.UTorrentJsonResponse;
import goofyhts.torrentkinesis.utorrent.server.setting.entry.UTorrentServerSettingEntry;

public class UTorrentServerSetting extends AbstractTorrentServerSettingCache<UTorrentServerSettingEntry> {
	
	public UTorrentServerSetting(TorrentServerRequest torrentServerRequest) {
		super(torrentServerRequest);
		refreshSettings();
	}

	@Override
	public void refreshSettings() {
		String json = this.torrentServerRequest.getRequest(UTorrentServerConst.GET_TORRENT_SERVER_SETTINGS_URL);
		UTorrentJsonResponse uTorrentJsonResponse = this.torrentServerRequest.getJsonParser().jsonToObject(json, UTorrentJsonResponse.class);
		System.out.println(uTorrentJsonResponse.getBuild());
				
		Object[][] utorrentSettings = uTorrentJsonResponse.getSettings();
		
		this.settings.clear();
		for(Object[] arr : utorrentSettings) {
			String optionName = (String)arr[0];
			int optionType = (int) Math.round((Double)arr[1]);
			String optionValue = (String)arr[2];
			UTorrentServerSettingEntry uTorrentServerSettingEntry = new UTorrentServerSettingEntry(optionName, optionType, optionValue);
			
			this.settings.put(optionName, uTorrentServerSettingEntry);
		}		
	}

	/*@Override
	public void setSetting(UTorrentServerSettingEntry serverSetting) {
		String url = buildSetSettingsUrl(Arrays.asList(new UTorrentServerSettingEntry[]{serverSetting}));
		String json = this.torrentServerRequest.getRequest(url);
		
		UTorrentJsonResponse uTorrentJsonResponse = this.torrentServerRequest.getJsonParser().jsonToObject(json, UTorrentJsonResponse.class);
		System.out.println(uTorrentJsonResponse.getBuild());
	}

	@Override
	public void setSettings(List<UTorrentServerSettingEntry> serverSettings) {
		String url = buildSetSettingsUrl(serverSettings);
		String json = this.torrentServerRequest.getRequest(url);
		
		UTorrentJsonResponse uTorrentJsonResponse = this.torrentServerRequest.getJsonParser().jsonToObject(json, UTorrentJsonResponse.class);
		System.out.println(uTorrentJsonResponse.getBuild());
	}*/
	
	private String buildSetSettingsUrl(List<UTorrentServerSettingEntry> serverSettings) {
		StringBuilder url = new StringBuilder(UTorrentServerConst.SET_TORRENT_SERVER_SETTINGS_BASE_URL);
		for(UTorrentServerSettingEntry uTorrentServerSettingEntry : serverSettings) {
			url.append(String.format(UTorrentServerConst.SET_TORRENT_SERVER_SETTINGS_PORTION_URL, uTorrentServerSettingEntry.getName(), uTorrentServerSettingEntry.getValue()));
		}
		return url.toString();
	}
}
