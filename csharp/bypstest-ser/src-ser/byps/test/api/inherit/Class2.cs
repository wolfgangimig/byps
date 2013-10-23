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
		
		internal Class2(int @int2) {
			this._int2 = @int2;
		}		
		
		#endregion
		
		#region Properties
		
		public int Int2
		{
			get
			{
				return _int2;
			}
			set
			{
				this._int2 = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected int _int2;

		#endregion
		
		
		public static readonly new long serialVersionUID = 6002L;		
	} // end class
}  // end namespace
