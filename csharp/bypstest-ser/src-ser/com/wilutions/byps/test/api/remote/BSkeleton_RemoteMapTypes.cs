using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteMapTypes.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteMapTypes : BSkeleton, RemoteMapTypes {	
		
		public readonly static long serialVersionUID = 80483097L;
		
		public virtual IDictionary<String,bool> GetBoolean1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetBoolean1(BAsyncResult<IDictionary<String,bool>> asyncResult) {
			try {
				IDictionary<String,bool> ret = GetBoolean1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetBoolean1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<String,bool> EndGetBoolean1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetBoolean1(IDictionary<String,bool> boolean1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetBoolean1(IDictionary<String,bool> boolean1, BAsyncResult<Object> asyncResult) {
			try {
				SetBoolean1(boolean1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetBoolean1(IDictionary<String,bool> boolean1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetBoolean1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual Dictionary<double,byte> GetByte1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetByte1(BAsyncResult<Dictionary<double,byte>> asyncResult) {
			try {
				Dictionary<double,byte> ret = GetByte1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetByte1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Dictionary<double,byte> EndGetByte1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetByte1(Dictionary<double,byte> byte1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetByte1(Dictionary<double,byte> byte1, BAsyncResult<Object> asyncResult) {
			try {
				SetByte1(byte1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetByte1(Dictionary<double,byte> byte1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetByte1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual Dictionary<float,char> GetChar1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetChar1(BAsyncResult<Dictionary<float,char>> asyncResult) {
			try {
				Dictionary<float,char> ret = GetChar1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetChar1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Dictionary<float,char> EndGetChar1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetChar1(Dictionary<float,char> char1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetChar1(Dictionary<float,char> char1, BAsyncResult<Object> asyncResult) {
			try {
				SetChar1(char1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetChar1(Dictionary<float,char> char1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetChar1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<long,short> GetShort1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetShort1(BAsyncResult<IDictionary<long,short>> asyncResult) {
			try {
				IDictionary<long,short> ret = GetShort1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetShort1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<long,short> EndGetShort1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetShort1(IDictionary<long,short> short1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetShort1(IDictionary<long,short> short1, BAsyncResult<Object> asyncResult) {
			try {
				SetShort1(short1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetShort1(IDictionary<long,short> short1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetShort1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<int,int> GetInt1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetInt1(BAsyncResult<IDictionary<int,int>> asyncResult) {
			try {
				IDictionary<int,int> ret = GetInt1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<int,int> EndGetInt1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetInt1(IDictionary<int,int> int1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetInt1(IDictionary<int,int> int1, BAsyncResult<Object> asyncResult) {
			try {
				SetInt1(int1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt1(IDictionary<int,int> int1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetInt1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<short,long> GetLong1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetLong1(BAsyncResult<IDictionary<short,long>> asyncResult) {
			try {
				IDictionary<short,long> ret = GetLong1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetLong1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<short,long> EndGetLong1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetLong1(IDictionary<short,long> long1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetLong1(IDictionary<short,long> long1, BAsyncResult<Object> asyncResult) {
			try {
				SetLong1(long1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetLong1(IDictionary<short,long> long1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetLong1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<char,float> GetFloat1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetFloat1(BAsyncResult<IDictionary<char,float>> asyncResult) {
			try {
				IDictionary<char,float> ret = GetFloat1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetFloat1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<char,float> EndGetFloat1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetFloat1(IDictionary<char,float> float1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetFloat1(IDictionary<char,float> float1, BAsyncResult<Object> asyncResult) {
			try {
				SetFloat1(float1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetFloat1(IDictionary<char,float> float1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetFloat1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<byte,double> GetDouble1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetDouble1(BAsyncResult<IDictionary<byte,double>> asyncResult) {
			try {
				IDictionary<byte,double> ret = GetDouble1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetDouble1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<byte,double> EndGetDouble1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetDouble1(IDictionary<byte,double> double1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetDouble1(IDictionary<byte,double> double1, BAsyncResult<Object> asyncResult) {
			try {
				SetDouble1(double1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetDouble1(IDictionary<byte,double> double1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetDouble1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<String,String> GetString1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetString1(BAsyncResult<IDictionary<String,String>> asyncResult) {
			try {
				IDictionary<String,String> ret = GetString1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetString1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<String,String> EndGetString1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetString1(IDictionary<String,String> string1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetString1(IDictionary<String,String> string1, BAsyncResult<Object> asyncResult) {
			try {
				SetString1(string1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetString1(IDictionary<String,String> string1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetString1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPrimitiveTypes1(BAsyncResult<IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) {
			try {
				IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> ret = GetPrimitiveTypes1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPrimitiveTypes1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> EndGetPrimitiveTypes1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) {
			try {
				SetPrimitiveTypes1(primitiveTypes1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPrimitiveTypes1(IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetPrimitiveTypes1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<int,byte[]> GetByte2() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetByte2(BAsyncResult<IDictionary<int,byte[]>> asyncResult) {
			try {
				IDictionary<int,byte[]> ret = GetByte2();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetByte2(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<int,byte[]> EndGetByte2(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetByte2(IDictionary<int,byte[]> byte2) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetByte2(IDictionary<int,byte[]> byte2, BAsyncResult<Object> asyncResult) {
			try {
				SetByte2(byte2);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetByte2(IDictionary<int,byte[]> byte2, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetByte2(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<int,int[]> GetInt2() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetInt2(BAsyncResult<IDictionary<int,int[]>> asyncResult) {
			try {
				IDictionary<int,int[]> ret = GetInt2();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetInt2(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<int,int[]> EndGetInt2(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetInt2(IDictionary<int,int[]> int2) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetInt2(IDictionary<int,int[]> int2, BAsyncResult<Object> asyncResult) {
			try {
				SetInt2(int2);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetInt2(IDictionary<int,int[]> int2, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetInt2(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual IDictionary<String,Object> GetObj1() {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetObj1(BAsyncResult<IDictionary<String,Object>> asyncResult) {
			try {
				IDictionary<String,Object> ret = GetObj1();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetObj1(AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public IDictionary<String,Object> EndGetObj1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void SetObj1(IDictionary<String,Object> obj1) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetObj1(IDictionary<String,Object> obj1, BAsyncResult<Object> asyncResult) {
			try {
				SetObj1(obj1);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetObj1(IDictionary<String,Object> obj1, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndSetObj1(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		
	}
}
