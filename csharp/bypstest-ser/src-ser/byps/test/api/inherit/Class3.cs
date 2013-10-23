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
			this._int3 = @int3;
		}		
		
		#endregion
		
		#region Properties
		
		public int Int3
		{
			get
			{
				return _int3;
			}
			set
			{
				this._int3 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected int _int3;

		#endregion
		
		
		public static readonly new long serialVersionUID = 6003L;		
	} // end class
}  // end namespace
