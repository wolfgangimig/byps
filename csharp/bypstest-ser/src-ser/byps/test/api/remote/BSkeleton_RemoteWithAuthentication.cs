using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
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
		
		public readonly static long serialVersionUID = 1983670399L;
		
		public virtual void SetUseAuthentication(bool useAuth) {
			throw new NotImplementedException();
		}
		public virtual async void SetUseAuthentication(bool useAuth, BAsyncResult<Object> asyncResult) {
			Object ret = default(Object);
			Exception ex = null;
			bool callAsync = false;
			try {
				SetUseAuthentication(useAuth);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				await SetUseAuthenticationAsync(useAuth);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		/// <summary>
		/// Set authentication flag in MySession.
		/// </summary>
		public virtual Task SetUseAuthenticationAsync(bool useAuth){
			return BTaskConstants<Object>.NotImplemented;
		}
		
		public virtual byps.test.api.auth.SessionInfo Login(byps.test.api.auth.SessionInfo sess, String userName, String userPwd) {
			throw new NotImplementedException();
		}
		public virtual async void Login(byps.test.api.auth.SessionInfo sess, String userName, String userPwd, BAsyncResult<byps.test.api.auth.SessionInfo> asyncResult) {
			byps.test.api.auth.SessionInfo ret = default(byps.test.api.auth.SessionInfo);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = Login(sess, userName, userPwd);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await LoginAsync(sess, userName, userPwd);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		/// <summary>
		/// Login.
		/// </summary>
		/// <remarks>
		/// Only user "Fritz" is allowed to login.
		/// </remarks>
		public virtual Task<byps.test.api.auth.SessionInfo> LoginAsync(byps.test.api.auth.SessionInfo sess, String userName, String userPwd){
			return BTaskConstants<byps.test.api.auth.SessionInfo>.NotImplemented;
		}
		
		public virtual int Doit(byps.test.api.auth.SessionInfo sess, int value) {
			throw new NotImplementedException();
		}
		public virtual async void Doit(byps.test.api.auth.SessionInfo sess, int value, BAsyncResult<int> asyncResult) {
			int ret = default(int);
			Exception ex = null;
			bool callAsync = false;
			try {
				ret = Doit(sess, value);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				ret = await DoitAsync(sess, value);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		/// <summary>
		/// Do something.
		/// </summary>
		public virtual Task<int> DoitAsync(byps.test.api.auth.SessionInfo sess, int value){
			return BTaskConstants<int>.NotImplemented;
		}
		
		public virtual void Expire(byps.test.api.auth.SessionInfo sess) {
			throw new NotImplementedException();
		}
		public virtual async void Expire(byps.test.api.auth.SessionInfo sess, BAsyncResult<Object> asyncResult) {
			Object ret = default(Object);
			Exception ex = null;
			bool callAsync = false;
			try {
				Expire(sess);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				await ExpireAsync(sess);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		/// <summary>
		/// Logout
		/// </summary>
		public virtual Task ExpireAsync(byps.test.api.auth.SessionInfo sess){
			return BTaskConstants<Object>.NotImplemented;
		}
		
		public virtual void SetReloginCount(int count) {
			throw new NotImplementedException();
		}
		public virtual async void SetReloginCount(int count, BAsyncResult<Object> asyncResult) {
			Object ret = default(Object);
			Exception ex = null;
			bool callAsync = false;
			try {
				SetReloginCount(count);
			}
			catch (NotImplementedException) { callAsync = true; }
			catch (Exception e) { ex = e; }
			if (callAsync) try {
				await SetReloginCountAsync(count);
			}
			catch (NotImplementedException) { ex = new BException(BExceptionC.UNSUPPORTED_METHOD, ""); }
			catch (Exception e) { ex = e; }
			asyncResult(ret, ex);
		}
		/// <summary>
		/// Set the number of login calls nessesary to login the user.
		/// </summary>
		/// <remarks>
		/// This function is used to check that parameter reloginCount in BAuthentication.isReloginException is supplied correctly.
		/// </remarks>
		public virtual Task SetReloginCountAsync(int count){
			return BTaskConstants<Object>.NotImplemented;
		}
		
		
	}
}
