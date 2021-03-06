﻿using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteListTypes : BStub, RemoteListTypes, BSerializable {	
		
		public readonly static long serialVersionUID = 1233438138L;
		
		public BStub_RemoteListTypes(BTransport transport)
			: base(transport) {}			
		
		public virtual IList<bool> GetBoolean1() {
			BSyncResult<IList<bool>> asyncResult = new BSyncResult<IList<bool>>();			
			GetBoolean1(BAsyncResultHelper.ToDelegate<IList<bool>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetBoolean1(BAsyncResult<IList<bool>> asyncResult) {
			BRequest_RemoteListTypes_getBoolean1 req = new BRequest_RemoteListTypes_getBoolean1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<bool>> GetBoolean1Async(){
			BRequest_RemoteListTypes_getBoolean1 req = new BRequest_RemoteListTypes_getBoolean1();			
			Task<IList<bool>> task = Task<IList<bool>>.Factory.FromAsync(transport.BeginSend<IList<bool>>, transport.EndSend<IList<bool>>, req, null);
			return await task;
		}
		
		public virtual void SetBoolean1(IList<bool> boolean1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetBoolean1(boolean1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetBoolean1(IList<bool> boolean1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setBoolean1 req = new BRequest_RemoteListTypes_setBoolean1();			
			req.boolean1Value = boolean1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetBoolean1Async(IList<bool> boolean1){
			BRequest_RemoteListTypes_setBoolean1 req = new BRequest_RemoteListTypes_setBoolean1();			
			req.boolean1Value = boolean1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<byte> GetByte1() {
			BSyncResult<IList<byte>> asyncResult = new BSyncResult<IList<byte>>();			
			GetByte1(BAsyncResultHelper.ToDelegate<IList<byte>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetByte1(BAsyncResult<IList<byte>> asyncResult) {
			BRequest_RemoteListTypes_getByte1 req = new BRequest_RemoteListTypes_getByte1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<byte>> GetByte1Async(){
			BRequest_RemoteListTypes_getByte1 req = new BRequest_RemoteListTypes_getByte1();			
			Task<IList<byte>> task = Task<IList<byte>>.Factory.FromAsync(transport.BeginSend<IList<byte>>, transport.EndSend<IList<byte>>, req, null);
			return await task;
		}
		
		public virtual void SetByte1(IList<byte> byte1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte1(byte1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetByte1(IList<byte> byte1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setByte1 req = new BRequest_RemoteListTypes_setByte1();			
			req.byte1Value = byte1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetByte1Async(IList<byte> byte1){
			BRequest_RemoteListTypes_setByte1 req = new BRequest_RemoteListTypes_setByte1();			
			req.byte1Value = byte1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<char> GetChar1() {
			BSyncResult<IList<char>> asyncResult = new BSyncResult<IList<char>>();			
			GetChar1(BAsyncResultHelper.ToDelegate<IList<char>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetChar1(BAsyncResult<IList<char>> asyncResult) {
			BRequest_RemoteListTypes_getChar1 req = new BRequest_RemoteListTypes_getChar1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<char>> GetChar1Async(){
			BRequest_RemoteListTypes_getChar1 req = new BRequest_RemoteListTypes_getChar1();			
			Task<IList<char>> task = Task<IList<char>>.Factory.FromAsync(transport.BeginSend<IList<char>>, transport.EndSend<IList<char>>, req, null);
			return await task;
		}
		
		public virtual void SetChar1(IList<char> char1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetChar1(char1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetChar1(IList<char> char1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setChar1 req = new BRequest_RemoteListTypes_setChar1();			
			req.char1Value = char1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetChar1Async(IList<char> char1){
			BRequest_RemoteListTypes_setChar1 req = new BRequest_RemoteListTypes_setChar1();			
			req.char1Value = char1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<short> GetShort1() {
			BSyncResult<IList<short>> asyncResult = new BSyncResult<IList<short>>();			
			GetShort1(BAsyncResultHelper.ToDelegate<IList<short>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetShort1(BAsyncResult<IList<short>> asyncResult) {
			BRequest_RemoteListTypes_getShort1 req = new BRequest_RemoteListTypes_getShort1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<short>> GetShort1Async(){
			BRequest_RemoteListTypes_getShort1 req = new BRequest_RemoteListTypes_getShort1();			
			Task<IList<short>> task = Task<IList<short>>.Factory.FromAsync(transport.BeginSend<IList<short>>, transport.EndSend<IList<short>>, req, null);
			return await task;
		}
		
		public virtual void SetShort1(IList<short> short1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetShort1(short1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetShort1(IList<short> short1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setShort1 req = new BRequest_RemoteListTypes_setShort1();			
			req.short1Value = short1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetShort1Async(IList<short> short1){
			BRequest_RemoteListTypes_setShort1 req = new BRequest_RemoteListTypes_setShort1();			
			req.short1Value = short1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<int> GetInt1() {
			BSyncResult<IList<int>> asyncResult = new BSyncResult<IList<int>>();			
			GetInt1(BAsyncResultHelper.ToDelegate<IList<int>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetInt1(BAsyncResult<IList<int>> asyncResult) {
			BRequest_RemoteListTypes_getInt1 req = new BRequest_RemoteListTypes_getInt1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<int>> GetInt1Async(){
			BRequest_RemoteListTypes_getInt1 req = new BRequest_RemoteListTypes_getInt1();			
			Task<IList<int>> task = Task<IList<int>>.Factory.FromAsync(transport.BeginSend<IList<int>>, transport.EndSend<IList<int>>, req, null);
			return await task;
		}
		
		public virtual void SetInt1(IList<int> int1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt1(int1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetInt1(IList<int> int1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt1 req = new BRequest_RemoteListTypes_setInt1();			
			req.int1Value = int1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt1Async(IList<int> int1){
			BRequest_RemoteListTypes_setInt1 req = new BRequest_RemoteListTypes_setInt1();			
			req.int1Value = int1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<long> GetLong1() {
			BSyncResult<IList<long>> asyncResult = new BSyncResult<IList<long>>();			
			GetLong1(BAsyncResultHelper.ToDelegate<IList<long>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetLong1(BAsyncResult<IList<long>> asyncResult) {
			BRequest_RemoteListTypes_getLong1 req = new BRequest_RemoteListTypes_getLong1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<long>> GetLong1Async(){
			BRequest_RemoteListTypes_getLong1 req = new BRequest_RemoteListTypes_getLong1();			
			Task<IList<long>> task = Task<IList<long>>.Factory.FromAsync(transport.BeginSend<IList<long>>, transport.EndSend<IList<long>>, req, null);
			return await task;
		}
		
		public virtual void SetLong1(IList<long> long1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetLong1(long1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetLong1(IList<long> long1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setLong1 req = new BRequest_RemoteListTypes_setLong1();			
			req.long1Value = long1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetLong1Async(IList<long> long1){
			BRequest_RemoteListTypes_setLong1 req = new BRequest_RemoteListTypes_setLong1();			
			req.long1Value = long1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<float> GetFloat1() {
			BSyncResult<IList<float>> asyncResult = new BSyncResult<IList<float>>();			
			GetFloat1(BAsyncResultHelper.ToDelegate<IList<float>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetFloat1(BAsyncResult<IList<float>> asyncResult) {
			BRequest_RemoteListTypes_getFloat1 req = new BRequest_RemoteListTypes_getFloat1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<float>> GetFloat1Async(){
			BRequest_RemoteListTypes_getFloat1 req = new BRequest_RemoteListTypes_getFloat1();			
			Task<IList<float>> task = Task<IList<float>>.Factory.FromAsync(transport.BeginSend<IList<float>>, transport.EndSend<IList<float>>, req, null);
			return await task;
		}
		
		public virtual void SetFloat1(IList<float> float1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetFloat1(float1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetFloat1(IList<float> float1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setFloat1 req = new BRequest_RemoteListTypes_setFloat1();			
			req.float1Value = float1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetFloat1Async(IList<float> float1){
			BRequest_RemoteListTypes_setFloat1 req = new BRequest_RemoteListTypes_setFloat1();			
			req.float1Value = float1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<double> GetDouble1() {
			BSyncResult<IList<double>> asyncResult = new BSyncResult<IList<double>>();			
			GetDouble1(BAsyncResultHelper.ToDelegate<IList<double>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetDouble1(BAsyncResult<IList<double>> asyncResult) {
			BRequest_RemoteListTypes_getDouble1 req = new BRequest_RemoteListTypes_getDouble1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<double>> GetDouble1Async(){
			BRequest_RemoteListTypes_getDouble1 req = new BRequest_RemoteListTypes_getDouble1();			
			Task<IList<double>> task = Task<IList<double>>.Factory.FromAsync(transport.BeginSend<IList<double>>, transport.EndSend<IList<double>>, req, null);
			return await task;
		}
		
		public virtual void SetDouble1(IList<double> double1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDouble1(double1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetDouble1(IList<double> double1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setDouble1 req = new BRequest_RemoteListTypes_setDouble1();			
			req.double1Value = double1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetDouble1Async(IList<double> double1){
			BRequest_RemoteListTypes_setDouble1 req = new BRequest_RemoteListTypes_setDouble1();			
			req.double1Value = double1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<String> GetString1() {
			BSyncResult<IList<String>> asyncResult = new BSyncResult<IList<String>>();			
			GetString1(BAsyncResultHelper.ToDelegate<IList<String>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetString1(BAsyncResult<IList<String>> asyncResult) {
			BRequest_RemoteListTypes_getString1 req = new BRequest_RemoteListTypes_getString1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<String>> GetString1Async(){
			BRequest_RemoteListTypes_getString1 req = new BRequest_RemoteListTypes_getString1();			
			Task<IList<String>> task = Task<IList<String>>.Factory.FromAsync(transport.BeginSend<IList<String>>, transport.EndSend<IList<String>>, req, null);
			return await task;
		}
		
		public virtual void SetString1(IList<String> string1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetString1(string1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetString1(IList<String> string1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setString1 req = new BRequest_RemoteListTypes_setString1();			
			req.string1Value = string1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetString1Async(IList<String> string1){
			BRequest_RemoteListTypes_setString1 req = new BRequest_RemoteListTypes_setString1();			
			req.string1Value = string1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			BSyncResult<IList<byps.test.api.prim.PrimitiveTypes>> asyncResult = new BSyncResult<IList<byps.test.api.prim.PrimitiveTypes>>();			
			GetPrimitiveTypes1(BAsyncResultHelper.ToDelegate<IList<byps.test.api.prim.PrimitiveTypes>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPrimitiveTypes1(BAsyncResult<IList<byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			BRequest_RemoteListTypes_getPrimitiveTypes1 req = new BRequest_RemoteListTypes_getPrimitiveTypes1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Async(){
			BRequest_RemoteListTypes_getPrimitiveTypes1 req = new BRequest_RemoteListTypes_getPrimitiveTypes1();			
			Task<IList<byps.test.api.prim.PrimitiveTypes>> task = Task<IList<byps.test.api.prim.PrimitiveTypes>>.Factory.FromAsync(transport.BeginSend<IList<byps.test.api.prim.PrimitiveTypes>>, transport.EndSend<IList<byps.test.api.prim.PrimitiveTypes>>, req, null);
			return await task;
		}
		
		public virtual void SetPrimitiveTypes1(IList<byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPrimitiveTypes1(primitiveTypes1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPrimitiveTypes1(IList<byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setPrimitiveTypes1 req = new BRequest_RemoteListTypes_setPrimitiveTypes1();			
			req.primitiveTypes1Value = primitiveTypes1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPrimitiveTypes1Async(IList<byps.test.api.prim.PrimitiveTypes> primitiveTypes1){
			BRequest_RemoteListTypes_setPrimitiveTypes1 req = new BRequest_RemoteListTypes_setPrimitiveTypes1();			
			req.primitiveTypes1Value = primitiveTypes1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<byte[]> GetByte2() {
			BSyncResult<IList<byte[]>> asyncResult = new BSyncResult<IList<byte[]>>();			
			GetByte2(BAsyncResultHelper.ToDelegate<IList<byte[]>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetByte2(BAsyncResult<IList<byte[]>> asyncResult) {
			BRequest_RemoteListTypes_getByte2 req = new BRequest_RemoteListTypes_getByte2();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<byte[]>> GetByte2Async(){
			BRequest_RemoteListTypes_getByte2 req = new BRequest_RemoteListTypes_getByte2();			
			Task<IList<byte[]>> task = Task<IList<byte[]>>.Factory.FromAsync(transport.BeginSend<IList<byte[]>>, transport.EndSend<IList<byte[]>>, req, null);
			return await task;
		}
		
		public virtual void SetByte2(IList<byte[]> byte2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetByte2(byte2, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetByte2(IList<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setByte2 req = new BRequest_RemoteListTypes_setByte2();			
			req.byte2Value = byte2;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetByte2Async(IList<byte[]> byte2){
			BRequest_RemoteListTypes_setByte2 req = new BRequest_RemoteListTypes_setByte2();			
			req.byte2Value = byte2;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<int[]> GetInt2() {
			BSyncResult<IList<int[]>> asyncResult = new BSyncResult<IList<int[]>>();			
			GetInt2(BAsyncResultHelper.ToDelegate<IList<int[]>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetInt2(BAsyncResult<IList<int[]>> asyncResult) {
			BRequest_RemoteListTypes_getInt2 req = new BRequest_RemoteListTypes_getInt2();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<int[]>> GetInt2Async(){
			BRequest_RemoteListTypes_getInt2 req = new BRequest_RemoteListTypes_getInt2();			
			Task<IList<int[]>> task = Task<IList<int[]>>.Factory.FromAsync(transport.BeginSend<IList<int[]>>, transport.EndSend<IList<int[]>>, req, null);
			return await task;
		}
		
		public virtual void SetInt2(IList<int[]> int2) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt2(int2, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetInt2(IList<int[]> int2, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt2 req = new BRequest_RemoteListTypes_setInt2();			
			req.int2Value = int2;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt2Async(IList<int[]> int2){
			BRequest_RemoteListTypes_setInt2 req = new BRequest_RemoteListTypes_setInt2();			
			req.int2Value = int2;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<Object> GetObj1() {
			BSyncResult<IList<Object>> asyncResult = new BSyncResult<IList<Object>>();			
			GetObj1(BAsyncResultHelper.ToDelegate<IList<Object>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetObj1(BAsyncResult<IList<Object>> asyncResult) {
			BRequest_RemoteListTypes_getObj1 req = new BRequest_RemoteListTypes_getObj1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<Object>> GetObj1Async(){
			BRequest_RemoteListTypes_getObj1 req = new BRequest_RemoteListTypes_getObj1();			
			Task<IList<Object>> task = Task<IList<Object>>.Factory.FromAsync(transport.BeginSend<IList<Object>>, transport.EndSend<IList<Object>>, req, null);
			return await task;
		}
		
		public virtual void SetObj1(IList<Object> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetObj1(obj1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetObj1(IList<Object> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setObj1 req = new BRequest_RemoteListTypes_setObj1();			
			req.obj1Value = obj1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetObj1Async(IList<Object> obj1){
			BRequest_RemoteListTypes_setObj1 req = new BRequest_RemoteListTypes_setObj1();			
			req.obj1Value = obj1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual void SetDate1(IList<DateTime> obj1) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetDate1(obj1, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetDate1(IList<DateTime> obj1, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setDate1 req = new BRequest_RemoteListTypes_setDate1();			
			req.obj1Value = obj1;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetDate1Async(IList<DateTime> obj1){
			BRequest_RemoteListTypes_setDate1 req = new BRequest_RemoteListTypes_setDate1();			
			req.obj1Value = obj1;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<DateTime> GetDate1() {
			BSyncResult<IList<DateTime>> asyncResult = new BSyncResult<IList<DateTime>>();			
			GetDate1(BAsyncResultHelper.ToDelegate<IList<DateTime>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetDate1(BAsyncResult<IList<DateTime>> asyncResult) {
			BRequest_RemoteListTypes_getDate1 req = new BRequest_RemoteListTypes_getDate1();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<DateTime>> GetDate1Async(){
			BRequest_RemoteListTypes_getDate1 req = new BRequest_RemoteListTypes_getDate1();			
			Task<IList<DateTime>> task = Task<IList<DateTime>>.Factory.FromAsync(transport.BeginSend<IList<DateTime>>, transport.EndSend<IList<DateTime>>, req, null);
			return await task;
		}
		
		public virtual IList<IList<int>> GetInt3() {
			BSyncResult<IList<IList<int>>> asyncResult = new BSyncResult<IList<IList<int>>>();			
			GetInt3(BAsyncResultHelper.ToDelegate<IList<IList<int>>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetInt3(BAsyncResult<IList<IList<int>>> asyncResult) {
			BRequest_RemoteListTypes_getInt3 req = new BRequest_RemoteListTypes_getInt3();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<IList<int>>> GetInt3Async(){
			BRequest_RemoteListTypes_getInt3 req = new BRequest_RemoteListTypes_getInt3();			
			Task<IList<IList<int>>> task = Task<IList<IList<int>>>.Factory.FromAsync(transport.BeginSend<IList<IList<int>>>, transport.EndSend<IList<IList<int>>>, req, null);
			return await task;
		}
		
		public virtual void SetInt3(IList<IList<int>> int3) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt3(int3, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetInt3(IList<IList<int>> int3, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt3 req = new BRequest_RemoteListTypes_setInt3();			
			req.int3Value = int3;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt3Async(IList<IList<int>> int3){
			BRequest_RemoteListTypes_setInt3 req = new BRequest_RemoteListTypes_setInt3();			
			req.int3Value = int3;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		public virtual IList<IDictionary<int,IList<HashSet<int>>>> GetInt4() {
			BSyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult = new BSyncResult<IList<IDictionary<int,IList<HashSet<int>>>>>();			
			GetInt4(BAsyncResultHelper.ToDelegate<IList<IDictionary<int,IList<HashSet<int>>>>>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetInt4(BAsyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult) {
			BRequest_RemoteListTypes_getInt4 req = new BRequest_RemoteListTypes_getInt4();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<IList<IDictionary<int,IList<HashSet<int>>>>> GetInt4Async(){
			BRequest_RemoteListTypes_getInt4 req = new BRequest_RemoteListTypes_getInt4();			
			Task<IList<IDictionary<int,IList<HashSet<int>>>>> task = Task<IList<IDictionary<int,IList<HashSet<int>>>>>.Factory.FromAsync(transport.BeginSend<IList<IDictionary<int,IList<HashSet<int>>>>>, transport.EndSend<IList<IDictionary<int,IList<HashSet<int>>>>>, req, null);
			return await task;
		}
		
		public virtual void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetInt4(int4, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteListTypes_setInt4 req = new BRequest_RemoteListTypes_setInt4();			
			req.int4Value = int4;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetInt4Async(IList<IDictionary<int,IList<HashSet<int>>>> int4){
			BRequest_RemoteListTypes_setInt4 req = new BRequest_RemoteListTypes_setInt4();			
			req.int4Value = int4;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
