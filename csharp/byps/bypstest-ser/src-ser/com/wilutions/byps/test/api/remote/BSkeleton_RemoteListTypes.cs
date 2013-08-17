using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteListTypes.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteListTypes : BSkeleton, RemoteListTypes {	
		
		public readonly static long serialVersionUID = 380156079L;
		
		public virtual IList<bool> GetBoolean1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetBoolean1(BAsyncResult<IList<bool>> asyncResult) {
			try {
				IList<bool> ret = GetBoolean1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<bool> EndGetBoolean1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetBoolean1(IList<bool> boolean1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetBoolean1(IList<bool> boolean1, BAsyncResult<Object> asyncResult) {
			try {
				SetBoolean1(boolean1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetBoolean1(IList<bool> boolean1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetBoolean1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<byte> GetByte1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetByte1(BAsyncResult<IList<byte>> asyncResult) {
			try {
				IList<byte> ret = GetByte1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetByte1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<byte> EndGetByte1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetByte1(IList<byte> byte1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetByte1(IList<byte> byte1, BAsyncResult<Object> asyncResult) {
			try {
				SetByte1(byte1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetByte1(IList<byte> byte1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetByte1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<char> GetChar1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetChar1(BAsyncResult<IList<char>> asyncResult) {
			try {
				IList<char> ret = GetChar1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetChar1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<char> EndGetChar1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetChar1(IList<char> char1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetChar1(IList<char> char1, BAsyncResult<Object> asyncResult) {
			try {
				SetChar1(char1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetChar1(IList<char> char1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetChar1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<short> GetShort1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetShort1(BAsyncResult<IList<short>> asyncResult) {
			try {
				IList<short> ret = GetShort1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetShort1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<short> EndGetShort1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetShort1(IList<short> short1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetShort1(IList<short> short1, BAsyncResult<Object> asyncResult) {
			try {
				SetShort1(short1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetShort1(IList<short> short1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetShort1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<int> GetInt1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetInt1(BAsyncResult<IList<int>> asyncResult) {
			try {
				IList<int> ret = GetInt1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<int> EndGetInt1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetInt1(IList<int> int1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetInt1(IList<int> int1, BAsyncResult<Object> asyncResult) {
			try {
				SetInt1(int1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt1(IList<int> int1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetInt1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<long> GetLong1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetLong1(BAsyncResult<IList<long>> asyncResult) {
			try {
				IList<long> ret = GetLong1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetLong1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<long> EndGetLong1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetLong1(IList<long> long1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetLong1(IList<long> long1, BAsyncResult<Object> asyncResult) {
			try {
				SetLong1(long1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetLong1(IList<long> long1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetLong1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<float> GetFloat1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetFloat1(BAsyncResult<IList<float>> asyncResult) {
			try {
				IList<float> ret = GetFloat1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetFloat1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<float> EndGetFloat1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetFloat1(IList<float> float1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetFloat1(IList<float> float1, BAsyncResult<Object> asyncResult) {
			try {
				SetFloat1(float1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetFloat1(IList<float> float1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetFloat1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<double> GetDouble1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetDouble1(BAsyncResult<IList<double>> asyncResult) {
			try {
				IList<double> ret = GetDouble1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetDouble1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<double> EndGetDouble1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetDouble1(IList<double> double1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetDouble1(IList<double> double1, BAsyncResult<Object> asyncResult) {
			try {
				SetDouble1(double1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetDouble1(IList<double> double1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetDouble1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<String> GetString1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetString1(BAsyncResult<IList<String>> asyncResult) {
			try {
				IList<String> ret = GetString1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetString1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<String> EndGetString1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetString1(IList<String> string1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetString1(IList<String> string1, BAsyncResult<Object> asyncResult) {
			try {
				SetString1(string1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetString1(IList<String> string1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetString1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPrimitiveTypes1(BAsyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			try {
				IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> ret = GetPrimitiveTypes1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			try {
				SetPrimitiveTypes1(primitiveTypes1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetPrimitiveTypes1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<byte[]> GetByte2() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetByte2(BAsyncResult<IList<byte[]>> asyncResult) {
			try {
				IList<byte[]> ret = GetByte2();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetByte2(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<byte[]> EndGetByte2(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetByte2(IList<byte[]> byte2) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetByte2(IList<byte[]> byte2, BAsyncResult<Object> asyncResult) {
			try {
				SetByte2(byte2);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetByte2(IList<byte[]> byte2, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetByte2(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<int[]> GetInt2() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetInt2(BAsyncResult<IList<int[]>> asyncResult) {
			try {
				IList<int[]> ret = GetInt2();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt2(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<int[]> EndGetInt2(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetInt2(IList<int[]> int2) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetInt2(IList<int[]> int2, BAsyncResult<Object> asyncResult) {
			try {
				SetInt2(int2);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt2(IList<int[]> int2, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetInt2(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<Object> GetObj1() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetObj1(BAsyncResult<IList<Object>> asyncResult) {
			try {
				IList<Object> ret = GetObj1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetObj1(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<Object> EndGetObj1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetObj1(IList<Object> obj1) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetObj1(IList<Object> obj1, BAsyncResult<Object> asyncResult) {
			try {
				SetObj1(obj1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetObj1(IList<Object> obj1, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetObj1(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<IList<int>> GetInt3() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetInt3(BAsyncResult<IList<IList<int>>> asyncResult) {
			try {
				IList<IList<int>> ret = GetInt3();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt3(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<IList<int>> EndGetInt3(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetInt3(IList<IList<int>> int3) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetInt3(IList<IList<int>> int3, BAsyncResult<Object> asyncResult) {
			try {
				SetInt3(int3);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt3(IList<IList<int>> int3, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetInt3(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<IDictionary<int,IList<HashSet<int>>>> GetInt4() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetInt4(BAsyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult) {
			try {
				IList<IDictionary<int,IList<HashSet<int>>>> ret = GetInt4();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt4(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<IDictionary<int,IList<HashSet<int>>>> EndGetInt4(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, BAsyncResult<Object> asyncResult) {
			try {
				SetInt4(int4);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetInt4(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		
	}
}
