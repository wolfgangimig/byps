using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BStub_ServerIF : BStub, ServerIF, BSerializable {	
		
		public readonly static long serialVersionUID = 1313562065L;
		
		public BStub_ServerIF(BTransport transport)
			: base(transport) {}			
		
		public int CallClientIncrementInt(int v) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			CallClientIncrementIntAsync(v, asyncResult);
			return asyncResult.GetResult();			
		}
		public void CallClientIncrementIntAsync(int v, BAsyncResult<int> asyncResult) {
			BRequest_ServerIF_callClientIncrementInt req = new BRequest_ServerIF_callClientIncrementInt();			
			req._v = v;
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginCallClientIncrementInt(int v, AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			CallClientIncrementIntAsync(v, _byps_ret);
			return _byps_ret;
		}
		public int EndCallClientIncrementInt(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		public async Task<int> CallClientIncrementIntTask(int v) {
			return await Task<int>.Factory.FromAsync(BeginCallClientIncrementInt, EndCallClientIncrementInt, v, null);
		}
		
		public void SetPartner(ClientIF client) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPartnerAsync(client, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetPartnerAsync(ClientIF client, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_setPartner req = new BRequest_ServerIF_setPartner();			
			req._client = client;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPartner(ClientIF client, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetPartnerAsync(client, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetPartner(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetPartnerTask(ClientIF client) {
			await Task.Factory.FromAsync(BeginSetPartner, EndSetPartner, client, null);
		}
		
		public ClientIF GetPartner() {
			BSyncResult<ClientIF> asyncResult = new BSyncResult<ClientIF>();			
			GetPartnerAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetPartnerAsync(BAsyncResult<ClientIF> asyncResult) {
			BRequest_ServerIF_getPartner req = new BRequest_ServerIF_getPartner();			
			BAsyncResultReceiveMethod<ClientIF> outerResult = new BAsyncResultReceiveMethod<ClientIF>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPartner(AsyncCallback callback, object state){
			BAsyncProgModel<ClientIF> _byps_ret = new BAsyncProgModel<ClientIF>(callback, state);
			GetPartnerAsync(_byps_ret);
			return _byps_ret;
		}
		public ClientIF EndGetPartner(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ClientIF>)asyncResult).Result;
		}
		public async Task<ClientIF> GetPartnerTask() {
			return await Task<ClientIF>.Factory.FromAsync(BeginGetPartner, EndGetPartner, null);
		}
		
		public IList<System.IO.Stream> GetStreamsFromClient() {
			BSyncResult<IList<System.IO.Stream>> asyncResult = new BSyncResult<IList<System.IO.Stream>>();			
			GetStreamsFromClientAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetStreamsFromClientAsync(BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			BRequest_ServerIF_getStreamsFromClient req = new BRequest_ServerIF_getStreamsFromClient();			
			BAsyncResultReceiveMethod<IList<System.IO.Stream>> outerResult = new BAsyncResultReceiveMethod<IList<System.IO.Stream>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetStreamsFromClient(AsyncCallback callback, object state){
			BAsyncProgModel<IList<System.IO.Stream>> _byps_ret = new BAsyncProgModel<IList<System.IO.Stream>>(callback, state);
			GetStreamsFromClientAsync(_byps_ret);
			return _byps_ret;
		}
		public IList<System.IO.Stream> EndGetStreamsFromClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<System.IO.Stream>>)asyncResult).Result;
		}
		public async Task<IList<System.IO.Stream>> GetStreamsFromClientTask() {
			return await Task<IList<System.IO.Stream>>.Factory.FromAsync(BeginGetStreamsFromClient, EndGetStreamsFromClient, null);
		}
		
		public void PutStreamsOnClient(IList<System.IO.Stream> streams) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			PutStreamsOnClientAsync(streams, asyncResult);
			asyncResult.GetResult();			
		}
		public void PutStreamsOnClientAsync(IList<System.IO.Stream> streams, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_putStreamsOnClient req = new BRequest_ServerIF_putStreamsOnClient();			
			req._streams = streams;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginPutStreamsOnClient(IList<System.IO.Stream> streams, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			PutStreamsOnClientAsync(streams, _byps_ret);
			return _byps_ret;
		}
		public Object EndPutStreamsOnClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task PutStreamsOnClientTask(IList<System.IO.Stream> streams) {
			await Task.Factory.FromAsync(BeginPutStreamsOnClient, EndPutStreamsOnClient, streams, null);
		}
		
		public void RegisterWithClientMap(int id) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			RegisterWithClientMapAsync(id, asyncResult);
			asyncResult.GetResult();			
		}
		public void RegisterWithClientMapAsync(int id, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_registerWithClientMap req = new BRequest_ServerIF_registerWithClientMap();			
			req._id = id;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginRegisterWithClientMap(int id, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			RegisterWithClientMapAsync(id, _byps_ret);
			return _byps_ret;
		}
		public Object EndRegisterWithClientMap(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task RegisterWithClientMapTask(int id) {
			await Task.Factory.FromAsync(BeginRegisterWithClientMap, EndRegisterWithClientMap, id, null);
		}
		
		public ClientIF GetClient(int id) {
			BSyncResult<ClientIF> asyncResult = new BSyncResult<ClientIF>();			
			GetClientAsync(id, asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetClientAsync(int id, BAsyncResult<ClientIF> asyncResult) {
			BRequest_ServerIF_getClient req = new BRequest_ServerIF_getClient();			
			req._id = id;
			BAsyncResultReceiveMethod<ClientIF> outerResult = new BAsyncResultReceiveMethod<ClientIF>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetClient(int id, AsyncCallback callback, object state){
			BAsyncProgModel<ClientIF> _byps_ret = new BAsyncProgModel<ClientIF>(callback, state);
			GetClientAsync(id, _byps_ret);
			return _byps_ret;
		}
		public ClientIF EndGetClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ClientIF>)asyncResult).Result;
		}
		public async Task<ClientIF> GetClientTask(int id) {
			return await Task<ClientIF>.Factory.FromAsync(BeginGetClient, EndGetClient, id, null);
		}
		
		public ISet<int> GetClientIds() {
			BSyncResult<ISet<int>> asyncResult = new BSyncResult<ISet<int>>();			
			GetClientIdsAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetClientIdsAsync(BAsyncResult<ISet<int>> asyncResult) {
			BRequest_ServerIF_getClientIds req = new BRequest_ServerIF_getClientIds();			
			BAsyncResultReceiveMethod<ISet<int>> outerResult = new BAsyncResultReceiveMethod<ISet<int>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetClientIds(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<int>> _byps_ret = new BAsyncProgModel<ISet<int>>(callback, state);
			GetClientIdsAsync(_byps_ret);
			return _byps_ret;
		}
		public ISet<int> EndGetClientIds(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<int>>)asyncResult).Result;
		}
		public async Task<ISet<int>> GetClientIdsTask() {
			return await Task<ISet<int>>.Factory.FromAsync(BeginGetClientIds, EndGetClientIds, null);
		}
		
		public int CallClientParallel(int v) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			CallClientParallelAsync(v, asyncResult);
			return asyncResult.GetResult();			
		}
		public void CallClientParallelAsync(int v, BAsyncResult<int> asyncResult) {
			BRequest_ServerIF_callClientParallel req = new BRequest_ServerIF_callClientParallel();			
			req._v = v;
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginCallClientParallel(int v, AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			CallClientParallelAsync(v, _byps_ret);
			return _byps_ret;
		}
		public int EndCallClientParallel(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		public async Task<int> CallClientParallelTask(int v) {
			return await Task<int>.Factory.FromAsync(BeginCallClientParallel, EndCallClientParallel, v, null);
		}
		
		
	}
}
