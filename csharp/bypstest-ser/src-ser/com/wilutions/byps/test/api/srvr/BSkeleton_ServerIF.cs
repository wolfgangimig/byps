using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface ServerIF.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_ServerIF : BSkeleton, ServerIF {	
		
		public readonly static long serialVersionUID = 1313562065L;
		
		public virtual int CallClientIncrementInt(int v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_CallClientIncrementInt(int v, BAsyncResult<int> asyncResult) {
			try {
				int ret = CallClientIncrementInt(v);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0, e);
			}
		}
		public IAsyncResult BeginCallClientIncrementInt(int v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public int EndCallClientIncrementInt(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetPartner(ClientIF client) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPartner(ClientIF client, BAsyncResult<Object> asyncResult) {
			try {
				SetPartner(client);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPartner(ClientIF client, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetPartner(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ClientIF GetPartner() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPartner(BAsyncResult<ClientIF> asyncResult) {
			try {
				ClientIF ret = GetPartner();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPartner(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ClientIF EndGetPartner(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual IList<System.IO.Stream> GetStreamsFromClient() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetStreamsFromClient(BAsyncResult<IList<System.IO.Stream>> asyncResult) {
			try {
				IList<System.IO.Stream> ret = GetStreamsFromClient();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetStreamsFromClient(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public IList<System.IO.Stream> EndGetStreamsFromClient(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void PutStreamsOnClient(IList<System.IO.Stream> streams) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_PutStreamsOnClient(IList<System.IO.Stream> streams, BAsyncResult<Object> asyncResult) {
			try {
				PutStreamsOnClient(streams);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginPutStreamsOnClient(IList<System.IO.Stream> streams, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndPutStreamsOnClient(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void RegisterWithClientMap(int id) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_RegisterWithClientMap(int id, BAsyncResult<Object> asyncResult) {
			try {
				RegisterWithClientMap(id);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginRegisterWithClientMap(int id, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndRegisterWithClientMap(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ClientIF GetClient(int id) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetClient(int id, BAsyncResult<ClientIF> asyncResult) {
			try {
				ClientIF ret = GetClient(id);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetClient(int id, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ClientIF EndGetClient(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual ISet<int> GetClientIds() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetClientIds(BAsyncResult<ISet<int>> asyncResult) {
			try {
				ISet<int> ret = GetClientIds();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetClientIds(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public ISet<int> EndGetClientIds(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual int CallClientParallel(int v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_CallClientParallel(int v, BAsyncResult<int> asyncResult) {
			try {
				int ret = CallClientParallel(v);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0, e);
			}
		}
		public IAsyncResult BeginCallClientParallel(int v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public int EndCallClientParallel(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
