//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class Class3 : Class2, BSerializable
	{
	
		#region Constructors
		
		public Class3() {
		}		
		
		public Class3(int @int3) {
			this.int3Value = @int3;
		}		
		
		public Class3(Class3 rhs) : base(rhs)
		{
			this.int3Value = rhs.int3Value;
		}		
		
		#endregion
		
		#region Properties
		
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
		
		
		#endregion
		
		#region Fields
		
		protected int int3Value;

		#endregion
		
		
		public static readonly new long serialVersionUID = 6003L;		
	} // end class
}  // end namespace
