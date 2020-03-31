//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class SordZ : BValueClass, BSerializable
	{
	
		#region Constructors
		
		public SordZ() {
		}		
		
		public SordZ(long @bset) {
			this.bsetValue = @bset;
		}		
		
		public SordZ(SordZ rhs) : base(rhs)
		{
			this.bsetValue = rhs.bsetValue;
		}		
		
		#endregion
		
		#region Properties
		
		public long Bset
		{
			get
			{
				return bsetValue;
			}
			set
			{
				this.bsetValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected long bsetValue;

		#endregion
		
		
		public static readonly new long serialVersionUID = 691830L;		
	} // end class
}  // end namespace
