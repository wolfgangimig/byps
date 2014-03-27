//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.set
{
	
	public class SetTypes : BSerializable
	{
	
		#region Constructors
		
		public SetTypes() {
		}		
		
		public SetTypes(ISet<bool> @boolean1, HashSet<byte> @byte1, HashSet<char> @char1, ISet<short> @short1, ISet<int> @int1, ISet<long> @long1, ISet<float> @float1, ISet<double> @double1, ISet<String> @string1, ISet<byps.test.api.prim.PrimitiveTypes> @primitiveTypes1, ISet<byte[]> @byte2, ISet<int[]> @int2, ISet<Object> @obj1, ISet<DateTime> @date1) {
			this.boolean1Value = @boolean1;
			this.byte1Value = @byte1;
			this.char1Value = @char1;
			this.short1Value = @short1;
			this.int1Value = @int1;
			this.long1Value = @long1;
			this.float1Value = @float1;
			this.double1Value = @double1;
			this.string1Value = @string1;
			this.primitiveTypes1Value = @primitiveTypes1;
			this.byte2Value = @byte2;
			this.int2Value = @int2;
			this.obj1Value = @obj1;
			this.date1Value = @date1;
		}		
		
		public SetTypes(SetTypes rhs)
		{
			this.boolean1Value = rhs.boolean1Value;
			this.byte1Value = rhs.byte1Value;
			this.char1Value = rhs.char1Value;
			this.short1Value = rhs.short1Value;
			this.int1Value = rhs.int1Value;
			this.long1Value = rhs.long1Value;
			this.float1Value = rhs.float1Value;
			this.double1Value = rhs.double1Value;
			this.string1Value = rhs.string1Value;
			this.primitiveTypes1Value = rhs.primitiveTypes1Value;
			this.byte2Value = rhs.byte2Value;
			this.int2Value = rhs.int2Value;
			this.obj1Value = rhs.obj1Value;
			this.date1Value = rhs.date1Value;
		}		
		
		#endregion
		
		#region Properties
		
		public ISet<bool> Boolean1
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
		
		
		public HashSet<byte> Byte1
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
		
		
		public HashSet<char> Char1
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
		
		
		public ISet<short> Short1
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
		
		
		public ISet<int> Int1
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
		
		
		public ISet<long> Long1
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
		
		
		public ISet<float> Float1
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
		
		
		public ISet<double> Double1
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
		
		
		public ISet<String> String1
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
		
		
		public ISet<byps.test.api.prim.PrimitiveTypes> PrimitiveTypes1
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
		
		
		public ISet<byte[]> Byte2
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
		
		
		public ISet<int[]> Int2
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
		
		
		public ISet<Object> Obj1
		{
			get
			{
				return obj1Value;
			}
			set
			{
				this.obj1Value = value;
			}
		}
		
		
		public ISet<DateTime> Date1
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
		
		
		#endregion
		
		#region Fields
		
		protected ISet<bool> boolean1Value;

		protected HashSet<byte> byte1Value;

		protected HashSet<char> char1Value;

		protected ISet<short> short1Value;

		protected ISet<int> int1Value;

		protected ISet<long> long1Value;

		protected ISet<float> float1Value;

		protected ISet<double> double1Value;

		protected ISet<String> string1Value;

		protected ISet<byps.test.api.prim.PrimitiveTypes> primitiveTypes1Value;

		protected ISet<byte[]> byte2Value;

		protected ISet<int[]> int2Value;

		protected ISet<Object> obj1Value;

		protected ISet<DateTime> date1Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 5001L;		
	} // end class
}  // end namespace
