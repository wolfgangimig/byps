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
		
		internal Class3(int @int3) {
			this.int3Value = @int3;
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
