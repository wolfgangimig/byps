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
public final class BRequest_RemoteSetTypes_getByte1 extends BMethodRequest implements Serializable {

	
	public final static long serialVersionUID = 901695825L;
	
	public int getRemoteId() { return 1900796440; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteSetTypesAsync __byps__remoteT = (RemoteSetTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<java.util.HashSet<java.lang.Byte>> __byps__outerResult = new BAsyncResultSendMethod<java.util.HashSet<java.lang.Byte>>(__byps__asyncResult, new byps.test.api.BResult_31512998());			
			__byps__remoteT.getByte1(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
