using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.ver
{
	
	public class BStub_EvolveIF : BStub, EvolveIF, BSerializable {	
		
		public readonly static long serialVersionUID = 15377840L;
		
		public BStub_EvolveIF(BTransport transport)
			: base(transport) {}			
		
		public void SetEvolve(Evolve obj) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetEvolve(obj, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetEvolve(Evolve obj, BAsyncResult<Object> asyncResult) {
			BRequest_EvolveIF_setEvolve req = new BRequest_EvolveIF_setEvolve();			
			req._obj = obj;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetEvolveAsync(Evolve obj){
			BRequest_EvolveIF_setEvolve req = new BRequest_EvolveIF_setEvolve();			
			req._obj = obj;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public Evolve GetEvolve() {
			BSyncResult<Evolve> asyncResult = new BSyncResult<Evolve>();			
			GetEvolve(BAsyncResultHelper.ToDelegate<Evolve>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetEvolve(BAsyncResult<Evolve> asyncResult) {
			BRequest_EvolveIF_getEvolve req = new BRequest_EvolveIF_getEvolve();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<Evolve> GetEvolveAsync(){
			BRequest_EvolveIF_getEvolve req = new BRequest_EvolveIF_getEvolve();			
			Task<Evolve> task = Task<Evolve>.Factory.FromAsync(transport.BeginSend<Evolve>, transport.EndSend<Evolve>, req, null);
			return await task;
		}
		
		public void SetClient(EvolveIF partner) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetClient(partner, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetClient(EvolveIF partner, BAsyncResult<Object> asyncResult) {
			BRequest_EvolveIF_setClient req = new BRequest_EvolveIF_setClient();			
			req._partner = partner;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetClientAsync(EvolveIF partner){
			BRequest_EvolveIF_setClient req = new BRequest_EvolveIF_setClient();			
			req._partner = partner;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public EvolveIF GetClient() {
			BSyncResult<EvolveIF> asyncResult = new BSyncResult<EvolveIF>();			
			GetClient(BAsyncResultHelper.ToDelegate<EvolveIF>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetClient(BAsyncResult<EvolveIF> asyncResult) {
			BRequest_EvolveIF_getClient req = new BRequest_EvolveIF_getClient();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<EvolveIF> GetClientAsync(){
			BRequest_EvolveIF_getClient req = new BRequest_EvolveIF_getClient();			
			Task<EvolveIF> task = Task<EvolveIF>.Factory.FromAsync(transport.BeginSend<EvolveIF>, transport.EndSend<EvolveIF>, req, null);
			return await task;
		}
		
		public void SendEvolveToClient() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SendEvolveToClient(BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SendEvolveToClient(BAsyncResult<Object> asyncResult) {
			BRequest_EvolveIF_sendEvolveToClient req = new BRequest_EvolveIF_sendEvolveToClient();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SendEvolveToClientAsync(){
			BRequest_EvolveIF_sendEvolveToClient req = new BRequest_EvolveIF_sendEvolveToClient();			
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
