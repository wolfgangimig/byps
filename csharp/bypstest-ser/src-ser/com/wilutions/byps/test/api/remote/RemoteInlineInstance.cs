using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface RemoteInlineInstance : BRemote {
	
		void SetActor(com.wilutions.byps.test.api.inl.Actor act);
		void SetActorAsync(com.wilutions.byps.test.api.inl.Actor act, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetActor(com.wilutions.byps.test.api.inl.Actor act, AsyncCallback callback, object state);
		Object EndSetActor(IAsyncResult asyncResult);
		
		com.wilutions.byps.test.api.inl.Actor GetActor();
		void GetActorAsync(BAsyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult) ;
		IAsyncResult BeginGetActor(AsyncCallback callback, object state);
		com.wilutions.byps.test.api.inl.Actor EndGetActor(IAsyncResult asyncResult);
		
		void SetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray);
		void SetPoint2DArray1dimAsync(com.wilutions.byps.test.api.inl.Point2D[] pointArray, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray, AsyncCallback callback, object state);
		Object EndSetPoint2DArray1dim(IAsyncResult asyncResult);
		
		com.wilutions.byps.test.api.inl.Point2D[] GetPoint2DArray1dim();
		void GetPoint2DArray1dimAsync(BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) ;
		IAsyncResult BeginGetPoint2DArray1dim(AsyncCallback callback, object state);
		com.wilutions.byps.test.api.inl.Point2D[] EndGetPoint2DArray1dim(IAsyncResult asyncResult);
		
		void SetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray);
		void SetPoint2DArray4dimAsync(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray, AsyncCallback callback, object state);
		Object EndSetPoint2DArray4dim(IAsyncResult asyncResult);
		
		com.wilutions.byps.test.api.inl.Point2D[,,,] GetPoint2DArray4dim();
		void GetPoint2DArray4dimAsync(BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[,,,]> asyncResult) ;
		IAsyncResult BeginGetPoint2DArray4dim(AsyncCallback callback, object state);
		com.wilutions.byps.test.api.inl.Point2D[,,,] EndGetPoint2DArray4dim(IAsyncResult asyncResult);
		
		void SetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList);
		void SetPoint2DListAsync(IList<com.wilutions.byps.test.api.inl.Point2D> pointList, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList, AsyncCallback callback, object state);
		Object EndSetPoint2DList(IAsyncResult asyncResult);
		
		IList<com.wilutions.byps.test.api.inl.Point2D> GetPoint2DList();
		void GetPoint2DListAsync(BAsyncResult<IList<com.wilutions.byps.test.api.inl.Point2D>> asyncResult) ;
		IAsyncResult BeginGetPoint2DList(AsyncCallback callback, object state);
		IList<com.wilutions.byps.test.api.inl.Point2D> EndGetPoint2DList(IAsyncResult asyncResult);
		
		void SetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList);
		void SetPoint2DListListAsync(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList, AsyncCallback callback, object state);
		Object EndSetPoint2DListList(IAsyncResult asyncResult);
		
		IList<IList<com.wilutions.byps.test.api.inl.Point2D>> GetPoint2DListList();
		void GetPoint2DListListAsync(BAsyncResult<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> asyncResult) ;
		IAsyncResult BeginGetPoint2DListList(AsyncCallback callback, object state);
		IList<IList<com.wilutions.byps.test.api.inl.Point2D>> EndGetPoint2DListList(IAsyncResult asyncResult);
		
		void SetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap);
		void SetPoint2DMapAsync(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap, AsyncCallback callback, object state);
		Object EndSetPoint2DMap(IAsyncResult asyncResult);
		
		IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> GetPoint2DMap();
		void GetPoint2DMapAsync(BAsyncResult<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>> asyncResult) ;
		IAsyncResult BeginGetPoint2DMap(AsyncCallback callback, object state);
		IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> EndGetPoint2DMap(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
