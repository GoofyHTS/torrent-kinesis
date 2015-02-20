package goofyhts.torrentkinesis.test.utilities;

import goofyhts.torrentkinesis.utilities.Utility;
import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void testConvertBytesToUnit() {
		String actual;
		
		long bytes = 62;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("0.06 kB", actual);
		
		bytes = 2545148;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("2.55 MB", actual);
		
		bytes = 15645416596L;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("15.65 GB", actual);		
	}
}
