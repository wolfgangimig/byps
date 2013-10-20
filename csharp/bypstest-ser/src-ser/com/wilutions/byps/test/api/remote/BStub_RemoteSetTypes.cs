using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteSetTypes : BStub, RemoteSetTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 1156008353L;
		
		public BStub_RemoteSetTypes(BTransport transport)
			: base(transport) {}			
		
		public ISet<bool> GetBoolean1() {
			BSyncResult<ISet<bool>> asyncResult = new BSyncResult<ISet<bool>>();			
			GetBoolean1(BAsyncResultHelper.ToDelegate<ISet<bool>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetBoolean1(BAsyncResult<ISet<bool>> asyncResult) {
			BRequest_RemoteSetTypes_getBoolean1 req = new BRequest_RemoteSetTypes_getBoolean1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<bool>> GetBoolean1Async(){
			BRequest_RemoteSetTypes_getBoolean1 req = new BRequest_RemoteSetTypes_getBoolean1();			
			Task<ISet<bool>> task = Task<ISet<bool>>.Factory.FromAsync(transport.BeginSend<ISet<bool>>, transport.EndSend<ISet<bool>>, req, null);
			return await task;
		}
		
		public void SetBoolean1(ISet<bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBoolean1(boolean1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetBoolean1(ISet<bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setBoolean1 req = new BRequest_RemoteSetTypes_setBoolean1();			
			req._boolean1 = boolean1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetBoolean1Async(ISet<bool> boolean1){
			BRequest_RemoteSetTypes_setBoolean1 req = new BRequest_RemoteSetTypes_setBoolean1();			
			req._boolean1 = boolean1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public HashSet<byte> GetByte1() {
			BSyncResult<HashSet<byte>> asyncResult = new BSyncResult<HashSet<byte>>();			
			GetByte1(BAsyncResultHelper.ToDelegate<HashSet<byte>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetByte1(BAsyncResult<HashSet<byte>> asyncResult) {
			BRequest_RemoteSetTypes_getByte1 req = new BRequest_RemoteSetTypes_getByte1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<HashSet<byte>> GetByte1Async(){
			BRequest_RemoteSetTypes_getByte1 req = new BRequest_RemoteSetTypes_getByte1();			
			Task<HashSet<byte>> task = Task<HashSet<byte>>.Factory.FromAsync(transport.BeginSend<HashSet<byte>>, transport.EndSend<HashSet<byte>>, req, null);
			return await task;
		}
		
		public void SetByte1(HashSet<byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte1(byte1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetByte1(HashSet<byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setByte1 req = new BRequest_RemoteSetTypes_setByte1();			
			req._byte1 = byte1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetByte1Async(HashSet<byte> byte1){
			BRequest_RemoteSetTypes_setByte1 req = new BRequest_RemoteSetTypes_setByte1();			
			req._byte1 = byte1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public HashSet<char> GetChar1() {
			BSyncResult<HashSet<char>> asyncResult = new BSyncResult<HashSet<char>>();			
			GetChar1(BAsyncResultHelper.ToDelegate<HashSet<char>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetChar1(BAsyncResult<HashSet<char>> asyncResult) {
			BRequest_RemoteSetTypes_getChar1 req = new BRequest_RemoteSetTypes_getChar1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<HashSet<char>> GetChar1Async(){
			BRequest_RemoteSetTypes_getChar1 req = new BRequest_RemoteSetTypes_getChar1();			
			Task<HashSet<char>> task = Task<HashSet<char>>.Factory.FromAsync(transport.BeginSend<HashSet<char>>, transport.EndSend<HashSet<char>>, req, null);
			return await task;
		}
		
		public void SetChar1(HashSet<char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar1(char1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetChar1(HashSet<char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setChar1 req = new BRequest_RemoteSetTypes_setChar1();			
			req._char1 = char1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetChar1Async(HashSet<char> char1){
			BRequest_RemoteSetTypes_setChar1 req = new BRequest_RemoteSetTypes_setChar1();			
			req._char1 = char1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<short> GetShort1() {
			BSyncResult<ISet<short>> asyncResult = new BSyncResult<ISet<short>>();			
			GetShort1(BAsyncResultHelper.ToDelegate<ISet<short>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetShort1(BAsyncResult<ISet<short>> asyncResult) {
			BRequest_RemoteSetTypes_getShort1 req = new BRequest_RemoteSetTypes_getShort1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<short>> GetShort1Async(){
			BRequest_RemoteSetTypes_getShort1 req = new BRequest_RemoteSetTypes_getShort1();			
			Task<ISet<short>> task = Task<ISet<short>>.Factory.FromAsync(transport.BeginSend<ISet<short>>, transport.EndSend<ISet<short>>, req, null);
			return await task;
		}
		
		public void SetShort1(ISet<short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort1(short1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetShort1(ISet<short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setShort1 req = new BRequest_RemoteSetTypes_setShort1();			
			req._short1 = short1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetShort1Async(ISet<short> short1){
			BRequest_RemoteSetTypes_setShort1 req = new BRequest_RemoteSetTypes_setShort1();			
			req._short1 = short1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<int> GetInt1() {
			BSyncResult<ISet<int>> asyncResult = new BSyncResult<ISet<int>>();			
			GetInt1(BAsyncResultHelper.ToDelegate<ISet<int>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt1(BAsyncResult<ISet<int>> asyncResult) {
			BRequest_RemoteSetTypes_getInt1 req = new BRequest_RemoteSetTypes_getInt1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<int>> GetInt1Async(){
			BRequest_RemoteSetTypes_getInt1 req = new BRequest_RemoteSetTypes_getInt1();			
			Task<ISet<int>> task = Task<ISet<int>>.Factory.FromAsync(transport.BeginSend<ISet<int>>, transport.EndSend<ISet<int>>, req, null);
			return await task;
		}
		
		public void SetInt1(ISet<int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt1(int1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt1(ISet<int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setInt1 req = new BRequest_RemoteSetTypes_setInt1();			
			req._int1 = int1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetInt1Async(ISet<int> int1){
			BRequest_RemoteSetTypes_setInt1 req = new BRequest_RemoteSetTypes_setInt1();			
			req._int1 = int1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<long> GetLong1() {
			BSyncResult<ISet<long>> asyncResult = new BSyncResult<ISet<long>>();			
			GetLong1(BAsyncResultHelper.ToDelegate<ISet<long>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetLong1(BAsyncResult<ISet<long>> asyncResult) {
			BRequest_RemoteSetTypes_getLong1 req = new BRequest_RemoteSetTypes_getLong1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<long>> GetLong1Async(){
			BRequest_RemoteSetTypes_getLong1 req = new BRequest_RemoteSetTypes_getLong1();			
			Task<ISet<long>> task = Task<ISet<long>>.Factory.FromAsync(transport.BeginSend<ISet<long>>, transport.EndSend<ISet<long>>, req, null);
			return await task;
		}
		
		public void SetLong1(ISet<long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong1(long1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetLong1(ISet<long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setLong1 req = new BRequest_RemoteSetTypes_setLong1();			
			req._long1 = long1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetLong1Async(ISet<long> long1){
			BRequest_RemoteSetTypes_setLong1 req = new BRequest_RemoteSetTypes_setLong1();			
			req._long1 = long1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<float> GetFloat1() {
			BSyncResult<ISet<float>> asyncResult = new BSyncResult<ISet<float>>();			
			GetFloat1(BAsyncResultHelper.ToDelegate<ISet<float>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetFloat1(BAsyncResult<ISet<float>> asyncResult) {
			BRequest_RemoteSetTypes_getFloat1 req = new BRequest_RemoteSetTypes_getFloat1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<float>> GetFloat1Async(){
			BRequest_RemoteSetTypes_getFloat1 req = new BRequest_RemoteSetTypes_getFloat1();			
			Task<ISet<float>> task = Task<ISet<float>>.Factory.FromAsync(transport.BeginSend<ISet<float>>, transport.EndSend<ISet<float>>, req, null);
			return await task;
		}
		
		public void SetFloat1(ISet<float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat1(float1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetFloat1(ISet<float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setFloat1 req = new BRequest_RemoteSetTypes_setFloat1();			
			req._float1 = float1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetFloat1Async(ISet<float> float1){
			BRequest_RemoteSetTypes_setFloat1 req = new BRequest_RemoteSetTypes_setFloat1();			
			req._float1 = float1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<double> GetDouble1() {
			BSyncResult<ISet<double>> asyncResult = new BSyncResult<ISet<double>>();			
			GetDouble1(BAsyncResultHelper.ToDelegate<ISet<double>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetDouble1(BAsyncResult<ISet<double>> asyncResult) {
			BRequest_RemoteSetTypes_getDouble1 req = new BRequest_RemoteSetTypes_getDouble1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<double>> GetDouble1Async(){
			BRequest_RemoteSetTypes_getDouble1 req = new BRequest_RemoteSetTypes_getDouble1();			
			Task<ISet<double>> task = Task<ISet<double>>.Factory.FromAsync(transport.BeginSend<ISet<double>>, transport.EndSend<ISet<double>>, req, null);
			return await task;
		}
		
		public void SetDouble1(ISet<double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble1(double1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetDouble1(ISet<double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setDouble1 req = new BRequest_RemoteSetTypes_setDouble1();			
			req._double1 = double1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetDouble1Async(ISet<double> double1){
			BRequest_RemoteSetTypes_setDouble1 req = new BRequest_RemoteSetTypes_setDouble1();			
			req._double1 = double1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<String> GetString1() {
			BSyncResult<ISet<String>> asyncResult = new BSyncResult<ISet<String>>();			
			GetString1(BAsyncResultHelper.ToDelegate<ISet<String>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetString1(BAsyncResult<ISet<String>> asyncResult) {
			BRequest_RemoteSetTypes_getString1 req = new BRequest_RemoteSetTypes_getString1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<String>> GetString1Async(){
			BRequest_RemoteSetTypes_getString1 req = new BRequest_RemoteSetTypes_getString1();			
			Task<ISet<String>> task = Task<ISet<String>>.Factory.FromAsync(transport.BeginSend<ISet<String>>, transport.EndSend<ISet<String>>, req, null);
			return await task;
		}
		
		public void SetString1(ISet<String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString1(string1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetString1(ISet<String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setString1 req = new BRequest_RemoteSetTypes_setString1();			
			req._string1 = string1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetString1Async(ISet<String> string1){
			BRequest_RemoteSetTypes_setString1 req = new BRequest_RemoteSetTypes_setString1();			
			req._string1 = string1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>();			
			GetPrimitiveTypes1(BAsyncResultHelper.ToDelegate<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPrimitiveTypes1(BAsyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteSetTypes_getPrimitiveTypes1 req = new BRequest_RemoteSetTypes_getPrimitiveTypes1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Async(){
			BRequest_RemoteSetTypes_getPrimitiveTypes1 req = new BRequest_RemoteSetTypes_getPrimitiveTypes1();			
			Task<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> task = Task<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>.Factory.FromAsync(transport.BeginSend<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>, transport.EndSend<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>, req, null);
			return await task;
		}
		
		public void SetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes1(primitiveTypes1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setPrimitiveTypes1 req = new BRequest_RemoteSetTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetPrimitiveTypes1Async(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1){
			BRequest_RemoteSetTypes_setPrimitiveTypes1 req = new BRequest_RemoteSetTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<byte[]> GetByte2() {
			BSyncResult<ISet<byte[]>> asyncResult = new BSyncResult<ISet<byte[]>>();			
			GetByte2(BAsyncResultHelper.ToDelegate<ISet<byte[]>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetByte2(BAsyncResult<ISet<byte[]>> asyncResult) {
			BRequest_RemoteSetTypes_getByte2 req = new BRequest_RemoteSetTypes_getByte2();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<byte[]>> GetByte2Async(){
			BRequest_RemoteSetTypes_getByte2 req = new BRequest_RemoteSetTypes_getByte2();			
			Task<ISet<byte[]>> task = Task<ISet<byte[]>>.Factory.FromAsync(transport.BeginSend<ISet<byte[]>>, transport.EndSend<ISet<byte[]>>, req, null);
			return await task;
		}
		
		public void SetByte2(ISet<byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte2(byte2, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetByte2(ISet<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setByte2 req = new BRequest_RemoteSetTypes_setByte2();			
			req._byte2 = byte2;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetByte2Async(ISet<byte[]> byte2){
			BRequest_RemoteSetTypes_setByte2 req = new BRequest_RemoteSetTypes_setByte2();			
			req._byte2 = byte2;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<int[]> GetInt2() {
			BSyncResult<ISet<int[]>> asyncResult = new BSyncResult<ISet<int[]>>();			
			GetInt2(BAsyncResultHelper.ToDelegate<ISet<int[]>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt2(BAsyncResult<ISet<int[]>> asyncResult) {
			BRequest_RemoteSetTypes_getInt2 req = new BRequest_RemoteSetTypes_getInt2();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<int[]>> GetInt2Async(){
			BRequest_RemoteSetTypes_getInt2 req = new BRequest_RemoteSetTypes_getInt2();			
			Task<ISet<int[]>> task = Task<ISet<int[]>>.Factory.FromAsync(transport.BeginSend<ISet<int[]>>, transport.EndSend<ISet<int[]>>, req, null);
			return await task;
		}
		
		public void SetInt2(ISet<int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt2(int2, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt2(ISet<int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setInt2 req = new BRequest_RemoteSetTypes_setInt2();			
			req._int2 = int2;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetInt2Async(ISet<int[]> int2){
			BRequest_RemoteSetTypes_setInt2 req = new BRequest_RemoteSetTypes_setInt2();			
			req._int2 = int2;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public ISet<Object> GetObj1() {
			BSyncResult<ISet<Object>> asyncResult = new BSyncResult<ISet<Object>>();			
			GetObj1(BAsyncResultHelper.ToDelegate<ISet<Object>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetObj1(BAsyncResult<ISet<Object>> asyncResult) {
			BRequest_RemoteSetTypes_getObj1 req = new BRequest_RemoteSetTypes_getObj1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<ISet<Object>> GetObj1Async(){
			BRequest_RemoteSetTypes_getObj1 req = new BRequest_RemoteSetTypes_getObj1();			
			Task<ISet<Object>> task = Task<ISet<Object>>.Factory.FromAsync(transport.BeginSend<ISet<Object>>, transport.EndSend<ISet<Object>>, req, null);
			return await task;
		}
		
		public void SetObj1(ISet<Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObj1(obj1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetObj1(ISet<Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setObj1 req = new BRequest_RemoteSetTypes_setObj1();			
			req._obj1 = obj1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetObj1Async(ISet<Object> obj1){
			BRequest_RemoteSetTypes_setObj1 req = new BRequest_RemoteSetTypes_setObj1();			
			req._obj1 = obj1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
