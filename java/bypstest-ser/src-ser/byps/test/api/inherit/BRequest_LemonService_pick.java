package byps.test.api.inherit;

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
public final class BRequest_LemonService_pick extends BMethodRequest implements Serializable {

	public byps.test.api.auth.SessionInfo sess;
	public java.lang.String fromTree;
	
	public final static long serialVersionUID = 1022088379L;
	
	public int getRemoteId() { return 605543968; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final LemonServiceAsync __byps__remoteT = (LemonServiceAsync)__byps__remote;			
			BAsyncResultSendMethod<String> __byps__outerResult = new BAsyncResultSendMethod<String>(__byps__asyncResult, new byps.test.api.BResult_10());			
			__byps__remoteT.pick(sess, fromTree, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[LemonService.pick(");
		s.append(BBuffer.paramToString(sess));
		s.append(",").append(BBuffer.paramToString(fromTree));
		s.append(")]");
		return s.toString();
	}
	
}
