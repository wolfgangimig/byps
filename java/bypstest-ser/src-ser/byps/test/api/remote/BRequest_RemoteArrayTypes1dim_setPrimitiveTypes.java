package byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import byps.*;
import java.io.Serializable;
import byps.test.api.prim.PrimitiveTypes;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteArrayTypes1dim_setPrimitiveTypes extends BMethodRequest implements Serializable {

	public byps.test.api.prim.PrimitiveTypes[] v;
	
	public final static long serialVersionUID = 1362276920L;
	
	public int getRemoteId() { return 123123; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes1dimAsync __byps__remoteT = (RemoteArrayTypes1dimAsync)__byps__remote;			
			BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new byps.test.api.BResult_19());			
			__byps__remoteT.setPrimitiveTypes(v, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
		}
	}	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[RemoteArrayTypes1dim.setPrimitiveTypes(");
		s.append(BBuffer.paramToString(v));
		s.append(")]");
		return s.toString();
	}
	
}
