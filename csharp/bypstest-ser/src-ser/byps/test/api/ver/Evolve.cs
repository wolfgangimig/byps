//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	/// <summary>
	/// Example class with elements that belong to different versions.
	/// </summary>
	public class Evolve : BSerializable
	{
	
		#region Constructors
		
		public Evolve() {
		}		
		
		public Evolve(bool @bool1, byte @byte1, char @char1, short @short1, int @int1, long @long1, float @float1, double @double1, bool[] @bools1, byte[] @bytes1, char[] @chars1, short[] @shorts1, int[] @ints1, long[] @longs1, float[] @floats1, double[] @doubles1, String @str1, Object @obj1, Evolve2 @evo1, IList<int> @list1, ISet<int> @set1, IDictionary<int,int> @map1, bool @bool2, byte @byte2, char @char2, short @short2, int @int2, long @long2, float @float2, double @double2, bool[] @bools2, byte[] @bytes2, char[] @chars2, short[] @shorts2, int[] @ints2, long[] @longs2, float[] @floats2, double[] @doubles2, String @str2, Object @obj2, Evolve2 @evo2, IList<int> @list2, ISet<int> @set2, IDictionary<int,int> @map2, bool @bool3, byte @byte3, char @char3, short @short3, int @int3, long @long3, float @float3, double @double3, bool[] @bools3, byte[] @bytes3, char[] @chars3, short[] @shorts3, int[] @ints3, long[] @longs3, float[] @floats3, double[] @doubles3, String @str3, Object @obj3, Evolve2 @evo3, IList<int> @list3, ISet<int> @set3, IDictionary<int,int> @map3) {
			this.bool1Value = @bool1;
			this.byte1Value = @byte1;
			this.char1Value = @char1;
			this.short1Value = @short1;
			this.int1Value = @int1;
			this.long1Value = @long1;
			this.float1Value = @float1;
			this.double1Value = @double1;
			this.bools1Value = @bools1;
			this.bytes1Value = @bytes1;
			this.chars1Value = @chars1;
			this.shorts1Value = @shorts1;
			this.ints1Value = @ints1;
			this.longs1Value = @longs1;
			this.floats1Value = @floats1;
			this.doubles1Value = @doubles1;
			this.str1Value = @str1;
			this.obj1Value = @obj1;
			this.evo1Value = @evo1;
			this.list1Value = @list1;
			this.set1Value = @set1;
			this.map1Value = @map1;
			this.bool2Value = @bool2;
			this.byte2Value = @byte2;
			this.char2Value = @char2;
			this.short2Value = @short2;
			this.int2Value = @int2;
			this.long2Value = @long2;
			this.float2Value = @float2;
			this.double2Value = @double2;
			this.bools2Value = @bools2;
			this.bytes2Value = @bytes2;
			this.chars2Value = @chars2;
			this.shorts2Value = @shorts2;
			this.ints2Value = @ints2;
			this.longs2Value = @longs2;
			this.floats2Value = @floats2;
			this.doubles2Value = @doubles2;
			this.str2Value = @str2;
			this.obj2Value = @obj2;
			this.evo2Value = @evo2;
			this.list2Value = @list2;
			this.set2Value = @set2;
			this.map2Value = @map2;
			this.bool3Value = @bool3;
			this.byte3Value = @byte3;
			this.char3Value = @char3;
			this.short3Value = @short3;
			this.int3Value = @int3;
			this.long3Value = @long3;
			this.float3Value = @float3;
			this.double3Value = @double3;
			this.bools3Value = @bools3;
			this.bytes3Value = @bytes3;
			this.chars3Value = @chars3;
			this.shorts3Value = @shorts3;
			this.ints3Value = @ints3;
			this.longs3Value = @longs3;
			this.floats3Value = @floats3;
			this.doubles3Value = @doubles3;
			this.str3Value = @str3;
			this.obj3Value = @obj3;
			this.evo3Value = @evo3;
			this.list3Value = @list3;
			this.set3Value = @set3;
			this.map3Value = @map3;
		}		
		
		public Evolve(Evolve rhs)
		{
			this.bool1Value = rhs.bool1Value;
			this.byte1Value = rhs.byte1Value;
			this.char1Value = rhs.char1Value;
			this.short1Value = rhs.short1Value;
			this.int1Value = rhs.int1Value;
			this.long1Value = rhs.long1Value;
			this.float1Value = rhs.float1Value;
			this.double1Value = rhs.double1Value;
			this.bools1Value = rhs.bools1Value;
			this.bytes1Value = rhs.bytes1Value;
			this.chars1Value = rhs.chars1Value;
			this.shorts1Value = rhs.shorts1Value;
			this.ints1Value = rhs.ints1Value;
			this.longs1Value = rhs.longs1Value;
			this.floats1Value = rhs.floats1Value;
			this.doubles1Value = rhs.doubles1Value;
			this.str1Value = rhs.str1Value;
			this.obj1Value = rhs.obj1Value;
			this.evo1Value = rhs.evo1Value;
			this.list1Value = rhs.list1Value;
			this.set1Value = rhs.set1Value;
			this.map1Value = rhs.map1Value;
			this.bool2Value = rhs.bool2Value;
			this.byte2Value = rhs.byte2Value;
			this.char2Value = rhs.char2Value;
			this.short2Value = rhs.short2Value;
			this.int2Value = rhs.int2Value;
			this.long2Value = rhs.long2Value;
			this.float2Value = rhs.float2Value;
			this.double2Value = rhs.double2Value;
			this.bools2Value = rhs.bools2Value;
			this.bytes2Value = rhs.bytes2Value;
			this.chars2Value = rhs.chars2Value;
			this.shorts2Value = rhs.shorts2Value;
			this.ints2Value = rhs.ints2Value;
			this.longs2Value = rhs.longs2Value;
			this.floats2Value = rhs.floats2Value;
			this.doubles2Value = rhs.doubles2Value;
			this.str2Value = rhs.str2Value;
			this.obj2Value = rhs.obj2Value;
			this.evo2Value = rhs.evo2Value;
			this.list2Value = rhs.list2Value;
			this.set2Value = rhs.set2Value;
			this.map2Value = rhs.map2Value;
			this.bool3Value = rhs.bool3Value;
			this.byte3Value = rhs.byte3Value;
			this.char3Value = rhs.char3Value;
			this.short3Value = rhs.short3Value;
			this.int3Value = rhs.int3Value;
			this.long3Value = rhs.long3Value;
			this.float3Value = rhs.float3Value;
			this.double3Value = rhs.double3Value;
			this.bools3Value = rhs.bools3Value;
			this.bytes3Value = rhs.bytes3Value;
			this.chars3Value = rhs.chars3Value;
			this.shorts3Value = rhs.shorts3Value;
			this.ints3Value = rhs.ints3Value;
			this.longs3Value = rhs.longs3Value;
			this.floats3Value = rhs.floats3Value;
			this.doubles3Value = rhs.doubles3Value;
			this.str3Value = rhs.str3Value;
			this.obj3Value = rhs.obj3Value;
			this.evo3Value = rhs.evo3Value;
			this.list3Value = rhs.list3Value;
			this.set3Value = rhs.set3Value;
			this.map3Value = rhs.map3Value;
		}		
		
		#endregion
		
		#region Properties
		
		public bool Bool1
		{
			get
			{
				return bool1Value;
			}
			set
			{
				this.bool1Value = value;
			}
		}
		
		
		public byte Byte1
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
		
		
		public char Char1
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
		
		
		public short Short1
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
		
		
		public int Int1
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
		
		
		public long Long1
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
		
		
		public float Float1
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
		
		
		public double Double1
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
		
		
		public bool[] Bools1
		{
			get
			{
				return bools1Value;
			}
			set
			{
				this.bools1Value = value;
			}
		}
		
		
		public byte[] Bytes1
		{
			get
			{
				return bytes1Value;
			}
			set
			{
				this.bytes1Value = value;
			}
		}
		
		
		public char[] Chars1
		{
			get
			{
				return chars1Value;
			}
			set
			{
				this.chars1Value = value;
			}
		}
		
		
		public short[] Shorts1
		{
			get
			{
				return shorts1Value;
			}
			set
			{
				this.shorts1Value = value;
			}
		}
		
		
		public int[] Ints1
		{
			get
			{
				return ints1Value;
			}
			set
			{
				this.ints1Value = value;
			}
		}
		
		
		public long[] Longs1
		{
			get
			{
				return longs1Value;
			}
			set
			{
				this.longs1Value = value;
			}
		}
		
		
		public float[] Floats1
		{
			get
			{
				return floats1Value;
			}
			set
			{
				this.floats1Value = value;
			}
		}
		
		
		public double[] Doubles1
		{
			get
			{
				return doubles1Value;
			}
			set
			{
				this.doubles1Value = value;
			}
		}
		
		
		public String Str1
		{
			get
			{
				return str1Value;
			}
			set
			{
				this.str1Value = value;
			}
		}
		
		
		public Object Obj1
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
		
		
		public Evolve2 Evo1
		{
			get
			{
				return evo1Value;
			}
			set
			{
				this.evo1Value = value;
			}
		}
		
		
		public IList<int> List1
		{
			get
			{
				return list1Value;
			}
			set
			{
				this.list1Value = value;
			}
		}
		
		
		public ISet<int> Set1
		{
			get
			{
				return set1Value;
			}
			set
			{
				this.set1Value = value;
			}
		}
		
		
		public IDictionary<int,int> Map1
		{
			get
			{
				return map1Value;
			}
			set
			{
				this.map1Value = value;
			}
		}
		
		
		public bool Bool2
		{
			get
			{
				return bool2Value;
			}
			set
			{
				this.bool2Value = value;
			}
		}
		
		
		public byte Byte2
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
		
		
		public char Char2
		{
			get
			{
				return char2Value;
			}
			set
			{
				this.char2Value = value;
			}
		}
		
		
		public short Short2
		{
			get
			{
				return short2Value;
			}
			set
			{
				this.short2Value = value;
			}
		}
		
		
		public int Int2
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
		
		
		public long Long2
		{
			get
			{
				return long2Value;
			}
			set
			{
				this.long2Value = value;
			}
		}
		
		
		public float Float2
		{
			get
			{
				return float2Value;
			}
			set
			{
				this.float2Value = value;
			}
		}
		
		
		public double Double2
		{
			get
			{
				return double2Value;
			}
			set
			{
				this.double2Value = value;
			}
		}
		
		
		public bool[] Bools2
		{
			get
			{
				return bools2Value;
			}
			set
			{
				this.bools2Value = value;
			}
		}
		
		
		public byte[] Bytes2
		{
			get
			{
				return bytes2Value;
			}
			set
			{
				this.bytes2Value = value;
			}
		}
		
		
		public char[] Chars2
		{
			get
			{
				return chars2Value;
			}
			set
			{
				this.chars2Value = value;
			}
		}
		
		
		public short[] Shorts2
		{
			get
			{
				return shorts2Value;
			}
			set
			{
				this.shorts2Value = value;
			}
		}
		
		
		public int[] Ints2
		{
			get
			{
				return ints2Value;
			}
			set
			{
				this.ints2Value = value;
			}
		}
		
		
		public long[] Longs2
		{
			get
			{
				return longs2Value;
			}
			set
			{
				this.longs2Value = value;
			}
		}
		
		
		public float[] Floats2
		{
			get
			{
				return floats2Value;
			}
			set
			{
				this.floats2Value = value;
			}
		}
		
		
		public double[] Doubles2
		{
			get
			{
				return doubles2Value;
			}
			set
			{
				this.doubles2Value = value;
			}
		}
		
		
		public String Str2
		{
			get
			{
				return str2Value;
			}
			set
			{
				this.str2Value = value;
			}
		}
		
		
		public Object Obj2
		{
			get
			{
				return obj2Value;
			}
			set
			{
				this.obj2Value = value;
			}
		}
		
		
		public Evolve2 Evo2
		{
			get
			{
				return evo2Value;
			}
			set
			{
				this.evo2Value = value;
			}
		}
		
		
		public IList<int> List2
		{
			get
			{
				return list2Value;
			}
			set
			{
				this.list2Value = value;
			}
		}
		
		
		public ISet<int> Set2
		{
			get
			{
				return set2Value;
			}
			set
			{
				this.set2Value = value;
			}
		}
		
		
		public IDictionary<int,int> Map2
		{
			get
			{
				return map2Value;
			}
			set
			{
				this.map2Value = value;
			}
		}
		
		
		public bool Bool3
		{
			get
			{
				return bool3Value;
			}
			set
			{
				this.bool3Value = value;
			}
		}
		
		
		public byte Byte3
		{
			get
			{
				return byte3Value;
			}
			set
			{
				this.byte3Value = value;
			}
		}
		
		
		public char Char3
		{
			get
			{
				return char3Value;
			}
			set
			{
				this.char3Value = value;
			}
		}
		
		
		public short Short3
		{
			get
			{
				return short3Value;
			}
			set
			{
				this.short3Value = value;
			}
		}
		
		
		public int Int3
		{
			get
			{
				return int3Value;
			}
			set
			{
				this.int3Value = value;
			}
		}
		
		
		public long Long3
		{
			get
			{
				return long3Value;
			}
			set
			{
				this.long3Value = value;
			}
		}
		
		
		public float Float3
		{
			get
			{
				return float3Value;
			}
			set
			{
				this.float3Value = value;
			}
		}
		
		
		public double Double3
		{
			get
			{
				return double3Value;
			}
			set
			{
				this.double3Value = value;
			}
		}
		
		
		public bool[] Bools3
		{
			get
			{
				return bools3Value;
			}
			set
			{
				this.bools3Value = value;
			}
		}
		
		
		public byte[] Bytes3
		{
			get
			{
				return bytes3Value;
			}
			set
			{
				this.bytes3Value = value;
			}
		}
		
		
		public char[] Chars3
		{
			get
			{
				return chars3Value;
			}
			set
			{
				this.chars3Value = value;
			}
		}
		
		
		public short[] Shorts3
		{
			get
			{
				return shorts3Value;
			}
			set
			{
				this.shorts3Value = value;
			}
		}
		
		
		public int[] Ints3
		{
			get
			{
				return ints3Value;
			}
			set
			{
				this.ints3Value = value;
			}
		}
		
		
		public long[] Longs3
		{
			get
			{
				return longs3Value;
			}
			set
			{
				this.longs3Value = value;
			}
		}
		
		
		public float[] Floats3
		{
			get
			{
				return floats3Value;
			}
			set
			{
				this.floats3Value = value;
			}
		}
		
		
		public double[] Doubles3
		{
			get
			{
				return doubles3Value;
			}
			set
			{
				this.doubles3Value = value;
			}
		}
		
		
		public String Str3
		{
			get
			{
				return str3Value;
			}
			set
			{
				this.str3Value = value;
			}
		}
		
		
		public Object Obj3
		{
			get
			{
				return obj3Value;
			}
			set
			{
				this.obj3Value = value;
			}
		}
		
		
		public Evolve2 Evo3
		{
			get
			{
				return evo3Value;
			}
			set
			{
				this.evo3Value = value;
			}
		}
		
		
		public IList<int> List3
		{
			get
			{
				return list3Value;
			}
			set
			{
				this.list3Value = value;
			}
		}
		
		
		public ISet<int> Set3
		{
			get
			{
				return set3Value;
			}
			set
			{
				this.set3Value = value;
			}
		}
		
		
		public IDictionary<int,int> Map3
		{
			get
			{
				return map3Value;
			}
			set
			{
				this.map3Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected bool bool1Value;

		protected byte byte1Value;

		protected char char1Value;

		protected short short1Value;

		protected int int1Value;

		protected long long1Value;

		protected float float1Value;

		protected double double1Value;

		protected bool[] bools1Value;

		protected byte[] bytes1Value;

		protected char[] chars1Value;

		protected short[] shorts1Value;

		protected int[] ints1Value;

		protected long[] longs1Value;

		protected float[] floats1Value;

		protected double[] doubles1Value;

		protected String str1Value;

		protected Object obj1Value;

		protected Evolve2 evo1Value;

		protected IList<int> list1Value;

		protected ISet<int> set1Value;

		protected IDictionary<int,int> map1Value;

		protected bool bool2Value;

		protected byte byte2Value;

		protected char char2Value;

		protected short short2Value;

		protected int int2Value;

		protected long long2Value;

		protected float float2Value;

		protected double double2Value;

		protected bool[] bools2Value;

		protected byte[] bytes2Value;

		protected char[] chars2Value;

		protected short[] shorts2Value;

		protected int[] ints2Value;

		protected long[] longs2Value;

		protected float[] floats2Value;

		protected double[] doubles2Value;

		protected String str2Value;

		protected Object obj2Value;

		protected Evolve2 evo2Value;

		protected IList<int> list2Value;

		protected ISet<int> set2Value;

		protected IDictionary<int,int> map2Value;

		protected bool bool3Value;

		protected byte byte3Value;

		protected char char3Value;

		protected short short3Value;

		protected int int3Value;

		protected long long3Value;

		protected float float3Value;

		protected double double3Value;

		protected bool[] bools3Value;

		protected byte[] bytes3Value;

		protected char[] chars3Value;

		protected short[] shorts3Value;

		protected int[] ints3Value;

		protected long[] longs3Value;

		protected float[] floats3Value;

		protected double[] doubles3Value;

		protected String str3Value;

		protected Object obj3Value;

		protected Evolve2 evo3Value;

		protected IList<int> list3Value;

		protected ISet<int> set3Value;

		protected IDictionary<int,int> map3Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 1391985860L;		
	} // end class
}  // end namespace
