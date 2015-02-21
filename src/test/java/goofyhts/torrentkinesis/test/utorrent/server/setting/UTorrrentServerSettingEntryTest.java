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
