using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.inherit
{
	
	public class BStub_BioLemonService : BStub, BioLemonServiceAuth, BSerializable {	
		
		public readonly static long serialVersionUID = 474058508L;
		
		public BStub_BioLemonService(BTransport transport)
			: base(transport) {}			
		
		public bool Certify(String param) {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			Certify(param, BAsyncResultHelper.ToDelegate<bool>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void Certify(String param, BAsyncResult<bool> asyncResult) {
			BRequest_BioFruitService_certify req = new BRequest_BioFruitService_certify();			
			req._param = param;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<bool> CertifyAsync(String param){
			BRequest_BioFruitService_certify req = new BRequest_BioFruitService_certify();			
			req._param = param;
			Task<bool> task = Task<bool>.Factory.FromAsync(transport.BeginSend<bool>, transport.EndSend<bool>, req, null);
			return await task;
		}
		
		public String Grow() {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			Grow(BAsyncResultHelper.ToDelegate<String>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void Grow(BAsyncResult<String> asyncResult) {
			BRequest_PlantService_grow req = new BRequest_PlantService_grow();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String> GrowAsync(){
			BRequest_PlantService_grow req = new BRequest_PlantService_grow();			
			Task<String> task = Task<String>.Factory.FromAsync(transport.BeginSend<String>, transport.EndSend<String>, req, null);
			return await task;
		}
		
		public String Squeeze() {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			Squeeze(BAsyncResultHelper.ToDelegate<String>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void Squeeze(BAsyncResult<String> asyncResult) {
			BRequest_FruitService_squeeze req = new BRequest_FruitService_squeeze();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String> SqueezeAsync(){
			BRequest_FruitService_squeeze req = new BRequest_FruitService_squeeze();			
			Task<String> task = Task<String>.Factory.FromAsync(transport.BeginSend<String>, transport.EndSend<String>, req, null);
			return await task;
		}
		
		public String Pick(byps.test.api.auth.SessionInfo sess, String fromTree) {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			Pick(sess, fromTree, BAsyncResultHelper.ToDelegate<String>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void Pick(byps.test.api.auth.SessionInfo sess, String fromTree, BAsyncResult<String> asyncResult) {
			BRequest_LemonService_pick req = new BRequest_LemonService_pick();			
			req._sess = sess;
			req._fromTree = fromTree;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String> PickAsync(byps.test.api.auth.SessionInfo sess, String fromTree){
			BRequest_LemonService_pick req = new BRequest_LemonService_pick();			
			req._sess = sess;
			req._fromTree = fromTree;
			Task<String> task = Task<String>.Factory.FromAsync(transport.BeginSend<String>, transport.EndSend<String>, req, null);
			return await task;
		}
		
		public int UseParing() {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			UseParing(BAsyncResultHelper.ToDelegate<int>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void UseParing(BAsyncResult<int> asyncResult) {
			BRequest_BioLemonService_useParing req = new BRequest_BioLemonService_useParing();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int> UseParingAsync(){
			BRequest_BioLemonService_useParing req = new BRequest_BioLemonService_useParing();			
			Task<int> task = Task<int>.Factory.FromAsync(transport.BeginSend<int>, transport.EndSend<int>, req, null);
			return await task;
		}
		
		
	}
}
