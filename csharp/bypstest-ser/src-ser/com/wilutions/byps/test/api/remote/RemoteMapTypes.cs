using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteMapTypes : BRemote
	{
		IDictionary<String,bool> GetBoolean1();
		void GetBoolean1Async(BAsyncResult<IDictionary<String,bool>> asyncResult) ;
		IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state);
		IDictionary<String,bool> EndGetBoolean1(IAsyncResult asyncResult);
		
		void SetBoolean1(IDictionary<String,bool> boolean1);
		void SetBoolean1Async(IDictionary<String,bool> boolean1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetBoolean1(IDictionary<String,bool> boolean1, AsyncCallback callback, object state);
		Object EndSetBoolean1(IAsyncResult asyncResult);
		
		Dictionary<double,byte> GetByte1();
		void GetByte1Async(BAsyncResult<Dictionary<double,byte>> asyncResult) ;
		IAsyncResult BeginGetByte1(AsyncCallback callback, object state);
		Dictionary<double,byte> EndGetByte1(IAsyncResult asyncResult);
		
		void SetByte1(Dictionary<double,byte> byte1);
		void SetByte1Async(Dictionary<double,byte> byte1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte1(Dictionary<double,byte> byte1, AsyncCallback callback, object state);
		Object EndSetByte1(IAsyncResult asyncResult);
		
		Dictionary<float,char> GetChar1();
		void GetChar1Async(BAsyncResult<Dictionary<float,char>> asyncResult) ;
		IAsyncResult BeginGetChar1(AsyncCallback callback, object state);
		Dictionary<float,char> EndGetChar1(IAsyncResult asyncResult);
		
		void SetChar1(Dictionary<float,char> char1);
		void SetChar1Async(Dictionary<float,char> char1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetChar1(Dictionary<float,char> char1, AsyncCallback callback, object state);
		Object EndSetChar1(IAsyncResult asyncResult);
		
		IDictionary<long,short> GetShort1();
		void GetShort1Async(BAsyncResult<IDictionary<long,short>> asyncResult) ;
		IAsyncResult BeginGetShort1(AsyncCallback callback, object state);
		IDictionary<long,short> EndGetShort1(IAsyncResult asyncResult);
		
		void SetShort1(IDictionary<long,short> short1);
		void SetShort1Async(IDictionary<long,short> short1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetShort1(IDictionary<long,short> short1, AsyncCallback callback, object state);
		Object EndSetShort1(IAsyncResult asyncResult);
		
		IDictionary<int,int> GetInt1();
		void GetInt1Async(BAsyncResult<IDictionary<int,int>> asyncResult) ;
		IAsyncResult BeginGetInt1(AsyncCallback callback, object state);
		IDictionary<int,int> EndGetInt1(IAsyncResult asyncResult);
		
		void SetInt1(IDictionary<int,int> int1);
		void SetInt1Async(IDictionary<int,int> int1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt1(IDictionary<int,int> int1, AsyncCallback callback, object state);
		Object EndSetInt1(IAsyncResult asyncResult);
		
		IDictionary<short,long> GetLong1();
		void GetLong1Async(BAsyncResult<IDictionary<short,long>> asyncResult) ;
		IAsyncResult BeginGetLong1(AsyncCallback callback, object state);
		IDictionary<short,long> EndGetLong1(IAsyncResult asyncResult);
		
		void SetLong1(IDictionary<short,long> long1);
		void SetLong1Async(IDictionary<short,long> long1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetLong1(IDictionary<short,long> long1, AsyncCallback callback, object state);
		Object EndSetLong1(IAsyncResult asyncResult);
		
		IDictionary<char,float> GetFloat1();
		void GetFloat1Async(BAsyncResult<IDictionary<char,float>> asyncResult) ;
		IAsyncResult BeginGetFloat1(AsyncCallback callback, object state);
		IDictionary<char,float> EndGetFloat1(IAsyncResult asyncResult);
		
		void SetFloat1(IDictionary<char,float> float1);
		void SetFloat1Async(IDictionary<char,float> float1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetFloat1(IDictionary<char,float> float1, AsyncCallback callback, object state);
		Object EndSetFloat1(IAsyncResult asyncResult);
		
		IDictionary<byte,double> GetDouble1();
		void GetDouble1Async(BAsyncResult<IDictionary<byte,double>> asyncResult) ;
		IAsyncResult BeginGetDouble1(AsyncCallback callback, object state);
		IDictionary<byte,double> EndGetDouble1(IAsyncResult asyncResult);
		
		void SetDouble1(IDictionary<byte,double> double1);
		void SetDouble1Async(IDictionary<byte,double> double1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetDouble1(IDictionary<byte,double> double1, AsyncCallback callback, object state);
		Object EndSetDouble1(IAsyncResult asyncResult);
		
		IDictionary<String,String> GetString1();
		void GetString1Async(BAsyncResult<IDictionary<String,String>> asyncResult) ;
		IAsyncResult BeginGetString1(AsyncCallback callback, object state);
		IDictionary<String,String> EndGetString1(IAsyncResult asyncResult);
		
		void SetString1(IDictionary<String,String> string1);
		void SetString1Async(IDictionary<String,String> string1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetString1(IDictionary<String,String> string1, AsyncCallback callback, object state);
		Object EndSetString1(IAsyncResult asyncResult);
		
		IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1();
		void GetPrimitiveTypes1Async(BAsyncResult<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) ;
		IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state);
		IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult);
		
		void SetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		void SetPrimitiveTypes1Async(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state);
		Object EndSetPrimitiveTypes1(IAsyncResult asyncResult);
		
		IDictionary<int,byte[]> GetByte2();
		void GetByte2Async(BAsyncResult<IDictionary<int,byte[]>> asyncResult) ;
		IAsyncResult BeginGetByte2(AsyncCallback callback, object state);
		IDictionary<int,byte[]> EndGetByte2(IAsyncResult asyncResult);
		
		void SetByte2(IDictionary<int,byte[]> byte2);
		void SetByte2Async(IDictionary<int,byte[]> byte2, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte2(IDictionary<int,byte[]> byte2, AsyncCallback callback, object state);
		Object EndSetByte2(IAsyncResult asyncResult);
		
		IDictionary<int,int[]> GetInt2();
		void GetInt2Async(BAsyncResult<IDictionary<int,int[]>> asyncResult) ;
		IAsyncResult BeginGetInt2(AsyncCallback callback, object state);
		IDictionary<int,int[]> EndGetInt2(IAsyncResult asyncResult);
		
		void SetInt2(IDictionary<int,int[]> int2);
		void SetInt2Async(IDictionary<int,int[]> int2, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt2(IDictionary<int,int[]> int2, AsyncCallback callback, object state);
		Object EndSetInt2(IAsyncResult asyncResult);
		
		IDictionary<String,Object> GetObj1();
		void GetObj1Async(BAsyncResult<IDictionary<String,Object>> asyncResult) ;
		IAsyncResult BeginGetObj1(AsyncCallback callback, object state);
		IDictionary<String,Object> EndGetObj1(IAsyncResult asyncResult);
		
		void SetObj1(IDictionary<String,Object> obj1);
		void SetObj1Async(IDictionary<String,Object> obj1, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetObj1(IDictionary<String,Object> obj1, AsyncCallback callback, object state);
		Object EndSetObj1(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
