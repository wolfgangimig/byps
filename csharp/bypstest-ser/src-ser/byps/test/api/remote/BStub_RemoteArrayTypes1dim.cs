using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteArrayTypes1dim : BStub, RemoteArrayTypes1dim, BSerializable {	
		
		public readonly static long serialVersionUID = 123123L;
		
		public BStub_RemoteArrayTypes1dim(BTransport transport)
			: base(transport) {}			
		
		public virtual void SetBool(bool[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBool(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetBool(bool[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setBool req = new BRequest_RemoteArrayTypes1dim_setBool();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetBoolAsync(bool[] v){
			BRequest_RemoteArrayTypes1dim_setBool req = new BRequest_RemoteArrayTypes1dim_setBool();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetByte(byte[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetByte(byte[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setByte req = new BRequest_RemoteArrayTypes1dim_setByte();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetByteAsync(byte[] v){
			BRequest_RemoteArrayTypes1dim_setByte req = new BRequest_RemoteArrayTypes1dim_setByte();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetChar(char[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetChar(char[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setChar req = new BRequest_RemoteArrayTypes1dim_setChar();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetCharAsync(char[] v){
			BRequest_RemoteArrayTypes1dim_setChar req = new BRequest_RemoteArrayTypes1dim_setChar();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetShort(short[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetShort(short[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setShort req = new BRequest_RemoteArrayTypes1dim_setShort();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetShortAsync(short[] v){
			BRequest_RemoteArrayTypes1dim_setShort req = new BRequest_RemoteArrayTypes1dim_setShort();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetInt(int[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetInt(int[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setInt req = new BRequest_RemoteArrayTypes1dim_setInt();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetIntAsync(int[] v){
			BRequest_RemoteArrayTypes1dim_setInt req = new BRequest_RemoteArrayTypes1dim_setInt();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetLong(long[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetLong(long[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setLong req = new BRequest_RemoteArrayTypes1dim_setLong();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetLongAsync(long[] v){
			BRequest_RemoteArrayTypes1dim_setLong req = new BRequest_RemoteArrayTypes1dim_setLong();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetFloat(float[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetFloat(float[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setFloat req = new BRequest_RemoteArrayTypes1dim_setFloat();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetFloatAsync(float[] v){
			BRequest_RemoteArrayTypes1dim_setFloat req = new BRequest_RemoteArrayTypes1dim_setFloat();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetDouble(double[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetDouble(double[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setDouble req = new BRequest_RemoteArrayTypes1dim_setDouble();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetDoubleAsync(double[] v){
			BRequest_RemoteArrayTypes1dim_setDouble req = new BRequest_RemoteArrayTypes1dim_setDouble();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetString(String[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetString(String[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setString req = new BRequest_RemoteArrayTypes1dim_setString();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetStringAsync(String[] v){
			BRequest_RemoteArrayTypes1dim_setString req = new BRequest_RemoteArrayTypes1dim_setString();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetPrimitiveTypes(byps.test.api.prim.PrimitiveTypes[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPrimitiveTypes(byps.test.api.prim.PrimitiveTypes[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setPrimitiveTypes req = new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPrimitiveTypesAsync(byps.test.api.prim.PrimitiveTypes[] v){
			BRequest_RemoteArrayTypes1dim_setPrimitiveTypes req = new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetObject(Object[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObject(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetObject(Object[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setObject req = new BRequest_RemoteArrayTypes1dim_setObject();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetObjectAsync(Object[] v){
			BRequest_RemoteArrayTypes1dim_setObject req = new BRequest_RemoteArrayTypes1dim_setObject();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetDate(DateTime[] v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDate(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetDate(DateTime[] v, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteArrayTypes1dim_setDate req = new BRequest_RemoteArrayTypes1dim_setDate();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetDateAsync(DateTime[] v){
			BRequest_RemoteArrayTypes1dim_setDate req = new BRequest_RemoteArrayTypes1dim_setDate();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual bool[] GetBool() {
			BSyncResult<bool[]> asyncResult = new BSyncResult<bool[]>();			
			GetBool(BAsyncResultHelper.ToDelegate<bool[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetBool(BAsyncResult<bool[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getBool req = new BRequest_RemoteArrayTypes1dim_getBool();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<bool[]> GetBoolAsync(){
			BRequest_RemoteArrayTypes1dim_getBool req = new BRequest_RemoteArrayTypes1dim_getBool();			
			Task<bool[]> task = Task<bool[]>.Factory.FromAsync(transport.BeginSend<bool[]>, transport.EndSend<bool[]>, req, null);
			return await task;
		}
		
		public virtual byte[] GetByte() {
			BSyncResult<byte[]> asyncResult = new BSyncResult<byte[]>();			
			GetByte(BAsyncResultHelper.ToDelegate<byte[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetByte(BAsyncResult<byte[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getByte req = new BRequest_RemoteArrayTypes1dim_getByte();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byte[]> GetByteAsync(){
			BRequest_RemoteArrayTypes1dim_getByte req = new BRequest_RemoteArrayTypes1dim_getByte();			
			Task<byte[]> task = Task<byte[]>.Factory.FromAsync(transport.BeginSend<byte[]>, transport.EndSend<byte[]>, req, null);
			return await task;
		}
		
		public virtual char[] GetChar() {
			BSyncResult<char[]> asyncResult = new BSyncResult<char[]>();			
			GetChar(BAsyncResultHelper.ToDelegate<char[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetChar(BAsyncResult<char[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getChar req = new BRequest_RemoteArrayTypes1dim_getChar();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<char[]> GetCharAsync(){
			BRequest_RemoteArrayTypes1dim_getChar req = new BRequest_RemoteArrayTypes1dim_getChar();			
			Task<char[]> task = Task<char[]>.Factory.FromAsync(transport.BeginSend<char[]>, transport.EndSend<char[]>, req, null);
			return await task;
		}
		
		public virtual short[] GetShort() {
			BSyncResult<short[]> asyncResult = new BSyncResult<short[]>();			
			GetShort(BAsyncResultHelper.ToDelegate<short[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetShort(BAsyncResult<short[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getShort req = new BRequest_RemoteArrayTypes1dim_getShort();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<short[]> GetShortAsync(){
			BRequest_RemoteArrayTypes1dim_getShort req = new BRequest_RemoteArrayTypes1dim_getShort();			
			Task<short[]> task = Task<short[]>.Factory.FromAsync(transport.BeginSend<short[]>, transport.EndSend<short[]>, req, null);
			return await task;
		}
		
		public virtual int[] GetInt() {
			BSyncResult<int[]> asyncResult = new BSyncResult<int[]>();			
			GetInt(BAsyncResultHelper.ToDelegate<int[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetInt(BAsyncResult<int[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getInt req = new BRequest_RemoteArrayTypes1dim_getInt();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int[]> GetIntAsync(){
			BRequest_RemoteArrayTypes1dim_getInt req = new BRequest_RemoteArrayTypes1dim_getInt();			
			Task<int[]> task = Task<int[]>.Factory.FromAsync(transport.BeginSend<int[]>, transport.EndSend<int[]>, req, null);
			return await task;
		}
		
		public virtual long[] GetLong() {
			BSyncResult<long[]> asyncResult = new BSyncResult<long[]>();			
			GetLong(BAsyncResultHelper.ToDelegate<long[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetLong(BAsyncResult<long[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getLong req = new BRequest_RemoteArrayTypes1dim_getLong();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<long[]> GetLongAsync(){
			BRequest_RemoteArrayTypes1dim_getLong req = new BRequest_RemoteArrayTypes1dim_getLong();			
			Task<long[]> task = Task<long[]>.Factory.FromAsync(transport.BeginSend<long[]>, transport.EndSend<long[]>, req, null);
			return await task;
		}
		
		public virtual float[] GetFloat() {
			BSyncResult<float[]> asyncResult = new BSyncResult<float[]>();			
			GetFloat(BAsyncResultHelper.ToDelegate<float[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetFloat(BAsyncResult<float[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getFloat req = new BRequest_RemoteArrayTypes1dim_getFloat();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<float[]> GetFloatAsync(){
			BRequest_RemoteArrayTypes1dim_getFloat req = new BRequest_RemoteArrayTypes1dim_getFloat();			
			Task<float[]> task = Task<float[]>.Factory.FromAsync(transport.BeginSend<float[]>, transport.EndSend<float[]>, req, null);
			return await task;
		}
		
		public virtual double[] GetDouble() {
			BSyncResult<double[]> asyncResult = new BSyncResult<double[]>();			
			GetDouble(BAsyncResultHelper.ToDelegate<double[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetDouble(BAsyncResult<double[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getDouble req = new BRequest_RemoteArrayTypes1dim_getDouble();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<double[]> GetDoubleAsync(){
			BRequest_RemoteArrayTypes1dim_getDouble req = new BRequest_RemoteArrayTypes1dim_getDouble();			
			Task<double[]> task = Task<double[]>.Factory.FromAsync(transport.BeginSend<double[]>, transport.EndSend<double[]>, req, null);
			return await task;
		}
		
		public virtual String[] GetString() {
			BSyncResult<String[]> asyncResult = new BSyncResult<String[]>();			
			GetString(BAsyncResultHelper.ToDelegate<String[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetString(BAsyncResult<String[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getString req = new BRequest_RemoteArrayTypes1dim_getString();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String[]> GetStringAsync(){
			BRequest_RemoteArrayTypes1dim_getString req = new BRequest_RemoteArrayTypes1dim_getString();			
			Task<String[]> task = Task<String[]>.Factory.FromAsync(transport.BeginSend<String[]>, transport.EndSend<String[]>, req, null);
			return await task;
		}
		
		public virtual byps.test.api.prim.PrimitiveTypes[] GetPrimitiveTypes() {
			BSyncResult<byps.test.api.prim.PrimitiveTypes[]> asyncResult = new BSyncResult<byps.test.api.prim.PrimitiveTypes[]>();			
			GetPrimitiveTypes(BAsyncResultHelper.ToDelegate<byps.test.api.prim.PrimitiveTypes[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPrimitiveTypes(BAsyncResult<byps.test.api.prim.PrimitiveTypes[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getPrimitiveTypes req = new BRequest_RemoteArrayTypes1dim_getPrimitiveTypes();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.prim.PrimitiveTypes[]> GetPrimitiveTypesAsync(){
			BRequest_RemoteArrayTypes1dim_getPrimitiveTypes req = new BRequest_RemoteArrayTypes1dim_getPrimitiveTypes();			
			Task<byps.test.api.prim.PrimitiveTypes[]> task = Task<byps.test.api.prim.PrimitiveTypes[]>.Factory.FromAsync(transport.BeginSend<byps.test.api.prim.PrimitiveTypes[]>, transport.EndSend<byps.test.api.prim.PrimitiveTypes[]>, req, null);
			return await task;
		}
		
		public virtual Object[] GetObject() {
			BSyncResult<Object[]> asyncResult = new BSyncResult<Object[]>();			
			GetObject(BAsyncResultHelper.ToDelegate<Object[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetObject(BAsyncResult<Object[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getObject req = new BRequest_RemoteArrayTypes1dim_getObject();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<Object[]> GetObjectAsync(){
			BRequest_RemoteArrayTypes1dim_getObject req = new BRequest_RemoteArrayTypes1dim_getObject();			
			Task<Object[]> task = Task<Object[]>.Factory.FromAsync(transport.BeginSend<Object[]>, transport.EndSend<Object[]>, req, null);
			return await task;
		}
		
		public virtual DateTime[] GetDate() {
			BSyncResult<DateTime[]> asyncResult = new BSyncResult<DateTime[]>();			
			GetDate(BAsyncResultHelper.ToDelegate<DateTime[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetDate(BAsyncResult<DateTime[]> asyncResult) {
			BRequest_RemoteArrayTypes1dim_getDate req = new BRequest_RemoteArrayTypes1dim_getDate();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<DateTime[]> GetDateAsync(){
			BRequest_RemoteArrayTypes1dim_getDate req = new BRequest_RemoteArrayTypes1dim_getDate();			
			Task<DateTime[]> task = Task<DateTime[]>.Factory.FromAsync(transport.BeginSend<DateTime[]>, transport.EndSend<DateTime[]>, req, null);
			return await task;
		}
		
		
	}
}
