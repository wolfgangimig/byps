using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteServerCtrl : BStub, RemoteServerCtrl, BSerializable {	
		
		public readonly static long serialVersionUID = 1124545992L;
		
		public BStub_RemoteServerCtrl(BTransport transport)
			: base(transport) {}			
		
		public void PublishRemote(String name, BRemote remote, bool fowardToOtherServers) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			PublishRemoteAsync(name, remote, fowardToOtherServers, asyncResult);
			asyncResult.GetResult();			
		}
		public void PublishRemoteAsync(String name, BRemote remote, bool fowardToOtherServers, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteServerCtrl_publishRemote req = new BRequest_RemoteServerCtrl_publishRemote();			
			req._name = name;
			req._remote = remote;
			req._fowardToOtherServers = fowardToOtherServers;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginPublishRemote(String name, BRemote remote, bool fowardToOtherServers, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			PublishRemoteAsync(name, remote, fowardToOtherServers, _byps_ret);
			return _byps_ret;
		}
		public Object EndPublishRemote(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task PublishRemoteTask(String name, BRemote remote, bool fowardToOtherServers) {
			await Task.Factory.FromAsync(BeginPublishRemote, EndPublishRemote, name, remote, fowardToOtherServers, null);
		}
		
		public BRemote GetPublishedRemote(String name) {
			BSyncResult<BRemote> asyncResult = new BSyncResult<BRemote>();			
			GetPublishedRemoteAsync(name, asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetPublishedRemoteAsync(String name, BAsyncResult<BRemote> asyncResult) {
			BRequest_RemoteServerCtrl_getPublishedRemote req = new BRequest_RemoteServerCtrl_getPublishedRemote();			
			req._name = name;
			BAsyncResultReceiveMethod<BRemote> outerResult = new BAsyncResultReceiveMethod<BRemote>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPublishedRemote(String name, AsyncCallback callback, object state){
			BAsyncProgModel<BRemote> _byps_ret = new BAsyncProgModel<BRemote>(callback, state);
			GetPublishedRemoteAsync(name, _byps_ret);
			return _byps_ret;
		}
		public BRemote EndGetPublishedRemote(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<BRemote>)asyncResult).Result;
		}
		public async Task<BRemote> GetPublishedRemoteTask(String name) {
			return await Task<BRemote>.Factory.FromAsync(BeginGetPublishedRemote, EndGetPublishedRemote, name, null);
		}
		
		public void RemovePublishedRemote(String name) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			RemovePublishedRemoteAsync(name, asyncResult);
			asyncResult.GetResult();			
		}
		public void RemovePublishedRemoteAsync(String name, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteServerCtrl_removePublishedRemote req = new BRequest_RemoteServerCtrl_removePublishedRemote();			
			req._name = name;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginRemovePublishedRemote(String name, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			RemovePublishedRemoteAsync(name, _byps_ret);
			return _byps_ret;
		}
		public Object EndRemovePublishedRemote(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task RemovePublishedRemoteTask(String name) {
			await Task.Factory.FromAsync(BeginRemovePublishedRemote, EndRemovePublishedRemote, name, null);
		}
		
		
	}
}
