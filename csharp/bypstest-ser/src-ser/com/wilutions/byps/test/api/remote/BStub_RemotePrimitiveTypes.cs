using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemotePrimitiveTypes : BStub, RemotePrimitiveTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 1341983932L;
		
		public BStub_RemotePrimitiveTypes(BTransport transport)
			: base(transport) {}			
		
		public void VoidFunctionVoid() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_VoidFunctionVoid(asyncResult);
			asyncResult.GetResult();			
		}
		public void async_VoidFunctionVoid(BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_voidFunctionVoid req = new BRequest_RemotePrimitiveTypes_voidFunctionVoid();			
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginVoidFunctionVoid(AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_VoidFunctionVoid(_byps_ret);
			return _byps_ret;
		}
		public 		Object EndVoidFunctionVoid(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetBool(bool v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetBool(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetBool(bool v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setBool req = new BRequest_RemotePrimitiveTypes_setBool();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetBool(bool v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetBool(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetBool(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetByte(byte v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetByte(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetByte(byte v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setByte req = new BRequest_RemotePrimitiveTypes_setByte();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte(byte v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetByte(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetByte(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetChar(char v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetChar(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetChar(char v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setChar req = new BRequest_RemotePrimitiveTypes_setChar();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetChar(char v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetChar(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetChar(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetShort(short v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetShort(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetShort(short v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setShort req = new BRequest_RemotePrimitiveTypes_setShort();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetShort(short v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetShort(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetShort(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetInt(int v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetInt(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetInt(int v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setInt req = new BRequest_RemotePrimitiveTypes_setInt();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt(int v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetInt(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetLong(long v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetLong(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetLong(long v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setLong req = new BRequest_RemotePrimitiveTypes_setLong();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetLong(long v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetLong(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetLong(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetFloat(float v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetFloat(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetFloat(float v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setFloat req = new BRequest_RemotePrimitiveTypes_setFloat();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetFloat(float v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetFloat(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetFloat(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetDouble(double v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetDouble(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetDouble(double v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setDouble req = new BRequest_RemotePrimitiveTypes_setDouble();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetDouble(double v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetDouble(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetDouble(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetString(String v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetString(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetString(String v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setString req = new BRequest_RemotePrimitiveTypes_setString();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetString(String v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetString(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetString(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetPrimitiveTypes(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setPrimitiveTypes req = new BRequest_RemotePrimitiveTypes_setPrimitiveTypes();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetPrimitiveTypes(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetPrimitiveTypes(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetObject(Object v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetObject(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetObject(Object v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setObject req = new BRequest_RemotePrimitiveTypes_setObject();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetObject(Object v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetObject(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetObject(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public bool GetBool() {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			async_GetBool(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetBool(BAsyncResult<bool> asyncResult) {
			BRequest_RemotePrimitiveTypes_getBool req = new BRequest_RemotePrimitiveTypes_getBool();			
			BAsyncResultReceiveMethod<bool> outerResult = new BAsyncResultReceiveMethod<bool>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetBool(AsyncCallback callback, object state){
			BAsyncProgModel<bool> _byps_ret = new BAsyncProgModel<bool>(callback, state);
			async_GetBool(_byps_ret);
			return _byps_ret;
		}
		public 		bool EndGetBool(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<bool>)asyncResult).Result;
		}
		
		public byte GetByte() {
			BSyncResult<byte> asyncResult = new BSyncResult<byte>();			
			async_GetByte(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetByte(BAsyncResult<byte> asyncResult) {
			BRequest_RemotePrimitiveTypes_getByte req = new BRequest_RemotePrimitiveTypes_getByte();			
			BAsyncResultReceiveMethod<byte> outerResult = new BAsyncResultReceiveMethod<byte>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte(AsyncCallback callback, object state){
			BAsyncProgModel<byte> _byps_ret = new BAsyncProgModel<byte>(callback, state);
			async_GetByte(_byps_ret);
			return _byps_ret;
		}
		public 		byte EndGetByte(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<byte>)asyncResult).Result;
		}
		
		public char GetChar() {
			BSyncResult<char> asyncResult = new BSyncResult<char>();			
			async_GetChar(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetChar(BAsyncResult<char> asyncResult) {
			BRequest_RemotePrimitiveTypes_getChar req = new BRequest_RemotePrimitiveTypes_getChar();			
			BAsyncResultReceiveMethod<char> outerResult = new BAsyncResultReceiveMethod<char>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetChar(AsyncCallback callback, object state){
			BAsyncProgModel<char> _byps_ret = new BAsyncProgModel<char>(callback, state);
			async_GetChar(_byps_ret);
			return _byps_ret;
		}
		public 		char EndGetChar(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<char>)asyncResult).Result;
		}
		
		public short GetShort() {
			BSyncResult<short> asyncResult = new BSyncResult<short>();			
			async_GetShort(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetShort(BAsyncResult<short> asyncResult) {
			BRequest_RemotePrimitiveTypes_getShort req = new BRequest_RemotePrimitiveTypes_getShort();			
			BAsyncResultReceiveMethod<short> outerResult = new BAsyncResultReceiveMethod<short>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetShort(AsyncCallback callback, object state){
			BAsyncProgModel<short> _byps_ret = new BAsyncProgModel<short>(callback, state);
			async_GetShort(_byps_ret);
			return _byps_ret;
		}
		public 		short EndGetShort(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<short>)asyncResult).Result;
		}
		
		public int GetInt() {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			async_GetInt(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetInt(BAsyncResult<int> asyncResult) {
			BRequest_RemotePrimitiveTypes_getInt req = new BRequest_RemotePrimitiveTypes_getInt();			
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt(AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			async_GetInt(_byps_ret);
			return _byps_ret;
		}
		public 		int EndGetInt(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		
		public long GetLong() {
			BSyncResult<long> asyncResult = new BSyncResult<long>();			
			async_GetLong(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetLong(BAsyncResult<long> asyncResult) {
			BRequest_RemotePrimitiveTypes_getLong req = new BRequest_RemotePrimitiveTypes_getLong();			
			BAsyncResultReceiveMethod<long> outerResult = new BAsyncResultReceiveMethod<long>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetLong(AsyncCallback callback, object state){
			BAsyncProgModel<long> _byps_ret = new BAsyncProgModel<long>(callback, state);
			async_GetLong(_byps_ret);
			return _byps_ret;
		}
		public 		long EndGetLong(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<long>)asyncResult).Result;
		}
		
		public float GetFloat() {
			BSyncResult<float> asyncResult = new BSyncResult<float>();			
			async_GetFloat(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetFloat(BAsyncResult<float> asyncResult) {
			BRequest_RemotePrimitiveTypes_getFloat req = new BRequest_RemotePrimitiveTypes_getFloat();			
			BAsyncResultReceiveMethod<float> outerResult = new BAsyncResultReceiveMethod<float>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetFloat(AsyncCallback callback, object state){
			BAsyncProgModel<float> _byps_ret = new BAsyncProgModel<float>(callback, state);
			async_GetFloat(_byps_ret);
			return _byps_ret;
		}
		public 		float EndGetFloat(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<float>)asyncResult).Result;
		}
		
		public double GetDouble() {
			BSyncResult<double> asyncResult = new BSyncResult<double>();			
			async_GetDouble(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetDouble(BAsyncResult<double> asyncResult) {
			BRequest_RemotePrimitiveTypes_getDouble req = new BRequest_RemotePrimitiveTypes_getDouble();			
			BAsyncResultReceiveMethod<double> outerResult = new BAsyncResultReceiveMethod<double>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetDouble(AsyncCallback callback, object state){
			BAsyncProgModel<double> _byps_ret = new BAsyncProgModel<double>(callback, state);
			async_GetDouble(_byps_ret);
			return _byps_ret;
		}
		public 		double EndGetDouble(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<double>)asyncResult).Result;
		}
		
		public String GetString() {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			async_GetString(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetString(BAsyncResult<String> asyncResult) {
			BRequest_RemotePrimitiveTypes_getString req = new BRequest_RemotePrimitiveTypes_getString();			
			BAsyncResultReceiveMethod<String> outerResult = new BAsyncResultReceiveMethod<String>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetString(AsyncCallback callback, object state){
			BAsyncProgModel<String> _byps_ret = new BAsyncProgModel<String>(callback, state);
			async_GetString(_byps_ret);
			return _byps_ret;
		}
		public 		String EndGetString(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<String>)asyncResult).Result;
		}
		
		public com.wilutions.byps.test.api.prim.PrimitiveTypes GetPrimitiveTypes() {
			BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes> asyncResult = new BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes>();			
			async_GetPrimitiveTypes(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetPrimitiveTypes(BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes> asyncResult) {
			BRequest_RemotePrimitiveTypes_getPrimitiveTypes req = new BRequest_RemotePrimitiveTypes_getPrimitiveTypes();			
			BAsyncResultReceiveMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPrimitiveTypes(AsyncCallback callback, object state){
			BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes> _byps_ret = new BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes>(callback, state);
			async_GetPrimitiveTypes(_byps_ret);
			return _byps_ret;
		}
		public 		com.wilutions.byps.test.api.prim.PrimitiveTypes EndGetPrimitiveTypes(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes>)asyncResult).Result;
		}
		
		public Object GetObject() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_GetObject(asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_GetObject(BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_getObject req = new BRequest_RemotePrimitiveTypes_getObject();			
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetObject(AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_GetObject(_byps_ret);
			return _byps_ret;
		}
		public 		Object EndGetObject(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SendAllTypes(b, c, s, i, l, f, d, str, pt, o, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_sendAllTypes req = new BRequest_RemotePrimitiveTypes_sendAllTypes();			
			req._b = b;
			req._c = c;
			req._s = s;
			req._i = i;
			req._l = l;
			req._f = f;
			req._d = d;
			req._str = str;
			req._pt = pt;
			req._o = o;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SendAllTypes(b, c, s, i, l, f, d, str, pt, o, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSendAllTypes(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public int Add(int a, int b) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			async_Add(a, b, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_Add(int a, int b, BAsyncResult<int> asyncResult) {
			BRequest_RemotePrimitiveTypes_add req = new BRequest_RemotePrimitiveTypes_add();			
			req._a = a;
			req._b = b;
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginAdd(int a, int b, AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			async_Add(a, b, _byps_ret);
			return _byps_ret;
		}
		public 		int EndAdd(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		
		
	}
}
