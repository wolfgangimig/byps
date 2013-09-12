using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteArrayTypes1dim : BStub, RemoteArrayTypes1dim, BSerializable {	
		
		public readonly static long serialVersionUID = 1557084481L;
		
		public BStub_RemoteArrayTypes1dim(BTransport transport)
			: base(transport) {}			
		
		public void SetBool(bool[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBoolAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetBoolAsync(bool[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setBool req = new BRequest_RemoteArrayTypes1dim_setBool();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetBool(bool[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetBoolAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetBool(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetByte(byte[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByteAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetByteAsync(byte[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setByte req = new BRequest_RemoteArrayTypes1dim_setByte();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte(byte[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetByteAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetByte(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetChar(char[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetCharAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetCharAsync(char[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setChar req = new BRequest_RemoteArrayTypes1dim_setChar();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetChar(char[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetCharAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetChar(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetShort(short[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShortAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetShortAsync(short[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setShort req = new BRequest_RemoteArrayTypes1dim_setShort();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetShort(short[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetShortAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetShort(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetInt(int[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetIntAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetIntAsync(int[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setInt req = new BRequest_RemoteArrayTypes1dim_setInt();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt(int[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetIntAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetInt(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetLong(long[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLongAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetLongAsync(long[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setLong req = new BRequest_RemoteArrayTypes1dim_setLong();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetLong(long[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetLongAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetLong(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetFloat(float[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloatAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetFloatAsync(float[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setFloat req = new BRequest_RemoteArrayTypes1dim_setFloat();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetFloat(float[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetFloatAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetFloat(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetDouble(double[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDoubleAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetDoubleAsync(double[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setDouble req = new BRequest_RemoteArrayTypes1dim_setDouble();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetDouble(double[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetDoubleAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetDouble(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetString(String[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetStringAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetStringAsync(String[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setString req = new BRequest_RemoteArrayTypes1dim_setString();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetString(String[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetStringAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetString(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypesAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetPrimitiveTypesAsync(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setPrimitiveTypes req = new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetPrimitiveTypesAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetPrimitiveTypes(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetObject(Object[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObjectAsync(v, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetObjectAsync(Object[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setObject req = new BRequest_RemoteArrayTypes1dim_setObject();			
			req._v = v;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetObject(Object[] v, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetObjectAsync(v, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetObject(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public bool[] GetBool() {
			BSyncResult<bool[]> asyncResult = new BSyncResult<bool[]>();			
			GetBoolAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetBoolAsync(BAsyncResult<bool[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getBool req = new BRequest_RemoteArrayTypes1dim_getBool();			
			BAsyncResultReceiveMethod<bool[]> outerResult = new BAsyncResultReceiveMethod<bool[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetBool(AsyncCallback callback, object state){
			BAsyncProgModel<bool[]> _byps_ret = new BAsyncProgModel<bool[]>(callback, state);
			GetBoolAsync(_byps_ret);
			return _byps_ret;
		}
		public 		bool[] EndGetBool(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<bool[]>)asyncResult).Result;
		}
		
		public byte[] GetByte() {
			BSyncResult<byte[]> asyncResult = new BSyncResult<byte[]>();			
			GetByteAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetByteAsync(BAsyncResult<byte[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getByte req = new BRequest_RemoteArrayTypes1dim_getByte();			
			BAsyncResultReceiveMethod<byte[]> outerResult = new BAsyncResultReceiveMethod<byte[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte(AsyncCallback callback, object state){
			BAsyncProgModel<byte[]> _byps_ret = new BAsyncProgModel<byte[]>(callback, state);
			GetByteAsync(_byps_ret);
			return _byps_ret;
		}
		public 		byte[] EndGetByte(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<byte[]>)asyncResult).Result;
		}
		
		public char[] GetChar() {
			BSyncResult<char[]> asyncResult = new BSyncResult<char[]>();			
			GetCharAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetCharAsync(BAsyncResult<char[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getChar req = new BRequest_RemoteArrayTypes1dim_getChar();			
			BAsyncResultReceiveMethod<char[]> outerResult = new BAsyncResultReceiveMethod<char[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetChar(AsyncCallback callback, object state){
			BAsyncProgModel<char[]> _byps_ret = new BAsyncProgModel<char[]>(callback, state);
			GetCharAsync(_byps_ret);
			return _byps_ret;
		}
		public 		char[] EndGetChar(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<char[]>)asyncResult).Result;
		}
		
		public short[] GetShort() {
			BSyncResult<short[]> asyncResult = new BSyncResult<short[]>();			
			GetShortAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetShortAsync(BAsyncResult<short[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getShort req = new BRequest_RemoteArrayTypes1dim_getShort();			
			BAsyncResultReceiveMethod<short[]> outerResult = new BAsyncResultReceiveMethod<short[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetShort(AsyncCallback callback, object state){
			BAsyncProgModel<short[]> _byps_ret = new BAsyncProgModel<short[]>(callback, state);
			GetShortAsync(_byps_ret);
			return _byps_ret;
		}
		public 		short[] EndGetShort(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<short[]>)asyncResult).Result;
		}
		
		public int[] GetInt() {
			BSyncResult<int[]> asyncResult = new BSyncResult<int[]>();			
			GetIntAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetIntAsync(BAsyncResult<int[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getInt req = new BRequest_RemoteArrayTypes1dim_getInt();			
			BAsyncResultReceiveMethod<int[]> outerResult = new BAsyncResultReceiveMethod<int[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt(AsyncCallback callback, object state){
			BAsyncProgModel<int[]> _byps_ret = new BAsyncProgModel<int[]>(callback, state);
			GetIntAsync(_byps_ret);
			return _byps_ret;
		}
		public 		int[] EndGetInt(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int[]>)asyncResult).Result;
		}
		
		public long[] GetLong() {
			BSyncResult<long[]> asyncResult = new BSyncResult<long[]>();			
			GetLongAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetLongAsync(BAsyncResult<long[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getLong req = new BRequest_RemoteArrayTypes1dim_getLong();			
			BAsyncResultReceiveMethod<long[]> outerResult = new BAsyncResultReceiveMethod<long[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetLong(AsyncCallback callback, object state){
			BAsyncProgModel<long[]> _byps_ret = new BAsyncProgModel<long[]>(callback, state);
			GetLongAsync(_byps_ret);
			return _byps_ret;
		}
		public 		long[] EndGetLong(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<long[]>)asyncResult).Result;
		}
		
		public float[] GetFloat() {
			BSyncResult<float[]> asyncResult = new BSyncResult<float[]>();			
			GetFloatAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetFloatAsync(BAsyncResult<float[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getFloat req = new BRequest_RemoteArrayTypes1dim_getFloat();			
			BAsyncResultReceiveMethod<float[]> outerResult = new BAsyncResultReceiveMethod<float[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetFloat(AsyncCallback callback, object state){
			BAsyncProgModel<float[]> _byps_ret = new BAsyncProgModel<float[]>(callback, state);
			GetFloatAsync(_byps_ret);
			return _byps_ret;
		}
		public 		float[] EndGetFloat(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<float[]>)asyncResult).Result;
		}
		
		public double[] GetDouble() {
			BSyncResult<double[]> asyncResult = new BSyncResult<double[]>();			
			GetDoubleAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetDoubleAsync(BAsyncResult<double[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getDouble req = new BRequest_RemoteArrayTypes1dim_getDouble();			
			BAsyncResultReceiveMethod<double[]> outerResult = new BAsyncResultReceiveMethod<double[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetDouble(AsyncCallback callback, object state){
			BAsyncProgModel<double[]> _byps_ret = new BAsyncProgModel<double[]>(callback, state);
			GetDoubleAsync(_byps_ret);
			return _byps_ret;
		}
		public 		double[] EndGetDouble(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<double[]>)asyncResult).Result;
		}
		
		public String[] GetString() {
			BSyncResult<String[]> asyncResult = new BSyncResult<String[]>();			
			GetStringAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetStringAsync(BAsyncResult<String[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getString req = new BRequest_RemoteArrayTypes1dim_getString();			
			BAsyncResultReceiveMethod<String[]> outerResult = new BAsyncResultReceiveMethod<String[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetString(AsyncCallback callback, object state){
			BAsyncProgModel<String[]> _byps_ret = new BAsyncProgModel<String[]>(callback, state);
			GetStringAsync(_byps_ret);
			return _byps_ret;
		}
		public 		String[] EndGetString(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<String[]>)asyncResult).Result;
		}
		
		public com.wilutions.byps.test.api.prim.PrimitiveTypes[] GetPrimitiveTypes() {
			BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult = new BSyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>();			
			GetPrimitiveTypesAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetPrimitiveTypesAsync(BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getPrimitiveTypes req = new BRequest_RemoteArrayTypes1dim_getPrimitiveTypes();			
			BAsyncResultReceiveMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPrimitiveTypes(AsyncCallback callback, object state){
			BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> _byps_ret = new BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>(callback, state);
			GetPrimitiveTypesAsync(_byps_ret);
			return _byps_ret;
		}
		public 		com.wilutions.byps.test.api.prim.PrimitiveTypes[] EndGetPrimitiveTypes(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>)asyncResult).Result;
		}
		
		public Object[] GetObject() {
			BSyncResult<Object[]> asyncResult = new BSyncResult<Object[]>();			
			GetObjectAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetObjectAsync(BAsyncResult<Object[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getObject req = new BRequest_RemoteArrayTypes1dim_getObject();			
			BAsyncResultReceiveMethod<Object[]> outerResult = new BAsyncResultReceiveMethod<Object[]>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetObject(AsyncCallback callback, object state){
			BAsyncProgModel<Object[]> _byps_ret = new BAsyncProgModel<Object[]>(callback, state);
			GetObjectAsync(_byps_ret);
			return _byps_ret;
		}
		public 		Object[] EndGetObject(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object[]>)asyncResult).Result;
		}
		
		
	}
}
