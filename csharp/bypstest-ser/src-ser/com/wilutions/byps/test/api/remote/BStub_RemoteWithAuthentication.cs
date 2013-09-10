using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteWithAuthentication : BStub, RemoteWithAuthenticationAuth, BSerializable {	
		
		public readonly static long serialVersionUID = 1677934392L;
		
		public BStub_RemoteWithAuthentication(BTransport transport)
			: base(transport) {}			
		
		public void SetUseAuthentication(bool useAuth) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetUseAuthentication(useAuth, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetUseAuthentication(bool useAuth, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteWithAuthentication_setUseAuthentication req = new BRequest_RemoteWithAuthentication_setUseAuthentication();			
			req._useAuth = useAuth;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetUseAuthentication(bool useAuth, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetUseAuthentication(useAuth, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetUseAuthentication(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public com.wilutions.byps.test.api.auth.SessionInfo Login(String userName, String userPwd) {
			BSyncResult<com.wilutions.byps.test.api.auth.SessionInfo> asyncResult = new BSyncResult<com.wilutions.byps.test.api.auth.SessionInfo>();			
			async_Login(userName, userPwd, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_Login(String userName, String userPwd, BAsyncResult<com.wilutions.byps.test.api.auth.SessionInfo> asyncResult) {
			BRequest_RemoteWithAuthentication_login req = new BRequest_RemoteWithAuthentication_login();			
			req._userName = userName;
			req._userPwd = userPwd;
			BAsyncResultReceiveMethod<com.wilutions.byps.test.api.auth.SessionInfo> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.auth.SessionInfo>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginLogin(String userName, String userPwd, AsyncCallback callback, object state){
			BAsyncProgModel<com.wilutions.byps.test.api.auth.SessionInfo> _byps_ret = new BAsyncProgModel<com.wilutions.byps.test.api.auth.SessionInfo>(callback, state);
			async_Login(userName, userPwd, _byps_ret);
			return _byps_ret;
		}
		public 		com.wilutions.byps.test.api.auth.SessionInfo EndLogin(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<com.wilutions.byps.test.api.auth.SessionInfo>)asyncResult).Result;
		}
		
		public int Doit(int @value) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			async_Doit(@value, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_Doit(int @value, BAsyncResult<int> asyncResult) {
			BRequest_RemoteWithAuthentication_doit req = new BRequest_RemoteWithAuthentication_doit();			
			req._value = @value;
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginDoit(int @value, AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			async_Doit(@value, _byps_ret);
			return _byps_ret;
		}
		public 		int EndDoit(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		
		public void Expire() {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_Expire(asyncResult);
			asyncResult.GetResult();			
		}
		public void async_Expire(BAsyncResult<Object> asyncResult) {
			BRequest_RemoteWithAuthentication_expire req = new BRequest_RemoteWithAuthentication_expire();			
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginExpire(AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_Expire(_byps_ret);
			return _byps_ret;
		}
		public 		Object EndExpire(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		public void SetReloginCount(int count) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_SetReloginCount(count, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_SetReloginCount(int count, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteWithAuthentication_setReloginCount req = new BRequest_RemoteWithAuthentication_setReloginCount();			
			req._count = count;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetReloginCount(int count, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_SetReloginCount(count, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetReloginCount(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		
	}
}
