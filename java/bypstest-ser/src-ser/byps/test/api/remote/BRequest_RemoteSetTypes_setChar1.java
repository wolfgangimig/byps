package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import byps.*;
import java.io.Serializable;
import java.util.TreeSet;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteSetTypes_setChar1 extends BMethodRequest implements Serializable {

	public java.util.TreeSet<java.lang.Character> char1;
	
	public final static long serialVersionUID = 1462409067L;
	
	public int getRemoteId() { return 1900796440; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteSetTypesAsync __byps__remoteT = (RemoteSetTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());			
			__byps__remoteT.setChar1(char1, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteSetTypes.setChar1(");
		s.append(BBuffer.paramToString(char1));
		s.append(")]");
		return s.toString();
	}
	
}
