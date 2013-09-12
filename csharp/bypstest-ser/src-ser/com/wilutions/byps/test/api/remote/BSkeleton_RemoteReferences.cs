using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteReferences.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteReferences : BSkeleton, RemoteReferences {	
		
		public readonly static long serialVersionUID = 2086824050L;
		
		public virtual com.wilutions.byps.test.api.refs.Node GetNode() {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void GetNodeAsync(BAsyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult) {
			try {
				com.wilutions.byps.test.api.refs.Node ret = GetNode();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetNode(AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.refs.Node EndGetNode(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetNode(com.wilutions.byps.test.api.refs.Node v) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void SetNodeAsync(com.wilutions.byps.test.api.refs.Node v, BAsyncResult<Object> asyncResult) {
			try {
				SetNode(v);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetNode(com.wilutions.byps.test.api.refs.Node v, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetNode(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
