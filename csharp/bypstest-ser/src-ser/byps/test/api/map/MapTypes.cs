//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.map
{
	
	public class MapTypes : BSerializable
	{
	
		#region Constructors
		
		public MapTypes() {
		}		
		
		public MapTypes(IDictionary<String,bool> @boolean1, Dictionary<double,byte> @byte1, Dictionary<float,char> @char1, IDictionary<long,short> @short1, IDictionary<int,int> @int1, IDictionary<short,long> @long1, IDictionary<char,float> @float1, IDictionary<byte,double> @double1, IDictionary<String,String> @string1, IDictionary<int,byps.test.api.prim.PrimitiveTypes> @primitiveTypes1, IDictionary<int,byte[]> @byte2, IDictionary<int,int[]> @int2, IDictionary<String,Object> @obj1, IDictionary<String,DateTime> @date1) {
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
		
		public MapTypes(MapTypes rhs)
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
		
		public IDictionary<String,bool> Boolean1
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
		
		
		public Dictionary<double,byte> Byte1
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
		
		
		public Dictionary<float,char> Char1
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
		
		
		public IDictionary<long,short> Short1
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
		
		
		public IDictionary<int,int> Int1
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
		
		
		public IDictionary<short,long> Long1
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
		
		
		public IDictionary<char,float> Float1
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
		
		
		public IDictionary<byte,double> Double1
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
		
		
		public IDictionary<String,String> String1
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
		
		
		public IDictionary<int,byps.test.api.prim.PrimitiveTypes> PrimitiveTypes1
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
		
		
		public IDictionary<int,byte[]> Byte2
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
		
		
		public IDictionary<int,int[]> Int2
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
		
		
		public IDictionary<String,Object> Obj1
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
		
		
		public IDictionary<String,DateTime> Date1
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
		
		protected IDictionary<String,bool> boolean1Value;

		protected Dictionary<double,byte> byte1Value;

		protected Dictionary<float,char> char1Value;

		protected IDictionary<long,short> short1Value;

		protected IDictionary<int,int> int1Value;

		protected IDictionary<short,long> long1Value;

		protected IDictionary<char,float> float1Value;

		protected IDictionary<byte,double> double1Value;

		protected IDictionary<String,String> string1Value;

		protected IDictionary<int,byps.test.api.prim.PrimitiveTypes> primitiveTypes1Value;

		protected IDictionary<int,byte[]> byte2Value;

		protected IDictionary<int,int[]> int2Value;

		protected IDictionary<String,Object> obj1Value;

		protected IDictionary<String,DateTime> date1Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 4001L;		
	} // end class
}  // end namespace
