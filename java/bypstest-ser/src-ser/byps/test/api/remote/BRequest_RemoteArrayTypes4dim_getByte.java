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
public final class BRequest_RemoteArrayTypes4dim_getByte extends BMethodRequest implements Serializable {

	
	public final static long serialVersionUID = 1874292737L;
	
	public int getRemoteId() { return 963726955; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes4dimAsync __byps__remoteT = (RemoteArrayTypes4dimAsync)__byps__remote;			
			BAsyncResultSendMethod<byte[][][][]> __byps__outerResult = new BAsyncResultSendMethod<byte[][][][]>(__byps__asyncResult, new byps.test.api.BResult_1201775504());			
			__byps__remoteT.getByte(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteArrayTypes4dim.getByte(");
		s.append(")]");
		return s.toString();
	}
	
}
