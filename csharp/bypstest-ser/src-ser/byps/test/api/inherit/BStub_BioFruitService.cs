using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	public class BStub_BioFruitService : BStub, BioFruitServiceAuth, BSerializable {	
		
		public readonly static long serialVersionUID = 612235846L;
		
		public BStub_BioFruitService(BTransport transport)
			: base(transport) {}			
		
		public virtual String Grow() {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			Grow(BAsyncResultHelper.ToDelegate<String>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void Grow(BAsyncResult<String> asyncResult) {
			BRequest_PlantService_grow req = new BRequest_PlantService_grow();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String> GrowAsync(){
			BRequest_PlantService_grow req = new BRequest_PlantService_grow();			
			Task<String> task = Task<String>.Factory.FromAsync(transport.BeginSend<String>, transport.EndSend<String>, req, null);
			return await task;
		}
		
		public virtual bool Certify(String param) {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			Certify(param, BAsyncResultHelper.ToDelegate<bool>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void Certify(String param, BAsyncResult<bool> asyncResult) {
			BRequest_BioFruitService_certify req = new BRequest_BioFruitService_certify();			
			req.paramValue = param;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<bool> CertifyAsync(String param){
			BRequest_BioFruitService_certify req = new BRequest_BioFruitService_certify();			
			req.paramValue = param;
			Task<bool> task = Task<bool>.Factory.FromAsync(transport.BeginSend<bool>, transport.EndSend<bool>, req, null);
			return await task;
		}
		
		public virtual String Squeeze() {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			Squeeze(BAsyncResultHelper.ToDelegate<String>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void Squeeze(BAsyncResult<String> asyncResult) {
			BRequest_FruitService_squeeze req = new BRequest_FruitService_squeeze();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String> SqueezeAsync(){
			BRequest_FruitService_squeeze req = new BRequest_FruitService_squeeze();			
			Task<String> task = Task<String>.Factory.FromAsync(transport.BeginSend<String>, transport.EndSend<String>, req, null);
			return await task;
		}
		
		
	}
}
