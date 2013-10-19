using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This interface is an example for using the authentication mechanism.
	/// </summary>
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface RemoteWithAuthentication : BRemote {
	
		/// <summary>
		/// Set authentication flag in MySession.
		/// </summary>
		void SetUseAuthentication(bool useAuth);
		void SetUseAuthentication(bool useAuth, BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Set authentication flag in MySession.
		/// </summary>
		Task SetUseAuthenticationAsync(bool useAuth);
		
		/// <summary>
		/// Login.
		/// </summary>
		/// <remarks>
		/// Only user "Fritz" is allowed to login.
		/// </remarks>
		com.wilutions.byps.test.api.auth.SessionInfo Login(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd);
		void Login(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd, BAsyncResult<com.wilutions.byps.test.api.auth.SessionInfo> asyncResult) ;
		/// <summary>
		/// Login.
		/// </summary>
		/// <remarks>
		/// Only user "Fritz" is allowed to login.
		/// </remarks>
		Task<com.wilutions.byps.test.api.auth.SessionInfo> LoginAsync(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd);
		
		/// <summary>
		/// Do something.
		/// </summary>
		int Doit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value);
		void Doit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value, BAsyncResult<int> asyncResult) ;
		/// <summary>
		/// Do something.
		/// </summary>
		Task<int> DoitAsync(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value);
		
		/// <summary>
		/// Logout
		/// </summary>
		void Expire(com.wilutions.byps.test.api.auth.SessionInfo sess);
		void Expire(com.wilutions.byps.test.api.auth.SessionInfo sess, BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Logout
		/// </summary>
		Task ExpireAsync(com.wilutions.byps.test.api.auth.SessionInfo sess);
		
		/// <summary>
		/// Set the number of login calls nessesary to login the user.
		/// </summary>
		/// <remarks>
		/// This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
		/// </remarks>
		void SetReloginCount(int count);
		void SetReloginCount(int count, BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Set the number of login calls nessesary to login the user.
		/// </summary>
		/// <remarks>
		/// This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
		/// </remarks>
		Task SetReloginCountAsync(int count);
		
		
	}
}  // end namespace
