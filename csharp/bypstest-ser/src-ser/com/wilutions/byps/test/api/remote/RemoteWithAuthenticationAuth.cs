using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This interface is an example for using the authentication mechanism.
	/// </summary>
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:81
	public interface RemoteWithAuthenticationAuth : BRemote {
	
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
		com.wilutions.byps.test.api.auth.SessionInfo Login(String userName, String userPwd);
		void LoginAsync(String userName, String userPwd, BAsyncResult<com.wilutions.byps.test.api.auth.SessionInfo> asyncResult) ;
		IAsyncResult BeginLogin(String userName, String userPwd, AsyncCallback callback, object state);
		com.wilutions.byps.test.api.auth.SessionInfo EndLogin(IAsyncResult asyncResult);
		
		/// <summary>
		/// Do something.
		/// </summary>
		int Doit(int @value);
		void DoitAsync(int @value, BAsyncResult<int> asyncResult) ;
		IAsyncResult BeginDoit(int @value, AsyncCallback callback, object state);
		int EndDoit(IAsyncResult asyncResult);
		
		/// <summary>
		/// Logout
		/// </summary>
		void Expire();
		void ExpireAsync(BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginExpire(AsyncCallback callback, object state);
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
