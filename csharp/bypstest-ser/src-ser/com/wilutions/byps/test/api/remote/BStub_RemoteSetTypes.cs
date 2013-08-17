using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteSetTypes : BStub, RemoteSetTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 1156008353L;
		
		public BStub_RemoteSetTypes(BTransport transport)
			: base(transport) {}			
		
		public ISet<bool> GetBoolean1() {
			BSyncResult<ISet<bool>> asyncResult = new BSyncResult<ISet<bool>>();			
			async_GetBoolean1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetBoolean1(BAsyncResult<ISet<bool>> asyncResult) {
			BRequest_RemoteSetTypes_getBoolean1 req = new BRequest_RemoteSetTypes_getBoolean1();			
			BAsyncResultReceiveMethod<ISet<bool>> outerResult = new BAsyncResultReceiveMethod<ISet<bool>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<bool>> _byps_ret = new BAsyncProgModel<ISet<bool>>(callback, state);
			async_GetBoolean1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<bool> EndGetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<bool>>)asyncResult).Result;
		}
		
		public void SetBoolean1(ISet<bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetBoolean1(boolean1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetBoolean1(ISet<bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setBoolean1 req = new BRequest_RemoteSetTypes_setBoolean1();			
			req._boolean1 = boolean1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetBoolean1(ISet<bool> boolean1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetBoolean1(boolean1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public HashSet<byte> GetByte1() {
			BSyncResult<HashSet<byte>> asyncResult = new BSyncResult<HashSet<byte>>();			
			async_GetByte1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetByte1(BAsyncResult<HashSet<byte>> asyncResult) {
			BRequest_RemoteSetTypes_getByte1 req = new BRequest_RemoteSetTypes_getByte1();			
			BAsyncResultReceiveMethod<HashSet<byte>> outerResult = new BAsyncResultReceiveMethod<HashSet<byte>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte1(AsyncCallback callback, object state){
			BAsyncProgModel<HashSet<byte>> _byps_ret = new BAsyncProgModel<HashSet<byte>>(callback, state);
			async_GetByte1(_byps_ret);
			return _byps_ret;
		}
		public 		HashSet<byte> EndGetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<HashSet<byte>>)asyncResult).Result;
		}
		
		public void SetByte1(HashSet<byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetByte1(byte1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetByte1(HashSet<byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setByte1 req = new BRequest_RemoteSetTypes_setByte1();			
			req._byte1 = byte1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte1(HashSet<byte> byte1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetByte1(byte1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public HashSet<char> GetChar1() {
			BSyncResult<HashSet<char>> asyncResult = new BSyncResult<HashSet<char>>();			
			async_GetChar1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetChar1(BAsyncResult<HashSet<char>> asyncResult) {
			BRequest_RemoteSetTypes_getChar1 req = new BRequest_RemoteSetTypes_getChar1();			
			BAsyncResultReceiveMethod<HashSet<char>> outerResult = new BAsyncResultReceiveMethod<HashSet<char>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetChar1(AsyncCallback callback, object state){
			BAsyncProgModel<HashSet<char>> _byps_ret = new BAsyncProgModel<HashSet<char>>(callback, state);
			async_GetChar1(_byps_ret);
			return _byps_ret;
		}
		public 		HashSet<char> EndGetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<HashSet<char>>)asyncResult).Result;
		}
		
		public void SetChar1(HashSet<char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetChar1(char1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetChar1(HashSet<char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setChar1 req = new BRequest_RemoteSetTypes_setChar1();			
			req._char1 = char1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetChar1(HashSet<char> char1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetChar1(char1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<short> GetShort1() {
			BSyncResult<ISet<short>> asyncResult = new BSyncResult<ISet<short>>();			
			async_GetShort1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetShort1(BAsyncResult<ISet<short>> asyncResult) {
			BRequest_RemoteSetTypes_getShort1 req = new BRequest_RemoteSetTypes_getShort1();			
			BAsyncResultReceiveMethod<ISet<short>> outerResult = new BAsyncResultReceiveMethod<ISet<short>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetShort1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<short>> _byps_ret = new BAsyncProgModel<ISet<short>>(callback, state);
			async_GetShort1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<short> EndGetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<short>>)asyncResult).Result;
		}
		
		public void SetShort1(ISet<short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetShort1(short1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetShort1(ISet<short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setShort1 req = new BRequest_RemoteSetTypes_setShort1();			
			req._short1 = short1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetShort1(ISet<short> short1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetShort1(short1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<int> GetInt1() {
			BSyncResult<ISet<int>> asyncResult = new BSyncResult<ISet<int>>();			
			async_GetInt1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt1(BAsyncResult<ISet<int>> asyncResult) {
			BRequest_RemoteSetTypes_getInt1 req = new BRequest_RemoteSetTypes_getInt1();			
			BAsyncResultReceiveMethod<ISet<int>> outerResult = new BAsyncResultReceiveMethod<ISet<int>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<int>> _byps_ret = new BAsyncProgModel<ISet<int>>(callback, state);
			async_GetInt1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<int> EndGetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<int>>)asyncResult).Result;
		}
		
		public void SetInt1(ISet<int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt1(int1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt1(ISet<int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setInt1 req = new BRequest_RemoteSetTypes_setInt1();			
			req._int1 = int1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt1(ISet<int> int1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt1(int1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<long> GetLong1() {
			BSyncResult<ISet<long>> asyncResult = new BSyncResult<ISet<long>>();			
			async_GetLong1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetLong1(BAsyncResult<ISet<long>> asyncResult) {
			BRequest_RemoteSetTypes_getLong1 req = new BRequest_RemoteSetTypes_getLong1();			
			BAsyncResultReceiveMethod<ISet<long>> outerResult = new BAsyncResultReceiveMethod<ISet<long>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetLong1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<long>> _byps_ret = new BAsyncProgModel<ISet<long>>(callback, state);
			async_GetLong1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<long> EndGetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<long>>)asyncResult).Result;
		}
		
		public void SetLong1(ISet<long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetLong1(long1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetLong1(ISet<long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setLong1 req = new BRequest_RemoteSetTypes_setLong1();			
			req._long1 = long1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetLong1(ISet<long> long1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetLong1(long1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<float> GetFloat1() {
			BSyncResult<ISet<float>> asyncResult = new BSyncResult<ISet<float>>();			
			async_GetFloat1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetFloat1(BAsyncResult<ISet<float>> asyncResult) {
			BRequest_RemoteSetTypes_getFloat1 req = new BRequest_RemoteSetTypes_getFloat1();			
			BAsyncResultReceiveMethod<ISet<float>> outerResult = new BAsyncResultReceiveMethod<ISet<float>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetFloat1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<float>> _byps_ret = new BAsyncProgModel<ISet<float>>(callback, state);
			async_GetFloat1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<float> EndGetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<float>>)asyncResult).Result;
		}
		
		public void SetFloat1(ISet<float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetFloat1(float1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetFloat1(ISet<float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setFloat1 req = new BRequest_RemoteSetTypes_setFloat1();			
			req._float1 = float1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetFloat1(ISet<float> float1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetFloat1(float1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<double> GetDouble1() {
			BSyncResult<ISet<double>> asyncResult = new BSyncResult<ISet<double>>();			
			async_GetDouble1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetDouble1(BAsyncResult<ISet<double>> asyncResult) {
			BRequest_RemoteSetTypes_getDouble1 req = new BRequest_RemoteSetTypes_getDouble1();			
			BAsyncResultReceiveMethod<ISet<double>> outerResult = new BAsyncResultReceiveMethod<ISet<double>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetDouble1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<double>> _byps_ret = new BAsyncProgModel<ISet<double>>(callback, state);
			async_GetDouble1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<double> EndGetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<double>>)asyncResult).Result;
		}
		
		public void SetDouble1(ISet<double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetDouble1(double1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetDouble1(ISet<double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setDouble1 req = new BRequest_RemoteSetTypes_setDouble1();			
			req._double1 = double1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetDouble1(ISet<double> double1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetDouble1(double1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<String> GetString1() {
			BSyncResult<ISet<String>> asyncResult = new BSyncResult<ISet<String>>();			
			async_GetString1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetString1(BAsyncResult<ISet<String>> asyncResult) {
			BRequest_RemoteSetTypes_getString1 req = new BRequest_RemoteSetTypes_getString1();			
			BAsyncResultReceiveMethod<ISet<String>> outerResult = new BAsyncResultReceiveMethod<ISet<String>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetString1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<String>> _byps_ret = new BAsyncProgModel<ISet<String>>(callback, state);
			async_GetString1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<String> EndGetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<String>>)asyncResult).Result;
		}
		
		public void SetString1(ISet<String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetString1(string1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetString1(ISet<String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setString1 req = new BRequest_RemoteSetTypes_setString1();			
			req._string1 = string1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetString1(ISet<String> string1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetString1(string1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>();			
			async_GetPrimitiveTypes1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetPrimitiveTypes1(BAsyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteSetTypes_getPrimitiveTypes1 req = new BRequest_RemoteSetTypes_getPrimitiveTypes1();			
			BAsyncResultReceiveMethod<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultReceiveMethod<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> _byps_ret = new BAsyncProgModel<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(callback, state);
			async_GetPrimitiveTypes1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>)asyncResult).Result;
		}
		
		public void SetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetPrimitiveTypes1(primitiveTypes1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setPrimitiveTypes1 req = new BRequest_RemoteSetTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetPrimitiveTypes1(primitiveTypes1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<byte[]> GetByte2() {
			BSyncResult<ISet<byte[]>> asyncResult = new BSyncResult<ISet<byte[]>>();			
			async_GetByte2(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetByte2(BAsyncResult<ISet<byte[]>> asyncResult) {
			BRequest_RemoteSetTypes_getByte2 req = new BRequest_RemoteSetTypes_getByte2();			
			BAsyncResultReceiveMethod<ISet<byte[]>> outerResult = new BAsyncResultReceiveMethod<ISet<byte[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte2(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<byte[]>> _byps_ret = new BAsyncProgModel<ISet<byte[]>>(callback, state);
			async_GetByte2(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<byte[]> EndGetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<byte[]>>)asyncResult).Result;
		}
		
		public void SetByte2(ISet<byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetByte2(byte2, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetByte2(ISet<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setByte2 req = new BRequest_RemoteSetTypes_setByte2();			
			req._byte2 = byte2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte2(ISet<byte[]> byte2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetByte2(byte2, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<int[]> GetInt2() {
			BSyncResult<ISet<int[]>> asyncResult = new BSyncResult<ISet<int[]>>();			
			async_GetInt2(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt2(BAsyncResult<ISet<int[]>> asyncResult) {
			BRequest_RemoteSetTypes_getInt2 req = new BRequest_RemoteSetTypes_getInt2();			
			BAsyncResultReceiveMethod<ISet<int[]>> outerResult = new BAsyncResultReceiveMethod<ISet<int[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt2(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<int[]>> _byps_ret = new BAsyncProgModel<ISet<int[]>>(callback, state);
			async_GetInt2(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<int[]> EndGetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<int[]>>)asyncResult).Result;
		}
		
		public void SetInt2(ISet<int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt2(int2, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt2(ISet<int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setInt2 req = new BRequest_RemoteSetTypes_setInt2();			
			req._int2 = int2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt2(ISet<int[]> int2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt2(int2, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public ISet<Object> GetObj1() {
			BSyncResult<ISet<Object>> asyncResult = new BSyncResult<ISet<Object>>();			
			async_GetObj1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetObj1(BAsyncResult<ISet<Object>> asyncResult) {
			BRequest_RemoteSetTypes_getObj1 req = new BRequest_RemoteSetTypes_getObj1();			
			BAsyncResultReceiveMethod<ISet<Object>> outerResult = new BAsyncResultReceiveMethod<ISet<Object>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetObj1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<Object>> _byps_ret = new BAsyncProgModel<ISet<Object>>(callback, state);
			async_GetObj1(_byps_ret);
			return _byps_ret;
		}
		public 		ISet<Object> EndGetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<Object>>)asyncResult).Result;
		}
		
		public void SetObj1(ISet<Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetObj1(obj1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetObj1(ISet<Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setObj1 req = new BRequest_RemoteSetTypes_setObj1();			
			req._obj1 = obj1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetObj1(ISet<Object> obj1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetObj1(obj1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		
	}
}
