//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.arr
{
	
	public class ArrayTypes1dim : BSerializable
	{
	
		#region Constructors
		
		public ArrayTypes1dim() {
		}		
		
		internal ArrayTypes1dim(bool[] @boolean1, byte[] @byte1, char[] @char1, short[] @short1, int[] @int1, long[] @long1, float[] @float1, double[] @double1, String[] @string1, com.wilutions.byps.test.api.prim.PrimitiveTypes[] @primitiveTypes1) {
			this._boolean1 = @boolean1;
			this._byte1 = @byte1;
			this._char1 = @char1;
			this._short1 = @short1;
			this._int1 = @int1;
			this._long1 = @long1;
			this._float1 = @float1;
			this._double1 = @double1;
			this._string1 = @string1;
			this._primitiveTypes1 = @primitiveTypes1;
		}		
		
		#endregion
		
		#region Properties
		
		public bool[] Boolean1
		{
			get
			{
				return _boolean1;
			}
			set
			{
				this._boolean1 = value;
			}
		}
		
		
		public byte[] Byte1
		{
			get
			{
				return _byte1;
			}
			set
			{
				this._byte1 = value;
			}
		}
		
		
		public char[] Char1
		{
			get
			{
				return _char1;
			}
			set
			{
				this._char1 = value;
			}
		}
		
		
		public short[] Short1
		{
			get
			{
				return _short1;
			}
			set
			{
				this._short1 = value;
			}
		}
		
		
		public int[] Int1
		{
			get
			{
				return _int1;
			}
			set
			{
				this._int1 = value;
			}
		}
		
		
		public long[] Long1
		{
			get
			{
				return _long1;
			}
			set
			{
				this._long1 = value;
			}
		}
		
		
		public float[] Float1
		{
			get
			{
				return _float1;
			}
			set
			{
				this._float1 = value;
			}
		}
		
		
		public double[] Double1
		{
			get
			{
				return _double1;
			}
			set
			{
				this._double1 = value;
			}
		}
		
		
		public String[] String1
		{
			get
			{
				return _string1;
			}
			set
			{
				this._string1 = value;
			}
		}
		
		
		public com.wilutions.byps.test.api.prim.PrimitiveTypes[] PrimitiveTypes1
		{
			get
			{
				return _primitiveTypes1;
			}
			set
			{
				this._primitiveTypes1 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected bool[] _boolean1;

		protected byte[] _byte1;

		protected char[] _char1;

		protected short[] _short1;

		protected int[] _int1;

		protected long[] _long1;

		protected float[] _float1;

		protected double[] _double1;

		protected String[] _string1;

		protected com.wilutions.byps.test.api.prim.PrimitiveTypes[] _primitiveTypes1;

		#endregion
		
		
		public static readonly long serialVersionUID = 2001L;		
	} // end class
}  // end namespace
