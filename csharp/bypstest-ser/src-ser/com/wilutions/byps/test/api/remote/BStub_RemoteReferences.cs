using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteReferences : BStub, RemoteReferences, BSerializable {	
		
		public readonly static long serialVersionUID = 2086824050L;
		
		public BStub_RemoteReferences(BTransport transport)
			: base(transport) {}			
		
		public com.wilutions.byps.test.api.refs.Node GetNode() {
			BSyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult = new BSyncResult<com.wilutions.byps.test.api.refs.Node>();			
			GetNode(BAsyncResultHelper.ToDelegate<com.wilutions.byps.test.api.refs.Node>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetNode(BAsyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult) {
			BRequest_RemoteReferences_getNode req = new BRequest_RemoteReferences_getNode();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<com.wilutions.byps.test.api.refs.Node> GetNodeAsync(){
			BRequest_RemoteReferences_getNode req = new BRequest_RemoteReferences_getNode();			
			Task<com.wilutions.byps.test.api.refs.Node> task = Task<com.wilutions.byps.test.api.refs.Node>.Factory.FromAsync(transport.BeginSend<com.wilutions.byps.test.api.refs.Node>, transport.EndSend<com.wilutions.byps.test.api.refs.Node>, req, null);
			return await task;
		}
		
		public void SetNode(com.wilutions.byps.test.api.refs.Node v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetNode(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetNode(com.wilutions.byps.test.api.refs.Node v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteReferences_setNode req = new BRequest_RemoteReferences_setNode();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetNodeAsync(com.wilutions.byps.test.api.refs.Node v){
			BRequest_RemoteReferences_setNode req = new BRequest_RemoteReferences_setNode();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
