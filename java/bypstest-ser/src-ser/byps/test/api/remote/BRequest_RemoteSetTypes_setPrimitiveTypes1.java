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
public final class BRequest_RemoteSetTypes_setPrimitiveTypes1 extends BMethodRequest implements Serializable {

	public java.util.Set<byps.test.api.prim.PrimitiveTypes> primitiveTypes1;
	
	public final static long serialVersionUID = 250758937L;
	
	public int getRemoteId() { return 1900796440; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteSetTypesAsync __byps__remoteT = (RemoteSetTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());			
			__byps__remoteT.setPrimitiveTypes1(primitiveTypes1, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteSetTypes.setPrimitiveTypes1(");
		s.append(BBuffer.paramToString(primitiveTypes1));
		s.append(")]");
		return s.toString();
	}
	
}
