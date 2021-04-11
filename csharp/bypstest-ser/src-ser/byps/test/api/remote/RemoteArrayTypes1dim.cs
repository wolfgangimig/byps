using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	/// <summary>
	/// Interface with functions using 1-dimensional arrays.
	/// </summary>
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteArrayTypes1dim : BRemote {
	
		/// <summary>
		/// Checks in an uploaded document.
		/// </summary>
		/// <remarks>
		/// <p>
		/// See <code>checkinDocBegin</code>, if you want to checkin new document or attachment version(s).
		/// </p>
		/// <p>
		/// Changing the document or attachment work version, version number, comment, flags or status:
		/// <code><br/><br/>
		/// Document doc = new Document();<br/>
		/// doc.objId = an object ID or GUID<br/>
		/// doc.docs = new DocVersion[] {new DocVersion()};<br/>
		/// doc.docs[0].id = a document ID;<br/>
		/// doc.docs[0].workVersion = true;<br/>
		/// doc.docs[0].version = "2.0";<br/>
		/// doc.docs[0].comment = "new comment";<br/>
		/// doc.docs[0].milestone = true;<br/>
		/// doc.docs[0].deleted = false;<br/>
		/// ix.checkinDocEnd(ci, null, null, doc, LOCK.NO);<br/>
		/// </code>
		/// </p>
		/// <p>
		/// If the supplied sord has <code>sord.type==LBT_DOCUMENT</code>, sord.type will be detected from
		/// the file extension of the given work version.
		/// </p>
		/// <p>
		/// If the document is only to be unlocked, see <code>checkinSord</code>.
		/// </p>
		/// </remarks>
		void SetBool(bool[] v);
		void SetBool(bool[] v, BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Checks in an uploaded document.
		/// </summary>
		/// <remarks>
		/// <p>
		/// See <code>checkinDocBegin</code>, if you want to checkin new document or attachment version(s).
		/// </p>
		/// <p>
		/// Changing the document or attachment work version, version number, comment, flags or status:
		/// <code><br/><br/>
		/// Document doc = new Document();<br/>
		/// doc.objId = an object ID or GUID<br/>
		/// doc.docs = new DocVersion[] {new DocVersion()};<br/>
		/// doc.docs[0].id = a document ID;<br/>
		/// doc.docs[0].workVersion = true;<br/>
		/// doc.docs[0].version = "2.0";<br/>
		/// doc.docs[0].comment = "new comment";<br/>
		/// doc.docs[0].milestone = true;<br/>
		/// doc.docs[0].deleted = false;<br/>
		/// ix.checkinDocEnd(ci, null, null, doc, LOCK.NO);<br/>
		/// </code>
		/// </p>
		/// <p>
		/// If the supplied sord has <code>sord.type==LBT_DOCUMENT</code>, sord.type will be detected from
		/// the file extension of the given work version.
		/// </p>
		/// <p>
		/// If the document is only to be unlocked, see <code>checkinSord</code>.
		/// </p>
		/// </remarks>
		Task SetBoolAsync(bool[] v);
		
		void SetByte(byte[] v);
		void SetByte(byte[] v, BAsyncResult<Object> asyncResult) ;
		Task SetByteAsync(byte[] v);
		
		void SetChar(char[] v);
		void SetChar(char[] v, BAsyncResult<Object> asyncResult) ;
		Task SetCharAsync(char[] v);
		
		void SetShort(short[] v);
		void SetShort(short[] v, BAsyncResult<Object> asyncResult) ;
		Task SetShortAsync(short[] v);
		
		void SetInt(int[] v);
		void SetInt(int[] v, BAsyncResult<Object> asyncResult) ;
		Task SetIntAsync(int[] v);
		
		void SetLong(long[] v);
		void SetLong(long[] v, BAsyncResult<Object> asyncResult) ;
		Task SetLongAsync(long[] v);
		
		void SetFloat(float[] v);
		void SetFloat(float[] v, BAsyncResult<Object> asyncResult) ;
		Task SetFloatAsync(float[] v);
		
		void SetDouble(double[] v);
		void SetDouble(double[] v, BAsyncResult<Object> asyncResult) ;
		Task SetDoubleAsync(double[] v);
		
		void SetString(String[] v);
		void SetString(String[] v, BAsyncResult<Object> asyncResult) ;
		Task SetStringAsync(String[] v);
		
		void SetPrimitiveTypes(byps.test.api.prim.PrimitiveTypes[] v);
		void SetPrimitiveTypes(byps.test.api.prim.PrimitiveTypes[] v, BAsyncResult<Object> asyncResult) ;
		Task SetPrimitiveTypesAsync(byps.test.api.prim.PrimitiveTypes[] v);
		
		void SetObject(Object[] v);
		void SetObject(Object[] v, BAsyncResult<Object> asyncResult) ;
		Task SetObjectAsync(Object[] v);
		
		void SetDate(DateTime[] v);
		void SetDate(DateTime[] v, BAsyncResult<Object> asyncResult) ;
		Task SetDateAsync(DateTime[] v);
		
		bool[] GetBool();
		void GetBool(BAsyncResult<bool[]> asyncResult) ;
		Task<bool[]> GetBoolAsync();
		
		byte[] GetByte();
		void GetByte(BAsyncResult<byte[]> asyncResult) ;
		Task<byte[]> GetByteAsync();
		
		char[] GetChar();
		void GetChar(BAsyncResult<char[]> asyncResult) ;
		Task<char[]> GetCharAsync();
		
		short[] GetShort();
		void GetShort(BAsyncResult<short[]> asyncResult) ;
		Task<short[]> GetShortAsync();
		
		int[] GetInt();
		void GetInt(BAsyncResult<int[]> asyncResult) ;
		Task<int[]> GetIntAsync();
		
		long[] GetLong();
		void GetLong(BAsyncResult<long[]> asyncResult) ;
		Task<long[]> GetLongAsync();
		
		float[] GetFloat();
		void GetFloat(BAsyncResult<float[]> asyncResult) ;
		Task<float[]> GetFloatAsync();
		
		double[] GetDouble();
		void GetDouble(BAsyncResult<double[]> asyncResult) ;
		Task<double[]> GetDoubleAsync();
		
		String[] GetString();
		void GetString(BAsyncResult<String[]> asyncResult) ;
		Task<String[]> GetStringAsync();
		
		byps.test.api.prim.PrimitiveTypes[] GetPrimitiveTypes();
		void GetPrimitiveTypes(BAsyncResult<byps.test.api.prim.PrimitiveTypes[]> asyncResult) ;
		Task<byps.test.api.prim.PrimitiveTypes[]> GetPrimitiveTypesAsync();
		
		Object[] GetObject();
		void GetObject(BAsyncResult<Object[]> asyncResult) ;
		Task<Object[]> GetObjectAsync();
		
		DateTime[] GetDate();
		void GetDate(BAsyncResult<DateTime[]> asyncResult) ;
		Task<DateTime[]> GetDateAsync();
		
		
	}
}  // end namespace
