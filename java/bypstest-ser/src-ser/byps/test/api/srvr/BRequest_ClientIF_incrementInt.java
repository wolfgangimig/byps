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
public final class BRequest_ClientIF_incrementInt extends BMethodRequest implements Serializable {

	public int a;
	
	public final static long serialVersionUID = 1685952420L;
	
	public int getRemoteId() { return 2049072174; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final ClientIFAsync __byps__remoteT = (ClientIFAsync)__byps__remote;			
			BAsyncResultSendMethod<Integer> __byps__outerResult = new BAsyncResultSendMethod<Integer>(__byps__asyncResult, new byps.test.api.BResult_5());			
			__byps__remoteT.incrementInt(a, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[ClientIF.incrementInt(");
		s.append(a);
		s.append(")]");
		return s.toString();
	}
	
}
