using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.comp
{
	
	public class BStub_IncompatibleChangeIF : BStub, IncompatibleChangeIF, BSerializable {	
		
		public readonly static long serialVersionUID = 88979576L;
		
		public BStub_IncompatibleChangeIF(BTransport transport)
			: base(transport) {}			
		
		public virtual int ChangedReturnType() {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			ChangedReturnType(BAsyncResultHelper.ToDelegate<int>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void ChangedReturnType(BAsyncResult<int> asyncResult) {
			BRequest_IncompatibleChangeIF_changedReturnType req = new BRequest_IncompatibleChangeIF_changedReturnType();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int> ChangedReturnTypeAsync(){
			BRequest_IncompatibleChangeIF_changedReturnType req = new BRequest_IncompatibleChangeIF_changedReturnType();			
			Task<int> task = Task<int>.Factory.FromAsync(transport.BeginSend<int>, transport.EndSend<int>, req, null);
			return await task;
		}
		
		public virtual void ChangedParameterType(int intParamChangedToString) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			ChangedParameterType(intParamChangedToString, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void ChangedParameterType(int intParamChangedToString, BAsyncResult<Object> asyncResult) {
			BRequest_IncompatibleChangeIF_changedParameterType req = new BRequest_IncompatibleChangeIF_changedParameterType();			
			req.intParamChangedToStringValue = intParamChangedToString;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task ChangedParameterTypeAsync(int intParamChangedToString){
			BRequest_IncompatibleChangeIF_changedParameterType req = new BRequest_IncompatibleChangeIF_changedParameterType();			
			req.intParamChangedToStringValue = intParamChangedToString;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void ChangedClass(IncompatibleChangeInfo param) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			ChangedClass(param, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void ChangedClass(IncompatibleChangeInfo param, BAsyncResult<Object> asyncResult) {
			BRequest_IncompatibleChangeIF_changedClass req = new BRequest_IncompatibleChangeIF_changedClass();			
			req.paramValue = param;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task ChangedClassAsync(IncompatibleChangeInfo param){
			BRequest_IncompatibleChangeIF_changedClass req = new BRequest_IncompatibleChangeIF_changedClass();			
			req.paramValue = param;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
