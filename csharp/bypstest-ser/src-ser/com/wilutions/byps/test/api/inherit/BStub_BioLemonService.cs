using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BStub_BioLemonService : BStub, BioLemonServiceAuth, BSerializable {	
		
		public readonly static long serialVersionUID = 1992245333L;
		
		public BStub_BioLemonService(BTransport transport)
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
		
		public int UseParing() {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			UseParingAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void UseParingAsync(BAsyncResult<int> asyncResult) {
			BRequest_BioLemonService_useParing req = new BRequest_BioLemonService_useParing();			
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginUseParing(AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			UseParingAsync(_byps_ret);
			return _byps_ret;
		}
		public int EndUseParing(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		public async Task<int> UseParingTask() {
			return await Task<int>.Factory.FromAsync(BeginUseParing, EndUseParing, null);
		}
		
		public bool Certify(String param) {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			CertifyAsync(param, asyncResult);
			return asyncResult.GetResult();			
		}
		public void CertifyAsync(String param, BAsyncResult<bool> asyncResult) {
			BRequest_BioFruitService_certify req = new BRequest_BioFruitService_certify();			
			req._param = param;
			BAsyncResultReceiveMethod<bool> outerResult = new BAsyncResultReceiveMethod<bool>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginCertify(String param, AsyncCallback callback, object state){
			BAsyncProgModel<bool> _byps_ret = new BAsyncProgModel<bool>(callback, state);
			CertifyAsync(param, _byps_ret);
			return _byps_ret;
		}
		public bool EndCertify(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<bool>)asyncResult).Result;
		}
		public async Task<bool> CertifyTask(String param) {
			return await Task<bool>.Factory.FromAsync(BeginCertify, EndCertify, param, null);
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
