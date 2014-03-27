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
		
		public Class1(int @int1, Class1 @nextClass1) {
			this.int1Value = @int1;
			this.nextClass1Value = @nextClass1;
		}		
		
		public Class1(Class1 rhs)
		{
			this.int1Value = rhs.int1Value;
			this.nextClass1Value = rhs.nextClass1Value;
		}		
		
		#endregion
		
		#region Properties
		
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
		
		
		public Class1 NextClass1
		{
			get
			{
				return nextClass1Value;
			}
			set
			{
				this.nextClass1Value = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected int int1Value;

		protected Class1 nextClass1Value;

		#endregion
		
		
		public static readonly long serialVersionUID = 6001L;		
	} // end class
}  // end namespace
