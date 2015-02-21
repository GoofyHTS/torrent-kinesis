package goofyhts.torrentkinesis.utorrent.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import goofyhts.torrentkinesis.TorrentHttpClient;
import goofyhts.torrentkinesis.exception.NotImplementedException;
import goofyhts.torrentkinesis.torrent.AbstractTorrent;
import goofyhts.torrentkinesis.utorrent.UTorrentServer;
import goofyhts.torrentkinesis.utorrent.constant.UTorrentServerConst;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UTorrentServerTest {
	
	private static final String basePath = "src\\test\\resources\\goofyhts\\torrentkinesis\\utorrent\\test\\resources";
	private static final String baseUrl = "http://unit.test:1234";
	private static final String baseTokenPath = basePath + "/token.html";
	private static final String baseTokenUrl = baseUrl + UTorrentServerConst.REQUEST_TOKEN_URL;
	private static final String token = "BoNU6Qj1-5U6-BiT8Q4ThE-eGsuuvUdyurxDkzEd2z_KUmmdUoHur6Zi2lQAAAAA";
	
	@Test
	public void getRequestTokenTest() throws IOException {
		String requestTokenHtml = FileUtils.readFileToString(new File(baseTokenPath));
		
		String expectedRequestToken = token;		
		String expectedUrl = baseTokenUrl;
		
		TorrentHttpClient httpClient = mock(TorrentHttpClient.class);		
		when(httpClient.getURL(expectedUrl)).thenReturn(requestTokenHtml);

		UTorrentServer uTorrentServer = new UTorrentServer(baseUrl, httpClient);
		String actualRequestToken = uTorrentServer.getRequestToken();
				
		verify(httpClient).getURL(expectedUrl);
		
		verifyNoMoreInteractions(httpClient);
		
		assertEquals(expectedRequestToken, actualRequestToken);		
	}
	
	@Test
	public void getTorrentListTest() throws IOException {
		String path = basePath + "/singleTorrentList.html";
		String torrentListJson = FileUtils.readFileToString(new File(path));
		
		//Torrent expectedTorrent = new Torrent();
		//expectedTorrent.setHash("01A6B93A6EF7BA32C5BE904C44F12373AC99A0E9");
		//expectedTorrent.setName("Supernatural.S10E08.HDTV.x264-LOL.mp4");
		
		String expectedUrl = baseUrl + String.format(UTorrentServerConst.GET_TORRENT_LIST_URL, token);
		
		TorrentHttpClient httpClient = mock(TorrentHttpClient.class);		
		when(httpClient.getURL(baseTokenUrl)).thenReturn(FileUtils.readFileToString(new File(baseTokenPath)));
		when(httpClient.getURL(expectedUrl)).thenReturn(torrentListJson);
		
		UTorrentServer uTorrentServer = new UTorrentServer(baseUrl, httpClient);
		//List<AbstractTorrent> torrents = uTorrentServer.getTorrentList();
		
		//verify(httpClient).getURL(baseTokenUrl);		
		//verify(httpClient).getURL(expectedUrl);
		
		//verifyNoMoreInteractions(httpClient);
		
		//assertEquals(expectedTorrent, torrents.get(0));
	}
	
	@Test(expected = NotImplementedException.class)
	public void testNotImplementedException() {
		throw new NotImplementedException();
	}
}
