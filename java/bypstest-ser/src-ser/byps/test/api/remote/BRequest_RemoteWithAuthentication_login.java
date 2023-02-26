package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import byps.*;
import java.io.Serializable;
import byps.test.api.auth.SessionInfo;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteWithAuthentication_login extends BMethodRequest implements Serializable {

	public byps.test.api.auth.SessionInfo sess;
	public java.lang.String userName;
	public java.lang.String userPwd;
	
	public final static long serialVersionUID = 134687724L;
	
	public int getRemoteId() { return 1983670399; }
	
	// checkpoint byps.gen.j.GenApiClass:633
	public void setSession(Object __byps__sess) {
		sess = (byps.test.api.auth.SessionInfo)__byps__sess;
	}
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteWithAuthenticationAsync __byps__remoteT = (RemoteWithAuthenticationAsync)__byps__remote;			
			BAsyncResultSendMethod<byps.test.api.auth.SessionInfo> __byps__outerResult = new BAsyncResultSendMethod<byps.test.api.auth.SessionInfo>(__byps__asyncResult, new byps.test.api.BResult_65775978());			
			__byps__remoteT.login(sess, userName, userPwd, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteWithAuthentication.login(");
		s.append(BBuffer.paramToString(sess));
		s.append(",").append(BBuffer.paramToString(userName));
		s.append(",").append(BBuffer.paramToString(userPwd));
		s.append(")]");
		return s.toString();
	}
	
}
