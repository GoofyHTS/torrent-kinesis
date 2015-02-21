package goofyhts.torrentkinesis.utorrent;

import java.util.List;

import com.google.gson.Gson;

import goofyhts.torrentkinesis.TorrentHttpClient;
import goofyhts.torrentkinesis.html.parser.HtmlParser;
import goofyhts.torrentkinesis.http.DefaultHttpClient;
import goofyhts.torrentkinesis.torrent.AbstractTorrent;
import goofyhts.torrentkinesis.torrent.AbstractTorrentServer;
import goofyhts.torrentkinesis.torrent.TorrentServerSetting;
import goofyhts.torrentkinesis.utorrent.constant.UTorrentServerConst;
import goofyhts.torrentkinesis.utorrent.json.response.UTorrentJsonResponse;

public class UTorrentServer extends AbstractTorrentServer {
	
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
	public List<TorrentServerSetting> getSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSettings(List<TorrentServerSetting> settings) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public List<AbstractTorrent> getTorrentList() {
		String token = getRequestToken();
		String url = baseUrl + String.format(UTorrentServerConst.GET_TORRENT_LIST_URL, token);

		UTorrentJsonResponse uTorrentJsonResponse = new Gson().fromJson(httpClient.getURL(url), UTorrentJsonResponse.class);
		return null;//UtorrentDomainBuilder.buildTorrentList(uTorrentJsonResponse.getTorrents());
	}*/
	
}
