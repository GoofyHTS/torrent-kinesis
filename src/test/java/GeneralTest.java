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
import java.util.List;

import org.junit.Test;

import goofyhts.torrentkinesis.http.DefaultHttpClient;
import goofyhts.torrentkinesis.torrent.TorrentServer;
import goofyhts.torrentkinesis.utorrent.UTorrentServer;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry;


public class GeneralTest {

	@Test
	public void test() {
	    UTorrentServer uTorrentServer = new UTorrentServer("http://localhost:8150/gui", new DefaultHttpClient("root", "Whcinhry21#"));
		List<UTorrentServerSettingEntry> entries = uTorrentServer.getSettings().getAllSettings();
		for(UTorrentServerSettingEntry e : entries) {
			System.out.println(e.getSettingName()+"="+e.getSettingValue() + " TYPE=" + e.getSettingType());
		}
		System.out.println(uTorrentServer.getSettings().getSetting("max_dl_rate").getSettingValue());
		
		UTorrentServerSettingEntry entry = uTorrentServer.getSettings().getSetting("max_dl_rate");
		entry.setSettingValue("123"); //test changing setting
				
		
		uTorrentServer.setSetting(entry);
	}
}
