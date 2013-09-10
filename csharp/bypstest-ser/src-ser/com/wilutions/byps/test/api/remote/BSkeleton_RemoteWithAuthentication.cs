using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteWithAuthentication.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteWithAuthentication : BSkeleton, RemoteWithAuthentication {	
		
		public readonly static long serialVersionUID = 1677934392L;
		
		public virtual void SetUseAuthentication(bool useAuth) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetUseAuthentication(bool useAuth, BAsyncResult<Object> asyncResult) {
			try {
				SetUseAuthentication(useAuth);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetUseAuthentication(bool useAuth, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetUseAuthentication(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual com.wilutions.byps.test.api.auth.SessionInfo Login(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_Login(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd, BAsyncResult<com.wilutions.byps.test.api.auth.SessionInfo> asyncResult) {
			try {
				com.wilutions.byps.test.api.auth.SessionInfo ret = Login(sess, userName, userPwd);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginLogin(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.auth.SessionInfo EndLogin(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual int Doit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_Doit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value, BAsyncResult<int> asyncResult) {
			try {
				int ret = Doit(sess, @value);
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0, e);
			}
		}
		public IAsyncResult BeginDoit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public int EndDoit(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void Expire(com.wilutions.byps.test.api.auth.SessionInfo sess) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_Expire(com.wilutions.byps.test.api.auth.SessionInfo sess, BAsyncResult<Object> asyncResult) {
			try {
				Expire(sess);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginExpire(com.wilutions.byps.test.api.auth.SessionInfo sess, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndExpire(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		public virtual void SetReloginCount(int count) {
			throw new BException(BExceptionC.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetReloginCount(int count, BAsyncResult<Object> asyncResult) {
			try {
				SetReloginCount(count);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetReloginCount(int count, AsyncCallback callback, object state) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		public Object EndSetReloginCount(IAsyncResult asyncResult) {
			throw new BException(BExceptionC.INTERNAL, "");
		}
		
		
	}
}
