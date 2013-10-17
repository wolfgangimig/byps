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
			GetNodeAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetNodeAsync(BAsyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult) {
			BRequest_RemoteReferences_getNode req = new BRequest_RemoteReferences_getNode();			
			BAsyncResultReceiveMethod<com.wilutions.byps.test.api.refs.Node> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.refs.Node>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetNode(AsyncCallback callback, object state){
			BAsyncProgModel<com.wilutions.byps.test.api.refs.Node> _byps_ret = new BAsyncProgModel<com.wilutions.byps.test.api.refs.Node>(callback, state);
			GetNodeAsync(_byps_ret);
			return _byps_ret;
		}
		public com.wilutions.byps.test.api.refs.Node EndGetNode(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<com.wilutions.byps.test.api.refs.Node>)asyncResult).Result;
		}
		public async Task<com.wilutions.byps.test.api.refs.Node> GetNodeTask() {
			return await Task<com.wilutions.byps.test.api.refs.Node>.Factory.FromAsync(BeginGetNode, EndGetNode, null);
		}
		
		public void SetNode(com.wilutions.byps.test.api.refs.Node v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetNodeAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetNodeAsync(com.wilutions.byps.test.api.refs.Node v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteReferences_setNode req = new BRequest_RemoteReferences_setNode();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetNode(com.wilutions.byps.test.api.refs.Node v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetNodeAsync(v, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetNode(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetNodeTask(com.wilutions.byps.test.api.refs.Node v) {
			await Task.Factory.FromAsync(BeginSetNode, EndSetNode, v, null);
		}
		
		
	}
}
