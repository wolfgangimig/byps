﻿//
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
	public class PrimitiveTypes : BValueClass, BSerializable
	{
	
		#region Constructors
		
		public PrimitiveTypes() {
		}		
		
		public PrimitiveTypes(bool @boolVal, byte @byteVal, char @charVal, short @shortVal, int @intVal, long @longVal, float @floatVal, double @doubleVal, String @stringVal, DateTime @dateVal, Object @objVal, Object @objVal2, bool @value, Object @temp, int @deferredValue) {
			this.boolValValue = @boolVal;
			this.byteValValue = @byteVal;
			this.charValValue = @charVal;
			this.shortValValue = @shortVal;
			this.intValValue = @intVal;
			this.longValValue = @longVal;
			this.floatValValue = @floatVal;
			this.doubleValValue = @doubleVal;
			this.stringValValue = @stringVal;
			this.dateValValue = @dateVal;
			this.objValValue = @objVal;
			this.objVal2Value = @objVal2;
			this.valueValue = @value;
			this.tempValue = @temp;
			this.deferredValueValue = @deferredValue;
		}		
		
		public PrimitiveTypes(PrimitiveTypes rhs) : base(rhs)
		{
			this.boolValValue = rhs.boolValValue;
			this.byteValValue = rhs.byteValValue;
			this.charValValue = rhs.charValValue;
			this.shortValValue = rhs.shortValValue;
			this.intValValue = rhs.intValValue;
			this.longValValue = rhs.longValValue;
			this.floatValValue = rhs.floatValValue;
			this.doubleValValue = rhs.doubleValValue;
			this.stringValValue = rhs.stringValValue;
			this.dateValValue = rhs.dateValValue;
			this.objValValue = rhs.objValValue;
			this.objVal2Value = rhs.objVal2Value;
			this.valueValue = rhs.valueValue;
			this.tempValue = rhs.tempValue;
			this.deferredValueValue = rhs.deferredValueValue;
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
				return boolValValue;
			}
			set
			{
				this.boolValValue = value;
			}
		}
		
		
		/// <summary>
		/// One byte.
		/// </summary>
		public byte ByteVal
		{
			get
			{
				return byteValValue;
			}
			set
			{
				this.byteValValue = value;
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
				return charValValue;
			}
			set
			{
				this.charValValue = value;
			}
		}
		
		
		public short ShortVal
		{
			get
			{
				return shortValValue;
			}
			set
			{
				this.shortValValue = value;
			}
		}
		
		
		public int IntVal
		{
			get
			{
				return intValValue;
			}
			set
			{
				this.intValValue = value;
			}
		}
		
		
		public long LongVal
		{
			get
			{
				return longValValue;
			}
			set
			{
				this.longValValue = value;
			}
		}
		
		
		public float FloatVal
		{
			get
			{
				return floatValValue;
			}
			set
			{
				this.floatValValue = value;
			}
		}
		
		
		public double DoubleVal
		{
			get
			{
				return doubleValValue;
			}
			set
			{
				this.doubleValValue = value;
			}
		}
		
		
		public String StringVal
		{
			get
			{
				return stringValValue;
			}
			set
			{
				this.stringValValue = value;
			}
		}
		
		
		public DateTime DateVal
		{
			get
			{
				return dateValValue;
			}
			set
			{
				this.dateValValue = value;
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
				return objValValue;
			}
			set
			{
				this.objValValue = value;
			}
		}
		
		
		public Object ObjVal2
		{
			get
			{
				return objVal2Value;
			}
			set
			{
				this.objVal2Value = value;
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
				return valueValue;
			}
			set
			{
				this.valueValue = value;
			}
		}
		
		
		public Object Temp
		{
			get
			{
				return tempValue;
			}
			set
			{
				this.tempValue = value;
			}
		}
		
		
		/// <summary>
		/// This value is read in its getter function.
		/// </summary>
		public int DeferredValue
		{
			get
			{
				return deferredValueValue;
			}
			set
			{
				this.deferredValueValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected bool boolValValue;

		protected byte byteValValue;

		protected char charValValue;

		protected short shortValValue;

		protected int intValValue;

		protected long longValValue;

		protected float floatValValue;

		protected double doubleValValue;

		protected String stringValValue;

		protected DateTime dateValValue;

		protected Object objValValue;

		protected Object objVal2Value;

		protected bool valueValue;

		protected Object tempValue; // transient

		protected int deferredValueValue;

		#endregion
		
		
		public static readonly new long serialVersionUID = 1000L;		
	} // end class
}  // end namespace
