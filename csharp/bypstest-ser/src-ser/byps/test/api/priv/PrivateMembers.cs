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
		
		internal PrivateMembers(bool @boolVal, byte @byteVal, char @charVal, short @shortVal, int @intVal, long @longVal, float @floatVal, double @doubleVal, String @stringVal, byps.test.api.prim.PrimitiveTypes @primitiveTypes, bool[] @arrBool, int[] @arrInt, String[] @arrString, byps.test.api.prim.PrimitiveTypes[] @arrPrimitiveTypes, IList<bool> @listBool, IList<int> @listInt, IList<String> @listString, IList<byps.test.api.prim.PrimitiveTypes> @listPrimitiveTypes, IDictionary<int,IList<String>> @mapIntListString, int @protInt, int @pprotInt) {
			this._boolVal = @boolVal;
			this._byteVal = @byteVal;
			this._charVal = @charVal;
			this._shortVal = @shortVal;
			this._intVal = @intVal;
			this._longVal = @longVal;
			this._floatVal = @floatVal;
			this._doubleVal = @doubleVal;
			this._stringVal = @stringVal;
			this._primitiveTypes = @primitiveTypes;
			this._arrBool = @arrBool;
			this._arrInt = @arrInt;
			this._arrString = @arrString;
			this._arrPrimitiveTypes = @arrPrimitiveTypes;
			this._listBool = @listBool;
			this._listInt = @listInt;
			this._listString = @listString;
			this._listPrimitiveTypes = @listPrimitiveTypes;
			this._mapIntListString = @mapIntListString;
			this._protInt = @protInt;
			this._pprotInt = @pprotInt;
		}		
		
		#endregion
		
		#region Properties
		
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
		
		
		public byps.test.api.prim.PrimitiveTypes PrimitiveTypes
		{
			get
			{
				return _primitiveTypes;
			}
			set
			{
				this._primitiveTypes = value;
			}
		}
		
		
		public bool[] ArrBool
		{
			get
			{
				return _arrBool;
			}
			set
			{
				this._arrBool = value;
			}
		}
		
		
		public int[] ArrInt
		{
			get
			{
				return _arrInt;
			}
			set
			{
				this._arrInt = value;
			}
		}
		
		
		public String[] ArrString
		{
			get
			{
				return _arrString;
			}
			set
			{
				this._arrString = value;
			}
		}
		
		
		public byps.test.api.prim.PrimitiveTypes[] ArrPrimitiveTypes
		{
			get
			{
				return _arrPrimitiveTypes;
			}
			set
			{
				this._arrPrimitiveTypes = value;
			}
		}
		
		
		public IList<bool> ListBool
		{
			get
			{
				return _listBool;
			}
			set
			{
				this._listBool = value;
			}
		}
		
		
		public IList<int> ListInt
		{
			get
			{
				return _listInt;
			}
			set
			{
				this._listInt = value;
			}
		}
		
		
		public IList<String> ListString
		{
			get
			{
				return _listString;
			}
			set
			{
				this._listString = value;
			}
		}
		
		
		public IList<byps.test.api.prim.PrimitiveTypes> ListPrimitiveTypes
		{
			get
			{
				return _listPrimitiveTypes;
			}
			set
			{
				this._listPrimitiveTypes = value;
			}
		}
		
		
		public IDictionary<int,IList<String>> MapIntListString
		{
			get
			{
				return _mapIntListString;
			}
			set
			{
				this._mapIntListString = value;
			}
		}
		
		
		public int ProtInt
		{
			get
			{
				return _protInt;
			}
			set
			{
				this._protInt = value;
			}
		}
		
		
		public int PprotInt
		{
			get
			{
				return _pprotInt;
			}
			set
			{
				this._pprotInt = value;
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

		protected byps.test.api.prim.PrimitiveTypes _primitiveTypes;

		protected bool[] _arrBool;

		protected int[] _arrInt;

		protected String[] _arrString;

		protected byps.test.api.prim.PrimitiveTypes[] _arrPrimitiveTypes;

		protected IList<bool> _listBool;

		protected IList<int> _listInt;

		protected IList<String> _listString;

		protected IList<byps.test.api.prim.PrimitiveTypes> _listPrimitiveTypes;

		protected IDictionary<int,IList<String>> _mapIntListString;

		protected int _protInt;

		protected int _pprotInt;

		#endregion
		
		
		public static readonly long serialVersionUID = 8001L;		
	} // end class
}  // end namespace
