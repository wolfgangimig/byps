//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace task.app
{
	
	public class Token : BSerializable
	{
	
		#region Constructors
		
		public Token() {
		}		
		
		public Token(String @sessionId) {
			this.sessionIdValue = @sessionId;
		}		
		
		public Token(Token rhs)
		{
			this.sessionIdValue = rhs.sessionIdValue;
		}		
		
		#endregion
		
		#region Properties
		
		public String SessionId
		{
			get
			{
				return sessionIdValue;
			}
			set
			{
				this.sessionIdValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected String sessionIdValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 323961470L;		
	} // end class
}  // end namespace
