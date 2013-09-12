using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteSetTypes.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteSetTypes : BSkeleton, RemoteSetTypes {	
		
		public readonly static long serialVersionUID = 1156008353L;
		
		public virtual ISet<bool> GetBoolean1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetBoolean1Async(BAsyncResult<ISet<bool>> asyncResult) {
			try {
				ISet<bool> ret = GetBoolean1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<bool> EndGetBoolean1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetBoolean1(ISet<bool> boolean1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetBoolean1Async(ISet<bool> boolean1, BAsyncResult<Object> asyncResult) {
			try {
				SetBoolean1(boolean1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetBoolean1(ISet<bool> boolean1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetBoolean1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual HashSet<byte> GetByte1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetByte1Async(BAsyncResult<HashSet<byte>> asyncResult) {
			try {
				HashSet<byte> ret = GetByte1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetByte1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public HashSet<byte> EndGetByte1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetByte1(HashSet<byte> byte1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetByte1Async(HashSet<byte> byte1, BAsyncResult<Object> asyncResult) {
			try {
				SetByte1(byte1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetByte1(HashSet<byte> byte1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetByte1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual HashSet<char> GetChar1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetChar1Async(BAsyncResult<HashSet<char>> asyncResult) {
			try {
				HashSet<char> ret = GetChar1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetChar1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public HashSet<char> EndGetChar1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetChar1(HashSet<char> char1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetChar1Async(HashSet<char> char1, BAsyncResult<Object> asyncResult) {
			try {
				SetChar1(char1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetChar1(HashSet<char> char1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetChar1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<short> GetShort1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetShort1Async(BAsyncResult<ISet<short>> asyncResult) {
			try {
				ISet<short> ret = GetShort1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetShort1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<short> EndGetShort1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetShort1(ISet<short> short1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetShort1Async(ISet<short> short1, BAsyncResult<Object> asyncResult) {
			try {
				SetShort1(short1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetShort1(ISet<short> short1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetShort1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<int> GetInt1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetInt1Async(BAsyncResult<ISet<int>> asyncResult) {
			try {
				ISet<int> ret = GetInt1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<int> EndGetInt1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetInt1(ISet<int> int1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetInt1Async(ISet<int> int1, BAsyncResult<Object> asyncResult) {
			try {
				SetInt1(int1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt1(ISet<int> int1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetInt1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<long> GetLong1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetLong1Async(BAsyncResult<ISet<long>> asyncResult) {
			try {
				ISet<long> ret = GetLong1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetLong1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<long> EndGetLong1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetLong1(ISet<long> long1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetLong1Async(ISet<long> long1, BAsyncResult<Object> asyncResult) {
			try {
				SetLong1(long1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetLong1(ISet<long> long1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetLong1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<float> GetFloat1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetFloat1Async(BAsyncResult<ISet<float>> asyncResult) {
			try {
				ISet<float> ret = GetFloat1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetFloat1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<float> EndGetFloat1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetFloat1(ISet<float> float1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetFloat1Async(ISet<float> float1, BAsyncResult<Object> asyncResult) {
			try {
				SetFloat1(float1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetFloat1(ISet<float> float1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetFloat1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<double> GetDouble1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetDouble1Async(BAsyncResult<ISet<double>> asyncResult) {
			try {
				ISet<double> ret = GetDouble1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetDouble1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<double> EndGetDouble1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetDouble1(ISet<double> double1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetDouble1Async(ISet<double> double1, BAsyncResult<Object> asyncResult) {
			try {
				SetDouble1(double1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetDouble1(ISet<double> double1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetDouble1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<String> GetString1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetString1Async(BAsyncResult<ISet<String>> asyncResult) {
			try {
				ISet<String> ret = GetString1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetString1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<String> EndGetString1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetString1(ISet<String> string1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetString1Async(ISet<String> string1, BAsyncResult<Object> asyncResult) {
			try {
				SetString1(string1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetString1(ISet<String> string1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetString1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetPrimitiveTypes1Async(BAsyncResult<ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			try {
				ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> ret = GetPrimitiveTypes1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetPrimitiveTypes1Async(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			try {
				SetPrimitiveTypes1(primitiveTypes1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPrimitiveTypes1(ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetPrimitiveTypes1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<byte[]> GetByte2() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetByte2Async(BAsyncResult<ISet<byte[]>> asyncResult) {
			try {
				ISet<byte[]> ret = GetByte2();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetByte2(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<byte[]> EndGetByte2(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetByte2(ISet<byte[]> byte2) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetByte2Async(ISet<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			try {
				SetByte2(byte2);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetByte2(ISet<byte[]> byte2, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetByte2(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<int[]> GetInt2() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetInt2Async(BAsyncResult<ISet<int[]>> asyncResult) {
			try {
				ISet<int[]> ret = GetInt2();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt2(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<int[]> EndGetInt2(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetInt2(ISet<int[]> int2) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetInt2Async(ISet<int[]> int2, BAsyncResult<Object> asyncResult) {
			try {
				SetInt2(int2);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt2(ISet<int[]> int2, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetInt2(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<Object> GetObj1() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetObj1Async(BAsyncResult<ISet<Object>> asyncResult) {
			try {
				ISet<Object> ret = GetObj1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetObj1(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<Object> EndGetObj1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetObj1(ISet<Object> obj1) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetObj1Async(ISet<Object> obj1, BAsyncResult<Object> asyncResult) {
			try {
				SetObj1(obj1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetObj1(ISet<Object> obj1, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetObj1(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
