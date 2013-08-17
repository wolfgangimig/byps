//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.map
{
	
	public class MapTypes : BSerializable
	{
	
		#region Constructors
		
		public MapTypes() {
		}		
		
		internal MapTypes(IDictionary<String,bool> @boolean1, Dictionary<double,byte> @byte1, Dictionary<float,char> @char1, IDictionary<long,short> @short1, IDictionary<int,int> @int1, IDictionary<short,long> @long1, IDictionary<char,float> @float1, IDictionary<byte,double> @double1, IDictionary<String,String> @string1, IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> @primitiveTypes1, IDictionary<int,byte[]> @byte2, IDictionary<int,int[]> @int2, IDictionary<String,Object> @obj1) {
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
			this._byte2 = @byte2;
			this._int2 = @int2;
			this._obj1 = @obj1;
		}		
		
		#endregion
		
		#region Properties
		
		public IDictionary<String,bool> Boolean1
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
		
		
		public Dictionary<double,byte> Byte1
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
		
		
		public Dictionary<float,char> Char1
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
		
		
		public IDictionary<long,short> Short1
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
		
		
		public IDictionary<int,int> Int1
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
		
		
		public IDictionary<short,long> Long1
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
		
		
		public IDictionary<char,float> Float1
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
		
		
		public IDictionary<byte,double> Double1
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
		
		
		public IDictionary<String,String> String1
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
		
		
		public IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> PrimitiveTypes1
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
		
		
		public IDictionary<int,byte[]> Byte2
		{
			get
			{
				return _byte2;
			}
			set
			{
				this._byte2 = value;
			}
		}
		
		
		public IDictionary<int,int[]> Int2
		{
			get
			{
				return _int2;
			}
			set
			{
				this._int2 = value;
			}
		}
		
		
		public IDictionary<String,Object> Obj1
		{
			get
			{
				return _obj1;
			}
			set
			{
				this._obj1 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected IDictionary<String,bool> _boolean1;

		protected Dictionary<double,byte> _byte1;

		protected Dictionary<float,char> _char1;

		protected IDictionary<long,short> _short1;

		protected IDictionary<int,int> _int1;

		protected IDictionary<short,long> _long1;

		protected IDictionary<char,float> _float1;

		protected IDictionary<byte,double> _double1;

		protected IDictionary<String,String> _string1;

		protected IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> _primitiveTypes1;

		protected IDictionary<int,byte[]> _byte2;

		protected IDictionary<int,int[]> _int2;

		protected IDictionary<String,Object> _obj1;

		#endregion
		
		
		public static readonly long serialVersionUID = 4001L;		
	} // end class
}  // end namespace
