using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteArrayTypes23 : BRemote
	{
		int[] SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4);
		void async_SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4, BAsyncResult<int[]> asyncResult) ;
		IAsyncResult BeginSendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4, AsyncCallback callback, object state);
		int[] EndSendArraysInt(IAsyncResult asyncResult);
		
		String[] SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4);
		void async_SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4, BAsyncResult<String[]> asyncResult) ;
		IAsyncResult BeginSendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4, AsyncCallback callback, object state);
		String[] EndSendArraysString(IAsyncResult asyncResult);
		
		com.wilutions.byps.test.api.prim.PrimitiveTypes[] SendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4);
		void async_SendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4, BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) ;
		IAsyncResult BeginSendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4, AsyncCallback callback, object state);
		com.wilutions.byps.test.api.prim.PrimitiveTypes[] EndSendArraysClass(IAsyncResult asyncResult);
		
		Object[] SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4);
		void async_SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4, BAsyncResult<Object[]> asyncResult) ;
		IAsyncResult BeginSendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4, AsyncCallback callback, object state);
		Object[] EndSendArraysObject(IAsyncResult asyncResult);
		
		com.wilutions.byps.test.api.inl.Point2D[] SendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4);
		void async_SendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4, BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) ;
		IAsyncResult BeginSendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4, AsyncCallback callback, object state);
		com.wilutions.byps.test.api.inl.Point2D[] EndSendArraysInline(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
