using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteListTypes : BStub, RemoteListTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 1233438138L;
		
		public BStub_RemoteListTypes(BTransport transport)
			: base(transport) {}			
		
		public IList<bool> GetBoolean1() {
			BSyncResult<IList<bool>> asyncResult = new BSyncResult<IList<bool>>();			
			GetBoolean1(BAsyncResultHelper.ToDelegate<IList<bool>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetBoolean1(BAsyncResult<IList<bool>> asyncResult) {
			BRequest_RemoteListTypes_getBoolean1 req = new BRequest_RemoteListTypes_getBoolean1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<bool>> GetBoolean1Async(){
			BRequest_RemoteListTypes_getBoolean1 req = new BRequest_RemoteListTypes_getBoolean1();			
			Task<IList<bool>> task = Task<IList<bool>>.Factory.FromAsync(transport.BeginSend<IList<bool>>, transport.EndSend<IList<bool>>, req, null);
			return await task;
		}
		
		public void SetBoolean1(IList<bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBoolean1(boolean1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetBoolean1(IList<bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setBoolean1 req = new BRequest_RemoteListTypes_setBoolean1();			
			req._boolean1 = boolean1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetBoolean1Async(IList<bool> boolean1){
			BRequest_RemoteListTypes_setBoolean1 req = new BRequest_RemoteListTypes_setBoolean1();			
			req._boolean1 = boolean1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<byte> GetByte1() {
			BSyncResult<IList<byte>> asyncResult = new BSyncResult<IList<byte>>();			
			GetByte1(BAsyncResultHelper.ToDelegate<IList<byte>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetByte1(BAsyncResult<IList<byte>> asyncResult) {
			BRequest_RemoteListTypes_getByte1 req = new BRequest_RemoteListTypes_getByte1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<byte>> GetByte1Async(){
			BRequest_RemoteListTypes_getByte1 req = new BRequest_RemoteListTypes_getByte1();			
			Task<IList<byte>> task = Task<IList<byte>>.Factory.FromAsync(transport.BeginSend<IList<byte>>, transport.EndSend<IList<byte>>, req, null);
			return await task;
		}
		
		public void SetByte1(IList<byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte1(byte1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetByte1(IList<byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setByte1 req = new BRequest_RemoteListTypes_setByte1();			
			req._byte1 = byte1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetByte1Async(IList<byte> byte1){
			BRequest_RemoteListTypes_setByte1 req = new BRequest_RemoteListTypes_setByte1();			
			req._byte1 = byte1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<char> GetChar1() {
			BSyncResult<IList<char>> asyncResult = new BSyncResult<IList<char>>();			
			GetChar1(BAsyncResultHelper.ToDelegate<IList<char>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetChar1(BAsyncResult<IList<char>> asyncResult) {
			BRequest_RemoteListTypes_getChar1 req = new BRequest_RemoteListTypes_getChar1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<char>> GetChar1Async(){
			BRequest_RemoteListTypes_getChar1 req = new BRequest_RemoteListTypes_getChar1();			
			Task<IList<char>> task = Task<IList<char>>.Factory.FromAsync(transport.BeginSend<IList<char>>, transport.EndSend<IList<char>>, req, null);
			return await task;
		}
		
		public void SetChar1(IList<char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar1(char1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetChar1(IList<char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setChar1 req = new BRequest_RemoteListTypes_setChar1();			
			req._char1 = char1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetChar1Async(IList<char> char1){
			BRequest_RemoteListTypes_setChar1 req = new BRequest_RemoteListTypes_setChar1();			
			req._char1 = char1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<short> GetShort1() {
			BSyncResult<IList<short>> asyncResult = new BSyncResult<IList<short>>();			
			GetShort1(BAsyncResultHelper.ToDelegate<IList<short>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetShort1(BAsyncResult<IList<short>> asyncResult) {
			BRequest_RemoteListTypes_getShort1 req = new BRequest_RemoteListTypes_getShort1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<short>> GetShort1Async(){
			BRequest_RemoteListTypes_getShort1 req = new BRequest_RemoteListTypes_getShort1();			
			Task<IList<short>> task = Task<IList<short>>.Factory.FromAsync(transport.BeginSend<IList<short>>, transport.EndSend<IList<short>>, req, null);
			return await task;
		}
		
		public void SetShort1(IList<short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort1(short1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetShort1(IList<short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setShort1 req = new BRequest_RemoteListTypes_setShort1();			
			req._short1 = short1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetShort1Async(IList<short> short1){
			BRequest_RemoteListTypes_setShort1 req = new BRequest_RemoteListTypes_setShort1();			
			req._short1 = short1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<int> GetInt1() {
			BSyncResult<IList<int>> asyncResult = new BSyncResult<IList<int>>();			
			GetInt1(BAsyncResultHelper.ToDelegate<IList<int>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt1(BAsyncResult<IList<int>> asyncResult) {
			BRequest_RemoteListTypes_getInt1 req = new BRequest_RemoteListTypes_getInt1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<int>> GetInt1Async(){
			BRequest_RemoteListTypes_getInt1 req = new BRequest_RemoteListTypes_getInt1();			
			Task<IList<int>> task = Task<IList<int>>.Factory.FromAsync(transport.BeginSend<IList<int>>, transport.EndSend<IList<int>>, req, null);
			return await task;
		}
		
		public void SetInt1(IList<int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt1(int1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt1(IList<int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt1 req = new BRequest_RemoteListTypes_setInt1();			
			req._int1 = int1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt1Async(IList<int> int1){
			BRequest_RemoteListTypes_setInt1 req = new BRequest_RemoteListTypes_setInt1();			
			req._int1 = int1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<long> GetLong1() {
			BSyncResult<IList<long>> asyncResult = new BSyncResult<IList<long>>();			
			GetLong1(BAsyncResultHelper.ToDelegate<IList<long>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetLong1(BAsyncResult<IList<long>> asyncResult) {
			BRequest_RemoteListTypes_getLong1 req = new BRequest_RemoteListTypes_getLong1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<long>> GetLong1Async(){
			BRequest_RemoteListTypes_getLong1 req = new BRequest_RemoteListTypes_getLong1();			
			Task<IList<long>> task = Task<IList<long>>.Factory.FromAsync(transport.BeginSend<IList<long>>, transport.EndSend<IList<long>>, req, null);
			return await task;
		}
		
		public void SetLong1(IList<long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong1(long1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetLong1(IList<long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setLong1 req = new BRequest_RemoteListTypes_setLong1();			
			req._long1 = long1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetLong1Async(IList<long> long1){
			BRequest_RemoteListTypes_setLong1 req = new BRequest_RemoteListTypes_setLong1();			
			req._long1 = long1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<float> GetFloat1() {
			BSyncResult<IList<float>> asyncResult = new BSyncResult<IList<float>>();			
			GetFloat1(BAsyncResultHelper.ToDelegate<IList<float>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetFloat1(BAsyncResult<IList<float>> asyncResult) {
			BRequest_RemoteListTypes_getFloat1 req = new BRequest_RemoteListTypes_getFloat1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<float>> GetFloat1Async(){
			BRequest_RemoteListTypes_getFloat1 req = new BRequest_RemoteListTypes_getFloat1();			
			Task<IList<float>> task = Task<IList<float>>.Factory.FromAsync(transport.BeginSend<IList<float>>, transport.EndSend<IList<float>>, req, null);
			return await task;
		}
		
		public void SetFloat1(IList<float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat1(float1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetFloat1(IList<float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setFloat1 req = new BRequest_RemoteListTypes_setFloat1();			
			req._float1 = float1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetFloat1Async(IList<float> float1){
			BRequest_RemoteListTypes_setFloat1 req = new BRequest_RemoteListTypes_setFloat1();			
			req._float1 = float1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<double> GetDouble1() {
			BSyncResult<IList<double>> asyncResult = new BSyncResult<IList<double>>();			
			GetDouble1(BAsyncResultHelper.ToDelegate<IList<double>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetDouble1(BAsyncResult<IList<double>> asyncResult) {
			BRequest_RemoteListTypes_getDouble1 req = new BRequest_RemoteListTypes_getDouble1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<double>> GetDouble1Async(){
			BRequest_RemoteListTypes_getDouble1 req = new BRequest_RemoteListTypes_getDouble1();			
			Task<IList<double>> task = Task<IList<double>>.Factory.FromAsync(transport.BeginSend<IList<double>>, transport.EndSend<IList<double>>, req, null);
			return await task;
		}
		
		public void SetDouble1(IList<double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble1(double1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetDouble1(IList<double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setDouble1 req = new BRequest_RemoteListTypes_setDouble1();			
			req._double1 = double1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetDouble1Async(IList<double> double1){
			BRequest_RemoteListTypes_setDouble1 req = new BRequest_RemoteListTypes_setDouble1();			
			req._double1 = double1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<String> GetString1() {
			BSyncResult<IList<String>> asyncResult = new BSyncResult<IList<String>>();			
			GetString1(BAsyncResultHelper.ToDelegate<IList<String>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetString1(BAsyncResult<IList<String>> asyncResult) {
			BRequest_RemoteListTypes_getString1 req = new BRequest_RemoteListTypes_getString1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<String>> GetString1Async(){
			BRequest_RemoteListTypes_getString1 req = new BRequest_RemoteListTypes_getString1();			
			Task<IList<String>> task = Task<IList<String>>.Factory.FromAsync(transport.BeginSend<IList<String>>, transport.EndSend<IList<String>>, req, null);
			return await task;
		}
		
		public void SetString1(IList<String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString1(string1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetString1(IList<String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setString1 req = new BRequest_RemoteListTypes_setString1();			
			req._string1 = string1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetString1Async(IList<String> string1){
			BRequest_RemoteListTypes_setString1 req = new BRequest_RemoteListTypes_setString1();			
			req._string1 = string1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<IList<byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<IList<byps.test.api.prim.PrimitiveTypes>>();			
			GetPrimitiveTypes1(BAsyncResultHelper.ToDelegate<IList<byps.test.api.prim.PrimitiveTypes>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPrimitiveTypes1(BAsyncResult<IList<byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteListTypes_getPrimitiveTypes1 req = new BRequest_RemoteListTypes_getPrimitiveTypes1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Async(){
			BRequest_RemoteListTypes_getPrimitiveTypes1 req = new BRequest_RemoteListTypes_getPrimitiveTypes1();			
			Task<IList<byps.test.api.prim.PrimitiveTypes>> task = Task<IList<byps.test.api.prim.PrimitiveTypes>>.Factory.FromAsync(transport.BeginSend<IList<byps.test.api.prim.PrimitiveTypes>>, transport.EndSend<IList<byps.test.api.prim.PrimitiveTypes>>, req, null);
			return await task;
		}
		
		public void SetPrimitiveTypes1(IList<byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes1(primitiveTypes1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPrimitiveTypes1(IList<byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setPrimitiveTypes1 req = new BRequest_RemoteListTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPrimitiveTypes1Async(IList<byps.test.api.prim.PrimitiveTypes> primitiveTypes1){
			BRequest_RemoteListTypes_setPrimitiveTypes1 req = new BRequest_RemoteListTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<byte[]> GetByte2() {
			BSyncResult<IList<byte[]>> asyncResult = new BSyncResult<IList<byte[]>>();			
			GetByte2(BAsyncResultHelper.ToDelegate<IList<byte[]>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetByte2(BAsyncResult<IList<byte[]>> asyncResult) {
			BRequest_RemoteListTypes_getByte2 req = new BRequest_RemoteListTypes_getByte2();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<byte[]>> GetByte2Async(){
			BRequest_RemoteListTypes_getByte2 req = new BRequest_RemoteListTypes_getByte2();			
			Task<IList<byte[]>> task = Task<IList<byte[]>>.Factory.FromAsync(transport.BeginSend<IList<byte[]>>, transport.EndSend<IList<byte[]>>, req, null);
			return await task;
		}
		
		public void SetByte2(IList<byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte2(byte2, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetByte2(IList<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setByte2 req = new BRequest_RemoteListTypes_setByte2();			
			req._byte2 = byte2;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetByte2Async(IList<byte[]> byte2){
			BRequest_RemoteListTypes_setByte2 req = new BRequest_RemoteListTypes_setByte2();			
			req._byte2 = byte2;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<int[]> GetInt2() {
			BSyncResult<IList<int[]>> asyncResult = new BSyncResult<IList<int[]>>();			
			GetInt2(BAsyncResultHelper.ToDelegate<IList<int[]>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt2(BAsyncResult<IList<int[]>> asyncResult) {
			BRequest_RemoteListTypes_getInt2 req = new BRequest_RemoteListTypes_getInt2();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<int[]>> GetInt2Async(){
			BRequest_RemoteListTypes_getInt2 req = new BRequest_RemoteListTypes_getInt2();			
			Task<IList<int[]>> task = Task<IList<int[]>>.Factory.FromAsync(transport.BeginSend<IList<int[]>>, transport.EndSend<IList<int[]>>, req, null);
			return await task;
		}
		
		public void SetInt2(IList<int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt2(int2, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt2(IList<int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt2 req = new BRequest_RemoteListTypes_setInt2();			
			req._int2 = int2;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt2Async(IList<int[]> int2){
			BRequest_RemoteListTypes_setInt2 req = new BRequest_RemoteListTypes_setInt2();			
			req._int2 = int2;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<Object> GetObj1() {
			BSyncResult<IList<Object>> asyncResult = new BSyncResult<IList<Object>>();			
			GetObj1(BAsyncResultHelper.ToDelegate<IList<Object>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetObj1(BAsyncResult<IList<Object>> asyncResult) {
			BRequest_RemoteListTypes_getObj1 req = new BRequest_RemoteListTypes_getObj1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<Object>> GetObj1Async(){
			BRequest_RemoteListTypes_getObj1 req = new BRequest_RemoteListTypes_getObj1();			
			Task<IList<Object>> task = Task<IList<Object>>.Factory.FromAsync(transport.BeginSend<IList<Object>>, transport.EndSend<IList<Object>>, req, null);
			return await task;
		}
		
		public void SetObj1(IList<Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObj1(obj1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetObj1(IList<Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setObj1 req = new BRequest_RemoteListTypes_setObj1();			
			req._obj1 = obj1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetObj1Async(IList<Object> obj1){
			BRequest_RemoteListTypes_setObj1 req = new BRequest_RemoteListTypes_setObj1();			
			req._obj1 = obj1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<IList<int>> GetInt3() {
			BSyncResult<IList<IList<int>>> asyncResult = new BSyncResult<IList<IList<int>>>();			
			GetInt3(BAsyncResultHelper.ToDelegate<IList<IList<int>>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt3(BAsyncResult<IList<IList<int>>> asyncResult) {
			BRequest_RemoteListTypes_getInt3 req = new BRequest_RemoteListTypes_getInt3();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<IList<int>>> GetInt3Async(){
			BRequest_RemoteListTypes_getInt3 req = new BRequest_RemoteListTypes_getInt3();			
			Task<IList<IList<int>>> task = Task<IList<IList<int>>>.Factory.FromAsync(transport.BeginSend<IList<IList<int>>>, transport.EndSend<IList<IList<int>>>, req, null);
			return await task;
		}
		
		public void SetInt3(IList<IList<int>> int3) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt3(int3, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt3(IList<IList<int>> int3, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt3 req = new BRequest_RemoteListTypes_setInt3();			
			req._int3 = int3;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt3Async(IList<IList<int>> int3){
			BRequest_RemoteListTypes_setInt3 req = new BRequest_RemoteListTypes_setInt3();			
			req._int3 = int3;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IList<IDictionary<int,IList<HashSet<int>>>> GetInt4() {
			BSyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult = new BSyncResult<IList<IDictionary<int,IList<HashSet<int>>>>>();			
			GetInt4(BAsyncResultHelper.ToDelegate<IList<IDictionary<int,IList<HashSet<int>>>>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt4(BAsyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult) {
			BRequest_RemoteListTypes_getInt4 req = new BRequest_RemoteListTypes_getInt4();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<IDictionary<int,IList<HashSet<int>>>>> GetInt4Async(){
			BRequest_RemoteListTypes_getInt4 req = new BRequest_RemoteListTypes_getInt4();			
			Task<IList<IDictionary<int,IList<HashSet<int>>>>> task = Task<IList<IDictionary<int,IList<HashSet<int>>>>>.Factory.FromAsync(transport.BeginSend<IList<IDictionary<int,IList<HashSet<int>>>>>, transport.EndSend<IList<IDictionary<int,IList<HashSet<int>>>>>, req, null);
			return await task;
		}
		
		public void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt4(int4, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt4 req = new BRequest_RemoteListTypes_setInt4();			
			req._int4 = int4;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt4Async(IList<IDictionary<int,IList<HashSet<int>>>> int4){
			BRequest_RemoteListTypes_setInt4 req = new BRequest_RemoteListTypes_setInt4();			
			req._int4 = int4;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
