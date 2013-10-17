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
			GetBoolean1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetBoolean1Async(BAsyncResult<ISet<bool>> asyncResult) {
			BRequest_RemoteSetTypes_getBoolean1 req = new BRequest_RemoteSetTypes_getBoolean1();			
			BAsyncResultReceiveMethod<ISet<bool>> outerResult = new BAsyncResultReceiveMethod<ISet<bool>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<bool>> _byps_ret = new BAsyncProgModel<ISet<bool>>(callback, state);
			GetBoolean1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<bool> EndGetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<bool>>)asyncResult).Result;
		}
		public async Task<ISet<bool>> GetBoolean1Task() {
			return await Task<ISet<bool>>.Factory.FromAsync(BeginGetBoolean1, EndGetBoolean1, null);
		}
		
		public void SetBoolean1(ISet<bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBoolean1Async(boolean1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetBoolean1Async(ISet<bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setBoolean1 req = new BRequest_RemoteSetTypes_setBoolean1();			
			req._boolean1 = boolean1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetBoolean1(ISet<bool> boolean1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetBoolean1Async(boolean1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetBoolean1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetBoolean1Task(ISet<bool> boolean1) {
			await Task.Factory.FromAsync(BeginSetBoolean1, EndSetBoolean1, boolean1, null);
		}
		
		public HashSet<byte> GetByte1() {
			BSyncResult<HashSet<byte>> asyncResult = new BSyncResult<HashSet<byte>>();			
			GetByte1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetByte1Async(BAsyncResult<HashSet<byte>> asyncResult) {
			BRequest_RemoteSetTypes_getByte1 req = new BRequest_RemoteSetTypes_getByte1();			
			BAsyncResultReceiveMethod<HashSet<byte>> outerResult = new BAsyncResultReceiveMethod<HashSet<byte>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte1(AsyncCallback callback, object state){
			BAsyncProgModel<HashSet<byte>> _byps_ret = new BAsyncProgModel<HashSet<byte>>(callback, state);
			GetByte1Async(_byps_ret);
			return _byps_ret;
		}
		public HashSet<byte> EndGetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<HashSet<byte>>)asyncResult).Result;
		}
		public async Task<HashSet<byte>> GetByte1Task() {
			return await Task<HashSet<byte>>.Factory.FromAsync(BeginGetByte1, EndGetByte1, null);
		}
		
		public void SetByte1(HashSet<byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte1Async(byte1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetByte1Async(HashSet<byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setByte1 req = new BRequest_RemoteSetTypes_setByte1();			
			req._byte1 = byte1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte1(HashSet<byte> byte1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetByte1Async(byte1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetByte1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetByte1Task(HashSet<byte> byte1) {
			await Task.Factory.FromAsync(BeginSetByte1, EndSetByte1, byte1, null);
		}
		
		public HashSet<char> GetChar1() {
			BSyncResult<HashSet<char>> asyncResult = new BSyncResult<HashSet<char>>();			
			GetChar1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetChar1Async(BAsyncResult<HashSet<char>> asyncResult) {
			BRequest_RemoteSetTypes_getChar1 req = new BRequest_RemoteSetTypes_getChar1();			
			BAsyncResultReceiveMethod<HashSet<char>> outerResult = new BAsyncResultReceiveMethod<HashSet<char>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetChar1(AsyncCallback callback, object state){
			BAsyncProgModel<HashSet<char>> _byps_ret = new BAsyncProgModel<HashSet<char>>(callback, state);
			GetChar1Async(_byps_ret);
			return _byps_ret;
		}
		public HashSet<char> EndGetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<HashSet<char>>)asyncResult).Result;
		}
		public async Task<HashSet<char>> GetChar1Task() {
			return await Task<HashSet<char>>.Factory.FromAsync(BeginGetChar1, EndGetChar1, null);
		}
		
		public void SetChar1(HashSet<char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar1Async(char1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetChar1Async(HashSet<char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setChar1 req = new BRequest_RemoteSetTypes_setChar1();			
			req._char1 = char1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetChar1(HashSet<char> char1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetChar1Async(char1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetChar1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetChar1Task(HashSet<char> char1) {
			await Task.Factory.FromAsync(BeginSetChar1, EndSetChar1, char1, null);
		}
		
		public ISet<short> GetShort1() {
			BSyncResult<ISet<short>> asyncResult = new BSyncResult<ISet<short>>();			
			GetShort1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetShort1Async(BAsyncResult<ISet<short>> asyncResult) {
			BRequest_RemoteSetTypes_getShort1 req = new BRequest_RemoteSetTypes_getShort1();			
			BAsyncResultReceiveMethod<ISet<short>> outerResult = new BAsyncResultReceiveMethod<ISet<short>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetShort1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<short>> _byps_ret = new BAsyncProgModel<ISet<short>>(callback, state);
			GetShort1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<short> EndGetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<short>>)asyncResult).Result;
		}
		public async Task<ISet<short>> GetShort1Task() {
			return await Task<ISet<short>>.Factory.FromAsync(BeginGetShort1, EndGetShort1, null);
		}
		
		public void SetShort1(ISet<short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort1Async(short1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetShort1Async(ISet<short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setShort1 req = new BRequest_RemoteSetTypes_setShort1();			
			req._short1 = short1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetShort1(ISet<short> short1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetShort1Async(short1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetShort1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetShort1Task(ISet<short> short1) {
			await Task.Factory.FromAsync(BeginSetShort1, EndSetShort1, short1, null);
		}
		
		public ISet<int> GetInt1() {
			BSyncResult<ISet<int>> asyncResult = new BSyncResult<ISet<int>>();			
			GetInt1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetInt1Async(BAsyncResult<ISet<int>> asyncResult) {
			BRequest_RemoteSetTypes_getInt1 req = new BRequest_RemoteSetTypes_getInt1();			
			BAsyncResultReceiveMethod<ISet<int>> outerResult = new BAsyncResultReceiveMethod<ISet<int>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<int>> _byps_ret = new BAsyncProgModel<ISet<int>>(callback, state);
			GetInt1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<int> EndGetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<int>>)asyncResult).Result;
		}
		public async Task<ISet<int>> GetInt1Task() {
			return await Task<ISet<int>>.Factory.FromAsync(BeginGetInt1, EndGetInt1, null);
		}
		
		public void SetInt1(ISet<int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt1Async(int1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetInt1Async(ISet<int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setInt1 req = new BRequest_RemoteSetTypes_setInt1();			
			req._int1 = int1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt1(ISet<int> int1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetInt1Async(int1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetInt1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetInt1Task(ISet<int> int1) {
			await Task.Factory.FromAsync(BeginSetInt1, EndSetInt1, int1, null);
		}
		
		public ISet<long> GetLong1() {
			BSyncResult<ISet<long>> asyncResult = new BSyncResult<ISet<long>>();			
			GetLong1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetLong1Async(BAsyncResult<ISet<long>> asyncResult) {
			BRequest_RemoteSetTypes_getLong1 req = new BRequest_RemoteSetTypes_getLong1();			
			BAsyncResultReceiveMethod<ISet<long>> outerResult = new BAsyncResultReceiveMethod<ISet<long>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetLong1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<long>> _byps_ret = new BAsyncProgModel<ISet<long>>(callback, state);
			GetLong1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<long> EndGetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<long>>)asyncResult).Result;
		}
		public async Task<ISet<long>> GetLong1Task() {
			return await Task<ISet<long>>.Factory.FromAsync(BeginGetLong1, EndGetLong1, null);
		}
		
		public void SetLong1(ISet<long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong1Async(long1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetLong1Async(ISet<long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setLong1 req = new BRequest_RemoteSetTypes_setLong1();			
			req._long1 = long1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetLong1(ISet<long> long1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetLong1Async(long1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetLong1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetLong1Task(ISet<long> long1) {
			await Task.Factory.FromAsync(BeginSetLong1, EndSetLong1, long1, null);
		}
		
		public ISet<float> GetFloat1() {
			BSyncResult<ISet<float>> asyncResult = new BSyncResult<ISet<float>>();			
			GetFloat1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetFloat1Async(BAsyncResult<ISet<float>> asyncResult) {
			BRequest_RemoteSetTypes_getFloat1 req = new BRequest_RemoteSetTypes_getFloat1();			
			BAsyncResultReceiveMethod<ISet<float>> outerResult = new BAsyncResultReceiveMethod<ISet<float>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetFloat1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<float>> _byps_ret = new BAsyncProgModel<ISet<float>>(callback, state);
			GetFloat1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<float> EndGetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<float>>)asyncResult).Result;
		}
		public async Task<ISet<float>> GetFloat1Task() {
			return await Task<ISet<float>>.Factory.FromAsync(BeginGetFloat1, EndGetFloat1, null);
		}
		
		public void SetFloat1(ISet<float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat1Async(float1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetFloat1Async(ISet<float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setFloat1 req = new BRequest_RemoteSetTypes_setFloat1();			
			req._float1 = float1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetFloat1(ISet<float> float1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetFloat1Async(float1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetFloat1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetFloat1Task(ISet<float> float1) {
			await Task.Factory.FromAsync(BeginSetFloat1, EndSetFloat1, float1, null);
		}
		
		public ISet<double> GetDouble1() {
			BSyncResult<ISet<double>> asyncResult = new BSyncResult<ISet<double>>();			
			GetDouble1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetDouble1Async(BAsyncResult<ISet<double>> asyncResult) {
			BRequest_RemoteSetTypes_getDouble1 req = new BRequest_RemoteSetTypes_getDouble1();			
			BAsyncResultReceiveMethod<ISet<double>> outerResult = new BAsyncResultReceiveMethod<ISet<double>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetDouble1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<double>> _byps_ret = new BAsyncProgModel<ISet<double>>(callback, state);
			GetDouble1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<double> EndGetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<double>>)asyncResult).Result;
		}
		public async Task<ISet<double>> GetDouble1Task() {
			return await Task<ISet<double>>.Factory.FromAsync(BeginGetDouble1, EndGetDouble1, null);
		}
		
		public void SetDouble1(ISet<double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble1Async(double1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetDouble1Async(ISet<double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setDouble1 req = new BRequest_RemoteSetTypes_setDouble1();			
			req._double1 = double1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetDouble1(ISet<double> double1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetDouble1Async(double1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetDouble1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetDouble1Task(ISet<double> double1) {
			await Task.Factory.FromAsync(BeginSetDouble1, EndSetDouble1, double1, null);
		}
		
		public ISet<String> GetString1() {
			BSyncResult<ISet<String>> asyncResult = new BSyncResult<ISet<String>>();			
			GetString1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetString1Async(BAsyncResult<ISet<String>> asyncResult) {
			BRequest_RemoteSetTypes_getString1 req = new BRequest_RemoteSetTypes_getString1();			
			BAsyncResultReceiveMethod<ISet<String>> outerResult = new BAsyncResultReceiveMethod<ISet<String>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetString1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<String>> _byps_ret = new BAsyncProgModel<ISet<String>>(callback, state);
			GetString1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<String> EndGetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<String>>)asyncResult).Result;
		}
		public async Task<ISet<String>> GetString1Task() {
			return await Task<ISet<String>>.Factory.FromAsync(BeginGetString1, EndGetString1, null);
		}
		
		public void SetString1(ISet<String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString1Async(string1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetString1Async(ISet<String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setString1 req = new BRequest_RemoteSetTypes_setString1();			
			req._string1 = string1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetString1(ISet<String> string1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetString1Async(string1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetString1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetString1Task(ISet<String> string1) {
			await Task.Factory.FromAsync(BeginSetString1, EndSetString1, string1, null);
		}
		
		public ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>();			
			GetPrimitiveTypes1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetPrimitiveTypes1Async(BAsyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteSetTypes_getPrimitiveTypes1 req = new BRequest_RemoteSetTypes_getPrimitiveTypes1();			
			BAsyncResultReceiveMethod<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultReceiveMethod<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> _byps_ret = new BAsyncProgModel<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(callback, state);
			GetPrimitiveTypes1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>)asyncResult).Result;
		}
		public async Task<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Task() {
			return await Task<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>>.Factory.FromAsync(BeginGetPrimitiveTypes1, EndGetPrimitiveTypes1, null);
		}
		
		public void SetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes1Async(primitiveTypes1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetPrimitiveTypes1Async(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setPrimitiveTypes1 req = new BRequest_RemoteSetTypes_setPrimitiveTypes1();			
			req._primitiveTypes1 = primitiveTypes1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetPrimitiveTypes1Async(primitiveTypes1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetPrimitiveTypes1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetPrimitiveTypes1Task(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			await Task.Factory.FromAsync(BeginSetPrimitiveTypes1, EndSetPrimitiveTypes1, primitiveTypes1, null);
		}
		
		public ISet<byte[]> GetByte2() {
			BSyncResult<ISet<byte[]>> asyncResult = new BSyncResult<ISet<byte[]>>();			
			GetByte2Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetByte2Async(BAsyncResult<ISet<byte[]>> asyncResult) {
			BRequest_RemoteSetTypes_getByte2 req = new BRequest_RemoteSetTypes_getByte2();			
			BAsyncResultReceiveMethod<ISet<byte[]>> outerResult = new BAsyncResultReceiveMethod<ISet<byte[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetByte2(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<byte[]>> _byps_ret = new BAsyncProgModel<ISet<byte[]>>(callback, state);
			GetByte2Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<byte[]> EndGetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<byte[]>>)asyncResult).Result;
		}
		public async Task<ISet<byte[]>> GetByte2Task() {
			return await Task<ISet<byte[]>>.Factory.FromAsync(BeginGetByte2, EndGetByte2, null);
		}
		
		public void SetByte2(ISet<byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte2Async(byte2, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetByte2Async(ISet<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setByte2 req = new BRequest_RemoteSetTypes_setByte2();			
			req._byte2 = byte2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetByte2(ISet<byte[]> byte2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetByte2Async(byte2, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetByte2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetByte2Task(ISet<byte[]> byte2) {
			await Task.Factory.FromAsync(BeginSetByte2, EndSetByte2, byte2, null);
		}
		
		public ISet<int[]> GetInt2() {
			BSyncResult<ISet<int[]>> asyncResult = new BSyncResult<ISet<int[]>>();			
			GetInt2Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetInt2Async(BAsyncResult<ISet<int[]>> asyncResult) {
			BRequest_RemoteSetTypes_getInt2 req = new BRequest_RemoteSetTypes_getInt2();			
			BAsyncResultReceiveMethod<ISet<int[]>> outerResult = new BAsyncResultReceiveMethod<ISet<int[]>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetInt2(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<int[]>> _byps_ret = new BAsyncProgModel<ISet<int[]>>(callback, state);
			GetInt2Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<int[]> EndGetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<int[]>>)asyncResult).Result;
		}
		public async Task<ISet<int[]>> GetInt2Task() {
			return await Task<ISet<int[]>>.Factory.FromAsync(BeginGetInt2, EndGetInt2, null);
		}
		
		public void SetInt2(ISet<int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt2Async(int2, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetInt2Async(ISet<int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setInt2 req = new BRequest_RemoteSetTypes_setInt2();			
			req._int2 = int2;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetInt2(ISet<int[]> int2, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetInt2Async(int2, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetInt2(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetInt2Task(ISet<int[]> int2) {
			await Task.Factory.FromAsync(BeginSetInt2, EndSetInt2, int2, null);
		}
		
		public ISet<Object> GetObj1() {
			BSyncResult<ISet<Object>> asyncResult = new BSyncResult<ISet<Object>>();			
			GetObj1Async(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetObj1Async(BAsyncResult<ISet<Object>> asyncResult) {
			BRequest_RemoteSetTypes_getObj1 req = new BRequest_RemoteSetTypes_getObj1();			
			BAsyncResultReceiveMethod<ISet<Object>> outerResult = new BAsyncResultReceiveMethod<ISet<Object>>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetObj1(AsyncCallback callback, object state){
			BAsyncProgModel<ISet<Object>> _byps_ret = new BAsyncProgModel<ISet<Object>>(callback, state);
			GetObj1Async(_byps_ret);
			return _byps_ret;
		}
		public ISet<Object> EndGetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<ISet<Object>>)asyncResult).Result;
		}
		public async Task<ISet<Object>> GetObj1Task() {
			return await Task<ISet<Object>>.Factory.FromAsync(BeginGetObj1, EndGetObj1, null);
		}
		
		public void SetObj1(ISet<Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObj1Async(obj1, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetObj1Async(ISet<Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteSetTypes_setObj1 req = new BRequest_RemoteSetTypes_setObj1();			
			req._obj1 = obj1;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetObj1(ISet<Object> obj1, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetObj1Async(obj1, _byps_ret);
			return _byps_ret;
		}
		public Object EndSetObj1(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		public async Task SetObj1Task(ISet<Object> obj1) {
			await Task.Factory.FromAsync(BeginSetObj1, EndSetObj1, obj1, null);
		}
		
		
	}
}
