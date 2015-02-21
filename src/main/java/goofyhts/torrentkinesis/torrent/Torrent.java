package goofyhts.torrentkinesis.torrent;

import java.util.List;

public interface Torrent {

	List<TorrentFile> getTorrentFiles();
	List<TorrentProperty> getTorrentProperties();
	void setTorrentProperty(TorrentProperty torrentProperty);
	void start();
	void stop();
	void pause();
	void unPause();
	void forceStart();
	void recheck();
	void remove();
	void removeData();
	void setFilePriorities(List<TorrentFile> torrentFiles);
	void setQueueBottom();
	void setQueueDown();
	void setQueueTop();
	void setQueueUp();
}
