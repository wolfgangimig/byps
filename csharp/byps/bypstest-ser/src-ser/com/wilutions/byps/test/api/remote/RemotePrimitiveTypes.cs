using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemotePrimitiveTypes : BRemote
	{
		void VoidFunctionVoid();
		void async_VoidFunctionVoid(BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginVoidFunctionVoid(AsyncCallback callback, object state);
		Object EndVoidFunctionVoid(IAsyncResult asyncResult);
		
		void SetBool(bool v);
		void async_SetBool(bool v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetBool(bool v, AsyncCallback callback, object state);
		Object EndSetBool(IAsyncResult asyncResult);
		
		void SetByte(byte v);
		void async_SetByte(byte v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte(byte v, AsyncCallback callback, object state);
		Object EndSetByte(IAsyncResult asyncResult);
		
		void SetChar(char v);
		void async_SetChar(char v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetChar(char v, AsyncCallback callback, object state);
		Object EndSetChar(IAsyncResult asyncResult);
		
		void SetShort(short v);
		void async_SetShort(short v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetShort(short v, AsyncCallback callback, object state);
		Object EndSetShort(IAsyncResult asyncResult);
		
		void SetInt(int v);
		void async_SetInt(int v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt(int v, AsyncCallback callback, object state);
		Object EndSetInt(IAsyncResult asyncResult);
		
		void SetLong(long v);
		void async_SetLong(long v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetLong(long v, AsyncCallback callback, object state);
		Object EndSetLong(IAsyncResult asyncResult);
		
		void SetFloat(float v);
		void async_SetFloat(float v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetFloat(float v, AsyncCallback callback, object state);
		Object EndSetFloat(IAsyncResult asyncResult);
		
		void SetDouble(double v);
		void async_SetDouble(double v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetDouble(double v, AsyncCallback callback, object state);
		Object EndSetDouble(IAsyncResult asyncResult);
		
		void SetString(String v);
		void async_SetString(String v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetString(String v, AsyncCallback callback, object state);
		Object EndSetString(IAsyncResult asyncResult);
		
		void SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v);
		void async_SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v, AsyncCallback callback, object state);
		Object EndSetPrimitiveTypes(IAsyncResult asyncResult);
		
		void SetObject(Object v);
		void async_SetObject(Object v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetObject(Object v, AsyncCallback callback, object state);
		Object EndSetObject(IAsyncResult asyncResult);
		
		bool GetBool();
		void async_GetBool(BAsyncResult<bool> asyncResult) ;
		IAsyncResult BeginGetBool(AsyncCallback callback, object state);
		bool EndGetBool(IAsyncResult asyncResult);
		
		byte GetByte();
		void async_GetByte(BAsyncResult<byte> asyncResult) ;
		IAsyncResult BeginGetByte(AsyncCallback callback, object state);
		byte EndGetByte(IAsyncResult asyncResult);
		
		char GetChar();
		void async_GetChar(BAsyncResult<char> asyncResult) ;
		IAsyncResult BeginGetChar(AsyncCallback callback, object state);
		char EndGetChar(IAsyncResult asyncResult);
		
		short GetShort();
		void async_GetShort(BAsyncResult<short> asyncResult) ;
		IAsyncResult BeginGetShort(AsyncCallback callback, object state);
		short EndGetShort(IAsyncResult asyncResult);
		
		int GetInt();
		void async_GetInt(BAsyncResult<int> asyncResult) ;
		IAsyncResult BeginGetInt(AsyncCallback callback, object state);
		int EndGetInt(IAsyncResult asyncResult);
		
		long GetLong();
		void async_GetLong(BAsyncResult<long> asyncResult) ;
		IAsyncResult BeginGetLong(AsyncCallback callback, object state);
		long EndGetLong(IAsyncResult asyncResult);
		
		float GetFloat();
		void async_GetFloat(BAsyncResult<float> asyncResult) ;
		IAsyncResult BeginGetFloat(AsyncCallback callback, object state);
		float EndGetFloat(IAsyncResult asyncResult);
		
		double GetDouble();
		void async_GetDouble(BAsyncResult<double> asyncResult) ;
		IAsyncResult BeginGetDouble(AsyncCallback callback, object state);
		double EndGetDouble(IAsyncResult asyncResult);
		
		String GetString();
		void async_GetString(BAsyncResult<String> asyncResult) ;
		IAsyncResult BeginGetString(AsyncCallback callback, object state);
		String EndGetString(IAsyncResult asyncResult);
		
		com.wilutions.byps.test.api.prim.PrimitiveTypes GetPrimitiveTypes();
		void async_GetPrimitiveTypes(BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes> asyncResult) ;
		IAsyncResult BeginGetPrimitiveTypes(AsyncCallback callback, object state);
		com.wilutions.byps.test.api.prim.PrimitiveTypes EndGetPrimitiveTypes(IAsyncResult asyncResult);
		
		Object GetObject();
		void async_GetObject(BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginGetObject(AsyncCallback callback, object state);
		Object EndGetObject(IAsyncResult asyncResult);
		
		void SendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o);
		void async_SendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o, AsyncCallback callback, object state);
		Object EndSendAllTypes(IAsyncResult asyncResult);
		
		int Add(int a, int b);
		void async_Add(int a, int b, BAsyncResult<int> asyncResult) ;
		IAsyncResult BeginAdd(int a, int b, AsyncCallback callback, object state);
		int EndAdd(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
