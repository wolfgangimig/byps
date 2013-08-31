using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteServerCtrl.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteServerCtrl : BSkeleton, RemoteServerCtrl {	
		
		public readonly static long serialVersionUID = 1124545992L;
		
		public virtual void PublishRemote(String name, BRemote remote, bool fowardToOtherServers) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_PublishRemote(String name, BRemote remote, bool fowardToOtherServers, BAsyncResult<Object> asyncResult) {
			try {
				PublishRemote(name, remote, fowardToOtherServers);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginPublishRemote(String name, BRemote remote, bool fowardToOtherServers, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndPublishRemote(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual BRemote GetPublishedRemote(String name) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPublishedRemote(String name, BAsyncResult<BRemote> asyncResult) {
			try {
				BRemote ret = GetPublishedRemote(name);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginGetPublishedRemote(String name, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public BRemote EndGetPublishedRemote(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		public virtual void RemovePublishedRemote(String name) {
			throw new BException(BExceptionO.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_RemovePublishedRemote(String name, BAsyncResult<Object> asyncResult) {
			try {
				RemovePublishedRemote(name);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginRemovePublishedRemote(String name, AsyncCallback callback, object state) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		public Object EndRemovePublishedRemote(IAsyncResult asyncResult) {
			throw new BException(BExceptionO.INTERNAL, "");
		}
		
		
	}
}
