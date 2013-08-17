using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteListTypes : BStub, RemoteListTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 380156079L;
		
		public BStub_RemoteListTypes(BTransport transport)
			: base(transport) {}			
		
		public IList<bool> GetBoolean1() {
			BSyncResult<IList<bool>> asyncResult = new BSyncResult<IList<bool>>();			
			async_GetBoolean1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetBoolean1(BAsyncResult<IList<bool>> asyncResult) {
			BRequest_RemoteListTypes_getBoolean1 req = new BRequest_RemoteListTypes_getBoolean1();			
			BAsyncResultReceiveMethod<IList<bool>> outerResult = new BAsyncResultReceiveMethod<IList<bool>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<bool>> _byps_ret = new BAsyncProgModel<IList<bool>>(callback, state);
			async_GetBoolean1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<bool> EndGetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<bool>>)asyncResult).Result;
		}
		
		public void SetBoolean1(IList<bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetBoolean1(boolean1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetBoolean1(IList<bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setBoolean1 req = new BRequest_RemoteListTypes_setBoolean1();			
			req._boolean1 = boolean1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetBoolean1(IList<bool> boolean1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetBoolean1(boolean1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<byte> GetByte1() {
			BSyncResult<IList<byte>> asyncResult = new BSyncResult<IList<byte>>();			
			async_GetByte1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetByte1(BAsyncResult<IList<byte>> asyncResult) {
			BRequest_RemoteListTypes_getByte1 req = new BRequest_RemoteListTypes_getByte1();			
			BAsyncResultReceiveMethod<IList<byte>> outerResult = new BAsyncResultReceiveMethod<IList<byte>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<byte>> _byps_ret = new BAsyncProgModel<IList<byte>>(callback, state);
			async_GetByte1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<byte> EndGetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<byte>>)asyncResult).Result;
		}
		
		public void SetByte1(IList<byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetByte1(byte1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetByte1(IList<byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setByte1 req = new BRequest_RemoteListTypes_setByte1();			
			req._byte1 = byte1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte1(IList<byte> byte1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetByte1(byte1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<char> GetChar1() {
			BSyncResult<IList<char>> asyncResult = new BSyncResult<IList<char>>();			
			async_GetChar1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetChar1(BAsyncResult<IList<char>> asyncResult) {
			BRequest_RemoteListTypes_getChar1 req = new BRequest_RemoteListTypes_getChar1();			
			BAsyncResultReceiveMethod<IList<char>> outerResult = new BAsyncResultReceiveMethod<IList<char>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetChar1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<char>> _byps_ret = new BAsyncProgModel<IList<char>>(callback, state);
			async_GetChar1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<char> EndGetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<char>>)asyncResult).Result;
		}
		
		public void SetChar1(IList<char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetChar1(char1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetChar1(IList<char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setChar1 req = new BRequest_RemoteListTypes_setChar1();			
			req._char1 = char1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetChar1(IList<char> char1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetChar1(char1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<short> GetShort1() {
			BSyncResult<IList<short>> asyncResult = new BSyncResult<IList<short>>();			
			async_GetShort1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetShort1(BAsyncResult<IList<short>> asyncResult) {
			BRequest_RemoteListTypes_getShort1 req = new BRequest_RemoteListTypes_getShort1();			
			BAsyncResultReceiveMethod<IList<short>> outerResult = new BAsyncResultReceiveMethod<IList<short>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetShort1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<short>> _byps_ret = new BAsyncProgModel<IList<short>>(callback, state);
			async_GetShort1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<short> EndGetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<short>>)asyncResult).Result;
		}
		
		public void SetShort1(IList<short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetShort1(short1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetShort1(IList<short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setShort1 req = new BRequest_RemoteListTypes_setShort1();			
			req._short1 = short1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetShort1(IList<short> short1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetShort1(short1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<int> GetInt1() {
			BSyncResult<IList<int>> asyncResult = new BSyncResult<IList<int>>();			
			async_GetInt1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt1(BAsyncResult<IList<int>> asyncResult) {
			BRequest_RemoteListTypes_getInt1 req = new BRequest_RemoteListTypes_getInt1();			
			BAsyncResultReceiveMethod<IList<int>> outerResult = new BAsyncResultReceiveMethod<IList<int>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<int>> _byps_ret = new BAsyncProgModel<IList<int>>(callback, state);
			async_GetInt1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<int> EndGetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<int>>)asyncResult).Result;
		}
		
		public void SetInt1(IList<int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt1(int1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt1(IList<int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt1 req = new BRequest_RemoteListTypes_setInt1();			
			req._int1 = int1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt1(IList<int> int1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt1(int1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<long> GetLong1() {
			BSyncResult<IList<long>> asyncResult = new BSyncResult<IList<long>>();			
			async_GetLong1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetLong1(BAsyncResult<IList<long>> asyncResult) {
			BRequest_RemoteListTypes_getLong1 req = new BRequest_RemoteListTypes_getLong1();			
			BAsyncResultReceiveMethod<IList<long>> outerResult = new BAsyncResultReceiveMethod<IList<long>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetLong1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<long>> _byps_ret = new BAsyncProgModel<IList<long>>(callback, state);
			async_GetLong1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<long> EndGetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<long>>)asyncResult).Result;
		}
		
		public void SetLong1(IList<long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetLong1(long1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetLong1(IList<long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setLong1 req = new BRequest_RemoteListTypes_setLong1();			
			req._long1 = long1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetLong1(IList<long> long1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetLong1(long1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<float> GetFloat1() {
			BSyncResult<IList<float>> asyncResult = new BSyncResult<IList<float>>();			
			async_GetFloat1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetFloat1(BAsyncResult<IList<float>> asyncResult) {
			BRequest_RemoteListTypes_getFloat1 req = new BRequest_RemoteListTypes_getFloat1();			
			BAsyncResultReceiveMethod<IList<float>> outerResult = new BAsyncResultReceiveMethod<IList<float>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetFloat1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<float>> _byps_ret = new BAsyncProgModel<IList<float>>(callback, state);
			async_GetFloat1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<float> EndGetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<float>>)asyncResult).Result;
		}
		
		public void SetFloat1(IList<float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetFloat1(float1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetFloat1(IList<float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setFloat1 req = new BRequest_RemoteListTypes_setFloat1();			
			req._float1 = float1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetFloat1(IList<float> float1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetFloat1(float1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<double> GetDouble1() {
			BSyncResult<IList<double>> asyncResult = new BSyncResult<IList<double>>();			
			async_GetDouble1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetDouble1(BAsyncResult<IList<double>> asyncResult) {
			BRequest_RemoteListTypes_getDouble1 req = new BRequest_RemoteListTypes_getDouble1();			
			BAsyncResultReceiveMethod<IList<double>> outerResult = new BAsyncResultReceiveMethod<IList<double>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetDouble1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<double>> _byps_ret = new BAsyncProgModel<IList<double>>(callback, state);
			async_GetDouble1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<double> EndGetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<double>>)asyncResult).Result;
		}
		
		public void SetDouble1(IList<double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetDouble1(double1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetDouble1(IList<double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setDouble1 req = new BRequest_RemoteListTypes_setDouble1();			
			req._double1 = double1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetDouble1(IList<double> double1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetDouble1(double1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<String> GetString1() {
			BSyncResult<IList<String>> asyncResult = new BSyncResult<IList<String>>();			
			async_GetString1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetString1(BAsyncResult<IList<String>> asyncResult) {
			BRequest_RemoteListTypes_getString1 req = new BRequest_RemoteListTypes_getString1();			
			BAsyncResultReceiveMethod<IList<String>> outerResult = new BAsyncResultReceiveMethod<IList<String>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetString1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<String>> _byps_ret = new BAsyncProgModel<IList<String>>(callback, state);
			async_GetString1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<String> EndGetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<String>>)asyncResult).Result;
		}
		
		public void SetString1(IList<String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetString1(string1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetString1(IList<String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setString1 req = new BRequest_RemoteListTypes_setString1();			
			req._string1 = string1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetString1(IList<String> string1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetString1(string1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>();			
			async_GetPrimitiveTypes1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetPrimitiveTypes1(BAsyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteListTypes_getPrimitiveTypes1 req = new BRequest_RemoteListTypes_getPrimitiveTypes1();			
			BAsyncResultReceiveMethod<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultReceiveMethod<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> _byps_ret = new BAsyncProgModel<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(callback, state);
			async_GetPrimitiveTypes1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>)asyncResult).Result;
		}
		
		public void SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetPrimitiveTypes1(primitiveTypes1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setPrimitiveTypes1 req = new BRequest_RemoteListTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetPrimitiveTypes1(primitiveTypes1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<byte[]> GetByte2() {
			BSyncResult<IList<byte[]>> asyncResult = new BSyncResult<IList<byte[]>>();			
			async_GetByte2(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetByte2(BAsyncResult<IList<byte[]>> asyncResult) {
			BRequest_RemoteListTypes_getByte2 req = new BRequest_RemoteListTypes_getByte2();			
			BAsyncResultReceiveMethod<IList<byte[]>> outerResult = new BAsyncResultReceiveMethod<IList<byte[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte2(AsyncCallback callback, object state){
			BAsyncProgModel<IList<byte[]>> _byps_ret = new BAsyncProgModel<IList<byte[]>>(callback, state);
			async_GetByte2(_byps_ret);
			return _byps_ret;
		}
		public 		IList<byte[]> EndGetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<byte[]>>)asyncResult).Result;
		}
		
		public void SetByte2(IList<byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetByte2(byte2, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetByte2(IList<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setByte2 req = new BRequest_RemoteListTypes_setByte2();			
			req._byte2 = byte2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte2(IList<byte[]> byte2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetByte2(byte2, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<int[]> GetInt2() {
			BSyncResult<IList<int[]>> asyncResult = new BSyncResult<IList<int[]>>();			
			async_GetInt2(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt2(BAsyncResult<IList<int[]>> asyncResult) {
			BRequest_RemoteListTypes_getInt2 req = new BRequest_RemoteListTypes_getInt2();			
			BAsyncResultReceiveMethod<IList<int[]>> outerResult = new BAsyncResultReceiveMethod<IList<int[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt2(AsyncCallback callback, object state){
			BAsyncProgModel<IList<int[]>> _byps_ret = new BAsyncProgModel<IList<int[]>>(callback, state);
			async_GetInt2(_byps_ret);
			return _byps_ret;
		}
		public 		IList<int[]> EndGetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<int[]>>)asyncResult).Result;
		}
		
		public void SetInt2(IList<int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt2(int2, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt2(IList<int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt2 req = new BRequest_RemoteListTypes_setInt2();			
			req._int2 = int2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt2(IList<int[]> int2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt2(int2, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<Object> GetObj1() {
			BSyncResult<IList<Object>> asyncResult = new BSyncResult<IList<Object>>();			
			async_GetObj1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetObj1(BAsyncResult<IList<Object>> asyncResult) {
			BRequest_RemoteListTypes_getObj1 req = new BRequest_RemoteListTypes_getObj1();			
			BAsyncResultReceiveMethod<IList<Object>> outerResult = new BAsyncResultReceiveMethod<IList<Object>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetObj1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<Object>> _byps_ret = new BAsyncProgModel<IList<Object>>(callback, state);
			async_GetObj1(_byps_ret);
			return _byps_ret;
		}
		public 		IList<Object> EndGetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<Object>>)asyncResult).Result;
		}
		
		public void SetObj1(IList<Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetObj1(obj1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetObj1(IList<Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setObj1 req = new BRequest_RemoteListTypes_setObj1();			
			req._obj1 = obj1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetObj1(IList<Object> obj1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetObj1(obj1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<IList<int>> GetInt3() {
			BSyncResult<IList<IList<int>>> asyncResult = new BSyncResult<IList<IList<int>>>();			
			async_GetInt3(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt3(BAsyncResult<IList<IList<int>>> asyncResult) {
			BRequest_RemoteListTypes_getInt3 req = new BRequest_RemoteListTypes_getInt3();			
			BAsyncResultReceiveMethod<IList<IList<int>>> outerResult = new BAsyncResultReceiveMethod<IList<IList<int>>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt3(AsyncCallback callback, object state){
			BAsyncProgModel<IList<IList<int>>> _byps_ret = new BAsyncProgModel<IList<IList<int>>>(callback, state);
			async_GetInt3(_byps_ret);
			return _byps_ret;
		}
		public 		IList<IList<int>> EndGetInt3(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<IList<int>>>)asyncResult).Result;
		}
		
		public void SetInt3(IList<IList<int>> int3) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt3(int3, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt3(IList<IList<int>> int3, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt3 req = new BRequest_RemoteListTypes_setInt3();			
			req._int3 = int3;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt3(IList<IList<int>> int3, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt3(int3, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt3(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IList<IDictionary<int,IList<HashSet<int>>>> GetInt4() {
			BSyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult = new BSyncResult<IList<IDictionary<int,IList<HashSet<int>>>>>();			
			async_GetInt4(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt4(BAsyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult) {
			BRequest_RemoteListTypes_getInt4 req = new BRequest_RemoteListTypes_getInt4();			
			BAsyncResultReceiveMethod<IList<IDictionary<int,IList<HashSet<int>>>>> outerResult = new BAsyncResultReceiveMethod<IList<IDictionary<int,IList<HashSet<int>>>>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt4(AsyncCallback callback, object state){
			BAsyncProgModel<IList<IDictionary<int,IList<HashSet<int>>>>> _byps_ret = new BAsyncProgModel<IList<IDictionary<int,IList<HashSet<int>>>>>(callback, state);
			async_GetInt4(_byps_ret);
			return _byps_ret;
		}
		public 		IList<IDictionary<int,IList<HashSet<int>>>> EndGetInt4(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<IDictionary<int,IList<HashSet<int>>>>>)asyncResult).Result;
		}
		
		public void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt4(int4, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt4 req = new BRequest_RemoteListTypes_setInt4();			
			req._int4 = int4;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt4(int4, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt4(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		
	}
}
