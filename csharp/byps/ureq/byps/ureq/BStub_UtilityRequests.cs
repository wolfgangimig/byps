using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BStub_UtilityRequests : BStub, UtilityRequests, BSerializable {	
		
		public readonly static long serialVersionUID = 363558736L;
		
		public BStub_UtilityRequests(BTransport transport)
			: base(transport) {}			
		
		public virtual void CancelMessage(long messageId) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			CancelMessage(messageId, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void CancelMessage(long messageId, BAsyncResult<Object> asyncResult) {
			BRequest_UtilityRequests_cancelMessage req = new BRequest_UtilityRequests_cancelMessage();			
			req.messageIdValue = messageId;
			transport.sendMethod(req, asyncResult);
		}
		
		
	}
}
