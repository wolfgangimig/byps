using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteInlineInstance : BRemote {
	
		void SetActor(byps.test.api.inl.Actor act);
		void SetActor(byps.test.api.inl.Actor act, BAsyncResult<Object> asyncResult) ;
		Task SetActorAsync(byps.test.api.inl.Actor act);
		
		byps.test.api.inl.Actor GetActor();
		void GetActor(BAsyncResult<byps.test.api.inl.Actor> asyncResult) ;
		Task<byps.test.api.inl.Actor> GetActorAsync();
		
		void SetPoint2DArray1dim(byps.test.api.inl.Point2D[] pointArray);
		void SetPoint2DArray1dim(byps.test.api.inl.Point2D[] pointArray, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DArray1dimAsync(byps.test.api.inl.Point2D[] pointArray);
		
		byps.test.api.inl.Point2D[] GetPoint2DArray1dim();
		void GetPoint2DArray1dim(BAsyncResult<byps.test.api.inl.Point2D[]> asyncResult) ;
		Task<byps.test.api.inl.Point2D[]> GetPoint2DArray1dimAsync();
		
		void SetPoint2DArray4dim(byps.test.api.inl.Point2D[,,,] pointArray);
		void SetPoint2DArray4dim(byps.test.api.inl.Point2D[,,,] pointArray, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DArray4dimAsync(byps.test.api.inl.Point2D[,,,] pointArray);
		
		byps.test.api.inl.Point2D[,,,] GetPoint2DArray4dim();
		void GetPoint2DArray4dim(BAsyncResult<byps.test.api.inl.Point2D[,,,]> asyncResult) ;
		Task<byps.test.api.inl.Point2D[,,,]> GetPoint2DArray4dimAsync();
		
		void SetPoint2DList(IList<byps.test.api.inl.Point2D> pointList);
		void SetPoint2DList(IList<byps.test.api.inl.Point2D> pointList, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DListAsync(IList<byps.test.api.inl.Point2D> pointList);
		
		IList<byps.test.api.inl.Point2D> GetPoint2DList();
		void GetPoint2DList(BAsyncResult<IList<byps.test.api.inl.Point2D>> asyncResult) ;
		Task<IList<byps.test.api.inl.Point2D>> GetPoint2DListAsync();
		
		void SetPoint2DListList(IList<IList<byps.test.api.inl.Point2D>> pointListList);
		void SetPoint2DListList(IList<IList<byps.test.api.inl.Point2D>> pointListList, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DListListAsync(IList<IList<byps.test.api.inl.Point2D>> pointListList);
		
		IList<IList<byps.test.api.inl.Point2D>> GetPoint2DListList();
		void GetPoint2DListList(BAsyncResult<IList<IList<byps.test.api.inl.Point2D>>> asyncResult) ;
		Task<IList<IList<byps.test.api.inl.Point2D>>> GetPoint2DListListAsync();
		
		void SetPoint2DMap(IDictionary<int,byps.test.api.inl.Point2D> pointMap);
		void SetPoint2DMap(IDictionary<int,byps.test.api.inl.Point2D> pointMap, BAsyncResult<Object> asyncResult) ;
		Task SetPoint2DMapAsync(IDictionary<int,byps.test.api.inl.Point2D> pointMap);
		
		IDictionary<int,byps.test.api.inl.Point2D> GetPoint2DMap();
		void GetPoint2DMap(BAsyncResult<IDictionary<int,byps.test.api.inl.Point2D>> asyncResult) ;
		Task<IDictionary<int,byps.test.api.inl.Point2D>> GetPoint2DMapAsync();
		
		
	}
}  // end namespace
