package goofyhts.torrentkinesis.test.utilities;

import goofyhts.torrentkinesis.utilities.Utility;
import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void testConvertBytesToUnit() {
		String actual;
		
		long bytes = 500;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("0.50 kB", actual);
		
		bytes = 125487;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("125.49 kB", actual);
		
		bytes = 122515269;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("122.52 MB", actual);
		
		bytes = 132652685845L;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("132.65 GB", actual);	
		
		bytes = 85412545236365L;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("85.41 TB", actual);
		
		bytes = 32547895412563254L;
		actual = Utility.convertBytesToUnit(bytes);
		assertEquals("32.55 PB", actual);
		
	}
	
	@Test
	public void testConvertBytesToSpeedUnit() {
		String actual;
		
		long bytes = 500;
		actual = Utility.convertBytesToSpeedUnit(bytes);
		assertEquals("0.50 kB/s", actual);
		
		bytes = 125487;
		actual = Utility.convertBytesToSpeedUnit(bytes);
		assertEquals("125.49 kB/s", actual);
		
		bytes = 122515269;
		actual = Utility.convertBytesToSpeedUnit(bytes);
		assertEquals("122.52 MB/s", actual);
		
		bytes = 132652685845L;
		actual = Utility.convertBytesToSpeedUnit(bytes);
		assertEquals("132.65 GB/s", actual);	
		
		bytes = 85412545236365L;
		actual = Utility.convertBytesToSpeedUnit(bytes);
		assertEquals("85.41 TB/s", actual);
		
		bytes = 32547895412563254L;
		actual = Utility.convertBytesToSpeedUnit(bytes);
		assertEquals("32.55 PB/s", actual);
		
	}
}
