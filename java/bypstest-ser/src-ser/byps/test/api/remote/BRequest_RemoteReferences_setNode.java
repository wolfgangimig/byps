package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import byps.*;
import java.io.Serializable;
import byps.test.api.refs.Node;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteReferences_setNode extends BMethodRequest implements Serializable {

	public byps.test.api.refs.Node v;
	
	public final static long serialVersionUID = 693117721L;
	
	public int getRemoteId() { return 568637225; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteReferencesAsync __byps__remoteT = (RemoteReferencesAsync)__byps__remote;			
			BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());			
			__byps__remoteT.setNode(v, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteReferences.setNode(");
		s.append(BBuffer.paramToString(v));
		s.append(")]");
		return s.toString();
	}
	
}
