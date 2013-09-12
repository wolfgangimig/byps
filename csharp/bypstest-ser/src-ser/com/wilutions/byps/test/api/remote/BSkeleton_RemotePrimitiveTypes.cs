using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemotePrimitiveTypes.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemotePrimitiveTypes : BSkeleton, RemotePrimitiveTypes {	
		
		public readonly static long serialVersionUID = 1341983932L;
		
		public virtual void VoidFunctionVoid() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void VoidFunctionVoidAsync(BAsyncResult<Object> asyncResult) {
			try {
				VoidFunctionVoid();
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginVoidFunctionVoid(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndVoidFunctionVoid(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetBool(bool v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetBoolAsync(bool v, BAsyncResult<Object> asyncResult) {
			try {
				SetBool(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetBool(bool v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetBool(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetByte(byte v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetByteAsync(byte v, BAsyncResult<Object> asyncResult) {
			try {
				SetByte(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetByte(byte v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetByte(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetChar(char v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetCharAsync(char v, BAsyncResult<Object> asyncResult) {
			try {
				SetChar(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetChar(char v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetChar(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetShort(short v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetShortAsync(short v, BAsyncResult<Object> asyncResult) {
			try {
				SetShort(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetShort(short v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetShort(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetInt(int v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetIntAsync(int v, BAsyncResult<Object> asyncResult) {
			try {
				SetInt(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt(int v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetInt(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetLong(long v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetLongAsync(long v, BAsyncResult<Object> asyncResult) {
			try {
				SetLong(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetLong(long v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetLong(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetFloat(float v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetFloatAsync(float v, BAsyncResult<Object> asyncResult) {
			try {
				SetFloat(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetFloat(float v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetFloat(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetDouble(double v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetDoubleAsync(double v, BAsyncResult<Object> asyncResult) {
			try {
				SetDouble(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetDouble(double v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetDouble(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetString(String v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetStringAsync(String v, BAsyncResult<Object> asyncResult) {
			try {
				SetString(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetString(String v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetString(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetPrimitiveTypesAsync(com.wilutions.byps.test.api.prim.PrimitiveTypes v, BAsyncResult<Object> asyncResult) {
			try {
				SetPrimitiveTypes(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPrimitiveTypes(com.wilutions.byps.test.api.prim.PrimitiveTypes v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetPrimitiveTypes(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetObject(Object v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetObjectAsync(Object v, BAsyncResult<Object> asyncResult) {
			try {
				SetObject(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetObject(Object v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetObject(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual bool GetBool() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetBoolAsync(BAsyncResult<bool> asyncResult) {
			try {
				bool ret = GetBool();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(false, e);
			}
		}
		public IAsyncResult BeginGetBool(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public bool EndGetBool(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual byte GetByte() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetByteAsync(BAsyncResult<byte> asyncResult) {
			try {
				byte ret = GetByte();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(((byte)0), e);
			}
		}
		public IAsyncResult BeginGetByte(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public byte EndGetByte(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual char GetChar() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetCharAsync(BAsyncResult<char> asyncResult) {
			try {
				char ret = GetChar();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(((char)0), e);
			}
		}
		public IAsyncResult BeginGetChar(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public char EndGetChar(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual short GetShort() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetShortAsync(BAsyncResult<short> asyncResult) {
			try {
				short ret = GetShort();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(((short)0), e);
			}
		}
		public IAsyncResult BeginGetShort(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public short EndGetShort(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual int GetInt() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetIntAsync(BAsyncResult<int> asyncResult) {
			try {
				int ret = GetInt();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0, e);
			}
		}
		public IAsyncResult BeginGetInt(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public int EndGetInt(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual long GetLong() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetLongAsync(BAsyncResult<long> asyncResult) {
			try {
				long ret = GetLong();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0L, e);
			}
		}
		public IAsyncResult BeginGetLong(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public long EndGetLong(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual float GetFloat() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetFloatAsync(BAsyncResult<float> asyncResult) {
			try {
				float ret = GetFloat();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0.0f, e);
			}
		}
		public IAsyncResult BeginGetFloat(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public float EndGetFloat(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual double GetDouble() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetDoubleAsync(BAsyncResult<double> asyncResult) {
			try {
				double ret = GetDouble();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0.0, e);
			}
		}
		public IAsyncResult BeginGetDouble(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public double EndGetDouble(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual String GetString() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetStringAsync(BAsyncResult<String> asyncResult) {
			try {
				String ret = GetString();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult("", e);
			}
		}
		public IAsyncResult BeginGetString(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public String EndGetString(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual com.wilutions.byps.test.api.prim.PrimitiveTypes GetPrimitiveTypes() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetPrimitiveTypesAsync(BAsyncResult<com.wilutions.byps.test.api.prim.PrimitiveTypes> asyncResult) {
			try {
				com.wilutions.byps.test.api.prim.PrimitiveTypes ret = GetPrimitiveTypes();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPrimitiveTypes(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.prim.PrimitiveTypes EndGetPrimitiveTypes(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual Object GetObject() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetObjectAsync(BAsyncResult<Object> asyncResult) {
			try {
				Object ret = GetObject();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetObject(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndGetObject(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SendAllTypesAsync(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o, BAsyncResult<Object> asyncResult) {
			try {
				SendAllTypes(b, c, s, i, l, f, d, str, pt, o);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSendAllTypes(bool b, char c, short s, int i, long l, float f, double d, String str, com.wilutions.byps.test.api.prim.PrimitiveTypes pt, Object o, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSendAllTypes(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual int Add(int a, int b) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void AddAsync(int a, int b, BAsyncResult<int> asyncResult) {
			try {
				int ret = Add(a, b);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0, e);
			}
		}
		public IAsyncResult BeginAdd(int a, int b, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public int EndAdd(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
