using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface RemoteListTypes : BRemote {
	
		IList<bool> GetBoolean1();
		void GetBoolean1(BAsyncResult<IList<bool>> asyncResult) ;
		Task<IList<bool>> GetBoolean1Async();
		
		void SetBoolean1(IList<bool> boolean1);
		void SetBoolean1(IList<bool> boolean1, BAsyncResult<Object> asyncResult) ;
		Task SetBoolean1Async(IList<bool> boolean1);
		
		IList<byte> GetByte1();
		void GetByte1(BAsyncResult<IList<byte>> asyncResult) ;
		Task<IList<byte>> GetByte1Async();
		
		void SetByte1(IList<byte> byte1);
		void SetByte1(IList<byte> byte1, BAsyncResult<Object> asyncResult) ;
		Task SetByte1Async(IList<byte> byte1);
		
		IList<char> GetChar1();
		void GetChar1(BAsyncResult<IList<char>> asyncResult) ;
		Task<IList<char>> GetChar1Async();
		
		void SetChar1(IList<char> char1);
		void SetChar1(IList<char> char1, BAsyncResult<Object> asyncResult) ;
		Task SetChar1Async(IList<char> char1);
		
		IList<short> GetShort1();
		void GetShort1(BAsyncResult<IList<short>> asyncResult) ;
		Task<IList<short>> GetShort1Async();
		
		void SetShort1(IList<short> short1);
		void SetShort1(IList<short> short1, BAsyncResult<Object> asyncResult) ;
		Task SetShort1Async(IList<short> short1);
		
		IList<int> GetInt1();
		void GetInt1(BAsyncResult<IList<int>> asyncResult) ;
		Task<IList<int>> GetInt1Async();
		
		void SetInt1(IList<int> int1);
		void SetInt1(IList<int> int1, BAsyncResult<Object> asyncResult) ;
		Task SetInt1Async(IList<int> int1);
		
		IList<long> GetLong1();
		void GetLong1(BAsyncResult<IList<long>> asyncResult) ;
		Task<IList<long>> GetLong1Async();
		
		void SetLong1(IList<long> long1);
		void SetLong1(IList<long> long1, BAsyncResult<Object> asyncResult) ;
		Task SetLong1Async(IList<long> long1);
		
		IList<float> GetFloat1();
		void GetFloat1(BAsyncResult<IList<float>> asyncResult) ;
		Task<IList<float>> GetFloat1Async();
		
		void SetFloat1(IList<float> float1);
		void SetFloat1(IList<float> float1, BAsyncResult<Object> asyncResult) ;
		Task SetFloat1Async(IList<float> float1);
		
		IList<double> GetDouble1();
		void GetDouble1(BAsyncResult<IList<double>> asyncResult) ;
		Task<IList<double>> GetDouble1Async();
		
		void SetDouble1(IList<double> double1);
		void SetDouble1(IList<double> double1, BAsyncResult<Object> asyncResult) ;
		Task SetDouble1Async(IList<double> double1);
		
		IList<String> GetString1();
		void GetString1(BAsyncResult<IList<String>> asyncResult) ;
		Task<IList<String>> GetString1Async();
		
		void SetString1(IList<String> string1);
		void SetString1(IList<String> string1, BAsyncResult<Object> asyncResult) ;
		Task SetString1Async(IList<String> string1);
		
		IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1();
		void GetPrimitiveTypes1(BAsyncResult<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> asyncResult) ;
		Task<IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Async();
		
		void SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		void SetPrimitiveTypes1(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) ;
		Task SetPrimitiveTypes1Async(IList<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		
		IList<byte[]> GetByte2();
		void GetByte2(BAsyncResult<IList<byte[]>> asyncResult) ;
		Task<IList<byte[]>> GetByte2Async();
		
		void SetByte2(IList<byte[]> byte2);
		void SetByte2(IList<byte[]> byte2, BAsyncResult<Object> asyncResult) ;
		Task SetByte2Async(IList<byte[]> byte2);
		
		IList<int[]> GetInt2();
		void GetInt2(BAsyncResult<IList<int[]>> asyncResult) ;
		Task<IList<int[]>> GetInt2Async();
		
		void SetInt2(IList<int[]> int2);
		void SetInt2(IList<int[]> int2, BAsyncResult<Object> asyncResult) ;
		Task SetInt2Async(IList<int[]> int2);
		
		IList<Object> GetObj1();
		void GetObj1(BAsyncResult<IList<Object>> asyncResult) ;
		Task<IList<Object>> GetObj1Async();
		
		void SetObj1(IList<Object> obj1);
		void SetObj1(IList<Object> obj1, BAsyncResult<Object> asyncResult) ;
		Task SetObj1Async(IList<Object> obj1);
		
		IList<IList<int>> GetInt3();
		void GetInt3(BAsyncResult<IList<IList<int>>> asyncResult) ;
		Task<IList<IList<int>>> GetInt3Async();
		
		void SetInt3(IList<IList<int>> int3);
		void SetInt3(IList<IList<int>> int3, BAsyncResult<Object> asyncResult) ;
		Task SetInt3Async(IList<IList<int>> int3);
		
		IList<IDictionary<int,IList<HashSet<int>>>> GetInt4();
		void GetInt4(BAsyncResult<IList<IDictionary<int,IList<HashSet<int>>>>> asyncResult) ;
		Task<IList<IDictionary<int,IList<HashSet<int>>>>> GetInt4Async();
		
		void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4);
		void SetInt4(IList<IDictionary<int,IList<HashSet<int>>>> int4, BAsyncResult<Object> asyncResult) ;
		Task SetInt4Async(IList<IDictionary<int,IList<HashSet<int>>>> int4);
		
		
	}
}  // end namespace
