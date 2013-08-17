//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.set
{
	
	public class SetTypes : BSerializable
	{
	
		#region Constructors
		
		public SetTypes() {
		}		
		
		internal SetTypes(ISet<bool> @boolean1, HashSet<byte> @byte1, HashSet<char> @char1, ISet<short> @short1, ISet<int> @int1, ISet<long> @long1, ISet<float> @float1, ISet<double> @double1, ISet<String> @string1, ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> @primitiveTypes1, ISet<byte[]> @byte2, ISet<int[]> @int2, ISet<Object> @obj1) {
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
		
		public ISet<bool> Boolean1
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
		
		
		public HashSet<byte> Byte1
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
		
		
		public HashSet<char> Char1
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
		
		
		public ISet<short> Short1
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
		
		
		public ISet<int> Int1
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
		
		
		public ISet<long> Long1
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
		
		
		public ISet<float> Float1
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
		
		
		public ISet<double> Double1
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
		
		
		public ISet<String> String1
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
		
		
		public ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> PrimitiveTypes1
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
		
		
		public ISet<byte[]> Byte2
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
		
		
		public ISet<int[]> Int2
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
		
		
		public ISet<Object> Obj1
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
		
		protected ISet<bool> _boolean1;

		protected HashSet<byte> _byte1;

		protected HashSet<char> _char1;

		protected ISet<short> _short1;

		protected ISet<int> _int1;

		protected ISet<long> _long1;

		protected ISet<float> _float1;

		protected ISet<double> _double1;

		protected ISet<String> _string1;

		protected ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> _primitiveTypes1;

		protected ISet<byte[]> _byte2;

		protected ISet<int[]> _int2;

		protected ISet<Object> _obj1;

		#endregion
		
		
		public static readonly long serialVersionUID = 5001L;		
	} // end class
}  // end namespace
