using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	public class BStub_PlantService : BStub, PlantServiceAuth, BSerializable {	
		
		public readonly static long serialVersionUID = 1954605928L;
		
		public BStub_PlantService(BTransport transport)
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
		
		
	}
}
