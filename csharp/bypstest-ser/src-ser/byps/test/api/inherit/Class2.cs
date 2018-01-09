//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class Class2 : Class1, BSerializable
	{
	
		#region Constructors
		
		public Class2() {
		}		
		
		public Class2(int @int2) {
			this.int2Value = @int2;
		}		
		
		public Class2(Class2 rhs) : base(rhs)
		{
			this.int2Value = rhs.int2Value;
		}		
		
		#endregion
		
		#region Properties
		
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
		
		
		#endregion
		
		#region Fields
		
		protected int int2Value;

		#endregion
		
		
		public static readonly new long serialVersionUID = 6002L;		
	} // end class
}  // end namespace
