package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import byps.*;
import java.io.Serializable;
import java.util.Map;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteMapTypes_setByte2 extends BMethodRequest implements Serializable {

	public java.util.Map<java.lang.Integer,byte[]> byte2;
	
	public final static long serialVersionUID = 685835106L;
	
	public int getRemoteId() { return 664304990; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync __byps__remoteT = (RemoteMapTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());			
			__byps__remoteT.setByte2(byte2, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteMapTypes.setByte2(");
		s.append(BBuffer.paramToString(byte2));
		s.append(")]");
		return s.toString();
	}
	
}
