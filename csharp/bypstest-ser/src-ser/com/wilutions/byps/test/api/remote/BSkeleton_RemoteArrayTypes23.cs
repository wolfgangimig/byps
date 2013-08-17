using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteArrayTypes23.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteArrayTypes23 : BSkeleton, RemoteArrayTypes23 {	
		
		public readonly static long serialVersionUID = 2081058997L;
		
		public virtual int[] SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4, BAsyncResult<int[]> asyncResult) {
			try {
				int[] ret = SendArraysInt(arr2, arr3, arr4);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public int[] EndSendArraysInt(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual String[] SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4, BAsyncResult<String[]> asyncResult) {
			try {
				String[] ret = SendArraysString(arr2, arr3, arr4);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public String[] EndSendArraysString(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual com.wilutions.byps.test.api.prim.PrimitiveTypes[] SendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4, BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) {
			try {
				com.wilutions.byps.test.api.prim.PrimitiveTypes[] ret = SendArraysClass(arr2, arr3, arr4);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.prim.PrimitiveTypes[] EndSendArraysClass(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual Object[] SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4, BAsyncResult<Object[]> asyncResult) {
			try {
				Object[] ret = SendArraysObject(arr2, arr3, arr4);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object[] EndSendArraysObject(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual com.wilutions.byps.test.api.inl.Point2D[] SendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4, BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) {
			try {
				com.wilutions.byps.test.api.inl.Point2D[] ret = SendArraysInline(arr2, arr3, arr4);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.inl.Point2D[] EndSendArraysInline(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		
	}
}
