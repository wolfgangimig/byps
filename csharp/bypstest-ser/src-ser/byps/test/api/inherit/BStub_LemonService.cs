using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	public class BStub_LemonService : BStub, LemonServiceAuth, BSerializable {	
		
		public readonly static long serialVersionUID = 605543968L;
		
		public BStub_LemonService(BTransport transport)
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
		
		public virtual String Pick(byps.test.api.auth.SessionInfo sess, String fromTree) {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			Pick(sess, fromTree, BAsyncResultHelper.ToDelegate<String>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void Pick(byps.test.api.auth.SessionInfo sess, String fromTree, BAsyncResult<String> asyncResult) {
			BRequest_LemonService_pick req = new BRequest_LemonService_pick();			
			req.sessValue = sess;
			req.fromTreeValue = fromTree;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String> PickAsync(byps.test.api.auth.SessionInfo sess, String fromTree){
			BRequest_LemonService_pick req = new BRequest_LemonService_pick();			
			req.sessValue = sess;
			req.fromTreeValue = fromTree;
			Task<String> task = Task<String>.Factory.FromAsync(transport.BeginSend<String>, transport.EndSend<String>, req, null);
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
