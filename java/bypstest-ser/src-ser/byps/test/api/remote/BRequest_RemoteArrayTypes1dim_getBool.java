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
public final class BRequest_RemoteArrayTypes1dim_getBool extends BMethodRequest implements Serializable {

	
	public final static long serialVersionUID = 2033416644L;
	
	public int getRemoteId() { return 963816328; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes1dimAsync __byps__remoteT = (RemoteArrayTypes1dimAsync)__byps__remote;			
			BAsyncResultSendMethod<boolean[]> __byps__outerResult = new BAsyncResultSendMethod<boolean[]>(__byps__asyncResult, new byps.test.api.BResult_2058423690());			
			__byps__remoteT.getBool(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
