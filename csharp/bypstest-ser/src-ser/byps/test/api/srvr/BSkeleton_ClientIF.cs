using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.srvr
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface ClientIF.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_ClientIF : BSkeleton, ClientIF {	
		
		public readonly static long serialVersionUID = 2049072174L;
		
		public virtual int IncrementInt(int a) {
			throw new NotImplementedException();
		}
		public virtual async void IncrementInt(int a, BAsyncResult<int> asyncResult) {
			int __byps__ret = default(int);
			Exception __byps__ex = null;
			bool __byps__callAsync = false;
			try {
				__byps__ret = IncrementInt(a);
			}
			catch (NotImplementedException) { __byps__callAsync = true; }
			catch (Exception e) { __byps__ex = e; }
			if (__byps__callAsync) try {
				__byps__ret = await IncrementIntAsync(a);
			}
			catch (NotImplementedException) { __byps__ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { __byps__ex = e; }
			asyncResult(__byps__ret, __byps__ex);
		}
		public virtual Task<int> IncrementIntAsync(int a){
			return BTaskConstants<int>.NotImplemented;
		}
		
		public virtual IList<System.IO.Stream> GetStreams(int ctrl) {
			throw new NotImplementedException();
		}
		public virtual async void GetStreams(int ctrl, BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			IList<System.IO.Stream> __byps__ret = default(IList<System.IO.Stream>);
			Exception __byps__ex = null;
			bool __byps__callAsync = false;
			try {
				__byps__ret = GetStreams(ctrl);
			}
			catch (NotImplementedException) { __byps__callAsync = true; }
			catch (Exception e) { __byps__ex = e; }
			if (__byps__callAsync) try {
				__byps__ret = await GetStreamsAsync(ctrl);
			}
			catch (NotImplementedException) { __byps__ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { __byps__ex = e; }
			asyncResult(__byps__ret, __byps__ex);
		}
		public virtual Task<IList<System.IO.Stream>> GetStreamsAsync(int ctrl){
			return BTaskConstants<IList<System.IO.Stream>>.NotImplemented;
		}
		
		public virtual void PutStreams(IList<System.IO.Stream> strm, int ctrl) {
			throw new NotImplementedException();
		}
		public virtual async void PutStreams(IList<System.IO.Stream> strm, int ctrl, BAsyncResult<Object> asyncResult) {
			Object __byps__ret = default(Object);
			Exception __byps__ex = null;
			bool __byps__callAsync = false;
			try {
				PutStreams(strm, ctrl);
			}
			catch (NotImplementedException) { __byps__callAsync = true; }
			catch (Exception e) { __byps__ex = e; }
			if (__byps__callAsync) try {
				await PutStreamsAsync(strm, ctrl);
			}
			catch (NotImplementedException) { __byps__ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { __byps__ex = e; }
			asyncResult(__byps__ret, __byps__ex);
		}
		public virtual Task PutStreamsAsync(IList<System.IO.Stream> strm, int ctrl){
			return BTaskConstants<Object>.NotImplemented;
		}
		
		public virtual ChatStructure SendChat(ChatStructure cs) {
			throw new NotImplementedException();
		}
		public virtual async void SendChat(ChatStructure cs, BAsyncResult<ChatStructure> asyncResult) {
			ChatStructure __byps__ret = default(ChatStructure);
			Exception __byps__ex = null;
			bool __byps__callAsync = false;
			try {
				__byps__ret = SendChat(cs);
			}
			catch (NotImplementedException) { __byps__callAsync = true; }
			catch (Exception e) { __byps__ex = e; }
			if (__byps__callAsync) try {
				__byps__ret = await SendChatAsync(cs);
			}
			catch (NotImplementedException) { __byps__ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { __byps__ex = e; }
			asyncResult(__byps__ret, __byps__ex);
		}
		public virtual Task<ChatStructure> SendChatAsync(ChatStructure cs){
			return BTaskConstants<ChatStructure>.NotImplemented;
		}
		
		
	}
}
