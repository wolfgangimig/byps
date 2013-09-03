//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.auth
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
			this._sessionID = @sessionID;
		}		
		
		#endregion
		
		#region Properties
		
		public String SessionID
		{
			get
			{
				return _sessionID;
			}
			set
			{
				this._sessionID = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected String _sessionID;

		#endregion
		
		
		public static readonly long serialVersionUID = 65775978L;		
	} // end class
}  // end namespace
