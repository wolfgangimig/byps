using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BStub_LemonService : BStub, LemonServiceAuth, BSerializable {	
		
		public readonly static long serialVersionUID = 617356599L;
		
		public BStub_LemonService(BTransport transport)
			: base(transport) {}			
		
		public String Grow() {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			GrowAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GrowAsync(BAsyncResult<String> asyncResult) {
			BRequest_PlantService_grow req = new BRequest_PlantService_grow();			
			BAsyncResultReceiveMethod<String> outerResult = new BAsyncResultReceiveMethod<String>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGrow(AsyncCallback callback, object state){
			BAsyncProgModel<String> _byps_ret = new BAsyncProgModel<String>(callback, state);
			GrowAsync(_byps_ret);
			return _byps_ret;
		}
		public String EndGrow(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<String>)asyncResult).Result;
		}
		public async Task<String> GrowTask() {
			return await Task<String>.Factory.FromAsync(BeginGrow, EndGrow, null);
		}
		
		public String Pick(String fromTree) {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			PickAsync(fromTree, asyncResult);
			return asyncResult.GetResult();			
		}
		public void PickAsync(String fromTree, BAsyncResult<String> asyncResult) {
			BRequest_LemonService_pick req = new BRequest_LemonService_pick();			
			req._fromTree = fromTree;
			BAsyncResultReceiveMethod<String> outerResult = new BAsyncResultReceiveMethod<String>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginPick(String fromTree, AsyncCallback callback, object state){
			BAsyncProgModel<String> _byps_ret = new BAsyncProgModel<String>(callback, state);
			PickAsync(fromTree, _byps_ret);
			return _byps_ret;
		}
		public String EndPick(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<String>)asyncResult).Result;
		}
		public async Task<String> PickTask(String fromTree) {
			return await Task<String>.Factory.FromAsync(BeginPick, EndPick, fromTree, null);
		}
		
		public String Squeeze() {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			SqueezeAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void SqueezeAsync(BAsyncResult<String> asyncResult) {
			BRequest_FruitService_squeeze req = new BRequest_FruitService_squeeze();			
			BAsyncResultReceiveMethod<String> outerResult = new BAsyncResultReceiveMethod<String>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSqueeze(AsyncCallback callback, object state){
			BAsyncProgModel<String> _byps_ret = new BAsyncProgModel<String>(callback, state);
			SqueezeAsync(_byps_ret);
			return _byps_ret;
		}
		public String EndSqueeze(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<String>)asyncResult).Result;
		}
		public async Task<String> SqueezeTask() {
			return await Task<String>.Factory.FromAsync(BeginSqueeze, EndSqueeze, null);
		}
		
		
	}
}
