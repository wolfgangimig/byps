using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BStub_FruitService : BStub, FruitServiceAuth, BSerializable {	
		
		public readonly static long serialVersionUID = 506940662L;
		
		public BStub_FruitService(BTransport transport)
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
