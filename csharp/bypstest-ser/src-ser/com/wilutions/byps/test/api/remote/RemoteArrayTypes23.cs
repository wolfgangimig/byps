using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface RemoteArrayTypes23 : BRemote {
	
		int[] SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4);
		void SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4, BAsyncResult<int[]> asyncResult) ;
		Task<int[]> SendArraysIntAsync(int[,] arr2, int[,,] arr3, int[,,,] arr4);
		
		String[] SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4);
		void SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4, BAsyncResult<String[]> asyncResult) ;
		Task<String[]> SendArraysStringAsync(String[,] arr2, String[,,] arr3, String[,,,] arr4);
		
		com.wilutions.byps.test.api.prim.PrimitiveTypes[] SendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4);
		void SendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4, BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) ;
		Task<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> SendArraysClassAsync(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4);
		
		Object[] SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4);
		void SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4, BAsyncResult<Object[]> asyncResult) ;
		Task<Object[]> SendArraysObjectAsync(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4);
		
		com.wilutions.byps.test.api.inl.Point2D[] SendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4);
		void SendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4, BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) ;
		Task<com.wilutions.byps.test.api.inl.Point2D[]> SendArraysInlineAsync(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4);
		
		
	}
}  // end namespace
