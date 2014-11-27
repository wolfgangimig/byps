using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BStub_BUtilityRequests : BStub, BUtilityRequests, BSerializable {	
		
		public readonly static long serialVersionUID = 174367442L;
		
		public BStub_BUtilityRequests(BTransport transport)
			: base(transport) {}			
		
		public virtual void CancelMessage(long messageId) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			CancelMessage(messageId, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void CancelMessage(long messageId, BAsyncResult<Object> asyncResult) {
			BRequest_BUtilityRequests_cancelMessage req = new BRequest_BUtilityRequests_cancelMessage();			
			req.messageIdValue = messageId;
			transport.sendMethod(req, asyncResult);
		}
		
		public virtual IDictionary<String,String> TestAdapter(String functionName, IDictionary<String,String> @params) {
			BSyncResult<IDictionary<String,String>> asyncResult = new BSyncResult<IDictionary<String,String>>();			
			TestAdapter(functionName, @params, BAsyncResultHelper.ToDelegate<IDictionary<String,String>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void TestAdapter(String functionName, IDictionary<String,String> @params, BAsyncResult<IDictionary<String,String>> asyncResult) {
			BRequest_BUtilityRequests_testAdapter req = new BRequest_BUtilityRequests_testAdapter();			
			req.functionNameValue = functionName;
			req.paramsValue = @params;
			transport.sendMethod(req, asyncResult);
		}
		
		public virtual IDictionary<String,String> Execute(String functionName, IDictionary<String,String> @params) {
			BSyncResult<IDictionary<String,String>> asyncResult = new BSyncResult<IDictionary<String,String>>();			
			Execute(functionName, @params, BAsyncResultHelper.ToDelegate<IDictionary<String,String>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void Execute(String functionName, IDictionary<String,String> @params, BAsyncResult<IDictionary<String,String>> asyncResult) {
			BRequest_BUtilityRequests_execute req = new BRequest_BUtilityRequests_execute();			
			req.functionNameValue = functionName;
			req.paramsValue = @params;
			transport.sendMethod(req, asyncResult);
		}
		
		
	}
}
