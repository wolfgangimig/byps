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
			this._boolean4 = @boolean4;
			this._byte4 = @byte4;
			this._char4 = @char4;
			this._short4 = @short4;
			this._int4 = @int4;
			this._long4 = @long4;
			this._float4 = @float4;
			this._double4 = @double4;
			this._string4 = @string4;
			this._primitiveTypes4 = @primitiveTypes4;
		}		
		
		#endregion
		
		#region Properties
		
		public bool[,,,] Boolean4
		{
			get
			{
				return _boolean4;
			}
			set
			{
				this._boolean4 = value;
			}
		}
		
		
		public byte[,,,] Byte4
		{
			get
			{
				return _byte4;
			}
			set
			{
				this._byte4 = value;
			}
		}
		
		
		public char[,,,] Char4
		{
			get
			{
				return _char4;
			}
			set
			{
				this._char4 = value;
			}
		}
		
		
		public short[,,,] Short4
		{
			get
			{
				return _short4;
			}
			set
			{
				this._short4 = value;
			}
		}
		
		
		public int[,,,] Int4
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
		
		
		public long[,,,] Long4
		{
			get
			{
				return _long4;
			}
			set
			{
				this._long4 = value;
			}
		}
		
		
		public float[,,,] Float4
		{
			get
			{
				return _float4;
			}
			set
			{
				this._float4 = value;
			}
		}
		
		
		public double[,,,] Double4
		{
			get
			{
				return _double4;
			}
			set
			{
				this._double4 = value;
			}
		}
		
		
		public String[,,,] String4
		{
			get
			{
				return _string4;
			}
			set
			{
				this._string4 = value;
			}
		}
		
		
		public byps.test.api.prim.PrimitiveTypes[,,,] PrimitiveTypes4
		{
			get
			{
				return _primitiveTypes4;
			}
			set
			{
				this._primitiveTypes4 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected bool[,,,] _boolean4;

		protected byte[,,,] _byte4;

		protected char[,,,] _char4;

		protected short[,,,] _short4;

		protected int[,,,] _int4;

		protected long[,,,] _long4;

		protected float[,,,] _float4;

		protected double[,,,] _double4;

		protected String[,,,] _string4;

		protected byps.test.api.prim.PrimitiveTypes[,,,] _primitiveTypes4;

		#endregion
		
		
		public static readonly long serialVersionUID = 2004L;		
	} // end class
}  // end namespace
