//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class AllTypesZ : BSerializable
	{
	
		#region Constructors
		
		public AllTypesZ() {
		}		
		
		public AllTypesZ(bool @bool1, byte @byte1, char @char1, short @short1, int @int1, long @long1, float @float1, double @double1, String @string1, HebrewZ @hebrew1, byte[] @byte2, int[] @int2, String[] @string2, HebrewZ[] @hebrew2) {
			this.bool1Value = @bool1;
			this.byte1Value = @byte1;
			this.char1Value = @char1;
			this.short1Value = @short1;
			this.int1Value = @int1;
			this.long1Value = @long1;
			this.float1Value = @float1;
			this.double1Value = @double1;
			this.string1Value = @string1;
			this.hebrew1Value = @hebrew1;
			this.byte2Value = @byte2;
			this.int2Value = @int2;
			this.string2Value = @string2;
			this.hebrew2Value = @hebrew2;
		}		
		
		public AllTypesZ(AllTypesZ rhs)
		{
			this.bool1Value = rhs.bool1Value;
			this.byte1Value = rhs.byte1Value;
			this.char1Value = rhs.char1Value;
			this.short1Value = rhs.short1Value;
			this.int1Value = rhs.int1Value;
			this.long1Value = rhs.long1Value;
			this.float1Value = rhs.float1Value;
			this.double1Value = rhs.double1Value;
			this.string1Value = rhs.string1Value;
			this.hebrew1Value = rhs.hebrew1Value;
			this.byte2Value = rhs.byte2Value;
			this.int2Value = rhs.int2Value;
			this.string2Value = rhs.string2Value;
			this.hebrew2Value = rhs.hebrew2Value;
		}		
		
		#endregion
		
		#region Properties
		
		public bool Bool1
		{
			get
			{
				return bool1Value;
			}
			set
			{
				this.bool1Value = value;
			}
		}
		
		
		public byte Byte1
		{
			get
			{
				return byte1Value;
			}
			set
			{
				this.byte1Value = value;
			}
		}
		
		
		public char Char1
		{
			get
			{
				return char1Value;
			}
			set
			{
				this.char1Value = value;
			}
		}
		
		
		public short Short1
		{
			get
			{
				return short1Value;
			}
			set
			{
				this.short1Value = value;
			}
		}
		
		
		public int Int1
		{
			get
			{
				return int1Value;
			}
			set
			{
				this.int1Value = value;
			}
		}
		
		
		public long Long1
		{
			get
			{
				return long1Value;
			}
			set
			{
				this.long1Value = value;
			}
		}
		
		
		public float Float1
		{
			get
			{
				return float1Value;
			}
			set
			{
				this.float1Value = value;
			}
		}
		
		
		public double Double1
		{
			get
			{
				return double1Value;
			}
			set
			{
				this.double1Value = value;
			}
		}
		
		
		public String String1
		{
			get
			{
				return string1Value;
			}
			set
			{
				this.string1Value = value;
			}
		}
		
		
		public HebrewZ Hebrew1
		{
			get
			{
				return hebrew1Value;
			}
			set
			{
				this.hebrew1Value = value;
			}
		}
		
		
		public byte[] Byte2
		{
			get
			{
				return byte2Value;
			}
			set
			{
				this.byte2Value = value;
			}
		}
		
		
		public int[] Int2
		{
			get
			{
				return int2Value;
			}
			set
			{
				this.int2Value = value;
			}
		}
		
		
		public String[] String2
		{
			get
			{
				return string2Value;
			}
			set
			{
				this.string2Value = value;
			}
		}
		
		
		public HebrewZ[] Hebrew2
		{
			get
			{
				return hebrew2Value;
			}
			set
			{
				this.hebrew2Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected bool bool1Value;

		protected byte byte1Value;

		protected char char1Value;

		protected short short1Value;

		protected int int1Value;

		protected long long1Value;

		protected float float1Value;

		protected double double1Value;

		protected String string1Value;

		protected HebrewZ hebrew1Value;

		protected byte[] byte2Value;

		protected int[] int2Value;

		protected String[] string2Value;

		protected HebrewZ[] hebrew2Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 142458L;		
	} // end class
}  // end namespace
