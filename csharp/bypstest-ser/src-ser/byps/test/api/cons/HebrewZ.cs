//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class HebrewZ : BSerializable
	{
	
		#region Constructors
		
		public HebrewZ() {
		}		
		
		public HebrewZ(String @core) {
			this.coreValue = @core;
		}		
		
		public HebrewZ(HebrewZ rhs)
		{
			this.coreValue = rhs.coreValue;
		}		
		
		#endregion
		
		#region Properties
		
		public String Core
		{
			get
			{
				return coreValue;
			}
			set
			{
				this.coreValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected String coreValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1518668429L;		
	} // end class
}  // end namespace
