using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BStub_ServerIF : BStub, ServerIF, BSerializable {	
		
		public readonly static long serialVersionUID = 1313562065L;
		
		public BStub_ServerIF(BTransport transport)
			: base(transport) {}			
		
		public int CallClientIncrementInt(int v) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			async_CallClientIncrementInt(v, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_CallClientIncrementInt(int v, BAsyncResult<int> asyncResult) {
			BRequest_ServerIF_callClientIncrementInt req = new BRequest_ServerIF_callClientIncrementInt();			
			req._v = v;
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginCallClientIncrementInt(int v, AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			async_CallClientIncrementInt(v, _byps_ret);
			return _byps_ret;
		}
		public 		int EndCallClientIncrementInt(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		
		public void SetPartner(ClientIF client) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetPartner(client, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetPartner(ClientIF client, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_setPartner req = new BRequest_ServerIF_setPartner();			
			req._client = client;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPartner(ClientIF client, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetPartner(client, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetPartner(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ClientIF GetPartner() {
			BSyncResult<ClientIF> asyncResult = new BSyncResult<ClientIF>();			
			async_GetPartner(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetPartner(BAsyncResult<ClientIF> asyncResult) {
			BRequest_ServerIF_getPartner req = new BRequest_ServerIF_getPartner();			
			BAsyncResultReceiveMethod<ClientIF> outerResult = new BAsyncResultReceiveMethod<ClientIF>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPartner(AsyncCallback callback, object state){
			BAsyncProgModel<ClientIF> _byps_ret = new BAsyncProgModel<ClientIF>(callback, state);
			async_GetPartner(_byps_ret);
			return _byps_ret;
		}
		public 		ClientIF EndGetPartner(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ClientIF>)asyncResult).Result;
		}
		
		public IList<System.IO.Stream> GetStreamsFromClient() {
			BSyncResult<IList<System.IO.Stream>> asyncResult = new BSyncResult<IList<System.IO.Stream>>();			
			async_GetStreamsFromClient(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetStreamsFromClient(BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			BRequest_ServerIF_getStreamsFromClient req = new BRequest_ServerIF_getStreamsFromClient();			
			BAsyncResultReceiveMethod<IList<System.IO.Stream>> outerResult = new BAsyncResultReceiveMethod<IList<System.IO.Stream>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetStreamsFromClient(AsyncCallback callback, object state){
			BAsyncProgModel<IList<System.IO.Stream>> _byps_ret = new BAsyncProgModel<IList<System.IO.Stream>>(callback, state);
			async_GetStreamsFromClient(_byps_ret);
			return _byps_ret;
		}
		public 		IList<System.IO.Stream> EndGetStreamsFromClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<System.IO.Stream>>)asyncResult).Result;
		}
		
		public void PutStreamsOnClient(IList<System.IO.Stream> streams) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_PutStreamsOnClient(streams, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_PutStreamsOnClient(IList<System.IO.Stream> streams, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_putStreamsOnClient req = new BRequest_ServerIF_putStreamsOnClient();			
			req._streams = streams;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginPutStreamsOnClient(IList<System.IO.Stream> streams, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_PutStreamsOnClient(streams, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndPutStreamsOnClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void RegisterWithClientMap(int id) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_RegisterWithClientMap(id, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_RegisterWithClientMap(int id, BAsyncResult<Object> asyncResult) {
			BRequest_ServerIF_registerWithClientMap req = new BRequest_ServerIF_registerWithClientMap();			
			req._id = id;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginRegisterWithClientMap(int id, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_RegisterWithClientMap(id, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndRegisterWithClientMap(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ClientIF GetClient(int id) {
			BSyncResult<ClientIF> asyncResult = new BSyncResult<ClientIF>();			
			async_GetClient(id, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetClient(int id, BAsyncResult<ClientIF> asyncResult) {
			BRequest_ServerIF_getClient req = new BRequest_ServerIF_getClient();			
			req._id = id;
			BAsyncResultReceiveMethod<ClientIF> outerResult = new BAsyncResultReceiveMethod<ClientIF>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetClient(int id, AsyncCallback callback, object state){
			BAsyncProgModel<ClientIF> _byps_ret = new BAsyncProgModel<ClientIF>(callback, state);
			async_GetClient(id, _byps_ret);
			return _byps_ret;
		}
		public 		ClientIF EndGetClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ClientIF>)asyncResult).Result;
		}
		
		public ISet<int> GetClientIds() {
			BSyncResult<ISet<int>> asyncResult = new BSyncResult<ISet<int>>();			
			async_GetClientIds(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetClientIds(BAsyncResult<ISet<int>> asyncResult) {
			BRequest_ServerIF_getClientIds req = new BRequest_ServerIF_getClientIds();			
			BAsyncResultReceiveMethod<ISet<int>> outerResult = new BAsyncResultReceiveMethod<ISet<int>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetClientIds(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<int>> _byps_ret = new BAsyncProgModel<ISet<int>>(callback, state);
			async_GetClientIds(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<int> EndGetClientIds(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<int>>)asyncResult).Result;
		}
		
		public int CallClientParallel(int v) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			async_CallClientParallel(v, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_CallClientParallel(int v, BAsyncResult<int> asyncResult) {
			BRequest_ServerIF_callClientParallel req = new BRequest_ServerIF_callClientParallel();			
			req._v = v;
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginCallClientParallel(int v, AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			async_CallClientParallel(v, _byps_ret);
			return _byps_ret;
		}
		public 		int EndCallClientParallel(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		
		
	}
}
