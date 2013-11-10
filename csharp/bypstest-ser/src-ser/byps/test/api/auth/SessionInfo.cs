//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.auth
{
	
	/// <summary>
	/// Example for a session class.
	/// </summary>
	public class SessionInfo : BSerializable
	{
	
		#region Constructors
		
		public SessionInfo() {
		}		
		
		internal SessionInfo(String @sessionID) {
			this.sessionIDValue = @sessionID;
		}		
		
		#endregion
		
		#region Properties
		
		public String SessionID
		{
			get
			{
				return sessionIDValue;
			}
			set
			{
				this.sessionIDValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected String sessionIDValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 65775978L;		
	} // end class
}  // end namespace
