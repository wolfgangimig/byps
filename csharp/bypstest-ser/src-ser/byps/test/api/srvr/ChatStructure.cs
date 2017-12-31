//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class ChatStructure : BSerializable
	{
	
		#region Constructors
		
		public ChatStructure() {
		}		
		
		public ChatStructure(String @msg, double @sentAt, double @receivedAt) {
			this.msgValue = @msg;
			this.sentAtValue = @sentAt;
			this.receivedAtValue = @receivedAt;
		}		
		
		public ChatStructure(ChatStructure rhs)
		{
			this.msgValue = rhs.msgValue;
			this.sentAtValue = rhs.sentAtValue;
			this.receivedAtValue = rhs.receivedAtValue;
		}		
		
		#endregion
		
		#region Properties
		
		public String Msg
		{
			get
			{
				return msgValue;
			}
			set
			{
				this.msgValue = value;
			}
		}
		
		
		public double SentAt
		{
			get
			{
				return sentAtValue;
			}
			set
			{
				this.sentAtValue = value;
			}
		}
		
		
		public double ReceivedAt
		{
			get
			{
				return receivedAtValue;
			}
			set
			{
				this.receivedAtValue = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected String msgValue;

		protected double sentAtValue;

		protected double receivedAtValue;

		#endregion
		
		
		public static readonly long serialVersionUID = 7007L;		
	} // end class
}  // end namespace
