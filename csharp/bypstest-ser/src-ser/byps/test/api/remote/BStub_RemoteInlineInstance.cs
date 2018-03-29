using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteInlineInstance : BStub, RemoteInlineInstance, BSerializable {	
		
		public readonly static long serialVersionUID = 567395951L;
		
		public BStub_RemoteInlineInstance(BTransport transport)
			: base(transport) {}			
		
		public virtual void SetActor(byps.test.api.inl.Actor act) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetActor(act, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetActor(byps.test.api.inl.Actor act, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setActor req = new BRequest_RemoteInlineInstance_setActor();			
			req.actValue = act;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetActorAsync(byps.test.api.inl.Actor act){
			BRequest_RemoteInlineInstance_setActor req = new BRequest_RemoteInlineInstance_setActor();			
			req.actValue = act;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual byps.test.api.inl.Actor GetActor() {
			BSyncResult<byps.test.api.inl.Actor> asyncResult = new BSyncResult<byps.test.api.inl.Actor>();			
			GetActor(BAsyncResultHelper.ToDelegate<byps.test.api.inl.Actor>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetActor(BAsyncResult<byps.test.api.inl.Actor> asyncResult) {
			BRequest_RemoteInlineInstance_getActor req = new BRequest_RemoteInlineInstance_getActor();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.inl.Actor> GetActorAsync(){
			BRequest_RemoteInlineInstance_getActor req = new BRequest_RemoteInlineInstance_getActor();			
			Task<byps.test.api.inl.Actor> task = Task<byps.test.api.inl.Actor>.Factory.FromAsync(transport.BeginSend<byps.test.api.inl.Actor>, transport.EndSend<byps.test.api.inl.Actor>, req, null);
			return await task;
		}
		
		public virtual void SetPoint2DArray1dim(byps.test.api.inl.Point2D[] pointArray) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DArray1dim(pointArray, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPoint2DArray1dim(byps.test.api.inl.Point2D[] pointArray, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DArray1dim req = new BRequest_RemoteInlineInstance_setPoint2DArray1dim();			
			req.pointArrayValue = pointArray;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DArray1dimAsync(byps.test.api.inl.Point2D[] pointArray){
			BRequest_RemoteInlineInstance_setPoint2DArray1dim req = new BRequest_RemoteInlineInstance_setPoint2DArray1dim();			
			req.pointArrayValue = pointArray;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual byps.test.api.inl.Point2D[] GetPoint2DArray1dim() {
			BSyncResult<byps.test.api.inl.Point2D[]> asyncResult = new BSyncResult<byps.test.api.inl.Point2D[]>();			
			GetPoint2DArray1dim(BAsyncResultHelper.ToDelegate<byps.test.api.inl.Point2D[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPoint2DArray1dim(BAsyncResult<byps.test.api.inl.Point2D[]> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DArray1dim req = new BRequest_RemoteInlineInstance_getPoint2DArray1dim();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.inl.Point2D[]> GetPoint2DArray1dimAsync(){
			BRequest_RemoteInlineInstance_getPoint2DArray1dim req = new BRequest_RemoteInlineInstance_getPoint2DArray1dim();			
			Task<byps.test.api.inl.Point2D[]> task = Task<byps.test.api.inl.Point2D[]>.Factory.FromAsync(transport.BeginSend<byps.test.api.inl.Point2D[]>, transport.EndSend<byps.test.api.inl.Point2D[]>, req, null);
			return await task;
		}
		
		public virtual void SetPoint2DArray4dim(byps.test.api.inl.Point2D[,,,] pointArray) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DArray4dim(pointArray, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPoint2DArray4dim(byps.test.api.inl.Point2D[,,,] pointArray, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DArray4dim req = new BRequest_RemoteInlineInstance_setPoint2DArray4dim();			
			req.pointArrayValue = pointArray;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DArray4dimAsync(byps.test.api.inl.Point2D[,,,] pointArray){
			BRequest_RemoteInlineInstance_setPoint2DArray4dim req = new BRequest_RemoteInlineInstance_setPoint2DArray4dim();			
			req.pointArrayValue = pointArray;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual byps.test.api.inl.Point2D[,,,] GetPoint2DArray4dim() {
			BSyncResult<byps.test.api.inl.Point2D[,,,]> asyncResult = new BSyncResult<byps.test.api.inl.Point2D[,,,]>();			
			GetPoint2DArray4dim(BAsyncResultHelper.ToDelegate<byps.test.api.inl.Point2D[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPoint2DArray4dim(BAsyncResult<byps.test.api.inl.Point2D[,,,]> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DArray4dim req = new BRequest_RemoteInlineInstance_getPoint2DArray4dim();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.inl.Point2D[,,,]> GetPoint2DArray4dimAsync(){
			BRequest_RemoteInlineInstance_getPoint2DArray4dim req = new BRequest_RemoteInlineInstance_getPoint2DArray4dim();			
			Task<byps.test.api.inl.Point2D[,,,]> task = Task<byps.test.api.inl.Point2D[,,,]>.Factory.FromAsync(transport.BeginSend<byps.test.api.inl.Point2D[,,,]>, transport.EndSend<byps.test.api.inl.Point2D[,,,]>, req, null);
			return await task;
		}
		
		public virtual void SetPoint2DList(IList<byps.test.api.inl.Point2D> pointList) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DList(pointList, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPoint2DList(IList<byps.test.api.inl.Point2D> pointList, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DList req = new BRequest_RemoteInlineInstance_setPoint2DList();			
			req.pointListValue = pointList;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DListAsync(IList<byps.test.api.inl.Point2D> pointList){
			BRequest_RemoteInlineInstance_setPoint2DList req = new BRequest_RemoteInlineInstance_setPoint2DList();			
			req.pointListValue = pointList;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<byps.test.api.inl.Point2D> GetPoint2DList() {
			BSyncResult<IList<byps.test.api.inl.Point2D>> asyncResult = new BSyncResult<IList<byps.test.api.inl.Point2D>>();			
			GetPoint2DList(BAsyncResultHelper.ToDelegate<IList<byps.test.api.inl.Point2D>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPoint2DList(BAsyncResult<IList<byps.test.api.inl.Point2D>> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DList req = new BRequest_RemoteInlineInstance_getPoint2DList();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<byps.test.api.inl.Point2D>> GetPoint2DListAsync(){
			BRequest_RemoteInlineInstance_getPoint2DList req = new BRequest_RemoteInlineInstance_getPoint2DList();			
			Task<IList<byps.test.api.inl.Point2D>> task = Task<IList<byps.test.api.inl.Point2D>>.Factory.FromAsync(transport.BeginSend<IList<byps.test.api.inl.Point2D>>, transport.EndSend<IList<byps.test.api.inl.Point2D>>, req, null);
			return await task;
		}
		
		public virtual void SetPoint2DListList(IList<IList<byps.test.api.inl.Point2D>> pointListList) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DListList(pointListList, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPoint2DListList(IList<IList<byps.test.api.inl.Point2D>> pointListList, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DListList req = new BRequest_RemoteInlineInstance_setPoint2DListList();			
			req.pointListListValue = pointListList;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DListListAsync(IList<IList<byps.test.api.inl.Point2D>> pointListList){
			BRequest_RemoteInlineInstance_setPoint2DListList req = new BRequest_RemoteInlineInstance_setPoint2DListList();			
			req.pointListListValue = pointListList;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<IList<byps.test.api.inl.Point2D>> GetPoint2DListList() {
			BSyncResult<IList<IList<byps.test.api.inl.Point2D>>> asyncResult = new BSyncResult<IList<IList<byps.test.api.inl.Point2D>>>();			
			GetPoint2DListList(BAsyncResultHelper.ToDelegate<IList<IList<byps.test.api.inl.Point2D>>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPoint2DListList(BAsyncResult<IList<IList<byps.test.api.inl.Point2D>>> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DListList req = new BRequest_RemoteInlineInstance_getPoint2DListList();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<IList<byps.test.api.inl.Point2D>>> GetPoint2DListListAsync(){
			BRequest_RemoteInlineInstance_getPoint2DListList req = new BRequest_RemoteInlineInstance_getPoint2DListList();			
			Task<IList<IList<byps.test.api.inl.Point2D>>> task = Task<IList<IList<byps.test.api.inl.Point2D>>>.Factory.FromAsync(transport.BeginSend<IList<IList<byps.test.api.inl.Point2D>>>, transport.EndSend<IList<IList<byps.test.api.inl.Point2D>>>, req, null);
			return await task;
		}
		
		public virtual void SetPoint2DMap(IDictionary<int,byps.test.api.inl.Point2D> pointMap) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPoint2DMap(pointMap, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPoint2DMap(IDictionary<int,byps.test.api.inl.Point2D> pointMap, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteInlineInstance_setPoint2DMap req = new BRequest_RemoteInlineInstance_setPoint2DMap();			
			req.pointMapValue = pointMap;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPoint2DMapAsync(IDictionary<int,byps.test.api.inl.Point2D> pointMap){
			BRequest_RemoteInlineInstance_setPoint2DMap req = new BRequest_RemoteInlineInstance_setPoint2DMap();			
			req.pointMapValue = pointMap;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IDictionary<int,byps.test.api.inl.Point2D> GetPoint2DMap() {
			BSyncResult<IDictionary<int,byps.test.api.inl.Point2D>> asyncResult = new BSyncResult<IDictionary<int,byps.test.api.inl.Point2D>>();			
			GetPoint2DMap(BAsyncResultHelper.ToDelegate<IDictionary<int,byps.test.api.inl.Point2D>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPoint2DMap(BAsyncResult<IDictionary<int,byps.test.api.inl.Point2D>> asyncResult) {
			BRequest_RemoteInlineInstance_getPoint2DMap req = new BRequest_RemoteInlineInstance_getPoint2DMap();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<int,byps.test.api.inl.Point2D>> GetPoint2DMapAsync(){
			BRequest_RemoteInlineInstance_getPoint2DMap req = new BRequest_RemoteInlineInstance_getPoint2DMap();			
			Task<IDictionary<int,byps.test.api.inl.Point2D>> task = Task<IDictionary<int,byps.test.api.inl.Point2D>>.Factory.FromAsync(transport.BeginSend<IDictionary<int,byps.test.api.inl.Point2D>>, transport.EndSend<IDictionary<int,byps.test.api.inl.Point2D>>, req, null);
			return await task;
		}
		
		
	}
}
