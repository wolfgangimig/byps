using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteListTypes : BStub, RemoteListTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 380156079L;
		
		public BStub_RemoteListTypes(BTransport transport)
			: base(transport) {}			
		
		public IList<bool> GetBoolean1() {
			BSyncResult<IList<bool>> asyncResult = new BSyncResult<IList<bool>>();			
			GetBoolean1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetBoolean1Async(BAsyncResult<IList<bool>> asyncResult) {
			BRequest_RemoteListTypes_getBoolean1 req = new BRequest_RemoteListTypes_getBoolean1();			
			BAsyncResultReceiveMethod<IList<bool>> outerResult = new BAsyncResultReceiveMethod<IList<bool>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<bool>> _byps_ret = new BAsyncProgModel<IList<bool>>(callback, state);
			GetBoolean1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<bool> EndGetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<bool>>)asyncResult).Result;
		}
		public async Task<IList<bool>> GetBoolean1Task() {
			return await Task<IList<bool>>.Factory.FromAsync(BeginGetBoolean1, EndGetBoolean1, null);
		}
		
		public void SetBoolean1(IList<bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBoolean1Async(boolean1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetBoolean1Async(IList<bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setBoolean1 req = new BRequest_RemoteListTypes_setBoolean1();			
			req._boolean1 = boolean1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetBoolean1(IList<bool> boolean1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetBoolean1Async(boolean1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetBoolean1Task(IList<bool> boolean1) {
			await Task.Factory.FromAsync(BeginSetBoolean1, EndSetBoolean1, boolean1, null);
		}
		
		public IList<byte> GetByte1() {
			BSyncResult<IList<byte>> asyncResult = new BSyncResult<IList<byte>>();			
			GetByte1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetByte1Async(BAsyncResult<IList<byte>> asyncResult) {
			BRequest_RemoteListTypes_getByte1 req = new BRequest_RemoteListTypes_getByte1();			
			BAsyncResultReceiveMethod<IList<byte>> outerResult = new BAsyncResultReceiveMethod<IList<byte>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<byte>> _byps_ret = new BAsyncProgModel<IList<byte>>(callback, state);
			GetByte1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<byte> EndGetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<byte>>)asyncResult).Result;
		}
		public async Task<IList<byte>> GetByte1Task() {
			return await Task<IList<byte>>.Factory.FromAsync(BeginGetByte1, EndGetByte1, null);
		}
		
		public void SetByte1(IList<byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte1Async(byte1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetByte1Async(IList<byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setByte1 req = new BRequest_RemoteListTypes_setByte1();			
			req._byte1 = byte1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte1(IList<byte> byte1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetByte1Async(byte1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetByte1Task(IList<byte> byte1) {
			await Task.Factory.FromAsync(BeginSetByte1, EndSetByte1, byte1, null);
		}
		
		public IList<char> GetChar1() {
			BSyncResult<IList<char>> asyncResult = new BSyncResult<IList<char>>();			
			GetChar1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetChar1Async(BAsyncResult<IList<char>> asyncResult) {
			BRequest_RemoteListTypes_getChar1 req = new BRequest_RemoteListTypes_getChar1();			
			BAsyncResultReceiveMethod<IList<char>> outerResult = new BAsyncResultReceiveMethod<IList<char>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetChar1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<char>> _byps_ret = new BAsyncProgModel<IList<char>>(callback, state);
			GetChar1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<char> EndGetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<char>>)asyncResult).Result;
		}
		public async Task<IList<char>> GetChar1Task() {
			return await Task<IList<char>>.Factory.FromAsync(BeginGetChar1, EndGetChar1, null);
		}
		
		public void SetChar1(IList<char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar1Async(char1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetChar1Async(IList<char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setChar1 req = new BRequest_RemoteListTypes_setChar1();			
			req._char1 = char1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetChar1(IList<char> char1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetChar1Async(char1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetChar1Task(IList<char> char1) {
			await Task.Factory.FromAsync(BeginSetChar1, EndSetChar1, char1, null);
		}
		
		public IList<short> GetShort1() {
			BSyncResult<IList<short>> asyncResult = new BSyncResult<IList<short>>();			
			GetShort1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetShort1Async(BAsyncResult<IList<short>> asyncResult) {
			BRequest_RemoteListTypes_getShort1 req = new BRequest_RemoteListTypes_getShort1();			
			BAsyncResultReceiveMethod<IList<short>> outerResult = new BAsyncResultReceiveMethod<IList<short>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetShort1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<short>> _byps_ret = new BAsyncProgModel<IList<short>>(callback, state);
			GetShort1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<short> EndGetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<short>>)asyncResult).Result;
		}
		public async Task<IList<short>> GetShort1Task() {
			return await Task<IList<short>>.Factory.FromAsync(BeginGetShort1, EndGetShort1, null);
		}
		
		public void SetShort1(IList<short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort1Async(short1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetShort1Async(IList<short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setShort1 req = new BRequest_RemoteListTypes_setShort1();			
			req._short1 = short1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetShort1(IList<short> short1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetShort1Async(short1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetShort1Task(IList<short> short1) {
			await Task.Factory.FromAsync(BeginSetShort1, EndSetShort1, short1, null);
		}
		
		public IList<int> GetInt1() {
			BSyncResult<IList<int>> asyncResult = new BSyncResult<IList<int>>();			
			GetInt1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetInt1Async(BAsyncResult<IList<int>> asyncResult) {
			BRequest_RemoteListTypes_getInt1 req = new BRequest_RemoteListTypes_getInt1();			
			BAsyncResultReceiveMethod<IList<int>> outerResult = new BAsyncResultReceiveMethod<IList<int>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<int>> _byps_ret = new BAsyncProgModel<IList<int>>(callback, state);
			GetInt1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<int> EndGetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<int>>)asyncResult).Result;
		}
		public async Task<IList<int>> GetInt1Task() {
			return await Task<IList<int>>.Factory.FromAsync(BeginGetInt1, EndGetInt1, null);
		}
		
		public void SetInt1(IList<int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt1Async(int1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetInt1Async(IList<int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt1 req = new BRequest_RemoteListTypes_setInt1();			
			req._int1 = int1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt1(IList<int> int1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetInt1Async(int1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetInt1Task(IList<int> int1) {
			await Task.Factory.FromAsync(BeginSetInt1, EndSetInt1, int1, null);
		}
		
		public IList<long> GetLong1() {
			BSyncResult<IList<long>> asyncResult = new BSyncResult<IList<long>>();			
			GetLong1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetLong1Async(BAsyncResult<IList<long>> asyncResult) {
			BRequest_RemoteListTypes_getLong1 req = new BRequest_RemoteListTypes_getLong1();			
			BAsyncResultReceiveMethod<IList<long>> outerResult = new BAsyncResultReceiveMethod<IList<long>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetLong1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<long>> _byps_ret = new BAsyncProgModel<IList<long>>(callback, state);
			GetLong1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<long> EndGetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<long>>)asyncResult).Result;
		}
		public async Task<IList<long>> GetLong1Task() {
			return await Task<IList<long>>.Factory.FromAsync(BeginGetLong1, EndGetLong1, null);
		}
		
		public void SetLong1(IList<long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong1Async(long1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetLong1Async(IList<long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setLong1 req = new BRequest_RemoteListTypes_setLong1();			
			req._long1 = long1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetLong1(IList<long> long1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetLong1Async(long1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetLong1Task(IList<long> long1) {
			await Task.Factory.FromAsync(BeginSetLong1, EndSetLong1, long1, null);
		}
		
		public IList<float> GetFloat1() {
			BSyncResult<IList<float>> asyncResult = new BSyncResult<IList<float>>();			
			GetFloat1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetFloat1Async(BAsyncResult<IList<float>> asyncResult) {
			BRequest_RemoteListTypes_getFloat1 req = new BRequest_RemoteListTypes_getFloat1();			
			BAsyncResultReceiveMethod<IList<float>> outerResult = new BAsyncResultReceiveMethod<IList<float>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetFloat1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<float>> _byps_ret = new BAsyncProgModel<IList<float>>(callback, state);
			GetFloat1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<float> EndGetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<float>>)asyncResult).Result;
		}
		public async Task<IList<float>> GetFloat1Task() {
			return await Task<IList<float>>.Factory.FromAsync(BeginGetFloat1, EndGetFloat1, null);
		}
		
		public void SetFloat1(IList<float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat1Async(float1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetFloat1Async(IList<float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setFloat1 req = new BRequest_RemoteListTypes_setFloat1();			
			req._float1 = float1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetFloat1(IList<float> float1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetFloat1Async(float1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetFloat1Task(IList<float> float1) {
			await Task.Factory.FromAsync(BeginSetFloat1, EndSetFloat1, float1, null);
		}
		
		public IList<double> GetDouble1() {
			BSyncResult<IList<double>> asyncResult = new BSyncResult<IList<double>>();			
			GetDouble1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetDouble1Async(BAsyncResult<IList<double>> asyncResult) {
			BRequest_RemoteListTypes_getDouble1 req = new BRequest_RemoteListTypes_getDouble1();			
			BAsyncResultReceiveMethod<IList<double>> outerResult = new BAsyncResultReceiveMethod<IList<double>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetDouble1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<double>> _byps_ret = new BAsyncProgModel<IList<double>>(callback, state);
			GetDouble1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<double> EndGetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<double>>)asyncResult).Result;
		}
		public async Task<IList<double>> GetDouble1Task() {
			return await Task<IList<double>>.Factory.FromAsync(BeginGetDouble1, EndGetDouble1, null);
		}
		
		public void SetDouble1(IList<double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble1Async(double1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetDouble1Async(IList<double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setDouble1 req = new BRequest_RemoteListTypes_setDouble1();			
			req._double1 = double1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetDouble1(IList<double> double1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetDouble1Async(double1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetDouble1Task(IList<double> double1) {
			await Task.Factory.FromAsync(BeginSetDouble1, EndSetDouble1, double1, null);
		}
		
		public IList<String> GetString1() {
			BSyncResult<IList<String>> asyncResult = new BSyncResult<IList<String>>();			
			GetString1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetString1Async(BAsyncResult<IList<String>> asyncResult) {
			BRequest_RemoteListTypes_getString1 req = new BRequest_RemoteListTypes_getString1();			
			BAsyncResultReceiveMethod<IList<String>> outerResult = new BAsyncResultReceiveMethod<IList<String>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetString1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<String>> _byps_ret = new BAsyncProgModel<IList<String>>(callback, state);
			GetString1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<String> EndGetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<String>>)asyncResult).Result;
		}
		public async Task<IList<String>> GetString1Task() {
			return await Task<IList<String>>.Factory.FromAsync(BeginGetString1, EndGetString1, null);
		}
		
		public void SetString1(IList<String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString1Async(string1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetString1Async(IList<String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setString1 req = new BRequest_RemoteListTypes_setString1();			
			req._string1 = string1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetString1(IList<String> string1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetString1Async(string1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetString1Task(IList<String> string1) {
			await Task.Factory.FromAsync(BeginSetString1, EndSetString1, string1, null);
		}
		
		public IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>();			
			GetPrimitiveTypes1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetPrimitiveTypes1Async(BAsyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteListTypes_getPrimitiveTypes1 req = new BRequest_RemoteListTypes_getPrimitiveTypes1();			
			BAsyncResultReceiveMethod<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultReceiveMethod<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> _byps_ret = new BAsyncProgModel<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(callback, state);
			GetPrimitiveTypes1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>)asyncResult).Result;
		}
		public async Task<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Task() {
			return await Task<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>>.Factory.FromAsync(BeginGetPrimitiveTypes1, EndGetPrimitiveTypes1, null);
		}
		
		public void SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes1Async(primitiveTypes1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetPrimitiveTypes1Async(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setPrimitiveTypes1 req = new BRequest_RemoteListTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetPrimitiveTypes1Async(primitiveTypes1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetPrimitiveTypes1Task(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			await Task.Factory.FromAsync(BeginSetPrimitiveTypes1, EndSetPrimitiveTypes1, primitiveTypes1, null);
		}
		
		public IList<byte[]> GetByte2() {
			BSyncResult<IList<byte[]>> asyncResult = new BSyncResult<IList<byte[]>>();			
			GetByte2Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetByte2Async(BAsyncResult<IList<byte[]>> asyncResult) {
			BRequest_RemoteListTypes_getByte2 req = new BRequest_RemoteListTypes_getByte2();			
			BAsyncResultReceiveMethod<IList<byte[]>> outerResult = new BAsyncResultReceiveMethod<IList<byte[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte2(AsyncCallback callback, object state){
			BAsyncProgModel<IList<byte[]>> _byps_ret = new BAsyncProgModel<IList<byte[]>>(callback, state);
			GetByte2Async(_byps_ret);
			return _byps_ret;
		}
		public IList<byte[]> EndGetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<byte[]>>)asyncResult).Result;
		}
		public async Task<IList<byte[]>> GetByte2Task() {
			return await Task<IList<byte[]>>.Factory.FromAsync(BeginGetByte2, EndGetByte2, null);
		}
		
		public void SetByte2(IList<byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte2Async(byte2, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetByte2Async(IList<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setByte2 req = new BRequest_RemoteListTypes_setByte2();			
			req._byte2 = byte2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte2(IList<byte[]> byte2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetByte2Async(byte2, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetByte2Task(IList<byte[]> byte2) {
			await Task.Factory.FromAsync(BeginSetByte2, EndSetByte2, byte2, null);
		}
		
		public IList<int[]> GetInt2() {
			BSyncResult<IList<int[]>> asyncResult = new BSyncResult<IList<int[]>>();			
			GetInt2Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetInt2Async(BAsyncResult<IList<int[]>> asyncResult) {
			BRequest_RemoteListTypes_getInt2 req = new BRequest_RemoteListTypes_getInt2();			
			BAsyncResultReceiveMethod<IList<int[]>> outerResult = new BAsyncResultReceiveMethod<IList<int[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt2(AsyncCallback callback, object state){
			BAsyncProgModel<IList<int[]>> _byps_ret = new BAsyncProgModel<IList<int[]>>(callback, state);
			GetInt2Async(_byps_ret);
			return _byps_ret;
		}
		public IList<int[]> EndGetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<int[]>>)asyncResult).Result;
		}
		public async Task<IList<int[]>> GetInt2Task() {
			return await Task<IList<int[]>>.Factory.FromAsync(BeginGetInt2, EndGetInt2, null);
		}
		
		public void SetInt2(IList<int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt2Async(int2, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetInt2Async(IList<int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt2 req = new BRequest_RemoteListTypes_setInt2();			
			req._int2 = int2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt2(IList<int[]> int2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetInt2Async(int2, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetInt2Task(IList<int[]> int2) {
			await Task.Factory.FromAsync(BeginSetInt2, EndSetInt2, int2, null);
		}
		
		public IList<Object> GetObj1() {
			BSyncResult<IList<Object>> asyncResult = new BSyncResult<IList<Object>>();			
			GetObj1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetObj1Async(BAsyncResult<IList<Object>> asyncResult) {
			BRequest_RemoteListTypes_getObj1 req = new BRequest_RemoteListTypes_getObj1();			
			BAsyncResultReceiveMethod<IList<Object>> outerResult = new BAsyncResultReceiveMethod<IList<Object>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetObj1(AsyncCallback callback, object state){
			BAsyncProgModel<IList<Object>> _byps_ret = new BAsyncProgModel<IList<Object>>(callback, state);
			GetObj1Async(_byps_ret);
			return _byps_ret;
		}
		public IList<Object> EndGetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<Object>>)asyncResult).Result;
		}
		public async Task<IList<Object>> GetObj1Task() {
			return await Task<IList<Object>>.Factory.FromAsync(BeginGetObj1, EndGetObj1, null);
		}
		
		public void SetObj1(IList<Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObj1Async(obj1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetObj1Async(IList<Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setObj1 req = new BRequest_RemoteListTypes_setObj1();			
			req._obj1 = obj1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetObj1(IList<Object> obj1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetObj1Async(obj1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetObj1Task(IList<Object> obj1) {
			await Task.Factory.FromAsync(BeginSetObj1, EndSetObj1, obj1, null);
		}
		
		public IList<IList<int>> GetInt3() {
			BSyncResult<IList<IList<int>>> asyncResult = new BSyncResult<IList<IList<int>>>();			
			GetInt3Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetInt3Async(BAsyncResult<IList<IList<int>>> asyncResult) {
			BRequest_RemoteListTypes_getInt3 req = new BRequest_RemoteListTypes_getInt3();			
			BAsyncResultReceiveMethod<IList<IList<int>>> outerResult = new BAsyncResultReceiveMethod<IList<IList<int>>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt3(AsyncCallback callback, object state){
			BAsyncProgModel<IList<IList<int>>> _byps_ret = new BAsyncProgModel<IList<IList<int>>>(callback, state);
			GetInt3Async(_byps_ret);
			return _byps_ret;
		}
		public IList<IList<int>> EndGetInt3(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<IList<int>>>)asyncResult).Result;
		}
		public async Task<IList<IList<int>>> GetInt3Task() {
			return await Task<IList<IList<int>>>.Factory.FromAsync(BeginGetInt3, EndGetInt3, null);
		}
		
		public void SetInt3(IList<IList<int>> int3) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt3Async(int3, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetInt3Async(IList<IList<int>> int3, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt3 req = new BRequest_RemoteListTypes_setInt3();			
			req._int3 = int3;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt3(IList<IList<int>> int3, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetInt3Async(int3, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetInt3(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetInt3Task(IList<IList<int>> int3) {
			await Task.Factory.FromAsync(BeginSetInt3, EndSetInt3, int3, null);
		}
		
		public IList<IDictionary<int,IList<HashSet<int>>>> GetInt4() {
			BSyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult = new BSyncResult<IList<IDictionary<int,IList<HashSet<int>>>>>();			
			GetInt4Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetInt4Async(BAsyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult) {
			BRequest_RemoteListTypes_getInt4 req = new BRequest_RemoteListTypes_getInt4();			
			BAsyncResultReceiveMethod<IList<IDictionary<int,IList<HashSet<int>>>>> outerResult = new BAsyncResultReceiveMethod<IList<IDictionary<int,IList<HashSet<int>>>>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt4(AsyncCallback callback, object state){
			BAsyncProgModel<IList<IDictionary<int,IList<HashSet<int>>>>> _byps_ret = new BAsyncProgModel<IList<IDictionary<int,IList<HashSet<int>>>>>(callback, state);
			GetInt4Async(_byps_ret);
			return _byps_ret;
		}
		public IList<IDictionary<int,IList<HashSet<int>>>> EndGetInt4(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<IList<IDictionary<int,IList<HashSet<int>>>>>)asyncResult).Result;
		}
		public async Task<IList<IDictionary<int,IList<HashSet<int>>>>> GetInt4Task() {
			return await Task<IList<IDictionary<int,IList<HashSet<int>>>>>.Factory.FromAsync(BeginGetInt4, EndGetInt4, null);
		}
		
		public void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt4Async(int4, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetInt4Async(IList<IDictionary<int,IList<HashSet<int>>>> int4, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt4 req = new BRequest_RemoteListTypes_setInt4();			
			req._int4 = int4;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetInt4Async(int4, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetInt4(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetInt4Task(IList<IDictionary<int,IList<HashSet<int>>>> int4) {
			await Task.Factory.FromAsync(BeginSetInt4, EndSetInt4, int4, null);
		}
		
		
	}
}
