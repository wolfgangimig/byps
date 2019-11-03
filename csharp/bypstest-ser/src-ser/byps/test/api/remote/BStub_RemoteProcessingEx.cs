using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteProcessingEx : BStub, RemoteProcessingEx, BSerializable {	
		
		public readonly static long serialVersionUID = 790485113L;
		
		public BStub_RemoteProcessingEx(BTransport transport)
			: base(transport) {}			
		
		public virtual bool GetValueAfterProcessingExceptions(int sleepSeconds) {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			GetValueAfterProcessingExceptions(sleepSeconds, BAsyncResultHelper.ToDelegate<bool>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetValueAfterProcessingExceptions(int sleepSeconds, BAsyncResult<bool> asyncResult) {
			BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions req = new BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions();			
			req.sleepSecondsValue = sleepSeconds;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<bool> GetValueAfterProcessingExceptionsAsync(int sleepSeconds){
			BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions req = new BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions();			
			req.sleepSecondsValue = sleepSeconds;
			Task<bool> task = Task<bool>.Factory.FromAsync(transport.BeginSend<bool>, transport.EndSend<bool>, req, null);
			return await task;
		}
		
		
	}
}
