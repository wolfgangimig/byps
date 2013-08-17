using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class BStub_EvolveIF : BStub, EvolveIF, BSerializable {	
		
		public readonly static long serialVersionUID = 2078696281L;
		
		public BStub_EvolveIF(BTransport transport)
			: base(transport) {}			
		
		public void SetEvolve(Evolve obj) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetEvolve(obj, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetEvolve(Evolve obj, BAsyncResult<Object> asyncResult) {
			BRequest_EvolveIF_setEvolve req = new BRequest_EvolveIF_setEvolve();			
			req._obj = obj;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetEvolve(Evolve obj, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetEvolve(obj, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetEvolve(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public Evolve GetEvolve() {
			BSyncResult<Evolve> asyncResult = new BSyncResult<Evolve>();			
			async_GetEvolve(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetEvolve(BAsyncResult<Evolve> asyncResult) {
			BRequest_EvolveIF_getEvolve req = new BRequest_EvolveIF_getEvolve();			
			BAsyncResultReceiveMethod<Evolve> outerResult = new BAsyncResultReceiveMethod<Evolve>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetEvolve(AsyncCallback callback, object state){
			BAsyncProgModel<Evolve> _byps_ret = new BAsyncProgModel<Evolve>(callback, state);
			async_GetEvolve(_byps_ret);
			return _byps_ret;
		}
		public 		Evolve EndGetEvolve(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Evolve>)asyncResult).Result;
		}
		
		public void SetClient(EvolveIF partner) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetClient(partner, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetClient(EvolveIF partner, BAsyncResult<Object> asyncResult) {
			BRequest_EvolveIF_setClient req = new BRequest_EvolveIF_setClient();			
			req._partner = partner;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetClient(EvolveIF partner, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetClient(partner, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public EvolveIF GetClient() {
			BSyncResult<EvolveIF> asyncResult = new BSyncResult<EvolveIF>();			
			async_GetClient(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetClient(BAsyncResult<EvolveIF> asyncResult) {
			BRequest_EvolveIF_getClient req = new BRequest_EvolveIF_getClient();			
			BAsyncResultReceiveMethod<EvolveIF> outerResult = new BAsyncResultReceiveMethod<EvolveIF>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetClient(AsyncCallback callback, object state){
			BAsyncProgModel<EvolveIF> _byps_ret = new BAsyncProgModel<EvolveIF>(callback, state);
			async_GetClient(_byps_ret);
			return _byps_ret;
		}
		public 		EvolveIF EndGetClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<EvolveIF>)asyncResult).Result;
		}
		
		public void SendEvolveToClient() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SendEvolveToClient(asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SendEvolveToClient(BAsyncResult<Object> asyncResult) {
			BRequest_EvolveIF_sendEvolveToClient req = new BRequest_EvolveIF_sendEvolveToClient();			
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSendEvolveToClient(AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SendEvolveToClient(_byps_ret);
			return _byps_ret;
		}
		public 		Object EndSendEvolveToClient(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		
	}
}
