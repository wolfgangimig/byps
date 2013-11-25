using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteArrayTypes23 : BStub, RemoteArrayTypes23, BSerializable {	
		
		public readonly static long serialVersionUID = 964138163L;
		
		public BStub_RemoteArrayTypes23(BTransport transport)
			: base(transport) {}			
		
		public virtual int[] SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4) {
			BSyncResult<int[]> asyncResult = new BSyncResult<int[]>();			
			SendArraysInt(arr2, arr3, arr4, BAsyncResultHelper.ToDelegate<int[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void SendArraysInt(int[,] arr2, int[,,] arr3, int[,,,] arr4, BAsyncResult<int[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysInt req = new BRequest_RemoteArrayTypes23_sendArraysInt();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int[]> SendArraysIntAsync(int[,] arr2, int[,,] arr3, int[,,,] arr4){
			BRequest_RemoteArrayTypes23_sendArraysInt req = new BRequest_RemoteArrayTypes23_sendArraysInt();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			Task<int[]> task = Task<int[]>.Factory.FromAsync(transport.BeginSend<int[]>, transport.EndSend<int[]>, req, null);
			return await task;
		}
		
		public virtual String[] SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4) {
			BSyncResult<String[]> asyncResult = new BSyncResult<String[]>();			
			SendArraysString(arr2, arr3, arr4, BAsyncResultHelper.ToDelegate<String[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void SendArraysString(String[,] arr2, String[,,] arr3, String[,,,] arr4, BAsyncResult<String[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysString req = new BRequest_RemoteArrayTypes23_sendArraysString();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String[]> SendArraysStringAsync(String[,] arr2, String[,,] arr3, String[,,,] arr4){
			BRequest_RemoteArrayTypes23_sendArraysString req = new BRequest_RemoteArrayTypes23_sendArraysString();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			Task<String[]> task = Task<String[]>.Factory.FromAsync(transport.BeginSend<String[]>, transport.EndSend<String[]>, req, null);
			return await task;
		}
		
		public virtual byps.test.api.prim.PrimitiveTypes[] SendArraysClass(byps.test.api.prim.PrimitiveTypes[,] arr2, byps.test.api.prim.PrimitiveTypes[,,] arr3, byps.test.api.prim.PrimitiveTypes[,,,] arr4) {
			BSyncResult<byps.test.api.prim.PrimitiveTypes[]> asyncResult = new BSyncResult<byps.test.api.prim.PrimitiveTypes[]>();			
			SendArraysClass(arr2, arr3, arr4, BAsyncResultHelper.ToDelegate<byps.test.api.prim.PrimitiveTypes[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void SendArraysClass(byps.test.api.prim.PrimitiveTypes[,] arr2, byps.test.api.prim.PrimitiveTypes[,,] arr3, byps.test.api.prim.PrimitiveTypes[,,,] arr4, BAsyncResult<byps.test.api.prim.PrimitiveTypes[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysClass req = new BRequest_RemoteArrayTypes23_sendArraysClass();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.prim.PrimitiveTypes[]> SendArraysClassAsync(byps.test.api.prim.PrimitiveTypes[,] arr2, byps.test.api.prim.PrimitiveTypes[,,] arr3, byps.test.api.prim.PrimitiveTypes[,,,] arr4){
			BRequest_RemoteArrayTypes23_sendArraysClass req = new BRequest_RemoteArrayTypes23_sendArraysClass();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			Task<byps.test.api.prim.PrimitiveTypes[]> task = Task<byps.test.api.prim.PrimitiveTypes[]>.Factory.FromAsync(transport.BeginSend<byps.test.api.prim.PrimitiveTypes[]>, transport.EndSend<byps.test.api.prim.PrimitiveTypes[]>, req, null);
			return await task;
		}
		
		public virtual Object[] SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4) {
			BSyncResult<Object[]> asyncResult = new BSyncResult<Object[]>();			
			SendArraysObject(arr2, arr3, arr4, BAsyncResultHelper.ToDelegate<Object[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void SendArraysObject(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4, BAsyncResult<Object[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysObject req = new BRequest_RemoteArrayTypes23_sendArraysObject();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<Object[]> SendArraysObjectAsync(Object[,] arr2, Object[,,] arr3, Object[,,,] arr4){
			BRequest_RemoteArrayTypes23_sendArraysObject req = new BRequest_RemoteArrayTypes23_sendArraysObject();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			Task<Object[]> task = Task<Object[]>.Factory.FromAsync(transport.BeginSend<Object[]>, transport.EndSend<Object[]>, req, null);
			return await task;
		}
		
		public virtual byps.test.api.inl.Point2D[] SendArraysInline(byps.test.api.inl.Point2D[,] arr2, byps.test.api.inl.Point2D[,,] arr3, byps.test.api.inl.Point2D[,,,] arr4) {
			BSyncResult<byps.test.api.inl.Point2D[]> asyncResult = new BSyncResult<byps.test.api.inl.Point2D[]>();			
			SendArraysInline(arr2, arr3, arr4, BAsyncResultHelper.ToDelegate<byps.test.api.inl.Point2D[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void SendArraysInline(byps.test.api.inl.Point2D[,] arr2, byps.test.api.inl.Point2D[,,] arr3, byps.test.api.inl.Point2D[,,,] arr4, BAsyncResult<byps.test.api.inl.Point2D[]> asyncResult) {
			BRequest_RemoteArrayTypes23_sendArraysInline req = new BRequest_RemoteArrayTypes23_sendArraysInline();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.inl.Point2D[]> SendArraysInlineAsync(byps.test.api.inl.Point2D[,] arr2, byps.test.api.inl.Point2D[,,] arr3, byps.test.api.inl.Point2D[,,,] arr4){
			BRequest_RemoteArrayTypes23_sendArraysInline req = new BRequest_RemoteArrayTypes23_sendArraysInline();			
			req.arr2Value = arr2;
			req.arr3Value = arr3;
			req.arr4Value = arr4;
			Task<byps.test.api.inl.Point2D[]> task = Task<byps.test.api.inl.Point2D[]>.Factory.FromAsync(transport.BeginSend<byps.test.api.inl.Point2D[]>, transport.EndSend<byps.test.api.inl.Point2D[]>, req, null);
			return await task;
		}
		
		
	}
}
