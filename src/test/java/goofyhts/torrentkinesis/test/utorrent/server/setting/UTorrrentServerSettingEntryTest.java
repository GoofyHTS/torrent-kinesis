package goofyhts.torrentkinesis.test.utorrent.server.setting;

import goofyhts.torrentkinesis.exception.InvalidTorrentServerSettingException;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry;
import goofyhts.torrentkinesis.utorrent.server.setting.UTorrentServerSettingEntry.OPTION_TYPE;
import static org.junit.Assert.*;

import org.junit.Test;

public class UTorrrentServerSettingEntryTest {

	@Test
	public void testSettingDataType(){
		UTorrentServerSettingEntry classUnderTest = new UTorrentServerSettingEntry("option1", 0, "0");
		assertEquals(OPTION_TYPE.INTEGER, classUnderTest.getOptionType());
		
		classUnderTest = new UTorrentServerSettingEntry("option1", 1, "false");
		assertEquals(OPTION_TYPE.BOOLEAN, classUnderTest.getOptionType());
		
		classUnderTest = new UTorrentServerSettingEntry("option1", 2, "string");
		assertEquals(OPTION_TYPE.STRING, classUnderTest.getOptionType());
	}
	
	@Test
	public void testValidSettingDataType() {
		UTorrentServerSettingEntry classUnderTest = new UTorrentServerSettingEntry("option1", 0, "0");
		classUnderTest.setOptionValue("6");
		assertEquals("6", classUnderTest.getOptionValue());
		
		classUnderTest = new UTorrentServerSettingEntry("option1", 1, "false");
		classUnderTest.setOptionValue("true");
		assertEquals("true", classUnderTest.getOptionValue());
		classUnderTest.setOptionValue("false");
		assertEquals("false", classUnderTest.getOptionValue());
		
		classUnderTest = new UTorrentServerSettingEntry("option1", 2, "string");
		classUnderTest.setOptionValue("otherstring");
		assertEquals("otherstring", classUnderTest.getOptionValue());
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
		classUnderTest.setOptionValue("abc");
	}
	
	@Test(expected = InvalidTorrentServerSettingException.class)
	public void testInvalidBooleanSetSettingDataType() {
		UTorrentServerSettingEntry classUnderTest = new UTorrentServerSettingEntry("option1", 1, "false");
		classUnderTest.setOptionValue("abc");
	}
}
