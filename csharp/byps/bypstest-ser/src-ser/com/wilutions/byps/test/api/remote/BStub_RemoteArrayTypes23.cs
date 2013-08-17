using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteArrayTypes23 : BStub, RemoteArrayTypes23, BSerializable {	
		
		public readonly static long serialVersionUID = 2081058997L;
		
		public BStub_RemoteArrayTypes23(BTransport transport)
			: base(transport) {}			
		
		public int[] SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4) {
			BSyncResult<int[]> asyncResult = new BSyncResult<int[]>();			
			async_SendArraysInt(arr2, arr3, arr4, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4, BAsyncResult<int[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysInt req = new BRequest_RemoteArrayTypes23_sendArraysInt();			
			req._arr2 = arr2;
			req._arr3 = arr3;
			req._arr4 = arr4;
			BAsyncResultReceiveMethod<int[]> outerResult = new BAsyncResultReceiveMethod<int[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4, AsyncCallback callback, object state){
			BAsyncProgModel<int[]> _byps_ret = new BAsyncProgModel<int[]>(callback, state);
			async_SendArraysInt(arr2, arr3, arr4, _byps_ret);
			return _byps_ret;
		}
		public 		int[] EndSendArraysInt(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int[]>)asyncResult).Result;
		}
		
		public String[] SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4) {
			BSyncResult<String[]> asyncResult = new BSyncResult<String[]>();			
			async_SendArraysString(arr2, arr3, arr4, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4, BAsyncResult<String[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysString req = new BRequest_RemoteArrayTypes23_sendArraysString();			
			req._arr2 = arr2;
			req._arr3 = arr3;
			req._arr4 = arr4;
			BAsyncResultReceiveMethod<String[]> outerResult = new BAsyncResultReceiveMethod<String[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4, AsyncCallback callback, object state){
			BAsyncProgModel<String[]> _byps_ret = new BAsyncProgModel<String[]>(callback, state);
			async_SendArraysString(arr2, arr3, arr4, _byps_ret);
			return _byps_ret;
		}
		public 		String[] EndSendArraysString(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<String[]>)asyncResult).Result;
		}
		
		public com.wilutions.byps.test.api.prim.PrimitiveTypes[] SendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4) {
			BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult = new BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>();			
			async_SendArraysClass(arr2, arr3, arr4, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_SendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4, BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysClass req = new BRequest_RemoteArrayTypes23_sendArraysClass();			
			req._arr2 = arr2;
			req._arr3 = arr3;
			req._arr4 = arr4;
			BAsyncResultReceiveMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSendArraysClass(com.wilutions.byps.test.api.prim.PrimitiveTypes[,] arr2, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,] arr3, com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] arr4, AsyncCallback callback, object state){
			BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> _byps_ret = new BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>(callback, state);
			async_SendArraysClass(arr2, arr3, arr4, _byps_ret);
			return _byps_ret;
		}
		public 		com.wilutions.byps.test.api.prim.PrimitiveTypes[] EndSendArraysClass(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>)asyncResult).Result;
		}
		
		public Object[] SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4) {
			BSyncResult<Object[]> asyncResult = new BSyncResult<Object[]>();			
			async_SendArraysObject(arr2, arr3, arr4, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4, BAsyncResult<Object[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysObject req = new BRequest_RemoteArrayTypes23_sendArraysObject();			
			req._arr2 = arr2;
			req._arr3 = arr3;
			req._arr4 = arr4;
			BAsyncResultReceiveMethod<Object[]> outerResult = new BAsyncResultReceiveMethod<Object[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4, AsyncCallback callback, object state){
			BAsyncProgModel<Object[]> _byps_ret = new BAsyncProgModel<Object[]>(callback, state);
			async_SendArraysObject(arr2, arr3, arr4, _byps_ret);
			return _byps_ret;
		}
		public 		Object[] EndSendArraysObject(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object[]>)asyncResult).Result;
		}
		
		public com.wilutions.byps.test.api.inl.Point2D[] SendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4) {
			BSyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult = new BSyncResult<com.wilutions.byps.test.api.inl.Point2D[]>();			
			async_SendArraysInline(arr2, arr3, arr4, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_SendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4, BAsyncResult<com.wilutions.byps.test.api.inl.Point2D[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysInline req = new BRequest_RemoteArrayTypes23_sendArraysInline();			
			req._arr2 = arr2;
			req._arr3 = arr3;
			req._arr4 = arr4;
			BAsyncResultReceiveMethod<com.wilutions.byps.test.api.inl.Point2D[]> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.inl.Point2D[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSendArraysInline(com.wilutions.byps.test.api.inl.Point2D[,] arr2, com.wilutions.byps.test.api.inl.Point2D[,,] arr3, com.wilutions.byps.test.api.inl.Point2D[,,,] arr4, AsyncCallback callback, object state){
			BAsyncProgModel<com.wilutions.byps.test.api.inl.Point2D[]> _byps_ret = new BAsyncProgModel<com.wilutions.byps.test.api.inl.Point2D[]>(callback, state);
			async_SendArraysInline(arr2, arr3, arr4, _byps_ret);
			return _byps_ret;
		}
		public 		com.wilutions.byps.test.api.inl.Point2D[] EndSendArraysInline(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<com.wilutions.byps.test.api.inl.Point2D[]>)asyncResult).Result;
		}
		
		
	}
}
