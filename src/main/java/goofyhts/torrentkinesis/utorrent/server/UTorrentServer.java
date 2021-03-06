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
package goofyhts.torrentkinesis.utorrent.server;

import goofyhts.torrentkinesis.html.TorrentHttpClient;
import goofyhts.torrentkinesis.http.client.DefaultHttpClient;
import goofyhts.torrentkinesis.json.parser.TorrentJsonParser;
import goofyhts.torrentkinesis.json.parser.gson.GsonTorrentParser;
import goofyhts.torrentkinesis.torrent.server.AbstractTorrentServer;
import goofyhts.torrentkinesis.utorrent.server.request.UTorrentServerRequest;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSetting;
import goofyhts.torrentkinesis.utorrent.server.setting.entry.UTorrentServerSettingEntry;

/**
 * UTorrent server implementation
 * @author GoofyHTS
 *
 */
public class UTorrentServer extends AbstractTorrentServer<UTorrentServerSetting,UTorrentServerSettingEntry> {
	
	/**
	 * Constructor, using the default http client and Json parser
	 * @param baseAddress Base URL of the UTorrent server
	 * @param username Username of the UTorrent server
	 * @param password Password of the UTorrent server
	 */
	public UTorrentServer(String baseAddress, String username, String password) {
		super(new UTorrentServerRequest(baseAddress, new DefaultHttpClient(username, password), new GsonTorrentParser()));
	}
	
	/**
	 * Constructor, using the default Json parser
	 * @param baseAddress Base URL of the UTorrent server
	 * @param httpClient Http client used for requests
	 */
	public UTorrentServer(String baseAddress, TorrentHttpClient httpClient) {
		super(new UTorrentServerRequest(baseAddress, httpClient, new GsonTorrentParser()));		
	}
	
	/**
	 * Constructor
	 * @param baseAddress Base URL of the UTorrent server
	 * @param httpClient Http client used for requests
	 * @param jsonParser Json parser used to parse responses
	 */
	public UTorrentServer(String baseAddress, TorrentHttpClient httpClient, TorrentJsonParser jsonParser) {
		super(new UTorrentServerRequest(baseAddress, httpClient, jsonParser));		
	}

	@Override
	public UTorrentServerSetting getTorrentServerSetting() {
		return new UTorrentServerSetting(torrentServerRequest);
	}

	/*@Override
	public List<UTorrentServerSettingEntry> getSettings() {
		httpClient.open();
		String url = buildRequestUrl(baseUrl, UTorrentServerConst.GET_TORRENT_SERVER_SETTINGS_BASE_URL, "", getRequestToken());
		String json = httpClient.getURL(url);
		httpClient.close();
		UTorrentJsonResponse uTorrentJsonResponse = new Gson().fromJson(json, UTorrentJsonResponse.class);
		UTorrentServerSetting uTorrentServerSetting = new UTorrentServerSetting();
		uTorrentServerSetting.parseSettings(uTorrentJsonResponse.getSettings());
		
		return uTorrentServerSetting.getSettings();
	}

	@Override
	public void setSetting(UTorrentServerSettingEntry setting) {
		httpClient.open();
		//String json = httpClient.getURL(String.format(baseUrl + UTorrentServerConst.SET_TORRENT_SERVER_SETTINGS_SINGLE_URL, setting.getSettingName(), setting.getSettingValue(), getRequestToken()));
		//System.out.println("resp=" + json);
		httpClient.close();
		//check success!
	}
	
	@Override
	public void setSettings(List<UTorrentServerSettingEntry> settings) {
		System.out.println("SIZE=" + settings.size());
		httpClient.open();
		StringBuilder request = new StringBuilder();
		for(TorrentServerSettingEntry entry : settings) {
			request = request.append(String.format(UTorrentServerConst.SET_TORRENT_SERVER_SETTINGS_PORTION_URL, entry.getSettingName(), entry.getSettingValue()));
			System.out.println("appending " + String.format(UTorrentServerConst.SET_TORRENT_SERVER_SETTINGS_PORTION_URL, entry.getSettingName(), entry.getSettingValue()));
		}
		
		String json = httpClient.getURL(String.format(baseUrl + request, getRequestToken()));
		System.out.println("resp=" + json);
		httpClient.close();
	}	
	
	private String buildRequestUrl(String baseUrl, String action, String parameters, String requestToken) {
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl);
		sb.append(action);
		sb.append(parameters);
		sb.append(UTorrentServerConst.REQUEST_TOKEN_PORTION_URL);
		sb.append(requestToken);
		return sb.toString();
	}

	@Override
	public UTorrentServerSettingEntry getSetting(String name) {
		httpClient.open();
		String url = buildRequestUrl(baseUrl, UTorrentServerConst.GET_TORRENT_SERVER_SETTINGS_BASE_URL, "", getRequestToken());
		String json = httpClient.getURL(url);
		httpClient.close();
		UTorrentJsonResponse uTorrentJsonResponse = new Gson().fromJson(json, UTorrentJsonResponse.class);
		UTorrentServerSetting uTorrentServerSetting = new UTorrentServerSetting();
		uTorrentServerSetting.parseSettings(uTorrentJsonResponse.getSettings());
		
		return uTorrentServerSetting.getSetting(name);
	}
	*/

}