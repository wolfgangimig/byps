package byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_ServerIF_callClientParallel extends BMethodRequest implements Serializable {

	public int v;
	
	public final static long serialVersionUID = 772308436L;
	
	public int getRemoteId() { return 1775199834; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final ServerIFAsync __byps__remoteT = (ServerIFAsync)__byps__remote;			
			BAsyncResultSendMethod<Integer> __byps__outerResult = new BAsyncResultSendMethod<Integer>(__byps__asyncResult, new byps.test.api.BResult_5());			
			__byps__remoteT.callClientParallel(v, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[ServerIF.callClientParallel(");
		s.append(BBuffer.paramToString(v));
		s.append(")]");
		return s.toString();
	}
	
}
