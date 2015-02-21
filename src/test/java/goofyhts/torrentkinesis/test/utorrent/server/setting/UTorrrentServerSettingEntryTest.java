package goofyhts.torrentkinesis.test.utorrent.server.setting;

import goofyhts.torrentkinesis.exception.InvalidTorrentServerSettingException;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry.SETTING_TYPE;
import static org.junit.Assert.*;

import org.junit.Test;

public class UTorrrentServerSettingEntryTest {

	@Test
	public void testSettingDataType(){
		UTorrentServerSettingEntry classUnderTest = new UTorrentServerSettingEntry("option1", 0, "0");
		assertEquals(SETTING_TYPE.INTEGER, classUnderTest.getSettingType());
		
		classUnderTest = new UTorrentServerSettingEntry("option1", 1, "false");
		assertEquals(SETTING_TYPE.BOOLEAN, classUnderTest.getSettingType());
		
		classUnderTest = new UTorrentServerSettingEntry("option1", 2, "string");
		assertEquals(SETTING_TYPE.STRING, classUnderTest.getSettingType());
	}
	
	@Test
	public void testValidSettingDataType() {
		UTorrentServerSettingEntry classUnderTest = new UTorrentServerSettingEntry("option1", 0, "0");
		classUnderTest.setSettingValue("6");
		assertEquals("6", classUnderTest.getSettingValue());
		
		classUnderTest = new UTorrentServerSettingEntry("option1", 1, "false");
		classUnderTest.setSettingValue("true");
		assertEquals("true", classUnderTest.getSettingValue());
		classUnderTest.setSettingValue("false");
		assertEquals("false", classUnderTest.getSettingValue());
		
		classUnderTest = new UTorrentServerSettingEntry("option1", 2, "string");
		classUnderTest.setSettingValue("otherstring");
		assertEquals("otherstring", classUnderTest.getSettingValue());
	}
	
	@Test(expected = InvalidTorrentServerSettingException.class)
	public void testInvalidIntegerNewSettingDataType() {
		new UTorrentServerSettingEntry("option1", 0, "abc");
	}
	
	@Test(expected = InvalidTorrentServerSettingException.class)
	public void testInvalidBooleanNewSettingDataType() {
		new UTorrentServerSettingEntry("option1", 1, "abc");
	}
	
	@Test(expected = InvalidTorrentServerSettingException.class)
	public void testInvalidIntegerSetSettingDataType() {
		UTorrentServerSettingEntry classUnderTest = new UTorrentServerSettingEntry("option1", 0, "0");
		classUnderTest.setSettingValue("abc");
	}
	
	@Test(expected = InvalidTorrentServerSettingException.class)
	public void testInvalidBooleanSetSettingDataType() {
		UTorrentServerSettingEntry classUnderTest = new UTorrentServerSettingEntry("option1", 1, "false");
		classUnderTest.setSettingValue("abc");
	}
	
	@Test
	public void testIgnore_offers_404_icon_SettingValidation() {
		UTorrentServerSettingEntry classUnderTest = new UTorrentServerSettingEntry("offers.404_icon", 0, "");
		classUnderTest = new UTorrentServerSettingEntry("offers.404_icon", 1, "");
		classUnderTest = new UTorrentServerSettingEntry("offers.404_icon", 2, "");
	}
}
