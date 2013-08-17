using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteListTypes : BRemote
	{
		IList<bool> GetBoolean1();
		void async_GetBoolean1(BAsyncResult<IList<bool>> asyncResult) ;
		IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state);
		IList<bool> EndGetBoolean1(IAsyncResult asyncResult);
		
		void SetBoolean1(IList<bool> boolean1);
		void async_SetBoolean1(IList<bool> boolean1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetBoolean1(IList<bool> boolean1, AsyncCallback callback, object state);
		Object EndSetBoolean1(IAsyncResult asyncResult);
		
		IList<byte> GetByte1();
		void async_GetByte1(BAsyncResult<IList<byte>> asyncResult) ;
		IAsyncResult BeginGetByte1(AsyncCallback callback, object state);
		IList<byte> EndGetByte1(IAsyncResult asyncResult);
		
		void SetByte1(IList<byte> byte1);
		void async_SetByte1(IList<byte> byte1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte1(IList<byte> byte1, AsyncCallback callback, object state);
		Object EndSetByte1(IAsyncResult asyncResult);
		
		IList<char> GetChar1();
		void async_GetChar1(BAsyncResult<IList<char>> asyncResult) ;
		IAsyncResult BeginGetChar1(AsyncCallback callback, object state);
		IList<char> EndGetChar1(IAsyncResult asyncResult);
		
		void SetChar1(IList<char> char1);
		void async_SetChar1(IList<char> char1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetChar1(IList<char> char1, AsyncCallback callback, object state);
		Object EndSetChar1(IAsyncResult asyncResult);
		
		IList<short> GetShort1();
		void async_GetShort1(BAsyncResult<IList<short>> asyncResult) ;
		IAsyncResult BeginGetShort1(AsyncCallback callback, object state);
		IList<short> EndGetShort1(IAsyncResult asyncResult);
		
		void SetShort1(IList<short> short1);
		void async_SetShort1(IList<short> short1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetShort1(IList<short> short1, AsyncCallback callback, object state);
		Object EndSetShort1(IAsyncResult asyncResult);
		
		IList<int> GetInt1();
		void async_GetInt1(BAsyncResult<IList<int>> asyncResult) ;
		IAsyncResult BeginGetInt1(AsyncCallback callback, object state);
		IList<int> EndGetInt1(IAsyncResult asyncResult);
		
		void SetInt1(IList<int> int1);
		void async_SetInt1(IList<int> int1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt1(IList<int> int1, AsyncCallback callback, object state);
		Object EndSetInt1(IAsyncResult asyncResult);
		
		IList<long> GetLong1();
		void async_GetLong1(BAsyncResult<IList<long>> asyncResult) ;
		IAsyncResult BeginGetLong1(AsyncCallback callback, object state);
		IList<long> EndGetLong1(IAsyncResult asyncResult);
		
		void SetLong1(IList<long> long1);
		void async_SetLong1(IList<long> long1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetLong1(IList<long> long1, AsyncCallback callback, object state);
		Object EndSetLong1(IAsyncResult asyncResult);
		
		IList<float> GetFloat1();
		void async_GetFloat1(BAsyncResult<IList<float>> asyncResult) ;
		IAsyncResult BeginGetFloat1(AsyncCallback callback, object state);
		IList<float> EndGetFloat1(IAsyncResult asyncResult);
		
		void SetFloat1(IList<float> float1);
		void async_SetFloat1(IList<float> float1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetFloat1(IList<float> float1, AsyncCallback callback, object state);
		Object EndSetFloat1(IAsyncResult asyncResult);
		
		IList<double> GetDouble1();
		void async_GetDouble1(BAsyncResult<IList<double>> asyncResult) ;
		IAsyncResult BeginGetDouble1(AsyncCallback callback, object state);
		IList<double> EndGetDouble1(IAsyncResult asyncResult);
		
		void SetDouble1(IList<double> double1);
		void async_SetDouble1(IList<double> double1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetDouble1(IList<double> double1, AsyncCallback callback, object state);
		Object EndSetDouble1(IAsyncResult asyncResult);
		
		IList<String> GetString1();
		void async_GetString1(BAsyncResult<IList<String>> asyncResult) ;
		IAsyncResult BeginGetString1(AsyncCallback callback, object state);
		IList<String> EndGetString1(IAsyncResult asyncResult);
		
		void SetString1(IList<String> string1);
		void async_SetString1(IList<String> string1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetString1(IList<String> string1, AsyncCallback callback, object state);
		Object EndSetString1(IAsyncResult asyncResult);
		
		IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1();
		void async_GetPrimitiveTypes1(BAsyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) ;
		IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state);
		IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult);
		
		void SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		void async_SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state);
		Object EndSetPrimitiveTypes1(IAsyncResult asyncResult);
		
		IList<byte[]> GetByte2();
		void async_GetByte2(BAsyncResult<IList<byte[]>> asyncResult) ;
		IAsyncResult BeginGetByte2(AsyncCallback callback, object state);
		IList<byte[]> EndGetByte2(IAsyncResult asyncResult);
		
		void SetByte2(IList<byte[]> byte2);
		void async_SetByte2(IList<byte[]> byte2, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte2(IList<byte[]> byte2, AsyncCallback callback, object state);
		Object EndSetByte2(IAsyncResult asyncResult);
		
		IList<int[]> GetInt2();
		void async_GetInt2(BAsyncResult<IList<int[]>> asyncResult) ;
		IAsyncResult BeginGetInt2(AsyncCallback callback, object state);
		IList<int[]> EndGetInt2(IAsyncResult asyncResult);
		
		void SetInt2(IList<int[]> int2);
		void async_SetInt2(IList<int[]> int2, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt2(IList<int[]> int2, AsyncCallback callback, object state);
		Object EndSetInt2(IAsyncResult asyncResult);
		
		IList<Object> GetObj1();
		void async_GetObj1(BAsyncResult<IList<Object>> asyncResult) ;
		IAsyncResult BeginGetObj1(AsyncCallback callback, object state);
		IList<Object> EndGetObj1(IAsyncResult asyncResult);
		
		void SetObj1(IList<Object> obj1);
		void async_SetObj1(IList<Object> obj1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetObj1(IList<Object> obj1, AsyncCallback callback, object state);
		Object EndSetObj1(IAsyncResult asyncResult);
		
		IList<IList<int>> GetInt3();
		void async_GetInt3(BAsyncResult<IList<IList<int>>> asyncResult) ;
		IAsyncResult BeginGetInt3(AsyncCallback callback, object state);
		IList<IList<int>> EndGetInt3(IAsyncResult asyncResult);
		
		void SetInt3(IList<IList<int>> int3);
		void async_SetInt3(IList<IList<int>> int3, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt3(IList<IList<int>> int3, AsyncCallback callback, object state);
		Object EndSetInt3(IAsyncResult asyncResult);
		
		IList<IDictionary<int,IList<HashSet<int>>>> GetInt4();
		void async_GetInt4(BAsyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult) ;
		IAsyncResult BeginGetInt4(AsyncCallback callback, object state);
		IList<IDictionary<int,IList<HashSet<int>>>> EndGetInt4(IAsyncResult asyncResult);
		
		void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4);
		void async_SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, AsyncCallback callback, object state);
		Object EndSetInt4(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
