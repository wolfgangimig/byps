using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// Interface with functions using 1-dimensional arrays.
	/// </summary>
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface RemoteArrayTypes1dim : BRemote {
	
		void SetBool(bool[] v);
		void SetBoolAsync(bool[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetBool(bool[] v, AsyncCallback callback, object state);
		Object EndSetBool(IAsyncResult asyncResult);
		
		void SetByte(byte[] v);
		void SetByteAsync(byte[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetByte(byte[] v, AsyncCallback callback, object state);
		Object EndSetByte(IAsyncResult asyncResult);
		
		void SetChar(char[] v);
		void SetCharAsync(char[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetChar(char[] v, AsyncCallback callback, object state);
		Object EndSetChar(IAsyncResult asyncResult);
		
		void SetShort(short[] v);
		void SetShortAsync(short[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetShort(short[] v, AsyncCallback callback, object state);
		Object EndSetShort(IAsyncResult asyncResult);
		
		void SetInt(int[] v);
		void SetIntAsync(int[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetInt(int[] v, AsyncCallback callback, object state);
		Object EndSetInt(IAsyncResult asyncResult);
		
		void SetLong(long[] v);
		void SetLongAsync(long[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetLong(long[] v, AsyncCallback callback, object state);
		Object EndSetLong(IAsyncResult asyncResult);
		
		void SetFloat(float[] v);
		void SetFloatAsync(float[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetFloat(float[] v, AsyncCallback callback, object state);
		Object EndSetFloat(IAsyncResult asyncResult);
		
		void SetDouble(double[] v);
		void SetDoubleAsync(double[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetDouble(double[] v, AsyncCallback callback, object state);
		Object EndSetDouble(IAsyncResult asyncResult);
		
		void SetString(String[] v);
		void SetStringAsync(String[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetString(String[] v, AsyncCallback callback, object state);
		Object EndSetString(IAsyncResult asyncResult);
		
		void SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v);
		void SetPrimitiveTypesAsync(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v, AsyncCallback callback, object state);
		Object EndSetPrimitiveTypes(IAsyncResult asyncResult);
		
		void SetObject(Object[] v);
		void SetObjectAsync(Object[] v, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetObject(Object[] v, AsyncCallback callback, object state);
		Object EndSetObject(IAsyncResult asyncResult);
		
		bool[] GetBool();
		void GetBoolAsync(BAsyncResult<bool[]> asyncResult) ;
		IAsyncResult BeginGetBool(AsyncCallback callback, object state);
		bool[] EndGetBool(IAsyncResult asyncResult);
		
		byte[] GetByte();
		void GetByteAsync(BAsyncResult<byte[]> asyncResult) ;
		IAsyncResult BeginGetByte(AsyncCallback callback, object state);
		byte[] EndGetByte(IAsyncResult asyncResult);
		
		char[] GetChar();
		void GetCharAsync(BAsyncResult<char[]> asyncResult) ;
		IAsyncResult BeginGetChar(AsyncCallback callback, object state);
		char[] EndGetChar(IAsyncResult asyncResult);
		
		short[] GetShort();
		void GetShortAsync(BAsyncResult<short[]> asyncResult) ;
		IAsyncResult BeginGetShort(AsyncCallback callback, object state);
		short[] EndGetShort(IAsyncResult asyncResult);
		
		int[] GetInt();
		void GetIntAsync(BAsyncResult<int[]> asyncResult) ;
		IAsyncResult BeginGetInt(AsyncCallback callback, object state);
		int[] EndGetInt(IAsyncResult asyncResult);
		
		long[] GetLong();
		void GetLongAsync(BAsyncResult<long[]> asyncResult) ;
		IAsyncResult BeginGetLong(AsyncCallback callback, object state);
		long[] EndGetLong(IAsyncResult asyncResult);
		
		float[] GetFloat();
		void GetFloatAsync(BAsyncResult<float[]> asyncResult) ;
		IAsyncResult BeginGetFloat(AsyncCallback callback, object state);
		float[] EndGetFloat(IAsyncResult asyncResult);
		
		double[] GetDouble();
		void GetDoubleAsync(BAsyncResult<double[]> asyncResult) ;
		IAsyncResult BeginGetDouble(AsyncCallback callback, object state);
		double[] EndGetDouble(IAsyncResult asyncResult);
		
		String[] GetString();
		void GetStringAsync(BAsyncResult<String[]> asyncResult) ;
		IAsyncResult BeginGetString(AsyncCallback callback, object state);
		String[] EndGetString(IAsyncResult asyncResult);
		
		com.wilutions.byps.test.api.prim.PrimitiveTypes[] GetPrimitiveTypes();
		void GetPrimitiveTypesAsync(BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) ;
		IAsyncResult BeginGetPrimitiveTypes(AsyncCallback callback, object state);
		com.wilutions.byps.test.api.prim.PrimitiveTypes[] EndGetPrimitiveTypes(IAsyncResult asyncResult);
		
		Object[] GetObject();
		void GetObjectAsync(BAsyncResult<Object[]> asyncResult) ;
		IAsyncResult BeginGetObject(AsyncCallback callback, object state);
		Object[] EndGetObject(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
