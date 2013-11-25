//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class AllTypesC : BSerializable
	{
	
		#region Constructors
		
		public AllTypesC() {
		}		
		
		public AllTypesC(AllTypesC rhs)
		{
		}		
		
		#endregion
		
		#region Properties
		
		#endregion
		
		#region Fields
		
		public const bool Bool1s = true;

		public const bool Bool2s = false;

		public const byte Byte1s = (byte)1;

		public const char Char1s = '\u00bf';

		public const String StringNull = "";

		/// <summary>
		/// This constant holds the currency symbol for Euro.
		/// </summary>
		/// <remarks>
		/// It is defined "final static" and thus cannot be changed.
		/// </remarks>
		public const char Char2s = '\u20ac';

		public const short Short1s = (short)3;

		public const int Int1s = 4;

		public const long Long1s = 6148914691236517205L;

		public const float Float1s = 6.8f;

		public const double Double1s = 7.8;

		public const String String1s = "Aa__\u00b6\u00b6__\u20ac\u20ac__\t\r\n\"\'";

		/// <summary>
		/// This defines a complex constant.
		/// </summary>
		/// <remarks>
		/// It is an instance of the class AllTypesZ.
		/// The field value cannot be changed, but it's contents could.
		/// </remarks>
		public readonly static AllTypesZ ALL = new AllTypesZ(true, (byte)1, 'A', (short)2, 3, 4L, 5.0f, 6.0, "777", new HebrewZ("\u05d0"), new byte[]{(byte)1,(byte)2,(byte)3}, new int[]{-4,-5}, new String[]{"a","b"}, new HebrewZ[]{new HebrewZ("\u05d0"),new HebrewZ("\u05d1")});

		public readonly static int[] ArrInt = new int[]{1,2,3};

		public readonly static int[,,,] ArrInt4 = new int[,,,]{{{{1,2},{4,5}},{{11,12},{14,15}}},{{{21,22},{24,25}},{{211,212},{214,215}}}};

		public readonly static String[] ArrStrings = new String[]{"s1","s2"};

		public readonly static String[,,,] ArrStrings4 = new String[,,,]{{{{"s1","s2"}}}};

		public readonly static AllTypesZ[,] ArrALL = new AllTypesZ[,]{{new AllTypesZ(false, (byte)0, '\0', (short)0, 0, 0L, 0.0f, 0.0, "", null, null, null, null, null)},{new AllTypesZ(true, (byte)1, 'A', (short)2, 3, 4L, 5.0f, 6.0, "777", new HebrewZ("\u05d0"), new byte[]{(byte)1,(byte)2,(byte)3}, new int[]{-4,-5}, new String[]{"a","b"}, new HebrewZ[]{new HebrewZ("\u05d0"),new HebrewZ("\u05d1")})}};

		#endregion
		
		
		public static readonly long serialVersionUID = 930294276L;		
	} // end class
}  // end namespace
