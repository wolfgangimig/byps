using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteInlineInstance : BStub, RemoteInlineInstance, BSerializable {	
		
		public readonly static long serialVersionUID = 1206670536L;
		
		public BStub_RemoteInlineInstance(BTransport transport)
			: base(transport) {}			
		
		public void SetActor(com.wilutions.byps.test.api.inl.Actor act) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetActor(act, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetActor(com.wilutions.byps.test.api.inl.Actor act, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setActor req = new BRequest_RemoteInlineInstance_setActor();			
			req._act = act;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetActorAsync(com.wilutions.byps.test.api.inl.Actor act){
			BRequest_RemoteInlineInstance_setActor req = new BRequest_RemoteInlineInstance_setActor();			
			req._act = act;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public com.wilutions.byps.test.api.inl.Actor GetActor() {
			BSyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult = new BSyncResult<com.wilutions.byps.test.api.inl.Actor>();			
			GetActor(BAsyncResultHelper.ToDelegate<com.wilutions.byps.test.api.inl.Actor>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetActor(BAsyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult) {
			BRequest_RemoteInlineInstance_getActor req = new BRequest_RemoteInlineInstance_getActor();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<com.wilutions.byps.test.api.inl.Actor> GetActorAsync(){
			BRequest_RemoteInlineInstance_getActor req = new BRequest_RemoteInlineInstance_getActor();			
			Task<com.wilutions.byps.test.api.inl.Actor> task = Task<com.wilutions.byps.test.api.inl.Actor>.Factory.FromAsync(transport.BeginSend<com.wilutions.byps.test.api.inl.Actor>, transport.EndSend<com.wilutions.byps.test.api.inl.Actor>, req, null);
			return await task;
		}
		
		public void SetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DArray1dim(pointArray, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DArray1dim req = new BRequest_RemoteInlineInstance_setPoint2DArray1dim();			
			req._pointArray = pointArray;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DArray1dimAsync(com.wilutions.byps.test.api.inl.Point2D[] pointArray){
			BRequest_RemoteInlineInstance_setPoint2DArray1dim req = new BRequest_RemoteInlineInstance_setPoint2DArray1dim();			
			req._pointArray = pointArray;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public com.wilutions.byps.test.api.inl.Point2D[] GetPoint2DArray1dim() {
			BSyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult = new BSyncResult<com.wilutions.byps.test.api.inl.Point2D[]>();			
			GetPoint2DArray1dim(BAsyncResultHelper.ToDelegate<com.wilutions.byps.test.api.inl.Point2D[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPoint2DArray1dim(BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DArray1dim req = new BRequest_RemoteInlineInstance_getPoint2DArray1dim();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<com.wilutions.byps.test.api.inl.Point2D[]> GetPoint2DArray1dimAsync(){
			BRequest_RemoteInlineInstance_getPoint2DArray1dim req = new BRequest_RemoteInlineInstance_getPoint2DArray1dim();			
			Task<com.wilutions.byps.test.api.inl.Point2D[]> task = Task<com.wilutions.byps.test.api.inl.Point2D[]>.Factory.FromAsync(transport.BeginSend<com.wilutions.byps.test.api.inl.Point2D[]>, transport.EndSend<com.wilutions.byps.test.api.inl.Point2D[]>, req, null);
			return await task;
		}
		
		public void SetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DArray4dim(pointArray, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DArray4dim req = new BRequest_RemoteInlineInstance_setPoint2DArray4dim();			
			req._pointArray = pointArray;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DArray4dimAsync(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray){
			BRequest_RemoteInlineInstance_setPoint2DArray4dim req = new BRequest_RemoteInlineInstance_setPoint2DArray4dim();			
			req._pointArray = pointArray;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public com.wilutions.byps.test.api.inl.Point2D[,,,] GetPoint2DArray4dim() {
			BSyncResult<com.wilutions.byps.test.api.inl.Point2D[,,,]> asyncResult = new BSyncResult<com.wilutions.byps.test.api.inl.Point2D[,,,]>();			
			GetPoint2DArray4dim(BAsyncResultHelper.ToDelegate<com.wilutions.byps.test.api.inl.Point2D[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPoint2DArray4dim(BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[,,,]> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DArray4dim req = new BRequest_RemoteInlineInstance_getPoint2DArray4dim();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<com.wilutions.byps.test.api.inl.Point2D[,,,]> GetPoint2DArray4dimAsync(){
			BRequest_RemoteInlineInstance_getPoint2DArray4dim req = new BRequest_RemoteInlineInstance_getPoint2DArray4dim();			
			Task<com.wilutions.byps.test.api.inl.Point2D[,,,]> task = Task<com.wilutions.byps.test.api.inl.Point2D[,,,]>.Factory.FromAsync(transport.BeginSend<com.wilutions.byps.test.api.inl.Point2D[,,,]>, transport.EndSend<com.wilutions.byps.test.api.inl.Point2D[,,,]>, req, null);
			return await task;
		}
		
		public void SetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DList(pointList, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DList req = new BRequest_RemoteInlineInstance_setPoint2DList();			
			req._pointList = pointList;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DListAsync(IList<com.wilutions.byps.test.api.inl.Point2D> pointList){
			BRequest_RemoteInlineInstance_setPoint2DList req = new BRequest_RemoteInlineInstance_setPoint2DList();			
			req._pointList = pointList;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<com.wilutions.byps.test.api.inl.Point2D> GetPoint2DList() {
			BSyncResult<IList<com.wilutions.byps.test.api.inl.Point2D>> asyncResult = new BSyncResult<IList<com.wilutions.byps.test.api.inl.Point2D>>();			
			GetPoint2DList(BAsyncResultHelper.ToDelegate<IList<com.wilutions.byps.test.api.inl.Point2D>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPoint2DList(BAsyncResult<IList<com.wilutions.byps.test.api.inl.Point2D>> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DList req = new BRequest_RemoteInlineInstance_getPoint2DList();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<IList<com.wilutions.byps.test.api.inl.Point2D>> GetPoint2DListAsync(){
			BRequest_RemoteInlineInstance_getPoint2DList req = new BRequest_RemoteInlineInstance_getPoint2DList();			
			Task<IList<com.wilutions.byps.test.api.inl.Point2D>> task = Task<IList<com.wilutions.byps.test.api.inl.Point2D>>.Factory.FromAsync(transport.BeginSend<IList<com.wilutions.byps.test.api.inl.Point2D>>, transport.EndSend<IList<com.wilutions.byps.test.api.inl.Point2D>>, req, null);
			return await task;
		}
		
		public void SetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DListList(pointListList, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DListList req = new BRequest_RemoteInlineInstance_setPoint2DListList();			
			req._pointListList = pointListList;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DListListAsync(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList){
			BRequest_RemoteInlineInstance_setPoint2DListList req = new BRequest_RemoteInlineInstance_setPoint2DListList();			
			req._pointListList = pointListList;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<IList<com.wilutions.byps.test.api.inl.Point2D>> GetPoint2DListList() {
			BSyncResult<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> asyncResult = new BSyncResult<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>>();			
			GetPoint2DListList(BAsyncResultHelper.ToDelegate<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPoint2DListList(BAsyncResult<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DListList req = new BRequest_RemoteInlineInstance_getPoint2DListList();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> GetPoint2DListListAsync(){
			BRequest_RemoteInlineInstance_getPoint2DListList req = new BRequest_RemoteInlineInstance_getPoint2DListList();			
			Task<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> task = Task<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>>.Factory.FromAsync(transport.BeginSend<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>>, transport.EndSend<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>>, req, null);
			return await task;
		}
		
		public void SetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DMap(pointMap, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DMap req = new BRequest_RemoteInlineInstance_setPoint2DMap();			
			req._pointMap = pointMap;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DMapAsync(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap){
			BRequest_RemoteInlineInstance_setPoint2DMap req = new BRequest_RemoteInlineInstance_setPoint2DMap();			
			req._pointMap = pointMap;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> GetPoint2DMap() {
			BSyncResult<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>> asyncResult = new BSyncResult<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>>();			
			GetPoint2DMap(BAsyncResultHelper.ToDelegate<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPoint2DMap(BAsyncResult<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DMap req = new BRequest_RemoteInlineInstance_getPoint2DMap();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>> GetPoint2DMapAsync(){
			BRequest_RemoteInlineInstance_getPoint2DMap req = new BRequest_RemoteInlineInstance_getPoint2DMap();			
			Task<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>> task = Task<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>>.Factory.FromAsync(transport.BeginSend<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>>, transport.EndSend<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>>, req, null);
			return await task;
		}
		
		
	}
}
