package goofyhts.torrentkinesis.domain;

public class Torrent {

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
	}
	
	public Torrent(String[] data) {
		this.hash = data[0];
		this.status = Integer.parseInt(data[1]);
		this.name = data[2];
		this.size = Integer.parseInt(data[3]);
	}
	
	private String hash;
	private String name;
	private int status;
	private int size; //bytes
	private String sizeInclUnit;
	private int percentProgress; //per mils
	private int downloaded; //bytes
	private int uploaded; //bytes
	private int ratio; //per mils
	private int uploadSpeed; //bytes per second
	private int downloadSpeed; //bytes per second
	private int eta; //seconds
	private String label;
	private int peersConnected;
	private int peersInSwarm;
	private int seedsConnected;
	private int seedsInSwarm;
	private int availability; // 1/65536ths
	private int torrentQueueOrder;
	private int remaining; //bytes;	
	private String statusText;
	private String saveDirectory;
		
}
