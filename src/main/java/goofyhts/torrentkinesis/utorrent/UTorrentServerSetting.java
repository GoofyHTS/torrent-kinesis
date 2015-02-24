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
package goofyhts.torrentkinesis.utorrent;

import java.util.List;

import goofyhts.torrentkinesis.TorrentHttpClient;
import goofyhts.torrentkinesis.torrent.AbstractTorrentServerSettingCache;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry;

public class UTorrentServerSetting extends AbstractTorrentServerSettingCache<UTorrentServerSettingEntry> {
	
	public UTorrentServerSetting(TorrentHttpClient httpClient) {
		super(httpClient);
	}

	@Override
	public void refreshSettings() {
		this.httpClient.open();
		//String url = buildRequestUrl(baseUrl, UTorrentServerConst.GET_TORRENT_SERVER_SETTINGS_BASE_URL, "", getRequestToken());
		//String json = httpClient.getURL(url);
		this.httpClient.close();
		//UTorrentJsonResponse uTorrentJsonResponse = new Gson().fromJson(json, UTorrentJsonResponse.class);
		
		
		Object[][] utorrentSettings = null;//(Object[][])value;
		
		this.settings.clear();
		for(Object[] arr : utorrentSettings) {
			String optionName = (String)arr[0];
			int optionType = (int) Math.round((Double)arr[1]);
			String optionValue = (String)arr[2];
			UTorrentServerSettingEntry uTorrentServerSettingEntry = new UTorrentServerSettingEntry(optionName, optionType, optionValue);
			
			this.settings.put(optionName, uTorrentServerSettingEntry);
		}		
	}

	@Override
	public void setSetting(UTorrentServerSettingEntry serverSetting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSettings(List<UTorrentServerSettingEntry> serverSetting) {
		// TODO Auto-generated method stub
		
	}
}
