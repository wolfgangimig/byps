using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteMapTypes : BStub, RemoteMapTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 80483097L;
		
		public BStub_RemoteMapTypes(BTransport transport)
			: base(transport) {}			
		
		public IDictionary<String,bool> GetBoolean1() {
			BSyncResult<IDictionary<String,bool>> asyncResult = new BSyncResult<IDictionary<String,bool>>();			
			async_GetBoolean1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetBoolean1(BAsyncResult<IDictionary<String,bool>> asyncResult) {
			BRequest_RemoteMapTypes_getBoolean1 req = new BRequest_RemoteMapTypes_getBoolean1();			
			BAsyncResultReceiveMethod<IDictionary<String,bool>> outerResult = new BAsyncResultReceiveMethod<IDictionary<String,bool>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<String,bool>> _byps_ret = new BAsyncProgModel<IDictionary<String,bool>>(callback, state);
			async_GetBoolean1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<String,bool> EndGetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<String,bool>>)asyncResult).Result;
		}
		
		public void SetBoolean1(IDictionary<String,bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetBoolean1(boolean1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetBoolean1(IDictionary<String,bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setBoolean1 req = new BRequest_RemoteMapTypes_setBoolean1();			
			req._boolean1 = boolean1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetBoolean1(IDictionary<String,bool> boolean1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetBoolean1(boolean1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public Dictionary<double,byte> GetByte1() {
			BSyncResult<Dictionary<double,byte>> asyncResult = new BSyncResult<Dictionary<double,byte>>();			
			async_GetByte1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetByte1(BAsyncResult<Dictionary<double,byte>> asyncResult) {
			BRequest_RemoteMapTypes_getByte1 req = new BRequest_RemoteMapTypes_getByte1();			
			BAsyncResultReceiveMethod<Dictionary<double,byte>> outerResult = new BAsyncResultReceiveMethod<Dictionary<double,byte>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte1(AsyncCallback callback, object state){
			BAsyncProgModel<Dictionary<double,byte>> _byps_ret = new BAsyncProgModel<Dictionary<double,byte>>(callback, state);
			async_GetByte1(_byps_ret);
			return _byps_ret;
		}
		public 		Dictionary<double,byte> EndGetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Dictionary<double,byte>>)asyncResult).Result;
		}
		
		public void SetByte1(Dictionary<double,byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetByte1(byte1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetByte1(Dictionary<double,byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setByte1 req = new BRequest_RemoteMapTypes_setByte1();			
			req._byte1 = byte1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte1(Dictionary<double,byte> byte1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetByte1(byte1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public Dictionary<float,char> GetChar1() {
			BSyncResult<Dictionary<float,char>> asyncResult = new BSyncResult<Dictionary<float,char>>();			
			async_GetChar1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetChar1(BAsyncResult<Dictionary<float,char>> asyncResult) {
			BRequest_RemoteMapTypes_getChar1 req = new BRequest_RemoteMapTypes_getChar1();			
			BAsyncResultReceiveMethod<Dictionary<float,char>> outerResult = new BAsyncResultReceiveMethod<Dictionary<float,char>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetChar1(AsyncCallback callback, object state){
			BAsyncProgModel<Dictionary<float,char>> _byps_ret = new BAsyncProgModel<Dictionary<float,char>>(callback, state);
			async_GetChar1(_byps_ret);
			return _byps_ret;
		}
		public 		Dictionary<float,char> EndGetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Dictionary<float,char>>)asyncResult).Result;
		}
		
		public void SetChar1(Dictionary<float,char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetChar1(char1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetChar1(Dictionary<float,char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setChar1 req = new BRequest_RemoteMapTypes_setChar1();			
			req._char1 = char1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetChar1(Dictionary<float,char> char1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetChar1(char1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<long,short> GetShort1() {
			BSyncResult<IDictionary<long,short>> asyncResult = new BSyncResult<IDictionary<long,short>>();			
			async_GetShort1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetShort1(BAsyncResult<IDictionary<long,short>> asyncResult) {
			BRequest_RemoteMapTypes_getShort1 req = new BRequest_RemoteMapTypes_getShort1();			
			BAsyncResultReceiveMethod<IDictionary<long,short>> outerResult = new BAsyncResultReceiveMethod<IDictionary<long,short>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetShort1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<long,short>> _byps_ret = new BAsyncProgModel<IDictionary<long,short>>(callback, state);
			async_GetShort1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<long,short> EndGetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<long,short>>)asyncResult).Result;
		}
		
		public void SetShort1(IDictionary<long,short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetShort1(short1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetShort1(IDictionary<long,short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setShort1 req = new BRequest_RemoteMapTypes_setShort1();			
			req._short1 = short1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetShort1(IDictionary<long,short> short1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetShort1(short1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<int,int> GetInt1() {
			BSyncResult<IDictionary<int,int>> asyncResult = new BSyncResult<IDictionary<int,int>>();			
			async_GetInt1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt1(BAsyncResult<IDictionary<int,int>> asyncResult) {
			BRequest_RemoteMapTypes_getInt1 req = new BRequest_RemoteMapTypes_getInt1();			
			BAsyncResultReceiveMethod<IDictionary<int,int>> outerResult = new BAsyncResultReceiveMethod<IDictionary<int,int>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<int,int>> _byps_ret = new BAsyncProgModel<IDictionary<int,int>>(callback, state);
			async_GetInt1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<int,int> EndGetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<int,int>>)asyncResult).Result;
		}
		
		public void SetInt1(IDictionary<int,int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt1(int1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt1(IDictionary<int,int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setInt1 req = new BRequest_RemoteMapTypes_setInt1();			
			req._int1 = int1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt1(IDictionary<int,int> int1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt1(int1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<short,long> GetLong1() {
			BSyncResult<IDictionary<short,long>> asyncResult = new BSyncResult<IDictionary<short,long>>();			
			async_GetLong1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetLong1(BAsyncResult<IDictionary<short,long>> asyncResult) {
			BRequest_RemoteMapTypes_getLong1 req = new BRequest_RemoteMapTypes_getLong1();			
			BAsyncResultReceiveMethod<IDictionary<short,long>> outerResult = new BAsyncResultReceiveMethod<IDictionary<short,long>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetLong1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<short,long>> _byps_ret = new BAsyncProgModel<IDictionary<short,long>>(callback, state);
			async_GetLong1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<short,long> EndGetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<short,long>>)asyncResult).Result;
		}
		
		public void SetLong1(IDictionary<short,long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetLong1(long1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetLong1(IDictionary<short,long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setLong1 req = new BRequest_RemoteMapTypes_setLong1();			
			req._long1 = long1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetLong1(IDictionary<short,long> long1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetLong1(long1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<char,float> GetFloat1() {
			BSyncResult<IDictionary<char,float>> asyncResult = new BSyncResult<IDictionary<char,float>>();			
			async_GetFloat1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetFloat1(BAsyncResult<IDictionary<char,float>> asyncResult) {
			BRequest_RemoteMapTypes_getFloat1 req = new BRequest_RemoteMapTypes_getFloat1();			
			BAsyncResultReceiveMethod<IDictionary<char,float>> outerResult = new BAsyncResultReceiveMethod<IDictionary<char,float>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetFloat1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<char,float>> _byps_ret = new BAsyncProgModel<IDictionary<char,float>>(callback, state);
			async_GetFloat1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<char,float> EndGetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<char,float>>)asyncResult).Result;
		}
		
		public void SetFloat1(IDictionary<char,float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetFloat1(float1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetFloat1(IDictionary<char,float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setFloat1 req = new BRequest_RemoteMapTypes_setFloat1();			
			req._float1 = float1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetFloat1(IDictionary<char,float> float1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetFloat1(float1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<byte,double> GetDouble1() {
			BSyncResult<IDictionary<byte,double>> asyncResult = new BSyncResult<IDictionary<byte,double>>();			
			async_GetDouble1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetDouble1(BAsyncResult<IDictionary<byte,double>> asyncResult) {
			BRequest_RemoteMapTypes_getDouble1 req = new BRequest_RemoteMapTypes_getDouble1();			
			BAsyncResultReceiveMethod<IDictionary<byte,double>> outerResult = new BAsyncResultReceiveMethod<IDictionary<byte,double>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetDouble1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<byte,double>> _byps_ret = new BAsyncProgModel<IDictionary<byte,double>>(callback, state);
			async_GetDouble1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<byte,double> EndGetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<byte,double>>)asyncResult).Result;
		}
		
		public void SetDouble1(IDictionary<byte,double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetDouble1(double1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetDouble1(IDictionary<byte,double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setDouble1 req = new BRequest_RemoteMapTypes_setDouble1();			
			req._double1 = double1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetDouble1(IDictionary<byte,double> double1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetDouble1(double1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<String,String> GetString1() {
			BSyncResult<IDictionary<String,String>> asyncResult = new BSyncResult<IDictionary<String,String>>();			
			async_GetString1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetString1(BAsyncResult<IDictionary<String,String>> asyncResult) {
			BRequest_RemoteMapTypes_getString1 req = new BRequest_RemoteMapTypes_getString1();			
			BAsyncResultReceiveMethod<IDictionary<String,String>> outerResult = new BAsyncResultReceiveMethod<IDictionary<String,String>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetString1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<String,String>> _byps_ret = new BAsyncProgModel<IDictionary<String,String>>(callback, state);
			async_GetString1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<String,String> EndGetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<String,String>>)asyncResult).Result;
		}
		
		public void SetString1(IDictionary<String,String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetString1(string1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetString1(IDictionary<String,String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setString1 req = new BRequest_RemoteMapTypes_setString1();			
			req._string1 = string1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetString1(IDictionary<String,String> string1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetString1(string1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>>();			
			async_GetPrimitiveTypes1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetPrimitiveTypes1(BAsyncResult<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteMapTypes_getPrimitiveTypes1 req = new BRequest_RemoteMapTypes_getPrimitiveTypes1();			
			BAsyncResultReceiveMethod<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultReceiveMethod<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>> _byps_ret = new BAsyncProgModel<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>>(callback, state);
			async_GetPrimitiveTypes1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>>)asyncResult).Result;
		}
		
		public void SetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetPrimitiveTypes1(primitiveTypes1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setPrimitiveTypes1 req = new BRequest_RemoteMapTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetPrimitiveTypes1(primitiveTypes1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<int,byte[]> GetByte2() {
			BSyncResult<IDictionary<int,byte[]>> asyncResult = new BSyncResult<IDictionary<int,byte[]>>();			
			async_GetByte2(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetByte2(BAsyncResult<IDictionary<int,byte[]>> asyncResult) {
			BRequest_RemoteMapTypes_getByte2 req = new BRequest_RemoteMapTypes_getByte2();			
			BAsyncResultReceiveMethod<IDictionary<int,byte[]>> outerResult = new BAsyncResultReceiveMethod<IDictionary<int,byte[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte2(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<int,byte[]>> _byps_ret = new BAsyncProgModel<IDictionary<int,byte[]>>(callback, state);
			async_GetByte2(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<int,byte[]> EndGetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<int,byte[]>>)asyncResult).Result;
		}
		
		public void SetByte2(IDictionary<int,byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetByte2(byte2, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetByte2(IDictionary<int,byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setByte2 req = new BRequest_RemoteMapTypes_setByte2();			
			req._byte2 = byte2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte2(IDictionary<int,byte[]> byte2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetByte2(byte2, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<int,int[]> GetInt2() {
			BSyncResult<IDictionary<int,int[]>> asyncResult = new BSyncResult<IDictionary<int,int[]>>();			
			async_GetInt2(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt2(BAsyncResult<IDictionary<int,int[]>> asyncResult) {
			BRequest_RemoteMapTypes_getInt2 req = new BRequest_RemoteMapTypes_getInt2();			
			BAsyncResultReceiveMethod<IDictionary<int,int[]>> outerResult = new BAsyncResultReceiveMethod<IDictionary<int,int[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt2(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<int,int[]>> _byps_ret = new BAsyncProgModel<IDictionary<int,int[]>>(callback, state);
			async_GetInt2(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<int,int[]> EndGetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<int,int[]>>)asyncResult).Result;
		}
		
		public void SetInt2(IDictionary<int,int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt2(int2, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt2(IDictionary<int,int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setInt2 req = new BRequest_RemoteMapTypes_setInt2();			
			req._int2 = int2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt2(IDictionary<int,int[]> int2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt2(int2, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public IDictionary<String,Object> GetObj1() {
			BSyncResult<IDictionary<String,Object>> asyncResult = new BSyncResult<IDictionary<String,Object>>();			
			async_GetObj1(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetObj1(BAsyncResult<IDictionary<String,Object>> asyncResult) {
			BRequest_RemoteMapTypes_getObj1 req = new BRequest_RemoteMapTypes_getObj1();			
			BAsyncResultReceiveMethod<IDictionary<String,Object>> outerResult = new BAsyncResultReceiveMethod<IDictionary<String,Object>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetObj1(AsyncCallback callback, object state){
			BAsyncProgModel<IDictionary<String,Object>> _byps_ret = new BAsyncProgModel<IDictionary<String,Object>>(callback, state);
			async_GetObj1(_byps_ret);
			return _byps_ret;
		}
		public 		IDictionary<String,Object> EndGetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IDictionary<String,Object>>)asyncResult).Result;
		}
		
		public void SetObj1(IDictionary<String,Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetObj1(obj1, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetObj1(IDictionary<String,Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteMapTypes_setObj1 req = new BRequest_RemoteMapTypes_setObj1();			
			req._obj1 = obj1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetObj1(IDictionary<String,Object> obj1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetObj1(obj1, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		
	}
}
