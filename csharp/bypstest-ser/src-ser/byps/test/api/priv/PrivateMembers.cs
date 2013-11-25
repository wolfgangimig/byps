//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.priv
{
	
	/// <summary>
	/// Example class with private and protected members
	/// </summary>
	public class PrivateMembers : BSerializable
	{
	
		#region Constructors
		
		public PrivateMembers() {
		}		
		
		public PrivateMembers(bool @boolVal, byte @byteVal, char @charVal, short @shortVal, int @intVal, long @longVal, float @floatVal, double @doubleVal, String @stringVal, byps.test.api.prim.PrimitiveTypes @primitiveTypes, bool[] @arrBool, int[] @arrInt, String[] @arrString, byps.test.api.prim.PrimitiveTypes[] @arrPrimitiveTypes, IList<bool> @listBool, IList<int> @listInt, IList<String> @listString, IList<byps.test.api.prim.PrimitiveTypes> @listPrimitiveTypes, IDictionary<int,IList<String>> @mapIntListString, int @protInt, int @pprotInt) {
			this.boolValValue = @boolVal;
			this.byteValValue = @byteVal;
			this.charValValue = @charVal;
			this.shortValValue = @shortVal;
			this.intValValue = @intVal;
			this.longValValue = @longVal;
			this.floatValValue = @floatVal;
			this.doubleValValue = @doubleVal;
			this.stringValValue = @stringVal;
			this.primitiveTypesValue = @primitiveTypes;
			this.arrBoolValue = @arrBool;
			this.arrIntValue = @arrInt;
			this.arrStringValue = @arrString;
			this.arrPrimitiveTypesValue = @arrPrimitiveTypes;
			this.listBoolValue = @listBool;
			this.listIntValue = @listInt;
			this.listStringValue = @listString;
			this.listPrimitiveTypesValue = @listPrimitiveTypes;
			this.mapIntListStringValue = @mapIntListString;
			this.protIntValue = @protInt;
			this.pprotIntValue = @pprotInt;
		}		
		
		public PrivateMembers(PrivateMembers rhs)
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
			this.primitiveTypesValue = rhs.primitiveTypesValue;
			this.arrBoolValue = rhs.arrBoolValue;
			this.arrIntValue = rhs.arrIntValue;
			this.arrStringValue = rhs.arrStringValue;
			this.arrPrimitiveTypesValue = rhs.arrPrimitiveTypesValue;
			this.listBoolValue = rhs.listBoolValue;
			this.listIntValue = rhs.listIntValue;
			this.listStringValue = rhs.listStringValue;
			this.listPrimitiveTypesValue = rhs.listPrimitiveTypesValue;
			this.mapIntListStringValue = rhs.mapIntListStringValue;
			this.protIntValue = rhs.protIntValue;
			this.pprotIntValue = rhs.pprotIntValue;
		}		
		
		#endregion
		
		#region Properties
		
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
		
		
		public byps.test.api.prim.PrimitiveTypes PrimitiveTypes
		{
			get
			{
				return primitiveTypesValue;
			}
			set
			{
				this.primitiveTypesValue = value;
			}
		}
		
		
		public bool[] ArrBool
		{
			get
			{
				return arrBoolValue;
			}
			set
			{
				this.arrBoolValue = value;
			}
		}
		
		
		public int[] ArrInt
		{
			get
			{
				return arrIntValue;
			}
			set
			{
				this.arrIntValue = value;
			}
		}
		
		
		public String[] ArrString
		{
			get
			{
				return arrStringValue;
			}
			set
			{
				this.arrStringValue = value;
			}
		}
		
		
		public byps.test.api.prim.PrimitiveTypes[] ArrPrimitiveTypes
		{
			get
			{
				return arrPrimitiveTypesValue;
			}
			set
			{
				this.arrPrimitiveTypesValue = value;
			}
		}
		
		
		public IList<bool> ListBool
		{
			get
			{
				return listBoolValue;
			}
			set
			{
				this.listBoolValue = value;
			}
		}
		
		
		public IList<int> ListInt
		{
			get
			{
				return listIntValue;
			}
			set
			{
				this.listIntValue = value;
			}
		}
		
		
		public IList<String> ListString
		{
			get
			{
				return listStringValue;
			}
			set
			{
				this.listStringValue = value;
			}
		}
		
		
		public IList<byps.test.api.prim.PrimitiveTypes> ListPrimitiveTypes
		{
			get
			{
				return listPrimitiveTypesValue;
			}
			set
			{
				this.listPrimitiveTypesValue = value;
			}
		}
		
		
		public IDictionary<int,IList<String>> MapIntListString
		{
			get
			{
				return mapIntListStringValue;
			}
			set
			{
				this.mapIntListStringValue = value;
			}
		}
		
		
		public int ProtInt
		{
			get
			{
				return protIntValue;
			}
			set
			{
				this.protIntValue = value;
			}
		}
		
		
		public int PprotInt
		{
			get
			{
				return pprotIntValue;
			}
			set
			{
				this.pprotIntValue = value;
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

		protected byps.test.api.prim.PrimitiveTypes primitiveTypesValue;

		protected bool[] arrBoolValue;

		protected int[] arrIntValue;

		protected String[] arrStringValue;

		protected byps.test.api.prim.PrimitiveTypes[] arrPrimitiveTypesValue;

		protected IList<bool> listBoolValue;

		protected IList<int> listIntValue;

		protected IList<String> listStringValue;

		protected IList<byps.test.api.prim.PrimitiveTypes> listPrimitiveTypesValue;

		protected IDictionary<int,IList<String>> mapIntListStringValue;

		protected int protIntValue;

		protected int pprotIntValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 8001L;		
	} // end class
}  // end namespace
