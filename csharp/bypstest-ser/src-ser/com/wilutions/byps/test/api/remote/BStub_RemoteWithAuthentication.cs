using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteWithAuthentication : BStub, RemoteWithAuthentication, BSerializable {	
		
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
		
		public com.wilutions.byps.test.api.auth.SessionInfo Login(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd) {
			BSyncResult<com.wilutions.byps.test.api.auth.SessionInfo> asyncResult = new BSyncResult<com.wilutions.byps.test.api.auth.SessionInfo>();			
			async_Login(sess, userName, userPwd, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_Login(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd, BAsyncResult<com.wilutions.byps.test.api.auth.SessionInfo> asyncResult) {
			BRequest_RemoteWithAuthentication_login req = new BRequest_RemoteWithAuthentication_login();			
			req._sess = sess;
			req._userName = userName;
			req._userPwd = userPwd;
			BAsyncResultReceiveMethod<com.wilutions.byps.test.api.auth.SessionInfo> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.auth.SessionInfo>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginLogin(com.wilutions.byps.test.api.auth.SessionInfo sess, String userName, String userPwd, AsyncCallback callback, object state){
			BAsyncProgModel<com.wilutions.byps.test.api.auth.SessionInfo> _byps_ret = new BAsyncProgModel<com.wilutions.byps.test.api.auth.SessionInfo>(callback, state);
			async_Login(sess, userName, userPwd, _byps_ret);
			return _byps_ret;
		}
		public 		com.wilutions.byps.test.api.auth.SessionInfo EndLogin(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<com.wilutions.byps.test.api.auth.SessionInfo>)asyncResult).Result;
		}
		
		public int Doit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value) {
			BSyncResult<int> asyncResult = new BSyncResult<int>();			
			async_Doit(sess, @value, asyncResult);
			return asyncResult.GetResult();			
		}
		public void async_Doit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value, BAsyncResult<int> asyncResult) {
			BRequest_RemoteWithAuthentication_doit req = new BRequest_RemoteWithAuthentication_doit();			
			req._sess = sess;
			req._value = @value;
			BAsyncResultReceiveMethod<int> outerResult = new BAsyncResultReceiveMethod<int>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginDoit(com.wilutions.byps.test.api.auth.SessionInfo sess, int @value, AsyncCallback callback, object state){
			BAsyncProgModel<int> _byps_ret = new BAsyncProgModel<int>(callback, state);
			async_Doit(sess, @value, _byps_ret);
			return _byps_ret;
		}
		public 		int EndDoit(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<int>)asyncResult).Result;
		}
		
		public void Expire(com.wilutions.byps.test.api.auth.SessionInfo sess) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			async_Expire(sess, asyncResult);
			asyncResult.GetResult();			
		}
		public void async_Expire(com.wilutions.byps.test.api.auth.SessionInfo sess, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteWithAuthentication_expire req = new BRequest_RemoteWithAuthentication_expire();			
			req._sess = sess;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginExpire(com.wilutions.byps.test.api.auth.SessionInfo sess, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			async_Expire(sess, _byps_ret);
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
