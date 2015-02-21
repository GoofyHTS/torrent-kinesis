package goofyhts.torrentkinesis.torrent;

public abstract class AbstractTorrent {

	private String hash;
	private String name;
	private int status;
	private long size; //bytes
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
