using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteMapTypes : BRemote
	{
		IDictionary<String,bool> GetBoolean1();
		void async_GetBoolean1(BAsyncResult<IDictionary<String,bool>> asyncResult) ;
		IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state);
		IDictionary<String,bool> EndGetBoolean1(IAsyncResult asyncResult);
		
		void SetBoolean1(IDictionary<String,bool> boolean1);
		void async_SetBoolean1(IDictionary<String,bool> boolean1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetBoolean1(IDictionary<String,bool> boolean1, AsyncCallback callback, object state);
		Object EndSetBoolean1(IAsyncResult asyncResult);
		
		Dictionary<double,byte> GetByte1();
		void async_GetByte1(BAsyncResult<Dictionary<double,byte>> asyncResult) ;
		IAsyncResult BeginGetByte1(AsyncCallback callback, object state);
		Dictionary<double,byte> EndGetByte1(IAsyncResult asyncResult);
		
		void SetByte1(Dictionary<double,byte> byte1);
		void async_SetByte1(Dictionary<double,byte> byte1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte1(Dictionary<double,byte> byte1, AsyncCallback callback, object state);
		Object EndSetByte1(IAsyncResult asyncResult);
		
		Dictionary<float,char> GetChar1();
		void async_GetChar1(BAsyncResult<Dictionary<float,char>> asyncResult) ;
		IAsyncResult BeginGetChar1(AsyncCallback callback, object state);
		Dictionary<float,char> EndGetChar1(IAsyncResult asyncResult);
		
		void SetChar1(Dictionary<float,char> char1);
		void async_SetChar1(Dictionary<float,char> char1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetChar1(Dictionary<float,char> char1, AsyncCallback callback, object state);
		Object EndSetChar1(IAsyncResult asyncResult);
		
		IDictionary<long,short> GetShort1();
		void async_GetShort1(BAsyncResult<IDictionary<long,short>> asyncResult) ;
		IAsyncResult BeginGetShort1(AsyncCallback callback, object state);
		IDictionary<long,short> EndGetShort1(IAsyncResult asyncResult);
		
		void SetShort1(IDictionary<long,short> short1);
		void async_SetShort1(IDictionary<long,short> short1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetShort1(IDictionary<long,short> short1, AsyncCallback callback, object state);
		Object EndSetShort1(IAsyncResult asyncResult);
		
		IDictionary<int,int> GetInt1();
		void async_GetInt1(BAsyncResult<IDictionary<int,int>> asyncResult) ;
		IAsyncResult BeginGetInt1(AsyncCallback callback, object state);
		IDictionary<int,int> EndGetInt1(IAsyncResult asyncResult);
		
		void SetInt1(IDictionary<int,int> int1);
		void async_SetInt1(IDictionary<int,int> int1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt1(IDictionary<int,int> int1, AsyncCallback callback, object state);
		Object EndSetInt1(IAsyncResult asyncResult);
		
		IDictionary<short,long> GetLong1();
		void async_GetLong1(BAsyncResult<IDictionary<short,long>> asyncResult) ;
		IAsyncResult BeginGetLong1(AsyncCallback callback, object state);
		IDictionary<short,long> EndGetLong1(IAsyncResult asyncResult);
		
		void SetLong1(IDictionary<short,long> long1);
		void async_SetLong1(IDictionary<short,long> long1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetLong1(IDictionary<short,long> long1, AsyncCallback callback, object state);
		Object EndSetLong1(IAsyncResult asyncResult);
		
		IDictionary<char,float> GetFloat1();
		void async_GetFloat1(BAsyncResult<IDictionary<char,float>> asyncResult) ;
		IAsyncResult BeginGetFloat1(AsyncCallback callback, object state);
		IDictionary<char,float> EndGetFloat1(IAsyncResult asyncResult);
		
		void SetFloat1(IDictionary<char,float> float1);
		void async_SetFloat1(IDictionary<char,float> float1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetFloat1(IDictionary<char,float> float1, AsyncCallback callback, object state);
		Object EndSetFloat1(IAsyncResult asyncResult);
		
		IDictionary<byte,double> GetDouble1();
		void async_GetDouble1(BAsyncResult<IDictionary<byte,double>> asyncResult) ;
		IAsyncResult BeginGetDouble1(AsyncCallback callback, object state);
		IDictionary<byte,double> EndGetDouble1(IAsyncResult asyncResult);
		
		void SetDouble1(IDictionary<byte,double> double1);
		void async_SetDouble1(IDictionary<byte,double> double1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetDouble1(IDictionary<byte,double> double1, AsyncCallback callback, object state);
		Object EndSetDouble1(IAsyncResult asyncResult);
		
		IDictionary<String,String> GetString1();
		void async_GetString1(BAsyncResult<IDictionary<String,String>> asyncResult) ;
		IAsyncResult BeginGetString1(AsyncCallback callback, object state);
		IDictionary<String,String> EndGetString1(IAsyncResult asyncResult);
		
		void SetString1(IDictionary<String,String> string1);
		void async_SetString1(IDictionary<String,String> string1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetString1(IDictionary<String,String> string1, AsyncCallback callback, object state);
		Object EndSetString1(IAsyncResult asyncResult);
		
		IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1();
		void async_GetPrimitiveTypes1(BAsyncResult<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) ;
		IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state);
		IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult);
		
		void SetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		void async_SetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state);
		Object EndSetPrimitiveTypes1(IAsyncResult asyncResult);
		
		IDictionary<int,byte[]> GetByte2();
		void async_GetByte2(BAsyncResult<IDictionary<int,byte[]>> asyncResult) ;
		IAsyncResult BeginGetByte2(AsyncCallback callback, object state);
		IDictionary<int,byte[]> EndGetByte2(IAsyncResult asyncResult);
		
		void SetByte2(IDictionary<int,byte[]> byte2);
		void async_SetByte2(IDictionary<int,byte[]> byte2, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte2(IDictionary<int,byte[]> byte2, AsyncCallback callback, object state);
		Object EndSetByte2(IAsyncResult asyncResult);
		
		IDictionary<int,int[]> GetInt2();
		void async_GetInt2(BAsyncResult<IDictionary<int,int[]>> asyncResult) ;
		IAsyncResult BeginGetInt2(AsyncCallback callback, object state);
		IDictionary<int,int[]> EndGetInt2(IAsyncResult asyncResult);
		
		void SetInt2(IDictionary<int,int[]> int2);
		void async_SetInt2(IDictionary<int,int[]> int2, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt2(IDictionary<int,int[]> int2, AsyncCallback callback, object state);
		Object EndSetInt2(IAsyncResult asyncResult);
		
		IDictionary<String,Object> GetObj1();
		void async_GetObj1(BAsyncResult<IDictionary<String,Object>> asyncResult) ;
		IAsyncResult BeginGetObj1(AsyncCallback callback, object state);
		IDictionary<String,Object> EndGetObj1(IAsyncResult asyncResult);
		
		void SetObj1(IDictionary<String,Object> obj1);
		void async_SetObj1(IDictionary<String,Object> obj1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetObj1(IDictionary<String,Object> obj1, AsyncCallback callback, object state);
		Object EndSetObj1(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
