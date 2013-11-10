//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.arr
{
	
	public class ArrayTypes1dim : BSerializable
	{
	
		#region Constructors
		
		public ArrayTypes1dim() {
		}		
		
		internal ArrayTypes1dim(bool[] @boolean1, byte[] @byte1, char[] @char1, short[] @short1, int[] @int1, long[] @long1, float[] @float1, double[] @double1, String[] @string1, java.util.Date[] @date1, byps.test.api.prim.PrimitiveTypes[] @primitiveTypes1) {
			this.boolean1Value = @boolean1;
			this.byte1Value = @byte1;
			this.char1Value = @char1;
			this.short1Value = @short1;
			this.int1Value = @int1;
			this.long1Value = @long1;
			this.float1Value = @float1;
			this.double1Value = @double1;
			this.string1Value = @string1;
			this.date1Value = @date1;
			this.primitiveTypes1Value = @primitiveTypes1;
		}		
		
		#endregion
		
		#region Properties
		
		public bool[] Boolean1
		{
			get
			{
				return boolean1Value;
			}
			set
			{
				this.boolean1Value = value;
			}
		}
		
		
		public byte[] Byte1
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
		
		
		public char[] Char1
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
		
		
		public short[] Short1
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
		
		
		public int[] Int1
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
		
		
		public long[] Long1
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
		
		
		public float[] Float1
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
		
		
		public double[] Double1
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
		
		
		public String[] String1
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
		
		
		public java.util.Date[] Date1
		{
			get
			{
				return date1Value;
			}
			set
			{
				this.date1Value = value;
			}
		}
		
		
		public byps.test.api.prim.PrimitiveTypes[] PrimitiveTypes1
		{
			get
			{
				return primitiveTypes1Value;
			}
			set
			{
				this.primitiveTypes1Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected bool[] boolean1Value;

		protected byte[] byte1Value;

		protected char[] char1Value;

		protected short[] short1Value;

		protected int[] int1Value;

		protected long[] long1Value;

		protected float[] float1Value;

		protected double[] double1Value;

		protected String[] string1Value;

		protected java.util.Date[] date1Value;

		protected byps.test.api.prim.PrimitiveTypes[] primitiveTypes1Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 2001L;		
	} // end class
}  // end namespace
