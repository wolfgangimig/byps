using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	/// <summary>
	/// This interface is an example for using the authentication mechanism.
	/// </summary>
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteWithAuthenticationAuth : BRemote {
	
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
		byps.test.api.auth.SessionInfo Login(String userName, String userPwd);
		void Login(String userName, String userPwd, BAsyncResult<byps.test.api.auth.SessionInfo> asyncResult) ;
		/// <summary>
		/// Login.
		/// </summary>
		/// <remarks>
		/// Only user "Fritz" is allowed to login.
		/// </remarks>
		Task<byps.test.api.auth.SessionInfo> LoginAsync(String userName, String userPwd);
		
		/// <summary>
		/// Do something.
		/// </summary>
		int Doit(int value);
		void Doit(int value, BAsyncResult<int> asyncResult) ;
		/// <summary>
		/// Do something.
		/// </summary>
		Task<int> DoitAsync(int value);
		
		/// <summary>
		/// Logout
		/// </summary>
		void Expire();
		void Expire(BAsyncResult<Object> asyncResult) ;
		/// <summary>
		/// Logout
		/// </summary>
		Task ExpireAsync();
		
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
