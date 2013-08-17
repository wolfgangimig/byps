using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteSetTypes : BRemote
	{
		ISet<bool> GetBoolean1();
		void async_GetBoolean1(BAsyncResult<ISet<bool>> asyncResult) ;
		IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state);
		ISet<bool> EndGetBoolean1(IAsyncResult asyncResult);
		
		void SetBoolean1(ISet<bool> boolean1);
		void async_SetBoolean1(ISet<bool> boolean1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetBoolean1(ISet<bool> boolean1, AsyncCallback callback, object state);
		Object EndSetBoolean1(IAsyncResult asyncResult);
		
		HashSet<byte> GetByte1();
		void async_GetByte1(BAsyncResult<HashSet<byte>> asyncResult) ;
		IAsyncResult BeginGetByte1(AsyncCallback callback, object state);
		HashSet<byte> EndGetByte1(IAsyncResult asyncResult);
		
		void SetByte1(HashSet<byte> byte1);
		void async_SetByte1(HashSet<byte> byte1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte1(HashSet<byte> byte1, AsyncCallback callback, object state);
		Object EndSetByte1(IAsyncResult asyncResult);
		
		HashSet<char> GetChar1();
		void async_GetChar1(BAsyncResult<HashSet<char>> asyncResult) ;
		IAsyncResult BeginGetChar1(AsyncCallback callback, object state);
		HashSet<char> EndGetChar1(IAsyncResult asyncResult);
		
		void SetChar1(HashSet<char> char1);
		void async_SetChar1(HashSet<char> char1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetChar1(HashSet<char> char1, AsyncCallback callback, object state);
		Object EndSetChar1(IAsyncResult asyncResult);
		
		ISet<short> GetShort1();
		void async_GetShort1(BAsyncResult<ISet<short>> asyncResult) ;
		IAsyncResult BeginGetShort1(AsyncCallback callback, object state);
		ISet<short> EndGetShort1(IAsyncResult asyncResult);
		
		void SetShort1(ISet<short> short1);
		void async_SetShort1(ISet<short> short1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetShort1(ISet<short> short1, AsyncCallback callback, object state);
		Object EndSetShort1(IAsyncResult asyncResult);
		
		ISet<int> GetInt1();
		void async_GetInt1(BAsyncResult<ISet<int>> asyncResult) ;
		IAsyncResult BeginGetInt1(AsyncCallback callback, object state);
		ISet<int> EndGetInt1(IAsyncResult asyncResult);
		
		void SetInt1(ISet<int> int1);
		void async_SetInt1(ISet<int> int1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt1(ISet<int> int1, AsyncCallback callback, object state);
		Object EndSetInt1(IAsyncResult asyncResult);
		
		ISet<long> GetLong1();
		void async_GetLong1(BAsyncResult<ISet<long>> asyncResult) ;
		IAsyncResult BeginGetLong1(AsyncCallback callback, object state);
		ISet<long> EndGetLong1(IAsyncResult asyncResult);
		
		void SetLong1(ISet<long> long1);
		void async_SetLong1(ISet<long> long1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetLong1(ISet<long> long1, AsyncCallback callback, object state);
		Object EndSetLong1(IAsyncResult asyncResult);
		
		ISet<float> GetFloat1();
		void async_GetFloat1(BAsyncResult<ISet<float>> asyncResult) ;
		IAsyncResult BeginGetFloat1(AsyncCallback callback, object state);
		ISet<float> EndGetFloat1(IAsyncResult asyncResult);
		
		void SetFloat1(ISet<float> float1);
		void async_SetFloat1(ISet<float> float1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetFloat1(ISet<float> float1, AsyncCallback callback, object state);
		Object EndSetFloat1(IAsyncResult asyncResult);
		
		ISet<double> GetDouble1();
		void async_GetDouble1(BAsyncResult<ISet<double>> asyncResult) ;
		IAsyncResult BeginGetDouble1(AsyncCallback callback, object state);
		ISet<double> EndGetDouble1(IAsyncResult asyncResult);
		
		void SetDouble1(ISet<double> double1);
		void async_SetDouble1(ISet<double> double1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetDouble1(ISet<double> double1, AsyncCallback callback, object state);
		Object EndSetDouble1(IAsyncResult asyncResult);
		
		ISet<String> GetString1();
		void async_GetString1(BAsyncResult<ISet<String>> asyncResult) ;
		IAsyncResult BeginGetString1(AsyncCallback callback, object state);
		ISet<String> EndGetString1(IAsyncResult asyncResult);
		
		void SetString1(ISet<String> string1);
		void async_SetString1(ISet<String> string1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetString1(ISet<String> string1, AsyncCallback callback, object state);
		Object EndSetString1(IAsyncResult asyncResult);
		
		ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1();
		void async_GetPrimitiveTypes1(BAsyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) ;
		IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state);
		ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult);
		
		void SetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		void async_SetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state);
		Object EndSetPrimitiveTypes1(IAsyncResult asyncResult);
		
		ISet<byte[]> GetByte2();
		void async_GetByte2(BAsyncResult<ISet<byte[]>> asyncResult) ;
		IAsyncResult BeginGetByte2(AsyncCallback callback, object state);
		ISet<byte[]> EndGetByte2(IAsyncResult asyncResult);
		
		void SetByte2(ISet<byte[]> byte2);
		void async_SetByte2(ISet<byte[]> byte2, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte2(ISet<byte[]> byte2, AsyncCallback callback, object state);
		Object EndSetByte2(IAsyncResult asyncResult);
		
		ISet<int[]> GetInt2();
		void async_GetInt2(BAsyncResult<ISet<int[]>> asyncResult) ;
		IAsyncResult BeginGetInt2(AsyncCallback callback, object state);
		ISet<int[]> EndGetInt2(IAsyncResult asyncResult);
		
		void SetInt2(ISet<int[]> int2);
		void async_SetInt2(ISet<int[]> int2, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt2(ISet<int[]> int2, AsyncCallback callback, object state);
		Object EndSetInt2(IAsyncResult asyncResult);
		
		ISet<Object> GetObj1();
		void async_GetObj1(BAsyncResult<ISet<Object>> asyncResult) ;
		IAsyncResult BeginGetObj1(AsyncCallback callback, object state);
		ISet<Object> EndGetObj1(IAsyncResult asyncResult);
		
		void SetObj1(ISet<Object> obj1);
		void async_SetObj1(ISet<Object> obj1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetObj1(ISet<Object> obj1, AsyncCallback callback, object state);
		Object EndSetObj1(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
