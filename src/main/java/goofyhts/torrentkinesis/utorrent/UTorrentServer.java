package goofyhts.torrentkinesis.utorrent;

import java.util.List;

import com.google.gson.Gson;

import goofyhts.torrentkinesis.TorrentHttpClient;
import goofyhts.torrentkinesis.html.parser.HtmlParser;
import goofyhts.torrentkinesis.http.DefaultHttpClient;
import goofyhts.torrentkinesis.torrent.AbstractTorrentServer;
import goofyhts.torrentkinesis.torrent.TorrentServerSetting;
import goofyhts.torrentkinesis.torrent.TorrentServerSettingEntry;
import goofyhts.torrentkinesis.utorrent.constant.UTorrentServerConst;
import goofyhts.torrentkinesis.utorrent.json.response.UTorrentJsonResponse;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry;

public class UTorrentServer extends AbstractTorrentServer<UTorrentServerSettingEntry> {
	
	public UTorrentServer(String baseUrl, TorrentHttpClient httpClient) {
		super(baseUrl, httpClient);
	}
	
	public UTorrentServer(String baseUrl) {
		super(baseUrl, new DefaultHttpClient("root","Whcinhry21#"));		
	}
	
	public String getRequestToken() {
		return HtmlParser.getElementTextById(httpClient.getURL(baseUrl + UTorrentServerConst.REQUEST_TOKEN_URL), UTorrentServerConst.REQUEST_TOKEN_ELEMENT_ID);
	}

	@Override
	public TorrentServerSetting<UTorrentServerSettingEntry> getSettings() {
		httpClient.open();
		String json = httpClient.getURL(String.format(baseUrl + UTorrentServerConst.GET_TORRENT_SERVER_SETTINGS_URL, getRequestToken()));
		httpClient.close();
		UTorrentJsonResponse uTorrentJsonResponse = new Gson().fromJson(json, UTorrentJsonResponse.class);
		UTorrentServerSetting uTorrentServerSetting = new UTorrentServerSetting();
		uTorrentServerSetting.parseSettings(uTorrentJsonResponse.getSettings());
		return uTorrentServerSetting;
	}

	@Override
	public void setSetting(TorrentServerSettingEntry setting) {
		httpClient.open();
		String json = httpClient.getURL(String.format(baseUrl + UTorrentServerConst.SET_TORRENT_SERVER_SETTINGS_URL, setting.getSettingName(), setting.getSettingValue(), getRequestToken()));
		System.out.println("resp=" + json);
		httpClient.close();	
	}
	
	@Override
	public void setSettings(List<TorrentServerSettingEntry> settings) {
			
	}	
}