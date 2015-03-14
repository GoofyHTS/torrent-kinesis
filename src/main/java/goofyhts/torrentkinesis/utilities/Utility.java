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
package goofyhts.torrentkinesis.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Contains utilities
 * @author GoofyHTS
 *
 */
public class Utility {

	/**
	 * Converts bytes to a representable unit, such as MB,GB,TB etc.
	 * @param bytes
	 * @return
	 */
	public static String convertBytesToUnit(long bytes) {
		String unit = " kB";
		BigDecimal divisor = new BigDecimal(1000);
		BigDecimal value = new BigDecimal(bytes);
		
		value = value.divide(divisor);

		if (value.compareTo(divisor) == 1) {
			value = value.divide(divisor);
			unit = " MB";
		}		
		if (value.compareTo(divisor) == 1) {
			value = value.divide(divisor);
			unit = " GB";
		}
		if (value.compareTo(divisor) == 1) {
			value = value.divide(divisor);
			unit = " TB";
		}
		if (value.compareTo(divisor) == 1) {
			value = value.divide(divisor);
			unit = " PB";
		}
		
		return value.setScale(2, RoundingMode.HALF_UP) + unit;
	}
	
	/**
	 * Converts bytes per second to a representable unit, such as MB/s,GB/s etc.
	 * @param bytes
	 * @return
	 */
	public static String convertBytesToSpeedUnit(long bytes) {
		return convertBytesToUnit(bytes) + "/s";
	}
}
