//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inl
{
	
	public sealed class Matrix2D : BSerializable
	{
	
		#region Constructors
		
		public Matrix2D() {
		}		
		
		internal Matrix2D(float @_11, float @_12, float @_13, float @_21, float @_22, float @_23, float @_31, float @_32, float @_33) {
			this.__11 = @_11;
			this.__12 = @_12;
			this.__13 = @_13;
			this.__21 = @_21;
			this.__22 = @_22;
			this.__23 = @_23;
			this.__31 = @_31;
			this.__32 = @_32;
			this.__33 = @_33;
		}		
		
		#endregion
		
		#region Properties
		
		public float _11
		{
			get
			{
				return __11;
			}
			set
			{
				this.__11 = value;
			}
		}
		
		
		public float _12
		{
			get
			{
				return __12;
			}
			set
			{
				this.__12 = value;
			}
		}
		
		
		public float _13
		{
			get
			{
				return __13;
			}
			set
			{
				this.__13 = value;
			}
		}
		
		
		public float _21
		{
			get
			{
				return __21;
			}
			set
			{
				this.__21 = value;
			}
		}
		
		
		public float _22
		{
			get
			{
				return __22;
			}
			set
			{
				this.__22 = value;
			}
		}
		
		
		public float _23
		{
			get
			{
				return __23;
			}
			set
			{
				this.__23 = value;
			}
		}
		
		
		public float _31
		{
			get
			{
				return __31;
			}
			set
			{
				this.__31 = value;
			}
		}
		
		
		public float _32
		{
			get
			{
				return __32;
			}
			set
			{
				this.__32 = value;
			}
		}
		
		
		public float _33
		{
			get
			{
				return __33;
			}
			set
			{
				this.__33 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		private float __11;

		private float __12;

		private float __13;

		private float __21;

		private float __22;

		private float __23;

		private float __31;

		private float __32;

		private float __33;

		#endregion
		
		
		public static readonly long serialVersionUID = 135329019L;		
	} // end class
}  // end namespace
