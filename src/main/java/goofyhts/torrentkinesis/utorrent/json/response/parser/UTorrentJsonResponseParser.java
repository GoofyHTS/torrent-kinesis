package goofyhts.torrentkinesis.utorrent.json.response.parser;

import java.util.ArrayList;
import java.util.List;

import goofyhts.torrentkinesis.torrent.AbstractTorrent;
import goofyhts.torrentkinesis.utilities.Utility;
import goofyhts.torrentkinesis.utorrent.json.response.UTorrentJsonResponse;

public class UTorrentJsonResponseParser {
	
	public enum TorrentStatus {
		STARTED(1),
		CHECKING(2),
		START_AFTER_CHECK(4),
		CHECKED(8),
		ERROR(16),
		PAUSED(32),
		QUEUED(64),
		LOADED(128);
		
		private final int value;
		
		private TorrentStatus(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
	}

	private List<AbstractTorrent> torrents = new ArrayList<AbstractTorrent>();
	
	public UTorrentJsonResponseParser(UTorrentJsonResponse uTorrentJsonResponse) {
		parseTorrents(uTorrentJsonResponse.getTorrents());
	}
	
	private void parseTorrents(String[][] torrentsData) {
		for(String[] torrentData : torrentsData) {
			/*Torrent torrent = new Torrent();
			torrent.setHash(torrentData[0]);
			torrent.setName(torrentData[1]);
			torrent.setSize(Integer.parseInt(torrentData[2]));
			torrent.setSizeInclUnit(Utility.convertBytesToUnit(torrent.getSize()));
			torrent.setPercentProgress(Integer.parseInt(torrentData[3]));
						
			torrents.add(torrent);*/
		}		
	}
}
