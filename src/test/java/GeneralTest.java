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
