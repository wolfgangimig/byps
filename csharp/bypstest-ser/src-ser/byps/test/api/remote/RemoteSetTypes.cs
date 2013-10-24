using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteSetTypes : BRemote {
	
		ISet<bool> GetBoolean1();
		void GetBoolean1(BAsyncResult<ISet<bool>> asyncResult) ;
		Task<ISet<bool>> GetBoolean1Async();
		
		void SetBoolean1(ISet<bool> boolean1);
		void SetBoolean1(ISet<bool> boolean1, BAsyncResult<Object> asyncResult) ;
		Task SetBoolean1Async(ISet<bool> boolean1);
		
		HashSet<byte> GetByte1();
		void GetByte1(BAsyncResult<HashSet<byte>> asyncResult) ;
		Task<HashSet<byte>> GetByte1Async();
		
		void SetByte1(HashSet<byte> byte1);
		void SetByte1(HashSet<byte> byte1, BAsyncResult<Object> asyncResult) ;
		Task SetByte1Async(HashSet<byte> byte1);
		
		HashSet<char> GetChar1();
		void GetChar1(BAsyncResult<HashSet<char>> asyncResult) ;
		Task<HashSet<char>> GetChar1Async();
		
		void SetChar1(HashSet<char> char1);
		void SetChar1(HashSet<char> char1, BAsyncResult<Object> asyncResult) ;
		Task SetChar1Async(HashSet<char> char1);
		
		ISet<short> GetShort1();
		void GetShort1(BAsyncResult<ISet<short>> asyncResult) ;
		Task<ISet<short>> GetShort1Async();
		
		void SetShort1(ISet<short> short1);
		void SetShort1(ISet<short> short1, BAsyncResult<Object> asyncResult) ;
		Task SetShort1Async(ISet<short> short1);
		
		ISet<int> GetInt1();
		void GetInt1(BAsyncResult<ISet<int>> asyncResult) ;
		Task<ISet<int>> GetInt1Async();
		
		void SetInt1(ISet<int> int1);
		void SetInt1(ISet<int> int1, BAsyncResult<Object> asyncResult) ;
		Task SetInt1Async(ISet<int> int1);
		
		ISet<long> GetLong1();
		void GetLong1(BAsyncResult<ISet<long>> asyncResult) ;
		Task<ISet<long>> GetLong1Async();
		
		void SetLong1(ISet<long> long1);
		void SetLong1(ISet<long> long1, BAsyncResult<Object> asyncResult) ;
		Task SetLong1Async(ISet<long> long1);
		
		ISet<float> GetFloat1();
		void GetFloat1(BAsyncResult<ISet<float>> asyncResult) ;
		Task<ISet<float>> GetFloat1Async();
		
		void SetFloat1(ISet<float> float1);
		void SetFloat1(ISet<float> float1, BAsyncResult<Object> asyncResult) ;
		Task SetFloat1Async(ISet<float> float1);
		
		ISet<double> GetDouble1();
		void GetDouble1(BAsyncResult<ISet<double>> asyncResult) ;
		Task<ISet<double>> GetDouble1Async();
		
		void SetDouble1(ISet<double> double1);
		void SetDouble1(ISet<double> double1, BAsyncResult<Object> asyncResult) ;
		Task SetDouble1Async(ISet<double> double1);
		
		ISet<String> GetString1();
		void GetString1(BAsyncResult<ISet<String>> asyncResult) ;
		Task<ISet<String>> GetString1Async();
		
		void SetString1(ISet<String> string1);
		void SetString1(ISet<String> string1, BAsyncResult<Object> asyncResult) ;
		Task SetString1Async(ISet<String> string1);
		
		ISet<byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1();
		void GetPrimitiveTypes1(BAsyncResult<ISet<byps.test.api.prim.PrimitiveTypes>> asyncResult) ;
		Task<ISet<byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Async();
		
		void SetPrimitiveTypes1(ISet<byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		void SetPrimitiveTypes1(ISet<byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) ;
		Task SetPrimitiveTypes1Async(ISet<byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		
		ISet<byte[]> GetByte2();
		void GetByte2(BAsyncResult<ISet<byte[]>> asyncResult) ;
		Task<ISet<byte[]>> GetByte2Async();
		
		void SetByte2(ISet<byte[]> byte2);
		void SetByte2(ISet<byte[]> byte2, BAsyncResult<Object> asyncResult) ;
		Task SetByte2Async(ISet<byte[]> byte2);
		
		ISet<int[]> GetInt2();
		void GetInt2(BAsyncResult<ISet<int[]>> asyncResult) ;
		Task<ISet<int[]>> GetInt2Async();
		
		void SetInt2(ISet<int[]> int2);
		void SetInt2(ISet<int[]> int2, BAsyncResult<Object> asyncResult) ;
		Task SetInt2Async(ISet<int[]> int2);
		
		ISet<Object> GetObj1();
		void GetObj1(BAsyncResult<ISet<Object>> asyncResult) ;
		Task<ISet<Object>> GetObj1Async();
		
		void SetObj1(ISet<Object> obj1);
		void SetObj1(ISet<Object> obj1, BAsyncResult<Object> asyncResult) ;
		Task SetObj1Async(ISet<Object> obj1);
		
		
	}
}  // end namespace
