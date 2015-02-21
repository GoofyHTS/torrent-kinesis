package goofyhts.torrentkinesis.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utility {

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
	
	public static String convertBytesToSpeedUnit(long bytes) {
		return convertBytesToUnit(bytes) + "/s";
	}
}
