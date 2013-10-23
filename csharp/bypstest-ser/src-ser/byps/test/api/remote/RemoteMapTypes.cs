using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteMapTypes : BRemote {
	
		IDictionary<String,bool> GetBoolean1();
		void GetBoolean1(BAsyncResult<IDictionary<String,bool>> asyncResult) ;
		Task<IDictionary<String,bool>> GetBoolean1Async();
		
		void SetBoolean1(IDictionary<String,bool> boolean1);
		void SetBoolean1(IDictionary<String,bool> boolean1, BAsyncResult<Object> asyncResult) ;
		Task SetBoolean1Async(IDictionary<String,bool> boolean1);
		
		Dictionary<double,byte> GetByte1();
		void GetByte1(BAsyncResult<Dictionary<double,byte>> asyncResult) ;
		Task<Dictionary<double,byte>> GetByte1Async();
		
		void SetByte1(Dictionary<double,byte> byte1);
		void SetByte1(Dictionary<double,byte> byte1, BAsyncResult<Object> asyncResult) ;
		Task SetByte1Async(Dictionary<double,byte> byte1);
		
		Dictionary<float,char> GetChar1();
		void GetChar1(BAsyncResult<Dictionary<float,char>> asyncResult) ;
		Task<Dictionary<float,char>> GetChar1Async();
		
		void SetChar1(Dictionary<float,char> char1);
		void SetChar1(Dictionary<float,char> char1, BAsyncResult<Object> asyncResult) ;
		Task SetChar1Async(Dictionary<float,char> char1);
		
		IDictionary<long,short> GetShort1();
		void GetShort1(BAsyncResult<IDictionary<long,short>> asyncResult) ;
		Task<IDictionary<long,short>> GetShort1Async();
		
		void SetShort1(IDictionary<long,short> short1);
		void SetShort1(IDictionary<long,short> short1, BAsyncResult<Object> asyncResult) ;
		Task SetShort1Async(IDictionary<long,short> short1);
		
		IDictionary<int,int> GetInt1();
		void GetInt1(BAsyncResult<IDictionary<int,int>> asyncResult) ;
		Task<IDictionary<int,int>> GetInt1Async();
		
		void SetInt1(IDictionary<int,int> int1);
		void SetInt1(IDictionary<int,int> int1, BAsyncResult<Object> asyncResult) ;
		Task SetInt1Async(IDictionary<int,int> int1);
		
		IDictionary<short,long> GetLong1();
		void GetLong1(BAsyncResult<IDictionary<short,long>> asyncResult) ;
		Task<IDictionary<short,long>> GetLong1Async();
		
		void SetLong1(IDictionary<short,long> long1);
		void SetLong1(IDictionary<short,long> long1, BAsyncResult<Object> asyncResult) ;
		Task SetLong1Async(IDictionary<short,long> long1);
		
		IDictionary<char,float> GetFloat1();
		void GetFloat1(BAsyncResult<IDictionary<char,float>> asyncResult) ;
		Task<IDictionary<char,float>> GetFloat1Async();
		
		void SetFloat1(IDictionary<char,float> float1);
		void SetFloat1(IDictionary<char,float> float1, BAsyncResult<Object> asyncResult) ;
		Task SetFloat1Async(IDictionary<char,float> float1);
		
		IDictionary<byte,double> GetDouble1();
		void GetDouble1(BAsyncResult<IDictionary<byte,double>> asyncResult) ;
		Task<IDictionary<byte,double>> GetDouble1Async();
		
		void SetDouble1(IDictionary<byte,double> double1);
		void SetDouble1(IDictionary<byte,double> double1, BAsyncResult<Object> asyncResult) ;
		Task SetDouble1Async(IDictionary<byte,double> double1);
		
		IDictionary<String,String> GetString1();
		void GetString1(BAsyncResult<IDictionary<String,String>> asyncResult) ;
		Task<IDictionary<String,String>> GetString1Async();
		
		void SetString1(IDictionary<String,String> string1);
		void SetString1(IDictionary<String,String> string1, BAsyncResult<Object> asyncResult) ;
		Task SetString1Async(IDictionary<String,String> string1);
		
		IDictionary<int,byps.test.api.prim.PrimitiveTypes> GetPrimitiveTypes1();
		void GetPrimitiveTypes1(BAsyncResult<IDictionary<int,byps.test.api.prim.PrimitiveTypes>> asyncResult) ;
		Task<IDictionary<int,byps.test.api.prim.PrimitiveTypes>> GetPrimitiveTypes1Async();
		
		void SetPrimitiveTypes1(IDictionary<int,byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		void SetPrimitiveTypes1(IDictionary<int,byps.test.api.prim.PrimitiveTypes> primitiveTypes1, BAsyncResult<Object> asyncResult) ;
		Task SetPrimitiveTypes1Async(IDictionary<int,byps.test.api.prim.PrimitiveTypes> primitiveTypes1);
		
		IDictionary<int,byte[]> GetByte2();
		void GetByte2(BAsyncResult<IDictionary<int,byte[]>> asyncResult) ;
		Task<IDictionary<int,byte[]>> GetByte2Async();
		
		void SetByte2(IDictionary<int,byte[]> byte2);
		void SetByte2(IDictionary<int,byte[]> byte2, BAsyncResult<Object> asyncResult) ;
		Task SetByte2Async(IDictionary<int,byte[]> byte2);
		
		IDictionary<int,int[]> GetInt2();
		void GetInt2(BAsyncResult<IDictionary<int,int[]>> asyncResult) ;
		Task<IDictionary<int,int[]>> GetInt2Async();
		
		void SetInt2(IDictionary<int,int[]> int2);
		void SetInt2(IDictionary<int,int[]> int2, BAsyncResult<Object> asyncResult) ;
		Task SetInt2Async(IDictionary<int,int[]> int2);
		
		IDictionary<String,Object> GetObj1();
		void GetObj1(BAsyncResult<IDictionary<String,Object>> asyncResult) ;
		Task<IDictionary<String,Object>> GetObj1Async();
		
		void SetObj1(IDictionary<String,Object> obj1);
		void SetObj1(IDictionary<String,Object> obj1, BAsyncResult<Object> asyncResult) ;
		Task SetObj1Async(IDictionary<String,Object> obj1);
		
		
	}
}  // end namespace
