package goofyhts.torrent.api.utorrent;

import java.util.List;

import com.google.gson.Gson;

import goofyhts.torrent.api.TorrentHttpClient;
import goofyhts.torrent.api.TorrentServer;
import goofyhts.torrent.api.domain.Torrent;
import goofyhts.torrent.api.html.parser.HtmlParser;
import goofyhts.torrent.api.http.DefaultHttpClient;
import goofyhts.torrent.api.utorrent.constant.UTorrentServerConst;
import goofyhts.torrent.api.utorrent.json.response.UTorrentJsonResponse;

public class UTorrentServer extends TorrentServer {
	
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
	public List<Torrent> getTorrentList() {
		String token = getRequestToken();
		String url = baseUrl + String.format(UTorrentServerConst.GET_TORRENT_LIST_URL, token);

		UTorrentJsonResponse uTorrentJsonResponse = new Gson().fromJson(httpClient.getURL(url), UTorrentJsonResponse.class);
		return null;//UtorrentDomainBuilder.buildTorrentList(uTorrentJsonResponse.getTorrents());
	}	
}
