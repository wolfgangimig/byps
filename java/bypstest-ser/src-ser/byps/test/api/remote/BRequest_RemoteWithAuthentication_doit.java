package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteWithAuthentication_doit extends BMethodRequest implements Serializable {

	public byps.test.api.auth.SessionInfo sess;
	public int value;
	
	public final static long serialVersionUID = 1251509013L;
	
	public int getRemoteId() { return 1983670399; }
	
	// checkpoint byps.gen.j.GenApiClass:627
	public void setSession(Object __byps__sess) {
		sess = (byps.test.api.auth.SessionInfo)__byps__sess;
	}
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteWithAuthenticationAsync __byps__remoteT = (RemoteWithAuthenticationAsync)__byps__remote;			
			BAsyncResultSendMethod<Integer> __byps__outerResult = new BAsyncResultSendMethod<Integer>(__byps__asyncResult, new byps.test.api.BResult_5());			
			__byps__remoteT.doit(sess, value, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteWithAuthentication.doit(");
		s.append(BBuffer.paramToString(sess));
		s.append(",").append(BBuffer.paramToString(value));
		s.append(")]");
		return s.toString();
	}
	
}
