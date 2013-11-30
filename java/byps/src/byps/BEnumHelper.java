package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

public class BEnumHelper {

	public static <E> E fromOrdinal(E[] values, int ordinal) {
		return ordinal >= 0 && ordinal < values.length ? values[ordinal] : values[0];
	}
	
}
