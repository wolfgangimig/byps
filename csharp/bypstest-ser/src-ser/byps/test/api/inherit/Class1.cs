//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	/// <summary>
	/// Base class for ...
	/// </summary>
	public class Class1 : BSerializable
	{
	
		#region Constructors
		
		public Class1() {
		}		
		
		internal Class1(int @int1, Class1 @nextClass1) {
			this._int1 = @int1;
			this._nextClass1 = @nextClass1;
		}		
		
		#endregion
		
		#region Properties
		
		public int Int1
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
		
		
		public Class1 NextClass1
		{
			get
			{
				return _nextClass1;
			}
			set
			{
				this._nextClass1 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected int _int1;

		protected Class1 _nextClass1;

		#endregion
		
		
		public static readonly long serialVersionUID = 6001L;		
	} // end class
}  // end namespace
