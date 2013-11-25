using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.srvr
{
	
	public class BStub_ServerIF : BStub, ServerIF, BSerializable {	
		
		public readonly static long serialVersionUID = 1426448279L;
		
		public BStub_ServerIF(BTransport transport)
			: base(transport) {}			
		
		public virtual int CallClientIncrementInt(int v) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			CallClientIncrementInt(v, BAsyncResultHelper.ToDelegate<int>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void CallClientIncrementInt(int v, BAsyncResult<int> asyncResult) {
			BRequest_ServerIF_callClientIncrementInt req = new BRequest_ServerIF_callClientIncrementInt();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int> CallClientIncrementIntAsync(int v){
			BRequest_ServerIF_callClientIncrementInt req = new BRequest_ServerIF_callClientIncrementInt();			
			req.vValue = v;
			Task<int> task = Task<int>.Factory.FromAsync(transport.BeginSend<int>, transport.EndSend<int>, req, null);
			return await task;
		}
		
		public virtual void SetPartner(ClientIF client) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPartner(client, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPartner(ClientIF client, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_setPartner req = new BRequest_ServerIF_setPartner();			
			req.clientValue = client;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPartnerAsync(ClientIF client){
			BRequest_ServerIF_setPartner req = new BRequest_ServerIF_setPartner();			
			req.clientValue = client;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual ClientIF GetPartner() {
			BSyncResult<ClientIF> asyncResult = new BSyncResult<ClientIF>();			
			GetPartner(BAsyncResultHelper.ToDelegate<ClientIF>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPartner(BAsyncResult<ClientIF> asyncResult) {
			BRequest_ServerIF_getPartner req = new BRequest_ServerIF_getPartner();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<ClientIF> GetPartnerAsync(){
			BRequest_ServerIF_getPartner req = new BRequest_ServerIF_getPartner();			
			Task<ClientIF> task = Task<ClientIF>.Factory.FromAsync(transport.BeginSend<ClientIF>, transport.EndSend<ClientIF>, req, null);
			return await task;
		}
		
		public virtual IList<System.IO.Stream> GetStreamsFromClient() {
			BSyncResult<IList<System.IO.Stream>> asyncResult = new BSyncResult<IList<System.IO.Stream>>();			
			GetStreamsFromClient(BAsyncResultHelper.ToDelegate<IList<System.IO.Stream>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetStreamsFromClient(BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			BRequest_ServerIF_getStreamsFromClient req = new BRequest_ServerIF_getStreamsFromClient();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<System.IO.Stream>> GetStreamsFromClientAsync(){
			BRequest_ServerIF_getStreamsFromClient req = new BRequest_ServerIF_getStreamsFromClient();			
			Task<IList<System.IO.Stream>> task = Task<IList<System.IO.Stream>>.Factory.FromAsync(transport.BeginSend<IList<System.IO.Stream>>, transport.EndSend<IList<System.IO.Stream>>, req, null);
			return await task;
		}
		
		public virtual void PutStreamsOnClient(IList<System.IO.Stream> streams) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			PutStreamsOnClient(streams, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void PutStreamsOnClient(IList<System.IO.Stream> streams, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_putStreamsOnClient req = new BRequest_ServerIF_putStreamsOnClient();			
			req.streamsValue = streams;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task PutStreamsOnClientAsync(IList<System.IO.Stream> streams){
			BRequest_ServerIF_putStreamsOnClient req = new BRequest_ServerIF_putStreamsOnClient();			
			req.streamsValue = streams;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void RegisterWithClientMap(int id) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			RegisterWithClientMap(id, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void RegisterWithClientMap(int id, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_registerWithClientMap req = new BRequest_ServerIF_registerWithClientMap();			
			req.idValue = id;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task RegisterWithClientMapAsync(int id){
			BRequest_ServerIF_registerWithClientMap req = new BRequest_ServerIF_registerWithClientMap();			
			req.idValue = id;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual ClientIF GetClient(int id) {
			BSyncResult<ClientIF> asyncResult = new BSyncResult<ClientIF>();			
			GetClient(id, BAsyncResultHelper.ToDelegate<ClientIF>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetClient(int id, BAsyncResult<ClientIF> asyncResult) {
			BRequest_ServerIF_getClient req = new BRequest_ServerIF_getClient();			
			req.idValue = id;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<ClientIF> GetClientAsync(int id){
			BRequest_ServerIF_getClient req = new BRequest_ServerIF_getClient();			
			req.idValue = id;
			Task<ClientIF> task = Task<ClientIF>.Factory.FromAsync(transport.BeginSend<ClientIF>, transport.EndSend<ClientIF>, req, null);
			return await task;
		}
		
		public virtual ISet<int> GetClientIds() {
			BSyncResult<ISet<int>> asyncResult = new BSyncResult<ISet<int>>();			
			GetClientIds(BAsyncResultHelper.ToDelegate<ISet<int>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetClientIds(BAsyncResult<ISet<int>> asyncResult) {
			BRequest_ServerIF_getClientIds req = new BRequest_ServerIF_getClientIds();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<int>> GetClientIdsAsync(){
			BRequest_ServerIF_getClientIds req = new BRequest_ServerIF_getClientIds();			
			Task<ISet<int>> task = Task<ISet<int>>.Factory.FromAsync(transport.BeginSend<ISet<int>>, transport.EndSend<ISet<int>>, req, null);
			return await task;
		}
		
		public virtual int CallClientParallel(int v) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			CallClientParallel(v, BAsyncResultHelper.ToDelegate<int>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void CallClientParallel(int v, BAsyncResult<int> asyncResult) {
			BRequest_ServerIF_callClientParallel req = new BRequest_ServerIF_callClientParallel();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int> CallClientParallelAsync(int v){
			BRequest_ServerIF_callClientParallel req = new BRequest_ServerIF_callClientParallel();			
			req.vValue = v;
			Task<int> task = Task<int>.Factory.FromAsync(transport.BeginSend<int>, transport.EndSend<int>, req, null);
			return await task;
		}
		
		
	}
}
