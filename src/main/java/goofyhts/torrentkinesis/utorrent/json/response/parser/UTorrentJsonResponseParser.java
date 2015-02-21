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
