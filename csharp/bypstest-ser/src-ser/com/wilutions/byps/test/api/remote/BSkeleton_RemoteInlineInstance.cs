using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteInlineInstance.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteInlineInstance : BSkeleton, RemoteInlineInstance {	
		
		public readonly static long serialVersionUID = 1206670536L;
		
		public virtual void SetActor(com.wilutions.byps.test.api.inl.Actor act) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetActor(com.wilutions.byps.test.api.inl.Actor act, BAsyncResult<Object> asyncResult) {
			try {
				SetActor(act);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetActor(com.wilutions.byps.test.api.inl.Actor act, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetActor(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual com.wilutions.byps.test.api.inl.Actor GetActor() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetActor(BAsyncResult<com.wilutions.byps.test.api.inl.Actor> asyncResult) {
			try {
				com.wilutions.byps.test.api.inl.Actor ret = GetActor();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetActor(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.inl.Actor EndGetActor(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray, BAsyncResult<Object> asyncResult) {
			try {
				SetPoint2DArray1dim(pointArray);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPoint2DArray1dim(com.wilutions.byps.test.api.inl.Point2D[] pointArray, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetPoint2DArray1dim(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual com.wilutions.byps.test.api.inl.Point2D[] GetPoint2DArray1dim() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPoint2DArray1dim(BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) {
			try {
				com.wilutions.byps.test.api.inl.Point2D[] ret = GetPoint2DArray1dim();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPoint2DArray1dim(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.inl.Point2D[] EndGetPoint2DArray1dim(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray, BAsyncResult<Object> asyncResult) {
			try {
				SetPoint2DArray4dim(pointArray);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPoint2DArray4dim(com.wilutions.byps.test.api.inl.Point2D[,,,] pointArray, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetPoint2DArray4dim(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual com.wilutions.byps.test.api.inl.Point2D[,,,] GetPoint2DArray4dim() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPoint2DArray4dim(BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[,,,]> asyncResult) {
			try {
				com.wilutions.byps.test.api.inl.Point2D[,,,] ret = GetPoint2DArray4dim();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPoint2DArray4dim(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.inl.Point2D[,,,] EndGetPoint2DArray4dim(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList, BAsyncResult<Object> asyncResult) {
			try {
				SetPoint2DList(pointList);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPoint2DList(IList<com.wilutions.byps.test.api.inl.Point2D> pointList, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetPoint2DList(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual IList<com.wilutions.byps.test.api.inl.Point2D> GetPoint2DList() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPoint2DList(BAsyncResult<IList<com.wilutions.byps.test.api.inl.Point2D>> asyncResult) {
			try {
				IList<com.wilutions.byps.test.api.inl.Point2D> ret = GetPoint2DList();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPoint2DList(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public IList<com.wilutions.byps.test.api.inl.Point2D> EndGetPoint2DList(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList, BAsyncResult<Object> asyncResult) {
			try {
				SetPoint2DListList(pointListList);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPoint2DListList(IList<IList<com.wilutions.byps.test.api.inl.Point2D>> pointListList, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetPoint2DListList(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual IList<IList<com.wilutions.byps.test.api.inl.Point2D>> GetPoint2DListList() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPoint2DListList(BAsyncResult<IList<IList<com.wilutions.byps.test.api.inl.Point2D>>> asyncResult) {
			try {
				IList<IList<com.wilutions.byps.test.api.inl.Point2D>> ret = GetPoint2DListList();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPoint2DListList(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public IList<IList<com.wilutions.byps.test.api.inl.Point2D>> EndGetPoint2DListList(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap, BAsyncResult<Object> asyncResult) {
			try {
				SetPoint2DMap(pointMap);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPoint2DMap(IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> pointMap, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetPoint2DMap(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> GetPoint2DMap() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPoint2DMap(BAsyncResult<IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>> asyncResult) {
			try {
				IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> ret = GetPoint2DMap();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPoint2DMap(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public IDictionary<int,com.wilutions.byps.test.api.inl.Point2D> EndGetPoint2DMap(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
