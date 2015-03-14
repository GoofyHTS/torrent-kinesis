package goofyhts.torrentkinesis.torrent.server.setting.list;

import java.util.List;

/**
 * Defines a list of torrent server settings
 * @author GoofyHTS
 *
 * @param <ServerSetting>
 */
public interface TorrentServerSettingList<ServerSetting> {

	/**
	 * Adds a torrent server setting to the list
	 * @param serverSetting Server setting
	 */
	public void addSetting(ServerSetting serverSetting);
	
	/**
	 * Adds a list of torrent server settings to the list
	 * @param serverSetting Server setting list
	 */
	public void addSettingList(List<ServerSetting> serverSetting);
	
	/**
	 * Gets a list of torrent server settings
	 * @return
	 */
	public List<ServerSetting> getSettingList();
	
	/**
	 * Saves the list of torrent server settings on the server
	 * <p>
	 * This results in a single request to the server
	 */
	public void save();
}
