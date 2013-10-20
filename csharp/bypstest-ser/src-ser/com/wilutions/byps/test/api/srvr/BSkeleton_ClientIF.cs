using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
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
		
		public readonly static long serialVersionUID = 1784257353L;
		
		public virtual int IncrementInt(int a) {
			throw new NotImplementedException();
		}
		public virtual async void IncrementInt(int a, BAsyncResult<int> asyncResult) {
			int ret = default(int);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = IncrementInt(a);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await IncrementIntAsync(a);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task<int> IncrementIntAsync(int a){
			return BTaskConstants<int>.NotImplemented;
		}
		
		public virtual IList<System.IO.Stream> GetStreams(int ctrl) {
			throw new NotImplementedException();
		}
		public virtual async void GetStreams(int ctrl, BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			IList<System.IO.Stream> ret = default(IList<System.IO.Stream>);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = GetStreams(ctrl);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await GetStreamsAsync(ctrl);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task<IList<System.IO.Stream>> GetStreamsAsync(int ctrl){
			return BTaskConstants<IList<System.IO.Stream>>.NotImplemented;
		}
		
		public virtual void PutStreams(IList<System.IO.Stream> strm, int ctrl) {
			throw new NotImplementedException();
		}
		public virtual async void PutStreams(IList<System.IO.Stream> strm, int ctrl, BAsyncResult<Object> asyncResult) {
			Object ret = default(Object);
			Exception ex = null;
			bool callAsync = false;
			try {
				PutStreams(strm, ctrl);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				await PutStreamsAsync(strm, ctrl);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task PutStreamsAsync(IList<System.IO.Stream> strm, int ctrl){
			return BTaskConstants<Object>.NotImplemented;
		}
		
		public virtual ChatStructure SendChat(ChatStructure cs) {
			throw new NotImplementedException();
		}
		public virtual async void SendChat(ChatStructure cs, BAsyncResult<ChatStructure> asyncResult) {
			ChatStructure ret = default(ChatStructure);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = SendChat(cs);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await SendChatAsync(cs);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		public virtual Task<ChatStructure> SendChatAsync(ChatStructure cs){
			return BTaskConstants<ChatStructure>.NotImplemented;
		}
		
		
	}
}
