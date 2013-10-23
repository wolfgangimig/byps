package byps;

public class BEnumHelper {

	public static <E> E fromOrdinal(E[] values, int ordinal) {
		return ordinal >= 0 && ordinal < values.length ? values[ordinal] : values[0];
	}
	
}
