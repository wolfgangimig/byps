using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteMapTypes : BStub, RemoteMapTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 664304990L;
		
		public BStub_RemoteMapTypes(BTransport transport)
			: base(transport) {}			
		
		public IDictionary<String,bool> GetBoolean1() {
			BSyncResult<IDictionary<String,bool>> asyncResult = new BSyncResult<IDictionary<String,bool>>();			
			GetBoolean1(BAsyncResultHelper.ToDelegate<IDictionary<String,bool>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetBoolean1(BAsyncResult<IDictionary<String,bool>> asyncResult) {
			BRequest_RemoteMapTypes_getBoolean1 req = new BRequest_RemoteMapTypes_getBoolean1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<String,bool>> GetBoolean1Async(){
			BRequest_RemoteMapTypes_getBoolean1 req = new BRequest_RemoteMapTypes_getBoolean1();			
			Task<IDictionary<String,bool>> task = Task<IDictionary<String,bool>>.Factory.FromAsync(transport.BeginSend<IDictionary<String,bool>>, transport.EndSend<IDictionary<String,bool>>, req, null);
			return await task;
		}
		
		public void SetBoolean1(IDictionary<String,bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBoolean1(boolean1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetBoolean1(IDictionary<String,bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setBoolean1 req = new BRequest_RemoteMapTypes_setBoolean1();			
			req._boolean1 = boolean1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetBoolean1Async(IDictionary<String,bool> boolean1){
			BRequest_RemoteMapTypes_setBoolean1 req = new BRequest_RemoteMapTypes_setBoolean1();			
			req._boolean1 = boolean1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public Dictionary<double,byte> GetByte1() {
			BSyncResult<Dictionary<double,byte>> asyncResult = new BSyncResult<Dictionary<double,byte>>();			
			GetByte1(BAsyncResultHelper.ToDelegate<Dictionary<double,byte>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetByte1(BAsyncResult<Dictionary<double,byte>> asyncResult) {
			BRequest_RemoteMapTypes_getByte1 req = new BRequest_RemoteMapTypes_getByte1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<Dictionary<double,byte>> GetByte1Async(){
			BRequest_RemoteMapTypes_getByte1 req = new BRequest_RemoteMapTypes_getByte1();			
			Task<Dictionary<double,byte>> task = Task<Dictionary<double,byte>>.Factory.FromAsync(transport.BeginSend<Dictionary<double,byte>>, transport.EndSend<Dictionary<double,byte>>, req, null);
			return await task;
		}
		
		public void SetByte1(Dictionary<double,byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte1(byte1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetByte1(Dictionary<double,byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setByte1 req = new BRequest_RemoteMapTypes_setByte1();			
			req._byte1 = byte1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetByte1Async(Dictionary<double,byte> byte1){
			BRequest_RemoteMapTypes_setByte1 req = new BRequest_RemoteMapTypes_setByte1();			
			req._byte1 = byte1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public Dictionary<float,char> GetChar1() {
			BSyncResult<Dictionary<float,char>> asyncResult = new BSyncResult<Dictionary<float,char>>();			
			GetChar1(BAsyncResultHelper.ToDelegate<Dictionary<float,char>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetChar1(BAsyncResult<Dictionary<float,char>> asyncResult) {
			BRequest_RemoteMapTypes_getChar1 req = new BRequest_RemoteMapTypes_getChar1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<Dictionary<float,char>> GetChar1Async(){
			BRequest_RemoteMapTypes_getChar1 req = new BRequest_RemoteMapTypes_getChar1();			
			Task<Dictionary<float,char>> task = Task<Dictionary<float,char>>.Factory.FromAsync(transport.BeginSend<Dictionary<float,char>>, transport.EndSend<Dictionary<float,char>>, req, null);
			return await task;
		}
		
		public void SetChar1(Dictionary<float,char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar1(char1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetChar1(Dictionary<float,char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setChar1 req = new BRequest_RemoteMapTypes_setChar1();			
			req._char1 = char1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetChar1Async(Dictionary<float,char> char1){
			BRequest_RemoteMapTypes_setChar1 req = new BRequest_RemoteMapTypes_setChar1();			
			req._char1 = char1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<long,short> GetShort1() {
			BSyncResult<IDictionary<long,short>> asyncResult = new BSyncResult<IDictionary<long,short>>();			
			GetShort1(BAsyncResultHelper.ToDelegate<IDictionary<long,short>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetShort1(BAsyncResult<IDictionary<long,short>> asyncResult) {
			BRequest_RemoteMapTypes_getShort1 req = new BRequest_RemoteMapTypes_getShort1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<long,short>> GetShort1Async(){
			BRequest_RemoteMapTypes_getShort1 req = new BRequest_RemoteMapTypes_getShort1();			
			Task<IDictionary<long,short>> task = Task<IDictionary<long,short>>.Factory.FromAsync(transport.BeginSend<IDictionary<long,short>>, transport.EndSend<IDictionary<long,short>>, req, null);
			return await task;
		}
		
		public void SetShort1(IDictionary<long,short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort1(short1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetShort1(IDictionary<long,short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setShort1 req = new BRequest_RemoteMapTypes_setShort1();			
			req._short1 = short1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetShort1Async(IDictionary<long,short> short1){
			BRequest_RemoteMapTypes_setShort1 req = new BRequest_RemoteMapTypes_setShort1();			
			req._short1 = short1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<int,int> GetInt1() {
			BSyncResult<IDictionary<int,int>> asyncResult = new BSyncResult<IDictionary<int,int>>();			
			GetInt1(BAsyncResultHelper.ToDelegate<IDictionary<int,int>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt1(BAsyncResult<IDictionary<int,int>> asyncResult) {
			BRequest_RemoteMapTypes_getInt1 req = new BRequest_RemoteMapTypes_getInt1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<int,int>> GetInt1Async(){
			BRequest_RemoteMapTypes_getInt1 req = new BRequest_RemoteMapTypes_getInt1();			
			Task<IDictionary<int,int>> task = Task<IDictionary<int,int>>.Factory.FromAsync(transport.BeginSend<IDictionary<int,int>>, transport.EndSend<IDictionary<int,int>>, req, null);
			return await task;
		}
		
		public void SetInt1(IDictionary<int,int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt1(int1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt1(IDictionary<int,int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setInt1 req = new BRequest_RemoteMapTypes_setInt1();			
			req._int1 = int1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt1Async(IDictionary<int,int> int1){
			BRequest_RemoteMapTypes_setInt1 req = new BRequest_RemoteMapTypes_setInt1();			
			req._int1 = int1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<short,long> GetLong1() {
			BSyncResult<IDictionary<short,long>> asyncResult = new BSyncResult<IDictionary<short,long>>();			
			GetLong1(BAsyncResultHelper.ToDelegate<IDictionary<short,long>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetLong1(BAsyncResult<IDictionary<short,long>> asyncResult) {
			BRequest_RemoteMapTypes_getLong1 req = new BRequest_RemoteMapTypes_getLong1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<short,long>> GetLong1Async(){
			BRequest_RemoteMapTypes_getLong1 req = new BRequest_RemoteMapTypes_getLong1();			
			Task<IDictionary<short,long>> task = Task<IDictionary<short,long>>.Factory.FromAsync(transport.BeginSend<IDictionary<short,long>>, transport.EndSend<IDictionary<short,long>>, req, null);
			return await task;
		}
		
		public void SetLong1(IDictionary<short,long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong1(long1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetLong1(IDictionary<short,long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setLong1 req = new BRequest_RemoteMapTypes_setLong1();			
			req._long1 = long1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetLong1Async(IDictionary<short,long> long1){
			BRequest_RemoteMapTypes_setLong1 req = new BRequest_RemoteMapTypes_setLong1();			
			req._long1 = long1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<char,float> GetFloat1() {
			BSyncResult<IDictionary<char,float>> asyncResult = new BSyncResult<IDictionary<char,float>>();			
			GetFloat1(BAsyncResultHelper.ToDelegate<IDictionary<char,float>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetFloat1(BAsyncResult<IDictionary<char,float>> asyncResult) {
			BRequest_RemoteMapTypes_getFloat1 req = new BRequest_RemoteMapTypes_getFloat1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<char,float>> GetFloat1Async(){
			BRequest_RemoteMapTypes_getFloat1 req = new BRequest_RemoteMapTypes_getFloat1();			
			Task<IDictionary<char,float>> task = Task<IDictionary<char,float>>.Factory.FromAsync(transport.BeginSend<IDictionary<char,float>>, transport.EndSend<IDictionary<char,float>>, req, null);
			return await task;
		}
		
		public void SetFloat1(IDictionary<char,float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat1(float1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetFloat1(IDictionary<char,float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setFloat1 req = new BRequest_RemoteMapTypes_setFloat1();			
			req._float1 = float1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetFloat1Async(IDictionary<char,float> float1){
			BRequest_RemoteMapTypes_setFloat1 req = new BRequest_RemoteMapTypes_setFloat1();			
			req._float1 = float1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<byte,double> GetDouble1() {
			BSyncResult<IDictionary<byte,double>> asyncResult = new BSyncResult<IDictionary<byte,double>>();			
			GetDouble1(BAsyncResultHelper.ToDelegate<IDictionary<byte,double>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetDouble1(BAsyncResult<IDictionary<byte,double>> asyncResult) {
			BRequest_RemoteMapTypes_getDouble1 req = new BRequest_RemoteMapTypes_getDouble1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<byte,double>> GetDouble1Async(){
			BRequest_RemoteMapTypes_getDouble1 req = new BRequest_RemoteMapTypes_getDouble1();			
			Task<IDictionary<byte,double>> task = Task<IDictionary<byte,double>>.Factory.FromAsync(transport.BeginSend<IDictionary<byte,double>>, transport.EndSend<IDictionary<byte,double>>, req, null);
			return await task;
		}
		
		public void SetDouble1(IDictionary<byte,double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble1(double1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetDouble1(IDictionary<byte,double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setDouble1 req = new BRequest_RemoteMapTypes_setDouble1();			
			req._double1 = double1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetDouble1Async(IDictionary<byte,double> double1){
			BRequest_RemoteMapTypes_setDouble1 req = new BRequest_RemoteMapTypes_setDouble1();			
			req._double1 = double1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<String,String> GetString1() {
			BSyncResult<IDictionary<String,String>> asyncResult = new BSyncResult<IDictionary<String,String>>();			
			GetString1(BAsyncResultHelper.ToDelegate<IDictionary<String,String>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetString1(BAsyncResult<IDictionary<String,String>> asyncResult) {
			BRequest_RemoteMapTypes_getString1 req = new BRequest_RemoteMapTypes_getString1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<String,String>> GetString1Async(){
			BRequest_RemoteMapTypes_getString1 req = new BRequest_RemoteMapTypes_getString1();			
			Task<IDictionary<String,String>> task = Task<IDictionary<String,String>>.Factory.FromAsync(transport.BeginSend<IDictionary<String,String>>, transport.EndSend<IDictionary<String,String>>, req, null);
			return await task;
		}
		
		public void SetString1(IDictionary<String,String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString1(string1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetString1(IDictionary<String,String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setString1 req = new BRequest_RemoteMapTypes_setString1();			
			req._string1 = string1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetString1Async(IDictionary<String,String> string1){
			BRequest_RemoteMapTypes_setString1 req = new BRequest_RemoteMapTypes_setString1();			
			req._string1 = string1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<int,byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<IDictionary<int,byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<IDictionary<int,byps.test.api.prim.PrimitiveTypes>>();			
			GetPrimitiveTypes1(BAsyncResultHelper.ToDelegate<IDictionary<int,byps.test.api.prim.PrimitiveTypes>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPrimitiveTypes1(BAsyncResult<IDictionary<int,byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteMapTypes_getPrimitiveTypes1 req = new BRequest_RemoteMapTypes_getPrimitiveTypes1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<int,byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Async(){
			BRequest_RemoteMapTypes_getPrimitiveTypes1 req = new BRequest_RemoteMapTypes_getPrimitiveTypes1();			
			Task<IDictionary<int,byps.test.api.prim.PrimitiveTypes>> task = Task<IDictionary<int,byps.test.api.prim.PrimitiveTypes>>.Factory.FromAsync(transport.BeginSend<IDictionary<int,byps.test.api.prim.PrimitiveTypes>>, transport.EndSend<IDictionary<int,byps.test.api.prim.PrimitiveTypes>>, req, null);
			return await task;
		}
		
		public void SetPrimitiveTypes1(IDictionary<int,byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes1(primitiveTypes1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPrimitiveTypes1(IDictionary<int,byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setPrimitiveTypes1 req = new BRequest_RemoteMapTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPrimitiveTypes1Async(IDictionary<int,byps.test.api.prim.PrimitiveTypes> primitiveTypes1){
			BRequest_RemoteMapTypes_setPrimitiveTypes1 req = new BRequest_RemoteMapTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<int,byte[]> GetByte2() {
			BSyncResult<IDictionary<int,byte[]>> asyncResult = new BSyncResult<IDictionary<int,byte[]>>();			
			GetByte2(BAsyncResultHelper.ToDelegate<IDictionary<int,byte[]>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetByte2(BAsyncResult<IDictionary<int,byte[]>> asyncResult) {
			BRequest_RemoteMapTypes_getByte2 req = new BRequest_RemoteMapTypes_getByte2();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<int,byte[]>> GetByte2Async(){
			BRequest_RemoteMapTypes_getByte2 req = new BRequest_RemoteMapTypes_getByte2();			
			Task<IDictionary<int,byte[]>> task = Task<IDictionary<int,byte[]>>.Factory.FromAsync(transport.BeginSend<IDictionary<int,byte[]>>, transport.EndSend<IDictionary<int,byte[]>>, req, null);
			return await task;
		}
		
		public void SetByte2(IDictionary<int,byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte2(byte2, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetByte2(IDictionary<int,byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setByte2 req = new BRequest_RemoteMapTypes_setByte2();			
			req._byte2 = byte2;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetByte2Async(IDictionary<int,byte[]> byte2){
			BRequest_RemoteMapTypes_setByte2 req = new BRequest_RemoteMapTypes_setByte2();			
			req._byte2 = byte2;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<int,int[]> GetInt2() {
			BSyncResult<IDictionary<int,int[]>> asyncResult = new BSyncResult<IDictionary<int,int[]>>();			
			GetInt2(BAsyncResultHelper.ToDelegate<IDictionary<int,int[]>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt2(BAsyncResult<IDictionary<int,int[]>> asyncResult) {
			BRequest_RemoteMapTypes_getInt2 req = new BRequest_RemoteMapTypes_getInt2();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<int,int[]>> GetInt2Async(){
			BRequest_RemoteMapTypes_getInt2 req = new BRequest_RemoteMapTypes_getInt2();			
			Task<IDictionary<int,int[]>> task = Task<IDictionary<int,int[]>>.Factory.FromAsync(transport.BeginSend<IDictionary<int,int[]>>, transport.EndSend<IDictionary<int,int[]>>, req, null);
			return await task;
		}
		
		public void SetInt2(IDictionary<int,int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt2(int2, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt2(IDictionary<int,int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setInt2 req = new BRequest_RemoteMapTypes_setInt2();			
			req._int2 = int2;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt2Async(IDictionary<int,int[]> int2){
			BRequest_RemoteMapTypes_setInt2 req = new BRequest_RemoteMapTypes_setInt2();			
			req._int2 = int2;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public IDictionary<String,Object> GetObj1() {
			BSyncResult<IDictionary<String,Object>> asyncResult = new BSyncResult<IDictionary<String,Object>>();			
			GetObj1(BAsyncResultHelper.ToDelegate<IDictionary<String,Object>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetObj1(BAsyncResult<IDictionary<String,Object>> asyncResult) {
			BRequest_RemoteMapTypes_getObj1 req = new BRequest_RemoteMapTypes_getObj1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IDictionary<String,Object>> GetObj1Async(){
			BRequest_RemoteMapTypes_getObj1 req = new BRequest_RemoteMapTypes_getObj1();			
			Task<IDictionary<String,Object>> task = Task<IDictionary<String,Object>>.Factory.FromAsync(transport.BeginSend<IDictionary<String,Object>>, transport.EndSend<IDictionary<String,Object>>, req, null);
			return await task;
		}
		
		public void SetObj1(IDictionary<String,Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObj1(obj1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetObj1(IDictionary<String,Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setObj1 req = new BRequest_RemoteMapTypes_setObj1();			
			req._obj1 = obj1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetObj1Async(IDictionary<String,Object> obj1){
			BRequest_RemoteMapTypes_setObj1 req = new BRequest_RemoteMapTypes_setObj1();			
			req._obj1 = obj1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
