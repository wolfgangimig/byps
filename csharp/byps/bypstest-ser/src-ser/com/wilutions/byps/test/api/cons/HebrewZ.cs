//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.cons
{
	
	public class HebrewZ : BSerializable
	{
	
		#region Constructors
		
		public HebrewZ() {
		}		
		
		internal HebrewZ(String @core) {
			this._core = @core;
		}		
		
		#endregion
		
		#region Properties
		
		public String Core
		{
			get
			{
				return _core;
			}
			set
			{
				this._core = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected String _core;

		#endregion
		
		
		public static readonly long serialVersionUID = 1518668429L;		
	} // end class
}  // end namespace
