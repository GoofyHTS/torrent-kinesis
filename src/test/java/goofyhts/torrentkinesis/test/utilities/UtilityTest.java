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
