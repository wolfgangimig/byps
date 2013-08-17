//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.list
{
	
	public class ListTypes : BSerializable
	{
	
		#region Constructors
		
		public ListTypes() {
		}		
		
		internal ListTypes(IList<bool> @boolean1, IList<byte> @byte1, IList<char> @char1, IList<short> @short1, IList<int> @int1, IList<long> @long1, IList<float> @float1, IList<double> @double1, IList<String> @string1, IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> @primitiveTypes1, IList<byte[]> @byte2, IList<int[]> @int2, IList<int[,,,]> @int4, IList<Object> @obj1) {
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
			this._int4 = @int4;
			this._obj1 = @obj1;
		}		
		
		#endregion
		
		#region Properties
		
		public IList<bool> Boolean1
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
		
		
		public IList<byte> Byte1
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
		
		
		public IList<char> Char1
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
		
		
		public IList<short> Short1
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
		
		
		public IList<int> Int1
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
		
		
		public IList<long> Long1
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
		
		
		public IList<float> Float1
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
		
		
		public IList<double> Double1
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
		
		
		public IList<String> String1
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
		
		
		public IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> PrimitiveTypes1
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
		
		
		public IList<byte[]> Byte2
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
		
		
		public IList<int[]> Int2
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
		
		
		public IList<int[,,,]> Int4
		{
			get
			{
				return _int4;
			}
			set
			{
				this._int4 = value;
			}
		}
		
		
		public IList<Object> Obj1
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
		
		protected IList<bool> _boolean1;

		protected IList<byte> _byte1;

		protected IList<char> _char1;

		protected IList<short> _short1;

		protected IList<int> _int1;

		protected IList<long> _long1;

		protected IList<float> _float1;

		protected IList<double> _double1;

		protected IList<String> _string1;

		protected IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> _primitiveTypes1;

		protected IList<byte[]> _byte2;

		protected IList<int[]> _int2;

		protected IList<int[,,,]> _int4;

		protected IList<Object> _obj1;

		#endregion
		
		
		public static readonly long serialVersionUID = 3001L;		
	} // end class
}  // end namespace
