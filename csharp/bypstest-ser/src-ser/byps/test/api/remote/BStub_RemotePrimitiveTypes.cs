using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemotePrimitiveTypes : BStub, RemotePrimitiveTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 1178916877L;
		
		public BStub_RemotePrimitiveTypes(BTransport transport)
			: base(transport) {}			
		
		public void VoidFunctionVoid() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			VoidFunctionVoid(BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void VoidFunctionVoid(BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_voidFunctionVoid req = new BRequest_RemotePrimitiveTypes_voidFunctionVoid();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task VoidFunctionVoidAsync(){
			BRequest_RemotePrimitiveTypes_voidFunctionVoid req = new BRequest_RemotePrimitiveTypes_voidFunctionVoid();			
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetBool(bool v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBool(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetBool(bool v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setBool req = new BRequest_RemotePrimitiveTypes_setBool();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetBoolAsync(bool v){
			BRequest_RemotePrimitiveTypes_setBool req = new BRequest_RemotePrimitiveTypes_setBool();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetByte(byte v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetByte(byte v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setByte req = new BRequest_RemotePrimitiveTypes_setByte();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetByteAsync(byte v){
			BRequest_RemotePrimitiveTypes_setByte req = new BRequest_RemotePrimitiveTypes_setByte();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetChar(char v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetChar(char v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setChar req = new BRequest_RemotePrimitiveTypes_setChar();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetCharAsync(char v){
			BRequest_RemotePrimitiveTypes_setChar req = new BRequest_RemotePrimitiveTypes_setChar();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetShort(short v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetShort(short v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setShort req = new BRequest_RemotePrimitiveTypes_setShort();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetShortAsync(short v){
			BRequest_RemotePrimitiveTypes_setShort req = new BRequest_RemotePrimitiveTypes_setShort();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetInt(int v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetInt(int v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setInt req = new BRequest_RemotePrimitiveTypes_setInt();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetIntAsync(int v){
			BRequest_RemotePrimitiveTypes_setInt req = new BRequest_RemotePrimitiveTypes_setInt();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetLong(long v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetLong(long v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setLong req = new BRequest_RemotePrimitiveTypes_setLong();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetLongAsync(long v){
			BRequest_RemotePrimitiveTypes_setLong req = new BRequest_RemotePrimitiveTypes_setLong();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetFloat(float v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetFloat(float v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setFloat req = new BRequest_RemotePrimitiveTypes_setFloat();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetFloatAsync(float v){
			BRequest_RemotePrimitiveTypes_setFloat req = new BRequest_RemotePrimitiveTypes_setFloat();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetDouble(double v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetDouble(double v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setDouble req = new BRequest_RemotePrimitiveTypes_setDouble();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetDoubleAsync(double v){
			BRequest_RemotePrimitiveTypes_setDouble req = new BRequest_RemotePrimitiveTypes_setDouble();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetString(String v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetString(String v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setString req = new BRequest_RemotePrimitiveTypes_setString();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetStringAsync(String v){
			BRequest_RemotePrimitiveTypes_setString req = new BRequest_RemotePrimitiveTypes_setString();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetPrimitiveTypes(byps.test.api.prim.PrimitiveTypes v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPrimitiveTypes(byps.test.api.prim.PrimitiveTypes v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setPrimitiveTypes req = new BRequest_RemotePrimitiveTypes_setPrimitiveTypes();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPrimitiveTypesAsync(byps.test.api.prim.PrimitiveTypes v){
			BRequest_RemotePrimitiveTypes_setPrimitiveTypes req = new BRequest_RemotePrimitiveTypes_setPrimitiveTypes();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetObject(Object v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObject(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetObject(Object v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setObject req = new BRequest_RemotePrimitiveTypes_setObject();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetObjectAsync(Object v){
			BRequest_RemotePrimitiveTypes_setObject req = new BRequest_RemotePrimitiveTypes_setObject();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public void SetDate(java.util.Date v) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDate(v, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetDate(java.util.Date v, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_setDate req = new BRequest_RemotePrimitiveTypes_setDate();			
			req.vValue = v;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetDateAsync(java.util.Date v){
			BRequest_RemotePrimitiveTypes_setDate req = new BRequest_RemotePrimitiveTypes_setDate();			
			req.vValue = v;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public bool GetBool() {
			BSyncResult<bool> asyncResult = new BSyncResult<bool>();			
			GetBool(BAsyncResultHelper.ToDelegate<bool>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetBool(BAsyncResult<bool> asyncResult) {
			BRequest_RemotePrimitiveTypes_getBool req = new BRequest_RemotePrimitiveTypes_getBool();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<bool> GetBoolAsync(){
			BRequest_RemotePrimitiveTypes_getBool req = new BRequest_RemotePrimitiveTypes_getBool();			
			Task<bool> task = Task<bool>.Factory.FromAsync(transport.BeginSend<bool>, transport.EndSend<bool>, req, null);
			return await task;
		}
		
		public byte GetByte() {
			BSyncResult<byte> asyncResult = new BSyncResult<byte>();			
			GetByte(BAsyncResultHelper.ToDelegate<byte>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetByte(BAsyncResult<byte> asyncResult) {
			BRequest_RemotePrimitiveTypes_getByte req = new BRequest_RemotePrimitiveTypes_getByte();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byte> GetByteAsync(){
			BRequest_RemotePrimitiveTypes_getByte req = new BRequest_RemotePrimitiveTypes_getByte();			
			Task<byte> task = Task<byte>.Factory.FromAsync(transport.BeginSend<byte>, transport.EndSend<byte>, req, null);
			return await task;
		}
		
		public char GetChar() {
			BSyncResult<char> asyncResult = new BSyncResult<char>();			
			GetChar(BAsyncResultHelper.ToDelegate<char>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetChar(BAsyncResult<char> asyncResult) {
			BRequest_RemotePrimitiveTypes_getChar req = new BRequest_RemotePrimitiveTypes_getChar();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<char> GetCharAsync(){
			BRequest_RemotePrimitiveTypes_getChar req = new BRequest_RemotePrimitiveTypes_getChar();			
			Task<char> task = Task<char>.Factory.FromAsync(transport.BeginSend<char>, transport.EndSend<char>, req, null);
			return await task;
		}
		
		public short GetShort() {
			BSyncResult<short> asyncResult = new BSyncResult<short>();			
			GetShort(BAsyncResultHelper.ToDelegate<short>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetShort(BAsyncResult<short> asyncResult) {
			BRequest_RemotePrimitiveTypes_getShort req = new BRequest_RemotePrimitiveTypes_getShort();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<short> GetShortAsync(){
			BRequest_RemotePrimitiveTypes_getShort req = new BRequest_RemotePrimitiveTypes_getShort();			
			Task<short> task = Task<short>.Factory.FromAsync(transport.BeginSend<short>, transport.EndSend<short>, req, null);
			return await task;
		}
		
		public int GetInt() {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			GetInt(BAsyncResultHelper.ToDelegate<int>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetInt(BAsyncResult<int> asyncResult) {
			BRequest_RemotePrimitiveTypes_getInt req = new BRequest_RemotePrimitiveTypes_getInt();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int> GetIntAsync(){
			BRequest_RemotePrimitiveTypes_getInt req = new BRequest_RemotePrimitiveTypes_getInt();			
			Task<int> task = Task<int>.Factory.FromAsync(transport.BeginSend<int>, transport.EndSend<int>, req, null);
			return await task;
		}
		
		public long GetLong() {
			BSyncResult<long> asyncResult = new BSyncResult<long>();			
			GetLong(BAsyncResultHelper.ToDelegate<long>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetLong(BAsyncResult<long> asyncResult) {
			BRequest_RemotePrimitiveTypes_getLong req = new BRequest_RemotePrimitiveTypes_getLong();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<long> GetLongAsync(){
			BRequest_RemotePrimitiveTypes_getLong req = new BRequest_RemotePrimitiveTypes_getLong();			
			Task<long> task = Task<long>.Factory.FromAsync(transport.BeginSend<long>, transport.EndSend<long>, req, null);
			return await task;
		}
		
		public float GetFloat() {
			BSyncResult<float> asyncResult = new BSyncResult<float>();			
			GetFloat(BAsyncResultHelper.ToDelegate<float>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetFloat(BAsyncResult<float> asyncResult) {
			BRequest_RemotePrimitiveTypes_getFloat req = new BRequest_RemotePrimitiveTypes_getFloat();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<float> GetFloatAsync(){
			BRequest_RemotePrimitiveTypes_getFloat req = new BRequest_RemotePrimitiveTypes_getFloat();			
			Task<float> task = Task<float>.Factory.FromAsync(transport.BeginSend<float>, transport.EndSend<float>, req, null);
			return await task;
		}
		
		public double GetDouble() {
			BSyncResult<double> asyncResult = new BSyncResult<double>();			
			GetDouble(BAsyncResultHelper.ToDelegate<double>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetDouble(BAsyncResult<double> asyncResult) {
			BRequest_RemotePrimitiveTypes_getDouble req = new BRequest_RemotePrimitiveTypes_getDouble();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<double> GetDoubleAsync(){
			BRequest_RemotePrimitiveTypes_getDouble req = new BRequest_RemotePrimitiveTypes_getDouble();			
			Task<double> task = Task<double>.Factory.FromAsync(transport.BeginSend<double>, transport.EndSend<double>, req, null);
			return await task;
		}
		
		public String GetString() {
			BSyncResult<String> asyncResult = new BSyncResult<String>();			
			GetString(BAsyncResultHelper.ToDelegate<String>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetString(BAsyncResult<String> asyncResult) {
			BRequest_RemotePrimitiveTypes_getString req = new BRequest_RemotePrimitiveTypes_getString();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<String> GetStringAsync(){
			BRequest_RemotePrimitiveTypes_getString req = new BRequest_RemotePrimitiveTypes_getString();			
			Task<String> task = Task<String>.Factory.FromAsync(transport.BeginSend<String>, transport.EndSend<String>, req, null);
			return await task;
		}
		
		public byps.test.api.prim.PrimitiveTypes GetPrimitiveTypes() {
			BSyncResult<byps.test.api.prim.PrimitiveTypes> asyncResult = new BSyncResult<byps.test.api.prim.PrimitiveTypes>();			
			GetPrimitiveTypes(BAsyncResultHelper.ToDelegate<byps.test.api.prim.PrimitiveTypes>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPrimitiveTypes(BAsyncResult<byps.test.api.prim.PrimitiveTypes> asyncResult) {
			BRequest_RemotePrimitiveTypes_getPrimitiveTypes req = new BRequest_RemotePrimitiveTypes_getPrimitiveTypes();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypesAsync(){
			BRequest_RemotePrimitiveTypes_getPrimitiveTypes req = new BRequest_RemotePrimitiveTypes_getPrimitiveTypes();			
			Task<byps.test.api.prim.PrimitiveTypes> task = Task<byps.test.api.prim.PrimitiveTypes>.Factory.FromAsync(transport.BeginSend<byps.test.api.prim.PrimitiveTypes>, transport.EndSend<byps.test.api.prim.PrimitiveTypes>, req, null);
			return await task;
		}
		
		public Object GetObject() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			GetObject(BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetObject(BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_getObject req = new BRequest_RemotePrimitiveTypes_getObject();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<Object> GetObjectAsync(){
			BRequest_RemotePrimitiveTypes_getObject req = new BRequest_RemotePrimitiveTypes_getObject();			
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			return await task;
		}
		
		public java.util.Date GetDate() {
			BSyncResult<java.util.Date> asyncResult = new BSyncResult<java.util.Date>();			
			GetDate(BAsyncResultHelper.ToDelegate<java.util.Date>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetDate(BAsyncResult<java.util.Date> asyncResult) {
			BRequest_RemotePrimitiveTypes_getDate req = new BRequest_RemotePrimitiveTypes_getDate();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<java.util.Date> GetDateAsync(){
			BRequest_RemotePrimitiveTypes_getDate req = new BRequest_RemotePrimitiveTypes_getDate();			
			Task<java.util.Date> task = Task<java.util.Date>.Factory.FromAsync(transport.BeginSend<java.util.Date>, transport.EndSend<java.util.Date>, req, null);
			return await task;
		}
		
		public void SendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, byps.test.api.prim.PrimitiveTypes pt, Object o) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SendAllTypes(b, c, s, i, l, f, d, str, pt, o, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, byps.test.api.prim.PrimitiveTypes pt, Object o, BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_sendAllTypes req = new BRequest_RemotePrimitiveTypes_sendAllTypes();			
			req.bValue = b;
			req.cValue = c;
			req.sValue = s;
			req.iValue = i;
			req.lValue = l;
			req.fValue = f;
			req.dValue = d;
			req.strValue = str;
			req.ptValue = pt;
			req.oValue = o;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SendAllTypesAsync(bool b, char c, short s, int i, long l, float f, double d, String str, byps.test.api.prim.PrimitiveTypes pt, Object o){
			BRequest_RemotePrimitiveTypes_sendAllTypes req = new BRequest_RemotePrimitiveTypes_sendAllTypes();			
			req.bValue = b;
			req.cValue = c;
			req.sValue = s;
			req.iValue = i;
			req.lValue = l;
			req.fValue = f;
			req.dValue = d;
			req.strValue = str;
			req.ptValue = pt;
			req.oValue = o;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public int Add(int a, int b) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			Add(a, b, BAsyncResultHelper.ToDelegate<int>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void Add(int a, int b, BAsyncResult<int> asyncResult) {
			BRequest_RemotePrimitiveTypes_add req = new BRequest_RemotePrimitiveTypes_add();			
			req.aValue = a;
			req.bValue = b;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int> AddAsync(int a, int b){
			BRequest_RemotePrimitiveTypes_add req = new BRequest_RemotePrimitiveTypes_add();			
			req.aValue = a;
			req.bValue = b;
			Task<int> task = Task<int>.Factory.FromAsync(transport.BeginSend<int>, transport.EndSend<int>, req, null);
			return await task;
		}
		
		public java.util.Date MakeDate(int year, int month, int day, int hour, int minute, int second, int millisecond) {
			BSyncResult<java.util.Date> asyncResult = new BSyncResult<java.util.Date>();			
			MakeDate(year, month, day, hour, minute, second, millisecond, BAsyncResultHelper.ToDelegate<java.util.Date>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void MakeDate(int year, int month, int day, int hour, int minute, int second, int millisecond, BAsyncResult<java.util.Date> asyncResult) {
			BRequest_RemotePrimitiveTypes_makeDate req = new BRequest_RemotePrimitiveTypes_makeDate();			
			req.yearValue = year;
			req.monthValue = month;
			req.dayValue = day;
			req.hourValue = hour;
			req.minuteValue = minute;
			req.secondValue = second;
			req.millisecondValue = millisecond;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<java.util.Date> MakeDateAsync(int year, int month, int day, int hour, int minute, int second, int millisecond){
			BRequest_RemotePrimitiveTypes_makeDate req = new BRequest_RemotePrimitiveTypes_makeDate();			
			req.yearValue = year;
			req.monthValue = month;
			req.dayValue = day;
			req.hourValue = hour;
			req.minuteValue = minute;
			req.secondValue = second;
			req.millisecondValue = millisecond;
			Task<java.util.Date> task = Task<java.util.Date>.Factory.FromAsync(transport.BeginSend<java.util.Date>, transport.EndSend<java.util.Date>, req, null);
			return await task;
		}
		
		public int[] ParseDate(java.util.Date date) {
			BSyncResult<int[]> asyncResult = new BSyncResult<int[]>();			
			ParseDate(date, BAsyncResultHelper.ToDelegate<int[]>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void ParseDate(java.util.Date date, BAsyncResult<int[]> asyncResult) {
			BRequest_RemotePrimitiveTypes_parseDate req = new BRequest_RemotePrimitiveTypes_parseDate();			
			req.dateValue = date;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<int[]> ParseDateAsync(java.util.Date date){
			BRequest_RemotePrimitiveTypes_parseDate req = new BRequest_RemotePrimitiveTypes_parseDate();			
			req.dateValue = date;
			Task<int[]> task = Task<int[]>.Factory.FromAsync(transport.BeginSend<int[]>, transport.EndSend<int[]>, req, null);
			return await task;
		}
		
		public void ThrowException() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			ThrowException(BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void ThrowException(BAsyncResult<Object> asyncResult) {
			BRequest_RemotePrimitiveTypes_throwException req = new BRequest_RemotePrimitiveTypes_throwException();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task ThrowExceptionAsync(){
			BRequest_RemotePrimitiveTypes_throwException req = new BRequest_RemotePrimitiveTypes_throwException();			
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
