//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inl
{
	
	public sealed class Matrix2D : BSerializable
	{
	
		#region Constructors
		
		public Matrix2D() {
		}		
		
		internal Matrix2D(float @_11, float @_12, float @_13, float @_21, float @_22, float @_23, float @_31, float @_32, float @_33) {
			this._11Value = @_11;
			this._12Value = @_12;
			this._13Value = @_13;
			this._21Value = @_21;
			this._22Value = @_22;
			this._23Value = @_23;
			this._31Value = @_31;
			this._32Value = @_32;
			this._33Value = @_33;
		}		
		
		#endregion
		
		#region Properties
		
		public float _11
		{
			get
			{
				return _11Value;
			}
			set
			{
				this._11Value = value;
			}
		}
		
		
		public float _12
		{
			get
			{
				return _12Value;
			}
			set
			{
				this._12Value = value;
			}
		}
		
		
		public float _13
		{
			get
			{
				return _13Value;
			}
			set
			{
				this._13Value = value;
			}
		}
		
		
		public float _21
		{
			get
			{
				return _21Value;
			}
			set
			{
				this._21Value = value;
			}
		}
		
		
		public float _22
		{
			get
			{
				return _22Value;
			}
			set
			{
				this._22Value = value;
			}
		}
		
		
		public float _23
		{
			get
			{
				return _23Value;
			}
			set
			{
				this._23Value = value;
			}
		}
		
		
		public float _31
		{
			get
			{
				return _31Value;
			}
			set
			{
				this._31Value = value;
			}
		}
		
		
		public float _32
		{
			get
			{
				return _32Value;
			}
			set
			{
				this._32Value = value;
			}
		}
		
		
		public float _33
		{
			get
			{
				return _33Value;
			}
			set
			{
				this._33Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		private float _11Value;

		private float _12Value;

		private float _13Value;

		private float _21Value;

		private float _22Value;

		private float _23Value;

		private float _31Value;

		private float _32Value;

		private float _33Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 135329019L;		
	} // end class
}  // end namespace
