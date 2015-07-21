//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	/// <summary>
	/// Class with incompatible changes.
	/// </summary>
	/// <remarks>
	/// This class has in API version 793 an int member.
	/// In version 794, this member was changed to String.
	/// Serializing this API from 793 to 794 cause an exception.
	/// </remarks>
	public class IncompatibleChangeInfo : BSerializable
	{
	
		#region Constructors
		
		public IncompatibleChangeInfo() {
		}		
		
		public IncompatibleChangeInfo(int @intValueChangedToString) {
			this.intValueChangedToStringValue = @intValueChangedToString;
		}		
		
		public IncompatibleChangeInfo(IncompatibleChangeInfo rhs)
		{
			this.intValueChangedToStringValue = rhs.intValueChangedToStringValue;
		}		
		
		#endregion
		
		#region Properties
		
		public int IntValueChangedToString
		{
			get
			{
				return intValueChangedToStringValue;
			}
			set
			{
				this.intValueChangedToStringValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected int intValueChangedToStringValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 1107425749L;		
	} // end class
}  // end namespace
