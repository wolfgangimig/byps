//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.arr
{
	
	public class ArrayTypes4dim : BSerializable
	{
	
		#region Constructors
		
		public ArrayTypes4dim() {
		}		
		
		internal ArrayTypes4dim(bool[,,,] @boolean4, byte[,,,] @byte4, char[,,,] @char4, short[,,,] @short4, int[,,,] @int4, long[,,,] @long4, float[,,,] @float4, double[,,,] @double4, String[,,,] @string4, byps.test.api.prim.PrimitiveTypes[,,,] @primitiveTypes4) {
			this.boolean4Value = @boolean4;
			this.byte4Value = @byte4;
			this.char4Value = @char4;
			this.short4Value = @short4;
			this.int4Value = @int4;
			this.long4Value = @long4;
			this.float4Value = @float4;
			this.double4Value = @double4;
			this.string4Value = @string4;
			this.primitiveTypes4Value = @primitiveTypes4;
		}		
		
		#endregion
		
		#region Properties
		
		public bool[,,,] Boolean4
		{
			get
			{
				return boolean4Value;
			}
			set
			{
				this.boolean4Value = value;
			}
		}
		
		
		public byte[,,,] Byte4
		{
			get
			{
				return byte4Value;
			}
			set
			{
				this.byte4Value = value;
			}
		}
		
		
		public char[,,,] Char4
		{
			get
			{
				return char4Value;
			}
			set
			{
				this.char4Value = value;
			}
		}
		
		
		public short[,,,] Short4
		{
			get
			{
				return short4Value;
			}
			set
			{
				this.short4Value = value;
			}
		}
		
		
		public int[,,,] Int4
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
		
		
		public long[,,,] Long4
		{
			get
			{
				return long4Value;
			}
			set
			{
				this.long4Value = value;
			}
		}
		
		
		public float[,,,] Float4
		{
			get
			{
				return float4Value;
			}
			set
			{
				this.float4Value = value;
			}
		}
		
		
		public double[,,,] Double4
		{
			get
			{
				return double4Value;
			}
			set
			{
				this.double4Value = value;
			}
		}
		
		
		public String[,,,] String4
		{
			get
			{
				return string4Value;
			}
			set
			{
				this.string4Value = value;
			}
		}
		
		
		public byps.test.api.prim.PrimitiveTypes[,,,] PrimitiveTypes4
		{
			get
			{
				return primitiveTypes4Value;
			}
			set
			{
				this.primitiveTypes4Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected bool[,,,] boolean4Value;

		protected byte[,,,] byte4Value;

		protected char[,,,] char4Value;

		protected short[,,,] short4Value;

		protected int[,,,] int4Value;

		protected long[,,,] long4Value;

		protected float[,,,] float4Value;

		protected double[,,,] double4Value;

		protected String[,,,] string4Value;

		protected byps.test.api.prim.PrimitiveTypes[,,,] primitiveTypes4Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 2004L;		
	} // end class
}  // end namespace
