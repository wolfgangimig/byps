using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteReferences : BStub, RemoteReferences, BSerializable {	
		
		public readonly static long serialVersionUID = 568637225L;
		
		public BStub_RemoteReferences(BTransport transport)
			: base(transport) {}			
		
		public byps.test.api.refs.Node GetNode() {
			BSyncResult<byps.test.api.refs.Node> asyncResult = new BSyncResult<byps.test.api.refs.Node>();			
			GetNode(BAsyncResultHelper.ToDelegate<byps.test.api.refs.Node>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetNode(BAsyncResult<byps.test.api.refs.Node> asyncResult) {
			BRequest_RemoteReferences_getNode req = new BRequest_RemoteReferences_getNode();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.refs.Node> GetNodeAsync(){
			BRequest_RemoteReferences_getNode req = new BRequest_RemoteReferences_getNode();			
			Task<byps.test.api.refs.Node> task = Task<byps.test.api.refs.Node>.Factory.FromAsync(transport.BeginSend<byps.test.api.refs.Node>, transport.EndSend<byps.test.api.refs.Node>, req, null);
			return await task;
		}
		
		public void SetNode(byps.test.api.refs.Node v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetNode(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetNode(byps.test.api.refs.Node v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteReferences_setNode req = new BRequest_RemoteReferences_setNode();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetNodeAsync(byps.test.api.refs.Node v){
			BRequest_RemoteReferences_setNode req = new BRequest_RemoteReferences_setNode();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
