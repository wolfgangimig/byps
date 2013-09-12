using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This interface is an example for using the authentication mechanism.
	/// </summary>
	public interface RemoteWithAuthentication : BRemote
	{
		/// <summary>
		/// Set authentication flag in MySession.
		/// </summary>
		void SetUseAuthentication(bool useAuth);
		void SetUseAuthenticationAsync(bool useAuth, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetUseAuthentication(bool useAuth, AsyncCallback callback, object state);
		Object EndSetUseAuthentication(IAsyncResult asyncResult);
		
		/// <summary>
		/// Login.
		/// </summary>
		/// <remarks>
		/// Only user "Fritz" is allowed to login.
		/// </remarks>
		com.wilutions.byps.test.api.auth.SessionInfo Login(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd);
		void LoginAsync(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd, BAsyncResult<com.wilutions.byps.test.api.auth.SessionInfo> asyncResult) ;
		IAsyncResult BeginLogin(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd, AsyncCallback callback, object state);
		com.wilutions.byps.test.api.auth.SessionInfo EndLogin(IAsyncResult asyncResult);
		
		/// <summary>
		/// Do something.
		/// </summary>
		int Doit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value);
		void DoitAsync(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value, BAsyncResult<int> asyncResult) ;
		IAsyncResult BeginDoit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value, AsyncCallback callback, object state);
		int EndDoit(IAsyncResult asyncResult);
		
		/// <summary>
		/// Logout
		/// </summary>
		void Expire(com.wilutions.byps.test.api.auth.SessionInfo sess);
		void ExpireAsync(com.wilutions.byps.test.api.auth.SessionInfo sess, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginExpire(com.wilutions.byps.test.api.auth.SessionInfo sess, AsyncCallback callback, object state);
		Object EndExpire(IAsyncResult asyncResult);
		
		/// <summary>
		/// Set the number of login calls nessesary to login the user.
		/// </summary>
		/// <remarks>
		/// This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
		/// </remarks>
		void SetReloginCount(int count);
		void SetReloginCountAsync(int count, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetReloginCount(int count, AsyncCallback callback, object state);
		Object EndSetReloginCount(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
