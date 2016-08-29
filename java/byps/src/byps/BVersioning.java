package byps;

import java.util.ArrayList;
import java.util.Arrays;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

/**
 * This class is used to convert version numbers to strings and vice versa.
 * Version numbers are used in string format e.g. at the javadoc since tags.
 * They are converted into long integer values to accelerate serialization.
 * <br/> 
 * A positive long integer (64bit) can hold up to 18 decimal digits (18 times the digit 9).
 * In the string representation, the digits are distributed on four groups separated by colon. 
 * The each of the first three groups consist of up to four digits and the last group holds up to six digits.
 * So the maximum version number is 9999.9999.9999.999999 and the minimum version number is 0.0.0.0.
 */
public class BVersioning {
	
	/**
	 * Convert a version number in string representation to a long integer.
	 * @param sver
	 * @return
	 */
	public static long stringToLong(String sver) {
		long ver = 0;
		if (sver != null && sver.length() != 0) {
			ArrayList<String> arr = new ArrayList<String>(Arrays.asList(sver.split("\\.")));
			while (arr.size() < 4) arr.add("0");
			for (int i = 0; i < Math.min(arr.size(), 4); i++) {
				ver *= 10000;
				if (i == 3) ver *= 100;
				if (arr.get(i).length() != 0) {
					ver += Integer.parseInt(arr.get(i));
				}
			}
		}
		return ver;
	}
	
	/**
	 * Convert a version number in integer representation into a string.
	 * @param nver
	 * @return
	 */
	public static String longToString(long nver) {
		StringBuilder sbuf = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int ndigits = (i == 0) ? 1000000 : 10000;
			int pver = (int)(nver % ndigits);

			if (i != 0) sbuf.insert(0,  '.'); 
			sbuf.insert(0, pver);
			
			nver /= ndigits;
		}
		return sbuf.toString();
	}
	
	
//	public static void main(String[] args) {
//		String[] svers = { "9999.9999.9999.999999", "0.0.0.0", "1.2.3.4", "8.00.032.012", "1234.2345.3456.456789" };
//		for (int i = 0; i < svers.length; i++) {
//			long nver = stringToLong(svers[i]);
//			String sver = longToString(nver);
//			System.out.println(sver + "=" + nver);
//		}
//	}
	
}
