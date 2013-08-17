using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteServerCtrl : BStub, RemoteServerCtrl, BSerializable {	
		
		public readonly static long serialVersionUID = 1124545992L;
		
		public BStub_RemoteServerCtrl(BTransport transport)
			: base(transport) {}			
		
		public void PublishRemote(String name, BRemote remote, bool fowardToOtherServers) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_PublishRemote(name, remote, fowardToOtherServers, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_PublishRemote(String name, BRemote remote, bool fowardToOtherServers, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteServerCtrl_publishRemote req = new BRequest_RemoteServerCtrl_publishRemote();			
			req._name = name;
			req._remote = remote;
			req._fowardToOtherServers = fowardToOtherServers;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginPublishRemote(String name, BRemote remote, bool fowardToOtherServers, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_PublishRemote(name, remote, fowardToOtherServers, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndPublishRemote(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public BRemote GetPublishedRemote(String name) {
			BSyncResult<BRemote> asyncResult = new BSyncResult<BRemote>();			
			async_GetPublishedRemote(name, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetPublishedRemote(String name, BAsyncResult<BRemote> asyncResult) {
			BRequest_RemoteServerCtrl_getPublishedRemote req = new BRequest_RemoteServerCtrl_getPublishedRemote();			
			req._name = name;
			BAsyncResultReceiveMethod<BRemote> outerResult = new BAsyncResultReceiveMethod<BRemote>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPublishedRemote(String name, AsyncCallback callback, object state){
			BAsyncProgModel<BRemote> _byps_ret = new BAsyncProgModel<BRemote>(callback, state);
			async_GetPublishedRemote(name, _byps_ret);
			return _byps_ret;
		}
		public 		BRemote EndGetPublishedRemote(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<BRemote>)asyncResult).Result;
		}
		
		public void RemovePublishedRemote(String name) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_RemovePublishedRemote(name, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_RemovePublishedRemote(String name, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteServerCtrl_removePublishedRemote req = new BRequest_RemoteServerCtrl_removePublishedRemote();			
			req._name = name;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginRemovePublishedRemote(String name, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_RemovePublishedRemote(name, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndRemovePublishedRemote(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		
	}
}
