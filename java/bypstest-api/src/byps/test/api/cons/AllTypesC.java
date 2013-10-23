package byps.test.api.cons;

import java.io.Serializable;


public class AllTypesC implements Serializable {

	private static final long serialVersionUID = 6059479029804902916L;
	
	public final static boolean bool1s = true;
	public final static boolean bool2s = false;
	public final static byte byte1s = (byte)1;
	public final static char char1s = '¿';
	public final static String stringNull = ""; 
	
	/**
	 * This constant holds the currency symbol for Euro.
	 * It is defined "final static" and thus cannot be changed. 
	 */
	public final static char char2s = '€';
	public final static short short1s = (short)3;
	public final static int int1s = 4;
	public final static long long1s = 0x5555555555555555L;
	public final static float float1s = 6.8f;
	public final static double double1s = 7.8;
	public final static String string1s = "Aa__¶¶__€€__\t\r\n\"\'";
	
	/**
	 * This defines a complex constant.
	 * It is an instance of the class AllTypesZ.
	 * The field value cannot be changed, but it's contents could.
	 */
	public final static AllTypesZ ALL = new AllTypesZ(
			true, (byte)1, 'A', (short)2, 3, 4L, 5.0f, 6.0, "777",
			HebrewC.ALEPH, 
			new byte[] {1,2,3}, new int[] {-4,-5}, new String[] {"a","b"}, 
			new HebrewZ[] { HebrewC.ALEPH, HebrewC.BETH });
	
	public final static int[] arrInt = new int[] {1,2,3};
	public final static int[][][][] arrInt4 = new int[][][][] {
		{
			{
				{1,2},{4,5}
			},
			{
				{11,12},{14,15}
			},
		},
		{
			{
				{21,22},{24,25}
			},
			{
				{211,212},{214,215}
			},
		}
	};
	
	public final static String[] arrStrings = new String[] {"s1", "s2"};
	public final static String[][][][] arrStrings4 = new String[][][][] {{{{"s1", "s2"}}}};
	
	public final static AllTypesZ[][] arrALL = new AllTypesZ[][] { { new AllTypesZ() }, { ALL } };
}
