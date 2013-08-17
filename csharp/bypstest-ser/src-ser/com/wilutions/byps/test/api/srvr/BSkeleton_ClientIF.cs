using System;
using System.Collections.Generic;
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
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_IncrementInt(int a, BAsyncResult<int> asyncResult) {
			try {
				int ret = IncrementInt(a);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0, e);
			}
		}
		public IAsyncResult BeginIncrementInt(int a, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public int EndIncrementInt(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual IList<System.IO.Stream> GetStreams(int ctrl) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetStreams(int ctrl, BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			try {
				IList<System.IO.Stream> ret = GetStreams(ctrl);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetStreams(int ctrl, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public IList<System.IO.Stream> EndGetStreams(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void PutStreams(IList<System.IO.Stream> strm, int ctrl) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_PutStreams(IList<System.IO.Stream> strm, int ctrl, BAsyncResult<Object> asyncResult) {
			try {
				PutStreams(strm, ctrl);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginPutStreams(IList<System.IO.Stream> strm, int ctrl, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndPutStreams(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual ChatStructure SendChat(ChatStructure cs) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SendChat(ChatStructure cs, BAsyncResult<ChatStructure> asyncResult) {
			try {
				ChatStructure ret = SendChat(cs);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSendChat(ChatStructure cs, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public ChatStructure EndSendChat(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		
	}
}
