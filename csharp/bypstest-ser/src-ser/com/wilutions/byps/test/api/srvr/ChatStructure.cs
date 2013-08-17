//
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class ChatStructure : BSerializable
	{
	
		#region Constructors
		
		public ChatStructure() {
		}		
		
		internal ChatStructure(String @msg, double @sentAt, double @receivedAt) {
			this._msg = @msg;
			this._sentAt = @sentAt;
			this._receivedAt = @receivedAt;
		}		
		
		#endregion
		
		#region Properties
		
		public String Msg
		{
			get
			{
				return _msg;
			}
			set
			{
				this._msg = value;
			}
		}
		
		
		public double SentAt
		{
			get
			{
				return _sentAt;
			}
			set
			{
				this._sentAt = value;
			}
		}
		
		
		public double ReceivedAt
		{
			get
			{
				return _receivedAt;
			}
			set
			{
				this._receivedAt = value;
			}
		}
		
		
		#endregion
		
		#region Fields
		
		protected String _msg;

		protected double _sentAt;

		protected double _receivedAt;

		#endregion
		
		
		public static readonly long serialVersionUID = 7007L;		
	} // end class
}  // end namespace
