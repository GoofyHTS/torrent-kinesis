package goofyhts.torrentkinesis.utorrent.server.request;

import goofyhts.torrentkinesis.html.TorrentHttpClient;
import goofyhts.torrentkinesis.html.parser.HtmlParser;
import goofyhts.torrentkinesis.json.parser.TorrentJsonParser;
import goofyhts.torrentkinesis.torrent.server.request.AbstractTorrenServerRequest;
import goofyhts.torrentkinesis.utorrent.constant.UTorrentServerConst;

public class UTorrentServerRequest extends AbstractTorrenServerRequest {

	public UTorrentServerRequest(String baseAddress, TorrentHttpClient httpClient, TorrentJsonParser jsonParser) {
		super(baseAddress, httpClient, jsonParser);
	}
	
	@Override
	protected String alterUrlBeforeRequest(TorrentHttpClient httpClient, String url) {
		String requestToken = getUTorrentRequestToken();
		return url + UTorrentServerConst.REQUEST_TOKEN_PORTION_URL + requestToken; 
	}
	
	private String getUTorrentRequestToken() {
		return HtmlParser.getElementTextById(httpClient.getURL(baseUrl + UTorrentServerConst.GET_REQUEST_TOKEN_URL), UTorrentServerConst.REQUEST_TOKEN_ELEMENT_ID);
	}
}
