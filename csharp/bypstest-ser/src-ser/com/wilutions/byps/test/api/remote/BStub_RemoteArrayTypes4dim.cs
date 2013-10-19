using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteArrayTypes4dim : BStub, RemoteArrayTypes4dim, BSerializable {	
		
		public readonly static long serialVersionUID = 1557173854L;
		
		public BStub_RemoteArrayTypes4dim(BTransport transport)
			: base(transport) {}			
		
		public void SetBool(bool[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBool(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetBool(bool[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setBool req = new BRequest_RemoteArrayTypes4dim_setBool();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetBoolAsync(bool[,,,] v){
			BRequest_RemoteArrayTypes4dim_setBool req = new BRequest_RemoteArrayTypes4dim_setBool();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetByte(byte[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetByte(byte[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setByte req = new BRequest_RemoteArrayTypes4dim_setByte();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetByteAsync(byte[,,,] v){
			BRequest_RemoteArrayTypes4dim_setByte req = new BRequest_RemoteArrayTypes4dim_setByte();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetChar(char[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetChar(char[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setChar req = new BRequest_RemoteArrayTypes4dim_setChar();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetCharAsync(char[,,,] v){
			BRequest_RemoteArrayTypes4dim_setChar req = new BRequest_RemoteArrayTypes4dim_setChar();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetShort(short[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetShort(short[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setShort req = new BRequest_RemoteArrayTypes4dim_setShort();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetShortAsync(short[,,,] v){
			BRequest_RemoteArrayTypes4dim_setShort req = new BRequest_RemoteArrayTypes4dim_setShort();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetInt(int[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt(int[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setInt req = new BRequest_RemoteArrayTypes4dim_setInt();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetIntAsync(int[,,,] v){
			BRequest_RemoteArrayTypes4dim_setInt req = new BRequest_RemoteArrayTypes4dim_setInt();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetLong(long[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetLong(long[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setLong req = new BRequest_RemoteArrayTypes4dim_setLong();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetLongAsync(long[,,,] v){
			BRequest_RemoteArrayTypes4dim_setLong req = new BRequest_RemoteArrayTypes4dim_setLong();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetFloat(float[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetFloat(float[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setFloat req = new BRequest_RemoteArrayTypes4dim_setFloat();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetFloatAsync(float[,,,] v){
			BRequest_RemoteArrayTypes4dim_setFloat req = new BRequest_RemoteArrayTypes4dim_setFloat();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetDouble(double[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetDouble(double[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setDouble req = new BRequest_RemoteArrayTypes4dim_setDouble();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetDoubleAsync(double[,,,] v){
			BRequest_RemoteArrayTypes4dim_setDouble req = new BRequest_RemoteArrayTypes4dim_setDouble();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetString(String[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetString(String[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setString req = new BRequest_RemoteArrayTypes4dim_setString();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetStringAsync(String[,,,] v){
			BRequest_RemoteArrayTypes4dim_setString req = new BRequest_RemoteArrayTypes4dim_setString();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setPrimitiveTypes req = new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetPrimitiveTypesAsync(com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] v){
			BRequest_RemoteArrayTypes4dim_setPrimitiveTypes req = new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetObject(Object[,,,] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObject(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetObject(Object[,,,] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes4dim_setObject req = new BRequest_RemoteArrayTypes4dim_setObject();			
			req._v = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetObjectAsync(Object[,,,] v){
			BRequest_RemoteArrayTypes4dim_setObject req = new BRequest_RemoteArrayTypes4dim_setObject();			
			req._v = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public bool[,,,] GetBool() {
			BSyncResult<bool[,,,]> asyncResult = new BSyncResult<bool[,,,]>();			
			GetBool(BAsyncResultHelper.ToDelegate<bool[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetBool(BAsyncResult<bool[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getBool req = new BRequest_RemoteArrayTypes4dim_getBool();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<bool[,,,]> GetBoolAsync(){
			BRequest_RemoteArrayTypes4dim_getBool req = new BRequest_RemoteArrayTypes4dim_getBool();			
			Task<bool[,,,]> task = Task<bool[,,,]>.Factory.FromAsync(transport.BeginSend<bool[,,,]>, transport.EndSend<bool[,,,]>, req, null);
			return await task;
		}
		
		public byte[,,,] GetByte() {
			BSyncResult<byte[,,,]> asyncResult = new BSyncResult<byte[,,,]>();			
			GetByte(BAsyncResultHelper.ToDelegate<byte[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetByte(BAsyncResult<byte[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getByte req = new BRequest_RemoteArrayTypes4dim_getByte();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<byte[,,,]> GetByteAsync(){
			BRequest_RemoteArrayTypes4dim_getByte req = new BRequest_RemoteArrayTypes4dim_getByte();			
			Task<byte[,,,]> task = Task<byte[,,,]>.Factory.FromAsync(transport.BeginSend<byte[,,,]>, transport.EndSend<byte[,,,]>, req, null);
			return await task;
		}
		
		public char[,,,] GetChar() {
			BSyncResult<char[,,,]> asyncResult = new BSyncResult<char[,,,]>();			
			GetChar(BAsyncResultHelper.ToDelegate<char[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetChar(BAsyncResult<char[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getChar req = new BRequest_RemoteArrayTypes4dim_getChar();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<char[,,,]> GetCharAsync(){
			BRequest_RemoteArrayTypes4dim_getChar req = new BRequest_RemoteArrayTypes4dim_getChar();			
			Task<char[,,,]> task = Task<char[,,,]>.Factory.FromAsync(transport.BeginSend<char[,,,]>, transport.EndSend<char[,,,]>, req, null);
			return await task;
		}
		
		public short[,,,] GetShort() {
			BSyncResult<short[,,,]> asyncResult = new BSyncResult<short[,,,]>();			
			GetShort(BAsyncResultHelper.ToDelegate<short[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetShort(BAsyncResult<short[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getShort req = new BRequest_RemoteArrayTypes4dim_getShort();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<short[,,,]> GetShortAsync(){
			BRequest_RemoteArrayTypes4dim_getShort req = new BRequest_RemoteArrayTypes4dim_getShort();			
			Task<short[,,,]> task = Task<short[,,,]>.Factory.FromAsync(transport.BeginSend<short[,,,]>, transport.EndSend<short[,,,]>, req, null);
			return await task;
		}
		
		public int[,,,] GetInt() {
			BSyncResult<int[,,,]> asyncResult = new BSyncResult<int[,,,]>();			
			GetInt(BAsyncResultHelper.ToDelegate<int[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt(BAsyncResult<int[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getInt req = new BRequest_RemoteArrayTypes4dim_getInt();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<int[,,,]> GetIntAsync(){
			BRequest_RemoteArrayTypes4dim_getInt req = new BRequest_RemoteArrayTypes4dim_getInt();			
			Task<int[,,,]> task = Task<int[,,,]>.Factory.FromAsync(transport.BeginSend<int[,,,]>, transport.EndSend<int[,,,]>, req, null);
			return await task;
		}
		
		public long[,,,] GetLong() {
			BSyncResult<long[,,,]> asyncResult = new BSyncResult<long[,,,]>();			
			GetLong(BAsyncResultHelper.ToDelegate<long[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetLong(BAsyncResult<long[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getLong req = new BRequest_RemoteArrayTypes4dim_getLong();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<long[,,,]> GetLongAsync(){
			BRequest_RemoteArrayTypes4dim_getLong req = new BRequest_RemoteArrayTypes4dim_getLong();			
			Task<long[,,,]> task = Task<long[,,,]>.Factory.FromAsync(transport.BeginSend<long[,,,]>, transport.EndSend<long[,,,]>, req, null);
			return await task;
		}
		
		public float[,,,] GetFloat() {
			BSyncResult<float[,,,]> asyncResult = new BSyncResult<float[,,,]>();			
			GetFloat(BAsyncResultHelper.ToDelegate<float[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetFloat(BAsyncResult<float[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getFloat req = new BRequest_RemoteArrayTypes4dim_getFloat();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<float[,,,]> GetFloatAsync(){
			BRequest_RemoteArrayTypes4dim_getFloat req = new BRequest_RemoteArrayTypes4dim_getFloat();			
			Task<float[,,,]> task = Task<float[,,,]>.Factory.FromAsync(transport.BeginSend<float[,,,]>, transport.EndSend<float[,,,]>, req, null);
			return await task;
		}
		
		public double[,,,] GetDouble() {
			BSyncResult<double[,,,]> asyncResult = new BSyncResult<double[,,,]>();			
			GetDouble(BAsyncResultHelper.ToDelegate<double[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetDouble(BAsyncResult<double[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getDouble req = new BRequest_RemoteArrayTypes4dim_getDouble();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<double[,,,]> GetDoubleAsync(){
			BRequest_RemoteArrayTypes4dim_getDouble req = new BRequest_RemoteArrayTypes4dim_getDouble();			
			Task<double[,,,]> task = Task<double[,,,]>.Factory.FromAsync(transport.BeginSend<double[,,,]>, transport.EndSend<double[,,,]>, req, null);
			return await task;
		}
		
		public String[,,,] GetString() {
			BSyncResult<String[,,,]> asyncResult = new BSyncResult<String[,,,]>();			
			GetString(BAsyncResultHelper.ToDelegate<String[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetString(BAsyncResult<String[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getString req = new BRequest_RemoteArrayTypes4dim_getString();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<String[,,,]> GetStringAsync(){
			BRequest_RemoteArrayTypes4dim_getString req = new BRequest_RemoteArrayTypes4dim_getString();			
			Task<String[,,,]> task = Task<String[,,,]>.Factory.FromAsync(transport.BeginSend<String[,,,]>, transport.EndSend<String[,,,]>, req, null);
			return await task;
		}
		
		public com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,] GetPrimitiveTypes() {
			BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]> asyncResult = new BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]>();			
			GetPrimitiveTypes(BAsyncResultHelper.ToDelegate<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPrimitiveTypes(BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getPrimitiveTypes req = new BRequest_RemoteArrayTypes4dim_getPrimitiveTypes();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]> GetPrimitiveTypesAsync(){
			BRequest_RemoteArrayTypes4dim_getPrimitiveTypes req = new BRequest_RemoteArrayTypes4dim_getPrimitiveTypes();			
			Task<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]> task = Task<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]>.Factory.FromAsync(transport.BeginSend<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]>, transport.EndSend<com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,]>, req, null);
			return await task;
		}
		
		public Object[,,,] GetObject() {
			BSyncResult<Object[,,,]> asyncResult = new BSyncResult<Object[,,,]>();			
			GetObject(BAsyncResultHelper.ToDelegate<Object[,,,]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetObject(BAsyncResult<Object[,,,]> asyncResult) {
			BRequest_RemoteArrayTypes4dim_getObject req = new BRequest_RemoteArrayTypes4dim_getObject();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<Object[,,,]> GetObjectAsync(){
			BRequest_RemoteArrayTypes4dim_getObject req = new BRequest_RemoteArrayTypes4dim_getObject();			
			Task<Object[,,,]> task = Task<Object[,,,]>.Factory.FromAsync(transport.BeginSend<Object[,,,]>, transport.EndSend<Object[,,,]>, req, null);
			return await task;
		}
		
		
	}
}
