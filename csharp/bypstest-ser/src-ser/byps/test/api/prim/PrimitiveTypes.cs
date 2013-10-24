//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.prim
{
	
	/// <summary>
	/// Example class with primitive types like boolean, int, String.
	/// </summary>
	public class PrimitiveTypes : BSerializable
	{
	
		#region Constructors
		
		public PrimitiveTypes() {
		}		
		
		internal PrimitiveTypes(bool @boolVal, byte @byteVal, char @charVal, short @shortVal, int @intVal, long @longVal, float @floatVal, double @doubleVal, String @stringVal, Object @objVal, Object @objVal2, bool @value, Object @temp) {
			this._boolVal = @boolVal;
			this._byteVal = @byteVal;
			this._charVal = @charVal;
			this._shortVal = @shortVal;
			this._intVal = @intVal;
			this._longVal = @longVal;
			this._floatVal = @floatVal;
			this._doubleVal = @doubleVal;
			this._stringVal = @stringVal;
			this._objVal = @objVal;
			this._objVal2 = @objVal2;
			this._value = @value;
			this._temp = @temp;
		}		
		
		#endregion
		
		#region Properties
		
		/// <summary>
		/// Boolean value.
		/// </summary>
		/// <remarks>
		/// Serialized as one byte with value 1 for true and value 0 for false.
		/// </remarks>
		public bool BoolVal
		{
			get
			{
				return _boolVal;
			}
			set
			{
				this._boolVal = value;
			}
		}
		
		
		/// <summary>
		/// One byte.
		/// </summary>
		public byte ByteVal
		{
			get
			{
				return _byteVal;
			}
			set
			{
				this._byteVal = value;
			}
		}
		
		
		/// <summary>
		/// One wide (2 byte) character.
		/// </summary>
		/// <remarks>
		/// Serialized as short integer in binary serialization and as string when serializing in JSON format.
		/// </remarks>
		public char CharVal
		{
			get
			{
				return _charVal;
			}
			set
			{
				this._charVal = value;
			}
		}
		
		
		public short ShortVal
		{
			get
			{
				return _shortVal;
			}
			set
			{
				this._shortVal = value;
			}
		}
		
		
		public int IntVal
		{
			get
			{
				return _intVal;
			}
			set
			{
				this._intVal = value;
			}
		}
		
		
		public long LongVal
		{
			get
			{
				return _longVal;
			}
			set
			{
				this._longVal = value;
			}
		}
		
		
		public float FloatVal
		{
			get
			{
				return _floatVal;
			}
			set
			{
				this._floatVal = value;
			}
		}
		
		
		public double DoubleVal
		{
			get
			{
				return _doubleVal;
			}
			set
			{
				this._doubleVal = value;
			}
		}
		
		
		public String StringVal
		{
			get
			{
				return _stringVal;
			}
			set
			{
				this._stringVal = value;
			}
		}
		
		
		/// <summary>
		/// This element can refer a an arbitrary type that implements Serializable.
		/// </summary>
		/// <remarks>
		/// It cannot hold an array, List, ArrayList, etc.
		/// </remarks>
		public Object ObjVal
		{
			get
			{
				return _objVal;
			}
			set
			{
				this._objVal = value;
			}
		}
		
		
		public Object ObjVal2
		{
			get
			{
				return _objVal2;
			}
			set
			{
				this._objVal2 = value;
			}
		}
		
		
		/// <summary>
		/// In CSharp, value is a keyword in property setter functions.
		/// </summary>
		/// <remarks>
		/// But it must not be a problem to name a member by value.
		/// </remarks>
		public bool Value
		{
			get
			{
				return _value;
			}
			set
			{
				this._value = value;
			}
		}
		
		
		public Object Temp
		{
			get
			{
				return _temp;
			}
			set
			{
				this._temp = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected bool _boolVal;

		protected byte _byteVal;

		protected char _charVal;

		protected short _shortVal;

		protected int _intVal;

		protected long _longVal;

		protected float _floatVal;

		protected double _doubleVal;

		protected String _stringVal;

		protected Object _objVal;

		protected Object _objVal2;

		protected bool _value;

		protected Object _temp; // transient

		#endregion
		
		
		public static readonly long serialVersionUID = 1000L;		
	} // end class
}  // end namespace
