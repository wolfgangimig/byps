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
public final class BRequest_RemoteSetTypes_getChar1 extends BMethodRequest implements Serializable {

	
	public final static long serialVersionUID = 901296607L;
	
	public int getRemoteId() { return 1900796440; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteSetTypesAsync __byps__remoteT = (RemoteSetTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<java.util.TreeSet<java.lang.Character>> __byps__outerResult = new BAsyncResultSendMethod<java.util.TreeSet<java.lang.Character>>(__byps__asyncResult, new byps.test.api.BResult_936607009());			
			__byps__remoteT.getChar1(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteSetTypes.getChar1(");
		s.append(")]");
		return s.toString();
	}
	
}
