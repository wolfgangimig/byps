using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteArrayTypes1dim.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteArrayTypes1dim : BSkeleton, RemoteArrayTypes1dim {	
		
		public readonly static long serialVersionUID = 1557084481L;
		
		public virtual void SetBool(bool[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetBool(bool[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetBool(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetBool(bool[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetBool(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetByte(byte[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetByte(byte[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetByte(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetByte(byte[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetByte(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetChar(char[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetChar(char[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetChar(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetChar(char[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetChar(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetShort(short[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetShort(short[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetShort(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetShort(short[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetShort(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetInt(int[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetInt(int[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetInt(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt(int[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetInt(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetLong(long[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetLong(long[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetLong(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetLong(long[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetLong(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetFloat(float[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetFloat(float[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetFloat(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetFloat(float[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetFloat(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetDouble(double[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetDouble(double[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetDouble(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetDouble(double[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetDouble(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetString(String[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetString(String[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetString(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetString(String[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetString(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetPrimitiveTypes(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetPrimitiveTypes(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetObject(Object[] v) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetObject(Object[] v, BAsyncResult<Object> asyncResult) {
			try {
				SetObject(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetObject(Object[] v, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetObject(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual bool[] GetBool() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetBool(BAsyncResult<bool[]> asyncResult) {
			try {
				bool[] ret = GetBool();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetBool(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public bool[] EndGetBool(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual byte[] GetByte() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetByte(BAsyncResult<byte[]> asyncResult) {
			try {
				byte[] ret = GetByte();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetByte(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public byte[] EndGetByte(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual char[] GetChar() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetChar(BAsyncResult<char[]> asyncResult) {
			try {
				char[] ret = GetChar();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetChar(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public char[] EndGetChar(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual short[] GetShort() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetShort(BAsyncResult<short[]> asyncResult) {
			try {
				short[] ret = GetShort();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetShort(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public short[] EndGetShort(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual int[] GetInt() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetInt(BAsyncResult<int[]> asyncResult) {
			try {
				int[] ret = GetInt();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public int[] EndGetInt(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual long[] GetLong() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetLong(BAsyncResult<long[]> asyncResult) {
			try {
				long[] ret = GetLong();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetLong(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public long[] EndGetLong(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual float[] GetFloat() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetFloat(BAsyncResult<float[]> asyncResult) {
			try {
				float[] ret = GetFloat();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetFloat(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public float[] EndGetFloat(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual double[] GetDouble() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetDouble(BAsyncResult<double[]> asyncResult) {
			try {
				double[] ret = GetDouble();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetDouble(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public double[] EndGetDouble(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual String[] GetString() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetString(BAsyncResult<String[]> asyncResult) {
			try {
				String[] ret = GetString();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetString(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public String[] EndGetString(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual com.wilutions.byps.test.api.prim.PrimitiveTypes[] GetPrimitiveTypes() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPrimitiveTypes(BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> asyncResult) {
			try {
				com.wilutions.byps.test.api.prim.PrimitiveTypes[] ret = GetPrimitiveTypes();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPrimitiveTypes(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.prim.PrimitiveTypes[] EndGetPrimitiveTypes(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual Object[] GetObject() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetObject(BAsyncResult<Object[]> asyncResult) {
			try {
				Object[] ret = GetObject();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetObject(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object[] EndGetObject(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		
	}
}
