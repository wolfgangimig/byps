using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface RemoteInlineInstance : BRemote {
	
		void SetActor(com.wilutions.byps.test.api.inl.Actor act);
		void SetActor(com.wilutions.byps.test.api.inl.Actor act, BAsyncResult<Object> asyncResult) ;
		Task SetActorAsync(com.wilutions.byps.test.api.inl.Actor act);
		
		com.wilutions.byps.test.api.inl.Actor GetActor();
		void GetActor(BAsyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult) ;
		Task<com.wilutions.byps.test.api.inl.Actor> GetActorAsync();
		
		void SetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray);
		void SetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DArray1dimAsync(com.wilutions.byps.test.api.inl.Point2D[] pointArray);
		
		com.wilutions.byps.test.api.inl.Point2D[] GetPoint2DArray1dim();
		void GetPoint2DArray1dim(BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) ;
		Task<com.wilutions.byps.test.api.inl.Point2D[]> GetPoint2DArray1dimAsync();
		
		void SetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray);
		void SetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DArray4dimAsync(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray);
		
		com.wilutions.byps.test.api.inl.Point2D[,,,] GetPoint2DArray4dim();
		void GetPoint2DArray4dim(BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[,,,]> asyncResult) ;
		Task<com.wilutions.byps.test.api.inl.Point2D[,,,]> GetPoint2DArray4dimAsync();
		
		void SetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList);
		void SetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DListAsync(IList<com.wilutions.byps.test.api.inl.Point2D> pointList);
		
		IList<com.wilutions.byps.test.api.inl.Point2D> GetPoint2DList();
		void GetPoint2DList(BAsyncResult<IList<com.wilutions.byps.test.api.inl.Point2D>> asyncResult) ;
		Task<IList<com.wilutions.byps.test.api.inl.Point2D>> GetPoint2DListAsync();
		
		void SetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList);
		void SetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DListListAsync(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList);
		
		IList<IList<com.wilutions.byps.test.api.inl.Point2D>> GetPoint2DListList();
		void GetPoint2DListList(BAsyncResult<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> asyncResult) ;
		Task<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> GetPoint2DListListAsync();
		
		void SetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap);
		void SetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DMapAsync(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap);
		
		IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> GetPoint2DMap();
		void GetPoint2DMap(BAsyncResult<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>> asyncResult) ;
		Task<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>> GetPoint2DMapAsync();
		
		
	}
}  // end namespace
