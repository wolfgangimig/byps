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
public final class BRequest_RemoteServerCtrl_removePublishedRemote extends BMethodRequest implements Serializable {

	public java.lang.String name;
	
	public final static long serialVersionUID = 135366859L;
	
	public int getRemoteId() { return 1652234479; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteServerCtrlAsync __byps__remoteT = (RemoteServerCtrlAsync)__byps__remote;			
			BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());			
			__byps__remoteT.removePublishedRemote(name, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteServerCtrl.removePublishedRemote(");
		s.append(name);
		s.append(")]");
		return s.toString();
	}
	
}
