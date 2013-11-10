using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteServerCtrl : BStub, RemoteServerCtrl, BSerializable {	
		
		public readonly static long serialVersionUID = 1652234479L;
		
		public BStub_RemoteServerCtrl(BTransport transport)
			: base(transport) {}			
		
		public void PublishRemote(String name, BRemote remote, bool fowardToOtherServers) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			PublishRemote(name, remote, fowardToOtherServers, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void PublishRemote(String name, BRemote remote, bool fowardToOtherServers, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteServerCtrl_publishRemote req = new BRequest_RemoteServerCtrl_publishRemote();			
			req.nameValue = name;
			req.remoteValue = remote;
			req.fowardToOtherServersValue = fowardToOtherServers;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task PublishRemoteAsync(String name, BRemote remote, bool fowardToOtherServers){
			BRequest_RemoteServerCtrl_publishRemote req = new BRequest_RemoteServerCtrl_publishRemote();			
			req.nameValue = name;
			req.remoteValue = remote;
			req.fowardToOtherServersValue = fowardToOtherServers;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public BRemote GetPublishedRemote(String name) {
			BSyncResult<BRemote> asyncResult = new BSyncResult<BRemote>();			
			GetPublishedRemote(name, BAsyncResultHelper.ToDelegate<BRemote>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPublishedRemote(String name, BAsyncResult<BRemote> asyncResult) {
			BRequest_RemoteServerCtrl_getPublishedRemote req = new BRequest_RemoteServerCtrl_getPublishedRemote();			
			req.nameValue = name;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<BRemote> GetPublishedRemoteAsync(String name){
			BRequest_RemoteServerCtrl_getPublishedRemote req = new BRequest_RemoteServerCtrl_getPublishedRemote();			
			req.nameValue = name;
			Task<BRemote> task = Task<BRemote>.Factory.FromAsync(transport.BeginSend<BRemote>, transport.EndSend<BRemote>, req, null);
			return await task;
		}
		
		public void RemovePublishedRemote(String name) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			RemovePublishedRemote(name, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void RemovePublishedRemote(String name, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteServerCtrl_removePublishedRemote req = new BRequest_RemoteServerCtrl_removePublishedRemote();			
			req.nameValue = name;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task RemovePublishedRemoteAsync(String name){
			BRequest_RemoteServerCtrl_removePublishedRemote req = new BRequest_RemoteServerCtrl_removePublishedRemote();			
			req.nameValue = name;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
