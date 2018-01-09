//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.list
{
	
	public class ListTypes : BSerializable
	{
	
		#region Constructors
		
		public ListTypes() {
		}		
		
		public ListTypes(IList<bool> @boolean1, IList<byte> @byte1, IList<char> @char1, IList<short> @short1, IList<int> @int1, IList<long> @long1, IList<float> @float1, IList<double> @double1, IList<String> @string1, IList<DateTime> @date1, IList<byps.test.api.prim.PrimitiveTypes> @primitiveTypes1, IList<byte[]> @byte2, IList<int[]> @int2, IList<int[,,,]> @int4, IList<Object> @obj1) {
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
			this.byte2Value = @byte2;
			this.int2Value = @int2;
			this.int4Value = @int4;
			this.obj1Value = @obj1;
		}		
		
		public ListTypes(ListTypes rhs)
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
			this.date1Value = rhs.date1Value;
			this.primitiveTypes1Value = rhs.primitiveTypes1Value;
			this.byte2Value = rhs.byte2Value;
			this.int2Value = rhs.int2Value;
			this.int4Value = rhs.int4Value;
			this.obj1Value = rhs.obj1Value;
		}		
		
		#endregion
		
		#region Properties
		
		public IList<bool> Boolean1
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
		
		
		public IList<byte> Byte1
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
		
		
		public IList<char> Char1
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
		
		
		public IList<short> Short1
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
		
		
		public IList<int> Int1
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
		
		
		public IList<long> Long1
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
		
		
		public IList<float> Float1
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
		
		
		public IList<double> Double1
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
		
		
		public IList<String> String1
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
		
		
		public IList<DateTime> Date1
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
		
		
		public IList<byps.test.api.prim.PrimitiveTypes> PrimitiveTypes1
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
		
		
		public IList<byte[]> Byte2
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
		
		
		public IList<int[]> Int2
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
		
		
		public IList<int[,,,]> Int4
		{
			get
			{
				return int4Value;
			}
			set
			{
				this.int4Value = value;
			}
		}
		
		
		public IList<Object> Obj1
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
		
		
		#endregion
		
		#region Fields
		
		protected IList<bool> boolean1Value;

		protected IList<byte> byte1Value;

		protected IList<char> char1Value;

		protected IList<short> short1Value;

		protected IList<int> int1Value;

		protected IList<long> long1Value;

		protected IList<float> float1Value;

		protected IList<double> double1Value;

		protected IList<String> string1Value;

		protected IList<DateTime> date1Value;

		protected IList<byps.test.api.prim.PrimitiveTypes> primitiveTypes1Value;

		protected IList<byte[]> byte2Value;

		protected IList<int[]> int2Value;

		protected IList<int[,,,]> int4Value;

		protected IList<Object> obj1Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 3001L;		
	} // end class
}  // end namespace
