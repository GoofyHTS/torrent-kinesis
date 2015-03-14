package goofyhts.torrentkinesis.torrent.server.setting.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides basic functionality for a torrent server setting list
 * @author GoofyHTS
 *
 * @param <ServerSetting>
 */
public class AbstractTorrentServerSettingList<ServerSetting> implements TorrentServerSettingList<ServerSetting> {

	protected List<ServerSetting> settingList = new ArrayList<ServerSetting>();
	
	@Override
	public void addSetting(ServerSetting serverSetting) {
		settingList.add(serverSetting);
	}

	@Override
	public void addSettingList(List<ServerSetting> serverSetting) {
		settingList.addAll(serverSetting);
	}

	@Override
	public List<ServerSetting> getSettingList() {
		return null;
	}

	@Override
	public void save() {

	}
}
